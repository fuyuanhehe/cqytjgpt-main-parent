package com.ccttic.entity.role;

import java.io.Serializable;

/**
功能说明：     企业基本信息
@author  admin
@see  com.ccttic.entity.role.Enterprise.java
@date  2018年5月30日
*/
public class Enterprise implements Serializable{
	private static final long serialVersionUID = -8991984368056005329L;
	// id 
	private String id;
	// 所属机构Id
	private String org_id;
	// 企业编码
	private String etpCd;
	// 企业名称
	private String etpNm;
	// 企业简称
	private String etpshortNm;
	// 企业法人
	private String etpLawer;
	// 法人电话
	private String lawerTel;
	// 安全责任人
	private String etpSafer;
	// 责任人电话
	private String saferTel;
	// 所属交巡警大队
	private String ownerTraffic;
	// 所属运管所
	private String ownerTransport;
	
	public Enterprise() {
		super();
	}

	public Enterprise(String id, String org_id, String etpCd, String etpNm, String etpshortNm, String etpLawer,
			String lawerTel, String etpSafer, String saferTel, String ownerTraffic, String ownerTransport) {
		super();
		this.id = id;
		this.org_id = org_id;
		this.etpCd = etpCd;
		this.etpNm = etpNm;
		this.etpshortNm = etpshortNm;
		this.etpLawer = etpLawer;
		this.lawerTel = lawerTel;
		this.etpSafer = etpSafer;
		this.saferTel = saferTel;
		this.ownerTraffic = ownerTraffic;
		this.ownerTransport = ownerTransport;
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

	public String getEtpCd() {
		return etpCd;
	}

	public void setEtpCd(String etpCd) {
		this.etpCd = etpCd;
	}

	public String getEtpNm() {
		return etpNm;
	}

	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}

	public String getEtpshortNm() {
		return etpshortNm;
	}

	public void setEtpshortNm(String etpshortNm) {
		this.etpshortNm = etpshortNm;
	}

	public String getEtpLawer() {
		return etpLawer;
	}

	public void setEtpLawer(String etpLawer) {
		this.etpLawer = etpLawer;
	}

	public String getLawerTel() {
		return lawerTel;
	}

	public void setLawerTel(String lawerTel) {
		this.lawerTel = lawerTel;
	}

	public String getEtpSafer() {
		return etpSafer;
	}

	public void setEtpSafer(String etpSafer) {
		this.etpSafer = etpSafer;
	}

	public String getSaferTel() {
		return saferTel;
	}

	public void setSaferTel(String saferTel) {
		this.saferTel = saferTel;
	}

	public String getOwnerTraffic() {
		return ownerTraffic;
	}

	public void setOwnerTraffic(String ownerTraffic) {
		this.ownerTraffic = ownerTraffic;
	}

	public String getOwnerTransport() {
		return ownerTransport;
	}

	public void setOwnerTransport(String ownerTransport) {
		this.ownerTransport = ownerTransport;
	}
	
	@Override
	public String toString() {
		return "Enterprise [org_id=" + org_id + ", etpCd=" + etpCd + ", etpNm=" + etpNm + ", etpshortNm=" + etpshortNm
				+ ", etpLawer=" + etpLawer+ ", lawerTel=" + lawerTel+ ", etpSafer=" + etpSafer
				+ ", saferTel=" + saferTel+ ", ownerTraffic=" + ownerTraffic+ ", ownerTransport=" + ownerTransport +", id=" + id + "]";
	}
	
	
}
