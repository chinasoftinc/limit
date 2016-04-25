package apple.module.menu.dao;

import java.util.List;

import apple.module.menu.model.Menu;

/**
 * 角色菜单级联dao
 * @author niebinxiao
 */
public interface RoleMenuSupportDao {

	/**
	 * 根据角色id集合查询所有菜单
	 * @param roleIds
	 * @return
	 */
	List<Menu> selectMenusByRoleIds(List<Long> roleIds);
}
