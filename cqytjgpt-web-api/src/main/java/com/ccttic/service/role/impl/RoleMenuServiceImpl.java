package com.ccttic.service.role.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.Model_MenuVo;
import com.ccttic.entity.role.vo.Model_RmsVo;
import com.ccttic.entity.role.vo.empModelVo;
import com.ccttic.mapper.role.RoleMenuMapper;
import com.ccttic.service.role.IRoleMenuService;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
@Service

/**
功能说明：     功能权限功能
@version  1.0.0
@date  
 */

public class RoleMenuServiceImpl implements IRoleMenuService {

	@Autowired
	private RoleMenuMapper Mapper;

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
	public List<Model_MenuVo> seMenuByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return Mapper.seMenuByRoleId(roleId);
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



}
