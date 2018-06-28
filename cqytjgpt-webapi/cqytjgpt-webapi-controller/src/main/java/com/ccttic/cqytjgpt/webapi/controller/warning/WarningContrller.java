package com.ccttic.cqytjgpt.webapi.controller.warning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ccttic.cqytjgpt.webapi.interfaces.warning.IWarningservice;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.DrDangerVo;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

/**
 * 预警提示
 * @author admin
 *
 */
@Controller
@RequestMapping("/warning")
@SessionAttributes(Const.ENT)
public class WarningContrller implements Serializable {
	private static final long serialVersionUID = 2213999569272828267L;
	
	@Autowired
	private IWarningservice warningservice;
	
	/**
	 * 根据条件获取车辆预警信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ResponseMsg<List<VehiDanger>> getVehicleWarningList(@RequestBody VehiDangerVo vo,HttpServletRequest request) {
		ResponseMsg<List<VehiDanger>> resp = new ResponseMsg<List<VehiDanger>>();
		PageRequest page = new PageRequest();
		page.setPage(vo.getPage());
		page.setRows(vo.getRows());
		EmployeeVo emp = (EmployeeVo) request.getSession(true).getAttribute(Const.ENT); 
		List<EssEnterprise> ent = emp.getEnt();
		List<String> list = new ArrayList<String>();
		for (EssEnterprise essEnterprise : ent) {
			list.add(essEnterprise.getId());
		}
		vo.setList(list);
		try {
			Page<VehiDanger> pager = warningservice.qryVehicleList(page, vo);
			resp.setData(pager.getRecords());
			resp.setTotal(pager.getTotalRows().intValue());
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
		}
		return resp;
	}
	
	@RequestMapping(value = "/qryDriverList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ResponseMsg<Page<DrDangerVo>> getDriverWarningList(@RequestBody DrDangerVo vo,HttpServletRequest request) {
		ResponseMsg<Page<DrDangerVo>> resp = new ResponseMsg<Page<DrDangerVo>>();
		PageRequest page = new PageRequest();
		page.setPage(vo.getPage());
		page.setRows(vo.getRows());
		EmployeeVo emp = (EmployeeVo) request.getSession(true).getAttribute(Const.ENT); 
		List<EssEnterprise> ent = emp.getEnt();
		List<String> list = new ArrayList<String>();
		for (EssEnterprise essEnterprise : ent) {
			list.add(essEnterprise.getId());
		}
		vo.setList(list);
		try {
			Page<DrDangerVo> pager = warningservice.qryDriverList(page, vo);
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
	@RequestMapping(value = "/getByIdVehicleWarning", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ResponseMsg<VehiDanger> getByIdVehicleWarning(@RequestBody VehiDangerVo vo) {
		ResponseMsg<VehiDanger> resp = new ResponseMsg<VehiDanger>();
		
		try {
			VehiDanger vehi = warningservice.qryOneVehicle(vo);
			resp.setData(vehi);
			resp.success("查询成功！");
		} catch (AppException e) {
			resp.fail("查询失败！");
		}
		return resp;
	}
	
	@RequestMapping(value = "/getByIdDriverWarning", method = {RequestMethod.POST,RequestMethod.GET})
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
}
