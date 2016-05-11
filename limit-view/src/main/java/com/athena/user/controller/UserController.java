package com.athena.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.dto.PageResult;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExampleDefined;
import com.athena.module.users.service.UserService;

/**
 * 用户
 * @author niebinxiao
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends AbstractWebController {
	@Inject
	private UserService userService;

	// 用户管理页面
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView roleManage(User filter) {

		ModelAndView mv = new ModelAndView("/system/user/main");

		// FIXME 查询所有角色供搜索下拉生成

		mv.addObject("filter", filter);
		return mv;
	}

	// 数据
	@RequestMapping(value = "/userJson", method = RequestMethod.POST)
	@ResponseBody
	public Object userJson(User filter, HttpServletResponse response) {

		// 构建分页查询dto
		PageResult<User> pr = new PageResult<User>(filter);

		// 搜索分页数据
		return seacher(pr);
	}

	// 搜索
	private PageResult<User> seacher(PageResult<User> pr) {

		// 查询分页用户消息
		UserExampleDefined example = new UserExampleDefined();
		example.setPagination(pr.getPage());
		example.setFilter(pr.getFilter());

		// 查询数据并构建
		pr.setRows(userService.selectUserPage(example));
		Integer total = userService.selectUserCount(example);
		pr.getPage().setTotalRcord(total);
		pr.setTotal(total);

		return pr;
	}

}
