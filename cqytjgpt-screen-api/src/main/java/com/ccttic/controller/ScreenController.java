package com.ccttic.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.service.IScreenService;

/**
 * 
 * @author zzy 源头监管大屏展示
 */
@RestController
@RequestMapping("/screen")
public class ScreenController {
	
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IScreenService screenService;
	// 驾驶人隐患发现情况
	@RequestMapping("findDangerForDriver")
	public ResponseMsg<Map<String, Object>> findDangerForDriver() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			Map<String,Object> map = screenService.findDangerForDriver();
			response.setData(map);
			response.success("驾驶人隐患发现情况查询成功");
		} catch (Exception e) {
			log.error("驾驶人隐患发现情况查询失败"+e.getMessage());
			response.fail("驾驶人隐患发现情况查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  机动车隐患发现情况
	 */
	@RequestMapping("findDangerForCar")
	public ResponseMsg<Map<String, Object>> findDangerForCar() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			Map<String,Object> map = screenService.findDangerForCar();
			response.setData(map);
			response.success("机动车隐患发现情况查询成功");
		} catch (Exception e) {
			log.error("机动车隐患发现情况查询失败"+e.getMessage());
			response.fail("机动车隐患发现情况查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  驾驶员隐患问题分布情况
	 * @param dateMap year年 season季 month月
	 */
	@RequestMapping("distributionDangerForDriver")
	public ResponseMsg<List<Map<String, Object>>> distributionDangerForDriver(@RequestBody Map<String, Object> dateMap) {
		ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
		// dateMap 年季月
		try {
			List<Map<String,Object>> map = screenService.distributionDangerForDriver(dateMap);
			response.setData(map);
			response.success("驾驶员隐患问题分布情况查询成功");
		} catch (Exception e) {
			log.error("驾驶员隐患问题分布情况查询失败"+e.getMessage());
			response.fail("驾驶员隐患问题分布情况查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  机动车隐患问题分布情况
	 * @param dateMap year年 season季 month月
	 */
	@RequestMapping("distributionDangerForCar")
	public ResponseMsg<List<Map<String, Object>>> distributionDangerForCar(@RequestBody Map<String, Object> dateMap) {
		ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
		// dateMap 年季月
		try {
			List<Map<String,Object>> map = screenService.distributionDangerForCar(dateMap);
			response.setData(map);
			response.success("机动车隐患问题分布情况查询成功");
			return response;
		} catch (Exception e) {
			log.error("机动车隐患问题分布情况查询失败"+e.getMessage());
			response.fail("机动车隐患问题分布情况查询失败"+e.getMessage());
			return response;
		}
	
	}

	/**
	 *  驾驶员隐患治理结果分析
	 */
	@RequestMapping("handleDangerForDriver")
	public ResponseMsg<Map<String, Object>> handleDangerForDriver() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			Map<String,Object> map = screenService.handleDangerForDriver();
			response.setData(map);
			response.success("驾驶员隐患治理结果分析查询成功");
		} catch (Exception e) {
			log.error("驾驶员隐患治理结果分析查询失败"+e.getMessage());
			response.fail("驾驶员隐患治理结果分析查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  机动车隐患治理结果分析
	 */
	@RequestMapping("handleDangerForCar")
	public ResponseMsg<Map<String, Object>> handleDangerForCar() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			log.info("开始查询处理过的机动车");
			Map<String,Object> map = screenService.handleDangerForCar();
			response.setData(map);
			response.success("机动车隐患治理结果分析查询成功");
		} catch (Exception e) {
			log.error("机动车隐患治理结果分析查询失败"+e.getMessage());
			response.fail("机动车隐患治理结果分析查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  驾驶员整治效果趋势分析
	 */
	@RequestMapping("resultDangerForDriver")
	public ResponseMsg<Map<String, Object>> resultDangerForDriver() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			log.info("开始查询驾驶员整治效果趋势");
			Map<String,Object> map = screenService.resultDangerForDriver();
			response.setData(map);
			response.success("驾驶员整治效果趋势分析查询成功");
		} catch (Exception e) {
			log.error("驾驶员整治效果趋势分析查询失败"+e.getMessage());
			response.fail("驾驶员整治效果趋势分析查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  机动车整治效果趋势分析
	 */
	@RequestMapping("resultDangerForCar")
	public ResponseMsg<Map<String, Object>> resultDangerForCar() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			log.info("开始查询机动车整治效果趋势");
			Map<String,Object> map = screenService.resultDangerForCar();
			response.setData(map);
			response.success("查询成功");
		} catch (Exception e) {
			log.error("机动车整治效果趋势分析查询失败"+e.getMessage());
			response.fail("机动车整治效果趋势分析查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  分区隐患信息
	 */
	@RequestMapping("areaDangerInfo")
	public ResponseMsg<List<Map<String, Object>>> areaDangerInfo() {
		ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
		try {
			log.info("开始查询分区隐患信息");
			List<Map<String,Object>> map = screenService.areaDangerInfo();
			response.setData(map);
			response.success("分区隐患信息查询成功");
		} catch (Exception e) {
			log.error("分区隐患信息查询失败"+e.getMessage());
			response.fail("分区隐患信息查询失败"+e.getMessage());
		}
		return response;
	}



	/**
	 *  隐患驾驶员通报
	 * @param map top 第几条 
	 */
	@RequestMapping("noticeDangerForDriver")
	public ResponseMsg<DrDanger> noticeDangerForDriver(@RequestBody Map map) {
		ResponseMsg<DrDanger> response = new ResponseMsg<DrDanger>();
		try {
			log.info("开始查询隐患驾驶员通报");
			DrDanger driver = screenService.noticeDangerForDriver(map);
			response.setData(driver);
			response.success("隐患驾驶员通报查询成功");
		} catch (Exception e) {
			log.error("隐患驾驶员通报查询失败"+e.getMessage());
			response.fail("隐患驾驶员通报查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  机动车通报
	 * @param map top 第几条 
	 */
	@RequestMapping("noticeDangerForCar")
	public ResponseMsg<VehiDanger> noticeDangerForCar(@RequestBody Map map) {
		ResponseMsg<VehiDanger> response = new ResponseMsg<VehiDanger>();
		try {
			log.info("开始查询隐患机动车通报");
			VehiDanger vehiDanger = screenService.noticeDangerForCar(map);
			response.setData(vehiDanger);
			response.success("隐患机动车通报查询成功");
		} catch (Exception e) {
			log.error("隐患机动车通报查询失败"+e.getMessage());
			response.fail("隐患机动车通报查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  各区隐患排名
	 */
	@RequestMapping("areaDangersTop")
	public ResponseMsg<List<Map<String, Object>>> areaDangersTop() {
		ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
		try {
			log.info("开始查询各区隐患排行");
			List<Map<String,Object>> topList = screenService.areaDangerInfo();
			response.setData(topList);
			response.success("各区隐患排名查询成功");
		} catch (Exception e) {
			log.error("各区隐患排名查询失败"+e.getMessage());
			response.fail("各区隐患排名查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  各区驾驶员隐患占比
	 */
	@RequestMapping("ratioDangerForDriver")
	public ResponseMsg<List<Map<String, Object>>> ratioDangerForDriver() {
		ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
		try {
			log.info("开始查询各区驾驶员占比");
			List<Map<String,Object>> topList = screenService.ratioDangerForDriver();
			response.setData(topList);
			response.success("各区驾驶员隐患占比查询成功");
		} catch (Exception e) {
			log.error("各区驾驶员隐患占比查询失败"+e.getMessage());
			response.fail("各区驾驶员隐患占比查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  各区机动车隐患占比
	 */
	@RequestMapping("ratioDangerForCar")
	public ResponseMsg<List<Map<String, Object>>> ratioDangerForCar() {
		ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
		try {
			log.info("开始查询各区机动车占比");
			List<Map<String,Object>> topList = screenService.ratioDangerForCar();
			response.setData(topList);
			response.success("各区机动车隐患占比查询成功");
		} catch (Exception e) {
			log.error("各区机动车隐患占比查询失败"+e.getMessage());
			response.fail("各区机动车隐患占比查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  各分所驾驶员治理情况
	 * @param map orgId 分所id
	 */
	@RequestMapping("deptDangerForDriver")
	public ResponseMsg<Map<String, Object>> deptDangerForDriver(@RequestBody Map<String,Object> map) {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		
		// map 不同分所   ，驾驶人或机动车
		try {
			log.info("开始查询各分所驾驶员治理情况");
			Map<String,Object> tempMap =screenService.deptDangerForDriver(map);
			response.setData(tempMap);
			response.success("各分所驾驶员治理情况查询成功");
		} catch (Exception e) {
			log.error("各分所驾驶员治理情况查询失败"+e.getMessage());
			response.fail("各分所驾驶员治理情况查询失败"+e.getMessage());
		}
		return response;
	}

	/**
	 *  各分所机动车治理情况
	 * @param map orgId 分所id
	 */
	@RequestMapping("deptDangerForCar")
	public ResponseMsg<Map<String, Object>> deptDangerForCar(@RequestBody Map<String,Object> map) {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			log.info("开始查询各分所机动车治理情况");
			Map<String,Object> tempMap =screenService.deptDangerForDriver(map);
			response.setData(tempMap);
			response.success("各区机动车治理情况查询成功");
		} catch (Exception e) { 
			log.error("各区机动车治理情况查询失败"+e.getMessage());
			response.fail("各区机动车治理情况占比查询失败"+e.getMessage());
		}
		return response;
	}
}
