package com.ccttic.mapper.role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
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


	/**
	 * 角色，员工，菜单条件分页
	 * @param 
	 * @return
	 */
	public long getPagesCount(Map<String, Object> params);

	public List<Roles> getRoleMenuPages(Map<String, Object> params);

	/**
	 * 删除角色菜单关系
	 * @param 
	 * @return
	 */

	public void deletesRoleMenuById(String [] roleId);

	/**
	 * 查询菜单id，名称
	 * @param 
	 * @return
	 */
	
	public List<ResMenu> seAllMenu();
	/**
	 * 查询员工id，名称
	 * @param 
	 * @return
	 */
	public List<EssEmployee> seAllEmp();
	
}
