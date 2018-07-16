package com.ccttic.entity.enterprise;
//通用分页实体
public class Pages  extends TypeVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8900872307077646628L;

	private int page = 1;

	private int rows = 10;

	public Pages() {
	}

	public Pages(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Pages [page=" + page + ", rows=" + rows + "]";
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
