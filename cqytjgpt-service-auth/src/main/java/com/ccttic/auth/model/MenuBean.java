package com.ccttic.auth.model;

import java.io.Serializable;

/**
   功能说明：     菜单Bean
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.res.MenuBean.java
 @date  2016年12月3日
 */

public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1845575934920201651L;
	//主键ID
	private String id;

	//资源唯一标识，必须且唯一。该资源标识进入权限控制系统的资源体系中，作为授权和权限验证的目标对象之一。
	private String resource;

	//资源显示名称
	private String label;

	//菜单项的分组名称，即所属的父级菜单资源标识。
	private String group;

	//菜单顺序
	private Integer order;

	//菜单项图标名称
	private String icon;

	//菜单描述
	private String description;
	//菜单访问路径
	private String path;

	/**
	 * 
	 */
	public MenuBean() {
		super();
	}

	/**
	 * @param id
	 * @param resource
	 * @param label
	 * @param group
	 * @param order
	 * @param icon
	 * @param description
	 * @param path
	 */
	public MenuBean(String id, String resource, String label, String group, Integer order, String icon,
			String description, String path) {
		super();
		this.id = id;
		this.resource = resource;
		this.label = label;
		this.group = group;
		this.order = order;
		this.icon = icon;
		this.description = description;
		this.path = path;
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
	 * @return the resource
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * @param resource the resource to set
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MenuBean [id=" + id + ", resource=" + resource + ", label=" + label + ", group=" + group + ", order="
				+ order + ", icon=" + icon + ", description=" + description + ", path=" + path + "]";
	}

}
