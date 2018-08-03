package com.ccttic.cqytjgpt.webapi.controller.vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ccttic.cqytjgpt.webapi.client.cqjxj.VehicleFeign;
import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryCarService;
import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.InputVehiVo;
import com.ccttic.entity.role.vo.PageVehiIllicitVo;
import com.ccttic.entity.role.vo.PageVehicleVo;
import com.ccttic.entity.role.vo.VehicleList;
import com.ccttic.entity.role.vo.VehicleVO;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.jwt.JWTUtil;
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

	private String token = null;

	private static final long serialVersionUID = -2422516254972777732L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehicleService vehicleService;
	@Autowired
	private IQueryCarService queryCarService;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private RedisService<EmployeeVo> redisService;
	@Autowired
	private VehicleFeign frign;

	/**
	 * 根据条件获取车辆基本信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_BASE_INFO, name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE), prsc = {
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<Vehicle>> qryVehicleList(@RequestBody PageVehicleVo vehicle,
			@RequestParam String access_token) {
		ResponseMsg<List<Vehicle>> resp = new ResponseMsg<List<Vehicle>>();
		try {
			if (StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 为空");
				return resp;
			}
			PageRequest page = new PageRequest();
			page.setPage(vehicle.getPage());
			page.setRows(vehicle.getRows());
			
			String username=JWTUtil.getUsername(access_token);
			// 从redis获取用户信息 
			EmployeeVo vo = (EmployeeVo)  redisService.get(username+Const.TOKEN);
			EssEnterprise ent = null;
			Organization org = null;
			if (null != vo) {
				ent = vo.getEnt();
				org = vo.getOrg();
			} else {
				EmployeeVo employee;
				try {
					employee = employeeService.findEmployeeByAccount(username);
					ent = employee.getEnt();
					org = employee.getOrg();
					redisService.set(username+Const.TOKEN,employee,Const.USER_REDIS_LIVE);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			String id = null;
			 // 根据登录账号类型判断查询数据
			if (Const.SUPERMAN.equals(vo.getEmptype())) {
				vehicle.setEmpType(Const.SUPERMAN);
			} else if (Const.SUPER.equals(vo.getEmptype())) {
				vehicle.setEmpType(Const.SUPER);
				if (null != org) {
					id = org.getOrgCd();
				}
			} else if (Const.ADMIN.equals(vo.getEmptype())) {
				vehicle.setEmpType(Const.ADMIN);
				if (null != ent) {
					id = ent.getId();
				}
			} else {
				resp.fail("该账号无查询数据权限");
				return resp;
			}
			Page<Vehicle> pager = vehicleService.qryVehicleList(page, vehicle,id);
			resp.setData(pager.getRecords());
			resp.setTotal(pager.getTotalRows().intValue());
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
			logger.error("查询失败！", e);
		}
		return resp;
	}

	/**
	 * 新增车牌号和车辆类型到数据库
	 * -----------------------------------这个接口可能要改，因为前端传递的机动车编号会有渝字-------------------------------
	 * 
	 * @param
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/saveVehicle", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ADD_CAR, name = "新增车辆", hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO), prsc = {
			@Resource(cd = Const.CAR_BASE_INFO, url = "/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> saveVehicle(@RequestBody VehicleList listMap, HttpServletRequest request,
			@RequestParam String access_token) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			String entId = "";
			if (StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 为空");
				return resp;
			}
			String username = JWTUtil.getUsername(access_token);
			EmployeeVo vo = null;

				try {
					vo = employeeService.findEmployeeByAccount(username);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			EssEnterprise ent = vo.getEnt();
			if (ent == null) {
				resp.fail("该用户企业为null");
				return resp;
			}
			// 默认只有一个 所以直接取list的第一条数据
			if (ent == null) {
				resp.fail("添加失败,只有企业才能添加车辆！");
				return resp;
			}
			entId = ent.getId();
			Map<String, Object> maps = vehicleService.saveVehicle(listMap, entId);
			if ((int) maps.get("cet") == 1) {
				resp.fail(maps.get("gather") + "其他添加成功！");
			} else {
				resp.success("添加成功！");
			}

		} catch (AppException e) {
			resp.fail("添加失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 调取信息（调取接口补全车辆信息）
	 * 
	 * @param
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifVehicle", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.MODIFICATION_CAR, name = "修改车辆", hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO), prsc = {
			@Resource(cd = Const.CAR_BASE_INFO, url = "/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> modifVehicle(@RequestBody VehicleList listMap) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		List<Map<String, String>> maps = listMap.getListMap();
		for (int i = 0; i < maps.size(); i++) {
			Map<String, String> mapVe = maps.get(i);
			try {
				// 调用接口获取车辆基础信息
				XMLCar xmlCar = queryCarService.selectCarByHpzlHphm(mapVe.get("vehiNoType"), mapVe.get("vehiNo"));
				if (xmlCar == null) {
					continue;
				}
				vehicleService.modifVehicle(xmlCar);
				resp.success("修改成功！");
			} catch (Exception e) {
				resp.fail("调用交巡警接口失败！");
				logger.error(e.getMessage());
			}
		}

		return resp;
	}

	/**
	 * 根据条件获取指定车辆信息 （详情）
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehicle", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.PARTICULARS_INFO, name = "车辆详情", hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO), prsc = {
			@Resource(cd = Const.CAR_BASE_INFO, url = "/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<VehicleVO> qryOneVehicle(@RequestBody Vehicle ve) {
		ResponseMsg<VehicleVO> resp = new ResponseMsg<VehicleVO>();
		Map<String, Object> params = new HashMap<String, Object>();
		// 去掉空格
		String vehiNo = ve.getVehiNo().replace(" ", "");
		// 匹配除了中文的
		Pattern pt = Pattern.compile("\\w+");
		Matcher mc = pt.matcher(vehiNo);
		if (mc.find()) {
			// 去掉中文之后的
			vehiNo = mc.group();
		}

		params.put("vehiNo", vehiNo);
		try {
			VehicleVO vehicle = vehicleService.qryOneVehicle(params);
			resp.setData(vehicle);
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 根据条件获取指定车辆信息 （违法记录）
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehiIllicit", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ILLICIT_INFO, name = "违法信息", hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO), prsc = {
			@Resource(cd = Const.CAR_BASE_INFO, url = "/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<VehiIllicit>> qryOneVehiIllicit(@RequestBody PageVehiIllicitVo vehiIllicit) {
		ResponseMsg<List<VehiIllicit>> resp = new ResponseMsg<List<VehiIllicit>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(vehiIllicit.getPage());
			page.setRows(vehiIllicit.getRows());
			Page<VehiIllicit> pager = vehicleService.qryVehiIllicitList(page, vehiIllicit);
			resp.setData(pager.getRecords());
			resp.setTotal(pager.getTotalRows().intValue());
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 根据条件获取车辆历史轨迹信息 ----------------------------------这个接口的渝字 后期也要修改
	 * 因为前端统一要传----------------------------
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/qryOneHistoryTrack", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_HISTORY_TRACK, name = "查询", hierarchy = 4, isMenue = false, pcd = Const.CAR_TRACK), prsc = {
			@Resource(cd = Const.CAR_TRACK, url = "/vehicle/qryOneVehicleInfoList", name = "动态监管", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<JSON> qryOneHistoryTrack(@RequestBody InputVehiVo vo) {
		ResponseMsg<JSON> resp = new ResponseMsg<JSON>();
		if (token == null) {
			token = getToken();
		}
		String s = frign.queryData(token, "渝" + vo.getVehiNo(), vo.getStartDate(), vo.getEndDate());
		Map<String, String> map = JsonUtil.jsonToMap(s);
		if ("-1".equals(map.get("result"))) {
			resp.fail("查询失败！第三方接口返回消息"+map.get("msg"));
		} else {
			resp.setData(JSON.parseObject(s));
			resp.success("查询成功！");
		}
		

		return resp;
	}

	/**
	 * 根据车牌号获取车辆信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehicleInfo", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_HISTORY_INFO, name = "搜索", hierarchy = 4, isMenue = false, pcd = Const.CAR_TRACK), prsc = {
			@Resource(cd = Const.CAR_TRACK, url = "/vehicle/qryOneVehicleInfoList", name = "动态监管", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<JSON> qryOneVehicleInfo(@RequestBody InputVehiVo vo) {
		ResponseMsg<JSON> resp = new ResponseMsg<JSON>();
		if (token == null) {
			token = getToken();
		}
		String s = frign.vehicleInfo(token, vo.getVehiNo(),"0");
		Map<String, String> map = JsonUtil.jsonToMap(s);
		if ("-1".equals(map.get("result"))) {
			resp.fail("查询失败！第三方接口返回消息"+map.get("msg"));
		} else {
			resp.setData(JSON.parseObject(s));
			resp.success("查询成功！");
		}
		return resp;
	}

	/**
	 * 根据条件获取车辆信息
	 * 
	 * @param
	 * @return
	 */

	@ResourceScan(rsc = @Resource(cd = Const.CAR_TRACK, name = "动态监管", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE), prsc = {
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@RequestMapping(value = "/qryOneVehicleInfoList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseMsg<List<JSON>> qryOneVehicleInfoList(HttpServletRequest request,@RequestParam String access_token,@RequestBody InputVehiVo vehVo) {
		ResponseMsg<List<JSON>> resp = new ResponseMsg<List<JSON>>();
		if (StringUtils.isEmpty(access_token)) {
			resp.fail("access_token 为空");
			return resp;
		}
		String username = JWTUtil.getUsername(access_token);
		if (token == null) {
			token = getToken();
		}
			EmployeeVo vo=null;
			try {
				vo = employeeService.findEmployeeForDynamic(username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		List<JSON> list = new ArrayList<JSON>();

		Area area = null;

			if (Const.SUPERMAN.equals(vo.getEmptype()) || "0".equals(vo.getOrg().getOrgType())) {
				String s =null;
				if (null != vehVo.getVehiNo()) {
					s = frign.vehicleInfoList(token,"0",null,"0",vehVo.getVehiNo());
				} else {
					s = frign.vehicleInfoList(token,"0",vehVo.getAreaCd(),"1",null);
				}
				
				Map<String, String> maps = JsonUtil.jsonToMap(s);
				if ("-1".equals(maps.get("result"))) {
					resp.fail("查询失败！第三方接口返回消息"+maps.get("msg"));
				} else {
					list.add(JSON.parseObject(s));
				}
		} else if (Const.SUPER.equals(vo.getEmptype()) && "1".equals(vo.getOrg().getOrgType())) {
				List<Organization> orgs = vo.getCanSeeOrgs();
				for (Organization org : orgs) {
					area = vehicleService.getfenceIdByEssid(org.getId());
					if (null != vehVo.getVehiNo()) {
						list.add(JSON.parseObject(area != null && area.getAreaCd() != null
								? frign.vehicleInfoList(token, "0", null,"0",vehVo.getVehiNo())
								: null));
					} else {
						list.add(JSON.parseObject(area != null && area.getAreaCd() != null
								? frign.vehicleInfoList(token, "0", area.getAreaCd(),"1",null)
								: null));
					}
					
				}

			} else if (Const.ADMIN.equals(vo.getEmptype()) && "2".equals(vo.getEmptype())) {
				area = vehicleService.getfenceIdByEssid(vo.getOrg().getId());
				if (null != vehVo.getVehiNo()) {
					list.add(JSON.parseObject(
							area != null && area.getAreaCd() != null ? frign.vehicleInfoList(token, "0", null,"0",vehVo.getVehiNo())
									: null));
				} else {
					list.add(JSON.parseObject(
							area != null && area.getAreaCd() != null ? frign.vehicleInfoList(token, "0", area.getAreaCd(),"0",null)
									: null));
				}
				
			}


		resp.setData(list);
		resp.success("查询成功！");
		return resp;
	}

	/**
	 * 调用交巡警登录接口获取token
	 * 
	 * @return
	 */
	public String getToken() {
		String account = "admin";
		String password = "123456";
		String user = frign.login(account, password);
		Map<String, String> maparray = JsonUtil.jsonToMap(user);
		String data = ObjectHelper.objectToJson(maparray.get("data"));
		Map<String, String> map = JsonUtil.jsonToMap(data);
		String token = map.get("token");
		return token;
	}
}
