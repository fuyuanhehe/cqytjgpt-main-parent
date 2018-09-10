package com.ccttic.cqytjgpt.enterpriseapi.controller.main;

import java.io.Serializable;
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
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.danger.vo.DangerCountVo;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.util.common.ObjectHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 首页
 * 
 * @author admin
 *
 */
@RestController
@RequestMapping("/main")
@Api(tags = "首页")
public class MainController implements Serializable {
	private static final long serialVersionUID = 6130325598177740435L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IEnterpriseService enterpriseService;

	/**
	 * 首页-企业隐患自查
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getDangerCount", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "首页-企业隐患自查", notes = "access_token，必传值")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access_token", value = "access_token", required = true, paramType = "query") })
	public ResponseMsg<DangerCountVo> getDangerCount(@RequestParam String access_token) {
		ResponseMsg<DangerCountVo> resp = new ResponseMsg<DangerCountVo>();
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
			// 获取该企业下的所有子企业id
			List<EssEnterprise> essEnt = enterpriseService.getSubordinateEnterprise(employeePermission.getEnterpriseId());
			// 首页-驾驶人隐患自查
			DangerCountVo drDanger = enterpriseService.getDrDangerCount(essEnt);
			// 首页-企业车辆隐患自查
			DangerCountVo vehiDanger = enterpriseService.getVehiDangerCount(essEnt);
			DangerCountVo dangerVo = new DangerCountVo();
			if (ObjectHelper.isNotEmpty(drDanger)) {
				dangerVo.setOverdueProofCount(drDanger.getOverdueProofCount());
				dangerVo.setDrExamineCount(drDanger.getDrExamineCount());
				dangerVo.setFullStudyCount(drDanger.getFullStudyCount());
			} 
			if (ObjectHelper.isNotEmpty(vehiDanger)) {
				dangerVo.setScrappedCount(vehiDanger.getScrappedCount());
				dangerVo.setIllicitCount(vehiDanger.getIllicitCount());
				dangerVo.setVehicleExamineCount(vehiDanger.getVehicleExamineCount());
			}
			resp.setData(dangerVo);
			resp.success("查询成功！");
		} catch (Exception e) {
			resp.fail("查询失败！");
			logger.error("查询失败！", e);
		}
		return resp;
	}

}
