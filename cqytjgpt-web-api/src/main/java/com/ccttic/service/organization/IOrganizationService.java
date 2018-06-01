package com.ccttic.service.organization;

import java.util.List;

import com.ccttic.common.exception.AppException;
import com.ccttic.entity.role.Organization;

public interface IOrganizationService {
	
	/**
	 * 获取树头
	 * @return
	 * @throws AppException
	 */
	Organization getHeadOrg() throws AppException;
	
	/**
	 * 通过机构代码获取子机构信息
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	List<Organization> findNextNode(String orgCd) throws AppException;
	
	/**
	 * 通过机构代码获取该机构信息
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	Organization findOrgByOrgCd(String orgCd) throws AppException;
	
	/**
	 * 创建组织机构
	 * @param org
	 * @return
	 * @throws AppException
	 */
	Organization createOrg(Organization org, String id) throws AppException;
	
	/**
	 * 修改组织机构
	 * @param org
	 * @return
	 * @throws AppException
	 */
	Organization editOrg(Organization org) throws AppException;
	
	/**
	 * 删除组织机构
	 * @param orgCd
	 * @throws AppException
	 */
	void removeOrg(String orgCd,String orgType) throws AppException;
}
