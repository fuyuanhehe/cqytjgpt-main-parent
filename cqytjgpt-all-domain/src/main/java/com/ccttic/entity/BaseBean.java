package com.ccttic.entity;

import java.util.Date;

/**
   功能说明：     
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.BaseBean.java
 @date  2016年12月3日
 */

public abstract class BaseBean {
	//已经删除
	public static final boolean ISDELETE = true;
	// 未删除
	public static final boolean NOTDELETE = false;
	//主键ID
	protected String id;
	 /**
     * 版本号
     */
    private Integer version;

    /**
     * 是否删除
     */
    private Boolean isdeleted = false;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 创建人编码
     */
    private String createby;

    /**
     * 创建人部门编码
     */
    private String createdepcd;

    /**
     * 修改人编码
     */
    private String updateby;

    /**
     * 修改人部门编码
     */
    private String updatedepcd;




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


	public Boolean getIsdeleted() {
		return isdeleted;
	}


	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public Date getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public Date getDeletetime() {
		return deletetime;
	}


	public void setDeletetime(Date deletetime) {
		this.deletetime = deletetime;
	}


	public String getCreateby() {
		return createby;
	}


	public void setCreateby(String createby) {
		this.createby = createby;
	}


	public String getCreatedepcd() {
		return createdepcd;
	}


	public void setCreatedepcd(String createdepcd) {
		this.createdepcd = createdepcd;
	}


	public String getUpdateby() {
		return updateby;
	}


	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}


	public String getUpdatedepcd() {
		return updatedepcd;
	}


	public void setUpdatedepcd(String updatedepcd) {
		this.updatedepcd = updatedepcd;
	}


}
