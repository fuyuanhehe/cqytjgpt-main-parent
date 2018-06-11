package com.ccttic.entity.drivers;

import java.util.Date;
//驾驶员实体
public class Driver {
    /** 主键ID*/
    private String id;

    /** 驾驶人名称*/
    private String name;

    /** 身份证号码*/
    private String idcard;

    /** 联系电话*/
    private String telphone;

    /** 手机号码*/
    private String mobilephone;

    /** 登记住所*/
    private String adress;

    /** 准驾车型*/
    private String permicar;

    /** 初次领证时间*/
    private String firstrecivetime;

    /** 管理部门
接口获取*/
    private String mgrdepart;

    /** 管理部门行政区划*/
    private String mgrdepartareaid;

    /** 管理企业id*/
    private String mgrenterpriseid;

    /** 下次验审时间*/
    private String nextexaminetime;

    /** 有效开始时间*/
    private String effectstarttime;

    /** 有效结束时间*/
    private String effectendtime;

    /** 审验有效期止*/
    private String examineeffectendtime;

    /** 累计计分*/
    private String scoretotal;

    /** 状态*/
    private String state;

    /** 备注*/
    private String remark;

    /** 版本号*/
    private Integer version;

    /** 是否删除*/
    private Byte isdelete;

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

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getPermicar() {
        return permicar;
    }

    public void setPermicar(String permicar) {
        this.permicar = permicar == null ? null : permicar.trim();
    }

    public String getFirstrecivetime() {
        return firstrecivetime;
    }

    public void setFirstrecivetime(String firstrecivetime) {
        this.firstrecivetime = firstrecivetime == null ? null : firstrecivetime.trim();
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

    public String getMgrenterpriseid() {
        return mgrenterpriseid;
    }

    public void setMgrenterpriseid(String mgrenterpriseid) {
        this.mgrenterpriseid = mgrenterpriseid == null ? null : mgrenterpriseid.trim();
    }

    public String getNextexaminetime() {
        return nextexaminetime;
    }

    public void setNextexaminetime(String nextexaminetime) {
        this.nextexaminetime = nextexaminetime == null ? null : nextexaminetime.trim();
    }

    public String getEffectstarttime() {
        return effectstarttime;
    }

    public void setEffectstarttime(String effectstarttime) {
        this.effectstarttime = effectstarttime == null ? null : effectstarttime.trim();
    }

    public String getEffectendtime() {
        return effectendtime;
    }

    public void setEffectendtime(String effectendtime) {
        this.effectendtime = effectendtime == null ? null : effectendtime.trim();
    }

    public String getExamineeffectendtime() {
        return examineeffectendtime;
    }

    public void setExamineeffectendtime(String examineeffectendtime) {
        this.examineeffectendtime = examineeffectendtime == null ? null : examineeffectendtime.trim();
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

    public Byte getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
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
    public Driver() {
		// TODO Auto-generated constructor stub
	}

	public Driver(String id, String name, String idcard, String telphone, String mobilephone,
			String adress, String permicar, String firstrecivetime, String mgrdepart,
			String mgrdepartareaid, String mgrenterpriseid, String nextexaminetime,
			String effectstarttime, String effectendtime, String examineeffectendtime,
			String scoretotal, String state, String remark, Integer version, Byte isdelete,
			Date createtime, Date updatetime, Date deletetime, String createby, String createdepcd,
			String updateby, String updatedepcd) {
		super();
		this.id = id;
		this.name = name;
		this.idcard = idcard;
		this.telphone = telphone;
		this.mobilephone = mobilephone;
		this.adress = adress;
		this.permicar = permicar;
		this.firstrecivetime = firstrecivetime;
		this.mgrdepart = mgrdepart;
		this.mgrdepartareaid = mgrdepartareaid;
		this.mgrenterpriseid = mgrenterpriseid;
		this.nextexaminetime = nextexaminetime;
		this.effectstarttime = effectstarttime;
		this.effectendtime = effectendtime;
		this.examineeffectendtime = examineeffectendtime;
		this.scoretotal = scoretotal;
		this.state = state;
		this.remark = remark;
		this.version = version;
		this.isdelete = isdelete;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.deletetime = deletetime;
		this.createby = createby;
		this.createdepcd = createdepcd;
		this.updateby = updateby;
		this.updatedepcd = updatedepcd;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", idcard=" + idcard + ", telphone="
				+ telphone + ", mobilephone=" + mobilephone + ", adress=" + adress + ", permicar="
				+ permicar + ", firstrecivetime=" + firstrecivetime + ", mgrdepart=" + mgrdepart
				+ ", mgrdepartareaid=" + mgrdepartareaid + ", mgrenterpriseid=" + mgrenterpriseid
				+ ", nextexaminetime=" + nextexaminetime + ", effectstarttime=" + effectstarttime
				+ ", effectendtime=" + effectendtime + ", examineeffectendtime="
				+ examineeffectendtime + ", scoretotal=" + scoretotal + ", state=" + state
				+ ", remark=" + remark + ", version=" + version + ", isdelete=" + isdelete
				+ ", createtime=" + createtime + ", updatetime=" + updatetime + ", deletetime="
				+ deletetime + ", createby=" + createby + ", createdepcd=" + createdepcd
				+ ", updateby=" + updateby + ", updatedepcd=" + updatedepcd + "]";
	}
    
    
}