package com.ccttic.auth.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.auth.model.Role;

/**
   功能说明：      MyBatis角色映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月11日
 */

public interface RoleMapper {

	/**
	 * 根据条件获取角色信息
	 * @param params
	 * @return
	 */
	public long countRole(Map<String, Object> params);

	/**
	 * 
	 * 根据条件获取角色信息总记录数
	 * @param params
	 * @return
	 */
	public List<Role> pagerRole(Map<String, Object> params);

	/**
	 * 编辑角色
	 * @param role
	 */
	public void addRole(@Param("role") Role role);

	/**
	 * 通过id获取角色信息
	 * @param id
	 * @return
	 */
	public Role findRoleById(@Param("id") String id);

	/**
	 * 修改角色
	 * @param role
	 */
	public void modifyRole(@Param("role") Role role);

	/**
	 * 通过ID删除角色信息
	 * @param id
	 */
	public void deleteRole(@Param("id") String id);

	/**
	 * 通过编码获取角色
	 * @param roleCd
	 * @return
	 */
	public Role findRoleByRoleCd(@Param("roleCd") String roleCd);

}
