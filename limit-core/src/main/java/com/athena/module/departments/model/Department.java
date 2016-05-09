package com.athena.module.departments.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.athena.common.base.entity.PageModel;

/**
 * 部门
 * @author niebinxiao
 */
public class Department extends PageModel<Department> {
	private static final long serialVersionUID = -8435144675258150493L;

	private BigDecimal id;

	// 代码
	private String deptCode;

	// 简称
	private String deptShortName;

	// 名称
	private String deptName;

	// 地区代码
	private BigDecimal deptAreaCode;

	// 区县代码
	private BigDecimal deptDistrictCode;

	// 部门备注
	private String deptDescription;

	// 类型(0:机构, 1:部门)
	private String deptType;

	// 上级id
	private BigDecimal deptParentId;

	// 下级数量
	private Short deptSubCount;

	// 排序
	private Short deptSortNo;

	// 路径深度
	private Short deptDeep;

	// 是否删除(0:未,1:删)
	private String isDel;

	// 创建时间
	private Date createTime;

	// 更新时间
	private Date updateTime;

	// 创建用户id
	private BigDecimal createUserid;

	// 更新用户id
	private BigDecimal updateUserid;

	// 版本号
	private BigDecimal versionNo;

	// 子部门或机构
	private List<Department> children;

	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode == null ? null : deptCode.trim();
	}

	public String getDeptShortName() {
		return deptShortName;
	}

	public void setDeptShortName(String deptShortName) {
		this.deptShortName = deptShortName == null ? null : deptShortName.trim();
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	public BigDecimal getDeptAreaCode() {
		return deptAreaCode;
	}

	public void setDeptAreaCode(BigDecimal deptAreaCode) {
		this.deptAreaCode = deptAreaCode;
	}

	public BigDecimal getDeptDistrictCode() {
		return deptDistrictCode;
	}

	public void setDeptDistrictCode(BigDecimal deptDistrictCode) {
		this.deptDistrictCode = deptDistrictCode;
	}

	public String getDeptDescription() {
		return deptDescription;
	}

	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription == null ? null : deptDescription.trim();
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType == null ? null : deptType.trim();
	}

	public BigDecimal getDeptParentId() {
		return deptParentId;
	}

	public void setDeptParentId(BigDecimal deptParentId) {
		this.deptParentId = deptParentId;
	}

	public Short getDeptSubCount() {
		return deptSubCount;
	}

	public void setDeptSubCount(Short deptSubCount) {
		this.deptSubCount = deptSubCount;
	}

	public Short getDeptSortNo() {
		return deptSortNo;
	}

	public void setDeptSortNo(Short deptSortNo) {
		this.deptSortNo = deptSortNo;
	}

	public Short getDeptDeep() {
		return deptDeep;
	}

	public void setDeptDeep(Short deptDeep) {
		this.deptDeep = deptDeep;
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

	public BigDecimal getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(BigDecimal versionNo) {
		this.versionNo = versionNo;
	}
}