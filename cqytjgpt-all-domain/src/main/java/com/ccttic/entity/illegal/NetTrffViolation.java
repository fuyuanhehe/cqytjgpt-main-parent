package com.ccttic.entity.illegal;

import java.io.Serializable;

public class NetTrffViolation implements Serializable{
	private static final long serialVersionUID = 2774027230686972149L;
	// 违法编号
	private String WFBH;
	// 决定书编号
	private String JDSBH;
	// 人员分类
	private String RYFL;
	// 驾驶证号
	private String JSZH;
	// 号牌种类
	private String HPZL;
	// 号牌号码
	private String HPHM;
	// 违法地址
	private String WFDZ;
	// 违法行为
	private String WFXW;
	// 处理机关名称
	private String CLJGMC;
	// 交款标记
	private String JKBJ;
	// 更新时间
	private String GXSJ;
	// 导出标记
	private String DCBJ;
	// 违法时间
	private String WFSJ;
	// 信息来源
	private String XXLY;
	// 凭证编号
	private String PZBH;
	// 违法记分数
	private String WFJFS;
	// 罚款金额
	private String FKJE;
	// 当事人
	private String DSR;
	// 处理时间
	private String CLSJ;
	// 处理机关
	private String CLJG;
	// 记录类型
	private String JLLX;
	// 业务校验位
	private String YWJYW;
	// 档案编号
	private String DABH;
	// 发证机关
	private String FZJG;
	// 违法地点
	private String WFDD;
	// 处罚种类
	private String CFZL;
	// 发现机关
	private String FXJG;
	// 发现机关名称
	private String FXJGMC;
	// 
	private String YLZZ4;
	// 
	private String BBH;
	
	public NetTrffViolation() {
		super();
	}

	public NetTrffViolation(String wFBH, String jDSBH, String rYFL, String jSZH, String hPZL, String hPHM, String wFDZ,
			String wFXW, String cLJGMC, String jKBJ, String gXSJ, String dCBJ, String wFSJ, String xXLY, String pZBH,
			String wFJFS, String fKJE, String dSR, String cLSJ, String cLJG, String jLLX, String yWJYW, String dABH,
			String fZJG, String wFDD, String cFZL, String fXJG, String fXJGMC, String yLZZ4, String bBH) {
		super();
		WFBH = wFBH;
		JDSBH = jDSBH;
		RYFL = rYFL;
		JSZH = jSZH;
		HPZL = hPZL;
		HPHM = hPHM;
		WFDZ = wFDZ;
		WFXW = wFXW;
		CLJGMC = cLJGMC;
		JKBJ = jKBJ;
		GXSJ = gXSJ;
		DCBJ = dCBJ;
		WFSJ = wFSJ;
		XXLY = xXLY;
		PZBH = pZBH;
		WFJFS = wFJFS;
		FKJE = fKJE;
		DSR = dSR;
		CLSJ = cLSJ;
		CLJG = cLJG;
		JLLX = jLLX;
		YWJYW = yWJYW;
		DABH = dABH;
		FZJG = fZJG;
		WFDD = wFDD;
		CFZL = cFZL;
		FXJG = fXJG;
		FXJGMC = fXJGMC;
		YLZZ4 = yLZZ4;
		BBH = bBH;
	}

	public String getWFBH() {
		return WFBH;
	}

	public void setWFBH(String wFBH) {
		WFBH = wFBH;
	}

	public String getJDSBH() {
		return JDSBH;
	}

	public void setJDSBH(String jDSBH) {
		JDSBH = jDSBH;
	}

	public String getRYFL() {
		return RYFL;
	}

	public void setRYFL(String rYFL) {
		RYFL = rYFL;
	}

	public String getJSZH() {
		return JSZH;
	}

	public void setJSZH(String jSZH) {
		JSZH = jSZH;
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

	public String getCLJGMC() {
		return CLJGMC;
	}

	public void setCLJGMC(String cLJGMC) {
		CLJGMC = cLJGMC;
	}

	public String getJKBJ() {
		return JKBJ;
	}

	public void setJKBJ(String jKBJ) {
		JKBJ = jKBJ;
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

	public String getXXLY() {
		return XXLY;
	}

	public void setXXLY(String xXLY) {
		XXLY = xXLY;
	}

	public String getPZBH() {
		return PZBH;
	}

	public void setPZBH(String pZBH) {
		PZBH = pZBH;
	}

	public String getWFJFS() {
		return WFJFS;
	}

	public void setWFJFS(String wFJFS) {
		WFJFS = wFJFS;
	}

	public String getFKJE() {
		return FKJE;
	}

	public void setFKJE(String fKJE) {
		FKJE = fKJE;
	}

	public String getDSR() {
		return DSR;
	}

	public void setDSR(String dSR) {
		DSR = dSR;
	}

	public String getCLSJ() {
		return CLSJ;
	}

	public void setCLSJ(String cLSJ) {
		CLSJ = cLSJ;
	}

	public String getCLJG() {
		return CLJG;
	}

	public void setCLJG(String cLJG) {
		CLJG = cLJG;
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

	public String getDABH() {
		return DABH;
	}

	public void setDABH(String dABH) {
		DABH = dABH;
	}

	public String getFZJG() {
		return FZJG;
	}

	public void setFZJG(String fZJG) {
		FZJG = fZJG;
	}

	public String getWFDD() {
		return WFDD;
	}

	public void setWFDD(String wFDD) {
		WFDD = wFDD;
	}

	public String getCFZL() {
		return CFZL;
	}

	public void setCFZL(String cFZL) {
		CFZL = cFZL;
	}

	public String getFXJG() {
		return FXJG;
	}

	public void setFXJG(String fXJG) {
		FXJG = fXJG;
	}

	public String getFXJGMC() {
		return FXJGMC;
	}

	public void setFXJGMC(String fXJGMC) {
		FXJGMC = fXJGMC;
	}

	public String getYLZZ4() {
		return YLZZ4;
	}

	public void setYLZZ4(String yLZZ4) {
		YLZZ4 = yLZZ4;
	}

	public String getBBH() {
		return BBH;
	}

	public void setBBH(String bBH) {
		BBH = bBH;
	}
	
}
