package com.ccttic.entity.role.vo;

import com.ccttic.entity.BaseBean;
import com.ccttic.entity.role.Vehicle;

import java.io.Serializable;

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
