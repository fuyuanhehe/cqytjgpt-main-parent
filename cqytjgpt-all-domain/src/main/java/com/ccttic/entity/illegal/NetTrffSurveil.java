package com.ccttic.entity.illegal;

import java.io.Serializable;

public class NetTrffSurveil implements Serializable {
	private static final long serialVersionUID = 6629765210406101141L;
	// 序号
	private String XH;
	// 决定书编号
	private String JDSBH;
	// 号牌种类
	private String HPZL;
	// 号牌号码
	private String HPHM;
	// 发证机关
	private String FZJG;
	// 违法地址
	private String WFDZ;
	// 违法行为
	private String WFXW;
	// 处理标记
	private String CLBJ;
	// 交款标记
	private String JKBJ;
	// 采集机关
	private String CJJG;
	// 采集机关名称
	private String CJJGMC;
	// 发送机关
	private String FSJG;
	// 接收机关
	private String JSJG;
	// 更新时间
	private String GXSJ;
	// 导出标记
	private String DCBJ;
	// 违法时间
	private String WFSJ;
	// 罚款金额
	private String FKJE;
	// 处理时间
	private String CLSJ;
	// 处理对象标记
	private String CLDXBJ;
	// 违法地点
	private String WFDD;
	// 记录类型
	private String JLLX;
	// 业务检验
	private String YWJYW;
	// 
	private String BBH;
	
	
	public NetTrffSurveil() {
		super();
	}

	public NetTrffSurveil(String xH, String jDSBH, String hPZL, String hPHM, String fZJG, String wFDZ, String wFXW,
			String cLBJ, String jKBJ, String cJJG, String cJJGMC, String fSJG, String jSJG, String gXSJ, String dCBJ,
			String wFSJ, String fKJE, String cLSJ, String cLDXBJ, String wFDD, String jLLX, String yWJYW, String bBH) {
		super();
		XH = xH;
		JDSBH = jDSBH;
		HPZL = hPZL;
		HPHM = hPHM;
		FZJG = fZJG;
		WFDZ = wFDZ;
		WFXW = wFXW;
		CLBJ = cLBJ;
		JKBJ = jKBJ;
		CJJG = cJJG;
		CJJGMC = cJJGMC;
		FSJG = fSJG;
		JSJG = jSJG;
		GXSJ = gXSJ;
		DCBJ = dCBJ;
		WFSJ = wFSJ;
		FKJE = fKJE;
		CLSJ = cLSJ;
		CLDXBJ = cLDXBJ;
		WFDD = wFDD;
		JLLX = jLLX;
		YWJYW = yWJYW;
		BBH = bBH;
	}

	public String getXH() {
		return XH;
	}

	public void setXH(String xH) {
		XH = xH;
	}

	public String getJDSBH() {
		return JDSBH;
	}

	public void setJDSBH(String jDSBH) {
		JDSBH = jDSBH;
	}

	public String getHPZL() {
		return HPZL;
	}

	public void setHPZL(String hPZL) {
		HPZL = hPZL;
	}

	public String getHPHM() {
		return HPHM;
	}

	public void setHPHM(String hPHM) {
		HPHM = hPHM;
	}

	public String getFZJG() {
		return FZJG;
	}

	public void setFZJG(String fZJG) {
		FZJG = fZJG;
	}

	public String getWFDZ() {
		return WFDZ;
	}

	public void setWFDZ(String wFDZ) {
		WFDZ = wFDZ;
	}

	public String getWFXW() {
		return WFXW;
	}

	public void setWFXW(String wFXW) {
		WFXW = wFXW;
	}

	public String getCLBJ() {
		return CLBJ;
	}

	public void setCLBJ(String cLBJ) {
		CLBJ = cLBJ;
	}

	public String getJKBJ() {
		return JKBJ;
	}

	public void setJKBJ(String jKBJ) {
		JKBJ = jKBJ;
	}

	public String getCJJG() {
		return CJJG;
	}

	public void setCJJG(String cJJG) {
		CJJG = cJJG;
	}

	public String getCJJGMC() {
		return CJJGMC;
	}

	public void setCJJGMC(String cJJGMC) {
		CJJGMC = cJJGMC;
	}

	public String getFSJG() {
		return FSJG;
	}

	public void setFSJG(String fSJG) {
		FSJG = fSJG;
	}

	public String getJSJG() {
		return JSJG;
	}

	public void setJSJG(String jSJG) {
		JSJG = jSJG;
	}

	public String getGXSJ() {
		return GXSJ;
	}

	public void setGXSJ(String gXSJ) {
		GXSJ = gXSJ;
	}

	public String getDCBJ() {
		return DCBJ;
	}

	public void setDCBJ(String dCBJ) {
		DCBJ = dCBJ;
	}

	public String getWFSJ() {
		return WFSJ;
	}

	public void setWFSJ(String wFSJ) {
		WFSJ = wFSJ;
	}

	public String getFKJE() {
		return FKJE;
	}

	public void setFKJE(String fKJE) {
		FKJE = fKJE;
	}

	public String getCLSJ() {
		return CLSJ;
	}

	public void setCLSJ(String cLSJ) {
		CLSJ = cLSJ;
	}

	public String getCLDXBJ() {
		return CLDXBJ;
	}

	public void setCLDXBJ(String cLDXBJ) {
		CLDXBJ = cLDXBJ;
	}

	public String getWFDD() {
		return WFDD;
	}

	public void setWFDD(String wFDD) {
		WFDD = wFDD;
	}

	public String getJLLX() {
		return JLLX;
	}

	public void setJLLX(String jLLX) {
		JLLX = jLLX;
	}

	public String getYWJYW() {
		return YWJYW;
	}

	public void setYWJYW(String yWJYW) {
		YWJYW = yWJYW;
	}

	public String getBBH() {
		return BBH;
	}

	public void setBBH(String bBH) {
		BBH = bBH;
	}
	
}
