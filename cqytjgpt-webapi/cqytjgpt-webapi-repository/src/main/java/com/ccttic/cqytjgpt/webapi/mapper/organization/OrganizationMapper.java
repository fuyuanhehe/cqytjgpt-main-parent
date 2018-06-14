package com.ccttic.cqytjgpt.webapi.mapper.organization;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.OrgEmpCombine;
import com.ccttic.entity.role.Organization;

public interface OrganizationMapper {

	/**
	 * 获取树头
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
	
}
