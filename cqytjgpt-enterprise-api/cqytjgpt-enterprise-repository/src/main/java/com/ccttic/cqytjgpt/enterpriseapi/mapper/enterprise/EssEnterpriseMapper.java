package com.ccttic.cqytjgpt.enterpriseapi.mapper.enterprise;

import com.ccttic.entity.enterprise.DeptTree;
import com.ccttic.entity.enterprise.EnterVehicle;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.EssEnterpriseExample;
import com.ccttic.entity.enterprise.vo.EnterpriseDriverVo;
import com.ccttic.entity.enterprise.vo.EnterpriseVehiVo;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.EmpVo;
import com.ccttic.util.exception.AppException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EssEnterpriseMapper {
	long countByExample(EssEnterpriseExample example);

	int deleteByExample(EssEnterpriseExample example);

	int deleteByPrimaryKey(String id);

	int insert(EssEnterprise record);

	int insertSelective(EssEnterprise record);

	List<EssEnterprise> selectByExample(EssEnterpriseExample example);

	EssEnterprise selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") EssEnterprise record, @Param("example") EssEnterpriseExample example);

	int updateByExample(@Param("record") EssEnterprise record, @Param("example") EssEnterpriseExample example);

	int updateByPrimaryKeySelective(EssEnterprise record);

	int updateByPrimaryKey(EssEnterprise record);
	//查看企业下是否还有员工
	int hasemp(String id);
	//通过企业id查询组织名
	String selectOrgIdbyId(String id);

	/**
	 * 根据条件获取企业信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public List<EssEnterprise> qryEnterpriseList(Map<String, Object> params) throws AppException;

	/**
	 * 
	 * 根据条件获取企业信息总记录数
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryEnterpriseCount(Map<String, Object> params) throws AppException;
	/**
	 *@Author:zhy
	 *@Description:企业管理员获取企业信息
	 *@Date:10:25 2018/7/11
	 */
	public List<EssEnterprise> getEssEnterprise(@Param("id") String id)throws AppException;
	/**
	 *@Author:zhy
	 *@Description:通过组织id获取企业信息
	 *@Date:10:25 2018/7/11
	 */
	public List<EssEnterprise> getEssEnterpriseByOrgId(@Param("id") String id)throws AppException;

	/**
	 *@Author:zhy
	 *@Description:通过用户的id获取企业信息
	 *@Date:10:28 2018/7/11
	 */
	public EssEnterprise getEntByEmpId(@Param("id") String id)throws AppException;
	/**
	 *@Author:zhy
	 *@Description:通过adminid获取企业
	 *@Date:18:36 2018/8/1
	 */
	public EssEnterprise getEntByAdmin(@Param("id") String id)throws AppException;
	/*
	 * 企业下属车辆
	 */
	public List<EnterpriseVehiVo> getEnterpriseVe(Map<String, Object> map);

	public long getEnterpriseVeCount(Map<String, Object> map);


	/*
	 * 企业下属驾驶员
	 */
	public List<EnterpriseDriverVo > getEnterpriceDriver(Map<String, Object> map);

	public Long getEnterpriceDriverCount(Map<String, Object> map);


	// 企业选择车辆

	public int updateVehicleByid(EmpVo empVo);

	// <!-- 查询车辆以前的绑定企业 --> id
	public Vehicle getEnterVehicle(Vehicle vehicle);

	// 插入选择前的企业和车辆
	public int setEnterpriseVehicle(EnterVehicle en);


	// 企业选择驾驶人
	public int updateDriverByid(EmpVo empVo);

	// <!-- 查询驾驶人以前的绑定企业 --> id
	public Vehicle getEnterDriversBy(Vehicle vehicle);

	// 插入选择前的企业和驾驶人
	public int setEnterpriseDriver(EnterVehicle en);

	//<!-- 企业解绑车辆 -->
	public int relieveVehicleEnter(EmpVo empVo);
	
	// <!-- 企业解绑驾驶人 -->
	
	public int relieveDricerEnter(EmpVo empVo);
	/**
	 *@Author:zhy
	 *@Description: 获取当前组织下的企业
	 *@Date:15:39 2018/7/23
	 */
	List<EssEnterprise> selectEnterpriseList(Map<String, Object> params);
	/**
	 * 条数
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int selectEnterpriseListCount(Map<String, Object> params);
	
	
	//企业获取所有管理部门
	public List<String> getDepar();

	List<DeptTree> getDeptByEtpId(String etpId);

	List<DeptTree> getDeptBySuperId(String deptId);
}