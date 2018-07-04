package com.ccttic.entity.drivers.vo;

import java.util.List;

// 企业机动车正常，隐患数量查询
public class VehicleCountVo {
	//企业名称
	private String etpNm;
	//车辆类型
	private String type;
	//总数车辆
	private Integer vCount;
	//正常车辆
	private Integer zCount;
	//逾期未检查车辆
	private Integer scraCount;
	//报废车辆
	private Integer overCount;
	//违法处理车辆
	private Integer illicitCount;
	//账号类型
	private String empType;
	//企业id
	private List<String> list;
	//区域
	private String orgNm;
    // 车辆类型
	private String vehiType;
	public VehicleCountVo() {
	}


	public String getVehiType() {
		return vehiType;
	}


	public void setVehiType(String vehiType) {
		this.vehiType = vehiType;
	}


	public String getOrgNm() {
		return orgNm;
	}


	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}


	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public VehicleCountVo(String etpNm, String type, Integer vCount, Integer zCount,
			Integer scraCount, Integer overCount, Integer illicitCount) {
		super();
		this.etpNm = etpNm;
		this.type = type;
		this.vCount = vCount;
		this.zCount = zCount;
		this.scraCount = scraCount;
		this.overCount = overCount;
		this.illicitCount = illicitCount;
	}

	@Override
	public String toString() {
		return "VehicleCountVo [etpNm=" + etpNm + ", type=" + type + ", vCount=" + vCount
				+ ", zCount=" + zCount + ", scraCount=" + scraCount + ", overCount=" + overCount
				+ ", illicitCount=" + illicitCount + "]";
	}

	public String getEtpNm() {
		return etpNm;
	}

	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getvCount() {
		return vCount;
	}

	public void setvCount(Integer vCount) {
		this.vCount = vCount;
	}

	public Integer getzCount() {
		return zCount;
	}

	public void setzCount(Integer zCount) {
		this.zCount = zCount;
	}

	public Integer getScraCount() {
		return scraCount;
	}

	public void setScraCount(Integer scraCount) {
		this.scraCount = scraCount;
	}

	public Integer getOverCount() {
		return overCount;
	}

	public void setOverCount(Integer overCount) {
		this.overCount = overCount;
	}

	public Integer getIllicitCount() {
		return illicitCount;
	}

	public void setIllicitCount(Integer illicitCount) {
		this.illicitCount = illicitCount;
	}


}
