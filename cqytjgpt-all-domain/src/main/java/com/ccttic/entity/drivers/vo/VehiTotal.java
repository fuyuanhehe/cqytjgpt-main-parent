package com.ccttic.entity.drivers.vo;


public class VehiTotal {

	private String id;

	private String etpNm;

	private VehicleCountVo maxVehi;
	
	private VehicleCountVo minVehi;
	
	private VehicleCountVo total;


	public VehiTotal() {
	}


	public VehiTotal(String id, String etpNm, VehicleCountVo maxVehi, VehicleCountVo minVehi,
			VehicleCountVo total) {
		super();
		this.id = id;
		this.etpNm = etpNm;
		this.maxVehi = maxVehi;
		this.minVehi = minVehi;
		this.total = total;
	}


	@Override
	public String toString() {
		return "VehiTotal [id=" + id + ", etpNm=" + etpNm + ", maxVehi=" + maxVehi + ", minVehi="
				+ minVehi + ", total=" + total + "]";
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


	public VehicleCountVo getMaxVehi() {
		return maxVehi;
	}


	public void setMaxVehi(VehicleCountVo maxVehi) {
		this.maxVehi = maxVehi;
	}


	public VehicleCountVo getMinVehi() {
		return minVehi;
	}


	public void setMinVehi(VehicleCountVo minVehi) {
		this.minVehi = minVehi;
	}


	public VehicleCountVo getTotal() {
		return total;
	}


	public void setTotal(VehicleCountVo total) {
		this.total = total;
	}

	
	


}
