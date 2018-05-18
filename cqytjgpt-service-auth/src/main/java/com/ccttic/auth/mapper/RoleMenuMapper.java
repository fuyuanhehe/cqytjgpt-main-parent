package com.ccttic.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.auth.model.RoleMenu;
import com.ccttic.auth.util.MyMapper;

/**
   功能说明：      MyBatis角色菜单映射
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.mapper.ess.ContractMapper.java
 @date  2016年12月10日
 */

public interface RoleMenuMapper extends MyMapper<RoleMenu>{
	/**
	 * 通过角色ID删除角色菜单关系表
	 * @param roleId
	 */
	public void deleteRoleMenuByRoleId(@Param("roleId") String roleId);

	/**
	 * 批量增加角色菜单关系
	 * @param rms
	 */
	public void setRoleResource(@Param("rms") List<RoleMenu> rms);

	/**
	 * 获取角色已有权限菜单
	 * @param roleId
	 * @return
	 */
	public List<RoleMenu> findRoleResources(@Param("roleId") String roleId);

}