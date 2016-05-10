package com.athena.departments.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.context.Constants;
import com.athena.common.dto.ResponseResult;
import com.athena.common.exception.BusinessException;
import com.athena.common.exception.ExceptionCode;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;
import com.athena.module.departments.service.DepartmentService;

@Controller
@RequestMapping("/system/dept")
public class DepartmentController extends AbstractWebController {

	@Autowired
	private DepartmentService departmentService;

	// 主页
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("/system/department/main");
	}

	// 数据
	@RequestMapping(value = "/deptJson", method = RequestMethod.POST)
	@ResponseBody
	public Object deptJson(HttpServletResponse response) {
		List<Department> depts = departmentService.selectDepartmentsTree();
		return depts == null ? new ArrayList<>() : depts;
	}

	// 查看页面
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(Department form) {
		ModelAndView mv = new ModelAndView("/system/department/edit");

		Department dept = departmentService.selectByPrimaryKey(form.getId());

		DepartmentExample example = new DepartmentExample();
		example.or().andIdEqualTo(dept.getDeptParentId());
		List<Department> depts = departmentService.selectByExample(example);

		// 获取上级及插入信息
		Department parent = CollectionUtils.isNotEmpty(depts) ? depts.get(0) : new Department();
		mv.addObject("parent", parent);
		mv.addObject("dept", dept);

		setReadOperation(mv);
		setWindowsId(mv, dept);
		return mv;
	}

	// 添加页面
	@RequestMapping(value = "/addDeptView", method = RequestMethod.GET)
	public ModelAndView addDeptView(Department form) {
		ModelAndView mv = new ModelAndView("/system/department/edit");

		DepartmentExample example = new DepartmentExample();
		example.or().andIdEqualTo(form.getDeptParentId());
		List<Department> depts = departmentService.selectByExample(example);

		// 获取上级及插入信息
		Department parent = CollectionUtils.isNotEmpty(depts) ? depts.get(0) : new Department();
		form.setDeptDeep(parent.getDeptDeep() == null ? 0 : (short) (parent.getDeptDeep() + 1));
		mv.addObject("parent", parent);
		mv.addObject("dept", form);

		setAddOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 编辑页面
	@RequestMapping(value = "/editDeptView", method = RequestMethod.GET)
	public ModelAndView editDeptView(Department form) {
		ModelAndView mv = new ModelAndView("/system/department/edit");

		// 编辑的字典和上级信息
		Department dept = departmentService.selectByPrimaryKey(form.getId());
		Department parent = departmentService.selectByPrimaryKey(dept.getDeptParentId());
		mv.addObject("dept", dept);
		mv.addObject("parent", parent);

		setEditOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 保存
	@RequestMapping(value = "/saveDept", method = RequestMethod.POST)
	@ResponseBody
	public Object saveDept(Department form) {
		try {
			// 添加
			if (isAddOperation(form))
				departmentService.insert(form);
			// 保存
			else
				departmentService.update(form);
			return new ResponseResult(true, "操作成功");
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			return new ResponseResult(false, "操作失败");
		}
	}

	// 删除
	@RequestMapping(value = "/removeDept", method = RequestMethod.POST)
	@ResponseBody
	public Object removeDept(Department form, HttpServletResponse response) {
		try {
			departmentService.remove(form.getId());
			return new ResponseResult(true, "操作成功");
		} catch (Exception e) {
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				if (be.getCode() == ExceptionCode.BusinessException) {
					return new ResponseResult(false, be);
				}
			}
			logger.error(e.getCause().getMessage());
			return new ResponseResult(false, "操作失败");
		}
	}

	// 移动位置
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	@ResponseBody
	public Object move(Department form, String direction, HttpServletResponse response) {
		try {
			departmentService.updatePos(form.getId(), Constants.Direction.valueOf(direction));
			return new ResponseResult(true, "操作成功");
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			return new ResponseResult(false, "操作失败");
		}
	}
}
