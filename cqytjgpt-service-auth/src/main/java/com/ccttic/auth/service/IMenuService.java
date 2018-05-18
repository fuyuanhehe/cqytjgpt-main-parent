package com.ccttic.auth.service;

import java.util.List;
import java.util.Map;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.model.Employee;
import com.ccttic.auth.model.MenuBean;

/**
   功能说明：     菜单业务接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.res.IMenuService.java
 @date  2016年12月3日
 */

public interface IMenuService {
	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	public int addMenu(MenuBean menu) throws AppException;

	/**
	 * 修改菜单
	 * @param menu
	 * @return
	 * @throws AppException
	 */
	public int updateMenu(MenuBean menu) throws AppException;

	/**
	 * 根据ID查询菜单
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public MenuBean findMenuById(String id) throws AppException;

	/**
	 * 根据resource查看菜单
	 * @param resource
	 * @return
	 * @throws AppException
	 */
	public MenuBean findMenuByResource(String resource) throws AppException;

	/**
	 * 获取权限菜单
	 * @param employee
	 * @return
	 * @throws AppException
	 */
	public Map<MenuBean, List<MenuBean>> getPermissionMenus(Employee employee) throws AppException;

	/**
	 * 获取所有菜单
	 * @return
	 * @throws AppException
	 */
	public Map<MenuBean, List<MenuBean>> findAllMenus() throws AppException;

}
