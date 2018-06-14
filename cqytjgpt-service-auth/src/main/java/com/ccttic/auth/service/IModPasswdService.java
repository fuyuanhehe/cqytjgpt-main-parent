package com.ccttic.auth.service;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.model.Employee;

/**
   功能说明：     修改密码接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.IModPasswdService.java
 @date  2017年3月21日
 */

public interface IModPasswdService {
	/**
	 * 查询密码信息
	 * @param empCd
	 * @return
	 * @throws AppException
	 */
	public Employee qryPasswd(String empCd) throws AppException;

	/**
	 * 密码修改信息
	 * @param empCd
	 * @return
	 * @throws AppException
	 */
	public boolean updPasswd(Employee emp) throws AppException;
}
