package com.ccttic.cqytjgpt.webapi.interfaces.batch;

import java.util.List;

import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.illegal.VehiIllicit;

public interface ICarBatch {
	
	/**
	 * 批量添加车辆违法
	 * @param list
	 */
	public void addCarIllegal(List<VehiIllicit> list);
	
	/**
	 * 批量添加车辆预警
	 * @param list
	 */
	public void addCarDanger(List<VehiDanger> list);
	
	/**
	 * 批量修改车辆违法
	 * @param list
	 */
	public void updateCarIllegal(List<VehiIllicit> list);
	
	/**
	 * 批量修改车辆预警
	 * @param list
	 */
	public void updateCarDanger(List<VehiDanger> list);
}
