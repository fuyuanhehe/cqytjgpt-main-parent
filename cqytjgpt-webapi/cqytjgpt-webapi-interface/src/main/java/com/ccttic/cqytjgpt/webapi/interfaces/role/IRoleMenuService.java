package com.ccttic.cqytjgpt.webapi.interfaces.role;

import java.util.List;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.EmpRoleMenuVo;
import com.ccttic.entity.role.vo.EmpVo;
import com.ccttic.entity.role.vo.MenuVo;
import com.ccttic.entity.role.vo.Model_MenuVo;
import com.ccttic.entity.role.vo.Model_RmsVo;
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
	public void deleteRoleMenuByRoleId(Roles roles);
    
	
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
 	public List<EmpVo> seAllEmp();
 	
 	/**
	 * 查询菜单id，名称
	 * @param 
	 * @return
	 */
	
	public List<MenuVo> seAllMenu();
	
	/**
	 * 根据角色id查询对应的菜单
	 * @param 
	 * @return
	 */
		
	 public List<Model_MenuVo> seMenuByRoleIds( String roleId);
	 
	 // 员工id查询角色，菜单
	 public EmployeeVo seRoleMenuById(String emp_id);

	 //获取所有角色名字
	 public List<String> getRoleNm();
	 
}
