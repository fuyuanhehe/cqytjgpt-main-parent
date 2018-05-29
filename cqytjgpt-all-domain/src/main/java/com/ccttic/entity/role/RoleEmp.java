package com.ccttic.entity.role;

import java.io.Serializable;

/**
   功能说明：      角色人员关联关系
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.RoleEmp.java
 @date  2016年12月11日
 */

public class RoleEmp implements Serializable {
	private static final long serialVersionUID = 7111761623751187515L;
	//主键ID
	private String id;
	//员工ID
	private String empId;
	//员工编号
	private String empCd;
	//员工姓名
	private String empNm;
	//角色ID
	private String roleId;
	//角色编号
	private String roleCd;
	//角色名称
	private String roleNm;
	//版本号
	private Integer version;

	/**
	 * 
	 */
	public RoleEmp() {
		super();
	}

	/**
	 * @param id
	 * @param empId
	 * @param empCd
	 * @param empNm
	 * @param roleId
	 * @param roleCd
	 * @param roleNm
	 * @param version
	 */
	public RoleEmp(String id, String empId, String empCd, String empNm, String roleId, String roleCd, String roleNm,
			Integer version) {
		super();
		this.id = id;
		this.empId = empId;
		this.empCd = empCd;
		this.empNm = empNm;
		this.roleId = roleId;
		this.roleCd = roleCd;
		this.roleNm = roleNm;
		this.version = version;
	}

	/**
	 * 
	 * @param id
	 * @param empId
	 * @param roleId
	 * @param version
	 */
	public RoleEmp(String id, String empId, String roleId, Integer version) {
		super();
		this.id = id;
		this.empId = empId;
		this.roleId = roleId;
		this.version = version;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
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
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleCd
	 */
	public String getRoleCd() {
		return roleCd;
	}

	/**
	 * @param roleCd the roleCd to set
	 */
	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

	/**
	 * @return the roleNm
	 */
	public String getRoleNm() {
		return roleNm;
	}

	/**
	 * @param roleNm the roleNm to set
	 */
	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleEmp [id=" + id + ", empId=" + empId + ", empCd=" + empCd + ", empNm=" + empNm + ", roleId=" + roleId
				+ ", roleCd=" + roleCd + ", roleNm=" + roleNm + ", version=" + version + "]";
	}

}
