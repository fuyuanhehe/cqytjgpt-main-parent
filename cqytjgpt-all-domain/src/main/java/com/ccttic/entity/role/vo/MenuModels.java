package com.ccttic.entity.role.vo;

import java.util.List;

public class MenuModels {

	private String title;
	
	private String url;
	
	private String type;
	
	private String id;
	
	private String ids;
	
	private List<MenuModels> children;
	
	private int cen;
public MenuModels() {
	// TODO Auto-generated constructor stub
}
	public MenuModels(String title, String url, String type, String id, String ids,
			List<MenuModels> children, int cen) {
		super();
		this.title = title;
		this.url = url;
		this.type = type;
		this.id = id;
		this.ids = ids;
		this.children = children;
		this.cen = cen;
	}

	@Override
	public String toString() {
		return "MenuModels [title=" + title + ", url=" + url + ", type=" + type + ", id=" + id
				+ ", ids=" + ids + ", children=" + children + ", cen=" + cen + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<MenuModels> getChildren() {
		return children;
	}

	public void setChildren(List<MenuModels> children) {
		this.children = children;
	}

	public int getCen() {
		return cen;
	}

	public void setCen(int cen) {
		this.cen = cen;
	}
	
	
	
	
	
	
}
