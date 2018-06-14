package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccttic.cqytjgpt.webapi.interfaces.taskcar.ITaskCarService;

@FeignClient(name="cqytjgpt-web-api")
public interface ICarServiceFeign extends ITaskCarService{

	@RequestMapping("/carService/addCarIllega")
	void addCarIllega();
	
	@RequestMapping("/carService/addCarDanger")
	void addCarDanger();
}
