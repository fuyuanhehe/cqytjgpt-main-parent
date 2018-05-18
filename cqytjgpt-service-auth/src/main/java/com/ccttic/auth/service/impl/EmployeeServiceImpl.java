package com.ccttic.auth.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.exception.DeleteRefusedException;
import com.ccttic.auth.common.page.Page;
import com.ccttic.auth.common.page.PageImpl;
import com.ccttic.auth.common.page.Pageable;
import com.ccttic.auth.mapper.EmpMenuMapper;
import com.ccttic.auth.mapper.EmployeeMapper;
import com.ccttic.auth.mapper.OrganizationMapper;
import com.ccttic.auth.mapper.PostEmpMapper;
import com.ccttic.auth.mapper.PostMapper;
import com.ccttic.auth.mapper.RoleEmpMapper;
import com.ccttic.auth.mapper.RoleMapper;
import com.ccttic.auth.mapper.RoleMenuMapper;
import com.ccttic.auth.model.EmpCategoryEnum;
import com.ccttic.auth.model.EmpMenu;
import com.ccttic.auth.model.Employee;
import com.ccttic.auth.model.OrgCategoryEnum;
import com.ccttic.auth.model.Organization;
import com.ccttic.auth.model.Post;
import com.ccttic.auth.model.PostEmp;
import com.ccttic.auth.model.Role;
import com.ccttic.auth.model.RoleEmp;
import com.ccttic.auth.model.RoleMenu;
import com.ccttic.auth.service.IEmployeeService;
import com.ccttic.auth.util.DESHelper;
import com.ccttic.auth.util.ObjectHelper;
import com.ccttic.auth.util.RandomHelper;
import com.ccttic.auth.util.StringHelper;

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
	private OrganizationMapper orgMapper;
	@Resource
	private PostEmpMapper peMapper;
	@Resource
	private RoleEmpMapper reMapper;
	@Resource
	private PostMapper postMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private EmpMenuMapper emMapper;
	@Resource
	private RoleMenuMapper rmMapper;

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#promotion(java.lang.String, java.lang.String, com.studio.framework.beans.ess.EmpCategoryEnum)
	 */
	@Override
	@Transactional(readOnly = true)
	public Employee promotion(String orgCd, String empCd, EmpCategoryEnum empType) throws AppException {
		Employee empFrom = mapper.findEmployeeByEmpCd(empCd);
		Employee emp = null;

		switch (empType) {
		case CHAIRMAN:
			if (EmpCategoryEnum.CHAIRMAN.name().equals(empFrom.getEmpType())) {
				// 本身就是董事长类型
				emp = empFrom;
			} else {
				// 如果不是董事长类型的Employee，通过直接更新数据库的方式执行员工升迁
				mapper.promotion(orgCd, empCd, empType.name());
				emp = mapper.findEmployeeByEmpCd(empCd);
			}
			break;
		case GENERALMANAGER:
			if (EmpCategoryEnum.GENERALMANAGER.name().equals(empFrom.getEmpType())
					|| EmpCategoryEnum.CHAIRMAN.name().equals(empFrom.getEmpType())) {
				// 本身就是总经理类型的
				emp = empFrom;
			} else {
				// 如果不是总经理类型的Employee，通过直接更新数据库的方式执行员工升迁
				mapper.promotion(orgCd, empCd, empType.name());
				emp = mapper.findEmployeeByEmpCd(empCd);
			}
			break;
		case LEADERSHIP:
			if (EmpCategoryEnum.LEADERSHIP.name().equals(empFrom.getEmpType())
					|| EmpCategoryEnum.GENERALMANAGER.name().equals(empFrom.getEmpType())
					|| EmpCategoryEnum.CHAIRMAN.name().equals(empFrom.getEmpType())) {
				// 本身就是分管领导类型的
				emp = empFrom;
			} else {
				// 如果不是分管领导类型的Employee，通过直接更新数据库的方式执行员工升迁
				orgCd = this.belongCompany(empFrom.getOrgCd()).getOrgCd();
				mapper.promotion(orgCd, empCd, empType.name());
				emp = mapper.findEmployeeByEmpCd(empCd);
			}

			break;
		case ADMIN:
			break;
		case GENERALEMPLOYEE:
			break;
		}
		return emp;
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeById(String id) throws AppException {
		Employee emp = mapper.findEmployeeById(id);
		//获取岗位人员
		List<PostEmp> posts = peMapper.findPostsByEmpId(emp.getId());
		for (PostEmp post : posts) {
			emp.getPostIds().add(post.getPostCd());
			emp.getPostNms().add(post.getPostNm());
		}
		return emp;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#findEmployeeByEmpCd(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeByEmpCd(String empCd) throws AppException {
		Employee emp = mapper.findEmployeeByEmpCd(empCd);
		//获取岗位人员
		List<PostEmp> posts = peMapper.findPostsByEmpId(emp.getId());
		for (PostEmp post : posts) {
			emp.getPostIds().add(post.getPostCd());
			emp.getPostNms().add(post.getPostNm());
		}
		return emp;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#getCompanyLeadership(java.lang.String, com.studio.framework.beans.ess.EmpCategoryEnum)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Employee> getCompanyLeadership(String orgCd, EmpCategoryEnum empCategory) throws AppException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgCd", orgCd);
		params.put("empType", empCategory.name());
		return mapper.findCompanyLeaders(params);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee login(String account, String password) throws AppException {
		return mapper.login(account, password);
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#removeEmployee(java.lang.String)
	 */
	@Override
	@Transactional
	public void removeEmployee(String empCd) throws AppException {
		Employee emp = mapper.findEmployeeByEmpCd(empCd);
		if (EmpCategoryEnum.ADMIN.name().equals(emp.getEmpType())) {
			throw new DeleteRefusedException(emp.getEmpNm() + "不能删除!");
		}
		if (this.isManagement(emp.getId())) {
			throw new DeleteRefusedException("董事长、总经理、领导、主管或副主管人员不能删除!");
		}

		//从人员岗位中删除相关岗位信息
		peMapper.deleteEmpPostByEmpId(emp.getId());
		//从人员角色中删除角色信息
		reMapper.deleteEmpRoleByEmpId(emp.getId());
		//从人员菜单中删除人员菜单信息
		emMapper.deleteEmpMenuByEmpId(emp.getId());
		//删除人员关系
		mapper.removeEmployee(empCd);

	}

	/**
	 * 通过人员ID判断是否为领导
	 * @param empId
	 * @return
	 */
	private boolean isManagement(String empId) {
		long count = mapper.isManagement(empId);
		return count > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#createEmployee(com.studio.framework.beans.ess.Employee)
	 */
	@Override
	@Transactional
	public Employee addEmployee(Employee emp) throws AppException {
		// 设置员工所属机构
		Organization org = orgMapper.findOrgByOrgCd(emp.getOrgCd());
		emp.setOrgId(org.getId());
		String empId = RandomHelper.uuid();
		emp.setId(empId);
		emp.setEmpCd(empId);
		try {
			//初始化密码
			emp.setPassword(DESHelper.getInstance().encrypt("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapper.addEmployee(emp);
		// 设置岗位
		if (ObjectHelper.isNotEmpty(emp.getPostIds())) {
			for (String postCd : emp.getPostIds()) {
				Post post = postMapper.findPostByCd(postCd);
				PostEmp postEmp = new PostEmp(RandomHelper.uuid(), empId, post.getId(), 1);
				peMapper.addPostEmp(postEmp);
			}
		}
		//设置默认角色
		Role role = roleMapper.findRoleByRoleCd("all");
		RoleEmp roleEmp = new RoleEmp(RandomHelper.uuid(), empId, role.getId(), 1);
		reMapper.addRoleEmp(roleEmp);
		return emp;

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#editEmployee(com.studio.framework.beans.ess.Employee)
	 */
	@Override
	@Transactional
	public Employee editEmployee(Employee emp) throws AppException {
		Employee tempEmp = mapper.findEmployeeByEmpCd(emp.getEmpCd());
		// 设置员工所属机构
		Organization org = orgMapper.findOrgByOrgCd(emp.getOrgCd());
		emp.setOrgId(org.getId());
		peMapper.deleteEmpPostByEmpId(tempEmp.getId());
		// 设置岗位
		if (ObjectHelper.isNotEmpty(emp.getPostIds())) {
			for (String postCd : emp.getPostIds()) {
				Post post = postMapper.findPostByCd(postCd);
				PostEmp postEmp = new PostEmp(RandomHelper.uuid(), tempEmp.getId(), post.getId(), 1);
				peMapper.addPostEmp(postEmp);
			}
		}
		mapper.editEmployee(emp);
		return emp;

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#setPassword(com.studio.framework.beans.ess.Employee)
	 */
	@Override
	@Transactional
	public void setPassword(Employee emp) throws AppException {
		try {
			//初始化密码
			emp.setPassword(DESHelper.getInstance().encrypt(emp.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapper.setPassword(emp);

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#findEmployees(boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, com.studio.framework.common.page.PageRequest)
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<Employee> findEmployees(boolean involveAllSubOrgs, String orgCd, String empNm, String account,
			List<String> postCds, Pageable page) throws AppException {
		//包含子机构查询条件
		if (ObjectHelper.isNotEmpty(orgCd)) {
			if (involveAllSubOrgs) {
				List<Organization> subOrgs = this.getAllSubOrgs(orgCd);
				List<String> orgCds = new ArrayList<String>();
				for (Organization o : subOrgs) {
					orgCds.add(o.getOrgCd());
				}

				// 加入本身
				orgCds.add(orgCd);

				String[] orgCdAry = new String[0];
				orgCdAry = orgCds.toArray(orgCdAry);

				orgCd = StringHelper.stringArrayToDelimitedStringWithQuotation(orgCdAry);
			} else {
				orgCd = StringHelper.stringArrayToDelimitedStringWithQuotation(new String[] { orgCd });
			}
		}

		String postCd = null;
		// 构造岗位查询子句和条件
		if (ObjectHelper.isNotEmpty(postCds)) {
			String[] postAry = postCds.toArray(new String[] {});
			postCd = StringHelper.stringArrayToDelimitedStringWithQuotation(postAry);
		}
		Page<Employee> pager = new PageImpl<Employee>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("involveAllSubOrgs", involveAllSubOrgs);
		params.put("orgCd", ObjectHelper.isEmpty(orgCd) ? null : orgCd);
		params.put("empNm", ObjectHelper.isEmpty(empNm) ? null : empNm);
		params.put("account", ObjectHelper.isEmpty(account) ? null : account);
		params.put("postCd", ObjectHelper.isEmpty(postCd) ? null : postCd);
		long totalRows = mapper.counEmployee(params);
		List<Employee> records = mapper.pagerEmployee(params);
		for (Employee record : records) {
			if (ObjectHelper.isNotEmpty(record.getOrgCd())) {
				//所属公司
				Organization org = orgMapper.findOrgByOrgCd(record.getOrgCd());
				if (!OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getOrgType())) {
					record.setCompanyNm(org.getOrgNm());
				} else {
					Organization company = this.belongCompany(org.getSuperOrgCd());
					if (ObjectHelper.isNotEmpty(company)) {
						record.setCompanyNm(company.getOrgNm());
					}
				}
			}
			//员工类型
			record.setEmpTypeNm(EmpCategoryEnum.getLabel(record.getEmpType()));
			//获取岗位人员
			List<PostEmp> posts = peMapper.findPostsByEmpId(record.getId());
			for (PostEmp post : posts) {
				record.getPostIds().add(post.getPostCd());
				record.getPostNms().add(post.getPostNm());
			}

		}
		pager.setTotalRows(totalRows);
		pager.setRecords(records);
		return pager;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#removeAdmin(java.lang.String)
	 */
	@Override
	@Transactional
	public void removeAdmin(String orgCd) throws AppException {
		Organization company = orgMapper.findOrgByOrgCd(orgCd);
		if (ObjectHelper.isNotEmpty(company) && ObjectHelper.isNotEmpty(company.getCompanyAdminCd())) {
			//从人员岗位中删除相关岗位信息
			peMapper.deleteEmpPostByEmpId(company.getCompanyAdminCd());
			//从人员角色中删除角色信息
			reMapper.deleteEmpRoleByEmpId(company.getCompanyAdminCd());
			//从人员菜单中删除人员菜单信息
			emMapper.deleteEmpMenuByEmpId(company.getCompanyAdminCd());
			mapper.removeEmployee(company.getCompanyAdminCd());
			//移除公司管理人员
			orgMapper.setCompanyAdmin(company.getId(), null);
		}
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#editAdmin(com.studio.framework.beans.ess.Employee)
	 */
	@Override
	@Transactional
	public Employee editAdmin(Employee admin) throws AppException {
		Organization company = orgMapper.findOrgByOrgCd(admin.getOrgCd());
		if (OrgCategoryEnum.HEAD.name().equals(company.getOrgType())) {
			admin.setEmpNm("系统管理员");
		} else {
			admin.setEmpNm(company.getOrgNm() + "管理员");
		}
		admin.setOrgId(company.getId());
		admin.setEmpType(EmpCategoryEnum.ADMIN.name());
		mapper.editEmployee(admin);
		return admin;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#assignAdmin(com.studio.framework.beans.ess.Employee)
	 */
	@Override
	@Transactional
	public Employee assignAdmin(Employee admin) throws AppException {
		Organization company = orgMapper.findOrgByOrgCd(admin.getOrgCd());
		String id = RandomHelper.uuid();
		admin.setEmpType(EmpCategoryEnum.ADMIN.name());
		admin.setEmpCd(id);
		admin.setId(id);
		admin.setOrgId(company.getId());
		admin.setEmpNm(company.getOrgNm() + "管理员");
		//初始化密码
		try {
			admin.setPassword(DESHelper.getInstance().encrypt("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapper.addEmployee(admin);
		//设置公司管理人员
		orgMapper.setCompanyAdmin(company.getId(), id);
		return admin;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#getCompanyAdmin(java.lang.String)
	 */
	@Override
	@Transactional
	public Employee getCompanyAdmin(String orgCd) throws AppException {
		Organization company = orgMapper.findOrgByOrgCd(orgCd);
		Employee companyAdmin = new Employee();
		if (OrgCategoryEnum.HEAD.name().equals(company.getOrgType())) {
			if (ObjectHelper.isEmpty(company.getCompanyAdminId())) {
				// 如果是总公司，但管理员不存在，则自动增加系统管理员为总公司的管理员
				companyAdmin = new Employee();
				String id = RandomHelper.uuid();
				companyAdmin.setEmpNm("系统管理员");
				companyAdmin.setEmpCd(id);
				companyAdmin.setId(id);
				companyAdmin.setAccount("admin");
				companyAdmin.setOrgId(company.getId());
				companyAdmin.setOrgCd(orgCd);
				companyAdmin.setEmpType(EmpCategoryEnum.ADMIN.name());
				//初始化密码
				try {
					companyAdmin.setPassword(DESHelper.getInstance().encrypt("123456"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				mapper.addEmployee(companyAdmin);
				company.setCompanyAdminId(id);
				//设置公司管理人员
				orgMapper.setCompanyAdmin(company.getId(), id);

			} else {
				companyAdmin = mapper.findEmployeeById(company.getCompanyAdminId());
				if (ObjectHelper.isNotEmpty(companyAdmin) && !"admin".equalsIgnoreCase(companyAdmin.getAccount())) {
					companyAdmin.setEmpNm("系统管理员");
					companyAdmin.setAccount("admin");
					companyAdmin.setOrgId(company.getId());
					companyAdmin.setOrgCd(orgCd);
					companyAdmin.setEmpType(EmpCategoryEnum.ADMIN.name());
					//初始化密码
					try {
						companyAdmin.setPassword(DESHelper.getInstance().encrypt("123456"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					mapper.editEmployee(companyAdmin);
				}
			}
		} else {
			if (ObjectHelper.isNotEmpty(company.getCompanyAdminId())) {
				companyAdmin = mapper.findEmployeeById(company.getCompanyAdminId());
				if (ObjectHelper.isNotEmpty(companyAdmin) && "admin".equalsIgnoreCase(companyAdmin.getAccount())) {
					companyAdmin.setEmpNm("管理员");
					companyAdmin.setAccount(RandomHelper.getRandomLowerChar(4) + "admin");
					companyAdmin.setOrgId(company.getId());
					companyAdmin.setOrgCd(orgCd);
					companyAdmin.setEmpType(EmpCategoryEnum.ADMIN.name());
					//初始化密码
					try {
						companyAdmin.setPassword(DESHelper.getInstance().encrypt("123456"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					mapper.editEmployee(companyAdmin);
				}
			}
			companyAdmin.setOrgCd(orgCd);
		}

		return companyAdmin;
	}

	private Organization belongCompany(String superOrgCd) {
		Organization org = orgMapper.findOrgByOrgCd(superOrgCd);
		if (OrgCategoryEnum.DEPARTMENT.name().equalsIgnoreCase(org.getOrgType())) {
			return belongCompany(org.getSuperOrgCd());
		} else {
			return org;
		}

	}

	/**
	 * 获取当前机构的所有下级机构的列表，不包含当前机构节点
	 * @param orgCd
	 * @return
	 */
	private List<Organization> getAllSubOrgs(String orgCd) {
		List<Organization> orgs = new ArrayList<Organization>();
		List<Organization> tempOrgs = orgMapper.findSubOrgsByOrgCd(orgCd);
		// 加入下级节点
		for (Organization o : tempOrgs) {
			appendSubOrgs(orgs, o);
		}

		return orgs;
	}

	/**
	 * 遍历当前机构及其下级机构
	 * @param orgs
	 * @param org
	 */
	private void appendSubOrgs(List<Organization> orgs, Organization org) {
		// 加入当前节点
		orgs.add(org);
		List<Organization> tempOrgs = orgMapper.findSubOrgsByOrgCd(org.getOrgCd());
		// 加入下级节点
		for (Organization o : tempOrgs) {
			appendSubOrgs(orgs, o);
		}
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#setEmpResource(java.lang.String, java.util.List)
	 */
	@Override
	@Transactional
	public void setEmpResource(String empId, String[] menuIds) throws AppException {
		emMapper.deleteEmpMenuByEmpId(empId);
		if (ObjectHelper.isNotEmpty(menuIds)) {
			List<EmpMenu> ems = new ArrayList<EmpMenu>();
			for (String resId : menuIds) {
				EmpMenu em = new EmpMenu(RandomHelper.uuid(), empId, resId, 1);
				ems.add(em);
			}
			emMapper.setEmpResource(ems);
		}

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#findEmpResources()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmpMenu> findEmpResources(String empId) throws AppException {
		return emMapper.findEmpResources(empId);
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#findRoleResources(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<RoleMenu> findRoleResources(String roleId) throws AppException {
		return rmMapper.findRoleResources(roleId);
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#setRoleResource(java.lang.String, java.lang.String[])
	 */
	@Override
	@Transactional
	public void setRoleResource(String roleId, String[] menuIds) throws AppException {
		rmMapper.deleteRoleMenuByRoleId(roleId);
		if (ObjectHelper.isNotEmpty(menuIds)) {
			List<RoleMenu> rms = new ArrayList<RoleMenu>();
			for (String resId : menuIds) {
				RoleMenu rm = new RoleMenu(RandomHelper.uuid(), roleId, resId, 1);
				rms.add(rm);
			}
			rmMapper.setRoleResource(rms);
		}

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IEmployeeService#findRolesByEmpCd(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<RoleEmp> findRolesByEmpId(String empId) throws AppException {
		return reMapper.findRolesByEmpId(empId);
	}

}
