package com.ccttic.entity.drivers.vo;

import com.ccttic.entity.drivers.Driver;

public class DriverVo  extends Driver{
    //所属区域
	private String areaNm;
	// 所属企业
	private String etpNm;
	
	public DriverVo() {
		// TODO Auto-generated constructor stub
	}

	public DriverVo(String areaNm, String etpNm) {
		super();
		this.areaNm = areaNm;
		this.etpNm = etpNm;
	}


	@Override
	public String toString() {
		return "DriverVo [areaNm=" + areaNm + ", etpNm=" + etpNm + "]";
	}

	public String getAreaNm() {
		return areaNm;
	}

	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}

	public String getEtpNm() {
		return etpNm;
	}

	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}
	
	
}
