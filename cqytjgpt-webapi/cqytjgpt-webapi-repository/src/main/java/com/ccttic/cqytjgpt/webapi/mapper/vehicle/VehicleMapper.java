package com.ccttic.cqytjgpt.webapi.mapper.vehicle;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.VehicleIllegal;
import com.ccttic.util.exception.AppException;


public interface VehicleMapper {
	/**
	 * 根据条件获取车辆基础信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public List<Vehicle> qryVehicleList(Map<String, Object> params) throws AppException;
	
	/**
	 * 
	 * 根据条件获取车辆基础信息总记录数
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryVehicleListCount(Map<String, Object> params) throws AppException;
	
	/**
	 * 获取指定车辆基础信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public Vehicle qryOneVehicle(Map<String, Object> params) throws AppException;
	
	/**
	 * 根据车牌号获取车辆基础信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public Vehicle qryOneVehiNo(String vehiNo) throws AppException;
	
	/**
	 * 根据条件获取车辆违法信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public List<VehiIllicit> qryVehiIllicitList(Map<String, Object> params) throws AppException;
	
	/**
	 * 
	 * 根据条件获取车辆违法信息总记录数
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryVehiIllicitListCount(Map<String, Object> params) throws AppException;
	
	/**
	 * 添加车辆基础信息
	 * 
	 * @param post
	 * @throws AppException
	 */
	public int saveVehicle(Map<String, Object> params) throws AppException;

	/**
	 * 修改车辆基础信息
	 * 
	 * @param params
	 * @throws AppException
	 */
	public int modifVehicle(Vehicle vehicle) throws AppException;
	//获取所有车辆
	public List<VehicleIllegal> getAllCar();
	//根据车辆id获取数据库违章信息
	List<VehiIllicit>selectByVehicleId(String vehicleId);

	public String getfenceIdByEssid(String id);

	/**批量更新车辆信息
	 * @param update
	 */
	public void updateBatch(List<Vehicle> vehicle);
	
	/**批量删除无信息车辆
	 * @param vehicle
	 */
	public void deleteBatch(List<String> vehicle);
}
