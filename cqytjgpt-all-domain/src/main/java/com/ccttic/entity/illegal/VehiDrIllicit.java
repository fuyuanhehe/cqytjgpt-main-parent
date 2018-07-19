package com.ccttic.entity.illegal;

import java.io.Serializable;

import com.ccttic.entity.BaseBean;

public class VehiDrIllicit extends BaseBean implements Serializable{
	private static final long serialVersionUID = -5148058947407199964L;
	// 决定书编号
	private String decisionNumber;
	// 车牌号
	private String vehiNo;
	// 号牌种类
	private String vehiNoType;
	// 使用性质
	private String nature;
	// 所属企业
	private String ownership;
	// 所有人
	private String owner;
	// 所有人住所详细地址
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
	// 机动车违法处理状态
	private String vehiState;
	// 驾驶人违法处理状态
	private String drState;
	// 驾驶人名称
	private String name;
	// 驾驶人身份证号码
	private String idcard;
	// 准驾车型
	private String permitCar;
	// 机动车是否违法
	private String vehiIllicitState;
	// 驾驶人是否违法
	private String drIllicitState;
	// 备注
	private String remark;
	// 表名 （其他使用请无视此字段） 
	private String tableName;
	public VehiDrIllicit() {
		super();
	}

	public VehiDrIllicit(String decisionNumber, String vehiNo, String vehiNoType, String nature, String ownership, String owner, String adress,
			String mgrDepart, String mgrDepartAreaId, String vehicleId, String illicitTime, String illicitScore,
			String illicitAmount, String illicitAdress, String illicit, String illicitDesc, String pickDepartment,
			String pickDepartmentDesc, String vehiState, String drState, String name, String idcard, String permitCar,
			String vehiIllicitState, String drIllicitState, String remark,String tableName) {
		super();
		this.decisionNumber = decisionNumber;
		this.vehiNo = vehiNo;
		this.vehiNoType = vehiNoType;
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
		this.illicitAdress = illicitAdress;
		this.illicit = illicit;
		this.illicitDesc = illicitDesc;
		this.pickDepartment = pickDepartment;
		this.pickDepartmentDesc = pickDepartmentDesc;
		this.vehiState = vehiState;
		this.drState = drState;
		this.name = name;
		this.idcard = idcard;
		this.permitCar = permitCar;
		this.vehiIllicitState = vehiIllicitState;
		this.drIllicitState = drIllicitState;
		this.remark = remark;
		this.tableName = tableName;
	}

	public String getDecisionNumber() {
		return decisionNumber;
	}

	public void setDecisionNumber(String decisionNumber) {
		this.decisionNumber = decisionNumber;
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

	public String getVehiState() {
		return vehiState;
	}

	public void setVehiState(String vehiState) {
		this.vehiState = vehiState;
	}

	public String getDrState() {
		return drState;
	}

	public void setDrState(String drState) {
		this.drState = drState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPermitCar() {
		return permitCar;
	}

	public void setPermitCar(String permitCar) {
		this.permitCar = permitCar;
	}

	public String getVehiIllicitState() {
		return vehiIllicitState;
	}

	public void setVehiIllicitState(String vehiIllicitState) {
		this.vehiIllicitState = vehiIllicitState;
	}

	public String getDrIllicitState() {
		return drIllicitState;
	}

	public void setDrIllicitState(String drIllicitState) {
		this.drIllicitState = drIllicitState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
