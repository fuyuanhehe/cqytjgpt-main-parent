package com.ccttic.cqytjgpt.webapi.controller.warning;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.ObjectHelper;

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
	
	/**
	 * 根据条件获取车辆预警信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qryVehicleList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getVehicleWarningList(@RequestBody VehiDangerVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		
		
		
		return ObjectHelper.objectToJson(map);
	}
	
	
}
