package com.athena.module.roleuser.model;

import java.math.BigDecimal;

import com.athena.common.base.entity.PageModel;

public class RoleUser extends PageModel<RoleUser> {
	private static final long serialVersionUID = -1064844586696515264L;

	private BigDecimal id;

	// 用户id
	private BigDecimal userId;

	// 角色id
	private BigDecimal roleId;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getUserId() {
		return userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public BigDecimal getRoleId() {
		return roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}
}