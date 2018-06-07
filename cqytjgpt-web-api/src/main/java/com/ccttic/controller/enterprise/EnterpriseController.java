package com.ccttic.controller.enterprise;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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

	private IEnterpriseService enterpriseService;

	@RequestMapping(value = "/selectEnterprise", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<EssEnterprise> selectEnterprise(HttpServletRequest request, @RequestBody String id) {
		ResponseMsg<EssEnterprise> rm = new ResponseMsg<EssEnterprise>();
		Map<String, String> map = JsonUtil.jsonToMap(id);

		try {
			EssEnterprise enterprise = enterpriseService.selectEnterpriseById(map);
			rm.setData(enterprise);
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

		int i = enterpriseService.modifyEnterpriseById(essEnterprise);
		if (i == 1) {
			rm.success("获得企业数据成功");
		} else {

			rm.fail("获得企业数据失败");
		}
		return rm;
	}
}
