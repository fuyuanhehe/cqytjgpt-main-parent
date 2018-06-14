package com.ccttic.cqytjgpt.webapi.controller.organization;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.organization.IDepartmentService;
import com.ccttic.cqytjgpt.webapi.interfaces.organization.IOrganizationService;
import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.entity.role.OrgEmpCombine;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;



/**
 * 功能说明： 组织机构信息Contrller
 * 
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findHeadOrg", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.GET_HEAD, name = "获取树头", isMenue = false, hierarchy = 3, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
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
	@ResourceScan(rsc = @Resource(cd = Const.GET_NEXT_NODE, name = "获取下级节点",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
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
	 * 
	 * @param orgCd
	 *            机构code
	 * @return
	 */
	@RequestMapping(value = "/findOrgByOrgCd", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.GET_ORGANIZATION, name = "获取组织信息",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String findOrgByOrgCd(String orgCd) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			OrgEmpCombine findOrg = organizationService.findOrgByOrgCd(orgCd);
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
	@ResourceScan(rsc = @Resource(cd = Const.ADD_ORGANIZATION, name = "创建组织",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
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
	 * 
	 * @param orgDto
	 *            机构属性
	 * @return
	 */
	@RequestMapping(value = "/editOrg", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.MODIFICATION_ORGANIZATION, name = "修改组织",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
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
	@ResourceScan(rsc = @Resource(cd = Const.DELETE_ORGANIZATION, name = "删除组织",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String removeOrg(String orgCd, String orgType) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			organizationService.removeOrg(orgCd, orgType);
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
	 * 
	 * @param orgCd
	 *            机构code
	 * @return
	 */
	@RequestMapping(value = "/findOrgDepartment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.GET_DEPARTMENT, name = "获取部门信息",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String findOrgDepartment(PageRequest page, Department tment, String orgCd) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Page<Map<String, Object>> pager = departmentService.findOrgDepartmentList(page, tment, orgCd);
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
	 * 
	 * @param orgCd
	 *            机构编码
	 * @param ment
	 * @return
	 */
	@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ADD_DEPARTMENT, name = "创建部门",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String saveDepartment(@RequestBody Department ment) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = RandomHelper.uuid();
			ment = departmentService.createMent(ment, id);
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
	 * 
	 * @param ment
	 * @return
	 */
	@RequestMapping(value = "/editDepartment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.MODIFICATION_DEPARTMENT, name = "修改部门",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String editDepartment(Department ment) {
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
	 * 删除部门
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeDepartment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.DELETE_DEPARTMENT, name = "删除部门",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String removeDepartment(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			departmentService.removeMent(id);
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
	 * 
	 * @param orgCd
	 *            机构编码
	 * @param rise
	 * @return
	 */
	@RequestMapping(value = "/saveEnterprise", method = RequestMethod.POST)
	@ResponseBody
	@ResourceScan(rsc = @Resource(cd = Const.ADD_ENTERPRISE, name = "创建企业",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.ORGANIZATION_SUPERVISE, url="/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public String saveEnterprise(@RequestBody Enterprise rise) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = RandomHelper.uuid();
			rise = departmentService.createRise(rise, id);
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
	 * 获取行政区域编码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getArea", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getArea() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Area> area = organizationService.getArea();
			map.put("data", area);
			map.put("result", 0);
			map.put("msg", "获取信息成功！");
		} catch (AppException e) {
			map.put("result", -1);
			map.put("msg", "获取信息失败！");
			logger.error(e.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}

}
