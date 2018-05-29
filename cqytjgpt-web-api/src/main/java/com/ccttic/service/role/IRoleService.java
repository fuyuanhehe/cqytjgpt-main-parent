package com.ccttic.service.role;


import java.util.List;

import com.ccttic.entity.role.Role;
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

}
