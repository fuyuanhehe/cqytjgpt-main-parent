package com.ccttic.service.employee.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.common.exception.AppException;
import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeePost;
import com.ccttic.entity.employee.EssEmployeeVo;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.mapper.employee.EmployeeMapper;
import com.ccttic.mapper.employee.EssEmployeeMapper;
import com.ccttic.mapper.post.EssPostMapper;
import com.ccttic.service.employee.IEmployeeService;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

/**
 * 功能说明： 人员业务实现类
 * 
 * @version 1.0.0
 * @author xgYin
 * @see com.studio.framework.service.ess.impl.EmployeeServiceImpl.java
 * @date 2016年12月4日
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Resource
	private EmployeeMapper mapper;
	@Autowired
	private EssEmployeeMapper empMapper;
	@Autowired
	private EssPostMapper postMapper;

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @throws AppException
	 * 
	 * @see com.ccttic.service.employee.IEmployeeService#findEmployeeById(java.lang.
	 * String)
	 */

	@Override
	public Employee findEmployeeById(String id) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param account
	 * 
	 * @return
	 * 
	 * @see
	 * com.ccttic.service.employee.IEmployeeService#findEmployeeByAccount(java.lang.
	 * String)
	 */

	@Override
	public Employee findEmployeeByAccount(String account) {

		return mapper.findEmployeeByAccount(account);
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param account
	 * 
	 * @param password
	 * 
	 * @return
	 * 
	 * @throws AppException
	 * 
	 * @see com.ccttic.service.employee.IEmployeeService#login(java.lang.String,
	 * java.lang.String)
	 */

	@Override
	public Employee login(String account, String password) {
		return mapper.login(account, password);
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param involveAllSubOrgs
	 * 
	 * @param orgCd
	 * 
	 * @param empNm
	 * 
	 * @param account
	 * 
	 * @param postCds
	 * 
	 * @param page
	 * 
	 * @return
	 * 
	 * @see com.ccttic.service.employee.IEmployeeService#findEmployees(boolean,
	 * java.lang.String, java.lang.String, java.lang.String, java.util.List,
	 * com.ccttic.util.page.Pageable)
	 */

	@Override
	public Page<Employee> findEmployees(boolean involveAllSubOrgs, String orgCd, String empNm, String account,
			List<String> postCds, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param emp
	 * 
	 * @return
	 * 
	 * @see
	 * com.ccttic.service.employee.IEmployeeService#addEmployee(com.ccttic.entity.
	 * employee.Employee)
	 */

	@Override
	@Transactional
	public void addEmployee(EssEmployeeVo emp) throws Exception {
		String empid = RandomHelper.uuid();
		EssEmployee employee = emp;
		employee.setId(empid);
			empMapper.insert(employee);
			for (int i = 0; i < emp.getPost().size(); i++) {
				String postId = emp.getPost().get(i).getId();
				String uid = RandomHelper.uuid();
				EssEmployeePost eep = new EssEmployeePost();
				eep.setEmpId(empid);
				eep.setId(uid);
				eep.setVersion(1);
				eep.setPostId(postId);
				postMapper.relatedPostAndEmp(eep);

			}
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param emp
	 * 
	 * @return
	 * 
	 * @see
	 * com.ccttic.service.employee.IEmployeeService#editEmployee(com.ccttic.entity.
	 * employee.Employee)
	 */

	@Override
	@Transactional
	public void editEmployee(EssEmployeeVo emp) throws Exception{
		EssEmployee employee = emp;
			empMapper.updateByPrimaryKeySelective(employee);
			empMapper.delPostUnderEmp(emp.getId());
			for (int i = 0; i < emp.getPost().size(); i++) {
				String postId = emp.getPost().get(i).getId();
				String uid = RandomHelper.uuid();
				EssEmployeePost eep = new EssEmployeePost();
				eep.setEmpId(emp.getId());
				eep.setId(uid);
				eep.setVersion(1);
				eep.setPostId(postId);
				postMapper.relatedPostAndEmp(eep);

			}
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param empId
	 * 
	 * @return
	 * 
	 * @see com.ccttic.service.employee.IEmployeeService#findRolesByEmpId(java.lang.
	 * String)
	 */

	@Override
	public List<RoleEmp> findRolesByEmpId(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EssEmployeeVo> selectEmployee(Pageable page, EssEmployeeVo emp) throws Exception {
		Page<EssEmployeeVo> pager = new PageImpl<EssEmployeeVo>(page);
		Map<String, String> params = new HashMap<String, String>();
		params.put("pageSize", page.getRows() + "");
		params.put("startRecord", (page.getPage() - 1) * page.getRows() + "");
		params.put("orgCd", emp.getOrgCd());// 组织id
		params.put("empNm", emp.getEmpnm());// 员工姓名
		params.put("account", emp.getAccount());// 员工账号
		params.put("depid", emp.getDepid());// 部门id

		long totolRols = empMapper.qryPostListCount(params);
		List<EssEmployeeVo> records = empMapper.qryPostList(params);
		for (EssEmployeeVo essEmployeeVo : records) {
			List<EssPost> post = empMapper.selectPostUnderEmp(essEmployeeVo.getId());
			essEmployeeVo.setPost(post);
		}

		pager.setTotalRows(totolRols);
		pager.setRecords(records);

		return pager;
	}

	@Override
	@Transactional
	public void modifyPassword(EssEmployee emp) throws Exception{
		 empMapper.updateByPrimaryKey(emp);
	}

	@Override
	@Transactional
	public void delEmployee(List<EssEmployee> emps)  throws Exception{
		
			for (EssEmployee emp : emps) {
				emp.setIsdeleted(true);
				empMapper.delPostUnderEmp(emp.getId());		
				empMapper.updateByPrimaryKey(emp);
			}
	}

}
