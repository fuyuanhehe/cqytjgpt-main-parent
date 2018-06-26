package com.ccttic.cqytjgpt.webapi.controller.vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehiIllicitService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.vo.PageVehiIllicitVo;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

/**
 * 功能说明： 车辆违法信息Contrller
 * @author admin
 *
 */
@RestController
@RequestMapping("/vehiIllicit")
@SessionAttributes(Const.ENT)
public class VehiIllicitContrller implements Serializable{
	private static final long serialVersionUID = 4967775901502780928L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVehiIllicitService vehiIllicitService;
	/**
	 * 根据条件获取车辆违法信息
	 * @return
	 */
	@RequestMapping(value = "/qryVehiIllicitList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CAR_ILLICIT_INFO, name = "车辆信息-违法记录", isMenue = true, hierarchy = 3, pcd = Const.CAR_SUPERVISE), prsc = {
			@Resource(cd = Const.CAR_SUPERVISE, name = "车辆监管", isMenue = true, hierarchy = 2, pcd = Const.DAY_SUPERVISE),
			@Resource(cd = Const.DAY_SUPERVISE, name = "日常监管", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<VehiIllicit>> qryVehiIllicitList (@RequestBody PageVehiIllicitVo vehiIllicit,@ModelAttribute(Const.ENT) List<EssEnterprise> ent) {
		ResponseMsg<List<VehiIllicit>> resp = new ResponseMsg<List<VehiIllicit>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(vehiIllicit.getPage());
			page.setRows(vehiIllicit.getRows());
			List<String> list = new ArrayList<String>();
			for (EssEnterprise essEnterprise : ent) {
				list.add(essEnterprise.getId());
			}
			
			Page<VehiIllicit> pager = vehiIllicitService.qryVehiIllicitList(page, vehiIllicit, list);
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
	 * @param id
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
		params.put("id", ve.getId());
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
