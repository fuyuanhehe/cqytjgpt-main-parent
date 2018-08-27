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
import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehiIllicitService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.vo.PageVehiIllicitVo;
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
 * 功能说明： 车辆违法信息Contrller
 * @author admin
 *
 */
@RestController
@RequestMapping("/vehiIllicit")
@Api(tags="车辆违法信息Contrller")
public class VehiIllicitContrller implements Serializable{
	private static final long serialVersionUID = 4967775901502780928L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehiIllicitService vehiIllicitService;
	@Autowired
	private IEmployeeService employeeService;
	/**
	 * 根据条件获取车辆违法信息
	 * @return
	 */
	@RequestMapping(value = "/qryVehiIllicitList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_ILLICIT_INFO, name = "车辆信息-违法记录", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE), prsc = {
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@ApiOperation(value="车辆信息-违法记录",notes="access_token，必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
	    @ApiImplicitParam(name="rows",value="条数",required=false,paramType="form"),
	    @ApiImplicitParam(name="page",value="页码",required=false,paramType="form"),
	    @ApiImplicitParam(name="mgrDepartAreaId",value="区域编码",required=false,paramType="form"),
		@ApiImplicitParam(name="vehiNo",value="车牌号",required=false,paramType="form"),
		@ApiImplicitParam(name="etpNm",value="企业",required=false,paramType="form"),
		@ApiImplicitParam(name="illicit",value="违法行为",required=false,paramType="form"),
		@ApiImplicitParam(name="state",value="处罚状态",required=false,paramType="form"),
		@ApiImplicitParam(name="vehiNoType",value="号牌种类",required=false,paramType="form"),
		@ApiImplicitParam(name="pickDepartmentDesc",value="采集机关名称",required=false,paramType="form"),
		@ApiImplicitParam(name="startTime",value="违法开始时间",required=false,paramType="form"),
		@ApiImplicitParam(name="endTime",value="违法结束时间",required=false,paramType="form")
	})
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
	@ApiOperation(value="车辆信息-违法详情",notes="access_token，id，必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
	    @ApiImplicitParam(name="id",value="id",required=true,paramType="form"),
	    @ApiImplicitParam(name="illicitTime",value="违法时间",required=true,paramType="form")
		})
	public ResponseMsg<VehiIllicit> qryOneVehiIllicit (@RequestBody VehiIllicit ve,@RequestParam String access_token) {
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
			if (vehiIllicit.getIllicitScore().length()>0) {
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
