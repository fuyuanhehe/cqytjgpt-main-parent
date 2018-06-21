package com.ccttic.cqytjgpt.webapi.controller.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.batch.IDriverBatch;
import com.ccttic.cqytjgpt.webapi.interfaces.drivers.DriversService;
import com.ccttic.cqytjgpt.webapi.interfaces.taskdriver.ITaskDriverService;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.drivers.vo.DriverIllegal;
import com.ccttic.entity.illegal.DrIllicit;

@RestController
@RequestMapping("/driverService")
class DriverTaskController {
	private Logger logger = LoggerFactory.getLogger(CarTaskController.class);
	@Autowired
	private DriversService driversService;
	@Autowired
	private ITaskDriverService taskDriverService;
	@Autowired
	private IDriverBatch driverBatch;

	@RequestMapping("/addDriverIllega")
	public void addDriverIllega() {
		Map<String, Object> result = null;
		List<DrIllicit> insert = new ArrayList<>();
		List<DrIllicit> update = new ArrayList<>();
		List<DriverIllegal> drivers = driversService.getAllDriver();
		for (DriverIllegal driver : drivers) {

			try {
				result = taskDriverService.getDriveIllega(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info(e.getMessage());
			}
			if (result.get("update") != null) {
				update.add((DrIllicit) (result.get("update")));
			}
			if (result.get("insert") != null) {
				insert.add((DrIllicit) (result.get("insert")));
			}
		}
		driverBatch.addDriverIllegal(insert);
		driverBatch.updateDriverIllegal(update);
	}

	@RequestMapping("/addDriverDanger")
	public void addDriverDanger() {
		Map<String, Object> result = null;
		List<DrDanger> insert = new ArrayList<>();
		List<DrDanger> update = new ArrayList<>();
		List<DriverIllegal> drivers = driversService.getAllDriver();
		for (DriverIllegal driver : drivers) {
			try {
				result = taskDriverService.getDriverDanger(driver);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			if (result.get("update") != null) {
				update.add((DrDanger) (result.get("update")));
			}
			if (result.get("insert") != null) {
				insert.add((DrDanger) (result.get("insert")));
			}
		}
		driverBatch.addDriverDanger(insert);
		driverBatch.updateDriverDanger(update);
	}

}
