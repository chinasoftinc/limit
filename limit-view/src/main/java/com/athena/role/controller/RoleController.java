package com.athena.role.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.dto.PageResult;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;
import com.athena.module.roles.model.RoleExample.Criteria;
import com.athena.module.roles.service.RoleService;

/**
 * 角色
 * @author niebinxiao
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends AbstractWebController {
	@Inject
	private RoleService roleService;

	// 角色管理页面
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public ModelAndView roleManage(Role filter) {
		ModelAndView mv = new ModelAndView("/system/role/roleManage");
		mv.addObject("filter", filter);
		return mv;
	}

	// 角色生成json [easyui, datagrid使用]
	@RequestMapping("/rolesJson")
	@ResponseBody
	public Object rolesJson(Role filter, HttpServletResponse response) {
		return seacher(filter);
	}

	// 分页搜索数据
	private PageResult<Role> seacher(Role filter) {

		PageResult<Role> pr = new PageResult<Role>(filter);
		RoleExample seacher = new RoleExample();

		// 设置分页查询对象
		if (pr.getPagination() != null)
			seacher.setPagination(pr.getPagination());

		// 获取构建后的条件模型
		filter = (Role) pr.getFilter();

		// 构建查询参数
		if (filter != null) {
			Criteria ct = seacher.or();
			if (StringUtils.isNotEmpty(filter.getRoleName())) {
				ct.andRoleNameLikeInsensitive("%" + filter.getRoleName() + "%");
			}

			// 构建排序
			seacher.setOrderByClause(pr.getOrderByString());
		}

		// 查询数据
		pr.setRows(roleService.selectByExample(seacher));
		Integer total = roleService.countByExample(seacher);

		// 构建数据总数
		pr.getPagination().setTotalRcord(total);
		pr.setTotal(total);

		return pr;
	}
}
