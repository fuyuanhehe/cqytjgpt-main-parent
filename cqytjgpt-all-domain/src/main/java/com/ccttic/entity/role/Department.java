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
	private String orgId;
	// 机构编码
	private String orgCd;
	// 企业id
	private String eptId;
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
	// 显示顺序
	private String dispOrder;
	
	public Department() {
		super();
	}
	
	public Department(String id, String orgId, String orgCd, String eptId, String depNm, String depShortNm,
			String depCd, String depDuty, String remark, String dispOrder) {
		super();
		this.id = id;
		this.orgId = orgId;
		this.orgCd = orgCd;
		this.eptId = eptId;
		this.depNm = depNm;
		this.depShortNm = depShortNm;
		this.depCd = depCd;
		this.depDuty = depDuty;
		this.remark = remark;
		this.dispOrder = dispOrder;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String getDispOrder() {
		return dispOrder;
	}

	public void setDispOrder(String dispOrder) {
		this.dispOrder = dispOrder;
	}

	public String getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}

	@Override
	public String toString() {
		return "Department [orgId=" + orgId + ", eptId=" + eptId + ", depNm=" + depNm 
				+ ", depShortNm=" + depShortNm+ ", depCd=" + depCd+ ", remark=" + remark+ ", dispOrder=" + dispOrder
				+", orgCd=" + orgCd +", id=" + id + "]";
	}
	
}
