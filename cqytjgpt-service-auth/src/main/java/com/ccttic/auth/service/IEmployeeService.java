package com.ccttic.auth.service;

import java.util.List;

import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.util.exception.AppException;

/**
   功能说明：     人员业务接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.IEmployeeService.java
 @date  2016年12月4日
 */

public interface IEmployeeService {

	/**
	 * 根据账号查找用户
	 * @param account
	 * @return
	 */
	public Employee findEmployeeByAccount(String account);
	
	
	/**
	 * 通过人员编号获取岗位
	 * @param empId
	 * @return
	 * @throws AppException
	 */
	public List<RoleEmp> findRolesByEmpId(String empId) throws AppException;

}
