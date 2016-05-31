package com.athena.common.context;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

import com.athena.common.context.Constants.UserModel.LoginStatus;
import com.athena.common.dto.UserLoginValidator;
import com.athena.common.exception.BusinessException;
import com.athena.common.exception.ExceptionCode;
import com.athena.common.utils.EncryptUtils;
import com.athena.common.utils.EncryptUtils.EncryType;
import com.athena.module.menus.model.Menu;
import com.athena.module.menus.model.MenuExample;
import com.athena.module.menus.service.MenuService;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;
import com.athena.module.users.service.UserService;

/**
 * 系统安全管理器
 * @author Binxiao
 */
public class SecurityManager {

	private static Logger logger = LoggerFactory.getLogger(SecurityManager.class);

	/**
	 * 校验用户, 返回登录用户校验信息dto
	 * @param user
	 * @return Map<User, LoginStatus>
	 * @throws Exception
	 */
	public UserLoginValidator validateUser(User user) throws Exception {

		UserExample example = new UserExample();
		example.or().andUserNameEqualTo(user.getUserName());
		List<User> users = userService.selectByExample(example);

		LoginStatus status = null;

		User dbUser = null;
		if (CollectionUtils.isNotEmpty(users)) {
			dbUser = users.get(0);

			if (EncryptUtils.encrypt(user.getPassWord(), EncryType.MD5, dbUser.getPasswdSalt()).equals(dbUser.getPassWord())) {

				if (LoginStatus.ADMIN.code.equals(dbUser.getUserStatus())) {
					status = LoginStatus.ADMIN;
					logger.info("超级管理员 {}[{}] 登录", dbUser.getNickName(), dbUser.getUserName());
				}

				else if (LoginStatus.VAILD.code.equals(dbUser.getUserStatus())) {
					status = LoginStatus.VAILD;
					logger.info("用户 {}[{}] 登录系统", dbUser.getNickName(), dbUser.getUserName());

				} else if (LoginStatus.INVAILD.code.equals(dbUser.getUserStatus())) {
					status = LoginStatus.INVAILD;

				} else {
					status = LoginStatus.ERROR;
				}
			} else {
				status = LoginStatus.ERROR;
			}

		} else {
			status = LoginStatus.ERROR;
		}

		return new UserLoginValidator(dbUser, status);
	}

	/**
	 * 用户登录, 计算用户权限
	 * @param user
	 */
	public void login(User user, HttpServletRequest request) {

		// 用户状态异常
		if (user.getUserStatus() == null) {
			throw new BusinessException(ExceptionCode.UserStatusException);
		}

		Long maxPos = menuService.selectMaxPrivilegePos();

		long[] privilegeSum = new long[(int) (maxPos == null ? 1 : maxPos + 1)];

		List<Menu> menus;
		if (LoginStatus.ADMIN.code.equals(user.getUserStatus())) {
			menus = menuService.selectByExample(new MenuExample());
		}
		menus = menuService.selectUserMenus(user.getId());

		for (Menu menu : menus) {
			long pos = menu.getMenuPrivilegePos();
			long code = menu.getMenuPrivilegeCode();
			privilegeSum[(int) pos] = code | privilegeSum[(int) pos];
		}

		user.setPrivilegeSum(privilegeSum);
		request.getSession().setAttribute(DictionaryProvider.USER_SESSION_KEY, user);
	}

	/**
	 * 是否对url有权限
	 * @param uri
	 * @return
	 */
	public boolean hasPrivilege(String uri, HttpServletRequest request) {

		// 公共资源放行
		if (isPublicResource(uri))
			return true;

		User user = getLoginUser(request);

		if (user != null) {
			if (LoginStatus.ADMIN.code.equals(user.getUserStatus())) {
				return true;
			}

			if (user.getPrivilegeSum() == null) {
				return false;
			}

			if ("/".equals(uri)) {
				return true;
			}

			if (uri.equals("/manage") && CollectionUtils.isNotEmpty(menuService.selectUserMenus(user.getId()))) {
				return true;
			}

			if (uri.startsWith("/business")) {
				return true;
			}

			uri = uri.substring(1);

			Menu matcherMenu = null;
			MenuExample example = new MenuExample();
			example.or().andMenuUrlLikeInsensitive(uri + "%");
			List<Menu> menus = menuService.selectByExample(example);
			if (CollectionUtils.isNotEmpty(menus)) {
				matcherMenu = menus.get(0);
			}

			if (matcherMenu == null) {
				return true;
			}

			return (user.getPrivilegeSum()[matcherMenu.getMenuPrivilegePos().intValue()] & matcherMenu.getMenuPrivilegeCode()) != 0;
		}

		return false;
	}

	/**
	 * 获取当前登录用户
	 * @return
	 */
	public User getLoginUser(HttpServletRequest request) {
		Object user = request.getSession().getAttribute(DictionaryProvider.USER_SESSION_KEY);
		return user == null ? null : (User) user;
	}

	/**
	 * 用户注销
	 */
	public void logout(HttpServletRequest request) {
		request.getSession().invalidate();
	}

	/**
	 * 检测是否是超级管理员
	 * @param user
	 * @return
	 */
	public boolean isAdmin(User user) {
		return LoginStatus.ADMIN.code.equals(user.getUserStatus());
	}

	/**
	 * 查询用户的所有菜单结构
	 * @param userId
	 * @return
	 */
	public Map<String, List<Menu>> selectUserMenusMap(HttpServletRequest request) {

		Map<String, List<Menu>> menus = new LinkedHashMap<String, List<Menu>>();

		MenuExample example = new MenuExample();
		example.or().andMenuParentIdEqualTo(BigDecimal.ZERO);
		example.setOrderByClause("MENU_SORT_NO");
		List<Menu> firstMenus = menuService.selectByExample(example);

		User user = getLoginUser(request);

		List<Menu> userMenus;

		if (isAdmin(user)) {
			example = new MenuExample();
			example.setOrderByClause("MENU_SORT_NO");
			userMenus = menuService.selectByExample(example);

		} else {
			userMenus = menuService.selectUserMenus(user.getId());
		}

		for (Menu firstMenu : firstMenus) {
			List<Menu> secondMenus = new ArrayList<Menu>();

			for (Menu secondmenu : userMenus) {
				if (secondmenu.getMenuParentId().compareTo(firstMenu.getId()) == 0) {
					secondMenus.add(secondmenu);
				}
			}

			if (secondMenus.size() != 0) {
				menus.put(firstMenu.getMenuName(), secondMenus);
			}
		}

		return menus;
	}

	// 检测是否是公共资源
	private boolean isPublicResource(String uri) {

		if (CollectionUtils.isEmpty(publicUrls)) {
			throw new BusinessException(ExceptionCode.IllegalParamException, "权限过滤应至少包含一个公共资源");
		}

		for (String publicUrl : publicUrls) {
			if (antPathMatcher.match(publicUrl + "/**", uri)) {
				return true;
			}
		}

		return false;
	}

	private AntPathMatcher antPathMatcher;

	private List<String> publicUrls;

	private UserService userService;

	private MenuService menuService;

	public AntPathMatcher getAntPathMatcher() {
		return antPathMatcher;
	}

	public void setAntPathMatcher(AntPathMatcher antPathMatcher) {
		this.antPathMatcher = antPathMatcher;
	}

	public List<String> getPublicUrls() {
		return publicUrls;
	}

	public void setPublicUrls(List<String> publicUrls) {
		this.publicUrls = publicUrls;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

}
