package com.ccttic.entity.role;

import java.io.Serializable;

import com.ccttic.entity.BaseBean;

/**
   功能说明：     岗位信息
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.Role.java
 @date  2016年12月7日
 */

public class Role extends BaseBean implements Serializable {
	private static final long serialVersionUID = 4734568568509158754L;
	//角色编码
	private String roleCd;
	//角色名称
	private String roleNm;
	//角色描述
	private String description;
	//是否默认数据，true 默认，不允许删除，false 非默认，用户自定义
	protected Boolean isDefault;
	//角色包含的菜单ID
	private String menuIds;
	//角色包含的菜单名
	private String menuLabels;
	//角色关联人员ID
	private String empIds;
	//角色关联人员ID
	private String empCds;
	//角色关联人员ID
	private String empNms;

	/**
	 * 
	 */
	public Role() {
		super();
	}

	

	/**
	 * @param roleCd
	 * @param roleNm
	 * @param description
	 * @param isDefault
	 * @param menuIds
	 * @param menuLabels
	 * @param empIds
	 * @param empCds
	 * @param empNms
	 */
	public Role(String roleCd, String roleNm, String description, Boolean isDefault, String menuIds, String menuLabels,
			String empIds, String empCds, String empNms) {
		super();
		this.roleCd = roleCd;
		this.roleNm = roleNm;
		this.description = description;
		this.isDefault = isDefault;
		this.menuIds = menuIds;
		this.menuLabels = menuLabels;
		this.empIds = empIds;
		this.empCds = empCds;
		this.empNms = empNms;
	}



	/**
	 * @return the roleCd
	 */
	public String getRoleCd() {
		return roleCd;
	}

	/**
	 * @param roleCd the roleCd to set
	 */
	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

	/**
	 * @return the roleNm
	 */
	public String getRoleNm() {
		return roleNm;
	}

	/**
	 * @param roleNm the roleNm to set
	 */
	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the isDefault
	 */
	public Boolean getIsDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault the isDefault to set
	 */
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return the menuIds
	 */
	public String getMenuIds() {
		return menuIds;
	}

	/**
	 * @param menuIds the menuIds to set
	 */
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	/**
	 * @return the menuLabels
	 */
	public String getMenuLabels() {
		return menuLabels;
	}

	/**
	 * @param menuLabels the menuLabels to set
	 */
	public void setMenuLabels(String menuLabels) {
		this.menuLabels = menuLabels;
	}

	/**
	 * @return the empIds
	 */
	public String getEmpIds() {
		return empIds;
	}

	/**
	 * @param empIds the empIds to set
	 */
	public void setEmpIds(String empIds) {
		this.empIds = empIds;
	}

	/**
	 * @return the empCds
	 */
	public String getEmpCds() {
		return empCds;
	}

	/**
	 * @param empCds the empCds to set
	 */
	public void setEmpCds(String empCds) {
		this.empCds = empCds;
	}

	/**
	 * @return the empNms
	 */
	public String getEmpNms() {
		return empNms;
	}

	/**
	 * @param empNms the empNms to set
	 */
	public void setEmpNms(String empNms) {
		this.empNms = empNms;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [roleCd=" + roleCd + ", roleNm=" + roleNm + ", description=" + description + ", isDefault="
				+ isDefault + ", menuIds=" + menuIds + ", menuLabels=" + menuLabels + ", empIds=" + empIds + ", empCds="
				+ empCds + ", empNms=" + empNms + ", id=" + id + "]";
	}

}
