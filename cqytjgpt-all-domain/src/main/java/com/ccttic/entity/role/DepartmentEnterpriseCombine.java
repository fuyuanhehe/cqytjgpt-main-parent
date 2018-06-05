package com.ccttic.entity.role;

import java.io.Serializable;

public class DepartmentEnterpriseCombine implements Serializable{

	private static final long serialVersionUID = 2757876975312901470L;
	// 部门id
	private String middleDepId;
	// 人员id
	private String middleEmpId;
	// 部门id
	private String depId;
	// 人员id
	private String empId;
	// 部门代码
	private String depCd;
	// 部门名称
	private String depNm;
	// 部门简称
	private String depShortNm;
	// 部门职责
	private String depDuty;
	// 员工主键id
	private String id;
	// 员工代码
	private String empCd;
	// 员工姓名
	private String empNm;
	// 工号
	private String empNo;
	// 职务
	private String duty;
	// 性别
	private String empGender;
	// 联系电话
	private String phone;
	
	public DepartmentEnterpriseCombine() {
		super();
	}

	public DepartmentEnterpriseCombine(String middleDepId, String middleEmpId, String depId, String empId, String depCd,
			String depNm, String depShortNm, String depDuty, String id, String empCd, String empNm, String empNo,
			String duty, String empGender, String phone) {
		super();
		this.middleDepId = middleDepId;
		this.middleEmpId = middleEmpId;
		this.depId = depId;
		this.empId = empId;
		this.depCd = depCd;
		this.depNm = depNm;
		this.depShortNm = depShortNm;
		this.depDuty = depDuty;
		this.id = id;
		this.empCd = empCd;
		this.empNm = empNm;
		this.empNo = empNo;
		this.duty = duty;
		this.empGender = empGender;
		this.phone = phone;
	}

	public String getMiddleDepId() {
		return middleDepId;
	}

	public void setMiddleDepId(String middleDepId) {
		this.middleDepId = middleDepId;
	}

	public String getMiddleEmpId() {
		return middleEmpId;
	}

	public void setMiddleEmpId(String middleEmpId) {
		this.middleEmpId = middleEmpId;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDepCd() {
		return depCd;
	}

	public void setDepCd(String depCd) {
		this.depCd = depCd;
	}

	public String getDepNm() {
		return depNm;
	}

	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}

	public String getDepShortNm() {
		return depShortNm;
	}

	public void setDepShortNm(String depShortNm) {
		this.depShortNm = depShortNm;
	}

	public String getDepDuty() {
		return depDuty;
	}

	public void setDepDuty(String depDuty) {
		this.depDuty = depDuty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpCd() {
		return empCd;
	}

	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
