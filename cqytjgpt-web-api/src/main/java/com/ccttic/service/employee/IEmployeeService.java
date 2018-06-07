package com.ccttic.service.employee;

import java.util.List;

import com.ccttic.entity.common.exception.AppException;
import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeeVo;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;



/**
   功能说明：     人员业务接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.IEmployeeService.java
 @date  2016年12月4日
 */

public interface IEmployeeService {

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
	public Employee login(String account, String password) ;

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
			List<String> postCds, Pageable page);

	/**
	 * 添加员工
	 * @param emp
	 * @return
	 * @throws AppException
	 */
	public void addEmployee(EssEmployeeVo emp) throws Exception ;

	/**
	 * 修改员工
	 * @param emp
	 * @return
	 * @throws AppException
	 */
	public void editEmployee(EssEmployeeVo emp)  throws Exception;



	







	/**
	 * 通过人员编号获取岗位
	 * @param empId
	 * @return
	 * @throws AppException
	 */
	public List<RoleEmp> findRolesByEmpId(String empId) ;

	/**
	 * 获取员工列表
	 * @param page
	 * @param emp
	 * @return
	 * @throws Exception
	 */
	public Page<EssEmployeeVo> selectEmployee(Pageable page, EssEmployeeVo emp) throws Exception ;

	/**修改员工密码
	 * @param emp
	 * @return
	 */
	public void modifyPassword(EssEmployee emp) throws Exception;
	
	public void delEmployee(List<EssEmployee> emps) throws Exception;


}
