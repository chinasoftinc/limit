package limit.module.menu.service;

import java.util.List;

import limit.common.base.service.Service;
import limit.common.dto.EasyUITreeNode;
import limit.module.menu.model.Menu;
import limit.module.menu.model.MenuExam;
import limit.module.menu.service.MenuServiceImp.Direction;

/**
 * 菜单业务层
 * @author niebinxiao
 */
public interface MenuService extends Service<Menu, MenuExam> {

	/**
	 * 获取菜单的树结构 [easyui treeGrid]
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
	List<EasyUITreeNode> selectEasyUITreeNodes();

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
