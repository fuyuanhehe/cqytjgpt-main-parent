package com.ccttic.cqytjgpt.webapi.controller.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.taskcar.ITaskCarService;
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.role.Vehicle;

@RestController
@RequestMapping("/carService")
public class CarTaskController {
	private Logger logger = LoggerFactory.getLogger(CarTaskController.class);
	@Autowired
	private IVehicleService vehicleService;
    @Autowired
	private ITaskCarService taskCarService;

	@RequestMapping("/addCarIllega")
	public void addCarIllega() {
		List<Vehicle> vehicles = vehicleService.getAllVehicle();
		for (Vehicle vehicle : vehicles) {
			try {
				taskCarService.addCarIllega(vehicle);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info(e.getMessage());
			}
		}
	}

	@RequestMapping("/addCarDanger")
	public void addCarDanger() {
		List<Vehicle> vehicles = vehicleService.getAllVehicle();
		for (Vehicle vehicle : vehicles) {
			try {
				taskCarService.addCarDanger(vehicle);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info(e.getMessage());
			}
		}
	}
}
