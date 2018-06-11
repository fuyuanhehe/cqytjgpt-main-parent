package com.ccttic.entity.drivers.vo;

import com.ccttic.entity.drivers.dr_illicit;


// 自定义驾驶员违法Vo
public class DriverillicitVo extends dr_illicit{
	// 驾驶员名字
	private String name;
	// 所属企业
	private String areaNm;
   
	// 所属区域
	private String etpNm;
	//违法时间
	//初次违法时间
	private String fiString;
	//最后违法时间
	private String laString;

	public DriverillicitVo() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public DriverillicitVo(String etpNm) {
		super();
		this.etpNm = etpNm;
	}




	public String getEtpNm() {
		return etpNm;
	}




	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}




	public DriverillicitVo(String name, String areaNm, String fiString, String laString) {
		super();
		this.name = name;
		this.areaNm = areaNm;
		this.fiString = fiString;
		this.laString = laString;
	}

	@Override
	public String toString() {
		return "DriverillicitVo [etpNm=" + etpNm + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaNm() {
		return areaNm;
	}

	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}

	public String getFiString() {
		return fiString;
	}

	public void setFiString(String fiString) {
		this.fiString = fiString;
	}

	public String getLaString() {
		return laString;
	}

	public void setLaString(String laString) {
		this.laString = laString;
	}


	

}
