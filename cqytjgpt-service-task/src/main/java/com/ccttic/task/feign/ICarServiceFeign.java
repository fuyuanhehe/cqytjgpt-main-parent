package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="cqytjgpt-webapi")
public interface ICarServiceFeign{

	@RequestMapping("/carService/addCarIllega")
	public void addCarIllega();
	
	@RequestMapping("/carService/addCarDanger")
	public void addCarDanger();
}
