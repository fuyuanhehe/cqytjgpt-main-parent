package com.ccttic.entity.drivers.vo;

import com.ccttic.entity.drivers.vo.EnterprisethenVo;

public class EnterprisethenVoPage extends EnterprisethenVo {

	private int page = 1;
	private int rows = 10;
	
	public EnterprisethenVoPage() {
	}

	public EnterprisethenVoPage(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "EnterprisethenVoPage [page=" + page + ", rows=" + rows + "]";
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
