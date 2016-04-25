package apple.module.menu.model;

import java.util.List;

import apple.common.base.entity.AbstractModel;

/**
 * 菜单model
 * @author niebinxiao
 */
public class Menu extends AbstractModel<Menu> {
	private static final long serialVersionUID = 7730043709336850146L;

	private Long id;
	// 菜单名称
	private String menuName;
	// 菜单URL
	private String menuUrl;
	// 上级菜单id
	private Long parentId;
	// 权限码
	private Long privilegeCode;
	// 权限位
	private Integer privilegePos;
	// 菜单说明
	private String description;
	// 菜单排序
	private Integer menuOrder;

	// -----------------------------

	// 子菜单集合 [转化为json, 供easyui使用]
	private List<Menu> children;
	// 父菜单名称
	private String parentName;

	// -----------------------------

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getPrivilegeCode() {
		return privilegeCode;
	}

	public void setPrivilegeCode(Long privilegeCode) {
		this.privilegeCode = privilegeCode;
	}

	public Integer getPrivilegePos() {
		return privilegePos;
	}

	public void setPrivilegePos(Integer privilegePos) {
		this.privilegePos = privilegePos;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

}
