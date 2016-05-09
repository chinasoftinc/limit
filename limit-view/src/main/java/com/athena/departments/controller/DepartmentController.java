package com.athena.departments.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.service.DepartmentService;

@Controller
@RequestMapping("/system/deptment")
public class DepartmentController extends AbstractWebController {

	@Autowired
	private DepartmentService departmentService;

	// 部门主页
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView optdicManage() {
		return new ModelAndView("/system/department/main");
	}

	// 字典数据
	@RequestMapping(value = "/deptJson", method = RequestMethod.POST)
	@ResponseBody
	public Object dictionaryJson(HttpServletResponse response) {
		List<Department> depts = departmentService.selectDepartmentsTree();
		return depts == null ? new ArrayList<>() : depts;
	}
}
