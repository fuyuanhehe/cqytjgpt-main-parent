package com.ccttic.cqytjgpt.webapi.client.system;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.util.page.PageRequest;

@FeignClient(name="cqytjgpt-service-logger")
public interface UserOperLoggerFeign {

	@RequestMapping(value="/multi",method= {RequestMethod.GET,RequestMethod.POST})
    public ResponseMsg<List<UserOperLogger>> findOperLogger(UserOperLogger userOperLogger, PageRequest page);

	@RequestMapping(value="/single",method= {RequestMethod.GET,RequestMethod.POST})
    public ResponseMsg<UserOperLogger> findOperLogger(String id) ;
	
	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
    public ResponseMsg<Boolean> addOperLogger(UserOperLogger userOperLogger);
}
