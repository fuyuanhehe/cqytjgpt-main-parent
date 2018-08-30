package com.ccttic.entity.role;

import java.io.Serializable;

import com.ccttic.entity.BaseBean;

/**
 * 车辆出车记录
 * @author admin
 *
 */
public class VehicleDispatch extends BaseBean implements Serializable{

	private static final long serialVersionUID = 7094637948370084408L;
	
	// 驾驶员
	private String driver;
	// 机动车号牌
	private String vehiNo;
	// 运送时间
	private String dispatchTime;
	// 配载货物类型
	private String goodsType;
	// 上车地点
	private String onSite;
	// 下车地点
	private String debusSite;
	// state
	private String state;
	
	public VehicleDispatch() {
		super();
	}
	public VehicleDispatch(String driver,String vehiNo, String dispatchTime, String goodsType, String onSite, String debusSite,
			String state) {
		super();
		this.driver = driver;
		this.vehiNo = vehiNo;
		this.dispatchTime = dispatchTime;
		this.goodsType = goodsType;
		this.onSite = onSite;
		this.debusSite = debusSite;
		this.state = state;
	}
	public String getVehiNo() {
		return vehiNo;
	}
	public void setVehiNo(String vehiNo) {
		this.vehiNo = vehiNo;
	}
	public String getDispatchTime() {
		return dispatchTime;
	}
	public void setDispatchTime(String dispatchTime) {
		this.dispatchTime = dispatchTime;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getOnSite() {
		return onSite;
	}
	public void setOnSite(String onSite) {
		this.onSite = onSite;
	}
	public String getDebusSite() {
		return debusSite;
	}
	public void setDebusSite(String debusSite) {
		this.debusSite = debusSite;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	

}
