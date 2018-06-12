package com.ccttic.entity.role.vo;
// 树形菜单Vo

public class MenuVo {
	//自己ID
	private String id;
	//父id
	private String pId;
	//标题
	private String title;
	//菜单还是按钮
	private String type;
	//路径
	private String url;
	//层级
	private Integer cen;

	public MenuVo() {
	}

	public MenuVo(String id, String pId, String title, String type, String url, Integer cen) {
		super();
		this.id = id;
		this.pId = pId;
		this.title = title;
		this.type = type;
		this.url = url;
		this.cen = cen;
	}

	@Override
	public String toString() {
		return "MenuVo [id=" + id + ", pId=" + pId + ", title=" + title + ", type=" + type
				+ ", url=" + url + ", cen=" + cen + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCen() {
		return cen;
	}

	public void setCen(Integer cen) {
		this.cen = cen;
	}





}
