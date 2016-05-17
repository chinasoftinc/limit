package com.athena.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.context.Constants.LoginStatus;
import com.athena.common.dto.ResponseResult;
import com.athena.common.dto.UserLoginValidator;
import com.athena.common.exception.BusinessException;
import com.athena.common.exception.ExceptionCode;
import com.athena.module.menus.service.MenuService;
import com.athena.module.users.model.User;
import com.athena.module.users.service.UserService;

/**
 * 系统入口
 * @author Binxiao
 */
@Controller
public class MainController extends AbstractWebController {

	@Autowired
	private com.athena.common.context.SecurityManager securityManager;

	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;

	// 入口页面
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/main/main");

		// 查询用户的授权菜单
		mv.addObject("menus", securityManager.selectUserMenusMap(request));
		return mv;
	}

	// 登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/public/login");
		return mv;
	}

	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(User form, HttpServletResponse response, HttpServletRequest request) {
		ResponseResult loginResponse = null;
		try {
			UserLoginValidator validator = securityManager.validateUser(form);
			LoginStatus status = validator.getStatus();

			form = validator.getUser();

			switch (status) {

			case ERROR:
				return new ResponseResult(false, LoginStatus.ERROR);

			case INVAILD:
				return new ResponseResult(false, LoginStatus.INVAILD);

			case ADMIN:
				loginResponse = new ResponseResult(true, LoginStatus.ADMIN);
				break;

			default:
				loginResponse = new ResponseResult(true, LoginStatus.VAILD);
				break;
			}

			securityManager.login(form, request);

			return loginResponse;
		} catch (BusinessException e) {
			return new ResponseResult(false, e);

		} catch (Exception e) {
			logger.error("系统登录异常: {}\r", e.getLocalizedMessage());
			return new ResponseResult(false, new BusinessException(ExceptionCode.SystemException, "未知异常, 请联系系统管理员"));
		}
	}

	// 用户退出系统
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public Object logout(HttpServletResponse response, HttpServletRequest request) {
		securityManager.logout(request);
		return new ResponseResult(true);
	}

	// 个人信息
	@RequestMapping(value = "/accout", method = RequestMethod.GET)
	public ModelAndView userInfo(User form, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// 个人信息页面
		if ("read".equals(form.getOperation())) {
			mv.setViewName("/system/user/accoutView");
			// 获取当前用户
			User loginUser = securityManager.getLoginUser(request);
			// 获取带角色名的user
			User viewUser = userService.load(loginUser.getId());
			mv.addObject("user", viewUser);
			mv.addObject("menus", menuService.selectUserMenus(loginUser.getId()));

			// 修改密码页面
		} else if ("edit".equals(form.getOperation())) {
			mv.setViewName("/system/user/accoutEdit");
			// 获取当前用户
			User loginUser = securityManager.getLoginUser(request);
			mv.addObject("user", loginUser);
		}
		setWindowsId(mv, form);
		return mv;
	}

	// 修改密码提交
	@RequestMapping(value = "/accout", method = RequestMethod.POST)
	public ModelAndView modifyPwd(User form, String newPassword, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/common/tip/complete");

		// 校验原密码是否正确
		User currentUser = securityManager.getLoginUser(request);
		if (currentUser.getPassWord().equals(form.getPassWord())) {
			userService.updateByPrimaryKeySelective(form); // 修改用户密码为新密码
			currentUser.setPassWord(newPassword); // 改变当前登录用户的密码为新密码
			form.setPassWord(newPassword); // 设置新密码
		} else {
			setErrorView(mv, "原密码不正确");
		}

		setWindowsId(mv, form);
		return mv;
	}

}
