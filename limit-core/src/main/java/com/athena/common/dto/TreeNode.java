package com.athena.common.dto;

import java.util.List;

/**
 * @author Binxiao
 */
public class TreeNode {

	public static final String CLOSE = "closed";
	public static final String OPEN = "open";

	private String id;

	// 节点名称
	private String text;

	// 节点状态: [open:展开,closed:折叠]
	private String state;

	// 是否是选中状态
	private boolean checked;

	// 额外参数
	private String attributes1;
	private String attributes2;
	private String attributes3;
	private String attributes4;
	private String attributes5;

	// 子节点
	private List<TreeNode> children;

	public String getAttributes1() {
		return attributes1;
	}

	public void setAttributes1(String attributes1) {
		this.attributes1 = attributes1;
	}

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

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

}
