package com.ccttic.cqytjgpt.webapi.controller.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.drivers.DriversService;
import com.ccttic.cqytjgpt.webapi.interfaces.taskdriver.ITaskDriverService;
import com.ccttic.entity.drivers.Driver;

@RestController
@RequestMapping("/driverService")
class DriverTaskController {
	private Logger logger = LoggerFactory.getLogger(CarTaskController.class);
	@Autowired
	private DriversService driversService;
	@Autowired
	private ITaskDriverService taskDriverService;

	@RequestMapping("/addDriverIllega")
	public void addDriveIllega() {

		List<Driver> drivers = driversService.getAllDriver();
		for (Driver driver : drivers) {

			try {
				taskDriverService.addDriveIllega(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info(e.getMessage());
			}
		}
	}

	@RequestMapping("/addDriverDanger")
	public void addDriverDanger() {
		List<Driver> drivers = driversService.getAllDriver();
		for (Driver driver : drivers) {
			try {
				taskDriverService.addDriverDanger(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info(e.getMessage());
			}
		}

	}

}
