package com.athena.module.menus.model;

import java.math.BigDecimal;
import java.util.List;
import com.athena.common.base.entity.PageModel;

/**
 * 菜单
 * @author niebinxiao
 */
public class Menu extends PageModel<Menu> {
	private static final long serialVersionUID = 4344290954506492638L;

	private BigDecimal id;

	// 菜单名称
	private String menuName;

	// 菜单url
	private String menuUrl;

	// 上级id
	private BigDecimal menuParentId;

	// 权限码
	private Long menuPrivilegeCode;

	// 权限位
	private Long menuPrivilegePos;

	// 详细说明
	private String menuDescription;

	// 排序
	private Short menuSortNo;

	// 子菜单集合
	private List<Menu> children;

	// 父菜单名称
	private String parentName;

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl == null ? null : menuUrl.trim();
	}

	public BigDecimal getMenuParentId() {
		return menuParentId;
	}

	public void setMenuParentId(BigDecimal menuParentId) {
		this.menuParentId = menuParentId;
	}

	public Long getMenuPrivilegeCode() {
		return menuPrivilegeCode;
	}

	public void setMenuPrivilegeCode(Long menuPrivilegeCode) {
		this.menuPrivilegeCode = menuPrivilegeCode;
	}

	public Long getMenuPrivilegePos() {
		return menuPrivilegePos;
	}

	public void setMenuPrivilegePos(Long menuPrivilegePos) {
		this.menuPrivilegePos = menuPrivilegePos;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription == null ? null : menuDescription.trim();
	}

	public Short getMenuSortNo() {
		return menuSortNo;
	}

	public void setMenuSortNo(Short menuSortNo) {
		this.menuSortNo = menuSortNo;
	}

}