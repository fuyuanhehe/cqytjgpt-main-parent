package com.ccttic.entity.role;

import java.io.Serializable;

import com.ccttic.entity.BaseBean;

/**
功能说明：     组织机构信息
@author  admin
@see  com.ccttic.entity.role.Organization.java
@date  2018年5月30日
*/
public class Organization extends BaseBean implements Serializable{

	private static final long serialVersionUID = -2447025603755403233L;
	// id
	private String id;
	// 组织机构代码
	private String orgCd;
	// 组织机构名称
	private String orgNm;
	// 组织机构简称
	private String shortNm;
	// 备注
	private String remark;
	//部门职能
	private String orgDuty;
	//显示顺序
	private Integer dispOrder;
	//父组织机构ID
	private String superOrgId;
	// 机构类型 0机构 1企业 2部门
	private String orgType;
	
	public Organization() {
		super();
	}

	public Organization(String id, String orgCd, String orgNm, String shortNm, String remark, String orgDuty,
			Integer dispOrder, String superOrgId, String orgType) {
		super();
		this.id = id;
		this.orgCd = orgCd;
		this.orgNm = orgNm;
		this.shortNm = shortNm;
		this.remark = remark;
		this.orgDuty = orgDuty;
		this.dispOrder = dispOrder;
		this.superOrgId = superOrgId;
		this.orgType = orgType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public String getShortNm() {
		return shortNm;
	}

	public void setShortNm(String shortNm) {
		this.shortNm = shortNm;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrgDuty() {
		return orgDuty;
	}

	public void setOrgDuty(String orgDuty) {
		this.orgDuty = orgDuty;
	}

	public Integer getDispOrder() {
		return dispOrder;
	}

	public void setDispOrder(Integer dispOrder) {
		this.dispOrder = dispOrder;
	}

	public String getSuperOrgId() {
		return superOrgId;
	}

	public void setSuperOrgId(String superOrgId) {
		this.superOrgId = superOrgId;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	
	@Override
	public String toString() {
		return "Organization [orgCd=" + orgCd + ", orgNm=" + orgNm + ", shortNm=" + shortNm + ", remark=" + remark
				+ ", orgDuty=" + orgDuty+ ", dispOrder=" + dispOrder+ ", superOrgId=" + superOrgId
				+ ", orgType=" + orgType +", id=" + id + "]";
	}
}
