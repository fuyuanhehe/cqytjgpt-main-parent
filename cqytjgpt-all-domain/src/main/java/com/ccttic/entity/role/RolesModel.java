package com.ccttic.entity.role;

import java.util.List;

import com.ccttic.entity.employee.ResMenu;

public class RolesModel {
	//菜单
	private List<ResMenu> menus;
	//角色
	private List<RoleModels> roles;

	public RolesModel() {
		// TODO Auto-generated constructor stub
	}

	public RolesModel(List<ResMenu> menus, List<RoleModels> roles) {
		super();
		this.menus = menus;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "RolesModel [menus=" + menus + ", roles=" + roles + "]";
	}

	public List<ResMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<ResMenu> menus) {
		this.menus = menus;
	}

	public List<RoleModels> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModels> roles) {
		this.roles = roles;
	}

}
