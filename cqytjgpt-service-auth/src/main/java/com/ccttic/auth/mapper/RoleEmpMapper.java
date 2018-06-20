package com.ccttic.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.role.RoleEmp;

/**
   功能说明：      MyBatis角色人员映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月11日
 */

public interface RoleEmpMapper {

	/**
	 * 通过人员ID获取角色信息
	 * @param roleId
	 * @return
	 */
	public List<RoleEmp> findRolesByEmpId(@Param("empId") String empId);

}
