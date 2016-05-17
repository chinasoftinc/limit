package com.athena.module.roles.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.mapper.Mapper;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;

public interface RoleMapper extends Mapper<Role, RoleExample> {

	/**
	 * 根据用户id查询所拥有的权限
	 * @param id
	 * @return
	 */
	List<Role> selectRolesByUserId(BigDecimal id);
}