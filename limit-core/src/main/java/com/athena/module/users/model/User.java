package com.athena.module.users.model;

import java.math.BigDecimal;
import java.util.Date;

import com.athena.common.base.entity.PageModel;

/**
 * 系统用户
 * @author niebinxiao
 */
public class User extends PageModel<User> {
	private static final long serialVersionUID = 7895485712712455973L;

	private BigDecimal id;

	// 用户登录名
	private String userName;

	// 用户密码
	private String passWord;

	// 用户昵称
	private String nickName;

	// 用户编码
	private String userCode;

	// 用户状态 (-1:不存在或错误, 0:停用, 1:启用, 2:超级管理员)
	private String userStatus;

	// 密码盐值(默认随机取部分用户名)
	private String passwdSalt;

	// 性别
	private String userSex;

	// 邮箱
	private String userEmail;

	// 电话
	private String userPhone;

	// 样式id
	private String cssId;

	// 角色id, 弃用, 用户和角色为多对多
	@Deprecated
	private BigDecimal roleId;

	// 部门id
	private BigDecimal departmentId;

	// 机构id
	private BigDecimal orgId;

	// 最后访问ip
	private String lastAccessIp;

	// 最后登录时间
	private Date lastLoginTime;

	// 最后访问时间
	private Date lastAccessTime;

	// 在线累计时长
	private Integer onlineTime;

	// 当前访问模块(记录展示名称)
	private String accessModule;

	// 是否已登录(0:否, 1:是)
	private String isLogin;

	// 是否删除(0:否, 1:删)
	private String isDel;

	// 创建时间
	private Date createTime;

	// 最后更新时间
	private Date updateTime;

	// 创建者id
	private BigDecimal createUserid;

	// 更新者id
	private BigDecimal updateUserid;

	private transient String roles;

	private long[] privilegeSum;

	private BigDecimal searchRoleId;

	private String deptName;

	private String orgName;

	public String getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public long[] getPrivilegeSum() {
		return privilegeSum;
	}

	public void setPrivilegeSum(long[] privilegeSum) {
		this.privilegeSum = privilegeSum;
	}

	public BigDecimal getSearchRoleId() {
		return searchRoleId;
	}

	public void setSearchRoleId(BigDecimal searchRoleId) {
		this.searchRoleId = searchRoleId;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord == null ? null : passWord.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus == null ? null : userStatus.trim();
	}

	public String getPasswdSalt() {
		return passwdSalt;
	}

	public void setPasswdSalt(String passwdSalt) {
		this.passwdSalt = passwdSalt == null ? null : passwdSalt.trim();
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex == null ? null : userSex.trim();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone == null ? null : userPhone.trim();
	}

	public String getCssId() {
		return cssId;
	}

	public void setCssId(String cssId) {
		this.cssId = cssId == null ? null : cssId.trim();
	}

	@Deprecated
	public BigDecimal getRoleId() {
		return roleId;
	}

	@Deprecated
	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

	public BigDecimal getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	public BigDecimal getOrgId() {
		return orgId;
	}

	public void setOrgId(BigDecimal orgId) {
		this.orgId = orgId;
	}

	public String getLastAccessIp() {
		return lastAccessIp;
	}

	public void setLastAccessIp(String lastAccessIp) {
		this.lastAccessIp = lastAccessIp == null ? null : lastAccessIp.trim();
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public Integer getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Integer onlineTime) {
		this.onlineTime = onlineTime;
	}

	public String getAccessModule() {
		return accessModule;
	}

	public void setAccessModule(String accessModule) {
		this.accessModule = accessModule == null ? null : accessModule.trim();
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