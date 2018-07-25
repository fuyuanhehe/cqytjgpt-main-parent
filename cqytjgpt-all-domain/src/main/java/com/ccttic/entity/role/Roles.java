package com.ccttic.entity.role;

import java.util.List;

public class Roles {	

	/**
	 * 	自定义角色员工菜单关联实体
	 */
	//role_emp 的ID
	private String id ;
	//角色编码
	private String roleCd;
	//角色名称
	private String roleNm;
	//角色描述
	private String description;
	//是否默认数据，true 默认，不允许删除，false 非默认，用户自定义
	protected Boolean isDefault;
	//角色关联人员ID
	private String empNms;	
	//角色关联人员ID
	private String empIds;
	//角色ID
	private String roleId;
	//角色包含的菜单ID
	private  String menuIds;
	//角色包含的菜单名
	private String menuLabels;
	//员工ID
	private String emp_id;
	//员工id
	private List<String> emporIds;

	//员工账号
	private List<String> emporNms;

	private List<String> list;

	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<String> getEmporNms() {
		return emporNms;
	}

	public void setEmporNms(List<String> emporNms) {
		this.emporNms = emporNms;
	}

	public List<String> getEmporIds() {
		return emporIds;
	}

	public void setEmporIds(List<String> emporIds) {
		this.emporIds = emporIds;
	}

	public Roles(List<String> emporIds) {
		super();
		this.emporIds = emporIds;
	}

	public Roles() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getEmpNms() {
		return empNms;
	}

	public void setEmpNms(String empNms) {
		this.empNms = empNms;
	}

	public String getEmpIds() {
		return empIds;
	}

	public void setEmpIds(String empIds) {
		this.empIds = empIds;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public String getMenuLabels() {
		return menuLabels;
	}

	public void setMenuLabels(String menuLabels) {
		this.menuLabels = menuLabels;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public Roles(String id, String roleCd, String roleNm, String description, Boolean isDefault,
			String empNms, String empIds, String roleId, String menuIds, String menuLabels,
			String emp_id) {
		super();
		this.id = id;
		this.roleCd = roleCd;
		this.roleNm = roleNm;
		this.description = description;
		this.isDefault = isDefault;
		this.empNms = empNms;
		this.empIds = empIds;
		this.roleId = roleId;
		this.menuIds = menuIds;
		this.menuLabels = menuLabels;
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", roleCd=" + roleCd + ", roleNm=" + roleNm + ", description="
				+ description + ", isDefault=" + isDefault + ", empNms=" + empNms + ", empIds="
				+ empIds + ", roleId=" + roleId + ", menuIds=" + menuIds + ", menuLabels="
				+ menuLabels + ", emp_id=" + emp_id + "]";
	}




}
