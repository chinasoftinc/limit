package limit.module.menu.model;

import limit.common.base.entity.PageModel;

/**
 * 角色菜单关联
 * @author Binxiao
 */
public class RoleMenu extends PageModel<RoleMenu> {
	private static final long serialVersionUID = -7320686147632179461L;

	private Long id;
	// 菜单id
	private Long menuId;
	// 角色id
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}