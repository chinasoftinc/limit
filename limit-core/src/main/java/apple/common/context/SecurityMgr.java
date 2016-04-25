package apple.common.context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

import apple.common.context.Constants.LoginStatus;
import apple.common.dto.UserLoginValidator;
import apple.common.exception.ExceptionCode;
import apple.common.exception.BusinessException;
import apple.module.menu.model.Menu;
import apple.module.menu.model.MenuExam;
import apple.module.menu.service.MenuService;
import apple.module.user.model.User;
import apple.module.user.model.UserExam;
import apple.module.user.service.UserService;

/**
 * 系统安全管理器
 * @author Binxiao
 */
public class SecurityMgr {

	private static Logger logger = LoggerFactory.getLogger(SecurityMgr.class);

	/**
	 * 校验用户, 返回登录用户提交信息和账户状态信息
	 * @param user
	 * @return Map<User, LoginStatus> 登录用户提交信息和账户状态信息
	 * @throws Exception
	 */
	public UserLoginValidator validateUser(User user) throws Exception {

		// 根据提交的用户信息查询账户
		UserExam exam = new UserExam();
		exam.or().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<User> users = userService.selectByExample(exam);

		LoginStatus status = null;

		// 存在账户
		if (CollectionUtils.isNotEmpty(users)) {
			user = users.get(0);

			// 如果是管理员, 返回管理员状态
			if (LoginStatus.ADMIN.code.equals(user.getStatus()))
				status = LoginStatus.ADMIN;

			// 如果是普通账户, 返回普通状态
			else if (LoginStatus.VAILD.code.equals(user.getStatus()))
				status = LoginStatus.VAILD;
		} else {

			// 登录错误
			status = LoginStatus.ERROR;
		}

		return new UserLoginValidator(user, status);
	}

	/**
	 * 用户登录, 计算用户权限总和, 登录信息存放到会话
	 * @param user
	 */
	public void login(User user, HttpServletRequest request) {

		// 用户状态异常
		if (user.getStatus() == null) {
			throw new BusinessException(ExceptionCode.UserStatusException);
		}

		// 查询最大的privilegePos[权限位]
		Integer maxPos = menuService.selectMaxPrivilegePos();

		// 根据pos位数初始化数组大小, 对应存放每个pos的权限和, 初始化权限数组的大小为pos + 1, 因为pos从0开始
		long[] privilegeSum = new long[maxPos == null ? 1 : maxPos + 1];

		// 查询用户的所有菜单, 管理员查询所有
		List<Menu> menus;
		if (Constants.LoginStatus.ADMIN.code.equals(user.getStatus())) {
			menus = menuService.selectByExample(new MenuExam());
		}
		menus = menuService.selectUserMenus(user.getId());

		// 获取每个菜单对应的pos和privilegeCode, 根据pos分组计算权限和, 存入list中对应的pos角标, 如果该pos没有对应的权限码, 设和为0, 因为0&任何数 都为0, 也就是无权限
		for (Menu menu : menus) {
			int pos = menu.getPrivilegePos();
			long code = menu.getPrivilegeCode();
			privilegeSum[pos] = code | privilegeSum[pos]; // 计算组的权限总和, 或运算
		}

		// 将权限总和保存到用户
		user.setPrivilegeSum(privilegeSum);

		// 将用户设置到session中, 标记为登录状态
		request.getSession().setAttribute(Dictionary.USER_SESSION_KEY, user);
	}

	/**
	 * 判断请求的uri对应用户是否有权限
	 * @param uri
	 * @return
	 */
	public boolean hasPrivilege(String uri, HttpServletRequest request) {

		// 公共资源放行
		if (isPublicResource(uri))
			return true;

		// 获取当前用户
		User user = getLoginUser(request);

		if (user != null) {

			// 管理员放行
			if (LoginStatus.ADMIN.code.equals(user.getStatus())) {
				return true;
			}

			// session失效, 重新登录
			if (user.getPrivilegeSum() == null) {
				return false;
			}

			// 如果是应用根目录, 那么放行
			if ("/".equals(uri)) {
				return true;
			}

			// 将uri第一个斜杠去掉, 因为数据存储的menu的url开头没有斜杠
			uri = uri.replace("/", "");

			// 根据uri查询匹配的菜单
			Menu matcherMenu = null;
			MenuExam exam = new MenuExam();
			exam.or().andMenuUrlLikeInsensitive(uri + "%");
			List<Menu> menus = menuService.selectByExample(exam);
			if (CollectionUtils.isNotEmpty(menus)) {
				matcherMenu = menus.get(0);
			}

			// 没有查询到对应的菜单, 菜单未收录, 记录警告信息并放行
			if (matcherMenu == null) {
				logger.warn("URI权限检查出现了未收录的URI: {}", uri);
				return true;
			}

			// 计算用户是否有该菜单的权限, 用户权限总和数组[menu的pos位] - > 该pos位的权限和 & menu的权限码
			Long rs = user.getPrivilegeSum()[matcherMenu.getPrivilegePos()] & matcherMenu.getPrivilegeCode();

			// 结果不为0则有权限
			return rs != 0;
		}

		// 用户未登录不能访问非公共资源
		return false;
	}

	/**
	 * 获取当前登录用户
	 * @return
	 */
	public User getLoginUser(HttpServletRequest request) {
		Object user = request.getSession().getAttribute(Dictionary.USER_SESSION_KEY);
		return user == null ? null : (User) user;
	}

	/**
	 * 用户注销
	 */
	public void logout(HttpServletRequest request) {
		request.getSession().removeAttribute(Dictionary.USER_SESSION_KEY);
	}

	/**
	 * 检测是否是超级管理员
	 * @param user
	 * @return
	 */
	public boolean isAdmin(User user) {
		return LoginStatus.ADMIN.code.equals(user.getStatus()) ? true : false;
	}

	/**
	 * 查询用户的所有菜单结构(key为一级菜单名称, value为二级菜单集合)
	 * @param userId
	 * @return
	 */
	public Map<String, List<Menu>> selectUserMenusMap(HttpServletRequest request) {

		Map<String, List<Menu>> menus = new LinkedHashMap<String, List<Menu>>();

		// 查询一级菜单
		MenuExam exam = new MenuExam();
		exam.or().andParentIdEqualTo(0L);
		List<Menu> firstMenus = menuService.selectByExample(exam);

		// 获取登录用户
		User user = getLoginUser(request);

		List<Menu> userMenus;

		// 查询用户授权的二级菜单
		if (isAdmin(user)) {
			userMenus = menuService.selectByExample(new MenuExam());

		} else {
			userMenus = menuService.selectUserMenus(user.getId());
		}

		// 拼接结构
		for (Menu firstMenu : firstMenus) {
			List<Menu> secondMenus = new ArrayList<Menu>();

			for (Menu secondmenu : userMenus) {
				if (secondmenu.getParentId().compareTo(firstMenu.getId()) == 0) {
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

		// 检测公共资源配置
		if (CollectionUtils.isEmpty(publicUrls)) {
			throw new BusinessException(ExceptionCode.IllegalParamException, "权限过滤应至少包含一个公共资源");
		}

		// uri匹配公共资源
		for (String publicUrl : publicUrls) {

			if (antPathMatcher.match(publicUrl + "/**", uri)) {
				return true;
			}
		}

		return false;
	}

	// spring url 匹配工具类
	private AntPathMatcher antPathMatcher;

	// 公共放行URL
	private List<String> publicUrls;

	// 管理员帐号
	private String admin_username;

	// 管理员密码
	private String admin_password;

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

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
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
