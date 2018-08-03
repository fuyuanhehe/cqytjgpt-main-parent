package com.ccttic.cqytjgpt.webapi.controller.drivers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ccttic.entity.employee.EmployeePermission;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ccttic.cqytjgpt.webapi.interfaces.drivers.DriversService;
import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.drivers.vo.DriverInsert;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverVoPage;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.entity.drivers.vo.DriverillicitVoPage;
import com.ccttic.entity.drivers.vo.EnterprisethenVo;
import com.ccttic.entity.drivers.vo.EnterprisethenVoPage;
import com.ccttic.entity.drivers.vo.PermiCarsVo;
import com.ccttic.entity.drivers.vo.VehiTotal;
import com.ccttic.entity.drivers.vo.VehicleCountVo;
import com.ccttic.entity.drivers.vo.vehiclesVo;
import com.ccttic.entity.drivers.vo.vehiclesVoPage;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;
/*
 *功能说明 : 驾驶员业务
 */

@RestController
@RequestMapping(value="/drvers")
public class DriversController implements Serializable{ 

	private static final long serialVersionUID = 1262917332392058333L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private DriversService service;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private RedisService<EmployeeVo> redisService;
	/**
	 * @return
	 * @date  2018年6月15日
	 */
	@OperLogging(operType = 3,content="驾驶员信息分页")
	@ResourceScan(rsc = @Resource(cd = Const.PERSONAL_INFORMATION, name = "驾驶人信息-基本信息", isMenue = false, hierarchy = 3, pcd = Const.DRIVER_INFORMATION), prsc = {
			@Resource(cd = Const.DRIVER_INFORMATION, name = "驾驶人监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@RequestMapping(value="/getDriversPages",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<DriverVo>> seDriverPages(@RequestBody(required = false) DriverVoPage tment,@RequestParam String access_token){
		ResponseMsg<List<DriverVo>> resp = new ResponseMsg<List<DriverVo>>();
		try {
			if(StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 不能为空");
				return resp;
			}
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());

			EmployeeVo employee = employeeService.getUserInfo(access_token);
			if(null == employee ){
				resp.fail("获取用户信息失败");
				return resp;
			}
			tment.setEmpType( employee.getEmptype());
			EmployeePermission employeePermission = employeeService.getEmployeePermission(employee);
			Page<DriverVo> data = service.seDriverPage(page, tment,employeePermission);
			resp.setMessage("获取驾驶人信息-基本信息成功！");
			resp.setStatus(0);
			resp.setData(data.getRecords());
			resp.setTotal(data.getTotalRows().intValue());

		} catch (Exception e) {
			resp.setMessage("获取驾驶人信息-基本信息失败！");
			resp.setStatus(0);
			logger.error("获取驾驶人信息-基本信息失败！",e);
		}

		return resp;
	}

	// 准假车型
	@ResourceScan(rsc = @Resource(cd = Const.GET_PERMICAR, name = "获取所有准假车型",  hierarchy = 4, isMenue = false, pcd = Const.PERSONAL_INFORMATION)
	, prsc = {@Resource( cd = Const.PERSONAL_INFORMATION, name = "驾驶人信息-基本信息", isMenue = false, hierarchy = 3, pcd = Const.DRIVER_INFORMATION),
			@Resource( cd = Const.DRIVER_INFORMATION, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	@OperLogging(operType = 3,content="获取准假车型")
	@RequestMapping(value="/getAllpermiCar",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<PermiCarsVo>>getAllpermiCar(){
		ResponseMsg<List<PermiCarsVo>> resp = new ResponseMsg<>();

		try {
			List<PermiCarsVo> data = service.getAllpermiCar();
			resp.setData(data);    	
			resp.setMessage("获取数据成功");
			resp.setStatus(1);
		} catch (Exception e) {
			resp.setMessage("获取数据失败");
			resp.setStatus(-1);	
			logger.error("获取数据失败",e);
		}

		return resp;
	}



	/**基本信息-违法记录
	 * idcard
	 * @date  2018年6月15日
	 */
	@OperLogging(operType = 3,content="驾驶员违法记录")
	@ResourceScan(rsc = @Resource(cd = Const.ILLEGAL_RECORD, name = "基本信息-违法记录",  hierarchy = 4, isMenue = false, pcd = Const.PERSONAL_INFORMATION)
	, prsc = {@Resource( cd = Const.PERSONAL_INFORMATION, name = "驾驶人信息-基本信息", isMenue = false, hierarchy = 3, pcd = Const.DRIVER_INFORMATION),
			@Resource( cd = Const.DRIVER_INFORMATION, name = "驾驶人监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	@RequestMapping(value="/getDrillicitByDriverId",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<DriverillicitVo>> seDrillicitByDriverId(@RequestBody DriverVoPage tment,@RequestParam String access_token){
		ResponseMsg<List<DriverillicitVo>> resp = new ResponseMsg<List<DriverillicitVo>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			List<String> list = new ArrayList<String>();
			Page<DriverillicitVo> data = service.seDrillicitByDriverId(page,tment);
			resp.setMessage("获取基本信息-违法记录成功！");
			resp.setStatus(0);
			resp.setData(data.getRecords());
			resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("获取基本信息-违法记录成功！");
			resp.setStatus(0);
			logger.error("获取基本信息-违法记录失败",e);
		}

		return resp;
	}
	/**
	 * 功能说明：  驾驶人违法记录分页
	 * @return
	 * @date  2018年6月15日
	 */
	@OperLogging(operType = 3,content="驾驶员违法信息分页")
	@ResourceScan(rsc = @Resource(cd = Const.DRIVER_PER, name = "驾驶人信息-信息记录-违法", isMenue = false, hierarchy = 3, pcd = Const.DRIVER_INFORMATION), prsc = {
			@Resource(cd = Const.DRIVER_INFORMATION, name = "驾驶人监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@RequestMapping(value="/getIllicitPages",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<DriverillicitVo>> getDriveresPages(@RequestBody(required = false) DriverillicitVoPage tment,@RequestParam String access_token){
		ResponseMsg<List<DriverillicitVo>> resp = new ResponseMsg<List<DriverillicitVo>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			List<String> list = new ArrayList<String>();
			EmployeeVo employee = employeeService.getUserInfo(access_token);
			if(null == employee ){
				resp.fail("获取用户信息失败");
				return resp;
			}

			EmployeePermission employeePermission = employeeService.getEmployeePermission(employee);

			Page<DriverillicitVo> data = service.getDriverPages(page, tment,employeePermission);
			resp.setMessage("获取驾驶人信息-信息记录成功！");
			resp.setStatus(0);
			resp.setData(data.getRecords());  
			resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("获取驾驶人信息-信息记录失败！");
			resp.setStatus(-1);
			logger.error("获取驾驶人信息-信息记录失败！",e);
		}

		return resp;
	}
	/**
	 * @return
	 * @date  2018年6月15日
	 */
	@OperLogging(operType = 0,content="增加驾驶人")
	@ResourceScan(rsc = @Resource(cd = Const.ADD_DRIVER, name = "新增驾驶人",  hierarchy = 4, isMenue = false, pcd = Const.PERSONAL_INFORMATION)
	, prsc = {@Resource( cd = Const.PERSONAL_INFORMATION, name = "驾驶人信息-基本信息", isMenue = false, hierarchy = 3, pcd = Const.DRIVER_INFORMATION),
			@Resource( cd = Const.DRIVER_INFORMATION, name = "驾驶人监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	@RequestMapping(value="/insertDriver",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<String> insertDriver(@RequestBody DriverInsert driver){
		ResponseMsg<String> resp = new ResponseMsg<>();

		try {
			service.insertSelective(driver);
			resp.setMessage("新增驾驶员成功");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("新增驾驶员失败");
			resp.setStatus(-1);
			logger.error("新增驾驶员失败"+driver,e);

		}
		return resp;
	}
	/**
	 * 功能说明：  企业信息-基本信息 分页，详情
	 * @return 
	 * @date  2018年6月20日
	 */
	@OperLogging(operType = 3,content="企业信息-基本信息")
	@ResourceScan(rsc = @Resource(cd = Const.ENTER_ESSENTIAL, name = "企业信息-基本信息", isMenue = false, hierarchy = 3, pcd = Const.ENTER_INFORMATION), prsc = {
			@Resource(cd = Const.ENTER_INFORMATION, name = "企业监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@RequestMapping(value="/queryEnterprisePage",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<EnterprisethenVo>> queryEnterprisePage(@RequestBody(required = false) EnterprisethenVoPage tment,@RequestParam String access_token){
		ResponseMsg<List<EnterprisethenVo>> resp = new ResponseMsg<>();

		try {
			if(StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 不能为空");
				return resp;
			}
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			
			EmployeeVo employee = employeeService.getUserInfo(access_token);
			if(null == employee ){
				resp.fail("获取用户信息失败");
				return resp;
			}
			tment.setEmpType( employee.getEmptype());
			EmployeePermission employeePermission = employeeService.getEmployeePermission(employee);
			Page<EnterprisethenVo> data = service.queryEnterprisePage(page, tment,employeePermission);
			resp.setMessage("查询企业信息-基本信息成功！");
			resp.setStatus(0);
			resp.setData(data.getRecords());  
			resp.setTotal(data.getTotalRows().intValue()); 
		} catch (Exception e) {
			resp.setMessage("查询企业信息-基本信息失败！");
			resp.setStatus(0);
			logger.error("查询企业信息-基本信息失败！",e);
		}

		return resp;
	}

	//测试查询,没用的接口
	@RequestMapping(value="/queryEmpPage",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<EssEmployee>> queryEmpPage(PageRequest page){
		ResponseMsg<List<EssEmployee>> resp = new ResponseMsg<List<EssEmployee>>();

		try {
			Page<EssEmployee> data = service.queryEmpPage(page);
			resp.setData(data.getRecords());
			resp.setTotal(data.getTotalRows().intValue());
			resp.setStatus(0);
			resp.setMessage("员工查询成功");
		} catch (Exception e) {
			resp.setStatus(-1);
			resp.setMessage("员工查询失败");
			logger.error("员工查询失败",e);
		}

		return resp;
	}
	/**
	 * 功能说明：  违法未处理详情
	 * @return 
	 * @date  2018年6月25日
	 */
	@OperLogging(operType = 3)
	@RequestMapping(value="/queryVehiclespage",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<vehiclesVo>>queryVehiclespage(@RequestBody vehiclesVoPage tment,@RequestParam String access_token){
		ResponseMsg<List<vehiclesVo>> resp = new ResponseMsg<List<vehiclesVo>>();

		try {
			if(StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 不能为空");
				return resp;
			}
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			List<String> list = new ArrayList<String>();
			String empType = null;

			String username=JWTUtil.getUsername(access_token);
			// 从redis获取用户信息 
			EmployeeVo vo= (EmployeeVo)  redisService.get(username+Const.TOKEN);
			List<EssEnterprise> ent = null;
			if (null != vo) {
				empType = vo.getEmptype();
				ent = vo.getCanSeeEnt();
			} else {
				EmployeeVo employee = employeeService.findEmployeeByAccount(username);
				empType = employee.getEmptype();
				ent = employee.getCanSeeEnt();
				redisService.set(username+Const.TOKEN,employee,Const.USER_REDIS_LIVE);
			}
			if(ent != null){
				for (EssEnterprise essEnterprise : ent) {
					list.add(essEnterprise.getId());
				} }

			tment.setQid(list);
			tment.setEmpType(empType);

			Page<vehiclesVo> data = service.queryVehiclespage(page, tment);
			resp.setData(data.getRecords());
			resp.setMessage("获取数据成功");
			resp.setStatus(0);
			resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("获取数据失败");
			resp.setStatus(-1);
			logger.error("获取数据失败",e);
		}

		return resp;
	}

	// 企业信息-信息记录
	/*
	 * @param etpNm 企业名字 
	 * @param orgNm 
	 * @param vehiType  
	 */

	@OperLogging(operType = 3)
	@RequestMapping(value="/getvehiclesCount",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<VehiTotal>>getvehiclesCount(@RequestBody VehicleCountVo tment,@RequestParam String access_token){
		ResponseMsg<List<VehiTotal>> resp = new ResponseMsg<>();

		try {
			if(StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 不能为空");
				return resp;
			}
			List<String> list = new ArrayList<String>();
			String empType = null;

			String username=JWTUtil.getUsername(access_token);
			// 从redis获取用户信息 
			EmployeeVo vo= (EmployeeVo)  redisService.get(username+Const.TOKEN);
			List<EssEnterprise> ent = null;
			if (null != vo) {
				empType = vo.getEmptype();
				ent = vo.getCanSeeEnt();
			} else {
				EmployeeVo employee = employeeService.findEmployeeByAccount(username);
				empType = employee.getEmptype();
				ent = employee.getCanSeeEnt();
				redisService.set(username+Const.TOKEN,employee,Const.USER_REDIS_LIVE);
			}
			if(ent != null){
				for (EssEnterprise essEnterprise : ent) {
					list.add(essEnterprise.getId());
				} }

			tment.setList(list);
			tment.setEmpType(empType);
			String type = tment.getVehiType();
			if(type.equals("")){
				List<VehiTotal > veList = new ArrayList<>();
				List<VehicleCountVo> data = service.getVehiclesCount(tment);
				List<VehicleCountVo> datas = service.getVehiclesVehi(tment);
				out:
					for (VehicleCountVo vehicleCountVo : data) {
						VehiTotal VehiTotal = new VehiTotal();
						for (VehicleCountVo vehikos : datas) {
							if(vehicleCountVo.getEtpNm().equals(vehikos.getEtpNm())){
								VehicleCountVo vecount = new VehicleCountVo();
								VehiTotal.setId(vehicleCountVo.getId());
								VehiTotal.setEtpNm(vehicleCountVo.getEtpNm());
								VehiTotal.setMaxVehi(vehicleCountVo);
								VehiTotal.setMinVehi(vehikos);
								vecount.setEtpNm("小计");
								vecount.setvCount( vehicleCountVo.getvCount()+ vehikos.getvCount());
								vecount.setzCount(vehicleCountVo.getzCount()+vehikos.getzCount() );
								vecount.setScraCount(vehicleCountVo.getScraCount()+vehikos.getScraCount() );								
								vecount.setOverCount(vehicleCountVo.getOverCount()+ vehikos.getOverCount());				
								vecount.setIllicitCount( vehicleCountVo.getIllicitCount()+vehikos.getIllicitCount());
								VehiTotal.setTotal(vecount);
								veList.add(VehiTotal);
								continue out;
							}
						}
					}
				resp.setTotal( veList.size());
				resp.setData(veList);    	
			}else if (type.equals("01")) {
				List<VehiTotal > veList = new ArrayList<>();
				List<VehicleCountVo> data = service.getVehiclesCount(tment);
				for (VehicleCountVo vehicleCountVo : data) {
					VehiTotal total = new VehiTotal();
					total.setMaxVehi(vehicleCountVo);
					total.setId(vehicleCountVo.getId()  );
					total.setEtpNm(vehicleCountVo.getEtpNm());
					veList.add(total);
				}
				resp.setData(veList);    	
				resp.setTotal( veList.size());
			}else if(type.equals("02") ) {
				List<VehiTotal > veList = new ArrayList<>();
				List<VehicleCountVo> data = service.getVehiclesVehi(tment);	
				for (VehicleCountVo vehicleCountVo : data) {
					VehiTotal total = new VehiTotal();
					total.setMinVehi(vehicleCountVo);
					total.setId(vehicleCountVo.getId()  );
					total.setEtpNm(vehicleCountVo.getEtpNm());
					veList.add(total);
				}
				resp.setData(veList); 
				resp.setTotal( veList.size());
			} 
			resp.setMessage("获取数据成功");
			resp.setStatus(1);

		} catch (Exception e) {
			resp.setMessage("获取数据失败");
			resp.setStatus(-1);	
			logger.error("获取数据失败",e);
		}

		return resp;
	}

}
