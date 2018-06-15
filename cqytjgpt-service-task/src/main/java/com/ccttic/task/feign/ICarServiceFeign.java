package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="cqytjgpt-webapi",path="carService")
public interface ICarServiceFeign{

	@RequestMapping("/addCarIllega")
	public String addCarIllega();
	
	@RequestMapping("/addCarDanger")
	public String addCarDanger();
}
