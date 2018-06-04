package com.ccttic.service.organization;

import java.util.Map;

import com.ccttic.common.exception.AppException;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IDepartmentService {

	/**
	 * 通过机构代码获取部门信息
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	public Page<Map<String, Object>> findOrgDepartmentList(Pageable page, Department tment,String orgCd) throws AppException;
	/**
	 * 创建部门
	 * @param ment
	 * @param id
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	Department createMent(Department ment, String id,String orgCd) throws AppException;
	
	/**
	 * 修改部门
	 * @param ment
	 * @return
	 * @throws AppException
	 */
	Department modifyMent(Department ment) throws AppException;
	
	/**
	 * 删除部门
	 * @param orgCd
	 * @throws AppException
	 */
	void removeMent(String orgCd,String id) throws AppException;
	
	/**
	 * 创建企业
	 * @param rise
	 * @param id
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	Enterprise createRise(Enterprise rise, String id,String orgCd) throws AppException;
}