package com.ccttic.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.auth.model.EmpMenu;
import com.ccttic.auth.util.MyMapper;

/**
   功能说明：      MyBatis人员菜单映射
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.mapper.ess.ContractMapper.java
 @date  2016年12月10日
 */

public interface EmpMenuMapper extends MyMapper<EmpMenu> {
	/**
	 * 通过人员ID删除人员菜单关系表
	 * @param empId
	 */
	public void deleteEmpMenuByEmpId(@Param("empId") String empId);

	/**
	 * 批量增加人员菜单关系
	 * @param ems
	 */
	public void setEmpResource(@Param("ems") List<EmpMenu> ems);

	/**
	 * 获取人员已有权限菜单
	 * @param empId
	 * @return
	 */
	public List<EmpMenu> findEmpResources(@Param("empId") String empId);

}
