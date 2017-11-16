package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class TreeModel {
	private String id;
	private String text;//名称
	private String iconCls;//图标
	private String linkUrl;//链接地址

	private List<TreeModel> children;// 孩子节点集合 

	public TreeModel(){
		this.children=new ArrayList<TreeModel>();
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

	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}
	
	
	
}
