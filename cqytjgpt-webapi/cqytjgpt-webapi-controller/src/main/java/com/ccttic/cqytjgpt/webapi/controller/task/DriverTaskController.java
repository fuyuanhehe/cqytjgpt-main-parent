package com.ccttic.cqytjgpt.webapi.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.taskdriver.ITaskDriverService;



@RestController
@RequestMapping("/driverService")
class DriverTaskController{
	@Autowired
	private  ITaskDriverService service;
	@RequestMapping("/addDriverIllega")
	public void addDriveIllega() {
		try {
			service.addDriveIllega();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@RequestMapping("/addDriverDanger")
	public void addDriverDanger() {
	
		try {
			service.addDriverDanger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
