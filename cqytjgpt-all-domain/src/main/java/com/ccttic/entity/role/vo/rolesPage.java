package com.ccttic.entity.role.vo;

import java.util.List;

import com.ccttic.entity.role.Roles;

public class rolesPage extends Roles {

	private int page = 1;
	private int rows = 10;
	
	public rolesPage() {
		
	}

	public rolesPage(List<String> emporIds, int page, int rows) {
		super(emporIds);
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
