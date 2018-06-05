package com.ccttic.controller.role;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.beans.ResponseMsg;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
import com.ccttic.service.role.IRoleMenuService;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.common.StringHelper;
import com.ccttic.util.logger.annotation.OperLogging;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping("/menus")
public class RoleMenuController {

	@Autowired
	private IRoleMenuService MenService;

	private final Logger logger = LoggerFactory.getLogger(RoleMenuController.class);
	/**
	 * 功能说明： 条件角色，菜单分页
	 * @param roleNm 角色名字
	 * @param   
	 * @return 
	 * @date  2018年6月4日
	 */
	@OperLogging(operType = 3)
	@GetMapping("/loadMenuPages")
	public ResponseMsg<List<Roles>> loadRolePages(PageRequest page,Roles roles) {
		ResponseMsg<List<Roles>> resp = new ResponseMsg<List<Roles>>();

		try {
			String roleIds = roles.getRoleId();
			
			if(!(ObjectHelper.isEmpty(roleIds))) {
				Page<Roles> pager = this.MenService.getRoleMenuPages(page,roles);
				resp.setMessage("查询角色菜单成功！");
				resp.setStatus(0);
				resp.setData(pager.getRecords());
				resp.setTotal(pager.getTotalRows().intValue());
				return resp;
			}
			
			Page<Roles> pager = this.MenService.getRoleMenuPages(page,roles);
			resp.setMessage("查询角色菜单分页成功！");
			resp.setStatus(0);
			resp.setData(pager.getRecords());
			resp.setTotal(pager.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("查询角色菜单分页失败！");
			resp.setStatus(-1);
			logger.error("查询角色菜单分页失败！",e);
		}

		return resp;

	}

	@OperLogging(operType = 1)
	@GetMapping("/updateMenuByRole")
	public ResponseMsg<String> addMenu(Roles roles){
		ResponseMsg<String> resp = new ResponseMsg<>();
		try {
			String menuId = roles.getMenuIds();     
	          
			String roleId = roles.getRoleId();
										
			List<RoleMenu> list = new ArrayList<RoleMenu>(); 
						
			 // 角色
			String arr [] = roleId.split(",");
			// 菜单ID
            String str [] = menuId.split(",");
             // 删除关联
            MenService.deletesRoleMenuById(arr);
            for (int i = 0; i < arr.length; i++) {
            	
            	 for (int j = 0; j < str.length; j++) {
            	RoleMenu rome = new RoleMenu();
            	rome.setId(RandomHelper.uuid());
            	rome.setRoleId(arr[i]);
            	rome.setMenuId(str[j]);
            	rome.setVersion(1);
            	list.add(rome);
            	 }
			}  
            
            MenService.setRoleResource(list);
            resp.setMessage("修改菜单成功！");
			resp.setStatus(0);
            
		} catch (Exception e) {
			resp.setMessage("修改菜单失败！");
			resp.setStatus(0);
			logger.error("修改菜单失败！",e);
		}


		return resp;
	}

}
