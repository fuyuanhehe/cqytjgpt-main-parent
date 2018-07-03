package com.ccttic.cqytjgpt.webapi.interfaces.taskcar;

import java.util.Map;

import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.VehicleIllegal;

public interface ITaskCarService {

	/**添加违法信息
	 * @param vehicle
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> getCarIllega(VehicleIllegal vehicle) throws Exception;
	
	/**添加预警信息
	 * @param vehicle
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> getCarDanger(Vehicle vehicle)throws Exception;

	/**
	 * 更新车辆信息
	 * @param vehicle
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> updateCar(VehicleIllegal vehicle)throws Exception;
}
