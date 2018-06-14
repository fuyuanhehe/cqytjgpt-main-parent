package com.ccttic.entity.post;

import java.io.Serializable;

import com.ccttic.entity.BaseBean;

public class EssPost extends BaseBean implements Serializable{
	private static final long serialVersionUID = -8349678655503842856L;
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
}