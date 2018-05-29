package com.ccttic.auth.controller;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.auth.common.beans.ResponseMsg;
import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.exception.DeleteRefusedException;
import com.ccttic.auth.common.page.Page;
import com.ccttic.auth.common.page.PageRequest;
import com.ccttic.auth.model.EmpCategoryEnum;
import com.ccttic.auth.model.Employee;
import com.ccttic.auth.model.Organization;
import com.ccttic.auth.service.IEmployeeService;
import com.ccttic.auth.service.IOrganizationService;
import com.ccttic.auth.util.ObjectHelper;

/**
   功能说明：    人员信息 
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.controller.ess.EmployeeController.java
 @date  2016年12月4日
 */
@RestController
@RequestMapping("/ess")
public class EmployeeController implements Serializable {
	private static final long serialVersionUID = 6413857376921472315L;
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IOrganizationService organizationService;

	/**
	 * 分页显示员工
	 * @param page
	 * @param emp
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/findEmployees")
	public ResponseMsg<List<Employee>> findEmployees(PageRequest page, Employee emp) throws AppException {
		ResponseMsg<List<Employee>> resp = new ResponseMsg<List<Employee>>();
		// 按条件取得员工信息
		Page<Employee> pager = this.employeeService.findEmployees(emp.isInvolveAllSubOrgs(), emp.getOrgCd(),
				emp.getEmpNm(), emp.getAccount(), emp.getPostIds(), page);
		resp.success("分页显示获取员工信息成功。");
		resp.setData(pager.getRecords());
		resp.setTotal(pager.getTotalRows().intValue());
		return resp;
	}

	/**
	 * 取得机构所有领导
	 * @param orgCd
	 * @param empCategory
	 * @return
	 */
	@RequestMapping("/findLeadShipByOrgCd")
	public ResponseMsg<List<Employee>> findLeadShipByOrgCd(String orgCd, EmpCategoryEnum empCategory) {
		ResponseMsg<List<Employee>> resp = new ResponseMsg<List<Employee>>();
		try {
			if (ObjectHelper.isNotEmpty(orgCd)) {
				//获取公司机构
				Organization company = organizationService.getCompanyByOrgId(orgCd);
				orgCd = company.getOrgCd();
			} else {
				orgCd = null;
			}
			// 取得该机构下面的所有领导
			List<Employee> list = employeeService.getCompanyLeadership(orgCd, empCategory);
			resp.success("获取领导成功!");
			resp.setData(list);
		} catch (AppException e) {
			resp.fail("获取领导员失败!");
			logger.error("获取领导员失败!",e);
		} catch (Exception e) {
			resp.fail("获取领导员失败!");
			logger.error("获取领导员失败!",e);
		}
		return resp;
	}

	/**
	 * 根据人员编号获取员工
	 * 
	 * @param empCd
	 * @param page
	 * @return
	 */
	@RequestMapping("/findEmployeeByEmpCd")
	public ResponseMsg<Employee> findEmployeeByEmpCd(String empCd) {
		ResponseMsg<Employee> resp = new ResponseMsg<Employee>();
		try {
			Employee emp = employeeService.findEmployeeByEmpCd(empCd);
			resp.success("查询人员成功!");
			resp.setData(emp);
		} catch (AppException e) {
			resp.fail("查询人员失败!");
			logger.error("查询人员失败!",e);
		} catch (Exception e) {
			resp.fail("查询人员失败!");
			logger.error("查询人员失败!",e);
		}
		return resp;
	}

	/**
	 * 删除人员信息
	 * 
	 * @param empCd
	 *            人员code
	 * @return
	 */
	@RequestMapping("/removeEmployee")
	public ResponseMsg<String> removeEmployee(String empCd) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			employeeService.removeEmployee(empCd);
			resp.success("删除人员失败!");
		} catch (DeleteRefusedException e) {
			resp.fail("查询人员失败!");
			logger.error("查询人员失败!",e);
		} catch (Exception e) {
			resp.fail("删除人员失败!");
			logger.error("查询人员失败!",e);
		}
		return resp;
	}

	/**
	 *  新增员工
	 * @param emp
	 * @return
	 */
	@RequestMapping("/addEmployee")
	public ResponseMsg<String> addEmployee(Employee emp) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			employeeService.addEmployee(emp);
			resp.success("新增员工成功!");
		} catch (AppException e) {
			resp.fail("新增人员失败!");
			logger.error("新增人员失败!",e);
		} catch (Exception e) {
			resp.fail("新增人员失败!");
			logger.error("新增人员失败!",e);
		}
		return resp;
	}

	/**
	 * 编辑员工信息
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping("/editEmployee")
	public ResponseMsg<String> editEmployee(Employee emp) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			employeeService.editEmployee(emp);
			resp.success("修改人员成功!");
		} catch (AppException e) {
			resp.fail("保存人员失败!");
			logger.error("保存人员失败!",e);
		} catch (Exception e) {
			resp.fail("保存人员失败!");
			logger.error("保存人员失败!",e);
		}
		return resp;
	}

	/**
	 * 密码设置
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping("/setPassword")
	public ResponseMsg<String> setPassword(Employee emp) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			employeeService.setPassword(emp);
			resp.success("密码设置成功!");
		} catch (AppException e) {
			resp.fail("密码设置失败!");
			logger.error("密码设置失败!",e);
		} catch (Exception e) {
			resp.fail("密码设置失败!");
			logger.error("密码设置失败!",e);
		}
		return resp;
	}

	/**
	 * 任命管理员
	 * @param admin  管理员信息
	 * @return
	 */
	@RequestMapping("/assignAdmin")
	public ResponseMsg<String> assignAdmin(Employee admin) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			admin = employeeService.assignAdmin(admin);
			resp.success("设置管理员成功!");
		} catch (AppException e) {
			resp.fail("创建管理员失败!");
			logger.error("创建管理员失败!",e);
		} catch (Exception e) {
			resp.fail("创建管理员失败!");
			logger.error("创建管理员失败!",e);
		}
		return resp;
	}

	/**
	 * 删除管理员
	 * @param admin  管理员信息
	 * @return
	 */
	@RequestMapping("/removeAdmin")
	public ResponseMsg<String> removeAdmin(String orgCd) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			employeeService.removeAdmin(orgCd);
			resp.success("移除管理员成功!");
		} catch (AppException e) {
			resp.fail("移除管理员失败!");
			logger.error("移除管理员失败!",e);
		} catch (Exception e) {
			resp.fail("移除管理员失败!");
			logger.error("移除管理员失败!",e);
		}
		return resp;
	}

	/**
	 * 更新管理员
	 * 
	 * @param admin
	 *            管理员信息 
	 * @return
	 */
	@RequestMapping("/editAdmin")
	public ResponseMsg<String> editAdmin(Employee admin) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			admin = employeeService.editAdmin(admin);
			resp.success("更新管理员成功!");
		} catch (AppException e) {
			resp.fail("新管理员失败!");
			logger.error("新管理员失败!",e);
		} catch (Exception e) {
			resp.fail("新管理员失败!");
			logger.error("新管理员失败!",e);
		}
		return resp;
	}

	/**
	 * 获取公司管理人员
	 * 
	 * @param orgCd
	 *            管理员信息 
	 * @return
	 */
	@RequestMapping("/findAdminByOrg")
	public ResponseMsg<Employee> findAdminByOrg(String orgCd) {
		ResponseMsg<Employee> resp = new ResponseMsg<Employee>();
		// 判断机构是否为空
		if (ObjectHelper.isNotEmpty(orgCd)) {
			try {
				//查询管理员信息
				Employee emp = employeeService.getCompanyAdmin(orgCd);
				if (emp != null) {
					resp.success("获取管理员信息成功!");
					resp.setData(emp);
				} else {
					resp.fail("该机构不存在管理员信息!");
				}
			} catch (AppException e) {
				resp.fail("获取公司管理员失败!");
				logger.error("获取公司管理员失败!",e);
			} catch (Exception e) {
				resp.fail("获取公司管理员失败!");
				logger.error("获取公司管理员失败!",e);
			}
		}
		return resp;
	}

}
