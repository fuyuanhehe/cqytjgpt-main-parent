package com.ccttic.util.auth;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 
 * @author syao
 * @version v1.0 
 * 登录接口访问
 */

@FeignClient(value = "cqytjgpt-service-auth", configuration = FeignConfiguration.class)
public interface AuthServiceFeign {
	/**
	 * 这里@requestMapping里指定的路径就是cqjxj-interface工程里的controller里的/ws/queryObject路径
	 * 认证登录获取访问token
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value = "/oauth/token")
	public String getAccessToken(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "grant_type") String grant_type,
			@RequestParam(value = "scope") String scope);
	
	/**
	 * 根据refresh_token来获取新token
	 * @param refresh_token
	 * grant_type=refresh_token
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value = "/oauth/token")
	public String getRefreshToken(@RequestParam(value = "refresh_token") String refresh_token,@RequestParam(value = "grant_type") String grant_type);
	
	/**
	 * 注销access_token
	 * @param access_token
	 * @return
	 */
	@RequestMapping(method=RequestMethod.DELETE,value = "/oauth/token")
	public String destoryAccess_token(@RequestParam(value = "access_token") String access_token);

}
