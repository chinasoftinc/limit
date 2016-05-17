package com.athena.module.roles.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.roles.mapper.RoleMapper;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;

@Repository
public class RoleDaoImp extends AbstractDao<Role, RoleExample> implements RoleDao {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public String sequenceName() {
		return "T_ROLES_SEQ";
	}

	@Override
	public List<Role> selectRolesByUserId(BigDecimal id) {
		return roleMapper.selectRolesByUserId(id);
	}

}
