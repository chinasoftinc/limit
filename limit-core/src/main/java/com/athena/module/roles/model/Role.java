package com.athena.module.roles.model;

import java.math.BigDecimal;
import java.util.Date;

import com.athena.common.base.entity.PageModel;

/**
 * 角色
 * @author niebinxiao
 */
public class Role extends PageModel<Role> {
	private static final long serialVersionUID = -5434724051768825721L;

	private BigDecimal id;

	// 角色名称
	private String roleName;

	// 角色代码
	private String roleCode;

	// 角色详细信息
	private String roleDescription;

	// 是否删除(0:否,1:删)
	private String isDel;

	// 创建时间
	private Date createTime;

	// 最后更新时间
	private Date updateTime;

	// 创建者id
	private BigDecimal createUserid;

	// 最后
	private BigDecimal updateUserid;

	// 菜单id字符串
	transient String menus;
	
	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription == null ? null : roleDescription.trim();
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel == null ? null : isDel.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public BigDecimal getCreateUserid() {
		return createUserid;
	}

	public void setCreateUserid(BigDecimal createUserid) {
		this.createUserid = createUserid;
	}

	public BigDecimal getUpdateUserid() {
		return updateUserid;
	}

	public void setUpdateUserid(BigDecimal updateUserid) {
		this.updateUserid = updateUserid;
	}
}