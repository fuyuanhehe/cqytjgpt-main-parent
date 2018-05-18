package com.ccttic.auth.mapper;

import com.ccttic.auth.model.Employee;
import com.ccttic.auth.util.MyMapper;

/**
   功能说明：     MyBatis密码映射
 @version  1.0.0
 @author  sqli
 @see  com.studio.framework.mapper.ess.ModPasswdMapper.java
 @date  2017年3月21日
 */

public interface ModPasswdMapper extends MyMapper<Employee>{
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
