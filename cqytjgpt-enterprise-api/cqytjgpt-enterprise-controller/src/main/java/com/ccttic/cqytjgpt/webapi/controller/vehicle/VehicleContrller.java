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
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.VehicleDispatch;
import com.ccttic.entity.role.vo.PageVehiIllicitVo;
import com.ccttic.entity.role.vo.PageVehicleVo;
import com.ccttic.entity.role.vo.VehicleDispatchVo;
import com.ccttic.entity.role.vo.VehicleVO;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 功能说明： 车辆信息管理Contrller
 * 
 * @author admin
 *
 */
@RestController
@RequestMapping("/vehicle")
@Api(tags="车辆信息管理Contrller")
public class VehicleContrller implements Serializable {

	private static final long serialVersionUID = -2422516254972777732L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehicleService vehicleService;
	@Autowired
	private IEmployeeService employeeService;

	/**
	 * 根据条件获取车辆基本信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value="车辆信息-基本信息",notes="access_token，必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
	    @ApiImplicitParam(name="rows",value="条数",required=false,paramType="form"),
	    @ApiImplicitParam(name="page",value="页码",required=false,paramType="form"),
	    @ApiImplicitParam(name="mgrDepartAreaId",value="区域编码",required=false,paramType="form"),
		@ApiImplicitParam(name="vehiNo",value="车牌号",required=false,paramType="form"),
		@ApiImplicitParam(name="vehiNoType",value="号牌种类",required=false,paramType="form"),
		@ApiImplicitParam(name="vehiType",value="车俩类型",required=false,paramType="form"),
		@ApiImplicitParam(name="state",value="状态",required=false,paramType="form"),
		@ApiImplicitParam(name="effectStartTime",value="有效开始时间",required=false,paramType="form"),
		@ApiImplicitParam(name="effectEndTime",value="有效结束时间",required=false,paramType="form"),
		@ApiImplicitParam(name="startTime",value="初次检验开始日期",required=false,paramType="form"),
		@ApiImplicitParam(name="endTime",value="初次检验结束日期",required=false,paramType="form")
	})
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
			// 从redis获取用户信息 
			EmployeeVo vo = employeeService.getUserInfo(access_token);
			if (null ==vo){
				resp.fail("用户信息丢失");
				return resp;
			}
			EmployeePermission employeePermission = employeeService.getEmployeePermission(vo);
			 if(null == employeePermission) {
				resp.fail("该账号无查询数据权限");
				return resp;
			}
			Page<Vehicle> pager = vehicleService.qryVehicleList(page, vehicle,employeePermission);
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
	 * 根据id获取指定车辆信息 （详情）
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehicle", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value="车辆详情",notes="access_token，id，必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
	    @ApiImplicitParam(name="id",value="id",required=true,paramType="form")
	})
	public ResponseMsg<VehicleVO> qryOneVehicle(@RequestBody Vehicle ve,@RequestParam String access_token) {
		ResponseMsg<VehicleVO> resp = new ResponseMsg<VehicleVO>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", ve.getId());
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
	@RequestMapping(value = "/qryVehiIllicitList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ILLICIT_INFO, name = "违法信息", hierarchy = 4, isMenue = false, pcd = Const.CAR_BASE_INFO), prsc = {
			@Resource(cd = Const.CAR_BASE_INFO, url = "/vehicle/qryVehicleList", name = "车辆信息-基本信息", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE),
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@ApiOperation(value="违法信息",notes="access_token，车牌号,号牌种类,违法时间,必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
		@ApiImplicitParam(name="rows",value="条数",required=false,paramType="form"),
	    @ApiImplicitParam(name="page",value="页码",required=false,paramType="form"),
	    @ApiImplicitParam(name="vehiNo",value="车牌号",required=true,paramType="form"),
	    @ApiImplicitParam(name="vehiNoType",value="号牌种类",required=true,paramType="form"),
		@ApiImplicitParam(name="illicitTime",value="违法时间",required=false,paramType="form")
	})
	public ResponseMsg<List<VehiIllicit>> qryVehiIllicitList(@RequestBody PageVehiIllicitVo vehiIllicit) {
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
	 * 根据id获取指定车辆违法信息 （详情）
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/qryOneVehiIllicit", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value="车辆违法详情",notes="access_token，id，必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
	    @ApiImplicitParam(name="id",value="id",required=true,paramType="form"),
		@ApiImplicitParam(name="illicitTime",value="违法时间",required=true,paramType="form")
	})
	public ResponseMsg<VehiIllicit> qryOneVehiIllicit(@RequestBody PageVehiIllicitVo vehiIllicit,@RequestParam String access_token) {
		ResponseMsg<VehiIllicit> resp = new ResponseMsg<VehiIllicit>();
		Map<String, Object> params = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = 0;
		if (null != vehiIllicit.getIllicitTime()) {
			year = Integer.valueOf(vehiIllicit.getIllicitTime().substring(0, 4));
		} else {
			year = calendar.get(Calendar.YEAR);
		}
		params.put("tableName", "illicit_"+year);
		params.put("id", vehiIllicit.getId());
		try {
			VehiIllicit illicit = vehicleService.qryOneVehiIllicit(params);
			resp.setData(illicit);
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}
	
	/**
	 * 根据条件获取车辆出车信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleDispatchList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value="车辆出车信息",notes="access_token，必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
	    @ApiImplicitParam(name="rows",value="条数",required=false,paramType="form"),
	    @ApiImplicitParam(name="page",value="页码",required=false,paramType="form"),
	    @ApiImplicitParam(name="driver",value="驾驶人员",required=false,paramType="form"),
		@ApiImplicitParam(name="vehiNo",value="车牌号",required=false,paramType="form"),
		@ApiImplicitParam(name="dispatchTime",value="出车时间",required=false,paramType="form"),
		@ApiImplicitParam(name="goodsType",value="配载货物类型",required=false,paramType="form"),
		@ApiImplicitParam(name="onSite",value="上车地点",required=false,paramType="form"),
		@ApiImplicitParam(name="debusSite",value="下车地点",required=false,paramType="form"),
		@ApiImplicitParam(name="state",value="运行状态",required=false,paramType="form"),
		
	})
	public ResponseMsg<List<VehicleDispatch>> qryVehicleDispatchList(@RequestBody VehicleDispatchVo vehicle,
			@RequestParam String access_token) {
		ResponseMsg<List<VehicleDispatch>> resp = new ResponseMsg<List<VehicleDispatch>>();
		try {
			if (StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 为空");
				return resp;
			}
			PageRequest page = new PageRequest();
			page.setPage(vehicle.getPage());
			page.setRows(vehicle.getRows());
			// 从redis获取用户信息 
			EmployeeVo vo = employeeService.getUserInfo(access_token);
			if (null ==vo){
				resp.fail("用户信息丢失");
				return resp;
			}
			EmployeePermission employeePermission = employeeService.getEmployeePermission(vo);
			 if(null == employeePermission) {
				resp.fail("该账号无查询数据权限");
				return resp;
			}
			Page<VehicleDispatch> pager = vehicleService.qryVehicleDispatchList(page,vehicle,employeePermission);
			resp.setData(pager.getRecords());
			resp.setTotal(pager.getTotalRows().intValue());
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
			logger.error("查询失败！", e);
		}
		return resp;
	}
}
