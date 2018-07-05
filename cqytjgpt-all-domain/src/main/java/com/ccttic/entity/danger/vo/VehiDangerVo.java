package com.ccttic.entity.danger.vo;

import java.util.List;

import com.ccttic.entity.danger.VehiDanger;

public class VehiDangerVo extends VehiDanger{

	private static final long serialVersionUID = 6867685586075527725L;
	private int page = 1;
	private int rows = 10;
	private List<String> list;
	private String areaId;
	private String empType;
	private String orgNm;
	private String superNm;
	
	public VehiDangerVo() {
		super();
	}

	public VehiDangerVo(int page, int rows, List<String> list, String areaId, String empType, String orgNm,
			String superNm) {
		super();
		this.page = page;
		this.rows = rows;
		this.list = list;
		this.areaId = areaId;
		this.empType = empType;
		this.orgNm = orgNm;
		this.superNm = superNm;
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

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
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

	public String getSuperNm() {
		return superNm;
	}

	public void setSuperNm(String superNm) {
		this.superNm = superNm;
	}
	
	
}
