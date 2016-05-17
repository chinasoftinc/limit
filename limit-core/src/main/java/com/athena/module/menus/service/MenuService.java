package com.athena.module.menus.service;

import java.math.BigDecimal;
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
	int insertMenu(Menu menu);

	/**
	 * 删除菜单
	 * @param id
	 */
	void removeMenu(BigDecimal id);

	/**
	 * 交换两个菜单的排序位置
	 * @param menuId
	 * @param direction
	 */
	void updateMenuPos(BigDecimal menuId, Direction direction);

	/**
	 * 获取菜单树结构 [easyui treeNode]
	 * @return
	 */
	List<TreeNode> selectEasyUITreeNodes();

	/**
	 * 查询指定用户的所有菜单
	 * @param userId
	 * @return
	 */
	List<Menu> selectUserMenus(BigDecimal userId);

	/**
	 * 更新菜单
	 * @param form
	 */
	int updateMenu(Menu form);

	/**
	 * 查询最大权限位
	 * @return
	 */
	Long selectMaxPrivilegePos();
}
