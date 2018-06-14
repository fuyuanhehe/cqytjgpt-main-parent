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
import com.ccttic.util.common.ObjectHelper;
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
		// TODO Auto-generated method stub
		Mapper.setRoleResource(list);

	}

	@Override
	public Page<Model_RmsVo> getRoleMenuPages(Pageable page, Roles roles) {
		Page<Model_RmsVo> pager = new PageImpl<Model_RmsVo>(page);

		Map<String, Object> params = new HashMap<String, Object>();

		List<Model_RmsVo> modellist = new ArrayList<>();

		String roleids = roles.getRoleId();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		// params.put("roleId",roleids);
		params.put("roleNm", roles.getRoleNm());
		long totolRols  = Mapper.getPagesCount(params);
		List<Roles> records = Mapper.getRoleMenuPages(params);

		for (Roles man : records) {
			Model_RmsVo demol = new Model_RmsVo();
			List<String> list = new ArrayList<>();

			List<String> listnm = new ArrayList<>();

			List<String> listenm = new ArrayList<>();

			demol.setRoleId(man.getRoleId());
			demol.setRoleCd(man.getRoleCd());
			demol.setRoleNm(man.getRoleNm());
			demol.setDescription(man.getDescription());

			/*String [] string3 = man.getEmpNms().split(",");
			for (int i = 0; i < string3.length; i++) {
				listenm.add(string3[i]);
			} */ 
			demol.setEmpName(man.getEmpNms());

			//	listenm.add( man.getEmpNms());

			String [] string = man.getMenuIds().split(",");
			for (int i = 0; i < string.length; i++) {
				list.add(string[i]);
			}  
			String [] string2 = man.getMenuLabels().split(","); 
			for (int i = 0; i < string2.length; i++) {
				listnm.add(string2[i]);
			} 
			demol.setEmpNms(listenm);
			demol.setAllMenuIds(list);
			demol.setAllMenus(listnm);
			modellist.add(demol);
		}

		if(!(ObjectHelper.isEmpty(modellist))){		    	
			for (Model_RmsVo roModel : modellist) {
				if(roModel.getRoleId().equals(roleids)) {
					List<Model_RmsVo> main = new ArrayList<>();
					main.add(roModel);
					pager.setTotalRows(new Long(1));
					pager.setRecords(main);
					return pager;
				}
			}
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
	public List<ResMenu> seAllMenu() {
		// TODO Auto-generated method stub
		return Mapper.seAllMenu();
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
		//多个角色
		for (int i = 0; i < role_Emp.size(); i++) {
			Role_Emp ss = role_Emp.get(i);
			arrs[i] = ss.getRole_id();
		} 
		// 通过角色ID获取菜单
		List<Model_MenuVo> menu = Mapper.seMenuByRoleId(arrs)  ;
		// 不重复的角色
		List<RoleModels> roleModels = new ArrayList<>();
		String str = "" ;
		//菜单
		List<MenuVo> mList = new ArrayList<>();

		for (Model_MenuVo mm : menu) {
			RoleModels models = new RoleModels();
			MenuVo mun = new MenuVo();
			models.setRoleId(mm.getRoleId());
			models.setRoleCd(mm.getRoleCd());
			models.setRoleNm(mm.getRoleNm());
			models.setDescription(mm.getDescription());
			mun.setTitle(mm.getLabel());
			mun.setUrl(mm.getPath());
			mun.setType(mm.getIsmenu());
			mun.setCen(mm.getHierarchy());
			mun.setId(mm.getResource());
			mun.setpId(mm.getGroupresource());
			list.add(models);
			mList.add(mun);
		}
		for (int i = 0; i < list.size(); i++) {
			RoleModels ar = list.get(i);

			if(i==0|| str!=ar.getRoleId()){

				roleModels.add(ar);   
			}  
			str = ar.getRoleId();
		}
		MenuTreeUtil menuTree = new MenuTreeUtil(); 
		List<Object> menuList = menuTree.menuList(mList);
		EmployeeVo emp = new EmployeeVo();
		emp.setModels(roleModels); 
		emp.setMenus(menuList);

		return  emp;

	}


}
