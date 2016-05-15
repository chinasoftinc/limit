package com.athena.module.roles.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.athena.module.users.model.User;

@Service
public class RoleServiceImp extends AbstractService<Role, RoleExample> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public void insertRole(Role role, User creator) {

		// FIXME 插入角色和权限关联..

		// 记录操作用户
		if (creator != null) {
			role.setCreateUserid(creator.getId());
			role.setUpdateUserid(creator.getId());
		}

		// 记录操作时间
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());

		// 生成roleCode
		role.setRoleCode(String.valueOf(role.getRoleName().hashCode()));

		role.setId(roleDao.nextSEQ());
		roleDao.insertSelective(role);
	}

	@Override
	public void updateRole(Role role, User creator) {

		// FIXME 处理权限的修改..

		// 记录操作用户
		if (creator != null) {
			role.setUpdateUserid(creator.getId());
		}

		// 记录操作时间
		role.setUpdateTime(new Date());

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
