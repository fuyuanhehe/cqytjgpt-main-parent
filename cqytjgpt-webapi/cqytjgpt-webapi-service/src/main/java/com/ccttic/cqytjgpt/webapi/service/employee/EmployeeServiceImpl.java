package com.ccttic.cqytjgpt.webapi.service.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.util.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.role.IRoleMenuService;
import com.ccttic.cqytjgpt.webapi.mapper.employee.EmployeeMapper;
import com.ccttic.cqytjgpt.webapi.mapper.employee.EssEmployeeMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.cqytjgpt.webapi.mapper.organization.DepartmentMapper;
import com.ccttic.cqytjgpt.webapi.mapper.organization.OrganizationMapper;
import com.ccttic.cqytjgpt.webapi.mapper.post.EssPostMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehicleMapper;
import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeeDept;
import com.ccttic.entity.employee.EssEmployeeExample;
import com.ccttic.entity.employee.EssEmployeePost;
import com.ccttic.entity.employee.EssEmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.util.common.Const;
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
 * @date 2016年12月4日
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Resource
	private EmployeeMapper mapper;
	@Resource
	private EssEmployeeMapper empMapper;
	@Resource
	private EssEnterpriseMapper entMapper;
	@Resource
	private EssPostMapper postMapper;
	@Autowired
	private IRoleMenuService service;
	@Resource
	private DepartmentMapper departmentMapper;
	@Resource
	private OrganizationMapper organizationMapper;
	@Resource
	private VehicleMapper vehicleMapper;// 司机基础信息
	@Autowired
	private RedisService<EmployeeVo> redisService;
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
	public EmployeeVo findEmployeeByAccount(String account) throws Exception {

		EmployeeVo emp = empMapper.findEmployeeByAccount(account);
		// 员工所在岗位
		List<EssPost> posts = empMapper.selectPostUnderEmp(emp.getId());
		emp.setPosts(posts);

		// 员工所在部门
		List<Department> deps = empMapper.selectDepUnderEmp(emp.getId());
		emp.setDeps(deps);
		EssEnterprise ent = entMapper.getEntByEmpId(emp.getId());
		emp.setEnt(ent);
		// 员工所在组织
		Map<String, String> map = null;
		Organization organization = null;
		if (Const.SUPERMAN.equals(emp.getEmptype())) {
			emp.setCanSeeOrgs(organizationMapper.getAllOrg() != null ? organizationMapper.getAllOrg() : null);
			emp.setCanSeeDeps(organizationMapper.getAllDepart("") != null ? organizationMapper.getAllDepart("") : null);
			emp.setCanSeeEnt(entMapper.getEssEnterpriseByOrgId(""));
			emp.setCanSeeEmp(empMapper.getAllEmp());
			emp.setCanSeePosts(postMapper.getAllPost());
		} else if (Const.ADMIN.equals(emp.getEmptype()) && (""+Const.ONE).equals(emp.getEmptype())) {

			organization = organizationMapper.getOrgByAdminId(emp.getId());
			List<Organization> organizations = organizationMapper.getLastOrg(organization.getId());
			emp.setOrg(organization);
			organizations.add(organization);
			emp.getCanSeeOrgs().addAll(organizations);
			for (Organization org : organizations) {

				if (organizationMapper.getAllDepart(org.getId()) != null
						&& organizationMapper.getAllDepart(org.getId()).size() > Const.ZERO) {
					emp.getCanSeeDeps().addAll(organizationMapper.getAllDepart(org.getId()));
					if (!org.getId().equals(organization.getId())) {
						emp.getCanSeeEnt().addAll(entMapper.getEssEnterpriseByOrgId(org.getId()));
					}
				}
			}

			for (Department depart : emp.getCanSeeDeps()) {
				map = new HashMap<>();
				map.put("depid", depart.getId());
				List<EssEmployee> emps = postMapper.getEmployeeByDep(map);
				emp.getCanSeeEmp().addAll(emps);

				List<EssPost> postList = postMapper.selectPostUnderDep(map);
				emp.getCanSeePosts().addAll(postList);
			}

		} else if (Const.ADMIN.equals(emp.getEmptype()) && (""+Const.TWO).equals(emp.getEmptype())) {
			organization = organizationMapper.getOrgByAdminId(emp.getId());
			if (organizationMapper.getAllDepart(organization.getId()) != null
					&& organizationMapper.getAllDepart(organization.getId()).size() > Const.ZERO) {
				emp.getCanSeeDeps().addAll(organizationMapper.getAllDepart(organization.getId()));
				emp.getCanSeeEnt().addAll(entMapper.getEssEnterpriseByOrgId(organization.getId()));
			}
			for (Department depart : emp.getCanSeeDeps()) {
				map = new HashMap<>();
				map.put("depid", depart.getId());
				List<EssEmployee> emps = postMapper.getEmployeeByDep(map);
				if (emps != null && emps.size() > Const.ZERO) {
					emp.getCanSeeEmp().addAll(emps);
				}
				List<EssPost> postList = postMapper.selectPostUnderDep(map);
				if (postList != null && postList.size() > Const.ZERO) {
					emp.getCanSeePosts().addAll(postList);
				}
			}
			emp.setOrg(organization);
		} else if((Const.ADMIN.equals(emp.getEmptype()) && (""+Const.THREE).equals(emp.getEmptype()))){
			List<EssEnterprise> adminEnt = entMapper.getEssEnterprise(emp.getId());
			emp.setCanSeeEnt(adminEnt);
			List<Department> departments =organizationMapper.getDepartByEntCd(adminEnt.get(0).getEtpcd());
			organization = organizationMapper.findOrgByEptId(adminEnt.get(0).getId());
			emp.setOrg(organization);
			for (Department depart : departments){
				map = new HashMap<>();
				map.put("depid", depart.getId());
				List<EssEmployee> emps = postMapper.getEmployeeByDep(map);
				if (emps != null && emps.size() > Const.ZERO) {
					emp.getCanSeeEmp().addAll(emps);
				}
				List<EssPost> postList = postMapper.selectPostUnderDep(map);
				if (postList != null && postList.size() > Const.ZERO) {
					emp.getCanSeePosts().addAll(postList);
				}
			}

		}else{
			organization = organizationMapper.getOrgByEmpId(emp.getId());
			emp.setOrg(organization);
		}

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
		EssEmployeeDept dept = new EssEmployeeDept();
		dept.setDepId(emp.getDepid());
		dept.setEmpId(emp.getId());
		dept.setVersion(1);
		dept.setId(RandomHelper.uuid());
		empMapper.delEmpUnderDep(dept);
		empMapper.relatedDepAndEmp(dept);
		if (emp.getPost() != null)
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
	public Page<EssEmployeeVo> selectEmployee(Pageable page, List<EssEmployee> list, EssEmployeeVo emp)
			throws Exception {
		Page<EssEmployeeVo> pager = new PageImpl<EssEmployeeVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		if (emp.getEptId() != null) {
			params.put("eptId", emp.getEptId());// 企业id
		}
		params.put("emps", list);//员工集合
		params.put("pageSize", page.getRows() + "");
		params.put("startRecord", (page.getPage() - 1) * page.getRows() + "");
		if (emp.getOrgCd() != null) {
			params.put("orgCd", emp.getOrgCd());// 组织id
		}
		params.put("empNm", emp.getEmpnm());// 员工姓名
		params.put("account", emp.getAccount());// 员工账号
		params.put("depid", emp.getDepid());// 部门id
		params.put("orgid", emp.getOrgCd());// 组织id
		long totalRows = empMapper.qryPostListCount(params);
		List<EssEmployeeVo> records = empMapper.qryPostList(params);
		for (EssEmployeeVo essEmployeeVo : records) {
			List<EssPost> post = empMapper.selectPostUnderEmp(essEmployeeVo.getId());
			essEmployeeVo.setPost(post);
		}

		pager.setTotalRows(totalRows);
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

	@Override
	public EmployeeVo getUserInfo(String access_token) {
		String username = JWTUtil.getUsername(access_token);
		EmployeeVo employee = (EmployeeVo) redisService.get(username + Const.TOKEN);
		// 2. 判断REDIS是否为空
		if (null == employee) {
			try {
				employee = findEmployeeByAccount(username);
				//3. 更新redis里用户缓存
				redisService.set(username + Const.TOKEN, employee, Const.USER_REDIS_LIVE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public int selectEmpByAccount(String account) {
		EssEmployeeExample example = new EssEmployeeExample();
		example.createCriteria().andAccountEqualTo(account);

		if(empMapper.selectByExample(example).size()>0){
			return 1;
		}else{
			return 0;
		}
	}

}
