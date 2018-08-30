package com.ccttic.entity.role.vo;

import com.ccttic.entity.role.VehicleDispatch;

public class VehicleDispatchVo extends VehicleDispatch{
	private static final long serialVersionUID = 5381766980280917868L;
	private int page = 1;
	private int rows = 10;
	
	public VehicleDispatchVo() {
		super();
	}

	public VehicleDispatchVo(int page, int rows) {
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
