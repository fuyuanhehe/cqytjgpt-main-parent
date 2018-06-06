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
	//角色关联人员名称
	private List<String> empNms;
	//角色关联人员id
	private List<String> emp_Id;
	//所有的员工ID
	private List<String> empid;
	//所有的人员名称
	private List<String> empNmss;

	//角色包含的菜单ID
	private List<String> menuIds;
	//角色包含的菜单名
	private List<String> menuLabels;	
	//所有菜单id
	private List<String> allMenuIds;
	// 所有菜单名称
	private List<String> allMenus;


	public Model_RmsVo() {
		// TODO Auto-generated constructor stub
	}

	public String getEmpName() {
		return empName;
	}







	public void setEmpName(String empName) {
		this.empName = empName;
	}







	public Model_RmsVo(String empName) {
		super();
		this.empName = empName;
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







	public List<String> getEmpNms() {
		return empNms;
	}







	public void setEmpNms(List<String> empNms) {
		this.empNms = empNms;
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







	public List<String> getMenuIds() {
		return menuIds;
	}







	public void setMenuIds(List<String> menuIds) {
		this.menuIds = menuIds;
	}







	public List<String> getMenuLabels() {
		return menuLabels;
	}







	public void setMenuLabels(List<String> menuLabels) {
		this.menuLabels = menuLabels;
	}







	public List<String> getAllMenuIds() {
		return allMenuIds;
	}







	public void setAllMenuIds(List<String> allMenuIds) {
		this.allMenuIds = allMenuIds;
	}







	public List<String> getAllMenus() {
		return allMenus;
	}







	public void setAllMenus(List<String> allMenus) {
		this.allMenus = allMenus;
	}







	public Model_RmsVo(String roleId, String roleCd, String roleNm, String description,
			List<String> empNms, List<String> emp_Id, List<String> empid, List<String> empNmss,
			List<String> menuIds, List<String> menuLabels, List<String> allMenuIds,
			List<String> allMenus) {
		super();
		this.roleId = roleId;
		this.roleCd = roleCd;
		this.roleNm = roleNm;
		this.description = description;
		this.empNms = empNms;
		this.emp_Id = emp_Id;
		this.empid = empid;
		this.empNmss = empNmss;
		this.menuIds = menuIds;
		this.menuLabels = menuLabels;
		this.allMenuIds = allMenuIds;
		this.allMenus = allMenus;
	}







	@Override
	public String toString() {
		return "Model_RmsVo [roleId=" + roleId + ", roleCd=" + roleCd + ", roleNm=" + roleNm
				+ ", description=" + description + ", empNms=" + empNms + ", emp_Id=" + emp_Id
				+ ", empid=" + empid + ", empNmss=" + empNmss + ", menuIds=" + menuIds
				+ ", menuLabels=" + menuLabels + ", allMenuIds=" + allMenuIds + ", allMenus="
				+ allMenus + "]";
	}



}
