package com.ccttic.mapper.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.vo.RoleMenuVo;


/**
   功能说明：      MyBatis角色菜单映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月10日
 */

public interface RoleMenuMapper {
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
	
	/**
	 * 获取所有角色的权限菜单
	 * @param roleId
	 * @return
	 */
	public List<RoleMenuVo> findRoleAllResources();

}
