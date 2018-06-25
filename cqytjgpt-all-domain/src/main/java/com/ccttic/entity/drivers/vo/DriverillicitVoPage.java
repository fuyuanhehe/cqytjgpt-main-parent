package com.ccttic.entity.drivers.vo;

import com.ccttic.entity.drivers.vo.DriverillicitVo;

public class DriverillicitVoPage extends DriverillicitVo {
	private int page = 1;
	private int rows = 10;

	public DriverillicitVoPage() {
		// TODO Auto-generated constructor stub
	}


	public DriverillicitVoPage(int page, int rows) {
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
