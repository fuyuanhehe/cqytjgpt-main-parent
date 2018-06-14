package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.ccttic.web.api.car.ICarServiceController;

@FeignClient(name="cqytjgpt-web-api")
public interface ICarServiceFeign extends ICarServiceController {

}
