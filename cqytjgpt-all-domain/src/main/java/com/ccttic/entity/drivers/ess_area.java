package com.ccttic.entity.drivers;

import java.util.Date;
//行政区域表实体
public class ess_area {
    /** 主键id*/
    private String id;

    /** 行政区域代码*/
    private String areacd;

    /** 行政区域名称*/
    private String areanm;

    /** 行政区域简称*/
    private String shortnm;

    /** 行政区域电子围栏*/
    private String boundary;

    /** 备注*/
    private String remark;

    /** 版本*/
    private Integer version;

    /** 是否删除*/
    private Byte isdeleted;

    /** 创建时间*/
    private Date createtime;

    /** 更新时间*/
    private Date updatetime;

    /** 删除时间*/
    private Date deletetime;

    /** 创建人CD*/
    private String createby;

    /** 创建部门CD*/
    private String createdepcd;

    /** 更新人CD*/
    private String updateby;

    /** 更新部门CD*/
    private String updatedepcd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAreacd() {
        return areacd;
    }

    public void setAreacd(String areacd) {
        this.areacd = areacd == null ? null : areacd.trim();
    }

    public String getAreanm() {
        return areanm;
    }

    public void setAreanm(String areanm) {
        this.areanm = areanm == null ? null : areanm.trim();
    }

    public String getShortnm() {
        return shortnm;
    }

    public void setShortnm(String shortnm) {
        this.shortnm = shortnm == null ? null : shortnm.trim();
    }

    public String getBoundary() {
        return boundary;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary == null ? null : boundary.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Byte getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Byte isdeleted) {
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
        this.createby = createby == null ? null : createby.trim();
    }

    public String getCreatedepcd() {
        return createdepcd;
    }

    public void setCreatedepcd(String createdepcd) {
        this.createdepcd = createdepcd == null ? null : createdepcd.trim();
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public String getUpdatedepcd() {
        return updatedepcd;
    }

    public void setUpdatedepcd(String updatedepcd) {
        this.updatedepcd = updatedepcd == null ? null : updatedepcd.trim();
    }
}