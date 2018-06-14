package com.ccttic.auth.model;

import java.io.Serializable;

/**
   功能说明：     岗位信息
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.Contract.java
 @date  2016年12月6日
 */

public class Post extends BaseBean implements Serializable {
	private static final long serialVersionUID = -7190659009549506998L;
	//岗位类型
	private String postType = PostCategoryEnum.BPost.name();
	//岗位编码
	private String postCd;
	//岗位名称
	private String postNm;
	//岗位描述
	private String description;
	//是否默认数据，true 默认，不允许删除，false 非默认，用户自定义
	protected Boolean isDefault;
	//岗位包含的人员ID
	private String empIds;
	//岗位包含的人员编号
	private String empCds;
	//岗位包含的人员名称
	private String empNms;

	/**
	 * 
	 */
	public Post() {
		super();
	}


	/**
	 * @param postType
	 * @param postCd
	 * @param postNm
	 * @param description
	 * @param isDefault
	 * @param empIds
	 * @param empCds
	 * @param empNms
	 */
	public Post(String postType, String postCd, String postNm, String description, Boolean isDefault, String empIds,
			String empCds, String empNms) {
		super();
		this.postType = postType;
		this.postCd = postCd;
		this.postNm = postNm;
		this.description = description;
		this.isDefault = isDefault;
		this.empIds = empIds;
		this.empCds = empCds;
		this.empNms = empNms;
	}


	/**
	 * @return the postType
	 */
	public String getPostType() {
		return postType;
	}

	/**
	 * @param postType the postType to set
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}

	/**
	 * @return the postCd
	 */
	public String getPostCd() {
		return postCd;
	}

	/**
	 * @param postCd the postCd to set
	 */
	public void setPostCd(String postCd) {
		this.postCd = postCd;
	}

	/**
	 * @return the postNm
	 */
	public String getPostNm() {
		return postNm;
	}

	/**
	 * @param postNm the postNm to set
	 */
	public void setPostNm(String postNm) {
		this.postNm = postNm;
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
		return "Post [postType=" + postType + ", postCd=" + postCd + ", postNm=" + postNm + ", description="
				+ description + ", isDefault=" + isDefault + ", empIds=" + empIds + ", empCds=" + empCds + ", empNms="
				+ empNms + ", id=" + id + "]";
	}

}
