package com.ccttic.cqytjgpt.screen.service.danger;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccttic.cqytjgpt.screen.mapper.danger.EtpDangerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.screen.interfaces.danger.IScreenService;
import com.ccttic.cqytjgpt.screen.mapper.danger.DrDangerMapper;
import com.ccttic.cqytjgpt.screen.mapper.danger.VehiDangerMapper;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.VehiDanger;

@SuppressWarnings("all") 
@Service
public class ScreenServiceImpl implements IScreenService{
	@Autowired
	DrDangerMapper drDangerMapper;
	@Autowired
	VehiDangerMapper vehiDangerMapper;
	@Autowired
	EtpDangerMapper etpDangerMapper;
	@Override
	public Map<String, Object> findDangerForDriver() {
		Map map = new HashMap();
		// 查询驾驶员接入数
		int intoNum =drDangerMapper.countIntoNum();
		// 查询驾驶员隐患发现数
		int findNum = drDangerMapper.countDriverDangerNum();
		// 查询预警数 根据级别分组 返回list
		List<Map<String,Object>> warnList = drDangerMapper.countWarnNum();
		// 数据填充到map
		map.put("intoNum", intoNum);
		map.put("findNum", findNum);
		map.put("warnList", warnList);
		return map;
	}
	
	@Override
	public Map<String, Object> findDangerForCar() {
		Map map = new HashMap();
		// 查询驾驶员接入数
		int intoNum =vehiDangerMapper.countIntoNum();
		// 查询驾驶员隐患发现数
		int findNum = vehiDangerMapper.countCarDangerNum();
		// 查询预警数 根据级别分组 返回list
		List warnList = vehiDangerMapper.countWarnNum();
		// 数据填充到map
		map.put("intoNum", intoNum);
		map.put("findNum", findNum);
		map.put("warnList", warnList);
		return map;
	}

	@Override
	public Map<String, Object> findDangerForEnterprise() {
		Map map = new HashMap();
		// 查询企业接入数
		int intoNum =etpDangerMapper.countIntoNum();
		// 查询隐患企业发现数
		int findNum = etpDangerMapper.countEnterpriseDangerNum();
		map.put("intoNum", intoNum);
		map.put("findNum", findNum);
		// 查询预警数 根据级别分组 返回list
		List warnList = etpDangerMapper.countWarnNum();

		return map;
	}

	@Override
	public List<Map<String, Object>> distributionDangerForDriver(Map<String, Object> dateMap) {
		// 查询驾驶员隐患问题分布情况
		List<Map<String,Object>> driverDangerList = drDangerMapper.distributionDangerForDriver(dateMap);
		return driverDangerList;
	}

	@Override
	public List<Map<String, Object>> distributionDangerForCar(Map<String, Object> dateMap) {
		// 查询机动车隐患问题分布情况
		List<Map<String,Object>> carDangerList = vehiDangerMapper.distributionDangerForCar(dateMap);
		return carDangerList;
	}

	@Override
	public List<Map<String, Object>> distributionDangerForEnterprise(Map<String, Object> dateMap) {
		return null;
	}

	@Override
	public Map<String, Object> handleDangerForDriver() {
		Map map = new HashMap();
		// 查询未处理的驾驶员
		int noHandleDriver = drDangerMapper.countNoHandleDriver();
		//查询已处理的驾驶员隐患 暂时没有
		map.put("handleDriver", 0);
		map.put("noHandleDriver", noHandleDriver);
		return map;
	}

	@Override
	public Map<String, Object> handleDangerForCar() {
		Map map = new HashMap();
		// 查询未处理的机动车
		int noHandleCar = vehiDangerMapper.countNoHandleCar();
		//查询已处理的机动车隐患 暂时没有
		map.put("handleCar", 0);
		map.put("noHandleCar", noHandleCar);
		return map;
	}

	@Override
	public Map<String, Object> handleDangerForEnterprise() {
		Map map = new HashMap();
		// 查询未处理的企业
		int noHandleEnterprise = etpDangerMapper.countNoHandleEnterprise();
		//查询已处理的机动车隐患 暂时没有
		map.put("handleEnterprise", 0);
		map.put("noHandleEnterprise", noHandleEnterprise);
		return map;
	}

	@Override
	public Map<String, Object> resultDangerForDriver() {
		// 驾驶员隐患治理结果趋势图  按月份分类数据{"一":100","二":100...}
		Map<String,Object> driverResultMap = drDangerMapper.resultDangerForDriver();
		return driverResultMap;
	}

	@Override
	public Map<String, Object> resultDangerForCar() {
		// 机动车隐患治理结果趋势图  按月份分类数据{"一":100","二":100...}
		Map<String,Object> carResultMap = vehiDangerMapper.resultDangerForCar();
		return carResultMap;
	}

	@Override
	public Map<String, Object> resultDangerForEnterprise() {
		return null;
	}

	@Override
	public List<Map<String, Object>> areaDangerInfo() {
		// 查全市不同地区隐患数据
		List<Map<String,Object>> areaDangerInfoList = drDangerMapper.areaDangerInfo();
		return areaDangerInfoList;
	}

	@Override
	public  Map<String,Object> noticeDangerForDriver(Map map) {
		// 查询通报隐患驾驶员
		 Map<String,Object> dangerDriver = drDangerMapper.noticeDangerDriver(map);
		return dangerDriver;
	}

	@Override
	public  Map<String,Object> noticeDangerForCar(Map map) {
		// 查询通报隐患驾驶员
		 Map<String,Object> dangerCar = vehiDangerMapper.noticeDangerCar(map);
		return dangerCar;
	}

	@Override
	public Map<String, Object> noticeDangerForEnterprise(Map map) {
		return null;
	}

	/**
	 * 该接口根据分区同时查询排行 各区驾驶员 各区机动车隐患数
	 */
	@Override
	public List<Map<String, Object>> areaDangersTop() {
		// 查询各区隐患排行数
		List<Map<String,Object>> areaDangersTopList = drDangerMapper.areaDangersTop();
		return areaDangersTopList;
	}

	@Override
	public List<Map<String, Object>> ratioDangerForDriver() {
		// 驾驶员各区隐患占比
		List<Map<String,Object>> areaDangersTopList = drDangerMapper.areaDangersTop();
		return areaDangersTopList;
	}

	@Override
	public List<Map<String, Object>> ratioDangerForCar() {
		// 机动车各区隐患占比 （直接调用之前的排行接口)
		List<Map<String,Object>> areaDangersTopList = drDangerMapper.areaDangersTop();
		return areaDangersTopList;
	}

	@Override
	public List<Map<String, Object>> ratioDangerForEnterprise() {
		// 企业各区隐患占比
		List<Map<String,Object>> areaDangersTopList =etpDangerMapper.ratioDangerForEnterprise();
		return null;
	}

	@Override
	public Map<String, Object> deptDangerForDriver(Map<String, Object> map) {
		Map theMap = new HashMap();
		// 根据分所查询当月分所下各区的驾驶员隐患数
		List<Map<String,Object>> areaMonthDriverDangerList = drDangerMapper.findMonthAreaDangerByOrgId(map);
		// 查询上月的
		List<Map<String,Object>> areaPreMonthDriverDangerList = drDangerMapper.findPreMonthAreaDangerByOrgId(map);
		theMap.put("本月", areaMonthDriverDangerList);
		theMap.put("上月", areaPreMonthDriverDangerList);
		return theMap;
	}

	@Override
	public Map<String, Object> deptDangerForCar(Map<String, Object> map) {
		Map theMap = new HashMap();
		// 根据分所查询当月分所下各区的驾驶员隐患数
		List<Map<String,Object>> areaMonthCarDangerList = vehiDangerMapper.findMonthAreaDangerByOrgId(map);
		// 查询上月的
		List<Map<String,Object>> areaPreMonthCarDangerList = vehiDangerMapper.findPreMonthAreaDangerByOrgId(map);
		theMap.put("本月", areaMonthCarDangerList);
		theMap.put("上月", areaPreMonthCarDangerList);
		return theMap;
	}

	@Override
	public Map<String, Object> deptDangerForEnterprise(Map<String, Object> map) {
		return null;
	}

	@Override
	public List<Map<String, Object>> areaHandleDangersTop() {
		return null;
	}

	@Override
	public void insertScreenTotal(List<Map<String, Object>> list) {
		drDangerMapper.insertScreenTotal(list);
	}

	@Override
	public void deleteScreenTotal() {
		drDangerMapper.deleteScreenTotal();
	}

	@Override
	public List<Map<String,Object>> areaInfoTotal() {
		return drDangerMapper.areaInfoTotal();
	}

	@Override
	public List<Map<String, Object>> findPlace() {
		
		return drDangerMapper.findPlace();
	}

	@Override
	public Map<String, Object> allDriver() {
		
		return drDangerMapper.allDriver();
	}

	@Override
	public Map<String, Object> allEnterprise() {
		return null;
	}

	@Override
	public Map<String, Object> allCar() {
		return drDangerMapper.allCar();
	}

	

}
