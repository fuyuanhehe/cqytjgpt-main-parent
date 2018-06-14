package com.ccttic.cqytjgpt.webapi.controller.task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.taskcar.ITaskCarService;

@RestController
@RequestMapping("/carSerivce")
public class CarTaskController{
	
	private ITaskCarService service;
	@RequestMapping("/addCarIllega")
	public void addCarIllega() {
		try {
			service.addCarIllega();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping("/addCarDanger")
	public void addCarDanger() {
		try {
			service.addCarDanger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
