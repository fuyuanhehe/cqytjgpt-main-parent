package com.ccttic.entity.danger.vo;

import java.io.Serializable;

/**
 * 首页-企业隐患自查
 * @author admin
 *
 */
public class DangerCountVo implements Serializable{

	private static final long serialVersionUID = -669240165868288035L;
	
	// 达到报废标准
	private String scrappedCount;
	// 违法处理
	private String illicitCount;
	// 逾期未检验
	private String vehicleExamineCount;
	// 预期未换证
	private String overdueProofCount;
	// 预期未审验
	private String DrExamineCount;
	// 满分未学习
	private String fullStudyCount;
	
	public DangerCountVo() {
		super();
	}

	public DangerCountVo(String scrappedCount, String illicitCount, String vehicleExamineCount, String overdueProofCount,
			String drExamineCount, String fullStudyCount) {
		super();
		this.scrappedCount = scrappedCount;
		this.illicitCount = illicitCount;
		this.vehicleExamineCount = vehicleExamineCount;
		this.overdueProofCount = overdueProofCount;
		DrExamineCount = drExamineCount;
		this.fullStudyCount = fullStudyCount;
	}

	public String getScrappedCount() {
		return scrappedCount;
	}

	public void setScrappedCount(String scrappedCount) {
		this.scrappedCount = scrappedCount;
	}

	public String getIllicitCount() {
		return illicitCount;
	}

	public void setIllicitCount(String illicitCount) {
		this.illicitCount = illicitCount;
	}

	public String getVehicleExamineCount() {
		return vehicleExamineCount;
	}

	public void setVehicleExamineCount(String vehicleExamineCount) {
		this.vehicleExamineCount = vehicleExamineCount;
	}

	public String getOverdueProofCount() {
		return overdueProofCount;
	}

	public void setOverdueProofCount(String overdueProofCount) {
		this.overdueProofCount = overdueProofCount;
	}

	public String getDrExamineCount() {
		return DrExamineCount;
	}

	public void setDrExamineCount(String drExamineCount) {
		DrExamineCount = drExamineCount;
	}

	public String getFullStudyCount() {
		return fullStudyCount;
	}

	public void setFullStudyCount(String fullStudyCount) {
		this.fullStudyCount = fullStudyCount;
	}
	
	
}
