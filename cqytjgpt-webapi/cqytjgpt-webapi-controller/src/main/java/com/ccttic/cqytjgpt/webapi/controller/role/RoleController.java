package com.ccttic.cqytjgpt.webapi.controller.role;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ccttic.cqytjgpt.webapi.interfaces.role.IRoleService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.role.Role_Emp;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.EmpRoleMenuVo;
import com.ccttic.entity.role.vo.OrgAndDep;
import com.ccttic.entity.role.vo.rolesPage;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;
/*
 * 功能说明：角色业务操作
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private IRoleService  Roleservice;

	/**
	 * 功能说明：  通过ID删除角色信息
	 * @param id 角色的ID
	 * @return
	 * @date  2018年5月30日
	 * 
	 */ 	
	@OperLogging(operType = 2)
	@RequestMapping(value="/deleteRoleById",method={RequestMethod.POST,RequestMethod.GET})
	@ResourceScan(rsc = @Resource(cd = Const.DELETE_ROLE, name = "删除角色",  hierarchy = 4, isMenue = false, pcd = Const.QUERY_ROLE)
	, prsc = {@Resource( cd = Const.QUERY_ROLE, name = "查询角色信息", isMenue = false, hierarchy = 3, pcd = Const.ROLE_MANAGE),
			@Resource( cd = Const.ROLE_MANAGE, name = "角色管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource( cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public ResponseMsg<String> deleteById(@RequestBody Roles roles) {

		ResponseMsg<String> resp = new ResponseMsg<>();

		try {

			if( !(ObjectHelper.isEmpty(roles) )) {		
				Roleservice.deleteRole(roles);
				resp.setStatus(0);
				resp.setMessage("删除角色成功!");

			}
		} catch (Exception e) {
			resp.setStatus(-1);
			resp.setMessage("删除角色失败!");				
			logger.error("删除角色失败!",e);

		}
		return resp;

	}

	/**
	 * 功能说明：  增加角色并关联员工
	 * @param  roleCd 角色编码
	 * @param  roleNm 角色名称
	 * @param  description 角色描述
	 * @param  emp_id 员工ID 多个用,隔开
	 * 
	 * @return
	 * @date  2018年5月31日
	 */
	@OperLogging(operType = 0,content="新增角色")
	@RequestMapping(value="/addRole_Emp",method={RequestMethod.POST,RequestMethod.GET})
	@ResourceScan(rsc = @Resource(cd = Const.ADD_ROLE, name = "新增角色",  hierarchy = 4, isMenue = false, pcd = Const.QUERY_ROLE)
	, prsc = {@Resource( cd = Const.QUERY_ROLE, name = "查询角色信息", isMenue = false, hierarchy = 3, pcd = Const.ROLE_MANAGE),
			@Resource( cd = Const.ROLE_MANAGE, name = "角色管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource( cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public ResponseMsg<String> addRole_Emp(@RequestBody(required = false) Roles rolty) {
		ResponseMsg<String> resp = new ResponseMsg<>();
		if(ObjectHelper.isNotEmpty(rolty)) {
			// 角色ID
			String  idss = RandomHelper.uuid();
			//员工ID
			String str = rolty.getEmp_id();
			if(str != null)  {
				List<Role_Emp> roles = new ArrayList<Role_Emp>(); 
				String [] strs = str.split(",");

				for(int i =0 ; i<strs.length; i++) {
					//循环添加角色关联员工
					Role_Emp emp = new Role_Emp();
					emp.setRole_id(idss);
					emp.setVersion(1);
					emp.setId(RandomHelper.uuid());
					emp.setEmp_id(strs[i]);
					roles.add(emp);
				}

				rolty.setId(idss);
				Roleservice.addRoless(rolty);
				Roleservice.addRole_Emp(roles);
				resp.setMessage("添加角色关联员工成功");
				resp.setStatus(0);
				resp.success("添加角色关联员工成功");
				return resp;
			}
			try {
				rolty.setId(idss);
				Roleservice.addRoless(rolty);
				resp.setMessage("添加角色成功");
				resp.setStatus(0);
				resp.success("添加角色成功");
			} catch (Exception e) {
				resp.success("添加角色关联员工失败");
				resp.setStatus(-1);
				resp.setMessage("添加角色关联员工失败");
				logger.error("添加角色关联员工失败",e);
			}

		}
		return resp;
	}

	/**
	 * 功能说明： 条件角色和关联的员工分页
	 * @param roles roleNm 角色名称,筛选
	 * @param roles roleId 角色ID,获得具体角色信息
	 * @return 	
	 * @date  2018年6月1日
	 */
	@OperLogging(operType = 3,content="查询角色所属的人员")
	@RequestMapping(value="/loadRolePages",method={RequestMethod.POST,RequestMethod.GET})
	@ResourceScan(rsc = @Resource(cd = Const.QUERY_ROLE, name = "查询角色", isMenue = false, hierarchy = 3, pcd = Const.ROLE_MANAGE), prsc = {
			@Resource(cd = Const.ROLE_MANAGE, name = "角色管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<List<Roles>> loadRolePages(@RequestBody(required = false) rolesPage tment)  {
		ResponseMsg<List<Roles>> resp = new ResponseMsg<List<Roles>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			Page<Roles> pager = this.Roleservice.seAllRole(page,tment);
			resp.setMessage("(根据条件)查询角色列表成功！");
			resp.setStatus(0);
			resp.setData(pager.getRecords());
			resp.setTotal(pager.getTotalRows().intValue());

		} catch (Exception e) {
			resp.setMessage("根据条件查询角色列表失败！");
			resp.setStatus(-1);
			logger.error("根据条件查询角色列表失败！",e);
		}
		return resp;  
	}

	/**
	 * 功能说明：  修改角色和关联的员工
	 *        roleId  
	 * @param roleCd 角色编码
	 * @param roleNm 角色名称
	 * @param description 角色描述
	 * @param emp_id 员工ID 多个用,隔开
	 * @return
	 * @date  2018年6月1日
	 */
	@OperLogging(operType = 1)
	@RequestMapping(value="/updateEssRole",method={RequestMethod.POST,RequestMethod.GET})
	@ResourceScan(rsc = @Resource(cd = Const.UPDATE_ROLE, name = "修改角色",  hierarchy = 4, isMenue = false, pcd = Const.QUERY_ROLE)
	, prsc = {@Resource( cd = Const.QUERY_ROLE, name = "查询角色信息", isMenue = false, hierarchy = 3, pcd = Const.ROLE_MANAGE),
			@Resource( cd = Const.ROLE_MANAGE, name = "角色管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource( cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public ResponseMsg<List<Roles>> updateEssRole(@RequestBody Roles roles){
		ResponseMsg<List<Roles>> resp = new ResponseMsg<List<Roles>>();

		try {
			Roleservice.updateEssRole(roles);
			resp.setMessage("修改角色成功!");
			resp.setStatus(0);

		} catch (Exception e) {
			resp.success("添加角色关联员工失败");
			resp.setMessage("添加角色关联员工失败");
			resp.setStatus(-1);
			logger.error("修改角色关联员工成功失败",e);
		}

		return resp;

	}	
	/**
	 * 功能说明： 
	 * orgNm
	 * depNm
	 * empNm
	 * @return
	 */
	@RequestMapping(value="/getEmpParameter",method={RequestMethod.POST,RequestMethod.GET})
	@ResourceScan(rsc = @Resource(cd = Const.ADD_ROLE_EMP, name = "增加角色,获取用户信息",  hierarchy = 4, isMenue = false, pcd = Const.QUERY_ROLE)
	, prsc = {@Resource( cd = Const.QUERY_ROLE, name = "查询角色信息", isMenue = false, hierarchy = 3, pcd = Const.ROLE_MANAGE),
			@Resource( cd = Const.ROLE_MANAGE, name = "角色管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource( cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	@OperLogging(operType = 3)
	public ResponseMsg<List<EmpRoleMenuVo> > getEmpParameter(@RequestBody EmpRoleMenuVo emp){
		ResponseMsg<List<EmpRoleMenuVo>> resp = new ResponseMsg<List<EmpRoleMenuVo>>();

		try {
			PageRequest page = new PageRequest();
			page.setPage(emp.getPage());
			page.setRows(emp.getRows());
			Page<EmpRoleMenuVo> data = Roleservice.getEmpParameter(emp, page);

			resp.setData(data.getRecords());
			resp.setTotal(data.getTotalRows().intValue());
			resp.setMessage("获取用户信息成功!");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("获取用户信息成功");
			resp.setStatus(-1);
			logger.error("修改角色关联员工成功失败",e);
		}

		return resp;

	}	

	@RequestMapping(value="/getOrgAndep",method={RequestMethod.POST,RequestMethod.GET})
	@ResourceScan(rsc = @Resource(cd = Const.GET_ORG_DEP, name = "获取组织和部门",  hierarchy = 4, isMenue = false, pcd = Const.QUERY_ROLE)
	, prsc = {@Resource( cd = Const.QUERY_ROLE, name = "查询角色信息", isMenue = false, hierarchy = 3, pcd = Const.ROLE_MANAGE),
			@Resource( cd = Const.ROLE_MANAGE, name = "角色管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource( cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	@OperLogging(operType = 3)
	public ResponseMsg<OrgAndDep> getOrgAndep(){
		ResponseMsg<OrgAndDep> resp = new ResponseMsg<OrgAndDep>();

		try {
			OrgAndDep data = Roleservice.getOrgAndDep();
			resp.setData(data);
			resp.setTotal(1);
			resp.setMessage("获取组织和部门成功!");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("获取组织和部门成功");
			resp.setStatus(-1);
			logger.error("获取组织和部门成功",e);
		}

		return resp;

	}	


}
