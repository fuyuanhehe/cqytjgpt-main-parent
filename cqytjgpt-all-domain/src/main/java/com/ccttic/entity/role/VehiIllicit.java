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
	// 使用性质
	private String usage;
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
	// 违法地址
	private String illicitAdress;
	// 违法行为
	private String illicit;
	// 违法行为描述
	private String illicitDesc;
	// 采集机关
	private String pickDepartment;
	// 采集机关名称
	private String pickDepartmentDesc;
	// 状态
	private String state;
	// 备注
	private String remark;

	public VehiIllicit() {
		super();
	}

	public VehiIllicit(String vehiNo, String vehiNoType, String usage, String ownership, String owner, String adress,
			String mgrDepart, String mgrDepartAreaId, String vehicleId, String illicitTime, String illicitScore,
			String illicitAmount, String illicitAdress, String illicit, String illicitDesc, String pickDepartment,
			String pickDepartmentDesc, String state, String remark) {
		super();
		this.vehiNo = vehiNo;
		this.vehiNoType = vehiNoType;
		this.usage = usage;
		this.ownership = ownership;
		this.owner = owner;
		this.adress = adress;
		this.mgrDepart = mgrDepart;
		this.mgrDepartAreaId = mgrDepartAreaId;
		this.vehicleId = vehicleId;
		this.illicitTime = illicitTime;
		this.illicitScore = illicitScore;
		this.illicitAmount = illicitAmount;
		this.illicitAdress = illicitAdress;
		this.illicit = illicit;
		this.illicitDesc = illicitDesc;
		this.pickDepartment = pickDepartment;
		this.pickDepartmentDesc = pickDepartmentDesc;
		this.state = state;
		this.remark = remark;
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

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
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

}
