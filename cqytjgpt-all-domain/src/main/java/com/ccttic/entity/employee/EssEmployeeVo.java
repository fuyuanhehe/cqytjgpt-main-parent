package com.ccttic.entity.employee;

public class EssEmployeeVo extends EssEmployee {
	//部门名
	private String depNm;
	//组织名
	private String orgNm;
	public String getDepNm() {
		return depNm;
	}
	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}
	public String getOrgNm() {
		return orgNm;
	}
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	public EssEmployeeVo(String depNm, String orgNm) {
		super();
		this.depNm = depNm;
		this.orgNm = orgNm;
	}
	public EssEmployeeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
