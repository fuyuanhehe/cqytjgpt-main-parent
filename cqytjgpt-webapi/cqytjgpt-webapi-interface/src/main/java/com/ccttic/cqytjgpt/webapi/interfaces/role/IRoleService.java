package com.ccttic.cqytjgpt.webapi.interfaces.role;


import java.util.List;
import com.ccttic.entity.role.Role;
import com.ccttic.entity.role.Role_Emp;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.EmpRoleMenuVo;
import com.ccttic.entity.role.vo.ModelByRole;
import com.ccttic.entity.role.vo.RoleMenuVo;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

/**
   功能说明：     角色业务接口
 @version  1.0.0
 @author  xgYin
 @see  com.ccttic.service.role.studio.framework.service.ess.IRoleService.java
 @date  2016年12月11日
 */

public interface IRoleService {

	/**
	 * 获取所有角色信息
	 * @param page
	 * @param role
	 * @return
	 * @throws AppException
	 */
	Page<Role> loadRolePages(Pageable page, Role role);

	/**
	 * 编辑角色信息
	 * @param role
	 * @return
	 * @throws AppException
	 */
	boolean editRole(Role role);

	/**
	 * 通过ID获取角色信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Role findRoleById(String id);

	/**
	 * 通过ID删除角色信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public boolean deleteRole(String id);

	/**
	 * 查询所有角色对应的菜单
	 * @return
	 * @throws AppException
	 */
	public List<RoleMenuVo> findAllRoleMeun();

	/**
	 * 增加角色关联员工
	 * @return
	 * @throws AppException
	 */
	public void addRoless(Roles rolty);

	public void addRole_Emp(List<Role_Emp> role);

	/**
	 * 分页角色
	 * @return
	 * @throws AppException
	 */

	Page<Roles> seAllRole(Pageable page,Roles roles);

	/**
	 * 修改角色信息和关联的员工
	 * @return
	 * @throws AppException
	 */
	public void updateEssRole(Roles roles);
		
	/**
	 * 通过员工ID获取角色
	 * @param roles
	 */
	public ModelByRole seRoleByEmpId(String emp_id);	
	

	//新增角色，查看所属的组织，部门，岗位
	 Page<EmpRoleMenuVo> getEmpParameter(Pageable page,EmpRoleMenuVo emp);
}
