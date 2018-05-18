package com.ccttic.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
   功能说明：     人员Bean
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.Employee.java
 @date  2016年12月3日
 */

public class Employee extends BaseBean implements Serializable {
	private static final long serialVersionUID = 2725950871498794398L;
	//员工代码
	private String empCd;
	//员工姓名
	private String empNm;
	//工号
	private String empNo;
	//职务
	private String duty;
	//职务中文名
	private String dutyNm;
	//性别
	private String empGender;
	//电话
	private String phone;
	//手机号
	private String mobile;
	//入职日期
	private Date entryDate;
	//离职日期
	private Date leaveDate;
	//登录帐号
	private String account;
	//登录密码
	private String password;
	//员工状态
	private String empStatus = EmpStatusEnum.ONJOB.name();
	//员工类型
	private String empType = EmpCategoryEnum.GENERALEMPLOYEE.name();
	//员工类型中文名
	private String empTypeNm;
	//人员所属机构Id
	private String orgId;
	//人员所属机构编号
	private String orgCd;
	//人员所属机构名称
	private String orgNm;
	//人员拥有岗位Id
	private List<String> postIds = new ArrayList<String>();
	//人员拥有岗位编号
	private List<String> postCds = new ArrayList<String>();
	//人员拥有岗位名称
	private List<String> postNms = new ArrayList<String>();
	//人员拥有角色Id
	private List<String> roleIds = new ArrayList<String>();
	//人员拥有角色编号
	private List<String> roleCds = new ArrayList<String>();
	//人员拥有角色名称
	private List<String> roleNms = new ArrayList<String>();
	//是否包含下级机构(查询条件)
	private boolean involveAllSubOrgs = false;

	//所属公司
	private String companyNm;

	/**
	 * 
	 */
	public Employee() {
		super();
	}

	

	public Employee(String empCd, String empNm, String empNo, String duty, String dutyNm, String empGender,
			String phone, String mobile, Date entryDate, Date leaveDate, String account, String password,
			String empStatus, String empType, String empTypeNm, String orgId, String orgCd, String orgNm,
			List<String> postIds, List<String> postCds, List<String> postNms, List<String> roleIds,
			List<String> roleCds, List<String> roleNms, boolean involveAllSubOrgs, String companyNm) {
		super();
		this.empCd = empCd;
		this.empNm = empNm;
		this.empNo = empNo;
		this.duty = duty;
		this.dutyNm = dutyNm;
		this.empGender = empGender;
		this.phone = phone;
		this.mobile = mobile;
		this.entryDate = entryDate;
		this.leaveDate = leaveDate;
		this.account = account;
		this.password = password;
		this.empStatus = empStatus;
		this.empType = empType;
		this.empTypeNm = empTypeNm;
		this.orgId = orgId;
		this.orgCd = orgCd;
		this.orgNm = orgNm;
		this.postIds = postIds;
		this.postCds = postCds;
		this.postNms = postNms;
		this.roleIds = roleIds;
		this.roleCds = roleCds;
		this.roleNms = roleNms;
		this.involveAllSubOrgs = involveAllSubOrgs;
		this.companyNm = companyNm;
	}



	/**
	 * @return the empCd
	 */
	public String getEmpCd() {
		return empCd;
	}

	/**
	 * @param empCd the empCd to set
	 */
	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}

	/**
	 * @return the empNm
	 */
	public String getEmpNm() {
		return empNm;
	}

	/**
	 * @param empNm the empNm to set
	 */
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the duty
	 */
	public String getDuty() {
		return duty;
	}

	/**
	 * @param duty the duty to set
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}

	/**
	 * @return the empGender
	 */
	public String getEmpGender() {
		return empGender;
	}

	/**
	 * @param empGender the empGender to set
	 */
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the leaveDate
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}

	/**
	 * @param leaveDate the leaveDate to set
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the empStatus
	 */
	public String getEmpStatus() {
		return empStatus;
	}

	/**
	 * @param empStatus the empStatus to set
	 */
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * @return the empType
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * @param empType the empType to set
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
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
	
	/**
	 * @return the orgNm
	 */
	public String getOrgNm() {
		return orgNm;
	}

	/**
	 * @return the postIds
	 */
	public List<String> getPostIds() {
		return postIds;
	}

	/**
	 * @param postIds the postIds to set
	 */
	public void setPostIds(List<String> postIds) {
		this.postIds = postIds;
	}

	/**
	 * @return the postCds
	 */
	public List<String> getPostCds() {
		return postCds;
	}

	/**
	 * @param postCds the postCds to set
	 */
	public void setPostCds(List<String> postCds) {
		this.postCds = postCds;
	}

	/**
	 * @return the postNms
	 */
	public List<String> getPostNms() {
		return postNms;
	}

	/**
	 * @param postNms the postNms to set
	 */
	public void setPostNms(List<String> postNms) {
		this.postNms = postNms;
	}

	/**
	 * @return the roleIds
	 */
	public List<String> getRoleIds() {
		return roleIds;
	}

	/**
	 * @param roleIds the roleIds to set
	 */
	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * @return the roleCds
	 */
	public List<String> getRoleCds() {
		return roleCds;
	}

	/**
	 * @param roleCds the roleCds to set
	 */
	public void setRoleCds(List<String> roleCds) {
		this.roleCds = roleCds;
	}

	/**
	 * @return the roleNms
	 */
	public List<String> getRoleNms() {
		return roleNms;
	}

	/**
	 * @param roleNms the roleNms to set
	 */
	public void setRoleNms(List<String> roleNms) {
		this.roleNms = roleNms;
	}

	/**
	 * @param orgNm the orgNm to set
	 */
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	/**
	 * @return the involveAllSubOrgs
	 */
	public boolean isInvolveAllSubOrgs() {
		return involveAllSubOrgs;
	}

	/**
	 * @param involveAllSubOrgs the involveAllSubOrgs to set
	 */
	public void setInvolveAllSubOrgs(boolean involveAllSubOrgs) {
		this.involveAllSubOrgs = involveAllSubOrgs;
	}

	/**
	 * @return the dutyNm
	 */
	public String getDutyNm() {
		return dutyNm;
	}

	/**
	 * @param dutyNm the dutyNm to set
	 */
	public void setDutyNm(String dutyNm) {
		this.dutyNm = dutyNm;
	}

	/**
	 * @return the empTypeNm
	 */
	public String getEmpTypeNm() {
		return empTypeNm;
	}

	/**
	 * @param empTypeNm the empTypeNm to set
	 */
	public void setEmpTypeNm(String empTypeNm) {
		this.empTypeNm = empTypeNm;
	}

	/**
	 * @return the companyNm
	 */
	public String getCompanyNm() {
		return companyNm;
	}

	/**
	 * @param companyNm the companyNm to set
	 */
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [empCd=" + empCd + ", empNm=" + empNm + ", empNo=" + empNo + ", duty=" + duty + ", empGender="
				+ empGender + ", phone=" + phone + ", mobile=" + mobile + ", entryDate=" + entryDate + ", leaveDate="
				+ leaveDate + ", account=" + account + ", password=" + password + ", empStatus=" + empStatus
				+ ", empType=" + empType + ", orgId=" + orgId + ", orgCd=" + orgCd + ", orgNm=" + orgNm + ", postId="
				+ postIds + ", postCd=" + postCds + ", postNm=" + postNms + ", roleId=" + roleIds + ", roleCd="
				+ roleCds + ", roleNm=" + roleNms + ", id=" + id + "]";
	}

}
