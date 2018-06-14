package com.ccttic.auth.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.mapper.ModPasswdMapper;
import com.ccttic.auth.model.Employee;
import com.ccttic.auth.service.IModPasswdService;

/**
   功能说明：     修改密码实现类
 @version  1.0.0
 @author  sqli
 @see  com.studio.framework.service.ess.impl.ModPasswdServiceImpl.java
 @date  2017年3月21日
 */
@Service
public class ModPasswdServiceImpl implements IModPasswdService {
	@Resource
	private ModPasswdMapper mapper;

	@Override
	@Transactional(readOnly = true)
	public Employee qryPasswd(String empCd) throws AppException {
		return mapper.qryPasswd(empCd);
	}

	@Override
	@Transactional
	public boolean updPasswd(Employee emp) throws AppException {
		return mapper.updPasswd(emp);
	}
}
