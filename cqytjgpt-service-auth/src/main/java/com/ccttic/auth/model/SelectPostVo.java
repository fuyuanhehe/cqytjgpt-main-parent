package com.ccttic.auth.model;

import java.io.Serializable;

/**
   功能说明：     岗位用于下来显示VO
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.SelectContractVo.java
 @date  2016年12月12日
 */

public class SelectPostVo implements Serializable {
	private static final long serialVersionUID = -680358912204543502L;
	private String id;
	private String text;

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

}
