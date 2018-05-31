package com.ccttic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.service.TestService;
import com.ccttic.util.auth.AuthServiceFeign;
import com.ccttic.util.logger.annotation.OperLogging;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    private TestService testService;
    
    @Autowired
	private AuthServiceFeign authFeign;



    @RequestMapping("/test")
    @OperLogging(content = "123456", remark = "test", operType = 1)
    @PreAuthorize("hasAuthority('query-demo')")
    public String getTestString() {
        return "syao";
    }
    
	@RequestMapping("/login")
	public String login(String username,String password,String flag,String scope) {
//		String username="admin";
//		String password="admin123";//得到加密后的密码
		String grant_type="password";
//		String scope="ccttic";
		String value="NA";
		if("pc".equals(flag)){
		 value=authFeign.getAccessToken(username, password, grant_type, scope);
		}
//		if("move".equals(flag)){
//			value=authMobileFeign.getAccessToken(username, password, grant_type, scope);
//		}
		 return value;
	}
	
	@RequestMapping("/refreshToken")
	public String refreshToken(@RequestParam(value = "refresh_token") String refresh_token,String flag) {
		String grant_type="refresh_token";
		String value="NA";
		if("pc".equals(flag)){
			value=authFeign.getRefreshToken(refresh_token,grant_type);
		}
//		if("move".equals(flag)){
//			value=authMobileFeign.getRefreshToken(refresh_token,grant_type);
//		}
		
		return value;
	}
	
	@RequestMapping("/destoryToken")
	public String destoryToken(@RequestParam(value = "token") String access_token) {
		System.out.println(access_token);
		String value=authFeign.destoryAccess_token(access_token);
		return value;
	}
	
	@RequestMapping("/reLoadResources")
	public String load() {
		String res = "hi syao";
		try {
//			soruce.doLoadResourceDefine();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "suceess->"+res;
	}
}
