package com.ccttic.entity.role.vo;
// 角色菜单Vo
public class Model_menus {

	//角色ID
	private String roleId;
	//角色编码
	private String roleCd;
	//角色名称
	private String roleNm;
	//角色描述
	private String roleDesc;
	//是否默认数据，true 默认，不允许删除，false 非默认，用户自定义
	protected Boolean isDefault;
	/**
	 * 主键ID
	 */
	private String id;

	/**
	 * 菜单资源标识
	 */
	private String resource;

	/**
	 * 菜单资源中文名
	 */
	private String label;

	/**
	 * 父菜单资源标识
	 */
	private String groupresource;

	/**
	 * 菜单排序号
	 */
	private Integer sortorder;

	/**
	 * 菜单图标
	 */
	private String icon;

	/**
	 * 菜单描述
	 */
	private String description;

	/**
	 * 菜单访问路径
	 */
	private String path;

	/**
	 * 资源类型（菜单or按钮）
	 */
	private String ismenu;

	/**
	 * 层级（菜单类型时）
	 */
	private Integer hierarchy;

   public Model_menus() {
	// TODO Auto-generated constructor stub
}

public Model_menus(String roleId, String roleCd, String roleNm, String roleDesc, Boolean isDefault,
		String id, String resource, String label, String groupresource, Integer sortorder,
		String icon, String description, String path, String ismenu, Integer hierarchy) {
	super();
	this.roleId = roleId;
	this.roleCd = roleCd;
	this.roleNm = roleNm;
	this.roleDesc = roleDesc;
	this.isDefault = isDefault;
	this.id = id;
	this.resource = resource;
	this.label = label;
	this.groupresource = groupresource;
	this.sortorder = sortorder;
	this.icon = icon;
	this.description = description;
	this.path = path;
	this.ismenu = ismenu;
	this.hierarchy = hierarchy;
}

@Override
public String toString() {
	return "Model_menus [roleId=" + roleId + ", roleCd=" + roleCd + ", roleNm=" + roleNm
			+ ", roleDesc=" + roleDesc + ", isDefault=" + isDefault + ", id=" + id + ", resource="
			+ resource + ", label=" + label + ", groupresource=" + groupresource + ", sortorder="
			+ sortorder + ", icon=" + icon + ", description=" + description + ", path=" + path
			+ ", ismenu=" + ismenu + ", hierarchy=" + hierarchy + "]";
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

public String getRoleDesc() {
	return roleDesc;
}

public void setRoleDesc(String roleDesc) {
	this.roleDesc = roleDesc;
}

public Boolean getIsDefault() {
	return isDefault;
}

public void setIsDefault(Boolean isDefault) {
	this.isDefault = isDefault;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getResource() {
	return resource;
}

public void setResource(String resource) {
	this.resource = resource;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public String getGroupresource() {
	return groupresource;
}

public void setGroupresource(String groupresource) {
	this.groupresource = groupresource;
}

public Integer getSortorder() {
	return sortorder;
}

public void setSortorder(Integer sortorder) {
	this.sortorder = sortorder;
}

public String getIcon() {
	return icon;
}

public void setIcon(String icon) {
	this.icon = icon;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

public String getIsmenu() {
	return ismenu;
}

public void setIsmenu(String ismenu) {
	this.ismenu = ismenu;
}

public Integer getHierarchy() {
	return hierarchy;
}

public void setHierarchy(Integer hierarchy) {
	this.hierarchy = hierarchy;
}
   

}
