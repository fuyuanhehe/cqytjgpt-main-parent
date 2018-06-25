package com.ccttic.entity.drivers.vo;

public class vehiclesVoPage extends vehiclesVo {
	private int page = 1;
	private int rows = 10;
	
	public vehiclesVoPage() {
		// TODO Auto-generated constructor stub
	}

	public vehiclesVoPage(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "vehiclesVoPage [page=" + page + ", rows=" + rows + "]";
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
