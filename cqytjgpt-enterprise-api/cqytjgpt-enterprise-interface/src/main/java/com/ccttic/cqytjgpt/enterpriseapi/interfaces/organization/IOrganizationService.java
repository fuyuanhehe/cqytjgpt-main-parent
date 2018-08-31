package com.ccttic.cqytjgpt.enterpriseapi.interfaces.organization;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.enterprise.vo.AccoutVo;
import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.OrgEmpCombine;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.exception.AppException;

public interface IOrganizationService {
	
	/**
	 * 获取机构头
	 * @return
	 * @throws AppException
	 * @param map
	 */
	Organization getHeadOrg(Map<String, String> map) throws AppException;
	
	/**
	 * 获取机构头下拉框用
	 * @return
	 * @throws AppException
	 */
	Organization getHeadOrgList() throws AppException;
	
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
	/**
	 *@Author:zhy
	 *@Description:根据组织type和id获取组织集合
	 *@Date:11:24 2018/7/30
	 */
	List<Organization> getOrgByTypeAndId(String id,String type)throws AppException ;
	
	AccoutVo getAccountOrgId (String account);
}
