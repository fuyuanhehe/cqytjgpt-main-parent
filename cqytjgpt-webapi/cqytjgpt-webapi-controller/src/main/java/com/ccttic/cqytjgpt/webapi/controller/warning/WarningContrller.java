package com.ccttic.cqytjgpt.webapi.controller.warning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.cqytjgpt.webapi.interfaces.warning.IWarningservice;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.DrDangerVo;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

/**
 * 预警提示
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/warning")
// @SessionAttributes(Const.ENT)
public class WarningContrller implements Serializable {
	private static final long serialVersionUID = 2213999569272828267L;

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private RedisService<EmployeeVo> redisService;

	@Autowired
	private IWarningservice warningservice;


	/**
	 * 根据条件获取车辆预警信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseMsg<List<VehiDangerVo>> getVehicleWarningList(@RequestBody VehiDangerVo vdvo,
			@RequestParam String access_token) {
		ResponseMsg<List<VehiDangerVo>> resp = new ResponseMsg<List<VehiDangerVo>>();
		PageRequest page = new PageRequest();
		page.setPage(vdvo.getPage());
		page.setRows(vdvo.getRows());
		List<String> list = new ArrayList<String>();
		List<EssEnterprise> ent = null;
		String empType = null;
		String username =JWTUtil.getUsername(access_token);
		// redis get data
		EmployeeVo vo = (EmployeeVo)redisService.get(username+Const.TOKEN); 
		// 2. 判断REDIS是否为空
		if (null != vo) {
			ent = vo.getEnt();
			empType = vo.getEmptype();
		} else {
			EmployeeVo employee;
			try {
				employee = employeeService.findEmployeeByAccount(username);
				ent=employee.getEnt();
				empType = employee.getEmptype();
				//3. 更新redis里用户缓存
				redisService.set(username+Const.TOKEN,employee, Const.USER_REDIS_LIVE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		for (EssEnterprise essEnterprise : ent) {
			list.add(essEnterprise.getId());
		}
		vdvo.setList(list);
		vdvo.setEmpType(empType);
		try {
			Page<VehiDangerVo> pager = warningservice.qryVehicleList(page, vdvo);
			resp.setData(pager.getRecords());
			resp.setTotal(pager.getTotalRows().intValue());
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
		}
		return resp;
	}

	@RequestMapping(value = "/qryDriverList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseMsg<Page<DrDangerVo>> getDriverWarningList(@RequestBody DrDangerVo drvo,
			@RequestParam String access_token) {
		ResponseMsg<Page<DrDangerVo>> resp = new ResponseMsg<Page<DrDangerVo>>();
		PageRequest page = new PageRequest();
		page.setPage(drvo.getPage());
		page.setRows(drvo.getRows());

		List<String> list = new ArrayList<String>();
		List<EssEnterprise> ent = null;
		String empType = null;
		String username =JWTUtil.getUsername(access_token);
		// redis get data
		EmployeeVo vo = (EmployeeVo)redisService.get(username); 
		// 2. 判断REDIS是否为空
		if (null != vo) {
			ent = vo.getEnt();
			empType = vo.getEmptype();
		} else {
			EmployeeVo employee;
			try {
				employee = employeeService.findEmployeeByAccount(username);
				ent=employee.getEnt();
				empType = employee.getEmptype();
				//3. 更新redis里用户缓存
				redisService.set(username,employee, Const.USER_REDIS_LIVE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		for (EssEnterprise essEnterprise : ent) {
			list.add(essEnterprise.getId());
		}
		drvo.setList(list);
		drvo.setEmpType(empType);
		try {
			Page<DrDangerVo> pager = warningservice.qryDriverList(page, drvo);
			resp.setData(pager);
			resp.setTotal(pager.getTotalRows().intValue());
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
		}
		return resp;
	}

	/**
	 * 根据条件获取车辆预警信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getByIdVehicleWarning", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseMsg<VehiDangerVo> getByIdVehicleWarning(@RequestBody VehiDangerVo vo) {
		ResponseMsg<VehiDangerVo> resp = new ResponseMsg<VehiDangerVo>();

		try {
			VehiDangerVo vehi = warningservice.qryOneVehicle(vo);
			resp.setData(vehi);
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
		}
		return resp;
	}

	@RequestMapping(value = "/getByIdDriverWarning", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseMsg<DrDanger> getByIdDriverWarning(@RequestBody DrDanger dr) {
		ResponseMsg<DrDanger> resp = new ResponseMsg<DrDanger>();

		try {
			DrDanger driver = warningservice.qryOneDriver(dr);
			resp.setData(driver);
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
		}
		return resp;
	}

	@RequestMapping(value = "/getEnterprise", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseMsg<List<EssEnterprise>> getEnterprise(@RequestParam String access_token) {
		ResponseMsg<List<EssEnterprise>> resp = new ResponseMsg<List<EssEnterprise>>();

		List<EssEnterprise> ent = null;
		String username = JWTUtil.getUsername(access_token);
		// redis get data
		EmployeeVo emp = (EmployeeVo) redisService.get(username+Const.TOKEN);

		try {
			// 2. 判断REDIS是否为空
			if (null != emp) {
				ent = emp.getEnt();
				resp.setData(ent);
				resp.success("获取企业列表成功");
			} else {

				EmployeeVo employee = employeeService.findEmployeeByAccount(username);
				ent = employee.getEnt();
				// 3. 更新redis里用户缓存
				redisService.set(username+Const.TOKEN, employee, Const.USER_REDIS_LIVE);
				resp.setData(ent);
				resp.success("获取企业列表成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.fail("获取企业列表失败"+e);
		}

		return resp;
	}
}
