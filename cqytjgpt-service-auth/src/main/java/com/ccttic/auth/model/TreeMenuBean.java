package com.ccttic.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
   功能说明：     树形Bean
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.res.TreeMenuBean.java
 @date  2016年12月26日
 */

public class TreeMenuBean implements Serializable {
	private static final long serialVersionUID = 3423926662762398978L;
	//主键ID
	private String id;
	//资源显示名称
	private String lable;
	//功能类型（默认：菜单）
	private String type = "菜单";
	//资源描述
	private String desc;
	//是否选中
	private boolean isChecked = false;
	private String state = "opened";
	private String parentId;
	//子菜单
	private List<TreeMenuBean> children = new ArrayList<TreeMenuBean>();

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
	 * @return the lable
	 */
	public String getLable() {
		return lable;
	}

	/**
	 * @param lable the lable to set
	 */
	public void setLable(String lable) {
		this.lable = lable;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the isChecked
	 */
	public boolean isChecked() {
		return isChecked;
	}

	/**
	 * @param isChecked the isChecked to set
	 */
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the children
	 */
	public List<TreeMenuBean> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<TreeMenuBean> children) {
		this.children = children;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
