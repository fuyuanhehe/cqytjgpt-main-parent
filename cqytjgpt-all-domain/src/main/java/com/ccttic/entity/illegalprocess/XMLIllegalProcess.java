package com.ccttic.entity.illegalprocess;

public class XMLIllegalProcess {
	//违法序号
	private String xh;
	//采集机关名称
	private String cjjgmc;
	//号牌种类
	private String hpzl;
	//号牌号码
	private String hphm;
	//违法时间
	private String wfsj;
	//违法地址
	private String wfdz;
	//违法行为
	private String wfxw;
	//处理标记
	private String clbj;
	//违法行为描述
	private String wfxwms;
	//罚款金额
	private String fkje;
	//违法记分数
	private String wfjfs;
	//处罚种类
	private String cfzl;
	//处理状态
	private String clzt;
	
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getCjjgmc() {
		return cjjgmc;
	}
	public void setCjjgmc(String cjjgmc) {
		this.cjjgmc = cjjgmc;
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
	public String getWfxw() {
		return wfxw;
	}
	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}
	public String getClbj() {
		return clbj;
	}
	public void setClbj(String clbj) {
		this.clbj = clbj;
	}
	public String getWfxwms() {
		return wfxwms;
	}
	public void setWfxwms(String wfxwms) {
		this.wfxwms = wfxwms;
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
	public String getCfzl() {
		return cfzl;
	}
	public void setCfzl(String cfzl) {
		this.cfzl = cfzl;
	}
	public String getClzt() {
		return clzt;
	}
	public void setClzt(String clzt) {
		this.clzt = clzt;
	}
	public XMLIllegalProcess(String xh, String cjjgmc, String hpzl, String hphm, String wfsj, String wfdz, String wfxw,
			String clbj, String wfxwms, String fkje, String wfjfs, String cfzl, String clzt) {
		super();
		this.xh = xh;
		this.cjjgmc = cjjgmc;
		this.hpzl = hpzl;
		this.hphm = hphm;
		this.wfsj = wfsj;
		this.wfdz = wfdz;
		this.wfxw = wfxw;
		this.clbj = clbj;
		this.wfxwms = wfxwms;
		this.fkje = fkje;
		this.wfjfs = wfjfs;
		this.cfzl = cfzl;
		this.clzt = clzt;
	}
	public XMLIllegalProcess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
