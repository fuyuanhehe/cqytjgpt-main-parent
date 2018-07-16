package com.ccttic.entity.enterprise.vo;

import com.ccttic.entity.enterprise.Pages;

//自定义企业驾驶人实体
public class EnterpriseVehiVo extends Pages {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3154729662588697562L;
	
	private String id;
	
	private String vehiNo;

	private String vehiType;
	
	private String vehiNoType;
	
	private String nature;
	
	private String firstReciveTime;
	
	private String effectEndTime;
	
	private String owner;
	
	private String mobilephone;
	
	private String mgrDepart;
	
	private String state;
	
	private String etpNm;
	
	private String areaNm;
	
	private String ownership;
	
	private String adress;
	
	private String examineEffectEndTime;
	
	private String telphone;
	
	
	
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getExamineEffectEndTime() {
		return examineEffectEndTime;
	}
	public void setExamineEffectEndTime(String examineEffectEndTime) {
		this.examineEffectEndTime = examineEffectEndTime;
	}
	public EnterpriseVehiVo() {
		// TODO Auto-generated constructor stub
	}
	public EnterpriseVehiVo(String id, String vehiNo, String vehiType, String vehiNoType,
			String nature, String firstReciveTime, String effectEndTime, String owner,
			String mobilephone, String mgrDepart, String state, String etpNm, String areaNm) {
		super();
		this.id = id;
		this.vehiNo = vehiNo;
		this.vehiType = vehiType;
		this.vehiNoType = vehiNoType;
		this.nature = nature;
		this.firstReciveTime = firstReciveTime;
		this.effectEndTime = effectEndTime;
		this.owner = owner;
		this.mobilephone = mobilephone;
		this.mgrDepart = mgrDepart;
		this.state = state;
		this.etpNm = etpNm;
		this.areaNm = areaNm;
	}
	@Override
	public String toString() {
		return "EnterpriseVehiVo [id=" + id + ", vehiNo=" + vehiNo + ", vehiType=" + vehiType
				+ ", vehiNoType=" + vehiNoType + ", nature=" + nature + ", firstReciveTime="
				+ firstReciveTime + ", effectEndTime=" + effectEndTime + ", owner=" + owner
				+ ", mobilephone=" + mobilephone + ", mgrDepart=" + mgrDepart + ", state=" + state
				+ ", etpNm=" + etpNm + ", areaNm=" + areaNm + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVehiNo() {
		return vehiNo;
	}
	public void setVehiNo(String vehiNo) {
		this.vehiNo = vehiNo;
	}
	public String getVehiType() {
		return vehiType;
	}
	public void setVehiType(String vehiType) {
		this.vehiType = vehiType;
	}
	public String getVehiNoType() {
		return vehiNoType;
	}
	public void setVehiNoType(String vehiNoType) {
		this.vehiNoType = vehiNoType;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getFirstReciveTime() {
		return firstReciveTime;
	}
	public void setFirstReciveTime(String firstReciveTime) {
		this.firstReciveTime = firstReciveTime;
	}
	public String getEffectEndTime() {
		return effectEndTime;
	}
	public void setEffectEndTime(String effectEndTime) {
		this.effectEndTime = effectEndTime;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getMgrDepart() {
		return mgrDepart;
	}
	public void setMgrDepart(String mgrDepart) {
		this.mgrDepart = mgrDepart;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEtpNm() {
		return etpNm;
	}
	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}
	public String getAreaNm() {
		return areaNm;
	}
	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}
	public String getOwnership() {
		return ownership;
	}
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
}
