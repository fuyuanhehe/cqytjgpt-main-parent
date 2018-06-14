package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.ccttic.web.api.driver.IDriverServiceController;

@FeignClient(name="cqytjgpt-web-api")
public interface IDriverServiceFeign extends IDriverServiceController {

}
