package com.ccttic.cqytjgpt.enterpriseapi.interfaces.employee;

import com.ccttic.entity.employee.*;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

import java.util.List;


/**
 * 功能说明：     人员业务接口
 *
 * @author xgYin
 * @version 1.0.0
 * @date 2016年12月4日
 */

public interface IEmployeeService {

	/**
	 * 根据账号查找用户
	 *
	 * @param account
	 * @return
	 */
	public EmployeeVo findEmployeeByAccount(String account) throws AppException;

	/**
	 * 用户登录
	 *
	 * @param account
	 * @param password
	 * @return
	 * @throws AppException
	 */
	public Employee login(String account, String password);

	/**
	 * 通过人员编号获取岗位
	 *
	 * @param empId
	 * @return
	 */
	public List<RoleEmp> findRolesByEmpId(String empId);

	/**
	 * 获取员工列表
	 *
	 * @param page
	 * @param emp
	 * @return
	 * @throws AppException
	 */
	public Page<EssEmployeeVo> selectEmployee(Pageable page, EssEmployeeVo emp) throws AppException;

	/**
	 * 修改员工密码
	 *
	 * @param emp
	 * @return
	 */
	public void modifyPassword(List<EssEmployee> emp) throws AppException;

	/**
	 * 删除员工
	 *
	 * @param emp
	 * @throws Exception
	 */
	public void delEmployee(EssEmployeeVo emp) throws AppException;

	/**
	 * @Author:zhy
	 * @Description:通过token获取用户信息
	 * @Date:16:03 2018/7/9
	 */
	public EmployeeVo getUserInfo(String access_token);

	/**
	 * @Author:zhy
	 * @Description:
	 * @Date:15:31 2018/7/10
	 */
	int selectEmpByAccount(String account) throws AppException;

	/**
	 * @Author:zhy
	 * @Description:通过部门id获取旗下的员工
	 * @Date:11:04 2018/7/13
	 */
	List<EssEmployeeVo> selectEmployeeByDepartment(String depid, String empnm, String orgCd) throws AppException;

	EmployeePermission getEmployeePermission(EmployeeVo employee);

	void addEmployee(EssEmployeeVo emp) throws AppException;
}
