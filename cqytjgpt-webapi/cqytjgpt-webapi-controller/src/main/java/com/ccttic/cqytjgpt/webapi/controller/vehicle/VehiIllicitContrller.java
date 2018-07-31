package com.ccttic.cqytjgpt.webapi.controller.vehicle;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehiIllicitService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.vo.PageVehiIllicitVo;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

/**
 * 功能说明： 车辆违法信息Contrller
 * @author admin
 *
 */
@RestController
@RequestMapping("/vehiIllicit")
//@SessionAttributes(Const.ENT)
public class VehiIllicitContrller implements Serializable{
	private static final long serialVersionUID = 4967775901502780928L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehiIllicitService vehiIllicitService;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private RedisService<EmployeeVo> redisService;
	/**
	 * 根据条件获取车辆违法信息
	 * @return
	 */
	@RequestMapping(value = "/qryVehiIllicitList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_ILLICIT_INFO, name = "车辆信息-违法记录", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE), prsc = {
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<VehiIllicit>> qryVehiIllicitList (@RequestBody PageVehiIllicitVo vehiIllicit,@RequestParam String access_token) {
		ResponseMsg<List<VehiIllicit>> resp = new ResponseMsg<List<VehiIllicit>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(vehiIllicit.getPage());
			page.setRows(vehiIllicit.getRows());
			 if(StringUtils.isEmpty(access_token)) {
				 resp.fail("access_token 不能为空");
				 return resp;
			 }
			 String username=JWTUtil.getUsername(access_token);
			// 从redis获取用户信息 
			EmployeeVo vo = (EmployeeVo)  redisService.get(username+Const.TOKEN);
			EssEnterprise ent = null;
			if (null != vo) {
				ent = vo.getEnt();
			} else {
				EmployeeVo employee;
				try {
					employee = employeeService.findEmployeeByAccount(username);
					ent = employee.getEnt();
					redisService.set(username+Const.TOKEN,employee,Const.USER_REDIS_LIVE);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			String userType = null;
			String id = null;
			if (null != ent) { // 根据登录账号类型判断
				if (Const.SUPERMAN.equals(vo.getEmptype())) {
					userType = Const.SUPERMAN;
				} else if (Const.SUPER.equals(vo.getEmptype())) {
					userType = Const.SUPER;
					id = ent.getId();
				} else if (Const.ADMIN.equals(vo.getEmptype())) {
					userType = Const.ADMIN;
					id = ent.getOrgId();
				}
			}
			Page<VehiIllicit> pager = vehiIllicitService.qryVehiIllicitList(page,vehiIllicit,userType,id);
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
	 * 根据条件获取指定车辆违法信息 （详情）
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehiIllicit", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ILLICIT_PARTICULARS, name = "违法详情",  hierarchy = 4, isMenue = false, pcd = Const.CAR_ILLICIT_INFO)
    , prsc = {@Resource( cd = Const.CAR_ILLICIT_INFO, url="/vehiIllicit/qryVehiIllicitList", name = "车辆信息-违法记录", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
    		@Resource( cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
    		@Resource( cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public ResponseMsg<VehiIllicit> qryOneVehiIllicit (@RequestBody VehiIllicit ve) {
		ResponseMsg<VehiIllicit> resp = new ResponseMsg<VehiIllicit>();
		Map<String, Object> params = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = 0;
		if (null != ve.getIllicitTime()) {
			year = Integer.valueOf(ve.getIllicitTime().substring(0, 4));
		} else {
			year = calendar.get(Calendar.YEAR);
		}
		if ("0".equals(ve.getDisposeSign())) {
			params.put("tableNmae", "net_trff_surveil_"+year);
		} else {
			params.put("tableNmae", "net_trff_violation_"+year);
		}
		params.put("id", ve.getId());
		params.put("disposeSign", ve.getDisposeSign());
		params.put("vehiNo", ve.getVehiNo());
		try {
			VehiIllicit vehiIllicit = vehiIllicitService.qryOneVehiIllicit(params);
			resp.setData(vehiIllicit);
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}
	
}
