package com.ccttic.entity.category.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
   功能说明：     
 @version  1.0.0
 @author  sqli
 @see  com.studio.framework.beans.param.TreeCategoryBean.java
 @date  2016年12月26日
 */

public class TreeCategoryBean implements Serializable {
	private static final long serialVersionUID = 3423926662762398978L;
	//主键ID
	private String id;
	//名称
	private String categoryNm;
	//编码
	private String categoryCd;
	//属性编码
	private String attrCd;
	//描述
	private String categorydesc;
	//状态
	private String state;
	//属性
	private List<TreeCategoryBean> children = new ArrayList<TreeCategoryBean>();

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

	public String getCategoryNm() {
		return categoryNm;
	}

	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}

	public String getCategoryCd() {
		return categoryCd;
	}

	public void setCategoryCd(String categoryCd) {
		this.categoryCd = categoryCd;
	}

	public String getAttrCd() {
		return attrCd;
	}

	public void setAttrCd(String attrCd) {
		this.attrCd = attrCd;
	}

	public String getCategorydesc() {
		return categorydesc;
	}

	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the children
	 */
	public List<TreeCategoryBean> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<TreeCategoryBean> children) {
		this.children = children;
	}

}
