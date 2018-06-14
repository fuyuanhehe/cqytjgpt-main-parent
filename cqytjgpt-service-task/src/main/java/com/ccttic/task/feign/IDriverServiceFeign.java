package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccttic.cqytjgpt.webapi.interfaces.taskdriver.ITaskDriverService;

@FeignClient(name="cqytjgpt-web-api")
public interface IDriverServiceFeign extends ITaskDriverService {
	
	@RequestMapping("/addDriverIllega")
	public void addDriveIllega();
	
	@RequestMapping("/addDriverDanger")
	public void addDriverDanger();

}
