package com.ccttic.cqytjgpt.webapi.controller.enterprise;

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
public class EnterpriseController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IEnterpriseService enterpriseService;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private RedisService<EmployeeVo> redisService;


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
	@ResourceScan(rsc = @Resource(cd = Const.MODIFY_ENTERPRISE, name = "修改企业信息", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
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
	 * @param page
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
	/**
	 * @param areaNm
	 * @param etpNm
	 * @param  id
	 * @return
	 */
	@OperLogging(operType = 0)
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
			for (EssEnterprise essEnterprise : ent) {
				list.add(essEnterprise.getId());
			}

			//	list.add(vo.getEnt().getId());

			tment.setList(list);
			tment.setEmpType(empType);

			Page<EnterpriseVehiVo> data = enterpriseService.getEnterpriseVe(page, tment);
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
	 * @param areaNm
	 * @param etpNm
	 * @param  id
	 * @return
	 */
	@OperLogging(operType = 0)
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
			for (EssEnterprise essEnterprise : ent) {
				list.add(essEnterprise.getId());
			}

			//	list.add(vo.getEnt().getId());

			tment.setList(list);
			tment.setEmpType(empType);

			Page<EnterpriseDriverVo> data = enterpriseService.getEnterpriceDriver(page, tment);
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
	@OperLogging(operType = 0)
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
				tment.setEmpId(str.getId());
			} else {
				EmployeeVo employee = employeeService.findEmployeeByAccount(username);
				redisService.set(username+Const.TOKEN,employee,Const.USER_REDIS_LIVE);
				EssEnterprise str = employee.getEnt() ;
				tment.setEmpId(str.getId());
			}
			
			enterpriseService.updateVehicleByid(tment);
			resp.setMessage("设置车辆成功!");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("设置车辆成功失败");
			resp.setStatus(-1);
			logger.error("设置车辆成功失败",e);
		}

		return resp;
	}



}
