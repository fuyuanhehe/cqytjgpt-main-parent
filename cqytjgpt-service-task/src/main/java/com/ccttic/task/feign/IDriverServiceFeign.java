package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="cqytjgpt-webapi")
public interface IDriverServiceFeign {
	
	@RequestMapping("/driverService/addDriverIllega")
	public String addDriverIllega();
	
	@RequestMapping("/driverService/addDriverDanger")
	public String addDriverDanger();

}
