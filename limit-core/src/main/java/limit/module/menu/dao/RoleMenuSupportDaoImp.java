package limit.module.menu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import limit.module.menu.mapper.RoleMenuSupportMapper;
import limit.module.menu.model.Menu;

/**
 * 角色菜单级联dao实现
 * @author niebinxiao
 */
@Repository
public class RoleMenuSupportDaoImp implements RoleMenuSupportDao {

	@Autowired
	private RoleMenuSupportMapper roleMenuCascadeMapper;

	// 根据角色id集合查询所有菜单
	@Override
	public List<Menu> selectMenusByRoleIds(List<Long> roleIds) {
		return roleMenuCascadeMapper.selectMenusByRoleIds(roleIds);
	}

}
