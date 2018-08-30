package com.ccttic.entity.role.vo;

import java.io.Serializable;

import com.ccttic.entity.role.Vehicle;

/**
 * 机动车 基本信息
 * 
 * @author admin
 *
 */
public class VehicleVO extends Vehicle implements Serializable {
	//区域名
	private String areaNm;
	//企业名
	private String etpNm;
	//所有权
	private String etplawer;
	

	public String getEtplawer() {
		return etplawer;
	}

	public void setEtplawer(String etplawer) {
		this.etplawer = etplawer;
	}

	@Override
	public String getEtpNm() {
		return etpNm;
	}

	@Override
	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}

	@Override
	public String getAreaNm() {
		return areaNm;
	}

	@Override
	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}
}
