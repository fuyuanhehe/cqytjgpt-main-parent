package com.ccttic.cqytjgpt.webapi.interfaces.taskcar;

import java.util.Map;

import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.VehicleIllegal;

public interface ITaskCarService {

	Map<String,Object> getCarIllega(VehicleIllegal vehicle) throws Exception;
	
	Map<String,Object> getCarDanger(Vehicle vehicle)throws Exception;
}
