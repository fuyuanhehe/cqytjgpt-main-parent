package com.ccttic.entity.role;

import java.io.Serializable;
/**
 * 行政区域
 * @author admin
 *
 */
public class Area implements Serializable{

	private static final long serialVersionUID = -5745399293039116876L;
	// 主键ID
	private String id;
	// 行政区域代码
	private String areaCd;
	// 行政区域名称
	private String areaNm;
	// 行政区域简称简称
	private String shortNm;
	// 备注
	private String remark;
	public Area() {
		super();
	}
	public Area(String id, String areaCd, String areaNm, String shortNm, String remark) {
		super();
		this.id = id;
		this.areaCd = areaCd;
		this.areaNm = areaNm;
		this.shortNm = shortNm;
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAreaCd() {
		return areaCd;
	}
	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
	}
	public String getAreaNm() {
		return areaNm;
	}
	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}
	public String getShortNm() {
		return shortNm;
	}
	public void setShortNm(String shortNm) {
		this.shortNm = shortNm;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
