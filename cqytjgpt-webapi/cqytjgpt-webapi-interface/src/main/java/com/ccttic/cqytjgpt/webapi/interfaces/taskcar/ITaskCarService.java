package com.ccttic.cqytjgpt.webapi.interfaces.taskcar;

import com.ccttic.entity.role.Vehicle;

public interface ITaskCarService {

	void addCarIllega(Vehicle vehicle) throws Exception;
	
	void addCarDanger(Vehicle vehicle)throws Exception;
}
