package com.athena.module.roles.service;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.common.dto.TreeNode;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;
import com.athena.module.users.model.User;

public interface RoleService extends Service<Role, RoleExample> {

	/**
	 * 插入角色并保存角色菜单的关联
	 * @param role
	 */
	void insertRole(Role role, User creator);

	/**
	 * 更新角色消息并保存角色菜单的关联
	 * @param role
	 */
	void updateRole(Role role, User creator);

	/**
	 * 获取角色和菜单信息
	 * @param id
	 * @return
	 */
	Role loadRole(BigDecimal id);

	/**
	 * 删除角色并删除菜单关联
	 * @param id
	 * @param creator 
	 */
	void removeRole(BigDecimal id, User creator);

	/**
	 * 生成菜单的树结构
	 * @return
	 */
	List<TreeNode> selectRolesTree();

	/**
	 * 根据用户id查询所拥有权限
	 * @param id
	 * @return
	 */
	List<Role> selectRolesByUserId(BigDecimal id);
}
