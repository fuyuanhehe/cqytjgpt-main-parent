package com.ccttic.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.service.taskdriver.ITaskDriverService;
import com.ccttic.web.api.driver.IDriverServiceController;

@RestController
class DriverTaskController implements IDriverServiceController{
	@Autowired
	private  ITaskDriverService service;
	@Override
	public void addDriveIllega() {
		try {
			service.addDriveIllega();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addDriverDanger() {
	
		try {
			service.addDriverDanger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
