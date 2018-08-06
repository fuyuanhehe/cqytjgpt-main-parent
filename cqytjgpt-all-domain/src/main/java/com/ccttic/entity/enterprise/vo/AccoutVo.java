package com.ccttic.entity.enterprise.vo;

public class AccoutVo {
	private String orgId;
	private String eptId;
	
	public AccoutVo() {
		super();
	}
	public AccoutVo(String orgId, String eptId) {
		super();
		this.orgId = orgId;
		this.eptId = eptId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getEptId() {
		return eptId;
	}
	public void setEptId(String eptId) {
		this.eptId = eptId;
	}
	
}
