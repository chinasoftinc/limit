package apple.module.user.model;

import java.util.Date;

import apple.common.base.entity.AbstractModel;

/**
 * 系统管理员实体
 * @author niebx
 */
public class User extends AbstractModel<User> {
	private static final long serialVersionUID = -8280432662555125485L;
	private Long id;
	// 昵称
	private String nickname;
	// 密码
	private String password;
	// 用户名
	private String username;
	// 状态 1:正常; 0:停用; 9:超级管理员; -1:不存在或错误
	private String status;
	// 邮箱
	private String email;
	// 最后一次访问时间
	private Date lastAccessTime;
	// 最后一次访问IP
	private String lastAccessAdress;
	// 创建者ID
	private Long createUserId;
	// 创建时间
	private Date createTime;

	// -----------------------------

	// 每个privilegPos的privilegeCode总和的数组, 即每个权限位的权限码总和数组
	private long[] privilegeSum;

	// 用户角色名 [空格分割, 给展示层显示] [用于添加/更新用户的角色id传递, 逗号分割]
	private transient String roles;

	// 查询的角色ID, 作为条件, 不能transient
	private Long searchRoleId;

	// -----------------------------

	public long[] getPrivilegeSum() {
		return privilegeSum;
	}

	public void setPrivilegeSum(long[] privilegeSum) {
		this.privilegeSum = privilegeSum;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Long getSearchRoleId() {
		return searchRoleId;
	}

	public void setSearchRoleId(Long searchRoleId) {
		this.searchRoleId = searchRoleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public String getLastAccessAdress() {
		return lastAccessAdress;
	}

	public void setLastAccessAdress(String lastAccessAdress) {
		this.lastAccessAdress = lastAccessAdress == null ? null : lastAccessAdress.trim();
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}