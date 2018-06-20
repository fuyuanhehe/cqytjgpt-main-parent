package com.ccttic.auth.mapper;

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
	 * 根据账号查询人员
	 * @param account
	 * @return
	 */
	public Employee findEmployeeByAccount(@Param("account") String account);

}
