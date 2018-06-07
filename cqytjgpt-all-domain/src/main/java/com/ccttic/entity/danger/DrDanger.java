package com.ccttic.entity.danger;

import java.util.Date;

public class DrDanger {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 驾驶人名称
     */
    private String drivername;

    /**
     * 身份证号码
     */
    private String driveridcard;

    /**
     * 预警等级
     */
    private String dangertype;

    /**
     * 所属交巡警大队
     */
    private String ownergener;

    /**
     * 所属运管所
     */
    private String ownerorgid;

    /**
     * 预警时间
     */
    private String dangertime;

    /**
     * 整改期限
     */
    private String correcttime;

    /**
     * 整改进度
     */
    private String correctstate;

    /**
     * 预警主题
     */
    private String dangerdesc;

    /**
     * 驾驶员关联id
     */
    private String driverId;

    /**
     * 违法处理状态 1是0否
     */
    private Integer illicitstate;

    /**
     * 事故处理状态 1是0否
     */
    private Integer failurestate;

    /**
     * 预期未换证状态 1是0否
     */
    private Integer overdueproofstate;

    /**
     * 预期未审验状态 1是0否
     */
    private Integer overdueexaminestate;

    /**
     * 满分未学习  1是0否
     */
    private Integer fullstudystate;

    /**
     * 备注
     */
    private String remark;

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
        this.id = id == null ? null : id.trim();
    }

    /**
     * 驾驶人名称
     * @return driverName 驾驶人名称
     */
    public String getDrivername() {
        return drivername;
    }

    /**
     * 驾驶人名称
     * @param drivername 驾驶人名称
     */
    public void setDrivername(String drivername) {
        this.drivername = drivername == null ? null : drivername.trim();
    }

    /**
     * 身份证号码
     * @return driverIdcard 身份证号码
     */
    public String getDriveridcard() {
        return driveridcard;
    }

    /**
     * 身份证号码
     * @param driveridcard 身份证号码
     */
    public void setDriveridcard(String driveridcard) {
        this.driveridcard = driveridcard == null ? null : driveridcard.trim();
    }

    /**
     * 预警等级
     * @return dangerType 预警等级
     */
    public String getDangertype() {
        return dangertype;
    }

    /**
     * 预警等级
     * @param dangertype 预警等级
     */
    public void setDangertype(String dangertype) {
        this.dangertype = dangertype == null ? null : dangertype.trim();
    }

    /**
     * 所属交巡警大队
     * @return ownerGener 所属交巡警大队
     */
    public String getOwnergener() {
        return ownergener;
    }

    /**
     * 所属交巡警大队
     * @param ownergener 所属交巡警大队
     */
    public void setOwnergener(String ownergener) {
        this.ownergener = ownergener == null ? null : ownergener.trim();
    }

    /**
     * 所属运管所
     * @return ownerOrgId 所属运管所
     */
    public String getOwnerorgid() {
        return ownerorgid;
    }

    /**
     * 所属运管所
     * @param ownerorgid 所属运管所
     */
    public void setOwnerorgid(String ownerorgid) {
        this.ownerorgid = ownerorgid == null ? null : ownerorgid.trim();
    }

    /**
     * 预警时间
     * @return dangerTime 预警时间
     */
    public String getDangertime() {
        return dangertime;
    }

    /**
     * 预警时间
     * @param dangertime 预警时间
     */
    public void setDangertime(String dangertime) {
        this.dangertime = dangertime == null ? null : dangertime.trim();
    }

    /**
     * 整改期限
     * @return correctTime 整改期限
     */
    public String getCorrecttime() {
        return correcttime;
    }

    /**
     * 整改期限
     * @param correcttime 整改期限
     */
    public void setCorrecttime(String correcttime) {
        this.correcttime = correcttime == null ? null : correcttime.trim();
    }

    /**
     * 整改进度
     * @return correctState 整改进度
     */
    public String getCorrectstate() {
        return correctstate;
    }

    /**
     * 整改进度
     * @param correctstate 整改进度
     */
    public void setCorrectstate(String correctstate) {
        this.correctstate = correctstate == null ? null : correctstate.trim();
    }

    /**
     * 预警主题
     * @return dangerDesc 预警主题
     */
    public String getDangerdesc() {
        return dangerdesc;
    }

    /**
     * 预警主题
     * @param dangerdesc 预警主题
     */
    public void setDangerdesc(String dangerdesc) {
        this.dangerdesc = dangerdesc == null ? null : dangerdesc.trim();
    }

    /**
     * 驾驶员关联id
     * @return driver_id 驾驶员关联id
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * 驾驶员关联id
     * @param driverId 驾驶员关联id
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    /**
     * 违法处理状态 1是0否
     * @return illicitState 违法处理状态 1是0否
     */
    public Integer getIllicitstate() {
        return illicitstate;
    }

    /**
     * 违法处理状态 1是0否
     * @param illicitstate 违法处理状态 1是0否
     */
    public void setIllicitstate(Integer illicitstate) {
        this.illicitstate = illicitstate;
    }

    /**
     * 事故处理状态 1是0否
     * @return failureState 事故处理状态 1是0否
     */
    public Integer getFailurestate() {
        return failurestate;
    }

    /**
     * 事故处理状态 1是0否
     * @param failurestate 事故处理状态 1是0否
     */
    public void setFailurestate(Integer failurestate) {
        this.failurestate = failurestate;
    }

    /**
     * 预期未换证状态 1是0否
     * @return overdueProofState 预期未换证状态 1是0否
     */
    public Integer getOverdueproofstate() {
        return overdueproofstate;
    }

    /**
     * 预期未换证状态 1是0否
     * @param overdueproofstate 预期未换证状态 1是0否
     */
    public void setOverdueproofstate(Integer overdueproofstate) {
        this.overdueproofstate = overdueproofstate;
    }

    /**
     * 预期未审验状态 1是0否
     * @return overdueExamineState 预期未审验状态 1是0否
     */
    public Integer getOverdueexaminestate() {
        return overdueexaminestate;
    }

    /**
     * 预期未审验状态 1是0否
     * @param overdueexaminestate 预期未审验状态 1是0否
     */
    public void setOverdueexaminestate(Integer overdueexaminestate) {
        this.overdueexaminestate = overdueexaminestate;
    }

    /**
     * 满分未学习  1是0否
     * @return fullStudyState 满分未学习  1是0否
     */
    public Integer getFullstudystate() {
        return fullstudystate;
    }

    /**
     * 满分未学习  1是0否
     * @param fullstudystate 满分未学习  1是0否
     */
    public void setFullstudystate(Integer fullstudystate) {
        this.fullstudystate = fullstudystate;
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
        this.remark = remark == null ? null : remark.trim();
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
        this.createby = createby == null ? null : createby.trim();
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
        this.createdepcd = createdepcd == null ? null : createdepcd.trim();
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
        this.updateby = updateby == null ? null : updateby.trim();
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
        this.updatedepcd = updatedepcd == null ? null : updatedepcd.trim();
    }
}