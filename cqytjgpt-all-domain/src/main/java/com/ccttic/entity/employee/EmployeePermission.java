package com.ccttic.entity.employee;

import java.util.List;

public class EmployeePermission {

	private String orgId;

	private String orgType;

	private String enterpriseId;
	
	private String superEntId;

	private String employeeType;

	private List<String> areaList;

	public List<String> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getSuperEntId() {
		return superEntId;
	}

	public void setSuperEntId(String superEntId) {
		this.superEntId = superEntId;
	}
	
}
