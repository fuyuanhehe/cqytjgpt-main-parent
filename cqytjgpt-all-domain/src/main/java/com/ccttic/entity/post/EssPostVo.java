package com.ccttic.entity.post;

import java.util.List;

import com.ccttic.entity.employee.EssEmployee;

public class EssPostVo extends EssPost {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//组织名
	private String orgNm;
	//部门名
	private String depNm;
	//员工名
	private List<EssEmployee> emp;
	private int page = 1;
	private int rows = 10;
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
	public String getOrgNm() {
		return orgNm;
	}
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	public String getDepNm() {
		return depNm;
	}
	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}
	public List<EssEmployee> getEmp() {
		return emp;
	}
	public void setEmp(List<EssEmployee> emp) {
		this.emp = emp;
	}
	public EssPostVo(String orgNm, String depNm, List<EssEmployee> emp) {
		super();
		this.orgNm = orgNm;
		this.depNm = depNm;
		this.emp = emp;
	}
	public EssPostVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
