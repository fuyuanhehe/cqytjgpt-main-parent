package com.ccttic.auth.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.auth.common.beans.ResponseMsg;
import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.model.OrgCategoryEnum;
import com.ccttic.auth.model.OrgTreeVo;
import com.ccttic.auth.model.Organization;
import com.ccttic.auth.model.TreeVo;
import com.ccttic.auth.service.IOrganizationService;
import com.ccttic.auth.util.ObjectHelper;

/**
   功能说明：     组织机构信息
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.controller.ess.ParamDataDictController.java
 @date  2016年12月9日
 */
@RestController
@RequestMapping("/ess")
public class OrganizationController implements Serializable {
	private static final long serialVersionUID = 2914535047234085214L;
	
	private final Logger logger = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	private IOrganizationService organizationService;

	/**
	 * 机构人员管理
	 * @return
	 */
/*	@RequestMapping(value = "/orgInit")
	@Menu(resource = "essential.orginit", group = "essential-manager", label = "机构人员管理", order = 1, description = "机构人员管理")
	public ModelAndView orgInit() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ess/organization");
		return mv;
	}*/


	/**
	 * 取得总公司
	 * @param req
	 * @return
	 */
	/*@RequestMapping("/findHeadOrg")
	public String findHeadOrg(HttpServletRequest req) {
		Organization vo = new Organization();
		HttpSession session = req.getSession(false);
		Employee loginUser = ObjectHelper.isEmpty(session) ? null
				: (Employee) session.getAttribute(CommonConstant.SESSION_USER);
		if ("admin".equals(loginUser.getAccount())) {
			try {
				return this.findHeadOrg();
			} catch (AppException e) {
				logger.error("检索机构失败！", e);
				vo.setOrgCd("-1");
				vo.setOrgNm("检索机构失败！");
			}
		} else {
			try {
				if (EmpCategoryEnum.ADMIN.name().equals(loginUser.getEmpType())) {
					Organization org = organizationService.getCompanyByOrgId(loginUser.getOrgId());
					if (org != null) {
						BeanUtils.copyProperties(org, vo);
					}
				} else {
					vo.setOrgCd("-1");
					vo.setOrgNm("只有公司管理员才能维护机构人员信息！");
				}

			} catch (AppException e) {
				logger.error("检索机构失败！", e);
				vo.setOrgCd("-1");
				vo.setOrgNm("检索机构失败！");
			}
		}

		return ObjectHelper.objectToJson(vo);
	}*/

	/**
	 * 取得总公司
	 * 
	 * @return
	 */
	/*private String findHeadOrg() throws AppException {
		Organization headOrg = organizationService.getHeadOrg();
		if (ObjectHelper.isEmpty(headOrg)) {
			headOrg = new Organization();
		}
		return ObjectHelper.objectToJson(headOrg);
	}*/

	/**
	 * 根据机构code取得机构
	 * 
	 * @param orgCd
	 *            机构code
	 * @return
	 */
	@RequestMapping("/findOrgByOrgCd")
	public ResponseMsg<Organization> findOrgByOrgCd(String orgCd) {
		ResponseMsg<Organization> resp = new ResponseMsg<Organization>();
		try {
			// 取得当前机构
			Organization org = organizationService.findOrgByOrgCd(orgCd);
			resp.success("获取机构成功！");
			resp.setData(org);
		} catch (AppException ae) {
			resp.fail("获取机构是吧！");
			logger.error("获取机构是吧！",ae);
		} catch (Exception e) {
			resp.fail("获取机构是吧！");
			logger.error("获取机构是吧！",e);		
		}
		return resp;
	}

	/**
	 * 创建机构
	 * 
	 * @param orgDto
	 *            机构属性
	 * @return
	 */
	@RequestMapping("/saveOrg")
	public ResponseMsg<Organization> saveOrg(Organization org) {
		ResponseMsg<Organization> resp = new ResponseMsg<Organization>();
		try {
			org = organizationService.createOrg(org);
			resp.success("创建机构成功！");
			resp.setData(org);
		} catch (AppException e) {
			resp.fail("创建机构失败！");
			logger.error("创建机构失败！",e);
		} catch (Exception e) {
			resp.fail("创建机构失败！");
			logger.error("创建机构失败！",e);	
		}
		return resp;
	}

	/**
	 * 删除机构
	 * 
	 * @param orgCd
	 *            当前节点的code
	 * @return 下级节点
	 */
	@RequestMapping("/removeOrg")
	public ResponseMsg<String> removeOrg(String orgCd, String jsoncallback) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		// 取得当前机构
		try {
			organizationService.removeOrg(orgCd);
			resp.success("机构删除成功!");
		} catch (AppException e) {
			resp.fail("删除机构失败！");
			logger.error("删除机构失败!",e);
		} catch (Exception e) {
			resp.fail("删除机构失败！");
			logger.error("删除机构失败!",e);
		}
		return resp;
	}

	/**
	 * 修改机构
	 * @param orgDto
	 *            机构属性
	 * @return
	 */
	@RequestMapping("/editOrg")
	@ResponseBody
	public ResponseMsg<Organization> editOrg(Organization org) {
		// 装取页面返回数据
		ResponseMsg<Organization> resp = new ResponseMsg<Organization>();
		try {
			org = organizationService.modifyOrg(org);
			resp.success("修改机构成功！");
			resp.setData(org);
		} catch (AppException e) {
			resp.fail("修改机构失败！");
			logger.error("修改机构失败！",e);
		}  catch (Exception e) {
			resp.fail("修改机构失败！");
			logger.error("修改机构失败！",e);
		}
		return resp;
	}

	/**
	 * 取得当前节点的下级节点
	 * 
	 * @param orgCd
	 *            当前节点的code
	 * @return 下级节点
	 */
	@RequestMapping("/findNextNode")
	public ResponseMsg<List<OrgTreeVo>> findNextNode(String orgCd) {
		ResponseMsg<List<OrgTreeVo>> resp = new ResponseMsg<List<OrgTreeVo>>();
		try {
			// 下级机构
			List<Organization> list = organizationService.findSubOrgsByOrgCd(orgCd);
			// 下级机构内容
			List<OrgTreeVo> orgList = new ArrayList<OrgTreeVo>();

			if (ObjectHelper.isNotEmpty(list)) {
				for (Organization org_ : list) {
					OrgTreeVo vo = orgCopyOrgTreeVo(org_);
					orgList.add(vo);
				}
			}
			resp.success("获取下级机构成功！");
			resp.setData(orgList);
		} catch (AppException e) {
			resp.fail("获取下级机构失败！");
			logger.error("获取下级机构失败！",e);
		}catch (Exception e) {
			resp.fail("获取下级机构失败！");
			logger.error("获取下级机构失败！",e);
		}
		return resp;
	}

	/**
	 * 取得所有的机构（树型）
	 * 
	 * @param type
	 *            取得机构的类型（org 为公司，dept 为部门)
	 * @return
	 */
	@RequestMapping("/findOrgToTree")
	@ResponseBody
	public ResponseMsg<List<TreeVo>> findOrgToTree(String type, String orgCd, Boolean isFilter) throws AppException {
		ResponseMsg<List<TreeVo>>  resp = new ResponseMsg<List<TreeVo>> ();
		List<TreeVo> list = new ArrayList<TreeVo>();
		if (ObjectHelper.isNotEmpty(isFilter) && isFilter && ObjectHelper.isNotEmpty(orgCd)) {
			Organization org = organizationService.findOrgByOrgCd(orgCd);
			TreeVo vo = new TreeVo();
			vo.setId(org.getOrgCd());
			vo.setText(org.getOrgNm());
			Map<String, String> map = new HashMap<String, String>();
			map.put("orgType", "org");
			map.put("orgCd", org.getOrgCd());
			map.put("id", org.getId());
			vo.setIconCls("company");
			vo.setAttributes(map);
			// 取得下级机构
			List<Organization> orgs = organizationService.findSubOrgsByOrgCd(orgCd);
			if (ObjectHelper.isNotEmpty(orgs)) {
				vo.setChildren(itemOrg(orgs, type));
			}
			list.add(vo);
		} else {
			// 取得总部
			Organization headOrg = organizationService.getHeadOrg();
			TreeVo vo = new TreeVo();
			vo.setId(headOrg.getOrgCd());
			vo.setText(headOrg.getOrgNm());
			Map<String, String> map = new HashMap<String, String>();
			map.put("orgType", "org");
			map.put("orgCd", headOrg.getOrgCd());
			map.put("id", headOrg.getId());
			vo.setIconCls("company");
			vo.setAttributes(map);
			// 取得下级机构
			List<Organization> orgs = organizationService.findSubOrgsByOrgCd(headOrg.getOrgCd());
			if (ObjectHelper.isNotEmpty(orgs)) {
				vo.setChildren(itemOrg(orgs, type));
			}
			list.add(vo);
		}
		resp.success("获取所有机构树成功！");
		resp.setData(list);
		return resp;
	}

	/**
	 * 遍历所有的下级机构
	 * @param orgs
	 * @param type
	 * @return
	 * @throws AppException
	 */
	public List<TreeVo> itemOrg(List<Organization> orgs, String type) throws AppException {
		List<TreeVo> list = new ArrayList<TreeVo>();
		for (Organization org : orgs) {
			// 判断机构是否己经删除
			if (org.getIsDeleted()) {
				continue;
			}
			// 判断是取得机构还是部门
			if (ObjectHelper.isNotEmpty(type)) {
				if (!"dept".equals(type)) {
					if (OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getOrgType())) {
						continue;
					}
				}
			}
			TreeVo vo = new TreeVo();
			vo.setId(org.getOrgCd());
			vo.setText(org.getOrgNm());
			Map<String, String> map = new HashMap<String, String>();
			// 判断机构类型
			if (OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getOrgType())) {
				map.put("orgType", "dept");
				vo.setIconCls("department");
			} else {
				map.put("orgType", "org");
				vo.setIconCls("company");
			}
			// 设置orgCd
			map.put("orgCd", org.getOrgCd());
			// 设置id
			map.put("id", org.getId());
			vo.setAttributes(map);
			// 取得下级机构
			List<Organization> childOrgs = organizationService.findSubOrgsByOrgCd(org.getOrgCd());
			if (ObjectHelper.isNotEmpty(childOrgs)) {
				vo.setChildren(itemOrg(childOrgs, type));
			}
			list.add(vo);
		}
		return list;
	}

	/**
	 * 将Organization转换成orgDto
	 * 
	 * @param org
	 * @return
	 */
	public OrgTreeVo orgCopyOrgTreeVo(Organization org) {
		OrgTreeVo vo = new OrgTreeVo();

		// 上级机构
		vo.setSuperOrgCd(org.getSuperOrgCd());
		vo.setSuperOrdNm(org.getSuperOrgNm());

		// 机构code
		vo.setOrgCd(org.getOrgCd());
		// 机构名称
		vo.setOrgNm(org.getOrgNm());
		// 部门职能（只在部门上设置）

		// 公司简称
		vo.setShortNm(org.getShortNm());
		// 备注
		vo.setRemark(org.getRemark());
		// 顺序号
		vo.setDispOrder(org.getDispOrder());
		// 树型显示名称
		vo.setText(org.getOrgNm());
		// 树型节点id
		vo.setId(org.getOrgCd());
		Map<String, String> map = new HashMap<String, String>();
		// 判断机构是公司还是部门
		if (!OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getOrgType())) {
			// 判断是否是总公司
			if (OrgCategoryEnum.HEAD.name().equalsIgnoreCase(org.getOrgType())) {
				vo.setOrgType("HEAD");
				vo.setOrgTypeNm("总公司");
				// 取得董事长
				if (ObjectHelper.isNotEmpty(org.getChairmanCd())) {
					vo.setChairman(org.getChairmanCd());
					vo.setChairmanNm(org.getChairmanNm());
				}
				// 子公司
			} else if (OrgCategoryEnum.SUB.name().equalsIgnoreCase(org.getOrgType())) {
				vo.setOrgType("SUB");
				vo.setOrgTypeNm("子公司");
				// 取得董事长
				if (ObjectHelper.isNotEmpty(org.getChairmanCd())) {
					vo.setChairman(org.getChairmanCd());
					vo.setChairmanNm(org.getChairmanNm());
				}
				// 分管领导
				if (ObjectHelper.isNotEmpty(org.getLeadershipCd())) {
					vo.setTempLeadership(org.getLeadershipCd());
					vo.setTempLeadershipNm(org.getLeadershipNm());
				}
				// 分公司
			} else if (OrgCategoryEnum.BRANCH.name().equalsIgnoreCase(org.getOrgType())) {
				vo.setOrgType("BRANCH");
				vo.setOrgTypeNm("分公司");
				// 分管领导
				if (ObjectHelper.isNotEmpty(org.getLeadershipCd())) {
					vo.setTempLeadership(org.getLeadershipCd());
					vo.setTempLeadershipNm(org.getLeadershipNm());
				}
			}
			// 总经理
			if (ObjectHelper.isNotEmpty(org.getGeneralManagerCd())) {
				vo.setGeneralManger(org.getGeneralManagerCd());
				vo.setGeneralMangerNm(org.getGeneralManagerNm());
			}

		} else if (OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getOrgType())) {
			vo.setOrgType("DEPARTMENT");
			vo.setOrgTypeNm("部门");

			// 分管领导
			if (ObjectHelper.isNotEmpty(org.getLeadershipCd())) {
				vo.setTempLeadership(org.getLeadershipCd());
				vo.setTempLeadershipNm(org.getLeadershipNm());
			}
			// 部门经理
			if (ObjectHelper.isNotEmpty(org.getManagerCd())) {
				vo.setDeptManager(org.getManagerCd());
				vo.setDeptManagerNm(org.getManagerNm());

			}
			// 部门副经理
			if (ObjectHelper.isNotEmpty(org.getDeptDeputyCd())) {
				vo.getDeputyManagerIds().clear();
				vo.getDeputyManagerNms().clear();
				for (String deptDeputyCd : org.getDeptDeputyCd().split(",")) {
					vo.getDeputyManagerIds().add(deptDeputyCd);
				}
				for (String deptDeputyNm : org.getDeptDeputyNm().split(",")) {
					vo.getDeputyManagerNms().add(deptDeputyNm);
				}
			}

			if (ObjectHelper.isNotEmpty(org.getSuperOrgCd())
					&& OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getSuperOrgType())) {
				vo.setSuperOrgCdOrgType("DEPARTMENT");
			}

			// 部门职能
			vo.setOrgDuty(org.getOrgDuty());
		}
		vo.setAttributes(map);
		map.put("orgType", vo.getOrgType());
		vo.setState("closed");
		return vo;
	}

}
