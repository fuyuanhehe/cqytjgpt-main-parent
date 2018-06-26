package com.ccttic.cqytjgpt.webapi.controller.vehicle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ccttic.cqytjgpt.webapi.client.cqjxj.VehicleFrign;
import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryCarService;
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.InputVehiVo;
import com.ccttic.entity.role.vo.PageVehiIllicitVo;
import com.ccttic.entity.role.vo.PageVehicleVo;
import com.ccttic.entity.role.vo.VehicleList;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
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
@SessionAttributes(Const.ENT)
public class VehicleContrller implements Serializable {
	
	private String token = null; 

	private static final long serialVersionUID = -2422516254972777732L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehicleService vehicleService;
	@Autowired
	private IQueryCarService queryCarService;
	
	@Autowired
	private VehicleFrign frign;
	/**
	 * 根据条件获取车辆基本信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_BASE_INFO, name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE), prsc = {
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String qryVehicleList(@RequestBody  PageVehicleVo vehicle,@ModelAttribute(Const.ENT) EssEnterprise ent) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(vehicle.getPage());
			page.setRows(vehicle.getRows());
			vehicle.setMgrEnterpriseId(ent.getId());
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
	@RequestMapping(value = "/saveVehicle", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ADD_CAR, name = "新增车辆",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String saveVehicle(@RequestBody VehicleList listMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> maps = vehicleService.saveVehicle(listMap);
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
	@RequestMapping(value = "/modifVehicle", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.MODIFICATION_CAR, name = "修改车辆",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String modifVehicle(@RequestBody VehicleList listMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> maps = listMap.getListMap();
		for (int i = 0; i < maps.size(); i++) {
			Map<String, String> mapVe = maps.get(i);
			try {
				// Vehicle vehicle = new Vehicle();
				// vehicle.setVehiNo(vehiNoGather[i]);
				// vehicle.setVehiType(vehiTypeGather[0]);
				// 调用接口获取车辆基础信息
				XMLCar xmlCar = queryCarService.selectCarByHpzlHphm(mapVe.get("vehiNoType"), mapVe.get("vehiNo"));
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
	@RequestMapping(value = "/qryOneVehicle", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.PARTICULARS_INFO, name = "车辆详情",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String qryOneVehicle(@RequestBody Vehicle ve) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", ve.getId());
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
	@RequestMapping(value = "/qryOneVehiIllicit", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ILLICIT_INFO, name = "违法信息",  hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO)
    , prsc = {@Resource( cd = Const.CAR_BASE_INFO, url="/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String qryOneVehiIllicit(@RequestBody PageVehiIllicitVo vehiIllicit) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(vehiIllicit.getPage());
			page.setRows(vehiIllicit.getRows());
			Page<VehiIllicit> pager = vehicleService.qryVehiIllicitList(page, vehiIllicit);
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
	 * 根据条件获取车辆历史轨迹信息 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/qryOneHistoryTrack", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_HISTORY_TRACK, name = "查询",  hierarchy = 4, isMenue = false, pcd = Const.CAR_TRACK)
    , prsc = {@Resource( cd = Const.CAR_TRACK, url="/vehicle/qryOneVehicleInfoList", name = "动态监管", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String qryOneHistoryTrack(@RequestBody InputVehiVo vo) {
		if (token==null) {
			token = getToken();
		}
		String s = frign.queryData(token, "渝"+vo.getVehiNo(), vo.getStartDate(), vo.getEndDate());
		
		return s;
	}
	
	/**
	 * 根据车牌号获取车辆信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehicleInfo", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_HISTORY_INFO, name = "搜索",  hierarchy = 4, isMenue = false, pcd = Const.CAR_TRACK)
    , prsc = {@Resource( cd = Const.CAR_TRACK, url="/vehicle/qryOneVehicleInfoList", name = "动态监管", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public String qryOneVehicleInfo(@RequestBody InputVehiVo vo) {
		if (token==null) {
			token = getToken();
		}
		String s = frign.vehicleInfo(token, "渝"+vo.getVehiNo());
		return s;
	}
	
	/**
	 * 根据条件获取车辆信息
	 * 
	 * @param id
	 * @return
	 */
	@ResourceScan(rsc = @Resource(cd = Const.CAR_TRACK, name = "动态监管", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE), prsc = {
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@RequestMapping(value = "/qryOneVehicleInfoList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	
	public String qryOneVehicleInfoList() {
		if (token==null) {
			token = getToken();
		}
		String flag = "0";
		String fenceCd="500000";
		String s = frign.vehicleInfoList(token,flag,fenceCd);
		return s;
	}
	
	/**
	 * 调用交巡警登录接口获取token
	 * @return
	 */
	public String getToken(){
		String account = "admin";
		String password = "123456";
		String user = frign.login(account, password);
		Map<String, String> maparray = JsonUtil.jsonToMap(user);
		String data = ObjectHelper.objectToJson(maparray.get("data"));
		Map<String, String> map = JsonUtil.jsonToMap(data);
		String token =map.get("token");
		return token;
	}
}
