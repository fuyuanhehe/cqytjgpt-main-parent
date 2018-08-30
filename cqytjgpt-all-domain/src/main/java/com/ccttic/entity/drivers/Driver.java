package com.ccttic.entity.drivers;

import com.ccttic.entity.BaseBean;
//驾驶员实体
public class Driver extends BaseBean{
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

    // 驾照状态
    private String state1;
    /**
     *@Author:zhy
     *@Description:就职状态
     *@Date:15:42 2018/8/29
     */
    private String inaugurationStatus;


    public String getInaugurationStatus() {
        return inaugurationStatus;
    }

    public void setInaugurationStatus(String inaugurationStatus) {
        this.inaugurationStatus = inaugurationStatus;
    }

    public String getState1() {
		return state1;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

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

	public Driver(String id, String name, String idcard, String telphone, String mobilephone, String adress,
			String permicar, String firstrecivetime, String mgrdepart, String mgrdepartareaid, String mgrenterpriseid,
			String nextexaminetime, String effectstarttime, String effectendtime, String examineeffectendtime,
			String scoretotal, String state,String inaugurationStatus) {
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
		this.inaugurationStatus = inaugurationStatus;
	}

	public Driver() {
		super();

	}   
    
}