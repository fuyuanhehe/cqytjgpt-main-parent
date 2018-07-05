package com.ccttic.cqytjgpt.webapi.client.system;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.util.page.PageRequest;

@FeignClient(value="cqytjgpt-service-logger",path="operlog")
public interface UserOperLoggerFeign {

	@RequestMapping(value="/multi",method=RequestMethod.POST)
    public ResponseMsg<List<UserOperLogger>> findOperLogger(@RequestParam("userOperLogger") UserOperLogger userOperLogger, @RequestParam("page") PageRequest page);

	@RequestMapping(value="/single",method=RequestMethod.POST)
    public ResponseMsg<UserOperLogger> findOperLogger(@RequestParam("id") String id) ;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
    public ResponseMsg<Boolean> addOperLogger(@RequestParam("userOperLogger") UserOperLogger userOperLogger);
}
