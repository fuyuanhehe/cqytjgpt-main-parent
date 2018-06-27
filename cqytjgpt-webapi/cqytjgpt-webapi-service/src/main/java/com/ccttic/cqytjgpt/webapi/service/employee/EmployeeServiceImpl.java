package com.ccttic.cqytjgpt.webapi.service.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.role.IRoleMenuService;
import com.ccttic.cqytjgpt.webapi.mapper.employee.EmployeeMapper;
import com.ccttic.cqytjgpt.webapi.mapper.employee.EssEmployeeMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.cqytjgpt.webapi.mapper.post.EssPostMapper;
import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeeDept;
import com.ccttic.entity.employee.EssEmployeePost;
import com.ccttic.entity.employee.EssEmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.util.common.MD5;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.exception.AppException;
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
	private EssEnterpriseMapper entMapper;
	@Autowired
	private EssPostMapper postMapper;
	@Autowired
	private IRoleMenuService service;

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
	public EmployeeVo findEmployeeByAccount(String account) {

		EmployeeVo emp = empMapper.findEmployeeByAccount(account);
		// 员工所在岗位
		List<EssPost> posts = empMapper.selectPostUnderEmp(emp.getId());
		emp.setPosts(posts);
		// 员工所在部门
		List<Department> deps = empMapper.selectDepUnderEmp(emp.getId());
		emp.setDeps(deps);
		List<EssEnterprise> ent = entMapper.getEssEnterprise(emp.getId());
		emp.setEnt(ent);
		// 员工所在组织
		List<Organization> orgs = new ArrayList<>();
		for (Department department : deps) {
			Organization org = empMapper.selectOrgByDepId(department.getId());
			orgs.add(org);
		}
		emp.setOrgs(orgs);
		// 员工能使用的菜单,员工角色
		EmployeeVo datas = service.seRole_MenuById(emp.getId());
		emp.setMenus(datas.getMenus());
		emp.setModels(datas.getModels());
		return emp;

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
		employee.setEmpcd(empid);
		employee.setEmptype(emp.getEmptype());
		employee.setPassword(MD5.sign(emp.getAccount(), emp.getPassword(), "utf-8"));
		empMapper.insert(employee);
		EssEmployeeDept dept = new EssEmployeeDept();
		dept.setDepId(emp.getDepid());
		dept.setEmpId(empid);
		dept.setVersion(1);
		dept.setId(RandomHelper.uuid());
		empMapper.relatedDepAndEmp(dept);
		for (int i = 0; i < emp.getPost().size(); i++) {
			String postId = emp.getPost().get(i).getId();
			EssEmployeePost eep = new EssEmployeePost();
			eep.setEmpId(empid);
			eep.setId(RandomHelper.uuid());
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
	public void editEmployee(EssEmployeeVo emp) throws Exception {
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
		params.put("eptId", emp.getEptId());//企业id

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
	public void modifyPassword(EssEmployee emp) throws Exception {
		empMapper.updateByPrimaryKeySelective(emp);
	}

	@Override
	@Transactional
	public void delEmployee(EssEmployeeVo emp) throws Exception {

		empMapper.delPostUnderEmp(emp.getId());
		EssEmployeeDept dept = new EssEmployeeDept();
		dept.setDepId(emp.getDepid());
		dept.setEmpId(emp.getId());
		empMapper.delEmpUnderDep(dept);
		empMapper.updateByPrimaryKeySelective(emp);

	}

}
