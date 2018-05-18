package com.ccttic.auth.service;

import java.awt.print.Pageable;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.model.Role;
import com.github.pagehelper.Page;

/**
   功能说明：     角色业务接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.IRoleService.java
 @date  2016年12月11日
 */

public interface IRoleService {

	/**
	 * 获取所有角色信息
	 * @param page
	 * @param role
	 * @return
	 * @throws AppException
	 */
	Page<Role> loadRolePages(Pageable page, Role role) throws AppException;

	/**
	 * 编辑角色信息
	 * @param role
	 * @return
	 * @throws AppException
	 */
	boolean editRole(Role role) throws AppException;

	/**
	 * 通过ID获取角色信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Role findRoleById(String id) throws AppException;

	/**
	 * 通过ID删除角色信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public boolean deleteRole(String id) throws AppException;

}
