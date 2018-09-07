package com.ccttic.cqytjgpt.enterpriseapi.controller.essEnterprise;

import java.io.Serializable;
import java.util.List;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.enterprise.IEnterpriseService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/essEnt")
@Api(tags = "企业Contrller")
public class EssEnterpriseController implements Serializable{

	private static final long serialVersionUID = 3922772436159593164L;
	
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehicleService vehicleService;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IEnterpriseService enterpriseService;
	
	
	/**
	 * 根据登录账号获取企业
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getEssEnterprise", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "根据登录账号获取企业", notes = "access_token，必传值")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access_token", value = "access_token", required = true, paramType = "query") })
	public ResponseMsg<List<EssEnterprise>> getEssEnterprise(@RequestParam String access_token) {
		ResponseMsg<List<EssEnterprise>> resp = new ResponseMsg<List<EssEnterprise>>();
		try {
			if (StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 为空");
				return resp;
			}
			// 从redis获取用户信息
			EmployeeVo vo = employeeService.getUserInfo(access_token);
			if (null == vo) {
				resp.fail("用户信息丢失");
				return resp;
			}
			EmployeePermission employeePermission = employeeService.getEmployeePermission(vo);
			if (null == employeePermission || null != employeePermission.getEnterpriseId()) {
				resp.fail("该账号无查询数据权限");
				return resp;
			}
			List<EssEnterprise> essEnt = vehicleService.getEssEnterprise(employeePermission.getEnterpriseId());
			resp.setData(essEnt);
			resp.success("查询成功！");
		} catch (Exception e) {
			resp.fail("查询失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 获取企业及子企业id和name
	 *
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getSubordinateEnterprise", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "获取企业及子企业id和name", notes = "access_token，必传值")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access_token", value = "access_token", required = true, paramType = "query") })
	public ResponseMsg<List<EssEnterprise>> getSubordinateEnterprise(@RequestParam String access_token) {
		ResponseMsg<List<EssEnterprise>> resp = new ResponseMsg<List<EssEnterprise>>();
		try {
			if (StringUtils.isEmpty(access_token)) {
				resp.fail("access_token 为空");
				return resp;
			}
			// 从redis获取用户信息
			EmployeeVo vo = employeeService.getUserInfo(access_token);
			if (null == vo) {
				resp.fail("用户信息丢失");
				return resp;
			}
			EmployeePermission employeePermission = employeeService.getEmployeePermission(vo);
			if (null == employeePermission || null == employeePermission.getEnterpriseId()) {
				resp.fail("该账号无查询数据权限");
				return resp;
			}
			List<EssEnterprise> essEnt = enterpriseService.getSubordinateEnterprise(employeePermission.getEnterpriseId());
			resp.setData(essEnt);
			resp.success("查询成功！");
		} catch (Exception e) {
			resp.fail("查询失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

}
