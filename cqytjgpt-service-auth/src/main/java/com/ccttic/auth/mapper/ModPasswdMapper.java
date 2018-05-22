package com.ccttic.auth.mapper;

import com.ccttic.auth.model.Employee;

/**
   功能说明：     MyBatis密码映射
 @version  1.0.0
 @author  sqli
 @date  2017年3月21日
 */

public interface ModPasswdMapper {
	/**
	 * 根据empCd查询密码
	 * @param empCd
	 * @return
	 */
	public Employee qryPasswd(String empCd);

	/**
	 * 根据empCd查询密码
	 * @param emp
	 * @return
	 */
	public boolean updPasswd(Employee emp);
}
