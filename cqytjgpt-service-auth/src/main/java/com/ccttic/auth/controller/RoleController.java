package com.ccttic.auth.controller;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.auth.common.beans.ResponseMsg;
import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.exception.InvalidArgumentException;
import com.ccttic.auth.common.page.Page;
import com.ccttic.auth.common.page.PageRequest;
import com.ccttic.auth.model.Role;
import com.ccttic.auth.service.IRoleService;
import com.ccttic.auth.util.ObjectHelper;

/**
   功能说明：     角色信息
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.controller.ess.RoleController.java
 @date  2016年12月9日
 */
@RestController
@RequestMapping("/ess")
public class RoleController implements Serializable {
	private static final long serialVersionUID = 3151609131168651231L;
	private final Logger logger = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	private IRoleService roleService;

	/**
	 * 角色管理
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping(value = "/roleInit")
	@Menu(resource = "essential.roleinit", group = "essential-manager", label = "角色管理", order = 3, description = "角色管理")
	public ModelAndView roleInit() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ess/role");
		return mv;
	}*/

	/**
	 * 根据查询条件获取角色列表
	 * @param pageRequest
	 *            分页请求接口
	 * @param post
	 *            查询条件
	 * @return JSON
	 * @throws AppException
	 */
	@RequestMapping("/loadRolePages")
	public ResponseMsg<List<Role>> loadRolePages(PageRequest page, Role role) throws AppException {
		ResponseMsg<List<Role>> resp = new ResponseMsg<List<Role>>();
		logger.debug("role--->" + role);
		Page<Role> pager = this.roleService.loadRolePages(page, role);
		resp.success("根据条件查询角色列表成功！");
		resp.setData(pager.getRecords());
		resp.setTotal(pager.getTotalRows().intValue());
		return resp;
	}

	/**
	 * 根据查询条件获取角色列表
	 * 
	 * @param pageRequest
	 *            分页请求接口
	 * @param post
	 *            查询条件
	 * @return JSON
	 */
	@RequestMapping(value = "/editRole")
	public ResponseMsg<String> editRole(Role role) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			if (ObjectHelper.isEmpty(role.getRoleNm())) {
				throw new InvalidArgumentException(role.getRoleNm());
			}
			this.roleService.editRole(role);
			resp.success("编辑角色成功!");
		} catch (AppException e) {
			resp.fail("编辑角色失败!");
			logger.error("编辑角色失败!",e);
		} catch (Exception e) {
			resp.fail("编辑角色失败!");
			logger.error("编辑角色失败!",e);
		}
		return resp;
	}

	/**
	 * 根据id获取角色信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findRole")
	public ResponseMsg<Role> findRole(String id) {
		ResponseMsg<Role> resp = new ResponseMsg<Role>();
		try {
			Role role = this.roleService.findRoleById(id);
			resp.success("根据角色id获取角色成功");
			resp.setData(role);
		} catch (AppException e) {
			resp.fail("根据角色id获取角色失败");
			logger.error("根据角色id获取角色失败",e);
		} catch (Exception e) {
			resp.fail("根据角色id获取角色失败");
			logger.error("根据角色id获取角色失败",e);
		}
		return resp;
	}

	/**
	 * 根据ID删除岗位信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteRole")
	public ResponseMsg<String> deleteRole(String id) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			this.roleService.deleteRole(id);
			resp.success("根据id删除角色成功");
		} catch (AppException ae) {
			resp.fail("根据id删除角色失败");
			logger.error("根据id删除角色失败",ae);
		} catch (Exception ae) {
			resp.fail("根据id删除角色失败");
			logger.error("根据id删除角色失败",ae);
		}
		return resp;
	}

}
