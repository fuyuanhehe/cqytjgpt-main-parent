package com.ccttic.cqytjgpt.webapi.mapper.vehicle;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.util.exception.AppException;

public interface VehiIllicitMapper {
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
	 * 获取指定车辆违法信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public VehiIllicit qryOneVehiIllicit(Map<String, Object> params) throws AppException;
}
