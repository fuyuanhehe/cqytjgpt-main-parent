package com.ccttic.cqytjgpt.webapi.mapper.organization;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.DepartmentEnterpriseCombine;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.util.exception.AppException;

public interface DepartmentMapper {
	/**
	 * 通过机构编码获取部门信息
	 * @param orgCd
	 * @return
	 */

	public List<Department> findOrgDepartment(@Param("orgCd") String orgCd);
	
	/**
	 * 
	 * 根据条件获取部门信息总记录数
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryDepartmentListCount(Map<String, Object> params) throws AppException;
	
	/**
	 * 根据条件获取部门信息
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public List<Department> qryDepartmentList(Map<String, Object> params) throws AppException;
	
	/**
	 * 创建部门
	 * @param org
	 */
	public void createMent(@Param("ment") Department ment);
	
	/**
	 * 修改部门
	 * @param ment
	 */
	public void modifyMent(@Param("ment") Department ment);
	
	/**
	 * 删除部门
	 * @param id
	 */
	public void removeMent(@Param("id") String id);
	
	/**
	 * 创建企业
	 * @param rise
	 */
	public void createRise(@Param("rise") Enterprise rise);
	
	/**
	 * 根据部门id查询该部门是否有在职人员
	 * @param id
	 * @return
	 */
	public List<DepartmentEnterpriseCombine> finByDepEmpId(@Param("id") String id);
}
