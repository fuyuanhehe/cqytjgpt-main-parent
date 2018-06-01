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
	// 行政区域代码
	private String areaCode;
	//显示顺序
	private Integer dispOrder;
	// 机构类型 0机构 1企业 2部门
	private String orgType;
	//父组织机构ID
	private String superOrgId;
	//父组织机构编号
	private String superOrgCd;
	//父组织机构名称
	private String superOrgNm;
	//父机构类型类型
	private String superOrgType;
	
	public Organization() {
		super();
	}

	public Organization(String id, String orgCd, String orgNm, String shortNm, String remark,String areaCode, Integer dispOrder,
			String orgType, String superOrgId, String superOrgCd, String superOrgNm, String superOrgType) {
		super();
		this.id = id;
		this.orgCd = orgCd;
		this.orgNm = orgNm;
		this.shortNm = shortNm;
		this.remark = remark;
		this.areaCode = areaCode;
		this.dispOrder = dispOrder;
		this.orgType = orgType;
		this.superOrgId = superOrgId;
		this.superOrgCd = superOrgCd;
		this.superOrgNm = superOrgNm;
		this.superOrgType = superOrgType;
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
	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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
	
	public String getSuperOrgCd() {
		return superOrgCd;
	}

	public void setSuperOrgCd(String superOrgCd) {
		this.superOrgCd = superOrgCd;
	}

	public String getSuperOrgNm() {
		return superOrgNm;
	}

	public void setSuperOrgNm(String superOrgNm) {
		this.superOrgNm = superOrgNm;
	}

	public String getSuperOrgType() {
		return superOrgType;
	}

	public void setSuperOrgType(String superOrgType) {
		this.superOrgType = superOrgType;
	}
	
	@Override
	public String toString() {
		return "Organization [orgCd=" + orgCd + ", orgNm=" + orgNm + ", shortNm=" + shortNm + ", remark=" + remark + ", areaCode=" + areaCode
				+ ", dispOrder=" + dispOrder + ", superOrgId=" + superOrgId + ", superOrgCd=" + superOrgCd 
				+ ", superOrgNm=" + superOrgNm + ", superOrgType=" + superOrgType + ", orgType=" + orgType +", id=" + id + "]";
	}
}
