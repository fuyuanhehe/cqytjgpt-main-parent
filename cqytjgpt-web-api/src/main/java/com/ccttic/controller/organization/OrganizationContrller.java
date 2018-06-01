package com.ccttic.controller.organization;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.common.exception.AppException;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.entity.role.Organization;
import com.ccttic.service.organization.IDepartmentService;
import com.ccttic.service.organization.IOrganizationService;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;


/**
 * 功能说明：     组织机构信息Contrller
 * @author admin
 *
 */
@RestController
@RequestMapping("/organization")
public class OrganizationContrller implements Serializable {
	
	private static final long serialVersionUID = -7767353326548858542L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IOrganizationService organizationService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	/**
	 * 获取机构头
	 * @return
	 */
	@RequestMapping(value = "/findHeadOrg", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findAllOrg() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Organization headOrg = organizationService.getHeadOrg();
			if (!ObjectHelper.isEmpty(headOrg)) {
				map.put("data", headOrg);
				map.put("result", 0);
				map.put("msg", "获取信息成功！");
			}
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "获取信息失败！");
			logger.error(e.getMessage());
		}
		
		return ObjectHelper.objectToJson(map);
	}
	
	/**
	 * 取得当前节点的下级节点
	 * 
	 * @param orgCd
	 *            当前节点的code
	 * @return 下级节点
	 */
	@RequestMapping(value = "/findNextNode", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findNextNode(String orgCd) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Organization> list = organizationService.findNextNode(orgCd);
			if (!ObjectHelper.isEmpty(list)) {
				map.put("data", list);
				map.put("result", 0);
				map.put("msg", "获取信息成功！");
			}
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "获取信息失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	/**
	 * 根据机构orgCd取得组织信息
	 * @param orgCd 机构code
	 * @return
	 */
	@RequestMapping(value = "/findOrgByOrgCd", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findOrgByOrgCd(String orgCd) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Organization findOrg = organizationService.findOrgByOrgCd(orgCd);
			if (!ObjectHelper.isEmpty(findOrg)) {
				map.put("data", findOrg);
				map.put("result", 0);
				map.put("msg", "获取信息成功！");
			}
		} catch (Exception e) {
			map.put("result", -1);
			map.put("msg", "获取信息失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	/**
	 * 创建机构
	 * 
	 * @param orgDto
	 *            机构属性
	 * @return
	 */
	@RequestMapping(value = "/saveOrg", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String saveOrg(Organization org) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = RandomHelper.uuid();
			org = organizationService.createOrg(org, id);
			map.put("data", org);
			map.put("result", 0);
			map.put("msg", "添加成功！");
		} catch (Exception e) {
			map.put("result", -1);
			map.put("msg", "添加失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	/**
	 * 修改机构
	 * @param orgDto
	 *            机构属性
	 * @return
	 */
	@RequestMapping(value = "/editOrg", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String editOrg(Organization org) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org = organizationService.editOrg(org);
			map.put("data", org);
			map.put("result", 0);
			map.put("msg", "修改成功！");
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "修改失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	
	/**
	 * 删除机构
	 * 
	 * @param orgCd
	 *            当前节点的code
	 * @return 下级节点
	 */
	@RequestMapping(value = "/removeOrg", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String removeOrg(String orgCd,String orgType) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			organizationService.removeOrg(orgCd,orgType);
			map.put("result", 0);
			map.put("msg", "删除成功！");
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "删除失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	/**
	 * 根据机构orgCd取得部门管理信息
	 * @param orgCd 机构code
	 * @return
	 */
	@RequestMapping(value = "/findOrgDepartment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findOrgDepartment(PageRequest page, Department tment,String orgCd) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Page<Map<String, Object>> pager  = departmentService.findOrgDepartmentList(page, tment, orgCd);
			map.put("data", pager.getRecords());
			map.put("total", pager.getTotalRows());
			map.put("result", 0);
			map.put("msg", "获取信息成功！");
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "获取信息失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	/**
	 * 新增部门
	 * @param orgCd 机构编码
	 * @param ment
	 * @return
	 */
	@RequestMapping(value = "/saveDepartment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String saveDepartment (String orgCd,Department ment) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = RandomHelper.uuid();
			ment = departmentService.createMent(ment, id, orgCd);
			map.put("data", ment);
			map.put("result", 0);
			map.put("msg", "添加成功！");
		} catch (Exception e) {
			map.put("result", -1);
			map.put("msg", "添加失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	/**
	 * 修改部门
	 * @param ment
	 * @return
	 */
	@RequestMapping(value = "/editDepartment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String editDepartment (Department ment) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ment = departmentService.modifyMent(ment);
			map.put("data", ment);
			map.put("result", 0);
			map.put("msg", "修改成功！");
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "修改失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	
	/**
	 *  删除部门
	 * @param orgCd
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeDepartment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String removeDepartment(String orgCd,String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			departmentService.removeMent(orgCd, id);
			map.put("result", 0);
			map.put("msg", "删除成功！");
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "删除失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
		
		
	}
	
	/**
	 * 新增企业
	 * @param orgCd 机构编码
	 * @param rise
	 * @return
	 */
	@RequestMapping(value = "/saveEnterprise", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String saveEnterprise (String orgCd,Enterprise rise) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = RandomHelper.uuid();
			rise = departmentService.createRise(rise, id, orgCd);
			map.put("data", rise);
			map.put("result", 0);
			map.put("msg", "添加成功！");
		} catch (Exception e) {
			map.put("result", -1);
			map.put("msg", "添加失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}
	
	/**
	 * 根据机构orgCd取得人员管理信息
	 * @param orgCd 机构code
	 * @return
	 */
	@RequestMapping(value = "/findOrgPersonnel", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findOrgPersonnel(String orgCd) {
		
		
		return "";
	}
	
}
