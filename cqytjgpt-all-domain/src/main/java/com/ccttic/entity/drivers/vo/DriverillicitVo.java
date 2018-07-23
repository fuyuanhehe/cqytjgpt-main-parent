package com.ccttic.entity.drivers.vo;

import java.util.List;

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
   //企业id
   private List<String> qid;
   
   private String empType;
   
   private String  drIllicitState;
   
   
	public String getDrIllicitState() {
	return drIllicitState;
}
public void setDrIllicitState(String drIllicitState) {
	this.drIllicitState = drIllicitState;
}
	public String getEmpType() {
	return empType;
}
public void setEmpType(String empType) {
	this.empType = empType;
}
	public DriverillicitVo() {
		// TODO Auto-generated constructor stub
	}
	public DriverillicitVo(String name, String areaNm, String etpNm, String fiString,
			String laString, List<String> qid) {
		super();
		this.name = name;
		this.areaNm = areaNm;
		this.etpNm = etpNm;
		this.fiString = fiString;
		this.laString = laString;
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "DriverillicitVo [name=" + name + ", areaNm=" + areaNm + ", etpNm=" + etpNm
				+ ", fiString=" + fiString + ", laString=" + laString + ", qid=" + qid + "]";
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
	public String getEtpNm() {
		return etpNm;
	}
	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
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
	public List<String> getQid() {
		return qid;
	}
	public void setQid(List<String> qid) {
		this.qid = qid;
	}
	


	

}
