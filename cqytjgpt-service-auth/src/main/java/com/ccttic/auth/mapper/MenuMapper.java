package com.ccttic.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.auth.model.MenuBean;

/**
 * 
   功能说明：    MyBatis菜单映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月3日
 */
public interface MenuMapper {
	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	public int addMenu(@Param("menu") MenuBean menu);

	/**
	 * 修改菜单
	 * @param menu
	 * @param id
	 * @return
	 */
	public int updateMenu(@Param("menu") MenuBean menu);

	/**
	 * 根据ID查询菜单
	 * @param id
	 * @return
	 */
	public MenuBean findMenuById(@Param("id") String id);

	/**
	 * 根据resource查看菜单
	 * @param resource
	 * @return
	 */
	public MenuBean findMenuByResource(@Param("resource") String resource);

	/**
	 * 获取一级菜单权限
	 * @param empCd
	 * @param roleCds 
	 * @return
	 */
	public List<MenuBean> getFirstPermissionMenus(@Param("empCd") String empCd, @Param("roleCds") String roleCds);

	/**
	 * 获取二级菜单权限
	 * @param empCd
	 * @param roleCds
	 * @param group
	 * @return
	 */
	public List<MenuBean> getSecondPermissionMenus(@Param("empCd") String empCd, @Param("roleCds") String roleCds,
			@Param("resource") String resource);

	/**
	 * 获取一级菜单
	 * @return
	 * @throws AppException
	 */
	public List<MenuBean> getFirstMenus();

	/**
	 * 获取二级菜单
	 * @param resource
	 * @return
	 * @throws AppException
	 */
	public List<MenuBean> getSecondMenus(@Param("resource") String resource);

}
