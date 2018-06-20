package com.ccttic.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.auth.mapper.EmployeeMapper;
import com.ccttic.auth.mapper.RoleEmpMapper;
import com.ccttic.auth.service.IEmployeeService;
import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.util.exception.AppException;

/**
   功能说明：     人员业务实现类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.impl.EmployeeServiceImpl.java
 @date  2016年12月4日
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Resource
	private EmployeeMapper mapper;

	@Resource
	private RoleEmpMapper reMapper;

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#findRolesByEmpCd(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<RoleEmp> findRolesByEmpId(String empId) throws AppException {
		return reMapper.findRolesByEmpId(empId);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeByAccount(String account) {
		return mapper.findEmployeeByAccount(account);
	}

}
