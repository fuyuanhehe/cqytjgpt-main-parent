package com.ccttic.cqytjgpt.enterpriseapi.interfaces.enterprise;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseDriverVo;
import com.ccttic.entity.enterprise.vo.EnterpriseVehiVo;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;
import com.ccttic.entity.enterprise.vo.PageEssEnterpriseVo;
import com.ccttic.entity.role.vo.EmpVo;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IEnterpriseService {

	/**
	 * 通过企业id查询企业详情
	 * @param map
	 * @return
	 */
	public Map<String,Object> selectEnterpriseById(Map<String, String> map);
	/**
	 * 修改企业信息
	 * @return
	 */
	public void modifyEnterpriseById(EssEnterprise essEnterprise)throws AppException;
	/**
	 * 删除企业
	 * @return
	 */
	public int delEnterpriseById(EssEnterprise essEnterprise) throws AppException;

	/**
	 * 
	 * @Title: registerEnterpries  
	 * @Description: 企业注册 
	 * @param @param vo
	 * @param @return
	 * @param @throws Exception    参数  
	 * @return int    返回类型  
	 * @throws
	 */
	public int registerEnterpries(EnterpriseVo vo)throws AppException;

	/**
	 * 根据条件获取企业信息
	 * @param page
	 * @param vo
	 * @return
	 * @throws AppException
	 */
	public Page<EssEnterprise> qryEssEnterpriseList(Pageable page, EssEnterprise vo) throws AppException;

	public List<EssEnterprise> getEssEnterprise(String id)throws AppException;

	/*
	 * 企业下属车辆
	 */

	public Page<EnterpriseVehiVo> getEnterpriseVe(Pageable page,EnterpriseVehiVo envo, EmployeePermission employeePermission)throws AppException ;

	/*
	 * 企业下属驾驶人
	 */
	public Page<EnterpriseDriverVo> getEnterpriceDriver(Pageable page,EnterpriseDriverVo envo, EmployeePermission employeePermission)throws AppException ;


	// 企业选择车辆

	public void updateVehicleByid(EmpVo empVo);

	// 企业选择驾驶人

	public void updateDriverById(EmpVo empVo);	


	//<!-- 企业解绑车辆 -->
	public void relieveVehicleEnter(EmpVo empVo);

	// <!-- 企业解绑驾驶人 -->

	public void relieveDricerEnter(EmpVo empVo);
	/**
	 *@Author:zhy
	 *@Description: 获取当前组织下的企业
	 *@Date:15:37 2018/7/23
	 */
	Page<EssEnterprise> selectEnterpriseList(Pageable page,EssEnterprise ess);
	
	//企业获取所有管理部门
		public List<String> getDepar();
}
