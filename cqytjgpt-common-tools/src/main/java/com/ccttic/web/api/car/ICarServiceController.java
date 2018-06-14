package com.ccttic.web.api.car;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/carService")
public interface ICarServiceController {
	@RequestMapping("/addCarIllega")
	public void addCarIllega();
	@RequestMapping("/addCarDanger")
	public void addCarDanger();

}
