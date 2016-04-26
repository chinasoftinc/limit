package limit.common.dto;

import java.util.List;

/**
 * easyuiTree节点实体
 * @author Binxiao
 */
public class EasyUITreeNode {

	public static final String STATUS_CLOSE = "closed";
	public static final String STATUS_OPEN = "open";

	private String id;

	/** 节点名称 */
	private String text;

	/** 节点状态 , 展开还是搜索['open'||'closed'] */
	private String state;

	/** 是否选中 */
	private boolean checked;

	// 额外参数
	private String attributes;
	private String attributes2;
	private String attributes3;
	private String attributes4;
	private String attributes5;

	/** 子节点 */
	private List<EasyUITreeNode> children;

	public String getAttributes2() {
		return attributes2;
	}

	public void setAttributes2(String attributes2) {
		this.attributes2 = attributes2;
	}

	public String getAttributes3() {
		return attributes3;
	}

	public void setAttributes3(String attributes3) {
		this.attributes3 = attributes3;
	}

	public String getAttributes4() {
		return attributes4;
	}

	public void setAttributes4(String attributes4) {
		this.attributes4 = attributes4;
	}

	public String getAttributes5() {
		return attributes5;
	}

	public void setAttributes5(String attributes5) {
		this.attributes5 = attributes5;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public List<EasyUITreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<EasyUITreeNode> children) {
		this.children = children;
	}

}
