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
import com.athena.module.users.model.User;

/**
 * 系统入口
 * @author Binxiao
 */
@Controller
public class MainController extends AbstractWebController {

	@Autowired
	private com.athena.common.context.SecurityManager securityManager;

	// 入口页面
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/main/main");
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
			return new ResponseResult(false, new BusinessException(ExceptionCode.SystemException, "未知异常"));
		}

	}

}
