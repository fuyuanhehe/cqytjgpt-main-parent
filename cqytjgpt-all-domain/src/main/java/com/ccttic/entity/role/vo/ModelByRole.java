package com.ccttic.entity.role.vo;

import java.util.List;
//角色对应菜单Vo
public class ModelByRole {

	//角色名字
	private String roleNm;

	 //角色对应的菜单
	private List<Model_MenuVo> menus;
	
	public ModelByRole() {
		// TODO Auto-generated constructor stub
	}

	public String getRoleNm() {
		return roleNm;
	}

	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	public List<Model_MenuVo> getMenus() {
		return menus;
	}

	public void setMenus(List<Model_MenuVo> menus) {
		this.menus = menus;
	}

	public ModelByRole(String roleNm, List<Model_MenuVo> menus) {
		super();
		this.roleNm = roleNm;
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "ModelByRole [roleNm=" + roleNm + ", menus=" + menus + "]";
	}

	
	
}
