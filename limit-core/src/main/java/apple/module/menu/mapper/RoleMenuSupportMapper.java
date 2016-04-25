package apple.module.menu.mapper;

import java.util.List;

import apple.module.menu.model.Menu;

/**
 * 角色菜单扩展mapper
 * @author niebinxiao
 */
public interface RoleMenuSupportMapper {

	/**
	 * 根据角色id集合查询所有菜单
	 * @param roleIds
	 * @return
	 */
	List<Menu> selectMenusByRoleIds(List<Long> roleIds);
}
