package com.athena.module.roles.dao;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.dao.Dao;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;

public interface RoleDao extends Dao<Role, RoleExample> {

	/**
	 * 根据用户id查询所拥有的权限
	 * @param id
	 * @return
	 */
	List<Role> selectRolesByUserId(BigDecimal id);

}
