package com.ccttic.auth.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.page.Page;
import com.ccttic.auth.common.page.Pageable;
import com.ccttic.auth.model.EmpCategoryEnum;
import com.ccttic.auth.model.EmpMenu;
import com.ccttic.auth.model.Employee;
import com.ccttic.auth.model.RoleEmp;
import com.ccttic.auth.model.RoleMenu;

/**
   功能说明：     人员业务接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.IEmployeeService.java
 @date  2016年12月4日
 */

public interface IEmployeeService {
	/**
	 * 员工升迁
	 * @param orgCd
	 * @param empCd
	 * @param empType
	 * @return
	 * @throws AppException
	 */
	public Employee promotion(String orgCd, String empCd, EmpCategoryEnum empType) throws AppException;

	/**
	 * 根据ID查询人员
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Employee findEmployeeById(String id) throws AppException;

	/**
	 * 根据账号查找用户
	 * @param account
	 * @return
	 */
	public Employee findEmployeeByAccount(String account);
	
	/**
	 * 用户登录
	 * @param account
	 * @param password
	 * @return
	 * @throws AppException
	 */
	public Employee login(String account, String password) throws AppException;

	/**
	 * 分页显示员工
	 * @param involveAllSubOrgs
	 * @param orgCd
	 * @param empNm
	 * @param account
	 * @param postCds
	 * @param page
	 * @return
	 * @throws AppException
	 */
	public Page<Employee> findEmployees(boolean involveAllSubOrgs, String orgCd, String empNm, String account,
			List<String> postCds, Pageable page) throws AppException;

	/**
	 * 添加员工
	 * @param emp
	 * @return
	 * @throws AppException
	 */
	public Employee addEmployee(Employee emp) throws AppException;

	/**
	 * 修改员工
	 * @param emp
	 * @return
	 * @throws AppException
	 */
	public Employee editEmployee(Employee emp) throws AppException;

	/**
	 * 通过人员编号删除员工信息
	 * @param empCd
	 * @throws AppException
	 */
	public void removeEmployee(String empCd) throws AppException;

	/**
	 * 通过人员编号获取人员
	 * @param empCd
	 * @return
	 * @throws AppException
	 */
	public Employee findEmployeeByEmpCd(String empCd) throws AppException;

	/**
	 * 密码设置
	 * @param emp
	 * @throws AppException
	 */
	public void setPassword(Employee emp) throws AppException;

	/**
	 * 获得公司管理人员
	 * @param orgCd
	 * @return
	 * @throws AppException
	 */
	public Employee getCompanyAdmin(String orgCd) throws AppException;

	/**
	 * 移除管理员
	 * @param orgCd
	 * @throws AppException
	 */
	public void removeAdmin(String orgCd) throws AppException;

	/**
	 * 更新管理员
	 * @param admin
	 * @return
	 * @throws AppException
	 */
	public Employee editAdmin(Employee admin) throws AppException;

	/**
	 * 任命管理人员
	 * @param admin
	 * @return
	 * @throws AppException
	 */
	public Employee assignAdmin(Employee admin) throws AppException;

	/**
	 * 获取公司领导
	 * @param orgCd
	 * @param empCategory
	 * @return
	 * @throws AppException
	 */
	public List<Employee> getCompanyLeadership(String orgCd, EmpCategoryEnum empCategory) throws AppException;

	/**
	 * 设置人员资源权限
	 * @param empId
	 * @param menuIds
	 * @throws AppException
	 */
	public void setEmpResource(String empId, String[] menuIds) throws AppException;

	/**
	 * 获取人员已有权限菜单
	 * @param empId 
	 * @return
	 * @throws AppException
	 */
	public List<EmpMenu> findEmpResources(String empId) throws AppException;

	/**
	 * 获取角色已有权限菜单
	 * @param roleId
	 * @return
	 * @throws AppException
	 */
	public List<RoleMenu> findRoleResources(String roleId) throws AppException;

	/**
	 * 设置角色资源权限
	 * @param roleId
	 * @param menuIds
	 * @throws AppException
	 */
	public void setRoleResource(String roleId, String[] menuIds) throws AppException;

	/**
	 * 通过人员编号获取岗位
	 * @param empId
	 * @return
	 * @throws AppException
	 */
	public List<RoleEmp> findRolesByEmpId(String empId) throws AppException;

}
