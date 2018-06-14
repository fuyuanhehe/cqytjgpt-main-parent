package com.ccttic.auth.model;

import java.io.Serializable;

/**
   功能说明：     组织机构信息
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.Organization.java
 @date  2016年12月7日
 */

public class Organization extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1347718600973609427L;
	//组织机构代码
	private String orgCd;
	//组织机构名称
	private String orgNm;
	//组织机构简称
	private String shortNm;
	//备注
	private String remark;
	//部门职能
	private String orgDuty;
	//部门职能中文名
	private String orgDutyNm;
	//显示顺序
	private Integer dispOrder;
	//父组织机构ID
	private String superOrgId;
	//父组织机构编号
	private String superOrgCd;
	//父组织机构名称
	private String superOrgNm;
	//公司管理员ID
	private String companyAdminId;
	//公司管理员编码
	private String companyAdminCd;
	//公司管理员名称
	private String companyAdminNm;
	//总经理ID
	private String generalManagerId;
	//总经理编码
	private String generalManagerCd;
	//总经理名称
	private String generalManagerNm;
	//董事长ID
	private String chairmanId;
	//董事长编号
	private String chairmanCd;
	//董事长名称
	private String chairmanNm;
	//分管领导ID
	private String leadershipId;
	//分管领导编号
	private String leadershipCd;
	//分管领导名称
	private String leadershipNm;
	//部门主管ID
	private String managerId;
	//部门主管编号
	private String managerCd;
	//部门主管名称
	private String managerNm;
	//部门副主管ID
	private String deptDeputyId;
	//部门副主管编号
	private String deptDeputyCd;
	//部门副主管名称
	private String deptDeputyNm;
	//父机构类型编号
	private String superOrgType;
	//机构类型编号
	private String orgType = OrgCategoryEnum.DEPARTMENT.name();
	//机构类型名称
	private String orgTypeNm;

	/**
	 * 
	 */
	public Organization() {
		super();
	}

	

	/**
	 * @param orgCd
	 * @param orgNm
	 * @param shortNm
	 * @param remark
	 * @param orgDuty
	 * @param orgDutyNm
	 * @param dispOrder
	 * @param superOrgId
	 * @param superOrgCd
	 * @param superOrgNm
	 * @param companyAdminId
	 * @param companyAdminCd
	 * @param companyAdminNm
	 * @param generalManagerId
	 * @param generalManagerCd
	 * @param generalManagerNm
	 * @param chairmanId
	 * @param chairmanCd
	 * @param chairmanNm
	 * @param leadershipId
	 * @param leadershipCd
	 * @param leadershipNm
	 * @param managerId
	 * @param managerCd
	 * @param managerNm
	 * @param deptDeputyId
	 * @param deptDeputyCd
	 * @param deptDeputyNm
	 * @param superOrgType
	 * @param orgType
	 * @param orgTypeNm
	 */
	public Organization(String orgCd, String orgNm, String shortNm, String remark, String orgDuty, String orgDutyNm,
			Integer dispOrder, String superOrgId, String superOrgCd, String superOrgNm, String companyAdminId,
			String companyAdminCd, String companyAdminNm, String generalManagerId, String generalManagerCd,
			String generalManagerNm, String chairmanId, String chairmanCd, String chairmanNm, String leadershipId,
			String leadershipCd, String leadershipNm, String managerId, String managerCd, String managerNm,
			String deptDeputyId, String deptDeputyCd, String deptDeputyNm, String superOrgType, String orgType,
			String orgTypeNm) {
		super();
		this.orgCd = orgCd;
		this.orgNm = orgNm;
		this.shortNm = shortNm;
		this.remark = remark;
		this.orgDuty = orgDuty;
		this.orgDutyNm = orgDutyNm;
		this.dispOrder = dispOrder;
		this.superOrgId = superOrgId;
		this.superOrgCd = superOrgCd;
		this.superOrgNm = superOrgNm;
		this.companyAdminId = companyAdminId;
		this.companyAdminCd = companyAdminCd;
		this.companyAdminNm = companyAdminNm;
		this.generalManagerId = generalManagerId;
		this.generalManagerCd = generalManagerCd;
		this.generalManagerNm = generalManagerNm;
		this.chairmanId = chairmanId;
		this.chairmanCd = chairmanCd;
		this.chairmanNm = chairmanNm;
		this.leadershipId = leadershipId;
		this.leadershipCd = leadershipCd;
		this.leadershipNm = leadershipNm;
		this.managerId = managerId;
		this.managerCd = managerCd;
		this.managerNm = managerNm;
		this.deptDeputyId = deptDeputyId;
		this.deptDeputyCd = deptDeputyCd;
		this.deptDeputyNm = deptDeputyNm;
		this.superOrgType = superOrgType;
		this.orgType = orgType;
		this.orgTypeNm = orgTypeNm;
	}



	/**
	 * @return the orgCd
	 */
	public String getOrgCd() {
		return orgCd;
	}

	/**
	 * @param orgCd the orgCd to set
	 */
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}

	/**
	 * @return the orgNm
	 */
	public String getOrgNm() {
		return orgNm;
	}

	/**
	 * @param orgNm the orgNm to set
	 */
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	/**
	 * @return the shortNm
	 */
	public String getShortNm() {
		return shortNm;
	}

	/**
	 * @param shortNm the shortNm to set
	 */
	public void setShortNm(String shortNm) {
		this.shortNm = shortNm;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the orgDuty
	 */
	public String getOrgDuty() {
		return orgDuty;
	}

	/**
	 * @param orgDuty the orgDuty to set
	 */
	public void setOrgDuty(String orgDuty) {
		this.orgDuty = orgDuty;
	}

	/**
	 * @return the orgDutyNm
	 */
	public String getOrgDutyNm() {
		return orgDutyNm;
	}

	/**
	 * @param orgDutyNm the orgDutyNm to set
	 */
	public void setOrgDutyNm(String orgDutyNm) {
		this.orgDutyNm = orgDutyNm;
	}

	/**
	 * @return the dispOrder
	 */
	public Integer getDispOrder() {
		return dispOrder;
	}

	/**
	 * @param dispOrder the dispOrder to set
	 */
	public void setDispOrder(Integer dispOrder) {
		this.dispOrder = dispOrder;
	}

	/**
	 * @return the superOrgId
	 */
	public String getSuperOrgId() {
		return superOrgId;
	}

	/**
	 * @param superOrgId the superOrgId to set
	 */
	public void setSuperOrgId(String superOrgId) {
		this.superOrgId = superOrgId;
	}

	/**
	 * @return the superOrgCd
	 */
	public String getSuperOrgCd() {
		return superOrgCd;
	}

	/**
	 * @param superOrgCd the superOrgCd to set
	 */
	public void setSuperOrgCd(String superOrgCd) {
		this.superOrgCd = superOrgCd;
	}

	/**
	 * @return the superOrgNm
	 */
	public String getSuperOrgNm() {
		return superOrgNm;
	}

	/**
	 * @param superOrgNm the superOrgNm to set
	 */
	public void setSuperOrgNm(String superOrgNm) {
		this.superOrgNm = superOrgNm;
	}

	/**
	 * @return the companyAdminId
	 */
	public String getCompanyAdminId() {
		return companyAdminId;
	}

	/**
	 * @param companyAdminId the companyAdminId to set
	 */
	public void setCompanyAdminId(String companyAdminId) {
		this.companyAdminId = companyAdminId;
	}

	/**
	 * @return the companyAdminCd
	 */
	public String getCompanyAdminCd() {
		return companyAdminCd;
	}

	/**
	 * @param companyAdminCd the companyAdminCd to set
	 */
	public void setCompanyAdminCd(String companyAdminCd) {
		this.companyAdminCd = companyAdminCd;
	}

	/**
	 * @return the companyAdminNm
	 */
	public String getCompanyAdminNm() {
		return companyAdminNm;
	}

	/**
	 * @param companyAdminNm the companyAdminNm to set
	 */
	public void setCompanyAdminNm(String companyAdminNm) {
		this.companyAdminNm = companyAdminNm;
	}

	/**
	 * @return the generalManagerId
	 */
	public String getGeneralManagerId() {
		return generalManagerId;
	}

	/**
	 * @param generalManagerId the generalManagerId to set
	 */
	public void setGeneralManagerId(String generalManagerId) {
		this.generalManagerId = generalManagerId;
	}

	/**
	 * @return the generalManagerCd
	 */
	public String getGeneralManagerCd() {
		return generalManagerCd;
	}

	/**
	 * @param generalManagerCd the generalManagerCd to set
	 */
	public void setGeneralManagerCd(String generalManagerCd) {
		this.generalManagerCd = generalManagerCd;
	}

	/**
	 * @return the generalManagerNm
	 */
	public String getGeneralManagerNm() {
		return generalManagerNm;
	}

	/**
	 * @param generalManagerNm the generalManagerNm to set
	 */
	public void setGeneralManagerNm(String generalManagerNm) {
		this.generalManagerNm = generalManagerNm;
	}

	/**
	 * @return the chairmanId
	 */
	public String getChairmanId() {
		return chairmanId;
	}

	/**
	 * @param chairmanId the chairmanId to set
	 */
	public void setChairmanId(String chairmanId) {
		this.chairmanId = chairmanId;
	}

	/**
	 * @return the chairmanCd
	 */
	public String getChairmanCd() {
		return chairmanCd;
	}

	/**
	 * @param chairmanCd the chairmanCd to set
	 */
	public void setChairmanCd(String chairmanCd) {
		this.chairmanCd = chairmanCd;
	}

	/**
	 * @return the chairmanNm
	 */
	public String getChairmanNm() {
		return chairmanNm;
	}

	/**
	 * @param chairmanNm the chairmanNm to set
	 */
	public void setChairmanNm(String chairmanNm) {
		this.chairmanNm = chairmanNm;
	}

	/**
	 * @return the leadershipId
	 */
	public String getLeadershipId() {
		return leadershipId;
	}

	/**
	 * @param leadershipId the leadershipId to set
	 */
	public void setLeadershipId(String leadershipId) {
		this.leadershipId = leadershipId;
	}

	/**
	 * @return the leadershipCd
	 */
	public String getLeadershipCd() {
		return leadershipCd;
	}

	/**
	 * @param leadershipCd the leadershipCd to set
	 */
	public void setLeadershipCd(String leadershipCd) {
		this.leadershipCd = leadershipCd;
	}

	/**
	 * @return the leadershipNm
	 */
	public String getLeadershipNm() {
		return leadershipNm;
	}

	/**
	 * @param leadershipNm the leadershipNm to set
	 */
	public void setLeadershipNm(String leadershipNm) {
		this.leadershipNm = leadershipNm;
	}

	/**
	 * @return the managerId
	 */
	public String getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	/**
	 * @return the managerCd
	 */
	public String getManagerCd() {
		return managerCd;
	}

	/**
	 * @param managerCd the managerCd to set
	 */
	public void setManagerCd(String managerCd) {
		this.managerCd = managerCd;
	}

	/**
	 * @return the managerNm
	 */
	public String getManagerNm() {
		return managerNm;
	}

	/**
	 * @param managerNm the managerNm to set
	 */
	public void setManagerNm(String managerNm) {
		this.managerNm = managerNm;
	}

	/**
	 * @return the deptDeputyId
	 */
	public String getDeptDeputyId() {
		return deptDeputyId;
	}

	/**
	 * @param deptDeputyId the deptDeputyId to set
	 */
	public void setDeptDeputyId(String deptDeputyId) {
		this.deptDeputyId = deptDeputyId;
	}

	/**
	 * @return the deptDeputyCd
	 */
	public String getDeptDeputyCd() {
		return deptDeputyCd;
	}

	/**
	 * @param deptDeputyCd the deptDeputyCd to set
	 */
	public void setDeptDeputyCd(String deptDeputyCd) {
		this.deptDeputyCd = deptDeputyCd;
	}

	/**
	 * @return the deptDeputyNm
	 */
	public String getDeptDeputyNm() {
		return deptDeputyNm;
	}

	/**
	 * @param deptDeputyNm the deptDeputyNm to set
	 */
	public void setDeptDeputyNm(String deptDeputyNm) {
		this.deptDeputyNm = deptDeputyNm;
	}

	/**
	 * @return the superOrgType
	 */
	public String getSuperOrgType() {
		return superOrgType;
	}

	/**
	 * @param superOrgType the superOrgType to set
	 */
	public void setSuperOrgType(String superOrgType) {
		this.superOrgType = superOrgType;
	}

	/**
	 * @return the orgType
	 */
	public String getOrgType() {
		return orgType;
	}

	/**
	 * @param orgType the orgType to set
	 */
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	/**
	 * @return the orgTypeNm
	 */
	public String getOrgTypeNm() {
		return orgTypeNm;
	}

	/**
	 * @param orgTypeNm the orgTypeNm to set
	 */
	public void setOrgTypeNm(String orgTypeNm) {
		this.orgTypeNm = orgTypeNm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Organization [orgCd=" + orgCd + ", orgNm=" + orgNm + ", shortNm=" + shortNm + ", remark=" + remark
				+ ", orgDuty=" + orgDuty + ", orgDutyNm=" + orgDutyNm + ", dispOrder=" + dispOrder + ", superOrgId="
				+ superOrgId + ", superOrgCd=" + superOrgCd + ", superOrgNm=" + superOrgNm + ", companyAdminId="
				+ companyAdminId + ", companyAdminCd=" + companyAdminCd + ", companyAdminNm=" + companyAdminNm
				+ ", generalManagerId=" + generalManagerId + ", generalManagerCd=" + generalManagerCd
				+ ", generalManagerNm=" + generalManagerNm + ", chairmanId=" + chairmanId + ", chairmanCd=" + chairmanCd
				+ ", chairmanNm=" + chairmanNm + ", leadershipId=" + leadershipId + ", leadershipCd=" + leadershipCd
				+ ", leadershipNm=" + leadershipNm + ", managerId=" + managerId + ", managerCd=" + managerCd
				+ ", managerNm=" + managerNm + ", deptDeputyId=" + deptDeputyId + ", deptDeputyCd=" + deptDeputyCd
				+ ", deptDeputyNm=" + deptDeputyNm + ", superOrgType=" + superOrgType + ", orgType=" + orgType
				+ ", orgTypeNm=" + orgTypeNm + ", id=" + id + "]";
	}

}
