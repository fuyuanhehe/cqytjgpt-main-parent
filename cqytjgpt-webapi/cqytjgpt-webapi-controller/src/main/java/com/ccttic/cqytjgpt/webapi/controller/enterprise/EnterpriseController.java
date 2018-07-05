package com.ccttic.cqytjgpt.webapi.controller.enterprise;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;
import com.ccttic.entity.enterprise.vo.PageEssEnterpriseVo;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IEnterpriseService enterpriseService;

	@RequestMapping(value = "/selectEnterprise", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.SELECT_ENTERPRISE, name = "查询企业信息", hierarchy = 3, isMenue = true, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/enterprise/selectEnterprise", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<Map<String, Object>> selectEnterprise(HttpServletRequest request, @RequestBody String id) {
		ResponseMsg<Map<String, Object>> rm = new ResponseMsg<Map<String, Object>>();
		Map<String, String> map = JsonUtil.jsonToMap(id);

		try {
			Map<String, Object> result = enterpriseService.selectEnterpriseById(map);
			rm.setData(result);
			rm.success("获得企业数据成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("获得企业数据失败");
			logger.info(e);
		}
		return rm;
	}

	@RequestMapping(value = "/modifyEnterprise", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.MODIFY_ENTERPRISE, name = "修改企业信息", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/enterprise/modifyEnterprise", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> modifyEnterprise(HttpServletRequest request, @RequestBody EssEnterprise essEnterprise) {
		ResponseMsg<String> rm = new ResponseMsg<String>();

		try {
			enterpriseService.modifyEnterpriseById(essEnterprise);
			rm.success("修改企业数据成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("企业数据失败");
			logger.info(e);
		}
		return rm;
	}

	@RequestMapping(value = "/delEnterprise", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.DELETE_ENTERPRISE, name = "删除企业", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/enterprise/delEnterprise", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> delEnterprise(HttpServletRequest request, @RequestBody EssEnterprise essEnterprise) {
		ResponseMsg<String> rm = new ResponseMsg<String>();
		try {
			int i = enterpriseService.delEnterpriseById(essEnterprise);
			if (i ==0) {
				rm.success("删除企业数据成功");
			} else {
				rm.fail("该企业下还有员工,请先将员工删完");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("删除企业数据失败");
			logger.info(e);
		}
		return rm;
	}
	
	/**
	 * 注册企业(资料填写)
	 * @param request
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/registerEnterpries", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.REGISTER_ENTERPRISE,url = "/enterprise/registerEnterpries", name = "注册企业", hierarchy = 2, isMenue = true, pcd = Const.LOGIN_REGISTER_ENTERPRISE), prsc = {
			@Resource(cd = Const.LOGIN_REGISTER_ENTERPRISE, name = "登录注册审核", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> registerEnterpries(HttpServletRequest request, @RequestBody EnterpriseVo vo) {
		ResponseMsg<String> rm = new ResponseMsg<String>();
		try {
			int i = enterpriseService.registerEnterpries(vo);
			if (i ==1) {
				rm.success("添加数据成功");
			} else {
				rm.fail("添加数据失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail("添加数据失败");
			logger.info(e);
		}
		return rm;
	}
	
	/**
	 * 根据条件获取企业信息(区分所审核)
	 * @param page
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/qryEnterpriesList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.CHECK_ENTERPRISE,url = "/enterprise/qryEnterpriesList", name = "区分所审核", hierarchy = 2, isMenue = true, pcd = Const.LOGIN_REGISTER_ENTERPRISE), prsc = {
			@Resource(cd = Const.LOGIN_REGISTER_ENTERPRISE, name = "登录注册审核", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<EssEnterprise>> qryEnterpriesList(@RequestBody PageEssEnterpriseVo vo) {
		ResponseMsg<List<EssEnterprise>> resp = new ResponseMsg<List<EssEnterprise>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(vo.getPage());
			page.setRows(vo.getRows());
			Page<EssEnterprise> pager = enterpriseService.qryEssEnterpriseList(page, vo);
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
