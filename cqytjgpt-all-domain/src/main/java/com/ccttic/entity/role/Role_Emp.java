package com.ccttic.entity.role;
/**
功能说明：    人员角色关系关系
@version  1.0.0
@author  xgYin
@see  com.studio.framework.beans.ess.RoleEmp.java
@date  2018年5月31日
 */

public class Role_Emp {

	// id
	private String id;
	//版本号
	private Integer version;
	//员工ID
	private String 	emp_id;
	//角色ID
	private String role_id;

	public Role_Emp() {
		super();
	}

	public Role_Emp(String id, Integer version, String emp_id, String role_id) {
		super();
		this.id = id;
		this.version = version;
		this.emp_id = emp_id;
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}



}
