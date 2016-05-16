package com.athena.module.menus.service;

import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.common.context.Constants.Direction;
import com.athena.common.dto.TreeNode;
import com.athena.module.menus.model.Menu;
import com.athena.module.menus.model.MenuExample;

public interface MenuService extends Service<Menu, MenuExample> {

	/**
	 * 获取菜单的树结构
	 * @return
	 */
	List<Menu> selectMenuTree();

	/**
	 * 添加菜单
	 * @param menu
	 */
	void insertMenu(Menu menu);

	/**
	 * 删除菜单
	 * @param id
	 */
	void deleteMenu(Long id);

	/**
	 * 交换两个菜单的排序位置
	 * @param menuId
	 * @param direction
	 */
	void updateMenuPos(Long menuId, Direction direction);

	/**
	 * 获取菜单树结构 [easyui treeNode]
	 * @return
	 */
	List<TreeNode> selectEasyUITreeNodes();

	/**
	 * 查询最大的权限位
	 * @return
	 */
	Integer selectMaxPrivilegePos();

	/**
	 * 查询指定用户的所有菜单
	 * @param userId
	 * @return
	 */
	List<Menu> selectUserMenus(Long userId);
}
