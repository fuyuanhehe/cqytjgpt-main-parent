package com.ccttic.entity.danger.vo;

import com.ccttic.entity.danger.VehiDanger;

public class VehiDangerVo extends VehiDanger{

	private static final long serialVersionUID = 6867685586075527725L;
	private int page = 1;
	private int rows = 10;
	
	public VehiDangerVo() {
		super();
	}
	public VehiDangerVo(int page, int rows) {
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
