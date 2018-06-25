package com.ccttic.entity.drivers.vo;

import java.util.Date;
//自定义企业信息记录实体
public class vehiclesVo {
	// 企业主键id
	private String id;
	//企业名称
	private String etpNm;
	//机动车号牌
	private String vehiNo;
	//使用性质
	private String nature;
	//车辆种类
	private String vehiType;
	//开始时间
	private String effectStartTime;
	//结束时间
	private String effectEndTime;
	//跟新时间
	private Date updateTime;
	//逾期审核状态
	private Integer overdueExamineState;
	//报废状态
	private Integer scrappedState;
	//违法处理状态
	private Integer illicitState;
	//区域
	private String orgNm;
    
    public vehiclesVo() {
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public vehiclesVo(String orgNm) {
		super();
		this.orgNm = orgNm;
	}

	public vehiclesVo(String id, String etpNm, String vehiNo, String nature, String vehiType,
			String effectStartTime, String effectEndTime, Date updateTime,
			Integer overdueExamineState, Integer scrappedState, Integer illicitState,
			String orgNm) {
		super();
		this.id = id;
		this.etpNm = etpNm;
		this.vehiNo = vehiNo;
		this.nature = nature;
		this.vehiType = vehiType;
		this.effectStartTime = effectStartTime;
		this.effectEndTime = effectEndTime;
		this.updateTime = updateTime;
		this.overdueExamineState = overdueExamineState;
		this.scrappedState = scrappedState;
		this.illicitState = illicitState;
	}

	@Override
	public String toString() {
		return "vehiclesVo [id=" + id + ", etpNm=" + etpNm + ", vehiNo=" + vehiNo + ", nature="
				+ nature + ", vehiType=" + vehiType + ", effectStartTime=" + effectStartTime
				+ ", effectEndTime=" + effectEndTime + ", updateTime=" + updateTime
				+ ", overdueExamineState=" + overdueExamineState + ", scrappedState="
				+ scrappedState + ", illicitState=" + illicitState + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEtpNm() {
		return etpNm;
	}

	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}

	public String getVehiNo() {
		return vehiNo;
	}

	public void setVehiNo(String vehiNo) {
		this.vehiNo = vehiNo;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getVehiType() {
		return vehiType;
	}

	public void setVehiType(String vehiType) {
		this.vehiType = vehiType;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getOverdueExamineState() {
		return overdueExamineState;
	}

	public void setOverdueExamineState(Integer overdueExamineState) {
		this.overdueExamineState = overdueExamineState;
	}

	public Integer getScrappedState() {
		return scrappedState;
	}

	public void setScrappedState(Integer scrappedState) {
		this.scrappedState = scrappedState;
	}

	public Integer getIllicitState() {
		return illicitState;
	}

	public void setIllicitState(Integer illicitState) {
		this.illicitState = illicitState;
	}

    

}
