package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccttic.entity.common.ResponseMsg;

/**
 * 用户操作日志
 * @author zhuliang
 *
 */
@FeignClient(name="cqytjgpt-service-logger")
public interface IUserOperLogger {
	
	@RequestMapping(value="/addTb",method= {RequestMethod.GET,RequestMethod.POST})
    public ResponseMsg<Boolean> addOperLoggerTb() ;
}
