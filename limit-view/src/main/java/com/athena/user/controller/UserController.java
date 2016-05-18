package com.athena.user.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.context.SecurityManager;
import com.athena.common.context.Constants.DepartmentModel;
import com.athena.common.context.Constants.IS_DEL;
import com.athena.common.dto.PageResult;
import com.athena.common.dto.ResponseResult;
import com.athena.common.dto.TreeNode;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;
import com.athena.module.departments.service.DepartmentService;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;
import com.athena.module.roles.service.RoleService;
import com.athena.module.users.model.User;
import com.athena.module.users.service.UserService;

/**
 * 用户
 * @author niebinxiao
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends AbstractWebController {

	@Autowired
	private UserService userService;

	@Autowired
	private DepartmentService deptService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SecurityManager securityManager;

	// 用户管理页面
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView roleManage(User filter) {

		ModelAndView mv = new ModelAndView("/system/user/main");

		// 查询所有下拉选择机构
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptTypeEqualTo(DepartmentModel.Type.ORG.code).andIsDelEqualTo(IS_DEL.NOT.code).andDeptSubCountNotEqualTo((short) 0);

		// 查询所有角色供搜索下拉生成
		mv.addObject("roles", roleService.selectByExample(new RoleExample()));

		mv.addObject("orgList", deptService.selectByExample(example));
		mv.addObject("filter", filter);
		return mv;
	}

	// 数据
	@RequestMapping(value = "/userJson", method = RequestMethod.POST)
	@ResponseBody
	public Object userJson(User filter, HttpServletResponse response) {
		return seacher(filter);
	}

	// 添加用户界面
	@RequestMapping(value = "/addUserView", method = RequestMethod.GET)
	public ModelAndView addView(User form) {
		ModelAndView mv = new ModelAndView("/system/user/edit");

		// 查询所有下拉选择机构
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptTypeEqualTo(DepartmentModel.Type.ORG.code).andIsDelEqualTo(IS_DEL.NOT.code).andDeptSubCountNotEqualTo((short) 0);
		mv.addObject("orgList", deptService.selectByExample(example));

		setAddOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 编辑用户界面
	@RequestMapping(value = "/editUserView", method = RequestMethod.GET)
	public ModelAndView editUserView(User form) {
		ModelAndView mv = new ModelAndView("/system/user/edit");
		User user = userService.getUserWithRoleIds(form.getId());

		// 查询所有下拉选择机构
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptTypeEqualTo(DepartmentModel.Type.ORG.code).andIsDelEqualTo(IS_DEL.NOT.code).andDeptSubCountNotEqualTo((short) 0);

		// 根据用户机构id查询所有子部门下拉
		List<Department> deptList = deptService.listDeptForOrg(user.getOrgId());

		mv.addObject("orgList", deptService.selectByExample(example));
		mv.addObject("deptList", deptList);
		mv.addObject("user", user);
		setEditOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 查看用户
	@RequestMapping(value = "/userView", method = RequestMethod.GET)
	public ModelAndView userView(User form) {
		ModelAndView mv = new ModelAndView("/system/user/view");
		User user = userService.getUserInfo(form.getId());

		// 查询所有下拉选择机构
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptTypeEqualTo(DepartmentModel.Type.ORG.code).andIsDelEqualTo(IS_DEL.NOT.code).andDeptSubCountNotEqualTo((short) 0);

		// 根据用户机构id查询所有子部门下拉
		List<Department> deptList = deptService.listDeptForOrg(user.getOrgId());

		mv.addObject("orgList", deptService.selectByExample(example));
		mv.addObject("deptList", deptList);
		mv.addObject("user", user);
		setWindowsId(mv, form);
		return mv;
	}

	// 保存用户
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(User form, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (isAddOperation(form)) {
			setSuccessView(mv);
			userService.insertUser(form, securityManager.getLoginUser(request));
		} else {
			setCompleteView(mv);
			userService.updateUser(form, securityManager.getLoginUser(request));
		}
		setWindowsId(mv, form);
		return mv;
	}

	// 删除用户
	@RequestMapping(value = "/removeUser", method = RequestMethod.POST)
	@ResponseBody
	public Object removeUser(BigDecimal id, HttpServletRequest request) {
		try {
			userService.removeUser(id, securityManager.getLoginUser(request));
			return new ResponseResult(true, "删除用户成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseResult(false, "删除用户失败");
		}
	}

	// 获取机构的所有子部门
	@RequestMapping(value = "/deptListForOrg", method = RequestMethod.POST)
	@ResponseBody
	public Object deptListForOrg(BigDecimal orgId) {
		List<Department> deptList = deptService.listDeptForOrg(orgId);
		return new ResponseResult(true, deptList);
	}

	@RequestMapping(value = "/isNotExistUserName", method = RequestMethod.POST)
	public void isNotExistUserName(String userName, HttpServletResponse response) throws IOException {
		response.getWriter().write(String.valueOf(userService.isNotExistUserName(userName)));
	}

	// 配置角色
	@RequestMapping(value = "/directionRole", method = RequestMethod.GET)
	public ModelAndView directionRole(Role form) {
		ModelAndView mv = new ModelAndView("/system/user/role");
		setWindowsId(mv, form);
		return mv;
	}

	// 角色数据
	@RequestMapping(value = "/roleTreeJson", method = RequestMethod.POST)
	@ResponseBody
	public Object roleTreeJson(HttpServletResponse response) {
		List<TreeNode> roles = roleService.selectRolesTree();
		return roles == null ? new ArrayList<TreeNode>() : roles;
	}

	// 搜索
	private PageResult<User> seacher(User filter) {

		// 构建分页查询dto
		@SuppressWarnings("unchecked")
		PageResult<User> pr = new PageResult<User>(filter, MapUtils.putAll(new HashMap<String, String>(),
				new String[] { "userSex", "USER_SEX", "userStatus", "USER_STATUS", "lastAccessTime", "LAST_ACCESS_TIME", "onlineTime", "ON_LINE_TIME" }));

		// 查询数据并构建
		pr.setRows(userService.selectUserPage(pr));
		Integer total = userService.selectUserCount(pr);
		pr.getPagination().setTotalRcord(total);
		pr.setTotal(total);

		return pr;
	}

}
