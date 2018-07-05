package com.ccttic.entity.role.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
   功能说明：     数型结构VO
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.TreeVo.java
 @date  2016年12月12日
 */

public class TreeVo implements Serializable {
	private static final long serialVersionUID = 3020232184197690022L;
	/**
	 * id 
	 */
	public String id;
	/**
	 * 名称 
	 */
	public String text;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 父id
	 */
	private String superOrgId;
	/**
	 * 树型结构的外加属性
	 */
	private Map<String, String> attributes = new HashMap<String, String>();

	/**
	 * 节点图标
	 */
	private String iconCls;

	/**
	 * 子结点
	 */
	public List<TreeVo> children;

	public TreeVo() {
		children = new ArrayList<TreeVo>();
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the children
	 */
	public List<TreeVo> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<TreeVo> children) {
		this.children = children;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSuperOrgId() {
		return superOrgId;
	}

	public void setSuperOrgId(String superOrgId) {
		this.superOrgId = superOrgId;
	}
	

}
