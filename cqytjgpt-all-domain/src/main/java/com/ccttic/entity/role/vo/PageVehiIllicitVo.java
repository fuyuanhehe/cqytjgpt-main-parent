package com.ccttic.entity.role.vo;

import com.ccttic.entity.role.VehiIllicit;

public class PageVehiIllicitVo extends VehiIllicit{
	private static final long serialVersionUID = -5437595901819895593L;
	private int page = 1;
	private int rows = 10;
	
	public PageVehiIllicitVo() {
		super();
	}
	public PageVehiIllicitVo(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
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
}
