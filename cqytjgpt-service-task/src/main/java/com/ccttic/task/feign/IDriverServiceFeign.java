package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="cqytjgpt-webapi")
public interface IDriverServiceFeign {
	
	@RequestMapping("/driverService/addDriverIllega")
	public void addDriveIllega();
	
	@RequestMapping("/driverService/addDriverDanger")
	public void addDriverDanger();

}
