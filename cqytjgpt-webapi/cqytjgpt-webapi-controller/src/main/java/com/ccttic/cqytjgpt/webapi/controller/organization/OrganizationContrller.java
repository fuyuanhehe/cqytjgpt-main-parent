package com.ccttic.cqytjgpt.webapi.controller.organization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.organization.IDepartmentService;
import com.ccttic.cqytjgpt.webapi.interfaces.organization.IOrganizationService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.entity.role.OrgEmpCombine;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.vo.PageDepartmentVo;
import com.ccttic.entity.role.vo.TreeVo;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
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
	@Autowired
	private IEmployeeService employeeService;
	/**
	 * 获取组织机构
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findHeadOrg")
	@ResourceScan(rsc = @Resource(cd = Const.GET_HEAD, name = "获取树头", isMenue = false, hierarchy = 3, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<TreeVo>> findAllOrg(@RequestParam String access_token,@RequestBody String orgId) {
		ResponseMsg<List<TreeVo>> resp = new ResponseMsg<List<TreeVo>>();
			EmployeeVo employee = employeeService.getUserInfo(access_token);
			Organization org = employee.getOrg();
		Map<String, String> orgIdMap = new HashMap<>();
		if (org==null){
			orgIdMap.put("orgId","162d7b86a54e465d8cf421def2f35ef8");
		}else{
			orgIdMap.put("orgId",org.getId());
		}
		List<TreeVo> list = new ArrayList<TreeVo>();
		TreeVo vo = new TreeVo();
		try {
			Organization headOrg = organizationService.getHeadOrg(orgIdMap); // 获取机构头
			vo.setId(headOrg.getOrgCd());
			vo.setText(headOrg.getOrgNm());
			vo.setRemark(headOrg.getRemark());
			Map<String, String> map = new HashMap<String, String>();
			map.put("orgType",headOrg.getOrgType());
			map.put("orgCd", headOrg.getOrgCd());
			map.put("id", headOrg.getId());
			vo.setIconCls("company");
			vo.setAttributes(map);
			List<Organization> orgs = organizationService.findNextNode(headOrg.getOrgCd()); // 获取分所
			if (ObjectHelper.isNotEmpty(orgs)) {
				vo.setChildren(itemOrg(orgs));
			}
			list.add(vo);
			if (!ObjectHelper.isEmpty(headOrg)) {
				resp.setData(list);
				resp.success("获取信息成功！");
			}
		} catch (AppException e) {
			resp.fail("获取信息失败！");
			logger.error(e.getMessage());
		}
		System.out.println(resp);
		return resp;
	}
	
	/**
	 * 遍历所有的下级机构
	 * @param orgs
	 * @return
	 * @throws AppException
	 */
	public List<TreeVo> itemOrg(List<Organization> orgs) throws AppException {
		List<TreeVo> list = new ArrayList<TreeVo>();
		for (Organization org : orgs) {
			TreeVo vo = new TreeVo();
			vo.setId(org.getOrgCd());
			vo.setText(org.getOrgNm());
			vo.setRemark(org.getRemark());
			vo.setSuperOrgId(org.getSuperOrgId());
			Map<String, String> map = new HashMap<String, String>();
			// 判断机构类型
			if ("1".equalsIgnoreCase(org.getOrgType())) {
				map.put("orgType", "1");
				vo.setIconCls("department");
			} else {
				map.put("orgType", "2");
				vo.setIconCls("company");
			}
			// 设置orgCd
			map.put("orgCd", org.getOrgCd());
			// 设置id
			map.put("id", org.getId());
			vo.setAttributes(map);
			// 取得下级机构
			List<Organization> childOrgs = organizationService.findNextNode(org.getOrgCd());
			if (ObjectHelper.isNotEmpty(childOrgs)) {
				vo.setChildren(itemOrg(childOrgs));
			}
			list.add(vo);
		}
		return list;
	}
	/**
	 * 取得当前节点的下级节点
	 *            当前节点的code
	 * @return 下级节点
	 */
	@RequestMapping(value = "/findNextNode", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.GET_NEXT_NODE, name = "获取下级节点", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<Organization>> findNextNode(@RequestBody Organization org) {
		ResponseMsg<List<Organization>> resp = new ResponseMsg<List<Organization>>();
		try {
			List<Organization> list = organizationService.findNextNode(org.getOrgCd());
			if (!ObjectHelper.isEmpty(list)) {
				resp.setData(list);
				resp.success("获取信息成功！");
			}
		} catch (AppException e) {
			resp.fail("获取信息失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 根据机构orgCd取得组织信息
	 *
	 *            机构code
	 * @return
	 */
	@RequestMapping(value = "/findOrgByOrgCd", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.GET_ORGANIZATION, name = "获取组织信息", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<OrgEmpCombine> findOrgByOrgCd(@RequestBody Organization org) {
		Map<String, Object> map = new HashMap<String, Object>();
		ResponseMsg<OrgEmpCombine> resp = new ResponseMsg<OrgEmpCombine>();
		try {
			OrgEmpCombine findOrg = organizationService.findOrgByOrgCd(org.getOrgCd());
			if (!ObjectHelper.isEmpty(findOrg)) {
				resp.setData(findOrg);
				map.put("data", findOrg);
				resp.success("获取信息成功！");
			}
		} catch (AppException e) {
			resp.fail("获取信息失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 创建机构

	 *            机构属性
	 * @return
	 */
	@RequestMapping(value = "/saveOrg", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.ADD_ORGANIZATION, name = "创建组织", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<Organization> saveOrg(@RequestBody Organization org) {
		ResponseMsg<Organization> resp = new ResponseMsg<Organization>();
		try {
			String id = RandomHelper.uuid();
			org = organizationService.createOrg(org, id);
			resp.setData(org);
			resp.success("添加成功！");
		} catch (AppException e) {
		resp.fail("添加失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 修改机构
	 *            机构属性
	 * @return
	 */
	@RequestMapping(value = "/editOrg", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.MODIFICATION_ORGANIZATION, name = "修改组织", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<Organization> editOrg(@RequestBody Organization org) {
		ResponseMsg<Organization> resp = new ResponseMsg<Organization>();
		try {
			org = organizationService.editOrg(org);
			resp.setData(org);
			resp.success("修改成功！");
		} catch (AppException e) {
		resp.fail("修改失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 删除机构
	 *            当前节点的code
	 * @return 下级节点
	 */
	@RequestMapping(value = "/removeOrg", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.DELETE_ORGANIZATION, name = "删除组织", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> removeOrg(@RequestBody Organization org) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			organizationService.removeOrg(org.getOrgCd(), org.getOrgType());
			resp.success("删除成功！");
		} catch (AppException e) {
			resp.fail("删除失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 根据机构orgCd取得部门管理信息
	 *            机构code
	 * @return
	 */
	@RequestMapping(value = "/findOrgDepartment", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.GET_DEPARTMENT, name = "获取部门信息", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<Department>>  findOrgDepartment(@RequestBody PageDepartmentVo tment) {
		ResponseMsg<List<Department>> resp = new ResponseMsg<List<Department>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			Page<Department> pager = departmentService.findOrgDepartmentList(page, tment, tment.getOrgCd());
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
	 * 新增部门
	 *            机构编码
	 * @param ment
	 * @return
	 */
	@RequestMapping(value = "/saveDepartment", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.ADD_DEPARTMENT, name = "创建部门", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<Department> saveDepartment(@RequestBody Department ment) {
		ResponseMsg<Department> resp = new ResponseMsg<Department>();
		try {
			String id = RandomHelper.uuid();
			ment = departmentService.createMent(ment, id);
			resp.setData(ment);
			resp.success("添加成功！");
		} catch (Exception e) {
			resp.fail("添加失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 修改部门
	 * 
	 * @param ment
	 * @return
	 */
	@RequestMapping(value = "/editDepartment", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.MODIFICATION_DEPARTMENT, name = "修改部门", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<Department> editDepartment(@RequestBody Department ment) {
		ResponseMsg<Department> resp = new ResponseMsg<Department>();
		try {
			ment = departmentService.modifyMent(ment);
			resp.setData(ment);
			resp.success("修改成功！");
		} catch (Exception e) {
			resp.fail("修改失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 删除部门
	 * @return
	 */
	@RequestMapping(value = "/removeDepartment", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.DELETE_DEPARTMENT, name = "删除部门", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> removeDepartment(@RequestBody Department ment) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			int cat = departmentService.removeMent(ment.getId());
			if (cat == 1) {
				resp.success("删除成功！");
			} else if (cat == 0) {
				resp.fail("删除失败！");
			} else if (cat == 2) {
				resp.fail("该部门下有人员关联，无法删除；请清除关联人员后重试!");
			}
		} catch (Exception e) {
			resp.fail("删除失败！");
			logger.error(e.getMessage());
		}
		return resp;

	}

	/**
	 * 新增企业
	 *            机构编码
	 * @param rise
	 * @return
	 */
	@RequestMapping(value = "/saveEnterprise", method = { RequestMethod.POST, RequestMethod.GET })
	@ResourceScan(rsc = @Resource(cd = Const.ADD_ENTERPRISE, name = "创建企业", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/organization/findHeadOrg", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<Enterprise> saveEnterprise(@RequestBody Enterprise rise) {
		ResponseMsg<Enterprise> resp = new ResponseMsg<Enterprise>();
		try {
			String id = RandomHelper.uuid();
			rise = departmentService.createRise(rise, id);
			resp.setData(rise);
			resp.success("添加成功！");
		} catch (Exception e) {
			resp.fail("添加失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}

	/**
	 * 获取行政区域编码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getArea", method = { RequestMethod.POST, RequestMethod.GET })
	public ResponseMsg<List<Area>> getArea() {
		ResponseMsg<List<Area>> resp = new ResponseMsg<List<Area>>();
		try {
			List<Area> area = organizationService.getArea();
			resp.setData(area);
			resp.success("添加成功！");
		} catch (Exception e) {
			resp.fail("添加失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}
	
	/**
	 * 获取组织机构下拉框用
	 * @return
	 */
	@RequestMapping(value = "/findAllOrgList", method = { RequestMethod.POST, RequestMethod.GET })
	public ResponseMsg<List<TreeVo>> findAllOrgList() {
		ResponseMsg<List<TreeVo>> resp = new ResponseMsg<List<TreeVo>>();
		List<TreeVo> list = new ArrayList<TreeVo>();
		TreeVo vo = new TreeVo();
		try {
			Organization headOrg = organizationService.getHeadOrgList(); // 获取机构头
			vo.setId(headOrg.getOrgCd());
			vo.setText(headOrg.getOrgNm());
			vo.setRemark(headOrg.getRemark());
			Map<String, String> map = new HashMap<String, String>();
			map.put("orgType", "0");
			map.put("orgCd", headOrg.getOrgCd());
			map.put("id", headOrg.getId());
			vo.setIconCls("company");
			vo.setAttributes(map);
			List<Organization> orgs = organizationService.findNextNode(headOrg.getOrgCd()); // 获取分所
			if (ObjectHelper.isNotEmpty(orgs)) {
				vo.setChildren(itemOrg(orgs));
			}
			list.add(vo);
			if (!ObjectHelper.isEmpty(headOrg)) {
				resp.setData(list);
				resp.success("获取信息成功！");
			}
		} catch (AppException e) {
			resp.fail("获取信息失败！");
			logger.error(e.getMessage());
		}
		System.out.println(resp);
		return resp;
	}
}
