package com.ccttic.entity.enterprise;

import java.io.Serializable;

public class EnterVehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String vehiId;
	
	private String enterId;
	
	private String setTime;
	
	
	
	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getVehiId() {
		return vehiId;
	}




	public void setVehiId(String vehiId) {
		this.vehiId = vehiId;
	}




	public String getEnterId() {
		return enterId;
	}




	public void setEnterId(String enterId) {
		this.enterId = enterId;
	}




	public String getSetTime() {
		return setTime;
	}




	public void setSetTime(String setTime) {
		this.setTime = setTime;
	}




	@Override
	public String toString() {
		return "EnterVehicle [id=" + id + ", vehiId=" + vehiId + ", enterId=" + enterId
				+ ", setTime=" + setTime + "]";
	}




	public EnterVehicle(String id, String vehiId, String enterId, String setTime) {
		super();
		this.id = id;
		this.vehiId = vehiId;
		this.enterId = enterId;
		this.setTime = setTime;
	}




	public EnterVehicle() {
		// TODO Auto-generated constructor stub
	}

}
