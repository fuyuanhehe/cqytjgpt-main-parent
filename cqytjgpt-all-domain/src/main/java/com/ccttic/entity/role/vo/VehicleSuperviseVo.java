package com.ccttic.entity.role.vo;

import java.io.Serializable;

public class VehicleSuperviseVo implements Serializable{
	private static final long serialVersionUID = -7833907040967944828L;
	private String id;
	private String vehiNO;
	
	public VehicleSuperviseVo() {
		super();
	}

	public VehicleSuperviseVo(String id, String vehiNO) {
		super();
		this.id = id;
		this.vehiNO = vehiNO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVehiNO() {
		return vehiNO;
	}

	public void setVehiNO(String vehiNO) {
		this.vehiNO = vehiNO;
	}
	
	
}
