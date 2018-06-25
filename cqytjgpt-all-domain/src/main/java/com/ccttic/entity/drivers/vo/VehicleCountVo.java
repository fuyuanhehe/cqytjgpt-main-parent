package com.ccttic.entity.drivers.vo;
// 企业机动车正常，隐患数量查询
public class VehicleCountVo {
	//企业名称
	private String etpNm;
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

	public VehicleCountVo() {
	}

	public VehicleCountVo(String etpNm, Integer vCount, Integer zCount, Integer scraCount,
			Integer overCount, Integer illicitCount) {
		super();
		this.etpNm = etpNm;
		this.vCount = vCount;
		this.zCount = zCount;
		this.scraCount = scraCount;
		this.overCount = overCount;
		this.illicitCount = illicitCount;
	}

	@Override
	public String toString() {
		return "VehicleCountVo [etpNm=" + etpNm + ", vCount=" + vCount + ", zCount=" + zCount
				+ ", scraCount=" + scraCount + ", overCount=" + overCount + ", illicitCount="
				+ illicitCount + "]";
	}

	public String getEtpNm() {
		return etpNm;
	}

	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
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
