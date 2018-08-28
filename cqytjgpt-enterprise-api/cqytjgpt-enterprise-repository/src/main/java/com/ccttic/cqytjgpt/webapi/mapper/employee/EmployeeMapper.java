package com.ccttic.cqytjgpt.webapi.mapper.employee;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.Employee;


/**
   功能说明：     MyBatis人员映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月3日
 */

public interface EmployeeMapper {
	/**
	 * 根据ID查询人员
	 * @param id
	 * @return
	 */
	public Employee findEmployeeById(@Param("id") String id);
	
	/**
	 * 根据账号查询人员
	 * @param account
	 * @return
	 */
	public Employee findEmployeeByAccount(@Param("account") String account);

	/**
	 * 用户登录
	 * @param account
	 * @param password
	 * @return
	 */
	public Employee login(@Param("account") String account, @Param("password") String password);

	/**
	 * 获取用户总记录数
	 * @param params
	 * @return
	 */
	public long counEmployee(Map<String, Object> params);

	/**
	 * 分页显示用户记录数
	 * @param params
	 * @return
	 */
	public List<Employee> pagerEmployee(Map<String, Object> params);

	/**
	 * 添加用户
	 * @param emp
	 */
	public void addEmployee(@Param("emp") Employee emp);

	/**
	 * 修改用户
	 * @param emp
	 */
	public void editEmployee(@Param("emp") Employee emp);

	/**
	 * 通过人员编号获取人员信息
	 * @param empCd
	 * @return
	 */
	public Employee findEmployeeByEmpCd(@Param("empCd") String empCd);

	/**
	 * 通过员工ID判断是否为领导
	 * @param empId
	 * @return
	 */
	public long isManagement(@Param("empId") String empId);

	/**
	 * 通过员工编号逻辑删除人员信息
	 * @param empCd
	 */
	public void removeEmployee(@Param("empCd") String empCd);

	/**
	 * 密码设置
	 * @param emp
	 */
	public void setPassword(@Param("emp") Employee emp);

	/**
	 * 该组织机构是包含人员
	 * @param orgCd
	 * @return
	 */
	public List<Employee> findEmployeesByOrgCd(@Param("orgCd") String orgCd);

	/**
	 * 指定人员是否是其他公司董事长
	 * @param orgCd
	 * @param empId
	 * @return
	 */
	public long isOtherCompanyChairman(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 指定人员是否是其他公司总经理
	 * @param orgCd
	 * @param empId
	 * @return
	 */
	public long isOtherCompanyGeneralManager(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 指定人员是否是其他公司分管领导
	 * @param orgCd
	 * @param id
	 * @return
	 */
	public long isOtherCompanyLeadership(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 指定人员是否是其他部门主管
	 * @param orgCd
	 * @param id
	 * @return
	 */
	public long isOtherDeptManager(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 指定人员是否是其他部门父主管
	 * @param orgCd
	 * @param id
	 * @return
	 */
	public long isOtherDeptDeputy(@Param("orgCd") String orgCd, @Param("empId") String empId);

	/**
	 * 根据机构查找董事长、领导、总经理
	 * @param params
	 * @return
	 */
	public List<Employee> findCompanyLeaders(Map<String, Object> params);

	/**
	 * 员工升迁为指定机构指定类型的员工 
	 * @param orgCd
	 * @param empCd
	 * @param empType
	 */
	public void promotion(@Param("orgCd") String orgCd, @Param("empCd") String empCd, @Param("empType") String empType);

}
