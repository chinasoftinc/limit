package com.athena.module.departments.dao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.departments.mapper.DepartmentMapper;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;

@Repository
public class DepartmentDaoImp extends AbstractDao<Department, DepartmentExample> implements DepartmentDao {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public String sequenceName() {
		return "T_DEPARTMENTS_SEQ";
	}

	@Override
	public Short selectMaxSortNo(BigDecimal bigDecimal) {
		Short no = departmentMapper.selectMaxSortNo(bigDecimal);
		return no == null ? 0 : no; 
	}

}
