package com.athena.module.roleuser.dao;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.roleuser.model.RoleUser;
import com.athena.module.roleuser.model.RoleUserExample;

@Repository
public class RoleUserDaoImp extends AbstractDao<RoleUser, RoleUserExample> implements RoleUserDao {

	@Override
	public String sequenceName() {
		return "T_ROLE_USER_SEQ";
	}

	@Override
	public int insertRoleUser(RoleUser roleuser) {
		roleuser.setId(this.nextSEQ());
		return this.insertSelective(roleuser);
	}

}
