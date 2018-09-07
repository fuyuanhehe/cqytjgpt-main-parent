package com.ccttic.cqytjgpt.enterpriseapi.mapper.vehicle;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.TreeVehileVo;
import com.ccttic.entity.role.vo.VehicleVO;
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
	public VehicleVO qryOneVehicle(Map<String, Object> params) throws AppException;
	
	/**
	 * 根据车牌号获取车辆基础信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public Vehicle qryOneVehiNo(String vehiNo) throws AppException;
	
//	/**
//	 * 根据条件获取车辆出车信息
//	 * 
//	 * @param params
//	 * @return
//	 * @throws AppException
//	 */
//	public List<VehicleDispatch> qryVehicleDispatchList(Map<String, Object> params) throws AppException;
//	
//	/**
//	 * 
//	 * 根据条件获取车辆出车信息总记录数
//	 * 
//	 * @param params
//	 * @return
//	 * @throws AppException
//	 */
//	public int qryVehicleDispatchListCount(Map<String, Object> params) throws AppException;
	/**
	 * 根据登录账号查询企业
	 * @param entId
	 * @return
	 * @throws AppException
	 */
	public List<EssEnterprise> getEssEnterprise (@Param("entId") String entId)throws AppException;
	
	/**
	 * 车辆关联
	 * @param params
	 * @return
	 */
	public int vehicleRelevance(Map<String, Object> params);
	// --------------------------车辆管理---------------------------------
	
	/**
	 * 根据条件获取车辆基础信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public List<Vehicle> qryVehicleAMList(Map<String, Object> params) throws AppException;
	
	/**
	 * 
	 * 根据条件获取车辆基础信息总记录数
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryVehicleAMListCount(Map<String, Object> params) throws AppException;
	
	/**
	 * 根据条件获取车辆违法信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public List<VehiIllicit> qryVehiIllicitList(Map<String, Object> params) throws AppException;
	
	/**
	 * 根据条件获取车辆违法信息总记录数
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryVehiIllicitListCount(Map<String, Object> params) throws AppException;
	
	/**
	 * 根据id获取车辆违法详情
	 * @param params
	 * @return
	 */
	public VehiIllicit qryOneVehiIllicit(Map<String, Object> params);
	
	// -----------------------------车辆监管-----------------------------
	/**
	 * 根据企业id查询相关车辆
	 * @param entId
	 * @return
	 * @throws AppException
	 */
	public List<TreeVehileVo> getVehicleSupervise(@Param("entId") String entId)throws AppException;
	
}
