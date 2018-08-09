package com.ccttic.cqytjgpt.webapi.controller.enterprise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseDriverVo;
import com.ccttic.entity.enterprise.vo.EnterpriseVehiVo;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;
import com.ccttic.entity.enterprise.vo.PageEssEnterpriseVo;
import com.ccttic.entity.role.vo.EmpVo;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7624503176461180718L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IEnterpriseService enterpriseService;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private RedisService<EmployeeVo> redisService;

	@RequestMapping(value = "/getEssEnterpriseList", method = { RequestMethod.GET, RequestMethod.POST })
	public  ResponseMsg<List<EssEnterprise>> getEssEnterpriseList(@RequestBody PageEssEnterpriseVo vo){
		ResponseMsg<List<EssEnterprise>> responseMsg = new ResponseMsg<>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(vo.getPage());
			page.setRows(vo.getRows());
			Page<EssEnterprise> result = enterpriseService.selectEnterpriseList(page,vo);
			responseMsg.setData(result.getRecords());
			responseMsg.setTotal(result.getTotalRows().intValue());
			responseMsg.success("获得企业列表");
		} catch (Exception e) {
			responseMsg.fail("获得企业列表");
			logger.info(e);
		}

		return responseMsg;
	}

	@RequestMapping(value = "/selectEnterprise", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.SELECT_ENTERPRISE, name = "查询企业信息", hierarchy = 3, isMenue = true, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/enterprise/selectEnterprise", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
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
	@ResourceScan(rsc = @Resource(cd = Const.MODIFY_ENTERPRISE, name = "修改企业", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/enterprise/modifyEnterprise", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
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
	@ResourceScan(rsc = @Resource(cd = Const.DELETE_ENTERPRISE, name = "删除企业", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/enterprise/delEnterprise", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
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

	/**
	 * 注册企业(资料填写)
	 * @param request
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/registerEnterpries", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.REGISTER_ENTERPRISE,url = "/enterprise/registerEnterpries", name = "注册企业", hierarchy = 2, isMenue = true, pcd = Const.LOGIN_REGISTER_ENTERPRISE), prsc = {
			@Resource(cd = Const.LOGIN_REGISTER_ENTERPRISE, name = "登录注册审核", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
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
	 * 根据条件获取企业信息(区分所审核)
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/qryEnterpriesList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CHECK_ENTERPRISE,url = "/enterprise/qryEnterpriesList", name = "区分所审核", hierarchy = 2, isMenue = true, pcd = Const.LOGIN_REGISTER_ENTERPRISE), prsc = {
			@Resource(cd = Const.LOGIN_REGISTER_ENTERPRISE, name = "登录注册审核", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<EssEnterprise>> qryEnterpriesList(@RequestBody PageEssEnterpriseVo vo) {
		ResponseMsg<List<EssEnterprise>> resp = new ResponseMsg<List<EssEnterprise>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(vo.getPage());
			page.setRows(vo.getRows());
			Page<EssEnterprise> pager = enterpriseService.qryEssEnterpriseList(page, vo);
			resp.setData(pager.getRecords());
			resp.setTotal(pager.getTotalRows().intValue());
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
			logger.error("查询失败！", e);
		}
		return resp;
	}
	/**企业下属车辆
	 * @return
	 */
	@OperLogging(operType = 3,content="企业下属车辆")
	@ResourceScan(rsc = @Resource(cd = Const.ENTER_VEHICLE, name = "企业下属车辆", isMenue = false, hierarchy = 3, pcd = Const.ENTER_INFORMATION), prsc = {
			@Resource(cd = Const.DRIVER_INFORMATION, name = "企业监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@RequestMapping(value="/getEnterpriseVe",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<EnterpriseVehiVo>>getEnterpriseVe(@RequestBody EnterpriseVehiVo tment,@RequestParam String access_token){
		ResponseMsg<List<EnterpriseVehiVo>> resp = new ResponseMsg<List<EnterpriseVehiVo>>();

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
			Page<EnterpriseVehiVo> data = enterpriseService.getEnterpriseVe(page, tment,employeePermission);
			resp.setData(data.getRecords());
			resp.setMessage("获取企业下属车辆成功");
			resp.setStatus(0);
			resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("获取企业下属车辆失败");
			resp.setStatus(-1);
			logger.error("获取企业下属车辆失败",e);
		}

		return resp;
	}

	/** 企业下属驾驶员
	 * @return
	 */
	@ResourceScan(rsc = @Resource(cd = Const.ENTER_DRIVER, name = "企业下属驾驶人", isMenue = false, hierarchy = 3, pcd = Const.ENTER_INFORMATION), prsc = {
			@Resource(cd = Const.DRIVER_INFORMATION, name = "企业监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@OperLogging(operType = 3,content="企业下属驾驶员")
	@RequestMapping(value="/getEnterpriceDriver",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<EnterpriseDriverVo>>getEnterpriceDriver(@RequestBody EnterpriseDriverVo tment,@RequestParam String access_token){
		ResponseMsg<List<EnterpriseDriverVo>> resp = new ResponseMsg<List<EnterpriseDriverVo>>();

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
			
			Page<EnterpriseDriverVo> data = enterpriseService.getEnterpriceDriver(page, tment,employeePermission);
			resp.setData(data.getRecords());
			resp.setMessage("获取企业下属驾驶员成功");
			resp.setStatus(0);
			resp.setTotal(data.getTotalRows().intValue()); 
		} catch (Exception e) {
			resp.setMessage("获取企业下属驾驶员失败");
			resp.setStatus(-1);
			logger.error("获取企业下属驾驶员失败",e);
		}

		return resp;
	}

	/*
	 * 企业选择车辆
	 * id
	 * empId
	 * 
	 */
	@OperLogging(operType = 1)
	@ResourceScan(rsc = @Resource(cd = Const.ENTER_CHOICE_VEHICLE, name = "企业选择车辆",  hierarchy = 4, isMenue = false, pcd = Const.ENTER_VEHICLE)
	, prsc = {@Resource( cd = Const.ENTER_VEHICLE, name = "企业下属车辆", isMenue = false, hierarchy = 3, pcd = Const.ENTER_INFORMATION),
			@Resource( cd = Const.ENTER_INFORMATION, name = "企业监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	@RequestMapping(value="/setVehicle",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<String>updateVehicleByid(@RequestBody EmpVo tment,@RequestParam String access_token){
		ResponseMsg<String> resp = new ResponseMsg<String>();

		try {
			if(StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 不能为空");
				return resp;
			}

			String username=JWTUtil.getUsername(access_token);
			// 从redis获取用户信息 
			EmployeeVo vo= (EmployeeVo)  redisService.get(username+Const.TOKEN);
			if (null != vo) {
				EssEnterprise str = vo.getEnt() ;
				if(str!=null){
					String ids = str.getId();
					if(  ids != null   ){
						tment.setEmpId(ids);  
					}else {
						resp.fail("您的账号没有关联企业，设置失败");
						return resp;
					} 
				}

			} else {
				EmployeeVo employee = employeeService.findEmployeeByAccount(username);
				redisService.set(username+Const.TOKEN,employee,Const.USER_REDIS_LIVE);
				EssEnterprise str = employee.getEnt() ;
				if(str!=null){
					String ids = str.getId();
					if(  ids != null   ){
						tment.setEmpId(ids);  
					}else {
						resp.fail("您的账号没有关联企业，设置失败");
						return resp;
					}  
				}
			}
			enterpriseService.updateVehicleByid(tment);
			resp.setMessage("设置车辆成功!");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("设置车辆失败");
			resp.setStatus(-1);
			logger.error("设置车辆失败",e);
		}

		return resp;
	}

	/*
	 * 企业选驾驶人
	 * id
	 * empId
	 * 
	 */
	@OperLogging(operType = 1)
	@ResourceScan(rsc = @Resource(cd = Const.ENTER_CHOICE_DRIVER, name = "企业选择驾驶人",  hierarchy = 4, isMenue = false, pcd = Const.ENTER_VEHICLE)
	, prsc = {@Resource( cd = Const.ENTER_VEHICLE, name = "企业下属车辆", isMenue = false, hierarchy = 3, pcd = Const.ENTER_INFORMATION),
			@Resource( cd = Const.ENTER_INFORMATION, name = "企业监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	@RequestMapping(value="/setDriver",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<String>setVehicle(@RequestBody EmpVo tment,@RequestParam String access_token){
		ResponseMsg<String> resp = new ResponseMsg<String>();

		try {
			if(StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 不能为空");
				return resp;
			}

			String username=JWTUtil.getUsername(access_token);
			// 从redis获取用户信息 
			EmployeeVo vo= (EmployeeVo)  redisService.get(username+Const.TOKEN);
			if (null != vo) {
				EssEnterprise str = vo.getEnt() ;
				if(str!=null){
					String ids = str.getId();
					if(  ids != null   ){
						tment.setEmpId(ids);  
					}else {
						resp.fail("您的账号没有关联企业，设置失败");
						return resp;
					} 
				}

			} else {
				EmployeeVo employee = employeeService.findEmployeeByAccount(username);
				redisService.set(username+Const.TOKEN,employee,Const.USER_REDIS_LIVE);
				EssEnterprise str = employee.getEnt() ;
				if(str!=null){
					String ids = str.getId();
					if(  ids != null   ){
						tment.setEmpId(ids);  
					}else {
						resp.fail("您的账号没有关联企业，设置失败");
						return resp;
					}


				}
			}
			enterpriseService.updateDriverById(tment);
			resp.setMessage("设置驾驶人成功!");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("设置驾驶人失败");
			resp.setStatus(-1);
			logger.error("设置驾驶人失败",e);
		}

		return resp;
	}


	// id
	@OperLogging(operType = 1)
	@RequestMapping(value="/removeVehicle",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<String>removeVehicle(@RequestBody EmpVo tmen){
		ResponseMsg<String> resp = new ResponseMsg<String>();

		try{
			enterpriseService.relieveVehicleEnter(tmen);
			resp.setMessage("移除车辆成功!");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("移除车辆失败");
			resp.setStatus(-1);
			logger.error("移除车辆失败",e);
		}

		return resp;
	}


	// id
	@OperLogging(operType = 1)
	@RequestMapping(value="/removeDriver",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<String>removeDriver(@RequestBody EmpVo tmen){
		ResponseMsg<String> resp = new ResponseMsg<String>();

		try{
			enterpriseService.relieveDricerEnter(tmen);
			resp.setMessage("移除驾驶人成功!");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("移除驾驶人失败");
			resp.setStatus(-1);
			logger.error("移除驾驶人失败",e);
		}

		return resp;
	}

	//获取管理部门
	@RequestMapping(value = "/getDepar", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<List<String>> getDepar() {
		ResponseMsg<List<String>> rm = new ResponseMsg<List<String>>();
		try {
			rm.setData( enterpriseService.getDepar() );
			rm.setMessage("获取所有管理部门成功");
			rm.setStatus(0);
		} catch (Exception e) {
			rm.setMessage("获取所有管理部门成功");
			rm.setStatus(-1);
			logger.info(e);
		}
		return rm;
	}

}
