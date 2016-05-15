package com.athena.module.roleuser.dao;

import com.athena.common.base.dao.Dao;
import com.athena.module.roleuser.model.RoleUser;
import com.athena.module.roleuser.model.RoleUserExample;

public interface RoleUserDao extends Dao<RoleUser, RoleUserExample> {

	/**
	 * 保存角色和用户关联
	 * @param roleuser
	 * @return
	 */
	int insertRoleUser(RoleUser roleuser);
}
