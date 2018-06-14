package com.ccttic.cqytjgpt.webapi.interfaces.vehicle;

import java.util.Map;

import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IVehiIllicitService {
	
	/**
	 * 根据条件获取车辆违法信息
	 * @param page
	 * @param driver
	 * @param entId 企业id
	 * @return
	 * @throws AppException
	 */
	public Page<VehiIllicit> qryVehiIllicitList(Pageable page, VehiIllicit vehiIllicit, String entId) throws AppException;
	
	/**
	 * 获取指定车辆违法信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public VehiIllicit qryOneVehiIllicit(Map<String, Object> params) throws AppException;
}
