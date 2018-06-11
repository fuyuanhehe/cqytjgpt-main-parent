package com.ccttic.entity.drivers;

import java.util.Date;
//驾驶员违法记录实体
public class dr_illicit {
    /** 主键ID*/
    private String id;

    /** 驾驶人名称*/
    private String name;

    /** 身份证号码*/
    private String idcard;

    /** 准驾车型*/
    private String permitcar;

    /** 管理部门*/
    private String mgrdepart;

    /** 管理部门行政区划*/
    private String mgrdepartareaid;

    /** 驾驶员关联id*/
    private String driverId;

    /** 累计记分*/
    private String scoretotal;

    /** 状态*/
    private String state;

    /** 机动车号牌*/
    private String vehino;

    /** 号牌种类*/
    private String vehinotype;

    /** 违法时间*/
    private String illicittime;

    /** 违法记分*/
    private String illicitscore;

    /** 罚款金额*/
    private String illicitamount;

    /** 违法地址*/
    private String illicitadress;

    /** 违法行为*/
    private String illicit;

    /** 违法行为描述*/
    private String illicitdesc;

    /** 采集机关*/
    private String pickdepartment;

    /** 采集机关名称*/
    private String pickdepartmentdesc;

    /** 备注*/
    private String remark;

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

    /** 创建人部门*/
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPermitcar() {
        return permitcar;
    }

    public void setPermitcar(String permitcar) {
        this.permitcar = permitcar == null ? null : permitcar.trim();
    }

    public String getMgrdepart() {
        return mgrdepart;
    }

    public void setMgrdepart(String mgrdepart) {
        this.mgrdepart = mgrdepart == null ? null : mgrdepart.trim();
    }

    public String getMgrdepartareaid() {
        return mgrdepartareaid;
    }

    public void setMgrdepartareaid(String mgrdepartareaid) {
        this.mgrdepartareaid = mgrdepartareaid == null ? null : mgrdepartareaid.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getScoretotal() {
        return scoretotal;
    }

    public void setScoretotal(String scoretotal) {
        this.scoretotal = scoretotal == null ? null : scoretotal.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getVehino() {
        return vehino;
    }

    public void setVehino(String vehino) {
        this.vehino = vehino == null ? null : vehino.trim();
    }

    public String getVehinotype() {
        return vehinotype;
    }

    public void setVehinotype(String vehinotype) {
        this.vehinotype = vehinotype == null ? null : vehinotype.trim();
    }

    public String getIllicittime() {
        return illicittime;
    }

    public void setIllicittime(String illicittime) {
        this.illicittime = illicittime == null ? null : illicittime.trim();
    }

    public String getIllicitscore() {
        return illicitscore;
    }

    public void setIllicitscore(String illicitscore) {
        this.illicitscore = illicitscore == null ? null : illicitscore.trim();
    }

    public String getIllicitamount() {
        return illicitamount;
    }

    public void setIllicitamount(String illicitamount) {
        this.illicitamount = illicitamount == null ? null : illicitamount.trim();
    }

    public String getIllicitadress() {
        return illicitadress;
    }

    public void setIllicitadress(String illicitadress) {
        this.illicitadress = illicitadress == null ? null : illicitadress.trim();
    }

    public String getIllicit() {
        return illicit;
    }

    public void setIllicit(String illicit) {
        this.illicit = illicit == null ? null : illicit.trim();
    }

    public String getIllicitdesc() {
        return illicitdesc;
    }

    public void setIllicitdesc(String illicitdesc) {
        this.illicitdesc = illicitdesc == null ? null : illicitdesc.trim();
    }

    public String getPickdepartment() {
        return pickdepartment;
    }

    public void setPickdepartment(String pickdepartment) {
        this.pickdepartment = pickdepartment == null ? null : pickdepartment.trim();
    }

    public String getPickdepartmentdesc() {
        return pickdepartmentdesc;
    }

    public void setPickdepartmentdesc(String pickdepartmentdesc) {
        this.pickdepartmentdesc = pickdepartmentdesc == null ? null : pickdepartmentdesc.trim();
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