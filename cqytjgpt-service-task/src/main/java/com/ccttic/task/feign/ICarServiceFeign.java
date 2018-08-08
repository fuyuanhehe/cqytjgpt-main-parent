package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="cqytjgpt-webapi")
public interface ICarServiceFeign{

	@RequestMapping("/carService/addCarIllega")
	public String addCarIllega();
	
	@RequestMapping("/carService/addCarDanger")
	public String addCarDanger();
	
	@RequestMapping("/carService/updateCar")
	public String updateCar();
}
