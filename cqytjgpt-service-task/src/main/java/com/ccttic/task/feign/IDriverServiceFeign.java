package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="cqytjgpt-webapi")
public interface IDriverServiceFeign {
	
	@RequestMapping("/driverService/addDriverIllega")
	public void addDriverIllega();
	
	@RequestMapping("/driverService/addDriverDanger")
	public void addDriverDanger();
	
	@RequestMapping("/driverService/updateCar")
	public void updateDriver();

}
