package com.ccttic.service.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.Model_MenuVo;
import com.ccttic.entity.role.vo.Model_RmsVo;
import com.ccttic.entity.role.vo.empModelVo;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

/**
功能说明：     角色菜单业务
@version  1.0.0
@author  Fy
@date  2018年6月1日
 */

public interface IRoleMenuService {

	/**
	 * 删除角色菜单
	 * @return
	 * @throws 
	 */		
	public void deleteRoleMenuByRoleId(String roleId);
    
	
	/**
	 * 批量角色菜单
	 * @return
	 * @throws 
	 */
    public void setRoleResource(List<RoleMenu> list);
    
	/**
	 * 分页角色员工菜单
	 * @return
	 * @throws 
	 */
     Page<Model_RmsVo> getRoleMenuPages(Pageable page,Roles roles);
     
     /**
 	 * 删除多个角色菜单
 	 * @return
 	 * @throws 
 	 */	
     public void deletesRoleMenuById(String [] roleId);
     
 	/**
 	 * 查询员工id，名称
 	 * @param 
 	 * @return
 	 */
 	public empModelVo seAllEmp();
 	
 	/**
	 * 查询菜单id，名称
	 * @param 
	 * @return
	 */
	
	public List<ResMenu> seAllMenu();
	
	/**
	 * 根据角色id查询对应的菜单
	 * @param 
	 * @return
	 */
		
	 public List<Model_MenuVo> seMenuByRoleId( String roleId);
}