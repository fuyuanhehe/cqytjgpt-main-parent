package com.ccttic.entity.drivers.vo;

public class DriverVoPage extends DriverVo {

	private int page = 1;
	private int rows = 10;
	
	 public DriverVoPage() {
	}
	 
	 

	public DriverVoPage(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}



	@Override
	public String toString() {
		return "rolesPage [page=" + page + ", rows=" + rows + "]";
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
