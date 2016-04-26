package limit.module.user.model;

import limit.common.base.entity.AbstractModel;

public class UserRole extends AbstractModel<UserRole> {
	private static final long serialVersionUID = -2414353945313729861L;
	private Long id;
	// 用户id
	private Long userId;
	// 角色id
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
