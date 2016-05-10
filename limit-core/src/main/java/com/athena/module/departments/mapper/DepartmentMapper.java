package com.athena.module.departments.mapper;

import java.math.BigDecimal;

import com.athena.common.base.mapper.Mapper;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;

public interface DepartmentMapper extends Mapper<Department, DepartmentExample> {

	/**
	 * 搜索最大排序
	 * @param bigDecimal 
	 * @return
	 */
	Short selectMaxSortNo(BigDecimal bigDecimal);
}