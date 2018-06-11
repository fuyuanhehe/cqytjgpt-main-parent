package com.ccttic.entity.role;

public class RoleModels {
	//角色ID
	private String roleId ;
	//角色编码
	private String roleCd;
	//角色名称
	private String roleNm;
	//角色描述
	private String description;
	//是否默认数据，true 默认，不允许删除，false 非默认，用户自定义
	protected Boolean isDefault;
	public RoleModels() {
		// TODO Auto-generated constructor stub
	}
	public RoleModels(String roleId, String roleCd, String roleNm, String description,
			Boolean isDefault) {
		super();
		this.roleId = roleId;
		this.roleCd = roleCd;
		this.roleNm = roleNm;
		this.description = description;
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "RoleModels [roleId=" + roleId + ", roleCd=" + roleCd + ", roleNm=" + roleNm
				+ ", description=" + description + ", isDefault=" + isDefault + "]";
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
	public Boolean getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	
}
