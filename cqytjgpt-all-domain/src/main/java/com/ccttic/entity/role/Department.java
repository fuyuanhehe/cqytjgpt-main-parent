package com.ccttic.entity.role;

import java.io.Serializable;

/**
功能说明：     部门基本信息
@author  admin
@see  com.ccttic.entity.role.Department.java
@date  2018年5月30日
*/
public class Department implements Serializable{
	private static final long serialVersionUID = -8349678655503842856L;
	// id
	private String id;
	// 所属机构Id
	private String org_id;
	// 
	private String ept_id;
	// 部门名称
	private String depNm;
	// 部门简称
	private String depShortNm;
	// 部门编码
	private String depCd;
	// 部门职责
	private String depDuty;
	// 岗位名称
	private String remark;
	
	public Department() {
		super();
	}
	
	public Department(String id, String org_id, String ept_id, String depNm, String depShortNm, String depCd,
			String depDuty, String remark) {
		super();
		this.id = id;
		this.org_id = org_id;
		this.ept_id = ept_id;
		this.depNm = depNm;
		this.depShortNm = depShortNm;
		this.depCd = depCd;
		this.depDuty = depDuty;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getEpt_id() {
		return ept_id;
	}

	public void setEpt_id(String ept_id) {
		this.ept_id = ept_id;
	}

	public String getDepNm() {
		return depNm;
	}

	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}

	public String getDepShortNm() {
		return depShortNm;
	}

	public void setDepShortNm(String depShortNm) {
		this.depShortNm = depShortNm;
	}

	public String getDepCd() {
		return depCd;
	}

	public void setDepCd(String depCd) {
		this.depCd = depCd;
	}

	public String getDepDuty() {
		return depDuty;
	}

	public void setDepDuty(String depDuty) {
		this.depDuty = depDuty;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "Department [org_id=" + org_id + ", ept_id=" + ept_id + ", depNm=" + depNm 
				+ ", depShortNm=" + depShortNm+ ", depCd=" + depCd+ ", remark=" + remark
				+", id=" + id + "]";
	}
	
}
