package com.athena.module.rolemenu.model;

import java.math.BigDecimal;

import com.athena.common.base.entity.PageModel;

/**
 * 角色菜单关联
 * @author niebinxiao
 */
public class RoleMenu extends PageModel<RoleMenu> {
	private static final long serialVersionUID = 625031829353348939L;

	private BigDecimal id;

	// 菜单id
	private BigDecimal menuId;

	// 角色id
	private BigDecimal roleId;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getMenuId() {
		return menuId;
	}

	public void setMenuId(BigDecimal menuId) {
		this.menuId = menuId;
	}

	public BigDecimal getRoleId() {
		return roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}
}