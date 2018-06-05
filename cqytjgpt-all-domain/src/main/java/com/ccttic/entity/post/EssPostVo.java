package com.ccttic.entity.post;

import java.util.List;

import com.ccttic.entity.employee.EssEmployee;

public class EssPostVo extends EssPost {
	//组织名
	private String orgNm;
	//部门名
	private String depNm;
	//员工名
	private List<EssEmployee> emp;
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
