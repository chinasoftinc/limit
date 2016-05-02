package com.athena.module.areas.model;

import java.math.BigDecimal;

import com.athena.common.base.entity.PageModel;

public class Area extends PageModel<Area> {
	private static final long serialVersionUID = 7104243818301795374L;

	private BigDecimal id;

	// 地区名称
	private String areasName;

	// 地区首字母 (中文取拼音首字母)
	private String areasHeadLetter;

	// 上级ID
	private BigDecimal areasParentId;

	// 排序(排序只参与同上级, 同路径深度排序, 默认为取最大的排序)
	private Short areasSortNo;

	// 地区路径深度, 如江苏省和上海市为0级地区
	private Short areasDeep;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getAreasName() {
		return areasName;
	}

	public void setAreasName(String areasName) {
		this.areasName = areasName == null ? null : areasName.trim();
	}

	public String getAreasHeadLetter() {
		return areasHeadLetter;
	}

	public void setAreasHeadLetter(String areasHeadLetter) {
		this.areasHeadLetter = areasHeadLetter == null ? null : areasHeadLetter.trim();
	}

	public BigDecimal getAreasParentId() {
		return areasParentId;
	}

	public void setAreasParentId(BigDecimal areasParentId) {
		this.areasParentId = areasParentId;
	}

	public Short getAreasSortNo() {
		return areasSortNo;
	}

	public void setAreasSortNo(Short areasSortNo) {
		this.areasSortNo = areasSortNo;
	}

	public Short getAreasDeep() {
		return areasDeep;
	}

	public void setAreasDeep(Short areasDeep) {
		this.areasDeep = areasDeep;
	}
}