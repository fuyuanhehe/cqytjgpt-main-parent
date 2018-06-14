package com.ccttic.web.api.driver;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/driverService")
public interface IDriverServiceController {
	@RequestMapping("/addDriverIllega")
	public void addDriveIllega();
	@RequestMapping("/addDriverDanger")
	public void addDriverDanger();

}
