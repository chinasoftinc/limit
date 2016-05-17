package com.athena.module.menus.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants.Direction;
import com.athena.common.dto.Pagination;
import com.athena.common.dto.TreeNode;
import com.athena.module.menus.dao.MenuDao;
import com.athena.module.menus.model.Menu;
import com.athena.module.menus.model.MenuExample;
import com.athena.module.menus.model.MenuExample.Criteria;
import com.athena.module.rolemenu.dao.RoleMenuDao;
import com.athena.module.rolemenu.model.RoleMenuExample;
import com.athena.module.roleuser.dao.RoleUserDao;
import com.athena.module.roleuser.model.RoleUser;
import com.athena.module.roleuser.model.RoleUserExample;

@Service
public class MenuServiceImp extends AbstractService<Menu, MenuExample> implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private RoleMenuDao roleMenuDao;

	@Autowired
	private RoleUserDao roleUserDao;

	@Override
	public List<Menu> selectMenuTree() {

		// 查询一级菜单
		MenuExample example = new MenuExample();
		example.setOrderByClause("MENU_SORT_NO");
		example.or().andMenuParentIdEqualTo(BigDecimal.ZERO);
		List<Menu> firstMenus = menuDao.selectByExample(example);

		// 遍历查询二级菜单
		for (Menu menu : firstMenus) {
			menu.setParentName("一级菜单");
			example = new MenuExample();
			example.setOrderByClause("MENU_SORT_NO");
			example.or().andMenuParentIdEqualTo(menu.getId());
			List<Menu> secondMenus = selectByExample(example);
			for (Menu subMenu : secondMenus) {
				subMenu.setParentName(menu.getMenuName()); // 设置二级菜单的父菜单名称
			}
			menu.setChildren(secondMenus); // 添加到父菜单children
		}

		return firstMenus;
	}

	@Override
	public int insertMenu(Menu menu) {

		// 主键
		menu.setId(menuDao.nextSEQ());

		// 排序
		menu.setMenuSortNo(menuDao.selectMaxSortNo(menu.getMenuParentId()));

		// 设置权限码和权限位
		Long maxPos = menuDao.selectMaxPrivilegePos();
		if (maxPos != null) {
			Long maxCode = menuDao.selectMaxPrivilegeCode(maxPos);
			if (maxCode << 1 < 0) {
				menu.setMenuPrivilegePos(maxPos + 1);
				menu.setMenuPrivilegeCode(1L);
			} else {
				menu.setMenuPrivilegePos(maxPos);
				menu.setMenuPrivilegeCode(maxCode << 1);
			}
		} else {
			menu.setMenuPrivilegePos(0L);
			menu.setMenuPrivilegeCode(1L);
		}

		return menuDao.insertSelective(menu);
	}

	@Override
	public int updateMenu(Menu form) {
		return this.updateByPrimaryKeySelective(form);
	}

	@Override
	public void removeMenu(BigDecimal id) {

		// 查询子菜单
		MenuExample example = new MenuExample();
		example.or().andMenuParentIdEqualTo(id);
		List<Menu> children = menuDao.selectByExample(example);

		// 删除菜单, 子菜单, 子菜单和角色的关联
		Menu root = new Menu();
		root.setId(id);
		children.add(root);
		List<BigDecimal> idlist = new ArrayList<>();
		for (Menu menu : children) {
			idlist.add(menu.getId());
		}

		RoleMenuExample rolemenuexample = new RoleMenuExample();
		rolemenuexample.or().andMenuIdIn(idlist);
		roleMenuDao.deleteByExample(rolemenuexample);
		MenuExample menuexample = new MenuExample();
		menuexample.or().andIdIn(idlist);
		this.deleteByExample(menuexample);
	}

	// 交换两个菜单的排序位置
	@Override
	public void updateMenuPos(BigDecimal menuId, Direction direction) {

		Menu currentMenu = menuDao.selectByPrimaryKey(menuId);

		MenuExample example = new MenuExample();
		Criteria criteria = example.or().andMenuParentIdEqualTo(currentMenu.getMenuParentId());
		if (Direction.UP == direction) {
			criteria.andMenuSortNoLessThan(currentMenu.getMenuSortNo());
			example.setOrderByClause("MENU_SORT_NO DESC");
		} else {
			criteria.andMenuSortNoGreaterThan(currentMenu.getMenuSortNo());
			example.setOrderByClause("MENU_SORT_NO ASC");
		}

		// 只查询相邻的一个
		example.setPagination(new Pagination(1, 1));
		List<Menu> result = menuDao.selectByExample(example);

		if (CollectionUtils.isNotEmpty(result)) {
			Menu targetMenu = result.get(0); // 相邻的目标菜单
			// 交换菜单的排序
			Short tempOrder = targetMenu.getMenuSortNo();
			targetMenu.setMenuSortNo(currentMenu.getMenuSortNo());
			currentMenu.setMenuSortNo(tempOrder);
			menuDao.updateByPrimaryKeySelective(targetMenu);
			menuDao.updateByPrimaryKeySelective(currentMenu);
		}
	}

	@Override
	public List<TreeNode> selectEasyUITreeNodes() {

		List<TreeNode> treeNodes = new ArrayList<TreeNode>();

		// 查询出一级菜单按order排序
		MenuExample example = new MenuExample();
		example.setOrderByClause("MENU_SORT_NO");
		example.or().andMenuParentIdEqualTo(BigDecimal.ZERO);
		List<Menu> firstMenus = menuDao.selectByExample(example);

		TreeNode node = null;
		List<TreeNode> children = null;
		List<Menu> secondMenus = null;
		TreeNode child = null;
		// 处理一级菜单的转换
		for (Menu menu : firstMenus) {
			node = new TreeNode();
			node.setText(menu.getMenuName());
			node.setId(menu.getId().toString());
			node.setState("closed");
			example = new MenuExample();
			example.setOrderByClause("MENU_SORT_NO"); // 排序
			example.or().andMenuParentIdEqualTo(menu.getId());
			secondMenus = selectByExample(example);

			// 处理二级菜单转化
			if (CollectionUtils.isNotEmpty(secondMenus)) {
				children = new ArrayList<TreeNode>();
				for (Menu menu2 : secondMenus) {
					child = new TreeNode();
					child.setId(String.valueOf(menu2.getId()));
					child.setText(menu2.getMenuName());
					children.add(child);
				}
				node.setChildren(children);
				treeNodes.add(node);
			}
		}

		return treeNodes;
	}

	// 查询指定用户的所有菜单
	@Override
	public List<Menu> selectUserMenus(BigDecimal userId) {
		RoleUserExample example = new RoleUserExample();
		example.or().andUserIdEqualTo(userId);
		List<RoleUser> userRoles = roleUserDao.selectByExample(example);
		List<BigDecimal> roleIds = new ArrayList<>();
		for (RoleUser ur : userRoles) {
			roleIds.add(ur.getRoleId());
		}

		if (!roleIds.isEmpty()) {
			return menuDao.selectMenusByRoleIds(roleIds);
		} else {
			return new ArrayList<Menu>();
		}
	}

	@Override
	public Long selectMaxPrivilegePos() {
		return menuDao.selectMaxPrivilegePos();
	}

}
