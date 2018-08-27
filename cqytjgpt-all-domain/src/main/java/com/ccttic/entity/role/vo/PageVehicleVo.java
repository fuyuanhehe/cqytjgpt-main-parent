package com.ccttic.entity.role.vo;

import java.util.List;

import com.ccttic.entity.role.Vehicle;

public class PageVehicleVo extends Vehicle {
	private static final long serialVersionUID = -5701790298734958591L;
	private int page = 1;
	private int rows = 10;
	private List<String> list;
	private String empType;
	private String orgNm;
	private String entNm;
	public PageVehicleVo() {
		super();
	}

	public PageVehicleVo(int page, int rows, List<String> list, String empType, String orgNm, String entNm) {
		super();
		this.page = page;
		this.rows = rows;
		this.list = list;
		this.empType = empType;
		this.orgNm = orgNm;
		this.entNm = entNm;
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

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public String getEntNm() {
		return entNm;
	}

	public void setEntNm(String entNm) {
		this.entNm = entNm;
	}
	
}
