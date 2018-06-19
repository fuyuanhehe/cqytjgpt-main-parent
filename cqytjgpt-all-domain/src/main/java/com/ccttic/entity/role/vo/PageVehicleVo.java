package com.ccttic.entity.role.vo;

import com.ccttic.entity.role.Vehicle;

public class PageVehicleVo extends Vehicle {
	private static final long serialVersionUID = -5701790298734958591L;
	private int page = 1;
	private int rows = 10;
	
	public PageVehicleVo() {
		super();
	}
	public PageVehicleVo(int page, int rows) {
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
