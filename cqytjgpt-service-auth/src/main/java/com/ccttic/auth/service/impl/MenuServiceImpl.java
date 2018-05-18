package com.ccttic.auth.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.mapper.MenuMapper;
import com.ccttic.auth.model.Employee;
import com.ccttic.auth.model.MenuBean;
import com.ccttic.auth.service.IMenuService;
import com.ccttic.auth.util.ObjectHelper;

/**
   功能说明：     菜单业务实现类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.res.impl.MenuServiceImpl.java
 @date  2016年12月3日
 */
@Service
public class MenuServiceImpl implements IMenuService {
	@Resource
	private MenuMapper mapper;

	@Override
	@Transactional
	public int addMenu(MenuBean menu) throws AppException {
		return mapper.addMenu(menu);
	}

	@Override
	@Transactional
	public int updateMenu(MenuBean menu) throws AppException {
		return mapper.updateMenu(menu);
	}

	@Override
	@Transactional(readOnly = true)
	public MenuBean findMenuById(String id) throws AppException {
		return mapper.findMenuById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public MenuBean findMenuByResource(String resource) throws AppException {
		return mapper.findMenuByResource(resource);
	}

	@Override
	@Transactional(readOnly = true)
	public Map<MenuBean, List<MenuBean>> getPermissionMenus(Employee login) throws AppException {
		Map<MenuBean, List<MenuBean>> menus = new TreeMap<MenuBean, List<MenuBean>>(new Comparator<MenuBean>() {
			/* 
			 * int compare(Object o1, Object o2) 返回一个基本类型的整型， 
			 * 返回负数表示：o1 小于o2， 
			 * 返回0 表示：o1和o2相等， 
			 * 返回正数表示：o1大于o2。 
			 */
			public int compare(MenuBean o1, MenuBean o2) {

				//指定排序器按照降序排列  
				return o1.getOrder().compareTo(o2.getOrder());
			}
		});
		List<MenuBean> firstMenus = new ArrayList<MenuBean>();
		String roleCds = "";
		for (String roleCd : login.getRoleCds()) {
			roleCds += "'" + roleCd + "',";
		}
		if (ObjectHelper.isNotEmpty(roleCds)) {
			roleCds = roleCds.substring(0, roleCds.length() - 1);
		}
		if ("admin".equalsIgnoreCase(login.getAccount())) {
			firstMenus = mapper.getFirstMenus();
		} else {
			firstMenus = mapper.getFirstPermissionMenus(login.getEmpCd(), roleCds);
		}
		for (MenuBean firstMenu : firstMenus) {
			List<MenuBean> secondMenus = new ArrayList<MenuBean>();
			if ("admin".equalsIgnoreCase(login.getAccount())) {
				secondMenus = mapper.getSecondMenus(firstMenu.getResource());
			} else {
				secondMenus = mapper.getSecondPermissionMenus(login.getEmpCd(), roleCds, firstMenu.getResource());
			}
			if (ObjectHelper.isEmpty(secondMenus)) {
				secondMenus = new ArrayList<MenuBean>();
			}
			menus.put(firstMenu, secondMenus);

		}
		return menus;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.res.IMenuService#findAllMenus()
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<MenuBean, List<MenuBean>> findAllMenus() throws AppException {

		Map<MenuBean, List<MenuBean>> menus = new TreeMap<MenuBean, List<MenuBean>>(new Comparator<MenuBean>() {
			/* 
			 * int compare(Object o1, Object o2) 返回一个基本类型的整型， 
			 * 返回负数表示：o1 小于o2， 
			 * 返回0 表示：o1和o2相等， 
			 * 返回正数表示：o1大于o2。 
			 */
			public int compare(MenuBean o1, MenuBean o2) {

				//指定排序器按照降序排列  
				return o1.getOrder().compareTo(o2.getOrder());
			}
		});
		List<MenuBean> firstMenus = mapper.getFirstMenus();
		for (MenuBean firstMenu : firstMenus) {
			List<MenuBean> secondMenus = mapper.getSecondMenus(firstMenu.getResource());
			if (ObjectHelper.isEmpty(secondMenus)) {
				secondMenus = new ArrayList<MenuBean>();
			}
			menus.put(firstMenu, secondMenus);

		}
		return menus;

	}

}
