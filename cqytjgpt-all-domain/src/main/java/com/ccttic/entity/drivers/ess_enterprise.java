package com.ccttic.entity.drivers;

import java.util.Date;
//企业基本信息实体
public class ess_enterprise {
    /** 主键ID*/
    private String id;

    /** 所属机构Id*/
    private String orgId;

    /** 企业编码*/
    private String etpcd;

    /** 企业 名称*/
    private String etpnm;

    /** 企业简称*/
    private String etpshortnm;

    /** 企业法人*/
    private String etplawer;

    /** 法人电话*/
    private String lawertel;

    /** 安全责任人*/
    private String etpsafer;

    /** 责任人电话*/
    private String safertel;

    /** 外键参照表ess_employee的id*/
    private String adminEmpid;

    /** 所属交巡警大队*/
    private String ownertraffic;

    /** 所属运管所*/
    private String ownertransport;

    /** 备注*/
    private String remark;

    /** 显示顺序*/
    private Integer disporder;

    /** 版本号*/
    private Integer version;

    /** 是否删除*/
    private Byte isdeleted;

    /** 创建时间*/
    private Date createtime;

    /** 修改时间*/
    private Date updatetime;

    /** 删除时间*/
    private Date deletetime;

    /** 创建人编码*/
    private String createby;

    /** 创建人部门编码*/
    private String createdepcd;

    /** 修改人编码*/
    private String updateby;

    /** 修改人部门编码*/
    private String updatedepcd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getEtpcd() {
        return etpcd;
    }

    public void setEtpcd(String etpcd) {
        this.etpcd = etpcd == null ? null : etpcd.trim();
    }

    public String getEtpnm() {
        return etpnm;
    }

    public void setEtpnm(String etpnm) {
        this.etpnm = etpnm == null ? null : etpnm.trim();
    }

    public String getEtpshortnm() {
        return etpshortnm;
    }

    public void setEtpshortnm(String etpshortnm) {
        this.etpshortnm = etpshortnm == null ? null : etpshortnm.trim();
    }

    public String getEtplawer() {
        return etplawer;
    }

    public void setEtplawer(String etplawer) {
        this.etplawer = etplawer == null ? null : etplawer.trim();
    }

    public String getLawertel() {
        return lawertel;
    }

    public void setLawertel(String lawertel) {
        this.lawertel = lawertel == null ? null : lawertel.trim();
    }

    public String getEtpsafer() {
        return etpsafer;
    }

    public void setEtpsafer(String etpsafer) {
        this.etpsafer = etpsafer == null ? null : etpsafer.trim();
    }

    public String getSafertel() {
        return safertel;
    }

    public void setSafertel(String safertel) {
        this.safertel = safertel == null ? null : safertel.trim();
    }

    public String getAdminEmpid() {
        return adminEmpid;
    }

    public void setAdminEmpid(String adminEmpid) {
        this.adminEmpid = adminEmpid == null ? null : adminEmpid.trim();
    }

    public String getOwnertraffic() {
        return ownertraffic;
    }

    public void setOwnertraffic(String ownertraffic) {
        this.ownertraffic = ownertraffic == null ? null : ownertraffic.trim();
    }

    public String getOwnertransport() {
        return ownertransport;
    }

    public void setOwnertransport(String ownertransport) {
        this.ownertransport = ownertransport == null ? null : ownertransport.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDisporder() {
        return disporder;
    }

    public void setDisporder(Integer disporder) {
        this.disporder = disporder;
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