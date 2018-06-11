package com.ccttic.controller.enterprise;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.beans.ResponseMsg;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.service.enterprise.IEnterpriseService;
import com.ccttic.util.common.JsonUtil;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IEnterpriseService enterpriseService;

	@RequestMapping(value = "/selectEnterprise", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<Map<String, Object>> selectEnterprise(HttpServletRequest request, @RequestBody String id) {
		ResponseMsg<Map<String, Object>> rm = new ResponseMsg<Map<String, Object>>();
		Map<String, String> map = JsonUtil.jsonToMap(id);

		try {
			Map<String, Object> result = enterpriseService.selectEnterpriseById(map);
			rm.setData(result);
			rm.success("获得企业数据成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("获得企业数据失败");
			logger.info(e);
		}
		return rm;
	}

	@RequestMapping(value = "/modifyEnterprise", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<String> modifyEnterprise(HttpServletRequest request, @RequestBody EssEnterprise essEnterprise) {
		ResponseMsg<String> rm = new ResponseMsg<String>();

		try {
			enterpriseService.modifyEnterpriseById(essEnterprise);
			rm.success("修改企业数据成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("企业数据失败");
			logger.info(e);
		}
		return rm;
	}

	@RequestMapping(value = "/delEnterprise", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<String> delEnterprise(HttpServletRequest request, @RequestBody EssEnterprise essEnterprise) {
		ResponseMsg<String> rm = new ResponseMsg<String>();
		try {
			int i = enterpriseService.delEnterpriseById(essEnterprise);
			if (i ==0) {
				rm.success("删除企业数据成功");
			} else {
				rm.fail("该企业下还有员工,请先将员工删完");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("删除企业数据失败");
			logger.info(e);
		}
		return rm;
	}
}