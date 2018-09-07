package com.ccttic.cqytjgpt.enterpriseapi.interfaces.warning;

import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.DrDangerVo;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IWarningService {
	/**
	 * 根据条件查询车辆预警信息
	 * @param page
	 * @param ve
	 * @param employeePermission
	 * @return
	 * @throws AppException
	 */
	 Page<VehiDangerVo> qryVehicleList(Pageable page, VehiDangerVo ve, EmployeePermission employeePermission) throws AppException;
	/**
	 * 根据id查询车辆预警详情信息
	 * @return
	 * @throws AppException
	 */
	 VehiDangerVo qryOneVehicle(VehiDanger ve) throws AppException;
	
	
	/**根据条件查询驾驶人预警信息
	 * @param page
	 * @param vo
	 * @param employeePermission
	 * @return
	 */
	 Page<DrDangerVo> qryDriverList(Pageable page, DrDangerVo vo, EmployeePermission employeePermission)throws AppException;
	
	/**
	 * 根据id查询驾驶员预警详情信息
	 * @return
	 * @throws AppException
	 */
	 DrDanger qryOneDriver(DrDanger dr)throws AppException;
}
