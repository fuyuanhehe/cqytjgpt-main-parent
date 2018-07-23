package com.ccttic.entity.drivers.vo;


import java.util.List;

import com.ccttic.entity.drivers.ess_enterprise;
// 企业自定义实体
public  class EnterprisethenVo extends ess_enterprise{
   
	//区县  所辖运所
	private String orgNm;
	// 所属行政辖划分
	private String areaNm;
	//状态
	private String state;
	//电话
	private String etpTel;
	//地址
	private String etpAdress;
	//企业id
	private List<String> qid;
	//账号类型
	private String empType;
	


	public List<String> getQid() {
		return qid;
	}


	public void setQid(List<String> qid) {
		this.qid = qid;
	}


	public String getEmpType() {
		return empType;
	}


	public void setEmpType(String empType) {
		this.empType = empType;
	}


	public EnterprisethenVo() {
	}


	public EnterprisethenVo(String orgNm, String areaNm, String state, String etpTel,
			String etpAdress) {
		super();
		this.orgNm = orgNm;
		this.areaNm = areaNm;
		this.state = state;
		this.etpTel = etpTel;
		this.etpAdress = etpAdress;
	}


	@Override
	public String toString() {
		return "EnterprisethenVo [orgNm=" + orgNm + ", areaNm=" + areaNm + ", state=" + state
				+ ", etpTel=" + etpTel + ", etpAdress=" + etpAdress + "]";
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getEtpTel() {
		return etpTel;
	}


	public void setEtpTel(String etpTel) {
		this.etpTel = etpTel;
	}


	public String getEtpAdress() {
		return etpAdress;
	}


	public void setEtpAdress(String etpAdress) {
		this.etpAdress = etpAdress;
	}


	
	
}
