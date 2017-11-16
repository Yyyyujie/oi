package cn.zx.tool;

import java.util.List;

public class DeptList {
	private Integer value;
	private String text;
	private List<DeptList> children;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<DeptList> getChildren() {
		return children;
	}
	public void setChildren(List<DeptList> children) {
		this.children = children;
	}
	
	
}
