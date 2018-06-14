package com.ccttic.cqytjgpt.webapi.controller.vehicle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryCarService;
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

/**
 * 功能说明： 车辆基本信息Contrller
 * 
 * @author admin
 *
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleContrller implements Serializable {

	private static final long serialVersionUID = -2422516254972777732L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehicleService vehicleService;
	@Autowired
	private IQueryCarService queryCarService;

	/**
	 * 根据条件获取车辆基本信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleList", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_BASE_INFO, name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE), prsc = {
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String qryVehicleList(PageRequest page, Vehicle vehicle) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Page<Vehicle> pager = vehicleService.qryVehicleList(page, vehicle);
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
	 * 新增车牌号和车辆类型到数据库
	 * 
	 * @param vehiNo
	 * @param vehiType
	 * @return
	 */
	@RequestMapping(value = "/saveVehicle", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ADD_CAR, name = "新增车辆",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String saveVehicle(String vehiNo, String vehiNoType) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> maps = vehicleService.saveVehicle(vehiNo, vehiNoType);
			if ((int) maps.get("cet") == 1) {
				map.put("result", 0);
				map.put("msg", maps.get("gather") + "其他添加成功！");
			} else {
				map.put("result", 0);
				map.put("msg", "添加成功！");
			}

		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "添加失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}

	/**
	 * 调取信息（调取接口补全车辆信息）
	 * 
	 * @param vehiNo
	 * @param vehiType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifVehicle", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.MODIFICATION_CAR, name = "修改车辆",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String modifVehicle(String vehiNoType, String vehiNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 拆分车牌号
		String[] vehiNoGather = vehiNo.split(",");
		// 号牌种类
		String[] vehiNoTypeGather = vehiNoType.split(",");
		// 循环把车牌号和车辆类型装入集合
		for (int i = 0; i < vehiNoGather.length; i++) {
			try {
				// Vehicle vehicle = new Vehicle();
				// vehicle.setVehiNo(vehiNoGather[i]);
				// vehicle.setVehiType(vehiTypeGather[0]);
				// 调用接口获取车辆基础信息
				XMLCar xmlCar = queryCarService.selectCarByHpzlHphm(vehiNoTypeGather[0], vehiNoGather[i]);
				// 根据车牌号修改车辆基础信息
				vehicleService.modifVehicle(xmlCar);
				map.put("result", 0);
				map.put("msg", "修改成功！");
			} catch (Exception e) {
				map.put("result", -1);
				map.put("msg", "修改失败！");
				logger.error(e.getMessage());
			}
		}

		return ObjectHelper.objectToJson(map);
	}

	/**
	 * 根据条件获取指定车辆信息 （详情）
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehicle", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.PARTICULARS_INFO, name = "车辆详情",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String qryOneVehicle(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		try {
			Vehicle vehicle = vehicleService.qryOneVehicle(params);
			map.put("data", vehicle);
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
	 * 根据条件获取指定车辆信息 （违法记录）
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehiIllicit", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ILLICIT_INFO, name = "违法信息",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String qryOneVehiIllicit(PageRequest page, VehiIllicit vehiIllicit, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Page<VehiIllicit> pager = vehicleService.qryVehiIllicitList(page, vehiIllicit, id);
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
