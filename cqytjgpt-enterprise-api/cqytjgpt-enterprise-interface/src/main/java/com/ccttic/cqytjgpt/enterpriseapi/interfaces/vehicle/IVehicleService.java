package com.ccttic.cqytjgpt.enterpriseapi.interfaces.vehicle;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.PageVehicleVo;
import com.ccttic.entity.role.vo.TreeVehileVo;
import com.ccttic.entity.role.vo.VehicleVO;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IVehicleService {
	/**
	 * 根据条件获取车辆基础信息（车辆关联）
	 * @param page
	 * @param driver
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Page<Vehicle> qryVehicleList(Pageable page, PageVehicleVo vehicleVo) throws AppException;

	/**
	 * 获取指定车辆基础信息（车辆关联和管理通用）
	 *
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public VehicleVO qryOneVehicle(Map<String, Object> params) throws AppException;

//	/**
//	 * 根据条件获取车辆出车信息
//	 * @param page
//	 * @param driver
//	 * @param id
//	 * @return
//	 * @throws AppException
//	 */
//	public Page<VehicleDispatch> qryVehicleDispatchList(Pageable page, VehicleDispatch vehiIllicit,EmployeePermission employeePermission) throws AppException;
	
	/**
	 * 车辆关联
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int vehicleRelevance(Map<String, Object> params)throws AppException;
	// -------------------车辆管理-------------------------
	/**
	 * 根据条件获取车辆基础信息（车辆管理）
	 * @param page
	 * @param driver
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Page<Vehicle> qryVehicleAMList(Pageable page, PageVehicleVo vehicleVo,List<EssEnterprise> essEnt) throws AppException;
	
	/**
	 * 根据条件获取车辆违法信息
	 * @param page
	 * @param driver
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Page<VehiIllicit> qryVehiIllicitList(Pageable page, VehiIllicit vehiIllicit) throws AppException;
	/**
	 * 根据id获取车辆违法信息
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public VehiIllicit qryOneVehiIllicit(Map<String, Object> params)throws AppException;
	// -------------------------车辆监管----------------------------
	public List<TreeVehileVo> getVehicleSupervise(String entId)throws AppException;
}
