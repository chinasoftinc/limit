package limit.module.dictionary.model;

import java.util.List;

import limit.common.base.entity.PageModel;

/**
 * 选项字典
 * @author niebinxiao
 */
public class OptDic extends PageModel<OptDic> {
	private static final long serialVersionUID = 6550637525172413165L;

	private Long id;
	// 选项字典名称
	private String optName;
	// 选项字典值, 存储值
	private String optKey;
	// 选项字典展示值
	private String optVal;
	// 所属父选项id
	private Long parentId;
	// 选项说明
	private String description;

	// ---------------------------

	// 子选项集合
	private List<OptDic> children;

	// ---------------------------

	public List<OptDic> getChildren() {
		return children;
	}

	public void setChildren(List<OptDic> children) {
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getOptVal() {
		return optVal;
	}

	public void setOptVal(String optVal) {
		this.optVal = optVal == null ? null : optVal.trim();
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

}
