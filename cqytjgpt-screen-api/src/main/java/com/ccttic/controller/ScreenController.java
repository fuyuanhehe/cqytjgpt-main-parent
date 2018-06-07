package com.ccttic.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.beans.ResponseMsg;

/**
 * 
 * @author zzy 源头监管大屏展示
 */
@RestController
@RequestMapping("/screen")
public class ScreenController {
	
	private Logger log = Logger.getLogger(this.getClass());
	// 驾驶人隐患发现情况
	@RequestMapping("findDangerForDriver")
	public ResponseMsg<Map<String, Object>> findDangerForDriver() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 机动车隐患发现情况
	@RequestMapping("findDangerForCar")
	public ResponseMsg<Map<String, Object>> findDangerForCar() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 驾驶员隐患问题分布情况
	@RequestMapping("distributionDangerForDriver")
	public ResponseMsg<Map<String, Object>> distributionDangerForDriver(@RequestBody Map<String, Object> dateMap) {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		// dateMap 年季月
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 机动车隐患问题分布情况
	@RequestMapping("distributionDangerForCar")
	public ResponseMsg<Map<String, Object>> distributionDangerForCar(@RequestBody Map<String, Object> dateMap) {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 驾驶员隐患治理结果分析
	@RequestMapping("handleDangerForDriver")
	public ResponseMsg<Map<String, Object>> handleDangerForDriver() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 机动车隐患治理结果分析
	@RequestMapping("handleDangerForCar")
	public ResponseMsg<Map<String, Object>> handleDangerForCar() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 驾驶员整治效果趋势分析
	@RequestMapping("resultDangerForDriver")
	public ResponseMsg<Map<String, Object>> resultDangerForDriver() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 机动车整治效果趋势分析
	@RequestMapping("resultDangerForCar")
	public ResponseMsg<Map<String, Object>> resultDangerForCar() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 分区隐患信息
	@RequestMapping("areaDangerInfo")
	public ResponseMsg<Map<String, Object>> areaDangerInfo() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}



	// 隐患驾驶员通报
	@RequestMapping("noticeDangerForDriver")
	public ResponseMsg<Map<String, Object>> noticeDangerForDriver(@RequestBody Map map) {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 隐患驾驶员通报
	@RequestMapping("noticeDangerForCar")
	public ResponseMsg<Map<String, Object>> noticeDangerForCar() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 各区隐患排名
	@RequestMapping("areaDangersTop")
	public ResponseMsg<Map<String, Object>> areaDangersTop() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 各区驾驶员隐患占比
	@RequestMapping("ratioDangerForDriver")
	public ResponseMsg<Map<String, Object>> ratioDangerForDriver() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 各区机动车隐患占比
	@RequestMapping("ratioDangerForCar")
	public ResponseMsg<Map<String, Object>> ratioDangerForCar() {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 各分所治理情况
	@RequestMapping("deptDangerForDriver")
	public ResponseMsg<Map<String, Object>> deptDangerForDriver(@RequestBody Map<String,Object> map) {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		
		// map 不同分所   ，驾驶人或机动车
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}

	// 各区机动车隐患占比
	@RequestMapping("deptDangerForCar")
	public ResponseMsg<Map<String, Object>> deptDangerForCar(@RequestBody Map<String,Object> map) {
		ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
		try {
			response.success("查询成功");
		} catch (Exception e) {
			log.error("查询失败"+e.getMessage());
			response.fail("查询失败"+e.getMessage());
		}
		return response;
	}
}
