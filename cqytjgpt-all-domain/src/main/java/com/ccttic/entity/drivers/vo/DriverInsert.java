package com.ccttic.entity.drivers.vo;

import java.util.List;

import com.ccttic.entity.drivers.Driver;
//驾驶人集合VO
public class DriverInsert {

	private List<Driver> drivers;
	
	public DriverInsert() {
	}

	public DriverInsert(List<Driver> drivers) {
		super();
		this.drivers = drivers;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	@Override
	public String toString() {
		return "DriverInsert [drivers=" + drivers + "]";
	}
	
}
