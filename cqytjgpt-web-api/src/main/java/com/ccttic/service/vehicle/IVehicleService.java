package com.ccttic.service.vehicle;

import java.util.Map;

import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.common.exception.AppException;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IVehicleService {
	/**
	 * 根据条件获取车辆基础信息
	 * @param page
	 * @param driver
	 * @param entId 企业id
	 * @return
	 * @throws AppException
	 */
	public Page<Vehicle> qryVehicleList(Pageable page, Vehicle driver) throws AppException;
	
	/**
	 * 获取指定车辆基础信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public Vehicle qryOneVehicle(Map<String, Object> params) throws AppException;
	
	/**
	 * 根据条件获取车辆违法信息
	 * @param page
	 * @param driver
	 * @param id 
	 * @return
	 * @throws AppException
	 */
	public Page<VehiIllicit> qryVehiIllicitList(Pageable page, VehiIllicit vehiIllicit, String id) throws AppException;
	
	/**
	 * 新增车牌号和车辆类型
	 * @throws AppException
	 */
	public Map<String, Object> saveVehicle(String vehiNo,String vehiNoType) throws AppException;
	
	/**
	 * 修改车辆基础信息（补全信息）
	 * @param vehicle
	 * @throws AppException
	 */
	public void modifVehicle(XMLCar xmlCar) throws AppException;
	
	
}
