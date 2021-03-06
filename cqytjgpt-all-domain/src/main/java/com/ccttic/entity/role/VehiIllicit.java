package com.ccttic.entity.role;

import java.io.Serializable;

import com.ccttic.entity.BaseBean;

/**
 * 车辆违法记录
 * 
 * @author admin
 *
 */
public class VehiIllicit extends BaseBean implements Serializable {

	private static final long serialVersionUID = -4888577142044933960L;

	// 机动车号牌
	private String vehiNo;
	// 号牌种类
	private String vehiNoType;
	// 号牌中文名
	private String vehiNoTypeText;
	// 使用性质
	private String nature;
	// 机动车所属企业
	private String ownership;
	// 所有人
	private String owner;
	// 住所地址
	private String adress;
	// 管理部门
	private String mgrDepart;
	// 管理部门行政区划
	private String mgrDepartAreaId;
	// 机动车关联id
	private String vehicleId;
	// 违法时间
	private String illicitTime;
	// 违法记分
	private String illicitScore;
	// 罚款金额
	private String illicitAmount;
	// 处罚种类
	private String disposeType;
	// 违法地址
	private String illicitAdress;
	// 违法行为
	private String illicit;
	// 违法行为描述
	private String illicitDesc;
	// 违法序号
	private String serialNumber ;
	// 采集机关
	private String pickDepartment;
	// 采集机关名称
	private String pickDepartmentDesc;
	// 处理标记中文
	private String disposeSign;
	// 处理标记
	private String disposeSignType;
	
	// 状态
	private String state;
	// 备注
	private String remark;
	// 企业中文名
	private String etpNm;
	// 违法开始时间
	private String startTime;
	// 违法结束时间
	private String endTime;
	private String areaNm;
	private String isState;

	public VehiIllicit() {
		super();
	}

	public VehiIllicit(String vehiNo, String vehiNoType, String vehiNoTypeText, String nature, String ownership,
			String owner, String adress, String mgrDepart, String mgrDepartAreaId, String vehicleId, String illicitTime,
			String illicitScore, String illicitAmount, String disposeType, String illicitAdress, String illicit,
			String illicitDesc, String serialNumber, String pickDepartment, String pickDepartmentDesc,
			String disposeSign, String disposeSignType, String state, String remark, String etpNm, String startTime,
			String endTime, String areaNm, String isState) {
		super();
		this.vehiNo = vehiNo;
		this.vehiNoType = vehiNoType;
		this.vehiNoTypeText = vehiNoTypeText;
		this.nature = nature;
		this.ownership = ownership;
		this.owner = owner;
		this.adress = adress;
		this.mgrDepart = mgrDepart;
		this.mgrDepartAreaId = mgrDepartAreaId;
		this.vehicleId = vehicleId;
		this.illicitTime = illicitTime;
		this.illicitScore = illicitScore;
		this.illicitAmount = illicitAmount;
		this.disposeType = disposeType;
		this.illicitAdress = illicitAdress;
		this.illicit = illicit;
		this.illicitDesc = illicitDesc;
		this.serialNumber = serialNumber;
		this.pickDepartment = pickDepartment;
		this.pickDepartmentDesc = pickDepartmentDesc;
		this.disposeSign = disposeSign;
		this.disposeSignType = disposeSignType;
		this.state = state;
		this.remark = remark;
		this.etpNm = etpNm;
		this.startTime = startTime;
		this.endTime = endTime;
		this.areaNm = areaNm;
		this.isState = isState;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getIllicitTime() {
		return illicitTime;
	}

	public void setIllicitTime(String illicitTime) {
		this.illicitTime = illicitTime;
	}

	public String getIllicitScore() {
		return illicitScore;
	}

	public void setIllicitScore(String illicitScore) {
		this.illicitScore = illicitScore;
	}

	public String getIllicitAmount() {
		return illicitAmount;
	}

	public void setIllicitAmount(String illicitAmount) {
		this.illicitAmount = illicitAmount;
	}

	public String getIllicitAdress() {
		return illicitAdress;
	}

	public void setIllicitAdress(String illicitAdress) {
		this.illicitAdress = illicitAdress;
	}

	public String getIllicit() {
		return illicit;
	}

	public void setIllicit(String illicit) {
		this.illicit = illicit;
	}

	public String getIllicitDesc() {
		return illicitDesc;
	}

	public void setIllicitDesc(String illicitDesc) {
		this.illicitDesc = illicitDesc;
	}

	public String getPickDepartment() {
		return pickDepartment;
	}

	public void setPickDepartment(String pickDepartment) {
		this.pickDepartment = pickDepartment;
	}

	public String getPickDepartmentDesc() {
		return pickDepartmentDesc;
	}

	public void setPickDepartmentDesc(String pickDepartmentDesc) {
		this.pickDepartmentDesc = pickDepartmentDesc;
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

	public String getEtpNm() {
		return etpNm;
	}

	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}

	public String getVehiNoTypeText() {
		return vehiNoTypeText;
	}

	public void setVehiNoTypeText(String vehiNoTypeText) {
		this.vehiNoTypeText = vehiNoTypeText;
	}

	public String getDisposeSign() {
		return disposeSign;
	}

	public void setDisposeSign(String disposeSign) {
		this.disposeSign = disposeSign;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDisposeType() {
		return disposeType;
	}

	public void setDisposeType(String disposeType) {
		this.disposeType = disposeType;
	}

	public String getDisposeSignType() {
		return disposeSignType;
	}

	public void setDisposeSignType(String disposeSignType) {
		this.disposeSignType = disposeSignType;
	}

	public String getIsState() {
		return isState;
	}

	public void setIsState(String isState) {
		this.isState = isState;
	}

}
