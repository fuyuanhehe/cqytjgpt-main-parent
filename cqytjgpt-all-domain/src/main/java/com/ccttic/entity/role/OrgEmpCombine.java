package com.ccttic.entity.role;

import java.io.Serializable;

/**
 * @author admin
 *
 */
public class OrgEmpCombine implements Serializable{
	private static final long serialVersionUID = -8447176244329878188L;
		// id
		private String id;
		// 组织机构代码
		private String orgCd;
		// 组织机构名称
		private String orgNm;
		// 组织机构简称
		private String shortNm;
		// 备注
		private String remark;
		// 职能部门
		private String orgDuty;
		// 机构类型 0机构 1企业 2部门
		private String orgType;
		// 行政区域代码
		private String areaId;
		private String superOrgId;
		private String adminEmpid;
		private String account;
		private String password;
		private String empNm;
		private String empCd;
		private String empNo;
		private String duty;
		private String empGender;
		private String mobile;
		public OrgEmpCombine() {
			super();
		}
		
		public OrgEmpCombine(String id, String orgCd, String orgNm, String shortNm, String remark, String orgDuty,
				String orgType, String areaId, String superOrgId, String adminEmpid, String account, String password,
				String empNm, String empCd, String empNo, String duty, String empGender, String mobile) {
			super();
			this.id = id;
			this.orgCd = orgCd;
			this.orgNm = orgNm;
			this.shortNm = shortNm;
			this.remark = remark;
			this.orgDuty = orgDuty;
			this.orgType = orgType;
			this.areaId = areaId;
			this.superOrgId = superOrgId;
			this.adminEmpid = adminEmpid;
			this.account = account;
			this.password = password;
			this.empNm = empNm;
			this.empCd = empCd;
			this.empNo = empNo;
			this.duty = duty;
			this.empGender = empGender;
			this.mobile = mobile;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getOrgCd() {
			return orgCd;
		}

		public void setOrgCd(String orgCd) {
			this.orgCd = orgCd;
		}

		public String getOrgNm() {
			return orgNm;
		}

		public void setOrgNm(String orgNm) {
			this.orgNm = orgNm;
		}

		public String getShortNm() {
			return shortNm;
		}

		public void setShortNm(String shortNm) {
			this.shortNm = shortNm;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getOrgDuty() {
			return orgDuty;
		}

		public void setOrgDuty(String orgDuty) {
			this.orgDuty = orgDuty;
		}

		public String getOrgType() {
			return orgType;
		}

		public void setOrgType(String orgType) {
			this.orgType = orgType;
		}

		public String getAreaId() {
			return areaId;
		}

		public void setAreaId(String areaId) {
			this.areaId = areaId;
		}

		public String getSuperOrgId() {
			return superOrgId;
		}

		public void setSuperOrgId(String superOrgId) {
			this.superOrgId = superOrgId;
		}

		public String getAdminEmpid() {
			return adminEmpid;
		}

		public void setAdminEmpid(String adminEmpid) {
			this.adminEmpid = adminEmpid;
		}

		public String getAccount() {
			return account;
		}

		public void setAccount(String account) {
			this.account = account;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmpNm() {
			return empNm;
		}

		public void setEmpNm(String empNm) {
			this.empNm = empNm;
		}

		public String getEmpCd() {
			return empCd;
		}

		public void setEmpCd(String empCd) {
			this.empCd = empCd;
		}

		public String getEmpNo() {
			return empNo;
		}

		public void setEmpNo(String empNo) {
			this.empNo = empNo;
		}

		public String getDuty() {
			return duty;
		}

		public void setDuty(String duty) {
			this.duty = duty;
		}

		public String getEmpGender() {
			return empGender;
		}

		public void setEmpGender(String empGender) {
			this.empGender = empGender;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		@Override
		public String toString() {
			return "OrgEmpCombine [id=" + id + ", orgCd=" + orgCd + ", orgNm=" + orgNm 
					+ ", shortNm=" + shortNm+ ", remark=" + remark+ ", orgDuty=" + orgDuty+ ", orgType=" + orgType
					+", password=" + password+", empNm=" + empNm+", empCd=" + empCd+", empNo=" + empNo
					+", duty=" + duty+", empGender=" + empGender+", mobile=" + mobile
					+", adminEmpid=" + adminEmpid+", account=" + account+", areaId=" + areaId +", superOrgId=" + superOrgId + "]";
			
		}
		
}