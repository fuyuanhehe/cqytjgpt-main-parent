package com.ccttic.entity.post;

import java.util.Date;

public class EssPost {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 
     */
    private String depId;

    /**
     * 岗位类型
     */
    private String posttype;

    /**
     * 岗位编码
     */
    private String postcd;

    /**
     * 岗位描述
     */
    private String description;

    /**
     * 岗位名称
     */
    private String postnm;

    /**
     * 是否默认
     */
    private Boolean isdefault;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 是否删除
     */
    private Boolean isdeleted;

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
     * 创建人机构编码
     */
    private String createdepcd;

    /**
     * 修改人编码
     */
    private String updateby;

    /**
     * 修改人机构编码
     */
    private String updatedepcd;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return org_id 
     */
    public String getdepId() {
        return depId;
    }

    /**
     * 
     * @param depId 
     */
    public void setdepId(String depId) {
        this.depId = depId;
    }

    /**
     * 岗位类型
     * @return postType 岗位类型
     */
    public String getPosttype() {
        return posttype;
    }

    /**
     * 岗位类型
     * @param posttype 岗位类型
     */
    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    /**
     * 岗位编码
     * @return postCd 岗位编码
     */
    public String getPostcd() {
        return postcd;
    }

    /**
     * 岗位编码
     * @param postcd 岗位编码
     */
    public void setPostcd(String postcd) {
        this.postcd = postcd;
    }

    /**
     * 岗位描述
     * @return description 岗位描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 岗位描述
     * @param description 岗位描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 岗位名称
     * @return postNm 岗位名称
     */
    public String getPostnm() {
        return postnm;
    }

    /**
     * 岗位名称
     * @param postnm 岗位名称
     */
    public void setPostnm(String postnm) {
        this.postnm = postnm;
    }

    /**
     * 是否默认
     * @return isDefault 是否默认
     */
    public Boolean getIsdefault() {
        return isdefault;
    }

    /**
     * 是否默认
     * @param isdefault 是否默认
     */
    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * 版本号
     * @return version 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 版本号
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 是否删除
     * @return isDeleted 是否删除
     */
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    /**
     * 是否删除
     * @param isdeleted 是否删除
     */
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    /**
     * 创建时间
     * @return createTime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 修改时间
     * @return updateTime 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 修改时间
     * @param updatetime 修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 删除时间
     * @return deleteTime 删除时间
     */
    public Date getDeletetime() {
        return deletetime;
    }

    /**
     * 删除时间
     * @param deletetime 删除时间
     */
    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    /**
     * 创建人编码
     * @return createBy 创建人编码
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * 创建人编码
     * @param createby 创建人编码
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }

    /**
     * 创建人机构编码
     * @return createDepCd 创建人机构编码
     */
    public String getCreatedepcd() {
        return createdepcd;
    }

    /**
     * 创建人机构编码
     * @param createdepcd 创建人机构编码
     */
    public void setCreatedepcd(String createdepcd) {
        this.createdepcd = createdepcd;
    }

    /**
     * 修改人编码
     * @return updateBy 修改人编码
     */
    public String getUpdateby() {
        return updateby;
    }

    /**
     * 修改人编码
     * @param updateby 修改人编码
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    /**
     * 修改人机构编码
     * @return updateDepCd 修改人机构编码
     */
    public String getUpdatedepcd() {
        return updatedepcd;
    }

    /**
     * 修改人机构编码
     * @param updatedepcd 修改人机构编码
     */
    public void setUpdatedepcd(String updatedepcd) {
        this.updatedepcd = updatedepcd;
    }
}