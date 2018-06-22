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
import com.ccttic.entity.role.vo.ModelByRole;
import com.ccttic.util.annotation.OperLogging;
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
	public ResponseMsg<String> deleteById(@RequestBody Roles roles) {

		ResponseMsg<String> resp = new ResponseMsg<>();

		try {

			if( !(ObjectHelper.isEmpty(roles.getId())) ) {		
				Roleservice.deleteRole(roles.getId());
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
	@OperLogging(operType = 0,content="增加角色关联员工")
	@RequestMapping(value="/addRole_Emp",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<String> addRole_Emp(@RequestBody(required = false) Roles rolty) {
		ResponseMsg<String> resp = new ResponseMsg<>();
		if(ObjectHelper.isNotEmpty(rolty)) {
			// 角色ID
			String  idss = RandomHelper.uuid();
			List<Role_Emp> roles = new ArrayList<Role_Emp>(); 
			//员工ID
			String str = rolty.getEmp_id();
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
			try {
				rolty.setId(idss);
				Roleservice.addRoless(rolty);
				Roleservice.addRole_Emp(roles);
				resp.setMessage("添加角色关联员工成功");
				resp.setStatus(0);
				resp.success("添加角色关联员工成功");
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
	@OperLogging(operType = 3,content="查询角色所属的菜单")
	@RequestMapping(value="/loadRolePages",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<Roles>> loadRolePages(PageRequest page,@RequestBody(required = false) Roles roles)  {
		ResponseMsg<List<Roles>> resp = new ResponseMsg<List<Roles>>();
		try {
			Page<Roles> pager = this.Roleservice.seAllRole(page,roles);
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
	 * @param roleCd 角色编码
	 * @param roleNm 角色名称
	 * @param description 角色描述
	 * @param emp_id 员工ID 多个用,隔开
	 * @return
	 * @date  2018年6月1日
	 */
	@OperLogging(operType = 1)
	@RequestMapping(value="/updateEssRole",method={RequestMethod.POST,RequestMethod.GET})
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
	 * 功能说明：  修改角色和关联的员工
	 * @param emp_id 员工id
	 * @return
	 * @date  2018年6月1日
	 */
	@OperLogging(operType = 3)
	@RequestMapping(value="/getRoleMenuByEmpid",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<ModelByRole> getRoleMenuByEmpid(@RequestBody Roles roles){
		ResponseMsg<ModelByRole> resp = new ResponseMsg<>();

		try {
			resp.setMessage("根据员工ID查询角色菜单成功!");
			resp.setStatus(0);
			resp.setData(Roleservice.seRoleByEmpId(roles.getEmp_id()) );

		} catch (Exception e) {
			resp.setMessage("根据员工ID查询角色菜单失败!");
			resp.setStatus(-1);
			logger.error("根据员工ID查询角色菜单失败!",e);
		}


		return resp;
	}

}
