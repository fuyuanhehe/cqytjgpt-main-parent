package com.ccttic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.core.annotation.Resource;
import com.ccttic.core.annotation.ResourceScan;
import com.ccttic.service.TestService;
import com.ccttic.util.auth.AuthServiceFeign;
import com.ccttic.util.common.Const;
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
	
//	@RequestMapping("/test1")
//    @ResourceScan(rsc = @Resource( cd = Const.CAR_BASE_INFO, name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE)
//    	         ,prsc = {@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
//    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
//	public String test1() {
//		return "";
//	}
//	
//	@RequestMapping("/test2")
//    @ResourceScan(rsc = @Resource(cd = Const.ADD_CAR, name = "新增车辆",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
//    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/test1", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
//    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
//    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
//	public String test2() {
//		return "";
//	}

}
