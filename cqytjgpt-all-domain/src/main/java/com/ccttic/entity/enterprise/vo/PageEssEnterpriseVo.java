package com.ccttic.entity.enterprise.vo;

import com.ccttic.entity.enterprise.EssEnterprise;

public class PageEssEnterpriseVo extends EssEnterprise{

	private static final long serialVersionUID = -6269491766542768674L;
	private int page = 1;
	private int rows = 10;
	
	public PageEssEnterpriseVo() {
		super();
	}
	public PageEssEnterpriseVo(int page, int rows) {
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
