package com.ccttic.cqytjgpt.webapi.controller.enterprise;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

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
	
	@RequestMapping(value = "/registerEnterpries", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<String> registerEnterpries(HttpServletRequest request, @RequestBody EnterpriseVo vo) {
		ResponseMsg<String> rm = new ResponseMsg<String>();
		try {
			int i = enterpriseService.registerEnterpries(vo);
			if (i ==1) {
				rm.success("添加数据成功");
			} else {
				rm.fail("添加数据失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail("添加数据失败");
			logger.info(e);
		}
		return rm;
	}
	
	/**
	 * 根据条件获取企业信息
	 * @param page
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/qryEnterpriesList", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String qryEnterpriesList(PageRequest page, EssEnterprise vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Page<EssEnterprise> pager = enterpriseService.qryEssEnterpriseList(page, vo);
			map.put("data", pager.getRecords());
			map.put("total", pager.getTotalRows());
			map.put("result", 0);
			map.put("msg", "获取信息成功！");
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "获取信息失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	
	
}
