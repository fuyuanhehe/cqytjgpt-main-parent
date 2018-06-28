package com.ccttic.entity.danger.vo;

import java.util.List;

import com.ccttic.entity.danger.VehiDanger;

public class VehiDangerVo extends VehiDanger{

	private static final long serialVersionUID = 6867685586075527725L;
	private int page = 1;
	private int rows = 10;
	private List<String> list;
	private String areaId;
	
	public VehiDangerVo() {
		super();
	}

	public VehiDangerVo(int page, int rows, List<String> list, String areaId) {
		super();
		this.page = page;
		this.rows = rows;
		this.list = list;
		this.areaId = areaId;
	}


	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	
}