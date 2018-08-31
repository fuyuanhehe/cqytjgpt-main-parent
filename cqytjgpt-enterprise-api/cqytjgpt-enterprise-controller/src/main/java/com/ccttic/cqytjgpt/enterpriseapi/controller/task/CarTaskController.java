package com.ccttic.cqytjgpt.enterpriseapi.controller.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.batch.ICarBatch;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.taskcar.ITaskCarService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.role.Vehicle;

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


//	@RequestMapping("/addCarIllegal")
//	public void addCarIllegal(@RequestBody EssEnterprise enterprises) {
//		Map<String, Object> result = null;
//		List<VehiIllicit> insertIllegal = new ArrayList<>();
//		List<VehiIllicit> updateIllegal = new ArrayList<>();
//		List<VehiDanger> insertDanger = new ArrayList<>();
//		List<VehiDanger> updateDanger = new ArrayList<>();
//
//		List<EssEnterprise> ent = new ArrayList<>();
//		ent.add(enterprises);
//	    List<VehicleIllegal> vehicles = vehicleService.getVehicleByEnterprises(ent);
//	    /*
//	    *
//	    * 违法记录查询
//	    * */
//		for (VehicleIllegal vehicle : vehicles) {
//
//			try {
//				result = taskCarService.getCarIllega(vehicle);
//			} catch (Exception e) {
//				logger.info(e.getMessage());
//			}
//			if (result!=null && result.get("update") != null) {
//				updateIllegal.addAll((List<VehiIllicit>) (result.get("update")));
//			}
//			if (result!=null && result.get("insert") != null) {
//				insertIllegal.addAll((List<VehiIllicit>) (result.get("insert")));
//			}
//		}
//		if(insertIllegal.size()>0)
//		carBatch.addCarIllegal(insertIllegal);
//		if(updateIllegal.size()>0)
//		carBatch.updateCarIllegal(updateIllegal);
//
//		/*
//		* 车辆预警数据处理
//		* */
//		for (VehicleIllegal vehicle : vehicles) {
//
//			try {
//				result = taskCarService.getCarDanger(vehicle);
//			} catch (Exception e) {
//				logger.info(e.getMessage());
//			}
//
//			if (result!=null && result.get("update") != null) {
//				updateDanger.add((VehiDanger) (result.get("update")));
//			}else if (result!=null && result.get("insert") != null) {
//				insertDanger.add((VehiDanger) (result.get("insert")));
//			}
//		}
//
//		if(insertDanger.size()>0)
//			carBatch.addCarDanger(insertDanger);
//		if(updateDanger.size()>0)
//			carBatch.updateCarDanger(updateDanger);
//	}

	@RequestMapping("/addCarDanger")
	public void addCarDanger() {
		
		Map<String, Object> result = null;
		List<VehiDanger> insert = new ArrayList<>();
		List<VehiDanger> update = new ArrayList<>();
		List<Vehicle> vehicles = vehicleService.getVehicleMsg();
		int i = 0;
		for (Vehicle vehicle : vehicles) {
			i++;
			logger.info("第"+i+"条");
			try {
				result = taskCarService.getCarDanger(vehicle);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			
//			if (result!=null && result.get("update") != null) {
//				update.add((VehiDanger) (result.get("update")));
//			}else if (result!=null && result.get("insert") != null) {
//				insert.add((VehiDanger) (result.get("insert")));
//			}
		}
		
//		if(insert.size()>0)
//		carBatch.addCarDanger(insert);
//		if(update.size()>0)
//		carBatch.updateCarDanger(update);
	}
	
	/*@RequestMapping("/updateCar")
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
	}*/
}
