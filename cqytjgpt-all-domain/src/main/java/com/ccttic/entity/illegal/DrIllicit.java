package com.ccttic.entity.illegal;

import java.util.Date;

public class DrIllicit {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 驾驶人名称
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idcard;

    /**
     * 准驾车型
     */
    private String permitcar;

    /**
     * 管理部门
     */
    private String mgrdepart;

    /**
     * 管理部门行政区划
     */
    private String mgrdepartareaid;

    /**
     * 驾驶员关联id
     */
    private String driverId;

    /**
     * 累计记分
     */
    private String scoretotal;

    /**
     * 状态
     */
    private String state;

    /**
     * 机动车号牌
     */
    private String vehino;

    /**
     * 号牌种类
     */
    private String vehinotype;

    /**
     * 违法时间
     */
    private String illicittime;

    /**
     * 违法记分
     */
    private String illicitscore;

    /**
     * 罚款金额
     */
    private String illicitamount;

    /**
     * 违法地址
     */
    private String illicitadress;

    /**
     * 违法行为
     */
    private String illicit;

    /**
     * 违法行为描述
     */
    private String illicitdesc;

    /**
     * 采集机关
     */
    private String pickdepartment;

    /**
     * 采集机关名称
     */
    private String pickdepartmentdesc;

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
     * 创建人部门
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
     * 驾驶人名称
     * @return name 驾驶人名称
     */
    public String getName() {
        return name;
    }

    /**
     * 驾驶人名称
     * @param name 驾驶人名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 身份证号码
     * @return idcard 身份证号码
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 身份证号码
     * @param idcard 身份证号码
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 准驾车型
     * @return permitCar 准驾车型
     */
    public String getPermitcar() {
        return permitcar;
    }

    /**
     * 准驾车型
     * @param permitcar 准驾车型
     */
    public void setPermitcar(String permitcar) {
        this.permitcar = permitcar;
    }

    /**
     * 管理部门
     * @return mgrDepart 管理部门
     */
    public String getMgrdepart() {
        return mgrdepart;
    }

    /**
     * 管理部门
     * @param mgrdepart 管理部门
     */
    public void setMgrdepart(String mgrdepart) {
        this.mgrdepart = mgrdepart;
    }

    /**
     * 管理部门行政区划
     * @return mgrDepartAreaId 管理部门行政区划
     */
    public String getMgrdepartareaid() {
        return mgrdepartareaid;
    }

    /**
     * 管理部门行政区划
     * @param mgrdepartareaid 管理部门行政区划
     */
    public void setMgrdepartareaid(String mgrdepartareaid) {
        this.mgrdepartareaid = mgrdepartareaid;
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
        this.driverId = driverId;
    }

    /**
     * 累计记分
     * @return scoreTotal 累计记分
     */
    public String getScoretotal() {
        return scoretotal;
    }

    /**
     * 累计记分
     * @param scoretotal 累计记分
     */
    public void setScoretotal(String scoretotal) {
        this.scoretotal = scoretotal;
    }

    /**
     * 状态
     * @return state 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 状态
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 机动车号牌
     * @return vehiNo 机动车号牌
     */
    public String getVehino() {
        return vehino;
    }

    /**
     * 机动车号牌
     * @param vehino 机动车号牌
     */
    public void setVehino(String vehino) {
        this.vehino = vehino;
    }

    /**
     * 号牌种类
     * @return vehiNoType 号牌种类
     */
    public String getVehinotype() {
        return vehinotype;
    }

    /**
     * 号牌种类
     * @param vehinotype 号牌种类
     */
    public void setVehinotype(String vehinotype) {
        this.vehinotype = vehinotype;
    }

    /**
     * 违法时间
     * @return illicitTime 违法时间
     */
    public String getIllicittime() {
        return illicittime;
    }

    /**
     * 违法时间
     * @param illicittime 违法时间
     */
    public void setIllicittime(String illicittime) {
        this.illicittime = illicittime;
    }

    /**
     * 违法记分
     * @return illicitScore 违法记分
     */
    public String getIllicitscore() {
        return illicitscore;
    }

    /**
     * 违法记分
     * @param illicitscore 违法记分
     */
    public void setIllicitscore(String illicitscore) {
        this.illicitscore = illicitscore;
    }

    /**
     * 罚款金额
     * @return illicitAmount 罚款金额
     */
    public String getIllicitamount() {
        return illicitamount;
    }

    /**
     * 罚款金额
     * @param illicitamount 罚款金额
     */
    public void setIllicitamount(String illicitamount) {
        this.illicitamount = illicitamount;
    }

    /**
     * 违法地址
     * @return illicitAdress 违法地址
     */
    public String getIllicitadress() {
        return illicitadress;
    }

    /**
     * 违法地址
     * @param illicitadress 违法地址
     */
    public void setIllicitadress(String illicitadress) {
        this.illicitadress = illicitadress;
    }

    /**
     * 违法行为
     * @return illicit 违法行为
     */
    public String getIllicit() {
        return illicit;
    }

    /**
     * 违法行为
     * @param illicit 违法行为
     */
    public void setIllicit(String illicit) {
        this.illicit = illicit;
    }

    /**
     * 违法行为描述
     * @return illicitDesc 违法行为描述
     */
    public String getIllicitdesc() {
        return illicitdesc;
    }

    /**
     * 违法行为描述
     * @param illicitdesc 违法行为描述
     */
    public void setIllicitdesc(String illicitdesc) {
        this.illicitdesc = illicitdesc;
    }

    /**
     * 采集机关
     * @return pickDepartment 采集机关
     */
    public String getPickdepartment() {
        return pickdepartment;
    }

    /**
     * 采集机关
     * @param pickdepartment 采集机关
     */
    public void setPickdepartment(String pickdepartment) {
        this.pickdepartment = pickdepartment;
    }

    /**
     * 采集机关名称
     * @return pickDepartmentDesc 采集机关名称
     */
    public String getPickdepartmentdesc() {
        return pickdepartmentdesc;
    }

    /**
     * 采集机关名称
     * @param pickdepartmentdesc 采集机关名称
     */
    public void setPickdepartmentdesc(String pickdepartmentdesc) {
        this.pickdepartmentdesc = pickdepartmentdesc;
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
     * 创建人部门
     * @return createDepCd 创建人部门
     */
    public String getCreatedepcd() {
        return createdepcd;
    }

    /**
     * 创建人部门
     * @param createdepcd 创建人部门
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