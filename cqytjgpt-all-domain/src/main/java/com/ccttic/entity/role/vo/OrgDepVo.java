package com.ccttic.entity.role.vo;

import java.io.Serializable;

//自定义 组织机构和部门尸体
public class OrgDepVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8498570941649191754L;

	private String orgId;
	
	private String orgNm;
	
	private String depId;
	
	private String depNm;
	
	public OrgDepVo() {
	}

	public OrgDepVo(String orgId, String orgNm, String depId, String depNm) {
		super();
		this.orgId = orgId;
		this.orgNm = orgNm;
		this.depId = depId;
		this.depNm = depNm;
	}

	@Override
	public String toString() {
		return "OrgDepVo [orgId=" + orgId + ", orgNm=" + orgNm + ", depId=" + depId + ", depNm="
				+ depNm + "]";
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepNm() {
		return depNm;
	}

	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}
	
	
	
	
}
