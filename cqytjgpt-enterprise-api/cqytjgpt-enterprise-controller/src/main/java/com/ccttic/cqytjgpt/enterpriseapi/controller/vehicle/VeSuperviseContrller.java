package com.ccttic.cqytjgpt.enterpriseapi.controller.vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.vehicle.IVehicleService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.TreeVehileVo;
import com.ccttic.entity.role.vo.TreeVo;
import com.ccttic.entity.role.vo.VehicleSuperviseVo;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.exception.AppException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/veSupervise")
@Api(tags = "车辆监管Contrller")
public class VeSuperviseContrller implements Serializable{

	private static final long serialVersionUID = 8887324856022221086L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IVehicleService vehicleService;
	
	/**
	 * 根据登录账号获取企业下（或下级企业）的车辆
	 * @param access_token
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleAMList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "根据登录账号获取企业下（或下级企业）的车辆", notes = "access_token，必传值")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access_token", value = "access_token", required = true, paramType = "query")})
	public ResponseMsg<List<TreeVehileVo>> getVeSupervise(@RequestParam String access_token) {
		ResponseMsg<List<TreeVehileVo>> resp = new ResponseMsg<List<TreeVehileVo>>();
		List<TreeVehileVo> list = new ArrayList<TreeVehileVo>();
		TreeVehileVo treeVo = new TreeVehileVo();
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
			List<EssEnterprise> essEnt = vehicleService.getEssEnterprise(employeePermission.getEnterpriseId());
			if (ObjectHelper.isNotEmpty(essEnt)) {
				treeVo.setChildren(itemVehicle(essEnt));
			}
			list.add(treeVo);
			resp.setData(list);
			resp.success("获取信息成功！");
		} catch (Exception e) {
			resp.fail("获取信息失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}
	public List<TreeVehileVo> itemVehicle(List<EssEnterprise> essEnt) throws AppException{
		List<TreeVehileVo> list = new ArrayList<TreeVehileVo>();
		for (EssEnterprise essEnterprise : essEnt) {
			TreeVehileVo vo = new TreeVehileVo();
			vo.setId(essEnterprise.getId());
			vo.setEtpNm(essEnterprise.getEtpnm());
			List<TreeVehileVo> listVo = vehicleService.getVehicleSupervise(essEnterprise.getId());
			vo.setChildren(listVo);
			list.add(vo);
		}
		return list;
	}
}
