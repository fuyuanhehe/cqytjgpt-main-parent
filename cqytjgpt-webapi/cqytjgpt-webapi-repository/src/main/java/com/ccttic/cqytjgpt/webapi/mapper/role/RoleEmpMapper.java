package com.ccttic.cqytjgpt.webapi.mapper.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.role.RoleEmp;
import com.ccttic.entity.role.Roles;


/**
   功能说明：      MyBatis角色人员映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月11日
 */

public interface RoleEmpMapper {

	/**
	 * 通过角色ID获取人员信息
	 * @param roleId
	 * @return
	 */
	public List<RoleEmp> findEmpsByRoleId(@Param("roleId") String roleId);

	/**
	 * 通过人员ID获取角色信息
	 * @param roleId
	 * @return
	 */
	public List<RoleEmp> findRolesByEmpId(@Param("empId") String empId);

	/**
	 * 通过角色ID删除人员角色关系
	 * @param id
	 */
	public void deleteEmpRoleByRoleId(Roles roles);

	/**
	 * 通过人员ID删除人员角色关系
	 * @param empId
	 */
	public void deleteEmpRoleByEmpId(@Param("empId") String empId);

	/**
	 * 插入人员角色关系
	 * @param roleEmp
	 */
	public void addRoleEmp(@Param("roleEmp") RoleEmp roleEmp);

}
