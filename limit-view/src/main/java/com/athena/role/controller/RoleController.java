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
import com.athena.common.context.Constants.IS_DEL;
import com.athena.common.dto.PageResult;
import com.athena.common.dto.ResponseResult;
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

	// 主页
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView roleManage(Role filter) {
		ModelAndView mv = new ModelAndView("/system/role/main");
		mv.addObject("filter", filter);
		return mv;
	}

	// 数据
	@RequestMapping(value = "/rolesJson", method = RequestMethod.POST)
	@ResponseBody
	public Object rolesJson(Role filter, HttpServletResponse response) {
		return seacher(filter);
	}

	// 添加角色页面
	@RequestMapping(value = "/addRoleView", method = RequestMethod.GET)
	public ModelAndView addRoleView(Role form) {
		ModelAndView mv = new ModelAndView("/system/role/edit");
		setWindowsId(mv, form);
		setAddOperation(mv);
		return mv;
	}

	// 修改角色页面
	@RequestMapping(value = "/editRoleView", method = RequestMethod.GET)
	public ModelAndView editRoleView(Role form) {
		ModelAndView mv = new ModelAndView("/system/role/edit");

		mv.addObject("role", roleService.loadRole(form.getId()));

		setWindowsId(mv, form);
		setEditOperation(mv);
		return mv;
	}

	// 保存角色
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public ModelAndView saveRole(Role form) {
		ModelAndView mv = new ModelAndView();
		if (isAddOperation(form)) {
			setSuccessView(mv);
			roleService.insertRole(form, null);
		} else {
			setCompleteView(mv);
			roleService.updateRole(form, null);
		}
		setWindowsId(mv, form);
		return mv;
	}

	// 删除角色
	@RequestMapping(value = "/removeRole", method = RequestMethod.POST)
	@ResponseBody
	public Object removeMenu(Role form, HttpServletResponse response) {
		try {
			roleService.removeRole(form.getId());
			return new ResponseResult(true, "删除角色成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseResult(false, "删除角色失败");
		}
	}

	// 搜索
	private PageResult<Role> seacher(Role filter) {

		PageResult<Role> pr = new PageResult<Role>(filter);
		RoleExample example = new RoleExample();

		// 设置分页查询对象
		if (pr.getPagination() != null)
			example.setPagination(pr.getPagination());

		// 获取构建后的条件模型
		filter = (Role) pr.getFilter();

		// 构建查询参数
		if (filter != null) {
			Criteria ct = example.or();
			if (StringUtils.isNotEmpty(filter.getRoleName())) {
				ct.andRoleNameLikeInsensitive("%" + filter.getRoleName() + "%");
			}
			ct.andIsDelEqualTo(IS_DEL.NOT.code);

			// 构建排序
			example.setOrderByClause(pr.getOrderByString());
		}

		// 查询数据
		pr.setRows(roleService.selectByExample(example));
		Integer total = roleService.countByExample(example);

		// 构建数据总数
		pr.getPagination().setTotalRcord(total);
		pr.setTotal(total);

		return pr;
	}
}
