package com.athena.module.roles.service;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.common.dto.TreeNode;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;

public interface RoleService extends Service<Role, RoleExample> {

	/**
	 * 插入角色并保存角色权限的关联
	 * @param role
	 */
	void insertRole(Role role);

	/**
	 * 更新角色消息并保存角色权限的关联
	 * @param role
	 */
	void updateRole(Role role);

	/**
	 * 获取角色和权限信息
	 * @param id
	 * @return
	 */
	Role loadRole(BigDecimal id);

	/**
	 * 删除角色并删除权限关联
	 * @param id
	 */
	void removeRole(BigDecimal id);

	/**
	 * 生成角色的树结构 [easyui treeNode]
	 * @return
	 */
	List<TreeNode> selectRolesTree();
}
