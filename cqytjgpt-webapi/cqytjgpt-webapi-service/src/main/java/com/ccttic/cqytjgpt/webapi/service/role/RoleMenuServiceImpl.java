package com.ccttic.cqytjgpt.webapi.service.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.role.IRoleMenuService;
import com.ccttic.cqytjgpt.webapi.mapper.role.RoleMapper;
import com.ccttic.cqytjgpt.webapi.mapper.role.RoleMenuMapper;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.RoleModels;
import com.ccttic.entity.role.Role_Emp;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.MenuVo;
import com.ccttic.entity.role.vo.Model_MenuVo;
import com.ccttic.entity.role.vo.Model_RmsVo;
import com.ccttic.entity.role.vo.empModelVo;
import com.ccttic.util.common.MenuTreeUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

/**
功能说明：     功能权限功能
@version  1.0.0
@date  
 */
@Service
public class RoleMenuServiceImpl implements IRoleMenuService {

	@Autowired
	private RoleMenuMapper Mapper;
	@Autowired
	private RoleMapper roleMapper;

	// 删除角色菜单关联
	@Override
	@Transactional
	public void deleteRoleMenuByRoleId(String roleId) {

		Mapper.deleteRoleMenuByRoleId(roleId);;
	}
	// 插入角色菜单关联
	@Override
	@Transactional
	public void setRoleResource(List<RoleMenu> list) {
		Mapper.setRoleResource(list);

	}

	@Override
	public Page<Model_RmsVo> getRoleMenuPages(Pageable page, Roles roles) {
		Page<Model_RmsVo> pager = new PageImpl<Model_RmsVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		List<Model_RmsVo> modellist = new ArrayList<>();

		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("roleId",roles.getRoleId());
		params.put("roleNm", roles.getRoleNm());
		long totolRols  = Mapper.getPagesCount(params);
		List<Roles> records = Mapper.getRoleMenuPages(params);
		List<String> arr = new ArrayList<>();

		for (Roles man : records) {
			List<MenuVo> mList = new ArrayList<>();
			Model_RmsVo demol = new Model_RmsVo();
			arr.add(man.getRoleId());
			demol.setRoleId(man.getRoleId());
			demol.setRoleCd(man.getRoleCd());
			demol.setRoleNm(man.getRoleNm());
			demol.setDescription(man.getDescription());
			demol.setEmpName(man.getEmpNms());
			List<Model_MenuVo> data = Mapper.seMenuByRoleIds(man.getRoleId());
			for (Model_MenuVo mm : data) {
				MenuVo mun = new MenuVo();
				mun.setTitle(mm.getLabel());
				mun.setUrl(mm.getPath());
				mun.setType(mm.getIsmenu());
				mun.setCen(mm.getHierarchy());
				mun.setId(mm.getResource());
				mun.setpId(mm.getGroupresource());
				mun.setMenuId(mm.getId());
				mList.add(mun);
			}
			MenuTreeUtil menuTree = new MenuTreeUtil(); 
			List<Object> menuList = menuTree.menuList(removeDuplicate(mList));
			demol.setMenus(menuList);
			modellist.add(demol);
		}

		pager.setTotalRows(totolRols);
		pager.setRecords(modellist);
		return pager;
	}

	@Override
	@Transactional
	public void deletesRoleMenuById(String[] roleId) {

		Mapper.deletesRoleMenuById(roleId);

	}

	@Override
	public List<MenuVo> seAllMenu() {

		List<ResMenu> data = Mapper.seAllMenu();
		List<MenuVo> list = new ArrayList<>();
		for (ResMenu resMenu : data) {
			MenuVo menuVo = new MenuVo();
			menuVo.setId(resMenu.getResource());
			menuVo.setpId(resMenu.getGroupresource());
			menuVo.setTitle(resMenu.getLabel());
			menuVo.setUrl(resMenu.getPath());
			menuVo.setType(resMenu.getIsmenu());
			menuVo.setCen(resMenu.getHierarchy());
			menuVo.setMenuId(resMenu.getId());
			list.add(menuVo);
		}

		return list;
	}
	@Override
	public List<Model_MenuVo> seMenuByRoleIds(String roleId) {
		// TODO Auto-generated method stub
		return Mapper.seMenuByRoleIds(roleId);
	}


	@Override
	public empModelVo seAllEmp() {
		// TODO Auto-generated method stub
		EssEmployee data = Mapper.seAllEmp();
		List<String> listid = new ArrayList<>();

		List<String> listenm = new ArrayList<>();  

		empModelVo modelVo = new empModelVo();

		String [] arr = data.getId().split(",");

		String [] array = data.getEmpnm().split(",");

		for (int i = 0; i < array.length; i++) {
			listid.add(arr[i]);
			listenm.add(array[i]);
		}

		modelVo.setEmpId(listid);
		modelVo.setEmpNm(listenm);

		return modelVo;
	}
	@Override
	public EmployeeVo  seRole_MenuById(String emp_id) {

		List<RoleModels> list = new ArrayList<>();
		//多个角色ID
		List<Role_Emp> role_Emp = roleMapper.seRoleByEmpId(emp_id);
		String arrs [] = new String[role_Emp.size()];
		//多个角色id
		for (int i = 0; i < role_Emp.size(); i++) {
			Role_Emp ss = role_Emp.get(i);
			arrs[i] = ss.getRole_id();
		} 
		// 通过角色ID获取菜单
		List<Model_MenuVo> menu = Mapper.seMenuByRoleId(arrs)  ;
		//菜单
		List<MenuVo> mList = new ArrayList<>();

		for (Model_MenuVo mm : menu) {
			RoleModels models = new RoleModels();
			models.setRoleId(mm.getRoleId());
			models.setRoleCd(mm.getRoleCd());
			models.setRoleNm(mm.getRoleNm());
			models.setDescription(mm.getDescription());
			list.add(models);

		}
		for (Model_MenuVo mm : menu) {
			MenuVo mun = new MenuVo();
			mun.setTitle(mm.getLabel());
			mun.setUrl(mm.getPath());
			mun.setType(mm.getIsmenu());
			mun.setCen(mm.getHierarchy());
			mun.setId(mm.getResource());
			mun.setpId(mm.getGroupresource());
			mun.setMenuId(mm.getId());
			mList.add(mun);
		}

		MenuTreeUtil menuTree = new MenuTreeUtil(); 
		List<Object> menuList = menuTree.menuList(removeDuplicate(mList));
		EmployeeVo emp = new EmployeeVo();
		emp.setModels(removeDuplicates(list)); 
		emp.setMenus(menuList);

		return  emp;

	}

	public   static  List<MenuVo>  removeDuplicate(List<MenuVo> list)  {       
		for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {       
			for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {       
				if  (list.get(j).getId().equals(list.get(i).getId() ))  {       
					list.remove(j);       
				}        
			}        
		}        
		return list;       
	}	
	public   static  List<RoleModels>  removeDuplicates(List<RoleModels> list)  {       
		for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {       
			for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {       
				if  (list.get(j).getRoleId().equals(list.get(i).getRoleId() ))  {       
					list.remove(j);       
				}        
			}        
		}        
		return list;       
	}	
	public static void main(String[] args) {
		List<MenuVo> list	= new ArrayList<>();
		MenuVo m = new MenuVo();
		m.setId("Root");
		m.setpId("0");
		MenuVo m1 = new MenuVo();
		m1.setId("2");
		m1.setpId("Root");

		MenuVo m2 = new MenuVo();
		m2.setId("3");
		m2.setpId("2");
		MenuVo m3 = new MenuVo();

		m3.setId("33");
		m3.setpId("3");

		MenuVo m4 = new MenuVo();
		m4.setId("44");
		m4.setpId("3");

		MenuVo m5 = new MenuVo();
		m5.setId("55");
		m5.setpId("33");

		list.add(m);
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		MenuTreeUtil menuTree = new MenuTreeUtil(); 

		for (MenuVo menuVo : list) {
			System.out.println(menuVo);
		}

		List<Object> menuList = menuTree.menuList(list); 
		System.out.println(menuList);


	}

}