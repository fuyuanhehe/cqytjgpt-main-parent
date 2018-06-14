package com.ccttic.entity.illegalprocess;

import java.io.Serializable;

public class XMLPendingPayment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 处罚决定书类别
	 */
	private String jdslb;
	
	/**
	 * 处罚决定书编号
	 */
	private String jdsbh;
	
	/**
	 * 驾驶人
	 */
	private String dsr;
	
	/**
	 * 驾驶证号
	 */
	private String jszh;
	
	/**
	 * 号牌种类
	 */
	private String hpzl;
	
	/**
	 * 号牌号码
	 */
	private String hphm;
	
	/**
	 * 处理时间
	 */
	private String clsj;
	
	/**
	 * 罚款金额
	 */
	private String fkje;
	
	/**
	 * 违法记分数
	 */
	private String wfjfs;
	
	/**
	 * 滞纳金
	 */
	private String znj;
	
	/**
	 * 处理标记
	 */
	private String clbj;
	
	/**
	 * 缴款标记
	 */
	private String jkbj;

	//违法时间
	private String wfsj;
	//违法地址
	private String wfdz;
	//采集机关名称
	private String cljgmc;
	//违法行为
	private String wfxw;
	public String getJdslb() {
		return jdslb;
	}
	public void setJdslb(String jdslb) {
		this.jdslb = jdslb;
	}
	public String getJdsbh() {
		return jdsbh;
	}
	public void setJdsbh(String jdsbh) {
		this.jdsbh = jdsbh;
	}
	public String getDsr() {
		return dsr;
	}
	public void setDsr(String dsr) {
		this.dsr = dsr;
	}
	public String getJszh() {
		return jszh;
	}
	public void setJszh(String jszh) {
		this.jszh = jszh;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getClsj() {
		return clsj;
	}
	public void setClsj(String clsj) {
		this.clsj = clsj;
	}
	public String getFkje() {
		return fkje;
	}
	public void setFkje(String fkje) {
		this.fkje = fkje;
	}
	public String getWfjfs() {
		return wfjfs;
	}
	public void setWfjfs(String wfjfs) {
		this.wfjfs = wfjfs;
	}
	public String getZnj() {
		return znj;
	}
	public void setZnj(String znj) {
		this.znj = znj;
	}
	public String getClbj() {
		return clbj;
	}
	public void setClbj(String clbj) {
		this.clbj = clbj;
	}
	public String getJkbj() {
		return jkbj;
	}
	public void setJkbj(String jkbj) {
		this.jkbj = jkbj;
	}
	public String getWfsj() {
		return wfsj;
	}
	public void setWfsj(String wfsj) {
		this.wfsj = wfsj;
	}
	public String getWfdz() {
		return wfdz;
	}
	public void setWfdz(String wfdz) {
		this.wfdz = wfdz;
	}
	public String getCljgmc() {
		return cljgmc;
	}
	public void setCljgmc(String cljgmc) {
		this.cljgmc = cljgmc;
	}
	public String getWfxw() {
		return wfxw;
	}
	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}
	public XMLPendingPayment(String jdslb, String jdsbh, String dsr, String jszh, String hpzl, String hphm, String clsj,
			String fkje, String wfjfs, String znj, String clbj, String jkbj, String wfsj, String wfdz, String cljgmc,
			String wfxw) {
		super();
		this.jdslb = jdslb;
		this.jdsbh = jdsbh;
		this.dsr = dsr;
		this.jszh = jszh;
		this.hpzl = hpzl;
		this.hphm = hphm;
		this.clsj = clsj;
		this.fkje = fkje;
		this.wfjfs = wfjfs;
		this.znj = znj;
		this.clbj = clbj;
		this.jkbj = jkbj;
		this.wfsj = wfsj;
		this.wfdz = wfdz;
		this.cljgmc = cljgmc;
		this.wfxw = wfxw;
	}
	public XMLPendingPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
