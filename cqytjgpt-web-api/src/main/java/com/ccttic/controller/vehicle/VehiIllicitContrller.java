package com.ccttic.controller.vehicle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.exception.AppException;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.service.vehicle.IVehiIllicitService;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

/**
 * 功能说明： 车辆违法信息Contrller
 * @author admin
 *
 */
@RestController
@RequestMapping("/vehiIllicit")
public class VehiIllicitContrller implements Serializable{
	private static final long serialVersionUID = 4967775901502780928L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehiIllicitService vehiIllicitService;
	/**
	 * 根据条件获取车辆违法信息
	 * @return
	 */
	@RequestMapping(value = "/qryVehiIllicitList", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String qryVehiIllicitList (PageRequest page, VehiIllicit vehiIllicit) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 企业id 调用接口获取企业id TODO
		String entId = ""; 
		try {
			Page<VehiIllicit> pager = vehiIllicitService.qryVehiIllicitList(page, vehiIllicit, entId);
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
	
	/**
	 * 根据条件获取指定车辆违法信息 （详情）
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehiIllicit", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String qryOneVehiIllicit (String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		try {
			VehiIllicit vehiIllicit = vehiIllicitService.qryOneVehiIllicit(params);
			map.put("data", vehiIllicit);
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
