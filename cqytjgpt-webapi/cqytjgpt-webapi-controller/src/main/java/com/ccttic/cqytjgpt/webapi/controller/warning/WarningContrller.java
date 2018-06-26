package com.ccttic.cqytjgpt.webapi.controller.warning;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryCarService;
import com.ccttic.cqytjgpt.webapi.interfaces.warning.IWarningservice;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.ObjectHelper;
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
	public String getVehicleWarningList(@RequestBody VehiDangerVo vo,@ModelAttribute(Const.ENT) EssEnterprise ent) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageRequest page = new PageRequest();
		page.setPage(vo.getPage());
		page.setRows(vo.getRows());
		vo.setOwnerorgid(ent.getId());
		try {
			Page<VehiDanger> pager = warningservice.qryVehicleList(page, vo);
		} catch (AppException e) {
			e.printStackTrace();
		}
		
		
		return ObjectHelper.objectToJson(map);
	}
	
	
}
