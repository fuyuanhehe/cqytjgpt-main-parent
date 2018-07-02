package com.ccttic.entity.drivers.vo;

import java.util.List;

import com.ccttic.entity.drivers.Driver;

//自定义驾驶员Vo
public class DriverVo  extends Driver{
	//所属区域
	private String areaNm;
	// 所属企业
	private String etpNm;

	//初次领证时间
	private String fiString;
	//最后领证时间
	private String laString;

	//初次审核时期
	private String fistShString;
	//最后审核时期
	private String laShString;
   //企业id
    private List<String> qid;
     //账号类型
    private String empType;
    
    public DriverVo() {
		// TODO Auto-generated constructor stub
	}

	public DriverVo(String id, String name, String idcard, String telphone, String mobilephone,
			String adress, String permicar, String firstrecivetime, String mgrdepart,
			String mgrdepartareaid, String mgrenterpriseid, String nextexaminetime,
			String effectstarttime, String effectendtime, String examineeffectendtime,
			String scoretotal, String state, String areaNm, String etpNm, String fiString,
			String laString, String fistShString, String laShString, List<String> qid,
			String empType) {
		super(id, name, idcard, telphone, mobilephone, adress, permicar, firstrecivetime, mgrdepart,
				mgrdepartareaid, mgrenterpriseid, nextexaminetime, effectstarttime, effectendtime,
				examineeffectendtime, scoretotal, state);
		this.areaNm = areaNm;
		this.etpNm = etpNm;
		this.fiString = fiString;
		this.laString = laString;
		this.fistShString = fistShString;
		this.laShString = laShString;
		this.qid = qid;
		this.empType = empType;
	}

	@Override
	public String toString() {
		return "DriverVo [areaNm=" + areaNm + ", etpNm=" + etpNm + ", fiString=" + fiString
				+ ", laString=" + laString + ", fistShString=" + fistShString + ", laShString="
				+ laShString + ", qid=" + qid + ", empType=" + empType + "]";
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

	public String getFistShString() {
		return fistShString;
	}

	public void setFistShString(String fistShString) {
		this.fistShString = fistShString;
	}

	public String getLaShString() {
		return laShString;
	}

	public void setLaShString(String laShString) {
		this.laShString = laShString;
	}

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
    
    
    
    

}
