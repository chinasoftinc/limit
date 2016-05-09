package com.athena.module.departments.dao;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;

@Repository
public class DepartmentDaoImp extends AbstractDao<Department, DepartmentExample> implements DepartmentDao {

	@Override
	public String sequenceName() {
		return "DEPARTMENTS_SEQ";
	}

}
