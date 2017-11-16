package cn.zx.pojo;

import java.util.List;

public class ZTreeModel {
	private String id;
	private String pid;
	private String text;//名称
	private String iconCls;//图标
	private String linkUrl;//链接地址
	private List<ZTreeModel> children;// 孩子节点集合 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public List<ZTreeModel> getChildren() {
		return children;
	}
	public void setChildren(List<ZTreeModel> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "ZTreeModel [id=" + id + ", pid=" + pid + ", text=" + text + ", iconCls=" + iconCls + ", linkUrl="
				+ linkUrl + ", children=" + children + ", getId()=" + getId() + ", getPid()=" + getPid()
				+ ", getText()=" + getText() + ", getIconCls()=" + getIconCls() + ", getLinkUrl()=" + getLinkUrl()
				+ ", getChildren()=" + getChildren() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

	
	
	
	
}
