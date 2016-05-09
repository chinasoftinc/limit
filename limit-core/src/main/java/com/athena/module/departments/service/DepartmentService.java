package com.athena.module.departments.service;

import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;

public interface DepartmentService extends Service<Department, DepartmentExample> {

	/**
	 * 获取部门树型结构
	 * @return
	 */
	List<Department> selectDepartmentsTree();

}
