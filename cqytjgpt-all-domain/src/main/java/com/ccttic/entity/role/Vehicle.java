package com.ccttic.entity.role;

import java.io.Serializable;

import com.ccttic.entity.BaseBean;

/**
 * 机动车 基本信息
 * 
 * @author admin
 *
 */
public class Vehicle extends BaseBean implements Serializable {
	private static final long serialVersionUID = -3732047563152491217L;
	// 机动车号牌
	private String vehiNo;
	// 号牌种类 
	private String vehiNoType;
	private String vehiNoTypeText;
	// 车辆种类
	private String vehiType;
	private String vehiTypeText;
	// 使用性质
	private String nature;
	// 机动车所属企业
	private String ownership;
	// 所有人
	private String owner;
	// 联系电话
	private String telphone;
	// 手机号码
	private String mobilephone;
	// 住所地址
	private String adress;
	// 准驾车型
	private String permitCar;
	// 初次领证时间
	private String firstReciveTime;
	// 管理部门
	private String mgrDepart;
	// 管理部门行政区划
	private String mgrDepartAreaId;
	// 管理部门中文名
	private String areaNm;
	// 管理企业id
	private String mgrEnterpriseId;
	// 企业中文名
	private String etpNm;
	// 下次审验时间
	private String nextExamineTime;
	// 有效开始时间
	private String effectStartTime;
	// 有效结束时间
	private String effectEndTime;
	// 审验有效期止
	private String examineEffectEndTime;
	// 累计记分
	private String scoreTotal;
	// 状态
	private String state;
	// 备注
	private String remark;
	// 初次检验开始日期
	private String startTime;
	// 初次检验结束日期
	private String endTime;
	
	private String id;
	//证件名称
	private String identityName;
	//证件号码
	private String identityCode;
	//是否为农用车
	private String countrySideUse;
	//是否是面包车
	private String mbCar;
	//强制报废时间
	private String examineForceEffectEndTime;

	public String getExamineForceEffectEndTime() {
		return examineForceEffectEndTime;
	}

	public void setExamineForceEffectEndTime(String examineForceEffectEndTime) {
		this.examineForceEffectEndTime = examineForceEffectEndTime;
	}

	public String getCountrySideUse() {
		return countrySideUse;
	}

	public void setCountrySideUse(String countrySideUse) {
		this.countrySideUse = countrySideUse;
	}

	public String getMbCar() {
		return mbCar;
	}

	public void setMbCar(String mbCar) {
		this.mbCar = mbCar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdentityName() {
		return identityName;
	}

	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
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

	public String getVehiNo() {
		return vehiNo;
	}

	public void setVehiNo(String vehiNo) {
		this.vehiNo = vehiNo;
	}

	public String getVehiNoType() {
		return vehiNoType;
	}

	public void setVehiNoType(String vehiNoType) {
		this.vehiNoType = vehiNoType;
	}

	public String getVehiType() {
		return vehiType;
	}

	public void setVehiType(String vehiType) {
		this.vehiType = vehiType;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPermitCar() {
		return permitCar;
	}

	public void setPermitCar(String permitCar) {
		this.permitCar = permitCar;
	}

	public String getFirstReciveTime() {
		return firstReciveTime;
	}

	public void setFirstReciveTime(String firstReciveTime) {
		this.firstReciveTime = firstReciveTime;
	}

	public String getMgrDepart() {
		return mgrDepart;
	}

	public void setMgrDepart(String mgrDepart) {
		this.mgrDepart = mgrDepart;
	}

	public String getMgrDepartAreaId() {
		return mgrDepartAreaId;
	}

	public void setMgrDepartAreaId(String mgrDepartAreaId) {
		this.mgrDepartAreaId = mgrDepartAreaId;
	}

	public String getMgrEnterpriseId() {
		return mgrEnterpriseId;
	}

	public void setMgrEnterpriseId(String mgrEnterpriseId) {
		this.mgrEnterpriseId = mgrEnterpriseId;
	}

	public String getNextExamineTime() {
		return nextExamineTime;
	}

	public void setNextExamineTime(String nextExamineTime) {
		this.nextExamineTime = nextExamineTime;
	}

	public String getEffectStartTime() {
		return effectStartTime;
	}

	public void setEffectStartTime(String effectStartTime) {
		this.effectStartTime = effectStartTime;
	}

	public String getEffectEndTime() {
		return effectEndTime;
	}

	public void setEffectEndTime(String effectEndTime) {
		this.effectEndTime = effectEndTime;
	}

	public String getExamineEffectEndTime() {
		return examineEffectEndTime;
	}

	public void setExamineEffectEndTime(String examineEffectEndTime) {
		this.examineEffectEndTime = examineEffectEndTime;
	}

	public String getScoreTotal() {
		return scoreTotal;
	}

	public void setScoreTotal(String scoreTotal) {
		this.scoreTotal = scoreTotal;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getVehiNoTypeText() {
		return vehiNoTypeText;
	}

	public void setVehiNoTypeText(String vehiNoTypeText) {
		this.vehiNoTypeText = vehiNoTypeText;
	}

	public String getVehiTypeText() {
		return vehiTypeText;
	}

	public void setVehiTypeText(String vehiTypeText) {
		this.vehiTypeText = vehiTypeText;
	}

	public Vehicle(){
		super();
	}

	public Vehicle(String vehiNo, String vehiNoType, String vehiNoTypeText, String vehiType, String vehiTypeText, String nature, String ownership, String owner, String telphone, String mobilephone, String adress, String permitCar, String firstReciveTime, String mgrDepart, String mgrDepartAreaId, String areaNm, String mgrEnterpriseId, String etpNm, String nextExamineTime, String effectStartTime, String effectEndTime, String examineEffectEndTime, String scoreTotal, String state, String remark, String startTime, String endTime, String id, String identityName, String identityCode, String countrySideUse, String mbCar, String examineForceEffectEndTime) {
		this.vehiNo = vehiNo;
		this.vehiNoType = vehiNoType;
		this.vehiNoTypeText = vehiNoTypeText;
		this.vehiType = vehiType;
		this.vehiTypeText = vehiTypeText;
		this.nature = nature;
		this.ownership = ownership;
		this.owner = owner;
		this.telphone = telphone;
		this.mobilephone = mobilephone;
		this.adress = adress;
		this.permitCar = permitCar;
		this.firstReciveTime = firstReciveTime;
		this.mgrDepart = mgrDepart;
		this.mgrDepartAreaId = mgrDepartAreaId;
		this.areaNm = areaNm;
		this.mgrEnterpriseId = mgrEnterpriseId;
		this.etpNm = etpNm;
		this.nextExamineTime = nextExamineTime;
		this.effectStartTime = effectStartTime;
		this.effectEndTime = effectEndTime;
		this.examineEffectEndTime = examineEffectEndTime;
		this.scoreTotal = scoreTotal;
		this.state = state;
		this.remark = remark;
		this.startTime = startTime;
		this.endTime = endTime;
		this.id = id;
		this.identityName = identityName;
		this.identityCode = identityCode;
		this.countrySideUse = countrySideUse;
		this.mbCar = mbCar;
		this.examineForceEffectEndTime = examineForceEffectEndTime;
	}
}
