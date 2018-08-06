package com.ccttic.cqytjgpt.webapi.controller.vehicle;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccttic.entity.employee.EmployeePermission;
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
import com.ccttic.cqytjgpt.webapi.interfaces.organization.IOrganizationService;
import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehiIllicitService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.AccoutVo;
import com.ccttic.entity.role.Organization;
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
	@Autowired
	private IOrganizationService organizationService;
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
			 EmployeeVo employee = employeeService.getUserInfo(access_token);

			 if (null==employee){
				 resp.fail("获取用户信息失败");
				 return resp;
			 }
			EmployeePermission employeePermission = employeeService.getEmployeePermission(employee);
			if(null == employeePermission)   {
				resp.fail("该账号无查询数据权限");
				return resp;
			}
			
			Page<VehiIllicit> pager = vehiIllicitService.qryVehiIllicitList(page,vehiIllicit,employeePermission);
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
		params.put("tableName", "illicit_"+year);
		params.put("id", ve.getId());
		try {
			VehiIllicit vehiIllicit = vehiIllicitService.qryOneVehiIllicit(params);
			if (null != vehiIllicit.getIllicitScore()) {
				vehiIllicit.setDisposeSign("已处理");
				vehiIllicit.setState("已处理");
			}
			resp.setData(vehiIllicit);
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}
	
}
