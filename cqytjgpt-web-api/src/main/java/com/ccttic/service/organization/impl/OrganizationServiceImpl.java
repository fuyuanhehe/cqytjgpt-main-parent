package com.ccttic.service.organization.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccttic.entity.common.exception.AppException;
import com.ccttic.entity.common.exception.DeleteRefusedException;
import com.ccttic.entity.role.Organization;
import com.ccttic.mapper.organization.DepartmentMapper;
import com.ccttic.mapper.organization.OrganizationMapper;
import com.ccttic.service.organization.IOrganizationService;
import com.ccttic.util.common.ObjectHelper;

@Service
public class OrganizationServiceImpl implements IOrganizationService{
	
	@Resource
	private OrganizationMapper mapper;
	@Resource
	private DepartmentMapper mentMapper;
	
	@Override
	public Organization getHeadOrg() throws AppException {
		return mapper.getHeadOrg();
	}

	@Override
	public List<Organization> findNextNode(String orgCd) throws AppException {
		return mapper.findNextNode(orgCd);
	}

	@Override
	public Organization findOrgByOrgCd(String orgCd) throws AppException {
		return mapper.findOrgByOrgCd(orgCd);
	}

	@Override
	public Organization createOrg(Organization org, String id) throws AppException {
		org.setId(id);
		org.setOrgCd(id);
		org.setSuperOrgId(org.getSuperOrgCd());
		if (ObjectHelper.isEmpty(org.getSuperOrgCd())) {// 如果没有父id则是在创建机构
			mapper.createOrg(org);
		} else {
			mapper.createChildOrg(org);
		}
		return org;
	}

	@Override
	public Organization editOrg(Organization org) throws AppException {
		mapper.editOrg(org);
		return org;
	}

	@Override
	public void removeOrg(String orgCd,String orgType) throws AppException {
		if (orgType.equals("1")) { // 分所
			if (ObjectHelper.isNotEmpty(mapper.findNextNode(orgCd))) {
				throw new DeleteRefusedException("该机构有下级机构，请移除下级机构后删除!");
			}
		} else if (orgType.equals("2")) { // 区县所
			if (ObjectHelper.isNotEmpty(mentMapper.findOrgDepartment(orgCd))) {
				throw new DeleteRefusedException("该机构有挂靠部门，请移除部门后删除!");
			}
			// TODO 人员表未加关联 select emp.*,org.id as orgId, org.orgCd as orgCd, org.orgNm as orgNm from ess_employee emp left join ess_organization org on emp.org_id = org.id where org.orgCd=#{orgCd} and (emp.isDeleted = 0 or emp.isDeleted is null)
			if (ObjectHelper.isNotEmpty(mentMapper.findOrgDepartment(orgCd))) {
				throw new DeleteRefusedException("该机构的部门有供职人员，请移除员工后删除!");
			}
		}
		
		mapper.removeOrg(orgCd);
	}

}
