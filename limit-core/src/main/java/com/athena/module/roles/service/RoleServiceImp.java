package com.athena.module.roles.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants.IS_DEL;
import com.athena.common.dto.TreeNode;
import com.athena.module.rolemenu.dao.RoleMenuDao;
import com.athena.module.rolemenu.model.RoleMenu;
import com.athena.module.rolemenu.model.RoleMenuExample;
import com.athena.module.roles.dao.RoleDao;
import com.athena.module.roles.model.Role;
import com.athena.module.roles.model.RoleExample;
import com.athena.module.roleuser.dao.RoleUserDao;
import com.athena.module.roleuser.model.RoleUserExample;
import com.athena.module.users.model.User;

@Service
public class RoleServiceImp extends AbstractService<Role, RoleExample> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private RoleMenuDao roleMenuDao;

	@Autowired
	private RoleUserDao roleuserDao;


	@Override
	public void insertRole(Role role, User creator) {

		role.setId(roleDao.nextSEQ());

		// 插入角色和菜单关联
		if (StringUtils.isNotEmpty(role.getMenus())) {
			for (String menuId : role.getMenus().split(",")) {
				RoleMenu rm = new RoleMenu();
				rm.setId(roleMenuDao.nextSEQ());
				rm.setRoleId(role.getId());
				rm.setMenuId(new BigDecimal(menuId));
				roleMenuDao.insert(rm);
			}
		}

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

		roleDao.insertSelective(role);
	}

	@Override
	public void updateRole(Role role, User creator) {

		// 查询原关联菜单
		RoleMenuExample example = new RoleMenuExample();
		example.or().andRoleIdEqualTo(role.getId());
		List<RoleMenu> rms = roleMenuDao.selectByExample(example);

		// 处理菜单的更新删除
		if (StringUtils.isNotEmpty(role.getMenus())) {
			List<String> newMenus = new ArrayList<String>();
			newMenus.addAll(Arrays.asList((role.getMenus().split(","))));

			for (RoleMenu rm : rms) {
				if (!newMenus.contains(String.valueOf(rm.getMenuId()))) {
					roleMenuDao.deleteByPrimaryKey(rm.getId());
				} else {
					newMenus.remove(String.valueOf(rm.getMenuId()));
				}
			}

			// 增加的菜单
			if (CollectionUtils.isNotEmpty(newMenus)) {
				for (String menuId : newMenus) {
					RoleMenu rm = new RoleMenu();
					rm.setId(roleMenuDao.nextSEQ());
					rm.setMenuId(new BigDecimal(menuId));
					rm.setRoleId(role.getId());
					roleMenuDao.insert(rm);
				}
			}

		} else {
			// 用户取消全部或没有勾选任何菜单
			RoleMenuExample roleMenuExample = new RoleMenuExample();
			example.or().andRoleIdEqualTo(role.getId());
			roleMenuDao.deleteByExample(roleMenuExample);
		}

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

		// 查询角色菜单关联信息, 设置到menus字段..
		RoleMenuExample example = new RoleMenuExample();
		example.or().andRoleIdEqualTo(id);
		List<RoleMenu> rms = roleMenuDao.selectByExample(example);

		if (CollectionUtils.isNotEmpty(rms)) {
			StringBuffer sb = new StringBuffer();
			for (RoleMenu rm : rms) {
				sb.append(String.valueOf(rm.getMenuId()).concat(","));
			}
			role.setMenus(sb.substring(0, sb.length() - 1));
		}

		return role;
	}

	@Override
	public void removeRole(BigDecimal id, User creator) {
		Role role = new Role();
		role.setId(id);

		// 删除菜单关联
		RoleMenuExample rolemenuexample = new RoleMenuExample();
		rolemenuexample.or().andRoleIdEqualTo(role.getId());
		roleMenuDao.deleteByExample(rolemenuexample);

		// 删除用户关联
		RoleUserExample roleuserexample = new RoleUserExample();
		roleuserexample.or().andRoleIdEqualTo(id);
		roleuserDao.deleteByExample(roleuserexample);

		// 记录操作用户
		if (creator != null) {
			role.setUpdateUserid(creator.getId());
		}

		// 记录操作时间
		role.setUpdateTime(new Date());

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

	@Override
	public List<Role> selectRolesByUserId(BigDecimal id) {

		return roleDao.selectRolesByUserId(id);
	}

}
