package com.athena.module.departments.service;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.common.context.Constants.Direction;
import com.athena.common.exception.BusinessException;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;
import com.athena.module.users.model.User;

public interface DepartmentService extends Service<Department, DepartmentExample> {

	/**
	 * 获取部门树型结构
	 * @return
	 */
	List<Department> selectDepartmentsTree();

	/**
	 * 更新部门
	 * @param dept
	 */
	int updateDept(Department dept, User creator);

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
	void removeDept(BigDecimal id, User creator) throws BusinessException;
	
	/**
	 * 插入部门
	 * @param dept
	 * @param creator
	 * @return
	 */
	int insertDept(Department dept, User creator);

	/**
	 * 查询指定机构的所有子部门
	 * @param orgId
	 * @return
	 */
	List<Department> listDeptForOrg(BigDecimal orgId);

}
