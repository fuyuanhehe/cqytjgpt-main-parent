package com.ccttic.entity.danger;

import java.util.Date;

public class VehiDanger {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 车牌号
     */
    private String vehino;

    /**
     * 车辆种类
     */
    private String vehitype;

    /**
     * 所属企业
     */
    private String ownerenterprise;

    /**
     * 达到报废标准状态 1是，2否
     */
    private Integer scrappedstate;

    /**
     * 违法处理状态 1是，2否
     */
    private Integer illicitstate;

    /**
     * 逾期喂验审核状态 1是，2否
     */
    private Integer overdueexaminestate;

    /**
     * 事故处理状态 1是，2否
     */
    private Integer failureState;

    /**
     * 预警等级 1,2,3
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
     * 机动车关联id
     */
    private String vehicleId;

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
     * 车牌号
     * @return vehiNo 车牌号
     */
    public String getVehino() {
        return vehino;
    }

    /**
     * 车牌号
     * @param vehino 车牌号
     */
    public void setVehino(String vehino) {
        this.vehino = vehino == null ? null : vehino.trim();
    }

    /**
     * 车辆种类
     * @return vehiType 车辆种类
     */
    public String getVehitype() {
        return vehitype;
    }

    /**
     * 车辆种类
     * @param vehitype 车辆种类
     */
    public void setVehitype(String vehitype) {
        this.vehitype = vehitype == null ? null : vehitype.trim();
    }

    /**
     * 所属企业
     * @return ownerEnterprise 所属企业
     */
    public String getOwnerenterprise() {
        return ownerenterprise;
    }

    /**
     * 所属企业
     * @param ownerenterprise 所属企业
     */
    public void setOwnerenterprise(String ownerenterprise) {
        this.ownerenterprise = ownerenterprise == null ? null : ownerenterprise.trim();
    }

    /**
     * 达到报废标准状态 1是，2否
     * @return scrappedState 达到报废标准状态 1是，2否
     */
    public Integer getScrappedstate() {
        return scrappedstate;
    }

    /**
     * 达到报废标准状态 1是，2否
     * @param scrappedstate 达到报废标准状态 1是，2否
     */
    public void setScrappedstate(Integer scrappedstate) {
        this.scrappedstate = scrappedstate;
    }

    /**
     * 违法处理状态 1是，2否
     * @return illicitState 违法处理状态 1是，2否
     */
    public Integer getIllicitstate() {
        return illicitstate;
    }

    /**
     * 违法处理状态 1是，2否
     * @param illicitstate 违法处理状态 1是，2否
     */
    public void setIllicitstate(Integer illicitstate) {
        this.illicitstate = illicitstate;
    }

    /**
     * 逾期喂验审核状态 1是，2否
     * @return overdueExamineSate 逾期喂验审核状态 1是，2否
     */
    public Integer getOverdueexaminestate() {
        return overdueexaminestate;
    }

    /**
     * 逾期喂验审核状态 1是，2否
     * @param overdueexaminesate 逾期喂验审核状态 1是，2否
     */
    public void setOverdueexaminestate(Integer overdueexaminestate) {
        this.overdueexaminestate = overdueexaminestate;
    }

    /**
     * 事故处理状态 1是，2否
     * @return fullStudyState 事故处理状态 1是，2否
     */
    public Integer getFailureState() {
        return failureState;
    }

    /**
     * 事故处理状态 1是，2否
     * @param fullstudystate 事故处理状态 1是，2否
     */
    public void setFailureState(Integer failureState) {
        this.failureState = failureState;
    }

    /**
     * 预警等级 1,2,3
     * @return dangerType 预警等级 1,2,3
     */
    public String getDangertype() {
        return dangertype;
    }

    /**
     * 预警等级 1,2,3
     * @param dangertype 预警等级 1,2,3
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
     * 机动车关联id
     * @return vehicle_id 机动车关联id
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 机动车关联id
     * @param vehicleId 机动车关联id
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId == null ? null : vehicleId.trim();
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