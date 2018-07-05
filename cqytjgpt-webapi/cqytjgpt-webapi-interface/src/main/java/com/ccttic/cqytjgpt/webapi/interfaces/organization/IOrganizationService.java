package com.ccttic.cqytjgpt.webapi.interfaces.organization;

import java.util.List;

import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.OrgEmpCombine;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.exception.AppException;

public interface IOrganizationService {
	
	/**
	 * 获取机构
	 * @return
	 * @throws AppException
	 */
	List<Organization> getHeadOrg() throws AppException;
	
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
	OrgEmpCombine findOrgByOrgCd(String orgCd) throws AppException;
	
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
	
	/**
	 * 获取行政区域编码
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	List<Area> getArea() throws AppException;
}
