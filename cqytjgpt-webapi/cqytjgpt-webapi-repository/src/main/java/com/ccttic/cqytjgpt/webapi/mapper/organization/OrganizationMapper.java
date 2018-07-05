package com.ccttic.cqytjgpt.webapi.mapper.organization;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.OrgEmpCombine;
import com.ccttic.entity.role.Organization;

public interface OrganizationMapper {

	/**
	 * 获取机构
	 * @return
	 */
	public Organization getHeadOrg();
	
	/**
	 * 通过机构编码获取子机构
	 * @param orgCd
	 * @return
	 */

	public List<Organization> findNextNode(@Param("orgCd") String orgCd);
	
	/**
	 * 通过机构编码获取该机构信息
	 * @param orgCd
	 * @return
	 */

	public OrgEmpCombine findOrgByOrgCd(@Param("orgCd") String orgCd);
	
	/**
	 * 创建组织机构
	 * @param org
	 */
	public void createOrg(@Param("org") Organization org);
	
	/**
	 * 创建组子织机构
	 * @param org
	 */
	public void createChildOrg(@Param("org") Organization org);
	
	/**
	 * 修改组织机构
	 * @param org
	 */
	public void editOrg(@Param("org") Organization org);
	
	/**
	 * 删除组织机构
	 * @param orgCd
	 */
	public void removeOrg(@Param("orgCd") String orgCd);

	/**
	 * 获取行政区域编码
	 * @return
	 */

	public List<Area> getArea();
	
	/**
	 * 通过企业id获取组织信息
	 * @param id
	 * @return
	 */
	public Organization findOrgByEptId(@Param("id") String id);
	
	/**获取所有组织信息
	 * @return
	 */
	public List<Organization> getAllOrg();
	
	/**通过第二层的组织获得最底层组织
	 * @param id
	 * @return
	 */
	public List<Organization> getLastOrg(@Param("id") String id);
	
	/**
	 * 获取所有最下层组织
	 * @param id
	 * @return
	 */
	public List<Organization> getAllLastOrg();

	/**通过adminid获取组织id
	 * @param id
	 * @return
	 */
	public Organization getOrgByAdminId(String id);
	
	public List<Department> getAllDepart(@Param("orgId") String orgId);
	
	
}
