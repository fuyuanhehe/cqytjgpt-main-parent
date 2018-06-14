package com.ccttic.auth.model;

import java.io.Serializable;

/**
   功能说明：    人员菜单关系
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.RoleEmp.java
 @date  2016年12月11日
 */

public class RoleMenu implements Serializable {
	private static final long serialVersionUID = 7111761623751187515L;
	//主键ID
	private String id;
	//角色ID
	private String roleId;
	//角色ID
	private String menuId;
	//版本号
	private Integer version;

	/**
	 * 
	 */
	public RoleMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param roleId
	 * @param menuId
	 * @param version
	 */
	public RoleMenu(String id, String roleId, String menuId, Integer version) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
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
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
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
		return "EmpMenu [id=" + id + ", roleId=" + roleId + ", menuId=" + menuId + ", version=" + version + "]";
	}

}
