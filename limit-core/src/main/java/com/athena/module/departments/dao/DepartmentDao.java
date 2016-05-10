package com.athena.module.departments.dao;

import java.math.BigDecimal;

import com.athena.common.base.dao.Dao;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;

public interface DepartmentDao extends Dao<Department, DepartmentExample> {

	/**
	 * 查询最大排序
	 * @param bigDecimal
	 * @return
	 */
	Short selectMaxSortNo(BigDecimal bigDecimal);

}
