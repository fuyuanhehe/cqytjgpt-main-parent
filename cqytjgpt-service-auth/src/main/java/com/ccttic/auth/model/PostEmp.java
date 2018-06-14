package com.ccttic.auth.model;

import java.io.Serializable;

/**
   功能说明：     岗位人员关联关系
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.PostEmp.java
 @date  2016年12月10日
 */

public class PostEmp implements Serializable {
	private static final long serialVersionUID = 5983922315582443555L;
	//主键ID
	private String id;
	//员工ID
	private String empId;
	//员工编号
	private String empCd;
	//员工姓名
	private String empNm;
	//岗位ID
	private String postId;
	//岗位编号
	private String postCd;
	//岗位名称
	private String postNm;
	//版本号
	private Integer version;

	/**
	 * 
	 */
	public PostEmp() {
		super();
	}

	/**
	 * @param id
	 * @param empId
	 * @param postId
	 * @param version
	 */
	public PostEmp(String id, String empId, String postId, Integer version) {
		super();
		this.id = id;
		this.empId = empId;
		this.postId = postId;
		this.version = version;
	}

	/**
	 * @param id
	 * @param empId
	 * @param empCd
	 * @param empNm
	 * @param postId
	 * @param postCd
	 * @param postNm
	 * @param version
	 */
	public PostEmp(String id, String empId, String empCd, String empNm, String postId, String postCd, String postNm,
			Integer version) {
		super();
		this.id = id;
		this.empId = empId;
		this.empCd = empCd;
		this.empNm = empNm;
		this.postId = postId;
		this.postCd = postCd;
		this.postNm = postNm;
		this.version = version;
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
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the empCd
	 */
	public String getEmpCd() {
		return empCd;
	}

	/**
	 * @param empCd the empCd to set
	 */
	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}

	/**
	 * @return the empNm
	 */
	public String getEmpNm() {
		return empNm;
	}

	/**
	 * @param empNm the empNm to set
	 */
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	/**
	 * @return the postId
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(String postId) {
		this.postId = postId;
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
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostEmp [id=" + id + ", empId=" + empId + ", empCd=" + empCd + ", empNm=" + empNm + ", postId=" + postId
				+ ", postCd=" + postCd + ", postNm=" + postNm + ", version=" + version + "]";
	}

}
