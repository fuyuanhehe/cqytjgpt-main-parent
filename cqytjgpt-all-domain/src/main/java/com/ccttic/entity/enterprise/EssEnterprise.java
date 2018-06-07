package com.ccttic.entity.enterprise;

import java.util.Date;

public class EssEnterprise {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 所属机构Id
     */
    private String orgId;

    /**
     * 企业编码
     */
    private String etpcd;

    /**
     * 企业 名称
     */
    private String etpnm;

    /**
     * 企业简称
     */
    private String etpshortnm;

    /**
     * 企业法人
     */
    private String etplawer;

    /**
     * 法人电话
     */
    private String lawertel;

    /**
     * 安全责任人
     */
    private String etpsafer;

    /**
     * 责任人电话
     */
    private String safertel;

    /**
     * 外键参照表ess_employee的id
     */
    private String adminEmpid;

    /**
     * 所属交巡警大队
     */
    private String ownertraffic;

    /**
     * 所属运管所
     */
    private String ownertransport;

    /**
     * 备注
     */
    private String remark;

    /**
     * 显示顺序
     */
    private Integer disporder;

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
     * 所属机构Id
     * @return org_id 所属机构Id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 所属机构Id
     * @param orgId 所属机构Id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 企业编码
     * @return etpCd 企业编码
     */
    public String getEtpcd() {
        return etpcd;
    }

    /**
     * 企业编码
     * @param etpcd 企业编码
     */
    public void setEtpcd(String etpcd) {
        this.etpcd = etpcd;
    }

    /**
     * 企业 名称
     * @return etpNm 企业 名称
     */
    public String getEtpnm() {
        return etpnm;
    }

    /**
     * 企业 名称
     * @param etpnm 企业 名称
     */
    public void setEtpnm(String etpnm) {
        this.etpnm = etpnm;
    }

    /**
     * 企业简称
     * @return etpshortNm 企业简称
     */
    public String getEtpshortnm() {
        return etpshortnm;
    }

    /**
     * 企业简称
     * @param etpshortnm 企业简称
     */
    public void setEtpshortnm(String etpshortnm) {
        this.etpshortnm = etpshortnm;
    }

    /**
     * 企业法人
     * @return etpLawer 企业法人
     */
    public String getEtplawer() {
        return etplawer;
    }

    /**
     * 企业法人
     * @param etplawer 企业法人
     */
    public void setEtplawer(String etplawer) {
        this.etplawer = etplawer;
    }

    /**
     * 法人电话
     * @return lawerTel 法人电话
     */
    public String getLawertel() {
        return lawertel;
    }

    /**
     * 法人电话
     * @param lawertel 法人电话
     */
    public void setLawertel(String lawertel) {
        this.lawertel = lawertel;
    }

    /**
     * 安全责任人
     * @return etpSafer 安全责任人
     */
    public String getEtpsafer() {
        return etpsafer;
    }

    /**
     * 安全责任人
     * @param etpsafer 安全责任人
     */
    public void setEtpsafer(String etpsafer) {
        this.etpsafer = etpsafer;
    }

    /**
     * 责任人电话
     * @return saferTel 责任人电话
     */
    public String getSafertel() {
        return safertel;
    }

    /**
     * 责任人电话
     * @param safertel 责任人电话
     */
    public void setSafertel(String safertel) {
        this.safertel = safertel;
    }

    /**
     * 外键参照表ess_employee的id
     * @return admin_empid 外键参照表ess_employee的id
     */
    public String getAdminEmpid() {
        return adminEmpid;
    }

    /**
     * 外键参照表ess_employee的id
     * @param adminEmpid 外键参照表ess_employee的id
     */
    public void setAdminEmpid(String adminEmpid) {
        this.adminEmpid = adminEmpid;
    }

    /**
     * 所属交巡警大队
     * @return ownerTraffic 所属交巡警大队
     */
    public String getOwnertraffic() {
        return ownertraffic;
    }

    /**
     * 所属交巡警大队
     * @param ownertraffic 所属交巡警大队
     */
    public void setOwnertraffic(String ownertraffic) {
        this.ownertraffic = ownertraffic;
    }

    /**
     * 所属运管所
     * @return ownerTransport 所属运管所
     */
    public String getOwnertransport() {
        return ownertransport;
    }

    /**
     * 所属运管所
     * @param ownertransport 所属运管所
     */
    public void setOwnertransport(String ownertransport) {
        this.ownertransport = ownertransport;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 显示顺序
     * @return dispOrder 显示顺序
     */
    public Integer getDisporder() {
        return disporder;
    }

    /**
     * 显示顺序
     * @param disporder 显示顺序
     */
    public void setDisporder(Integer disporder) {
        this.disporder = disporder;
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
     * 创建人部门编码
     * @return createDepCd 创建人部门编码
     */
    public String getCreatedepcd() {
        return createdepcd;
    }

    /**
     * 创建人部门编码
     * @param createdepcd 创建人部门编码
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
     * 修改人部门编码
     * @return updateDepCd 修改人部门编码
     */
    public String getUpdatedepcd() {
        return updatedepcd;
    }

    /**
     * 修改人部门编码
     * @param updatedepcd 修改人部门编码
     */
    public void setUpdatedepcd(String updatedepcd) {
        this.updatedepcd = updatedepcd;
    }
}