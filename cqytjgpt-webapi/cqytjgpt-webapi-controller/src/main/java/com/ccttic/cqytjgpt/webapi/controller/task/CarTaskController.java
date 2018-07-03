package com.ccttic.cqytjgpt.webapi.controller.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.batch.ICarBatch;
import com.ccttic.cqytjgpt.webapi.interfaces.taskcar.ITaskCarService;
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.illegal.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.VehicleIllegal;

@RestController
@RequestMapping("/carService")
public class CarTaskController {
	private Logger logger = LoggerFactory.getLogger(CarTaskController.class);
	@Autowired
	private IVehicleService vehicleService;
	@Autowired
	private ITaskCarService taskCarService;
	@Autowired
	private ICarBatch carBatch;

	@SuppressWarnings("unchecked")
	@RequestMapping("/addCarIllega")
	public void addCarIllega() {
		Map<String, Object> result = null;
		List<VehiIllicit> insert = new ArrayList<>();
		List<VehiIllicit> update = new ArrayList<>();
	    List<VehicleIllegal> vehicles = vehicleService.getAllVehicle();
	    int i =0;
		for (VehicleIllegal vehicle : vehicles) {
			i++;
			logger.info("第"+i+"条");
			try {
				result = taskCarService.getCarIllega(vehicle);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			if (result!=null && result.get("update") != null) {
				update.addAll((List<VehiIllicit>) (result.get("update")));
			}
			if (result!=null && result.get("insert") != null) {
				insert.addAll((List<VehiIllicit>) (result.get("insert")));
			}
		}
		if(insert.size()>0)
		carBatch.addCarIllegal(insert);
		if(update.size()>0)
		carBatch.updateCarIllegal(update);
	}

	@RequestMapping("/addCarDanger")
	public void addCarDanger() {
		
		Map<String, Object> result = null;
		List<VehiDanger> insert = new ArrayList<>();
		List<VehiDanger> update = new ArrayList<>();
		List<VehicleIllegal> vehicles = vehicleService.getAllVehicle();
		int i = 0;
		for (VehicleIllegal vehicle : vehicles) {
			i++;
			logger.info("第"+i+"条");
			try {
				result = taskCarService.getCarDanger(vehicle);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			
			if (result!=null && result.get("update") != null) {
				update.add((VehiDanger) (result.get("update")));
			}else if (result!=null && result.get("insert") != null) {
				insert.add((VehiDanger) (result.get("insert")));
			}
		}
		
		if(insert.size()>0)
		carBatch.addCarDanger(insert);
		if(update.size()>0)
		carBatch.updateCarDanger(update);
	}
	
	@RequestMapping("/updateCar")
	public void updateCar() {
		
		Map<String, Object> result = null;
		List<Vehicle> delete = new ArrayList<>();
		List<Vehicle> update = new ArrayList<>();
		List<VehicleIllegal> vehicles = vehicleService.getAllVehicle();
		int i = 0;
		for (VehicleIllegal vehicle : vehicles) {
			i++;
			logger.info("第"+i+"条");
			try {
				result = taskCarService.updateCar(vehicle);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			
			if (result!=null && result.get("update") != null) {
				update.add((Vehicle) (result.get("update")));
			}else if (result!=null && result.get("delete") != null) {
				delete.add((Vehicle) (result.get("delete")));
			}
		}
		
		
		if(delete.size()>0)
		carBatch.deleteCar(delete);
		if(update.size()>0)
		carBatch.updateCar(update);
	}
}
