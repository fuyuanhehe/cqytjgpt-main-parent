package com.ccttic.cqytjgpt.webapi.interfaces.vehicle;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.VehicleDispatch;
import com.ccttic.entity.role.vo.PageVehicleVo;
import com.ccttic.entity.role.vo.VehicleIllegal;
import com.ccttic.entity.role.vo.VehicleVO;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IVehicleService {
	/**
	 * 根据条件获取车辆基础信息
	 * @param entId 企业id
	 * @param page
	 * @param driver
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Page<Vehicle> qryVehicleList(Pageable page, PageVehicleVo driver, EmployeePermission employeePermission) throws AppException;

	/**
	 * 获取指定车辆基础信息
	 *
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public VehicleVO qryOneVehicle(Map<String, Object> params) throws AppException;

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
	
	/**
	 * 根据条件获取车辆出车信息
	 * @param page
	 * @param driver
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Page<VehicleDispatch> qryVehicleDispatchList(Pageable page, VehicleDispatch vehiIllicit,EmployeePermission employeePermission) throws AppException;
	
	public Area getfenceIdByEssid(String id);

    List<VehicleIllegal> getVehicleByEnterprises(List<EssEnterprise> enterprises);
	/**
	 *@Author:zhy
	 *@Description:获取预警车辆信息
	 *@Date:15:02 2018/7/20
	 */
    List<Vehicle> getVehicleMsg();
}
