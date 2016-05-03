package com.athena.module.dictionaries.model;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.entity.PageModel;

public class Dictionary extends PageModel<Dictionary> {
	private static final long serialVersionUID = 9069565159348340912L;

	private BigDecimal id;

	// 字典或参数名称
	private String optName;

	// 字典散列键
	private String optKey;

	// 字典散列值或参数值
	private String optValue;

	// 上级ID
	private BigDecimal optParentId;

	// 说明
	private String optDescription;

	// 排序(排序只参与同上级, 同路径深度排序, 默认为取最大的排序)
	private Short optSortNo;

	// 是否是目录 (0:否, 1:是)
	private String optIsDir;

	// 类型 (0:参数, 1:选项字典, 2:选项组)
	private String optType;

	// 路径深度( starts 0)
	private Short optDeep;

	// 子选项集合
	private List<Dictionary> children;

	public List<Dictionary> getChildren() {
		return children;
	}

	public void setChildren(List<Dictionary> children) {
		this.children = children;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName == null ? null : optName.trim();
	}

	public String getOptKey() {
		return optKey;
	}

	public void setOptKey(String optKey) {
		this.optKey = optKey == null ? null : optKey.trim();
	}

	public String getOptValue() {
		return optValue;
	}

	public void setOptValue(String optValue) {
		this.optValue = optValue == null ? null : optValue.trim();
	}

	public BigDecimal getOptParentId() {
		return optParentId;
	}

	public void setOptParentId(BigDecimal optParentId) {
		this.optParentId = optParentId;
	}

	public String getOptDescription() {
		return optDescription;
	}

	public void setOptDescription(String optDescription) {
		this.optDescription = optDescription == null ? null : optDescription.trim();
	}

	public Short getOptSortNo() {
		return optSortNo;
	}

	public void setOptSortNo(Short optSortNo) {
		this.optSortNo = optSortNo;
	}

	public String getOptIsDir() {
		return optIsDir;
	}

	public void setOptIsDir(String optIsDir) {
		this.optIsDir = optIsDir == null ? null : optIsDir.trim();
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType == null ? null : optType.trim();
	}

	public Short getOptDeep() {
		return optDeep;
	}

	public void setOptDeep(Short optDeep) {
		this.optDeep = optDeep;
	}
}