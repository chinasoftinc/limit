package com.athena.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;

/**
 * 系统入口控制器
 * @author Binxiao
 */
@Controller
public class MainController extends AbstractWebController {

	// 入口页面
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/main/main");
		return mv;
	}

}
