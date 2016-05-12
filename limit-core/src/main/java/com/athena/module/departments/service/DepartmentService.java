package com.athena.module.departments.service;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.common.context.Constants.Direction;
import com.athena.common.exception.BusinessException;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;

public interface DepartmentService extends Service<Department, DepartmentExample> {

	/**
	 * 获取部门树型结构
	 * @return
	 */
	List<Department> selectDepartmentsTree();

	/**
	 * 更新部门
	 * @param record
	 */
	void update(Department record);

	/**
	 * 移动位置
	 * @param id
	 * @param valueOf
	 */
	void updatePos(BigDecimal id, Direction direction);

	/**
	 * 删除部门
	 * @param id
	 * @throws BusinessException
	 */
	void remove(BigDecimal id) throws BusinessException;

	/**
	 * 查询指定机构的所有子部门
	 * @param orgId
	 * @return
	 */
	List<Department> listDeptForOrg(BigDecimal orgId);

}
