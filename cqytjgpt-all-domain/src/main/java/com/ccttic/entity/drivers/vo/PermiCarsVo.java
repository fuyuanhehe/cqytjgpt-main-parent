package com.ccttic.entity.drivers.vo;
//自定义准假车型实体
public class PermiCarsVo {
  // 准假车型
	private String permiCar;

	public PermiCarsVo(String permiCar) {
		super();
		this.permiCar = permiCar;
	}
	
	
	public PermiCarsVo() {
	}


	@Override
	public String toString() {
		return "PermiCarsVo [permiCar=" + permiCar + "]";
	}


	public String getPermiCar() {
		return permiCar;
	}


	public void setPermiCar(String permiCar) {
		this.permiCar = permiCar;
	}
	
	
	
	
}
