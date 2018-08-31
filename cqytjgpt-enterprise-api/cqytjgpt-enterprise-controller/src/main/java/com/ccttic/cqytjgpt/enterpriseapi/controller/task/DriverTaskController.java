package com.ccttic.cqytjgpt.enterpriseapi.controller.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.batch.IDriverBatch;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.drivers.DriversService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.taskdriver.ITaskDriverService;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.drivers.Driver;

@RestController
@RequestMapping("/driverService")
class DriverTaskController {
	private Logger logger = LoggerFactory.getLogger(DriverTaskController.class);
	@Autowired
	private DriversService driversService;
	@Autowired
	private ITaskDriverService taskDriverService;
	@Autowired
	private IDriverBatch driverBatch;

//	@SuppressWarnings("unchecked")
//	@RequestMapping("/addDriverIllega")
//	public void addDriverIllega() {
//		Map<String, Object> result = null;
//		List<DrIllicit> insert = new ArrayList<>();
//		List<DrIllicit> update = new ArrayList<>();
//		List<Driver> drivers = driversService.getAllDriverMsg();
//		int i =0;
//		for (DriverIllegal driver : drivers) {
//			i++;
//			logger.info("第"+i+"条");
//			try {
//				result = taskDriverService.getDriveIllega(driver);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				logger.info(e.getMessage());
//			}
//			if (result!=null && result.get("update") != null) {
//				update.addAll((List<DrIllicit>) (result.get("update")));
//			}
//			if (result!=null && result.get("insert") != null) {
//				insert.addAll((List<DrIllicit>) (result.get("insert")));
//			}
//		}
//		if(insert.size()>0)
//		driverBatch.addDriverIllegal(insert);
//		if(update.size()>0)
//		driverBatch.updateDriverIllegal(update);
//	}

	@RequestMapping("/addDriverDanger")
	public void addDriverDanger() {
		Map<String, Object> result = null;
		List<DrDanger> insert = new ArrayList<>();
		List<DrDanger> update = new ArrayList<>();
		List<Driver> drivers = driversService.getAllDriverMsg();
		int i =0;
		for (Driver driver : drivers) {
			i++;
			logger.info("第"+i+"条");
			try {
				result = taskDriverService.getDriverDanger(driver);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
//			if (result!=null && result.get("update") != null) {
//				update.add((DrDanger) (result.get("update")));
//			}
//			if (result!=null && result.get("insert") != null) {
//				insert.add((DrDanger) (result.get("insert")));
//			}
		}
//		if(insert.size()>0)
//		driverBatch.addDriverDanger(insert);
//		if(update.size()>0)
//		driverBatch.updateDriverDanger(update);
	}
	
	@RequestMapping("/updateDriver")
	public void updateDriver() {
		Driver dr = null;
		
		List<Driver> update = new ArrayList<>();
		List<Driver> delete = new ArrayList<>();
		List<Driver> drivers = driversService.getAllDriverMsg();
		int i =0;
		for (Driver driver : drivers) {
			i++;
			logger.info("第"+i+"条");
			try {
				dr = taskDriverService.updateDriver(driver);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			if (dr != null && dr.getState()!=null) {
				update.add(dr);
			}else {
				delete.add(dr);
			}
			
		}
		if(update.size()>0)
		driverBatch.updateDriver(update);
		if(delete.size()>0)
		driverBatch.deleteDriver(delete);
	}

}
