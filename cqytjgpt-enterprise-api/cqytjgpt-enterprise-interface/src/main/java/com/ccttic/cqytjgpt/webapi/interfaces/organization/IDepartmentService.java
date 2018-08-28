package com.ccttic.cqytjgpt.webapi.interfaces.organization;

import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IDepartmentService {

	/**
	 * 通过机构代码获取部门信息
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	public Page<Department> findOrgDepartmentList(Pageable page, Department tment) throws AppException;
	/**
	 * 创建部门
	 * @param ment
	 * @param id
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	int createMent(Department ment);
	
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
	int removeMent(String id) throws AppException;
	
	/**
	 * 创建企业
	 * @param rise
	 * @param id
	 * @return
	 * @throws AppException
	 */
	Enterprise createRise(Enterprise rise, String id) throws AppException;
}
