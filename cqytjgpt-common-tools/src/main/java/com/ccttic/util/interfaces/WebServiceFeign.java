package com.ccttic.util.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author syao
 * @version v1.0
 * 通过feign调用交巡警webservice接口服务
 *
 */

//@FeignClient注解接名该接口通过指定的的“CQJXJ-INTERFACES”服务名，找到资源服务
//feign默认实现了负载均衡,如果CQJXJ-INTERFACES资源服务启动多个时，默认是轮询调用
@FeignClient(name="cqjxj-interfaces", url="http://10.10.20.21:8084")
public interface WebServiceFeign {
    /**
     * 这里@requestMapping里指定的路径就是cqjxj-interface工程里的controller里的/ws/queryObject路径
     * @return
     */
	@RequestMapping(method=RequestMethod.POST,value="/ws/queryObject")
	public String queryData(@RequestParam(value = "args[]") String[] args);
	 
	
    /**
     * 这里@requestMapping里指定的路径就是cqjxj-interface工程里的controller里的/ws/writeObject路径
     * @return
     */
	@RequestMapping(method=RequestMethod.POST,value="/ws/writeObject")
	public String writeData(@RequestParam(value = "args[]") String[] args);
}
