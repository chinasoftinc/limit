package com.athena.module.roles.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants.IS_DEL;
import com.athena.common.dto.TreeNode;
import com.athena.module.roles.dao.RoleDao;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;

@Service
public class RoleServiceImp extends AbstractService<Role, RoleExample> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public void insertRole(Role role) {
		role.setId(roleDao.nextSEQ());

		// FIXME 插入角色和权限关联..

		roleDao.insertSelective(role);
	}

	@Override
	public void updateRole(Role role) {

		// FIXME 处理权限的修改..

		roleDao.updateByPrimaryKeySelective(role);
	}

	@Override
	public Role loadRole(BigDecimal id) {
		Role role = roleDao.selectByPrimaryKey(id);

		// FIXME 查询角色权限关联信息, 设置到privilegeIds字段..

		return role;
	}

	@Override
	public void removeRole(BigDecimal id) {
		Role role = new Role();
		role.setId(id);

		// FIXME 删除权限关联 ..

		// FIXME 删除用户关联 ..

		role.setIsDel(IS_DEL.DELED.code);
		roleDao.updateByPrimaryKeySelective(role);
	}

	@Override
	public List<TreeNode> selectRolesTree() {
		// 查询所有角色
		RoleExample example = new RoleExample();
		List<Role> roles = roleDao.selectByExample(example);

		// 生成树节点
		List<TreeNode> treeNodes = null;
		if (CollectionUtils.isNotEmpty(roles)) {
			treeNodes = new ArrayList<TreeNode>();
			TreeNode node;
			for (Role role : roles) {
				node = new TreeNode();
				node.setId(String.valueOf(role.getId()));
				node.setText(role.getRoleName());
				treeNodes.add(node);
			}
		}

		return treeNodes;
	}

}
