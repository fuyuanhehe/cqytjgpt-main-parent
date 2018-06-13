package com.ccttic.entity.role.vo;

import java.util.List;

// 自定义角色，员工，菜单实体
public class Model_RmsVo  {
	//角色ID
	private String roleId;
	//角色编码
	private String roleCd;
	//角色名称
	private String roleNm;
	//角色描述
	private String description;
	//角色名称字符串
	private String empName;	
	//角色关联人员id
	private List<String> emp_Id;
	//所有的员工ID
	private List<String> empid;
	//所有的人员名称
	private List<String> empNmss;

     private List<Object> menus;

	public Model_RmsVo() {
		// TODO Auto-generated constructor stub
	}

	public Model_RmsVo(String roleId, String roleCd, String roleNm, String description,
			String empName, List<String> emp_Id, List<String> empid, List<String> empNmss,
			List<Object> menus) {
		super();
		this.roleId = roleId;
		this.roleCd = roleCd;
		this.roleNm = roleNm;
		this.description = description;
		this.empName = empName;
		this.emp_Id = emp_Id;
		this.empid = empid;
		this.empNmss = empNmss;
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Model_RmsVo [roleId=" + roleId + ", roleCd=" + roleCd + ", roleNm=" + roleNm
				+ ", description=" + description + ", empName=" + empName + ", emp_Id=" + emp_Id
				+ ", empid=" + empid + ", empNmss=" + empNmss + ", menus=" + menus + "]";
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleCd() {
		return roleCd;
	}

	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

	public String getRoleNm() {
		return roleNm;
	}

	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<String> getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(List<String> emp_Id) {
		this.emp_Id = emp_Id;
	}

	public List<String> getEmpid() {
		return empid;
	}

	public void setEmpid(List<String> empid) {
		this.empid = empid;
	}

	public List<String> getEmpNmss() {
		return empNmss;
	}

	public void setEmpNmss(List<String> empNmss) {
		this.empNmss = empNmss;
	}

	public List<Object> getMenus() {
		return menus;
	}

	public void setMenus(List<Object> menus) {
		this.menus = menus;
	}


}
