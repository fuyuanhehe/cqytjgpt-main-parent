package com.ccttic.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.auth.model.Organization;

/**
   功能说明：     myBatis机构映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月12日
 */

public interface OrganizationMapper {

	/**
	 * 获取总公司
	 * @return
	 */
	public Organization getHeadOrg();

	/**
	 * 通过ID获取组织机构
	 * @param orgId
	 * @return
	 */
	public Organization findOrgById(@Param("orgId") String orgId);

	/**
	 * 创建组子织机构
	 * @param org
	 */
	public void createChildOrg(@Param("org") Organization org);

	/**
	 * 创建组织机构
	 * @param org
	 */
	public void createOrg(@Param("org") Organization org);

	/**
	 * 通过编号获取组织机构
	 * @param orgCd
	 * @return
	 */
	public Organization findOrgByOrgCd(@Param("orgCd") String orgCd);

	/**
	 * 通过机构编码获取子机构
	 * @param orgCd
	 * @return
	 */

	public List<Organization> findSubOrgsByOrgCd(@Param("orgCd") String orgCd);

	/**
	 * 修改组织机构
	 * @param org
	 */
	public void modifyOrg(@Param("org") Organization org);

	/**
	 * 删除组织机构资料
	 * @param orgCd
	 */
	public void removeOrg(@Param("orgCd") String orgCd);

	/**
	 * 设置公司管理人员
	 * @param orgId
	 * @param empId
	 */
	public void setCompanyAdmin(@Param("orgId") String orgId, @Param("empId") String empId);

	/**
	 * 机构董事长设置
	 * @param orgCd
	 * @param empId
	 */
	public void setChairman(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 机构总经理设置
	 * @param orgCd
	 * @param empId
	 */
	public void setGeneralManager(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 机构分管领导设置
	 * @param orgCd
	 * @param empId
	 */
	public void setLeadership(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 机构主管设置
	 * @param orgCd
	 * @param empId
	 */
	public void setDeptManager(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 机构副主管设置
	 * @param orgCd
	 * @param empId
	 */
	public void setDeptDeputy(@Param("orgCd") String orgCd, @Param("empId") String empId);

}
