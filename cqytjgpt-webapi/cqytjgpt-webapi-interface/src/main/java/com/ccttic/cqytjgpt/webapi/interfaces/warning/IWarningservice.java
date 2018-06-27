package com.ccttic.cqytjgpt.webapi.interfaces.warning;

import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IWarningservice {
	/**
	 * 根据条件查询车辆预警信息
	 * @param page
	 * @param ve
	 * @return
	 * @throws AppException
	 */
	public Page<VehiDanger> qryVehicleList(Pageable page, VehiDangerVo ve) throws AppException;
	/**
	 * 根据id查询车辆预警详情信息
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public VehiDanger qryOneVehicle(VehiDanger ve) throws AppException;
}
