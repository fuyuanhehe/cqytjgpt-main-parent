package com.ccttic.service.role.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
import com.ccttic.mapper.role.RoleMapper;
import com.ccttic.mapper.role.RoleMenuMapper;
import com.ccttic.service.role.IRoleMenuService;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
@Service
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
	public Page<Roles> getRoleMenuPages(Pageable page, Roles roles) {
		Page<Roles> pager = new PageImpl<Roles>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		String roleids = roles.getRoleId();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		// params.put("roleId",roleids);
		params.put("roleNm", roles.getRoleNm());
		long totolRols  = Mapper.getPagesCount(params);
		List<Roles> records = Mapper.getRoleMenuPages(params);

		List<Roles> lists = new ArrayList<Roles>();
		
		if(!(ObjectHelper.isEmpty(roleids))){		    	
			for (Roles roModel : records) {
				if(roModel.getRoleId().equals(roleids)) {
					lists.add(roModel);
					pager.setTotalRows(new Long(1));
					pager.setRecords(lists);
					return pager;
				}

			}

		}


		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	@Transactional
	public void deletesRoleMenuById(String[] roleId) {

		Mapper.deletesRoleMenuById(roleId);

	}



}
