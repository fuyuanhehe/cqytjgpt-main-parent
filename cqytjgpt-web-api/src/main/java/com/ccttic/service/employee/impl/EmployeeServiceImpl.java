package com.ccttic.service.employee.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccttic.entity.common.exception.AppException;
import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.mapper.employee.EmployeeMapper;
import com.ccttic.service.employee.IEmployeeService;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;


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

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param id
	    * @return
	    * @throws AppException  
	    * @see com.ccttic.service.employee.IEmployeeService#findEmployeeById(java.lang.String)  
	    */  
	    
	@Override
	public Employee findEmployeeById(String id) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param account
	    * @return  
	    * @see com.ccttic.service.employee.IEmployeeService#findEmployeeByAccount(java.lang.String)  
	    */  
	    
	@Override
	public Employee findEmployeeByAccount(String account) {
	
		return mapper.findEmployeeByAccount(account);
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param account
	    * @param password
	    * @return
	    * @throws AppException  
	    * @see com.ccttic.service.employee.IEmployeeService#login(java.lang.String, java.lang.String)  
	    */  
	    
	@Override
	public Employee login(String account, String password)  {
		return mapper.login(account, password);
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param involveAllSubOrgs
	    * @param orgCd
	    * @param empNm
	    * @param account
	    * @param postCds
	    * @param page
	    * @return  
	    * @see com.ccttic.service.employee.IEmployeeService#findEmployees(boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, com.ccttic.util.page.Pageable)  
	    */  
	    
	@Override
	public Page<Employee> findEmployees(boolean involveAllSubOrgs, String orgCd, String empNm, String account,
			List<String> postCds, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param emp
	    * @return  
	    * @see com.ccttic.service.employee.IEmployeeService#addEmployee(com.ccttic.entity.employee.Employee)  
	    */  
	    
	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param emp
	    * @return  
	    * @see com.ccttic.service.employee.IEmployeeService#editEmployee(com.ccttic.entity.employee.Employee)  
	    */  
	    
	@Override
	public Employee editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param empId
	    * @return  
	    * @see com.ccttic.service.employee.IEmployeeService#findRolesByEmpId(java.lang.String)  
	    */  
	    
	@Override
	public List<RoleEmp> findRolesByEmpId(String empId) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
