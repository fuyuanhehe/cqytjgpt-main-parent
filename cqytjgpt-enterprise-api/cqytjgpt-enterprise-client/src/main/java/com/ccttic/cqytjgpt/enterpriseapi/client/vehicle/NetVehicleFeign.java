package com.ccttic.cqytjgpt.enterpriseapi.client.vehicle;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="lkywjxj-service", url="${urls.ypt-url}",path="lkywjxj")
public interface NetVehicleFeign {
	
	/**
     * 这里@requestMapping里指定的路径就是lkywjxj-service工程里的里的/lkywjxj-service/admin/qryVehiHissTrack路径
     * @return
     */
	@RequestMapping(method=RequestMethod.POST,value="/qryVehiHissTrack")
	public String queryData(@RequestParam(value = "token") String token,@RequestParam(value = "vehiNo") String vehiNo
			,@RequestParam(value = "startDate") String startDate,@RequestParam(value = "endDate") String endDate);
	 
	
	/**
     * 这里@requestMapping里指定的路径就是lkywjxj-service工程里的里的/lkywjxj-service/admin/login路径
     * @return
     */
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public String login(@RequestParam(value = "account") String account,@RequestParam(value = "password") String password
			);
	
	
	
}
