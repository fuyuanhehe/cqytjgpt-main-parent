package com.ccttic.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.exception.DeleteRefusedException;
import com.ccttic.auth.mapper.EmployeeMapper;
import com.ccttic.auth.mapper.OrganizationMapper;
import com.ccttic.auth.mapper.PostEmpMapper;
import com.ccttic.auth.mapper.PostMapper;
import com.ccttic.auth.model.EmpCategoryEnum;
import com.ccttic.auth.model.Employee;
import com.ccttic.auth.model.OrgCategoryEnum;
import com.ccttic.auth.model.Organization;
import com.ccttic.auth.model.Post;
import com.ccttic.auth.model.PostCategoryEnum;
import com.ccttic.auth.model.PostEmp;
import com.ccttic.auth.service.ICategoryService;
import com.ccttic.auth.service.IEmployeeService;
import com.ccttic.auth.service.IOrganizationService;
import com.ccttic.auth.util.ObjectHelper;
import com.ccttic.auth.util.RandomHelper;

/**
   功能说明：     机构业务实现类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.impl.OrganizationServiceImpl.java
 @date  2016年12月12日
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService {
	@Resource
	private OrganizationMapper mapper;
	@Resource
	private EmployeeMapper empMapper;
	@Resource
	private PostEmpMapper peMapper;
	@Resource
	private PostMapper postMapper;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private ICategoryService categoryService;

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#getCompanyByOrgId(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Organization getCompanyByOrgId(String orgId) throws AppException {
		Organization org = mapper.findOrgById(orgId);
		if (ObjectHelper.isNotEmpty(org)) {
			if (!OrgCategoryEnum.DEPARTMENT.name().equals(org.getOrgType())) {
				return org;
			} else {
				this.getCompanyByOrgId(org.getSuperOrgId());
			}
		}
		return org;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#assignGeneralManager(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public void assignGeneralManager(String orgCd, String empCd) throws AppException {
		//获取总经理岗位
		Post generalManagerPost = postMapper.findPostByPostType(PostCategoryEnum.GMPost.name());
		// 获取orgCd指定的公司
		Organization org = mapper.findOrgByOrgCd(orgCd);
		org = this.getCompanyByOrgId(org.getId());
		//员工升迁为总经理
		Employee gm = employeeService.promotion(orgCd, empCd, EmpCategoryEnum.GENERALMANAGER);
		// 原总经理卸任
		String oldGeneralManagerId = org.getGeneralManagerId();
		if (ObjectHelper.isNotEmpty(oldGeneralManagerId)) {
			//是否是其他公司的总经理
			boolean isGm = empMapper.isOtherCompanyGeneralManager(orgCd, oldGeneralManagerId) > 0 ? true : false;
			boolean isCM = empMapper.isOtherCompanyChairman(orgCd, oldGeneralManagerId) > 0 ? true : false;
			if (!isGm || !isCM) {
				peMapper.removeEmpPost(oldGeneralManagerId, generalManagerPost.getId());
			}
		}

		// 任命新总经理
		long pe = peMapper.findPostEmpByCondition(gm.getId(), generalManagerPost.getId());
		if (pe < 1) {
			peMapper.addPostEmp(new PostEmp(RandomHelper.uuid(), gm.getId(), generalManagerPost.getId(), 1));
		}

		// 修改员工升迁为总经理
		mapper.setGeneralManager(org.getOrgCd(), gm.getId());

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#removeGeneralManager(java.lang.String)
	 */
	@Override
	@Transactional
	public void removeGeneralManager(String orgCd) throws AppException {
		Organization org = mapper.findOrgByOrgCd(orgCd);
		if (ObjectHelper.isNotEmpty(org) && ObjectHelper.isNotEmpty(org.getGeneralManagerId())) {
			//总经理
			Employee gm = empMapper.findEmployeeById(org.getGeneralManagerId());
			// 获取总经理岗位
			Post gmp = postMapper.findPostByPostType(PostCategoryEnum.GMPost.name());
			if (OrgCategoryEnum.HEAD.name().equals(org.getOrgType())
					|| OrgCategoryEnum.SUB.name().equals(org.getOrgType())
					|| OrgCategoryEnum.BRANCH.name().equals(org.getOrgType())) {
				// 异常总经理的总经理岗
				boolean isGm = empMapper.isOtherCompanyGeneralManager(orgCd, gm.getId()) > 0 ? true : false;
				if (!isGm) {
					//从人员岗位中移除岗位信息
					peMapper.removeEmpPost(gm.getId(), gmp.getId());
				}
				// 移除公司的总经理
				mapper.setGeneralManager(orgCd, null);

			}
		}

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#assignDeparemntLeadership(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public void assignDeparemntLeadership(String orgCd, String empCd) throws AppException {
		//获取组织机构
		Organization org = mapper.findOrgByOrgCd(orgCd);
		if (OrgCategoryEnum.BRANCH.name().equalsIgnoreCase(org.getOrgType())
				|| OrgCategoryEnum.SUB.name().equalsIgnoreCase(org.getOrgType())
				|| OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getOrgType())) {
			//分管领导岗位
			Post leadershipPost = postMapper.findPostByPostType(PostCategoryEnum.LSPost.name());
			//员工升迁分管领导
			Employee emp = employeeService.promotion(orgCd, empCd, EmpCategoryEnum.LEADERSHIP);
			//原分管领导
			String oldLeadershipId = org.getLeadershipId();
			if (ObjectHelper.isNotEmpty(oldLeadershipId)) {
				Employee oldLsp = empMapper.findEmployeeById(oldLeadershipId);
				if (ObjectHelper.isNotEmpty(oldLsp) && (EmpCategoryEnum.CHAIRMAN.name().equals(oldLsp.getEmpType())
						|| EmpCategoryEnum.GENERALMANAGER.name().equals(oldLsp.getEmpType()))) {
					// 如果是董事长或总经理，则判断是否还担任除当前部门外的其他部门的分管领导
					boolean isLeader = empMapper.isOtherCompanyLeadership(orgCd, oldLeadershipId) > 0 ? true : false;
					if (!isLeader) {
						// 如果不再担任其它部门分管领导，则异常分管领导岗
						peMapper.removeEmpPost(oldLeadershipId, leadershipPost.getId());
					}
				}
			}
			//新分管领导追加分管领导岗位
			long pe = peMapper.findPostEmpByCondition(emp.getId(), leadershipPost.getId());
			if (pe < 1) {
				peMapper.addPostEmp(new PostEmp(RandomHelper.uuid(), emp.getId(), leadershipPost.getId(), 1));
			}
			//机构设置分管领导
			mapper.setLeadership(orgCd, emp.getId());

		}

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#removeDepartmentLeadership(java.lang.String)
	 */
	@Override
	@Transactional
	public void removeDepartmentLeadership(String orgCd) throws AppException {
		Organization org = mapper.findOrgByOrgCd(orgCd);
		if (ObjectHelper.isNotEmpty(org) && (OrgCategoryEnum.BRANCH.name().equalsIgnoreCase(org.getOrgType())
				|| OrgCategoryEnum.SUB.name().equalsIgnoreCase(org.getOrgType())
				|| OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getOrgType()))) {
			// 获取分管领导岗位
			Post lmp = postMapper.findPostByPostType(PostCategoryEnum.LSPost.name());
			//分管领导
			Employee lm = empMapper.findEmployeeById(org.getLeadershipId());
			if (ObjectHelper.isNotEmpty(lm)) {
				// 异常分管领导的分管领导岗
				boolean isLeader = empMapper.isOtherCompanyLeadership(orgCd, lm.getId()) > 0 ? true : false;
				if (!isLeader) {
					//从人员岗位中移除岗位信息
					peMapper.removeEmpPost(lm.getId(), lmp.getId());
				}
			}
			// 移除公司的分管领导
			mapper.setLeadership(orgCd, null);
		}

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#assignDeparmentManager(java.lang.String)
	 */
	@Override
	@Transactional
	public void assignDeparmentManager(String orgCd, String empCd) throws AppException {
		Organization org = mapper.findOrgByOrgCd(orgCd);
		// 获取部门主管岗位
		Post lmp = postMapper.findPostByPostType(PostCategoryEnum.DMPost.name());
		Employee emp = empMapper.findEmployeeByEmpCd(empCd);

		// 卸任原主管
		String oldDeptMgrId = org.getManagerId();
		if (ObjectHelper.isNotEmpty(oldDeptMgrId)) {
			Employee oldDeptMgr = empMapper.findEmployeeById(oldDeptMgrId);
			if (ObjectHelper.isNotEmpty(oldDeptMgr)) {
				boolean isMgr = empMapper.isOtherDeptManager(orgCd, oldDeptMgrId) > 0 ? true : false;
				if (isMgr) {
					// 如果原主管不再任任何部门主管，则移除其部门主管岗位
					peMapper.removeEmpPost(oldDeptMgrId, lmp.getId());
				}
			}
		}
		//新部门主管追加部门主管岗位
		long pe = peMapper.findPostEmpByCondition(emp.getId(), lmp.getId());
		if (pe < 1) {
			peMapper.addPostEmp(new PostEmp(RandomHelper.uuid(), emp.getId(), lmp.getId(), 1));
		}
		//机构设置部门主管
		mapper.setDeptManager(orgCd, emp.getId());
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#removeDepartmentManager(java.lang.String)
	 */
	@Override
	@Transactional
	public void removeDepartmentManager(String orgCd) throws AppException {
		Organization org = mapper.findOrgByOrgCd(orgCd);
		if (ObjectHelper.isNotEmpty(org) && ObjectHelper.isNotEmpty(org.getManagerId())) {
			//部门主管
			Employee lm = empMapper.findEmployeeById(org.getManagerId());
			// 获取部门主管岗位
			Post lmp = postMapper.findPostByPostType(PostCategoryEnum.DMPost.name());
			// 异常部门主管的部门主管岗
			boolean isMgr = empMapper.isOtherDeptManager(orgCd, lm.getId()) > 0 ? true : false;
			if (!isMgr) {
				//从人员岗位中移除岗位信息
				peMapper.removeEmpPost(lm.getId(), lmp.getId());
			}
			// 移除公司的部门主管
			mapper.setDeptManager(orgCd, null);
		}

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#assignDeputyManagers(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public void assignDeputyManagers(String orgCd, String empCd) throws AppException {
		Organization org = mapper.findOrgByOrgCd(orgCd);
		// 获取部门副主管岗位
		Post lmp = postMapper.findPostByPostType(PostCategoryEnum.DDMPost.name());
		Employee emp = empMapper.findEmployeeByEmpCd(empCd);

		// 卸任原副主管
		String oldDeptDeputyId = org.getDeptDeputyId();
		if (ObjectHelper.isNotEmpty(oldDeptDeputyId)) {
			Employee oldDeptDeputyr = empMapper.findEmployeeById(oldDeptDeputyId);
			if (ObjectHelper.isNotEmpty(oldDeptDeputyr)) {
				boolean isDd = empMapper.isOtherDeptDeputy(orgCd, oldDeptDeputyId) > 0 ? true : false;
				if (isDd) {
					// 如果原副主管不再任任何部门副主管，则移除其部门副主管岗位
					peMapper.removeEmpPost(oldDeptDeputyId, lmp.getId());
				}
			}
		}
		//新部门主管追加部门副主管岗位
		long pe = peMapper.findPostEmpByCondition(emp.getId(), lmp.getId());
		if (pe < 1) {
			peMapper.addPostEmp(new PostEmp(RandomHelper.uuid(), emp.getId(), lmp.getId(), 1));
		}
		//机构设置部门副主管
		mapper.setDeptDeputy(orgCd, emp.getId());
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#removeDeputyManager(java.lang.String)
	 */
	@Override
	@Transactional
	public void removeDeputyManager(String orgCd) throws AppException {
		Organization org = mapper.findOrgByOrgCd(orgCd);
		if (ObjectHelper.isNotEmpty(org) && ObjectHelper.isNotEmpty(org.getDeptDeputyId())) {
			//部门副主管
			Employee lm = empMapper.findEmployeeById(org.getDeptDeputyId());
			// 获取部门副主管岗位
			Post lmp = postMapper.findPostByPostType(PostCategoryEnum.DDMPost.name());
			// 异常部门副主管的部门副主管岗
			boolean isDd = empMapper.isOtherDeptDeputy(orgCd, lm.getId()) > 0 ? true : false;
			if (!isDd) {
				//从人员岗位中移除岗位信息
				peMapper.removeEmpPost(lm.getId(), lmp.getId());
			}
			// 移除公司的部门副主管
			mapper.setDeptDeputy(orgCd, null);
		}

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#assignChairman(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public void assignChairman(String orgCd, String empCd) throws AppException {
		//获取董事长岗位
		Post chairmanPost = postMapper.findPostByPostType(PostCategoryEnum.CMPost.name());
		//机构信息
		Organization org = mapper.findOrgByOrgCd(orgCd);
		//员工升迁为董事长
		Employee emp = employeeService.promotion(orgCd, empCd, EmpCategoryEnum.CHAIRMAN);
		//原有董事长
		String oldChairmanId = null;
		if (OrgCategoryEnum.HEAD.name().equalsIgnoreCase(org.getOrgType())
				|| OrgCategoryEnum.SUB.name().equalsIgnoreCase(org.getOrgType())) {
			//获取原董事长
			if (ObjectHelper.isNotEmpty(org)) {
				oldChairmanId = org.getChairmanId();
			}
			//机构设置董事长
			mapper.setChairman(orgCd, empCd);
		}
		//移除原董事长的董事长岗位
		if (ObjectHelper.isNotEmpty(oldChairmanId)) {
			peMapper.removeEmpPost(oldChairmanId, chairmanPost.getId());
		}

		//新董事长追加董事长岗位
		long pe = peMapper.findPostEmpByCondition(emp.getId(), chairmanPost.getId());
		if (pe < 1) {
			peMapper.addPostEmp(new PostEmp(RandomHelper.uuid(), emp.getId(), chairmanPost.getId(), 1));
		}

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#removeChairman(java.lang.String)
	 */
	@Override
	@Transactional
	public void removeChairman(String orgCd) throws AppException {// 获取机构
		Organization org = mapper.findOrgByOrgCd(orgCd);

		if (ObjectHelper.isNotEmpty(org) && ObjectHelper.isNotEmpty(org.getChairmanId())) {
			//董事长
			Employee cm = empMapper.findEmployeeById(org.getChairmanId());
			// 获取董事长岗位
			Post cmp = postMapper.findPostByPostType(PostCategoryEnum.CMPost.name());

			if (OrgCategoryEnum.HEAD.name().equals(org.getOrgType())
					|| OrgCategoryEnum.SUB.name().equals(org.getOrgType())) {

				//是否是其他公司的董事长 
				boolean isCm = empMapper.isOtherCompanyChairman(orgCd, cm.getId()) > 0 ? true : false;
				if (!isCm) {
					//从人员岗位中移除岗位信息
					peMapper.removeEmpPost(cm.getId(), cmp.getId());
				}
				// 移除公司的董事长
				mapper.setChairman(orgCd, null);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#createOrg(com.studio.framework.beans.ess.Organization)
	 */
	@Override
	@Transactional
	public Organization createOrg(Organization org) throws AppException {
		String id = RandomHelper.uuid();
		org.setId(id);
		org.setOrgCd(id);
		org.setSuperOrgId(org.getSuperOrgCd());
		if (ObjectHelper.isEmpty(org.getSuperOrgCd())) {
			mapper.createOrg(org);
		} else {
			mapper.createChildOrg(org);
		}
		return org;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#modifyOrg(com.studio.framework.beans.ess.Organization)
	 */
	@Transactional
	public Organization modifyOrg(Organization org) throws AppException {
		mapper.modifyOrg(org);
		return org;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#getHeadOrg()
	 */
	@Override
	@Transactional(readOnly = true)
	public Organization getHeadOrg() throws AppException {
		return mapper.getHeadOrg();
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#findOrgByOrgCd(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Organization findOrgByOrgCd(String orgCd) throws AppException {
		Organization org = mapper.findOrgByOrgCd(orgCd);
		org.setOrgTypeNm(OrgCategoryEnum.getLabel(org.getOrgType()));
		org.setOrgDutyNm(categoryService.findCategoryAttrNm("002", org.getOrgDuty()));
		return org;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#findSubOrgs(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Organization> findSubOrgsByOrgCd(String orgCd) throws AppException {
		return mapper.findSubOrgsByOrgCd(orgCd);
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IOrganizationService#removeOrg(java.lang.String)
	 */
	@Override
	@Transactional
	public void removeOrg(String orgCd) throws AppException {
		if (ObjectHelper.isNotEmpty(empMapper.findEmployeesByOrgCd(orgCd))) {
			throw new DeleteRefusedException("该机构有供职人员，请移除员工后删除!");
		}
		mapper.removeOrg(orgCd);
	}

}
