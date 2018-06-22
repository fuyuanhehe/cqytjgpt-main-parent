package com.ccttic.entity.drivers.vo;


import com.ccttic.entity.drivers.ess_enterprise;
// 企业自定义实体
public abstract class EnterprisethenVo extends ess_enterprise{
   
	//区县  所辖运所
	private String orgNm;
	// 所属行政辖划分
	private String areaNm;
	
	
	
	public EnterprisethenVo() {
	}



	public EnterprisethenVo(String orgNm, String areaNm) {
		super();
		this.orgNm = orgNm;
		this.areaNm = areaNm;
	}



	@Override
	public String toString() {
		return "EnterprisethenVo [orgNm=" + orgNm + ", areaNm=" + areaNm + "]";
	}



	public String getOrgNm() {
		return orgNm;
	}



	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}



	public String getAreaNm() {
		return areaNm;
	}



	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}
	
	
	
}
