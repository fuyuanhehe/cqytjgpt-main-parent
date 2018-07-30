package com.ccttic.cqytjgpt.webapi.mapper.role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.role.Role;
import com.ccttic.entity.role.Role_Emp;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.EmpRoleMenuVo;
import com.ccttic.entity.role.vo.OrgDepVo;

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
	public void deleteRole(Roles roles);

	/**
	 * 通过编码获取角色
	 * @param roleCd
	 * @return
	 */
	public Role findRoleByRoleCd(@Param("roleCd") String roleCd);


	/**
	 * 增加角色并关联员工
	 * @param role
	 */

	public	int addRoless(Roles roles);

	public	int addRoleEmp(List<Role_Emp> role);

	/**
	 * 分页角色
	 * @param roleNm
	 */
	public	long seRoleCount(Map<String, Object> params);

	public	List<Roles> seRoleAll(Map<String, Object> params);

	/**
	 * 删除角色员工关联
	 * @param id
	 */
	public int deleteEssRoleById(String role_id);

	
	/**
	 * 修改角色
	 * @param roles
	 */
	public int updateRoleById(Roles roles);
	/**
	 * 通过员工ID获取角色
	 * @param roles
	 */
	public List<Role_Emp> seRoleByEmpId(@Param("emp_id") String emp_id);
	
	
	//新增角色，查看所属的组织，部门，岗位
		 public List<EmpRoleMenuVo> getEmpParameter(Map<String, Object> params);
	     public long getEmpParameterCount(Map<String, Object> params);
		 
		 
	//获取组织机构   ，获取部门	 
		 public List<OrgDepVo> getOrgNm();	 
		 public List<OrgDepVo> getDep();
		 
		 
		 
}
