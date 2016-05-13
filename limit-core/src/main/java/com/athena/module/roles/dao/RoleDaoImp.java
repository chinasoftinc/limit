package com.athena.module.roles.dao;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;

@Repository
public class RoleDaoImp extends AbstractDao<Role, RoleExample> implements RoleDao {

	@Override
	public String sequenceName() {
		return "T_ROLES_SEQ";
	}

}
