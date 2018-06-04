package com.ccttic.entity.post;

import java.util.List;

public class EssPostVo extends EssPost {
	//组织名
	private String orgNm;
	//部门名
	private String depNm;
	//员工名
	private List<String> empNm;
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
	public List<String> getEmpNm() {
		return empNm;
	}
	public void setEmpNm(List<String> empNm) {
		this.empNm = empNm;
	}
	public EssPostVo(String orgNm, String depNm, List<String> empNm) {
		super();
		this.orgNm = orgNm;
		this.depNm = depNm;
		this.empNm = empNm;
	}
	public EssPostVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
