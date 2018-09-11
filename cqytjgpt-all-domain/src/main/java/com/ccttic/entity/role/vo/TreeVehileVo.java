package com.ccttic.entity.role.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeVehileVo implements Serializable{
	private static final long serialVersionUID = 3942760177307338036L;
	
	private String id;
	private String etpNm;
	private String vehiNo;
	public List<TreeVehileVo> children;
	public TreeVehileVo() {
		children = new ArrayList<TreeVehileVo>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEtpNm() {
		return etpNm;
	}
	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}
	public String getVehiNo() {
		return vehiNo;
	}
	public void setVehiNo(String vehiNo) {
		this.vehiNo = vehiNo;
	}
	public List<TreeVehileVo> getChildren() {
		return children;
	}
	public void setChildren(List<TreeVehileVo> children) {
		this.children = children;
	}
	
}
