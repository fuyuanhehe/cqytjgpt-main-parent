package com.ccttic.cqytjgpt.webapi.controller.role;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.role.IRoleMenuService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.Model_RmsVo;
import com.ccttic.entity.role.vo.empModelVo;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping("/menus")
public class RoleMenuController {
	private  Logger logger = Logger.getLogger(this.getClass());


	@Autowired
	private IRoleMenuService MenService;

	/**
	 * 功能说明： 条件角色，菜单分页
	 * @param roleNm 角色名字
	 * @param   
	 * @return 
	 * @date  2018年6月4日
	 */
	@OperLogging(operType = 3)
	@RequestMapping(value="/loadMenuPages",method={RequestMethod.POST,RequestMethod.GET})
	public  ResponseMsg<List<Model_RmsVo>> loadRolePages( PageRequest page,@RequestBody Roles roles) {
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
			logger.error("查询角色菜单分页失败！"+roles,e);
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
	//	@PostMapping("/updateMenuByRole")
	@RequestMapping(value="/updateMenuByRole",method={RequestMethod.POST,RequestMethod.GET})
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
	@RequestMapping(value="/seAllMenu",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<ResMenu>> seAllMenu(){
		ResponseMsg<List<ResMenu>> resp = new ResponseMsg<>();

		try {
			List<ResMenu> data = MenService.seAllMenu();

			resp.setData(data);
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
	@RequestMapping(value="/seAllEmp",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<empModelVo> seAllEmp(){
		ResponseMsg<empModelVo>  resp = new ResponseMsg<>();

		try {
			empModelVo data = MenService.seAllEmp();
			resp.setData(data);
			resp.setMessage("员工查询成功！");
			resp.setStatus(0);			

		} catch (Exception e) {
			resp.setMessage("员工查询失败！");
			resp.setStatus(-1);	
			logger.error("员工查询失败！",e);
		}

		return resp;
	}

/*	@RequestMapping(value="/getTreeMenus",method={RequestMethod.POST,RequestMethod.GET})
	public List<Object> getTreeMenus(String emp_id){

		List<MenuVo>  data = MenService.seRole_MenuById(emp_id);

		MenuTreeUtil menuTree = new MenuTreeUtil();  

		List<Object> menuList = menuTree.menuList(data);

		return menuList;
		
	} */



}
