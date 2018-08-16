package com.ccttic.cqytjgpt.webapi.controller.role;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.auth.UrlFilterInvocationSecurityMetadataSource;
import com.ccttic.cqytjgpt.webapi.interfaces.role.IRoleMenuService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.role.RoleMenu;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.EmpVo;
import com.ccttic.entity.role.vo.MenuVo;
import com.ccttic.entity.role.vo.Model_RmsVo;
import com.ccttic.entity.role.vo.rolesPage;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.MenuTreeUtil;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/menus")
@Api(tags="菜单业务Contrller")
public class RoleMenuController {
	private  Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	 private	UrlFilterInvocationSecurityMetadataSource soruce;

	@Autowired
	private IRoleMenuService MenService;

	/**
	 * 功能说明： 条件角色，菜单分页
	 * @param roleNm 角色名字
	 * @param roleId  
	 * @return 
	 * @date  2018年6月4日
	 */
	@OperLogging(operType = 3)
	@RequestMapping(value="/loadMenuPages",method={RequestMethod.POST,RequestMethod.GET})
	@ResourceScan(rsc = @Resource(cd = Const.QUERY_MENU, name = "查询菜单", isMenue = false, hierarchy = 3, pcd = Const.MENU_MANAGE), prsc = {
			@Resource(cd = Const.MENU_MANAGE, name = "功能权限管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@ApiOperation(value="查询菜单",notes="access_token，必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
	    @ApiImplicitParam(name="roleNm",value="角色名字",required=false,paramType="form"),
	    @ApiImplicitParam(name="roleId",value="角色id",required=false,paramType="form"),
	    @ApiImplicitParam(name="page",value="第几页",required=false,paramType="form"),
	    @ApiImplicitParam(name="rows",value="条数",required=false,paramType="form"),
	})
	public  ResponseMsg<List<Model_RmsVo>> loadRolePages(@RequestBody(required = false) rolesPage tment) {
		ResponseMsg<List<Model_RmsVo>> resp = new ResponseMsg<List<Model_RmsVo>>();

		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			Page<Model_RmsVo> pager = this.MenService.getRoleMenuPages(page,tment);
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
	//	@PostMapping("/updateMenuByRole")
	@RequestMapping(value="/updateMenuByRole",method={RequestMethod.POST,RequestMethod.GET})
	@ResourceScan(rsc = @Resource(cd = Const.UPDATE_MENU, name = "修改角色权限", isMenue = false, hierarchy = 3, pcd = Const.MENU_MANAGE), prsc = {
			@Resource(cd = Const.MENU_MANAGE, name = "功能权限管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@ApiOperation(value="修改角色权限",notes="access_token，必传值")
	@ApiImplicitParams({
		@ApiImplicitParam(name="access_token",value="access_token",required=true,paramType="query"),
	    @ApiImplicitParam(name="roleId",value="角色id",required=true,paramType="form"),
	    @ApiImplicitParam(name="menuId",value="菜单id",required=true,paramType="form"),
	})
	public ResponseMsg<String> addMenu(@RequestBody Roles roles){
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
			soruce.loadModuleResources();

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
	@ResourceScan(rsc = @Resource(cd = Const.QUERYALL_MENU, name = "查询菜单树", isMenue = false, hierarchy = 3, pcd = Const.MENU_MANAGE), prsc = {
			@Resource(cd = Const.MENU_MANAGE, name = "功能权限管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@ApiOperation(value="查询菜单树")
	public ResponseMsg<List<Object>> seAllMenu(){
		ResponseMsg<List<Object>> resp = new ResponseMsg<>();

		try {

			List<MenuVo> data = MenService.seAllMenu();

			MenuTreeUtil menuTree = new MenuTreeUtil(); 
			List<Object> menuList = menuTree.menuList(data);
			resp.setData(menuList);
			resp.setMessage("菜单查询成功！");
			resp.setStatus(0);			

		} catch (Exception e) {
			resp.setMessage("菜单查询失败！");
			resp.setStatus(-1);	
			logger.error("菜单查询失败！",e);
		}

		return resp;
	}

	@OperLogging(operType = 3)
	@ResourceScan(rsc = @Resource(cd = Const.GETALL_EMP, name = "查询所有员工", isMenue = false, hierarchy = 3, pcd = Const.MENU_MANAGE), prsc = {
			@Resource(cd = Const.MENU_MANAGE, name = "功能权限管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	@RequestMapping(value="/seAllEmp",method={RequestMethod.POST,RequestMethod.GET})
	@ApiOperation(value="查询所有员工")
	public ResponseMsg<List<EmpVo>> seAllEmp(){
		ResponseMsg<List<EmpVo>>  resp = new ResponseMsg<>();

		try {
			List<EmpVo> data = MenService.seAllEmp();
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
	// emp_id 根据员工id获取角色，菜单
	@RequestMapping(value="/getTreeMenus",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<EmployeeVo> getTreeMenus(String emp_id){
		ResponseMsg<EmployeeVo>  resp = new ResponseMsg<>();

		try { 
			EmployeeVo data = MenService.seRoleMenuById(emp_id);
			resp.setData(data);
			resp.setMessage("角色菜单查询成功！");
			resp.setStatus(0);	
		} catch (Exception e) {
			resp.setMessage("角色菜单查询失败！");
			resp.setStatus(0);
			logger.error("角色菜单查询失败！",e);
		}

		return resp;
	} 
	//获取所有角色
	@RequestMapping(value="/getRoleNm",method={RequestMethod.POST,RequestMethod.GET})
	@ApiOperation(value="获取所有角色")
	public ResponseMsg<List<String>> getRoleNm(){
		ResponseMsg<List<String>>  resp = new ResponseMsg<>();
		try { 
			List<String> data = MenService.getRoleNm();
			resp.setData(data);
			resp.setMessage("所有角色查询成功！");
			resp.setStatus(0);	
		} catch (Exception e) {
			resp.setMessage("所有角色查询失败！");
			resp.setStatus(0);
			logger.error("所有角色查询失败！",e);
		}

		return resp;
	} 



}
