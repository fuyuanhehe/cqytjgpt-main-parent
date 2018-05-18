package com.ccttic.auth.model;

import java.io.Serializable;

/**
   功能说明：     基础属性Bean
 @version  1.0.0
 @author  sqli
 @see  com.studio.framework.beans.param.Category.java
 @date  2016年12月12日
 */

public class Category extends BaseBean implements Serializable {
	private static final long serialVersionUID = 2725950871498794398L;
	//分类编码
	private String categoryCd;
	//属性编码
	private String attrCd;
	//分类名称
	private String categoryNm;
	//分类描述
	private String categorydesc;
	
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
	public String getCategoryNm() {
		return categoryNm;
	}
	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}
	public String getCategorydesc() {
		return categorydesc;
	}
	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}
	@Override
	public String toString() {
		return "Category [categoryCd=" + categoryCd + ", attrCd=" + attrCd + ", categoryNm=" + categoryNm + ", categorydesc=" + categorydesc
				+ "]";
	}
	public Category() {
		super();
	}
	/**
	 * @param categoryCd
	 * @param attrCd
	 * @param categoryNm
	 * @param categorydesc
	 */
	public Category(String categoryCd, String attrCd, String categoryNm, String categorydesc) {
		super();
		this.categoryCd = categoryCd;
		this.attrCd = attrCd;
		this.categoryNm = categoryNm;
		this.categorydesc = categorydesc;
	}
	
	
}
