package apple.module.user.model;

import apple.common.base.entity.AbstractModel;

/**
 * 角色model
 * @author Binxiao
 */
public class Role extends AbstractModel<Role> {
	private static final long serialVersionUID = 3199695445228391182L;
	private Long id;
	// 角色说明
	private String description;
	// 角色名称
	private String rolename;

	// --------------------------

	// 权限ID字符串, 逗号分割
	transient String privilegeIds;

	// --------------------------
	public String getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename == null ? null : rolename.trim();
	}

}
