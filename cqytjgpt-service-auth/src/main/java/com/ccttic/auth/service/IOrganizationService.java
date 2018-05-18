package com.ccttic.auth.service;

import java.util.List;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.model.Organization;

/**
   功能说明：     机构业务接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.IOrganizationService.java
 @date  2016年12月12日
 */

public interface IOrganizationService {

	/**
	 * 通过ID获取机构类型为公司的机构
	 * @param orgId
	 * @return
	 * @throws AppExeption
	 */
	Organization getCompanyByOrgId(String orgId) throws AppException;

	/**
	 * 获取公司总公司
	 * @return
	 * @throws AppException
	 */
	Organization getHeadOrg() throws AppException;

	/**
	 * 创建组织机构
	 * @param org
	 * @return
	 * @throws AppException
	 */
	Organization createOrg(Organization org) throws AppException;

	/**
	 * 通过机构代码获取机构信息
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	Organization findOrgByOrgCd(String orgCd) throws AppException;

	/**
	 * 通过机构代码获取子机构信息
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	List<Organization> findSubOrgsByOrgCd(String orgCd) throws AppException;

	/**
	 * 修改组织机构
	 * @param org
	 * @return
	 * @throws AppException
	 */
	Organization modifyOrg(Organization org) throws AppException;

	/**
	 * 删除组织机构
	 * @param orgCd
	 * @throws AppException
	 */
	void removeOrg(String orgCd) throws AppException;

	/**
	 * 卸任董事长
	 * @param orgCd
	 * @throws AppException
	 */
	void removeChairman(String orgCd) throws AppException;

	/**
	 * 卸任总经理
	 * @param orgCd
	 * @throws AppException
	 */
	void removeGeneralManager(String orgCd) throws AppException;

	/**
	 * 卸任分管领导
	 * @param orgCd
	 * @throws AppException
	 */
	void removeDepartmentLeadership(String orgCd) throws AppException;

	/**
	 * 卸任部门主管
	 * @param orgCd
	 * @throws AppException
	 */
	void removeDepartmentManager(String orgCd) throws AppException;

	/**
	 * 卸任部门副主管
	 * @param orgCd
	 * @throws AppException
	 */
	void removeDeputyManager(String orgCd) throws AppException;

	/**
	 * 任命董事长
	 * @param orgCd
	 * @param empCd
	 * @throws AppException
	 */
	void assignChairman(String orgCd, String empCd) throws AppException;

	/**
	 * 任命总经理
	 * @param orgCd
	 * @param empCd
	 * @throws AppException
	 */
	void assignGeneralManager(String orgCd, String empCd) throws AppException;

	/**
	 * 任命分管领导
	 * @param orgCd
	 * @param empCd
	 * @throws AppException
	 */
	void assignDeparemntLeadership(String orgCd, String empCd) throws AppException;

	/**
	 * 任命主管
	 * @param orgCd
	 * @param empCd 
	 * @throws AppException
	 */
	void assignDeparmentManager(String orgCd, String empCd) throws AppException;

	/**
	 * 任命部门副主管
	 * @param orgCd
	 * @param empCd
	 * @throws AppException
	 */
	void assignDeputyManagers(String orgCd, String empCd) throws AppException;

}
