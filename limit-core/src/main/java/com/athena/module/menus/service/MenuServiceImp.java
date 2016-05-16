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
import com.athena.module.menus.dao.MenuDao;
import com.athena.module.menus.model.Menu;
import com.athena.module.menus.model.MenuExample;
import com.athena.module.menus.model.MenuExample.Criteria;
import com.athena.module.rolemenu.dao.RoleMenuDao;
import com.athena.module.roleuser.dao.RoleUserDao;

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

	// 添加菜单
	@Override
	public void insertMenu(Menu menu) {

		// 主键
		menu.setId(menuDao.nextSEQ());

		// 排序
		menu.setMenuSortNo(menuDao.selectMaxSortNo(menu.getMenuParentId()));

		// 设置权限码和权限位, 查询最高的权限码和最高的权限位
		Integer maxPos = menuDao.selectMaxPrivilegePos();
		if (maxPos != null) {
			// 查询最大权限位最大权限码
			Long maxCode = menuDao.selectMaxPrivilegeCode(maxPos);
			// 权限码已经移63位, 另起权限位, 权限码从1开始计算
			if (maxCode << 1 < 0) {
				menu.setPrivilegePos(maxPos + 1);
				menu.setPrivilegeCode(new Long(1));
			} else {
				// 否则权限位向后移1位
				menu.setPrivilegePos(maxPos);
				menu.setPrivilegeCode(maxCode << 1);
			}
		} else {
			// 权限位为空, 无任何菜单, 权限位从0开始, 权限码从1开始
			menu.setPrivilegePos(0);
			menu.setPrivilegeCode(new Long(1));
		}

		menuDao.insert(menu);
	}

	// 删除菜单
	@Override
	public void deleteMenu(Long id) {
		// 查询该菜单的子菜单
		MenuExam exam = new MenuExam();
		exam.or().andParentIdEqualTo(id);
		List<Menu> children = menuDao.selectByExample(exam);

		// 删除子菜单
		for (Menu menu : children) {
			// 删除子菜单和角色的关联
			RoleMenuExam rmExam = new RoleMenuExam();
			rmExam.or().andMenuIdEqualTo(menu.getId());
			roleMenuDao.deleteByExample(rmExam);
			menuDao.deleteByPrimaryKey(menu.getId());
		}

		// 删除该菜单和角色的关联
		RoleMenuExam rmExam = new RoleMenuExam();
		rmExam.or().andMenuIdEqualTo(id);
		roleMenuDao.deleteByExample(rmExam);

		// 删除该菜单
		menuDao.deleteByPrimaryKey(id);
	}

	// 交换两个菜单的排序位置
	@Override
	public void updateMenuPos(Long menuId, Direction direction) {
		// 当前菜单
		Menu currentMenu = menuDao.selectByPrimaryKey(menuId);

		// 条件为, 父级菜单相同, 排序相邻的
		MenuExam exam = new MenuExam();
		Criteria criteria = exam.or().andParentIdEqualTo(currentMenu.getParentId());
		if (Direction.UP == direction) {
			// 查询小于当前order, 并且是最大的
			criteria.andMenuOrderLessThan(currentMenu.getMenuOrder());
			exam.setOrderByClause("menu_order desc");
		} else {
			// 查询大于当前order, 并且是最小的
			criteria.andMenuOrderGreaterThan(currentMenu.getMenuOrder());
			exam.setOrderByClause("menu_order asc");
		}
		// 只查询相邻的一个
		exam.setPagination(new Pagination(1, 1));
		List<Menu> result = menuDao.selectByExample(exam);

		if (CollectionUtils.isNotEmpty(result)) {
			Menu targetMenu = result.get(0); // 相邻的目标菜单
			// 交换菜单的排序
			Integer tempOrder = targetMenu.getMenuOrder();
			targetMenu.setMenuOrder(currentMenu.getMenuOrder());
			currentMenu.setMenuOrder(tempOrder);
			menuDao.updateByPrimaryKeySelective(targetMenu);
			menuDao.updateByPrimaryKeySelective(currentMenu);
		}
	}

	// 获取菜单树结构 [easyui treeNode]
	@Override
	public List<EasyUITreeNode> selectEasyUITreeNodes() {
		List<EasyUITreeNode> treeNodes = new ArrayList<EasyUITreeNode>();
		// 查询出一级菜单按order排序
		MenuExam exam = new MenuExam();
		exam.setOrderByClause("menu_order");
		exam.or().andParentIdEqualTo(0L);
		List<Menu> firstMenus = menuDao.selectByExample(exam);

		EasyUITreeNode node = null;
		List<EasyUITreeNode> children = null;
		List<Menu> secondMenus = null;
		EasyUITreeNode child = null;
		// 处理一级菜单的转换
		for (Menu menu : firstMenus) {
			node = new EasyUITreeNode();
			node.setText(menu.getMenuName());
			node.setId(menu.getId().toString());
			node.setState("closed");
			exam = new MenuExam();
			exam.setOrderByClause("menu_order"); // 排序
			exam.or().andParentIdEqualTo(menu.getId());
			secondMenus = selectByExample(exam);

			// 处理二级菜单转化
			if (CollectionUtils.isNotEmpty(secondMenus)) {
				children = new ArrayList<EasyUITreeNode>();
				for (Menu menu2 : secondMenus) {
					child = new EasyUITreeNode();
					child.setId(menu2.getId().toString());
					child.setText(menu2.getMenuName());
					children.add(child);
				}
				node.setChildren(children); // 一级菜单添加二级菜单
				treeNodes.add(node); // 一级菜单添加进菜单list
			}
		}

		return treeNodes;
	}

	// 查询最大的权限位
	@Override
	public Integer selectMaxPrivilegePos() {
		return menuDao.selectMaxPrivilegePos();
	}

	// 查询指定用户的所有菜单
	@Override
	public List<Menu> selectUserMenus(Long userId) {
		// 根据userId对应的所有roleId
		UserRoleExam exam = new UserRoleExam();
		exam.or().andUserIdEqualTo(userId);
		List<UserRole> userRoles = roleUserDao.selectByExample(exam);
		List<Long> roleIds = new ArrayList<Long>();
		for (UserRole ur : userRoles) {
			roleIds.add(ur.getRoleId());
		}

		if (!roleIds.isEmpty()) {
			return roleMenuCascadeDao.selectMenusByRoleIds(roleIds);
		} else {
			return new ArrayList<Menu>();
		}
	}

}
