package com.ccttic.auth.model;

import java.io.Serializable;

/**
   功能说明：     基础属性Bean
 @version  1.0.0
 @author  sqli
 @see  com.studio.framework.beans.param.CategoryAttr.java
 @date  2016年12月12日
 */

public class CategoryAttr extends BaseBean implements Serializable {
	private static final long serialVersionUID = 2725950871498794398L;
	//分类编码
	private String categoryCd;
	//属性编码
	private String attrCd;
	//分类名称
	private String attrNm;
	//分类描述
	private String actualval;
	
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
	public String getAttrNm() {
		return attrNm;
	}
	public void setAttrNm(String attrNm) {
		this.attrNm = attrNm;
	}
	public String getActualval() {
		return actualval;
	}
	public void setActualval(String actualval) {
		this.actualval = actualval;
	}
	@Override
	public String toString() {
		return "Category [categoryCd=" + categoryCd + ", attrCd=" + attrCd + ", attrNm=" + attrNm + ", actualval=" + actualval
				+ "]";
	}
	public CategoryAttr() {
		super();
	}
	/**
	 * @param categoryCd
	 * @param attrCd
	 * @param attrNm
	 * @param actualval
	 */
	public CategoryAttr(String categoryCd, String attrCd, String attrNm, String actualval) {
		super();
		this.categoryCd = categoryCd;
		this.attrCd = attrCd;
		this.attrNm = attrNm;
		this.actualval = actualval;
	}

}
