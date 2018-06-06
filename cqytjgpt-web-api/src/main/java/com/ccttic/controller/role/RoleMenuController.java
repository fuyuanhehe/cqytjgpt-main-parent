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
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.Model_RmsVo;
import com.ccttic.service.role.IRoleMenuService;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.common.RandomHelper;
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
	public ResponseMsg<List<Model_RmsVo>> loadRolePages(PageRequest page,Roles roles) {
		ResponseMsg<List<Model_RmsVo>> resp = new ResponseMsg<List<Model_RmsVo>>();

		try {
			String roleIds = roles.getRoleId();

			if(!(ObjectHelper.isEmpty(roleIds))) {
				Page<Model_RmsVo> pager = this.MenService.getRoleMenuPages(page,roles);
				resp.setMessage("查询角色菜单成功！");
				resp.setStatus(0);
				resp.setData(pager.getRecords());
				resp.setTotal(pager.getTotalRows().intValue());
				return resp;
			}

			Page<Model_RmsVo> pager = this.MenService.getRoleMenuPages(page,roles);
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

	/**
	 * 功能说明：修改角色菜单
	 * @param roleId 角色id，多个用,隔开
	 * @param menuId 菜单id，多个用,隔开
	 * @return 
	 * @date  2018年6月4日
	 */
	@OperLogging(operType = 1)
	@GetMapping("/updateMenuByRole")
	public ResponseMsg<String> addMenu(Roles roles){
		ResponseMsg<String> resp = new ResponseMsg<>();
		try {
			// List<String> menuId = roles.getMenuIds();     
			String menuId = roles.getMenuIds();
			String roleId = roles.getRoleId();

			List<RoleMenu> list = new ArrayList<RoleMenu>(); 

			// 角色
			String arr [] = roleId.split(",");
			// 菜单ID
			String str [] = menuId.split(",");
			//   String [] str = (String[]) menuId.toArray();
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

	/**
	 * 功能说明：查询菜单所有的id，名称
	 * @param 
	 * @return 
	 * @date  2018年6月6日
	 */
	@OperLogging(operType = 3)
	@GetMapping("/seAllMenu")
	public ResponseMsg<Model_RmsVo> seAllMenu(){
		ResponseMsg<Model_RmsVo> resp = new ResponseMsg<>();

		try {
			Model_RmsVo model = new Model_RmsVo();

			List<ResMenu> data = MenService.seAllMenu();

			List<String> list = new ArrayList<>();
			List<String> listnum = new ArrayList<>();
			if(!ObjectHelper.isEmpty(data)){			
				for (ResMenu menu : data) {
					list.add(menu.getId());
					listnum.add(menu.getLabel());

				}

			}
			model.setEmp_Id(list);
			model.setEmpNms(listnum);
			resp.setData(model);
			resp.setMessage("菜单查询成功！");
			resp.setStatus(0);			

		} catch (Exception e) {
			resp.setMessage("菜单查询失败！");
			resp.setStatus(-1);	
			logger.error("菜单查询失败！",e);
		}



		return resp;
	}

	/**
	 * 功能说明：查询员工所有的id，名称
	 * @param 
	 * @return 
	 * @date  2018年6月6日
	 */
	@OperLogging(operType = 3)
	@GetMapping("/seAllEmp")
	public ResponseMsg<Model_RmsVo> seAllEmp(){
		ResponseMsg<Model_RmsVo> resp = new ResponseMsg<>();
         
		try {
			Model_RmsVo model = new Model_RmsVo();

			List<EssEmployee> data = MenService.seAllEmp();

			List<String> list = new ArrayList<>();
			List<String> listnum = new ArrayList<>();
			if(!ObjectHelper.isEmpty(data)){			
				for (EssEmployee menu : data) {
				list.add(menu.getId());
				listnum.add(menu.getEmpnm());
					

				}

			}
			model.setAllMenuIds(list);
			model.setAllMenus(listnum);
			resp.setData(model);
			resp.setMessage("员工查询成功！");
			resp.setStatus(0);			

		} catch (Exception e) {
			resp.setMessage("员工查询失败！");
			resp.setStatus(-1);	
			logger.error("员工查询失败！",e);
		}
		


		return resp;
	}


}
