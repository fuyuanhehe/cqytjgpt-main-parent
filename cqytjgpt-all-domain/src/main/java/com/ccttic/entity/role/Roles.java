package com.ccttic.entity.role;

public class Roles {

	/**
	 * 	自定义角色员工菜单关联实体
	 */
	private static final long serialVersionUID = 1L;
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
	private String menuIds;
	//角色包含的菜单名
	private String menuLabels;
	//员工ID
	private String emp_id;

	
	
	
	public Roles(String emp_id) {
		super();
		this.emp_id = emp_id;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public  Roles() { super();}

	public Roles(String id, String roleCd, String roleNm, String description, Boolean isDefault, String empNms,
			String empIds, String roleId, String menuIds, String menuLabels) {
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
	}

	@Override
	public String toString() {
		return "Roles [emp_id=" + emp_id + "]";
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

   
	
	



}
