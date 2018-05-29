package com.ccttic.entity.role.vo;

import java.io.Serializable;

/**
 * 
 * @author syao
 * 所有角色对应资源VO
 *
 */
public class RoleMenuVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***
	 * 角色编码
	 */
	private String roleCd;
	/**
	 * 角色名称
	 */
	private String roleNm;
	/**
	 * 菜单ID
	 */
	private String menu_id;
	/**
	 * 菜单URL
	 */
	private String path;
	
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
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
