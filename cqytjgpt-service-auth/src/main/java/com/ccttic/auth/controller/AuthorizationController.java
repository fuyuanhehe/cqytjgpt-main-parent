package com.ccttic.auth.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.auth.common.beans.ResponseMsg;
import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.model.EmpMenu;
import com.ccttic.auth.model.MenuBean;
import com.ccttic.auth.model.RoleMenu;
import com.ccttic.auth.model.TreeMenuBean;
import com.ccttic.auth.service.IEmployeeService;
import com.ccttic.auth.service.IMenuService;
import com.ccttic.auth.util.ObjectHelper;

/**
   功能说明：     授权管理
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.controller.ess.AuthorizationController.java
 @date  2016年12月25日
 */
@RestController
public class AuthorizationController implements Serializable {
	
	private final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
	
	private static final long serialVersionUID = 1566894389329322104L;
	
	
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IEmployeeService employeeService;

	/**
	 * 功能授权管理
	 * @return
	 */
	/*@RequestMapping(value = "/funcAuthInit")
	@Menu(resource = "essential.funcauthinit", group = "essential-manager", label = "功能权限管理", order = 4, description = "功能权限管理")
	public ModelAndView funcAuthInit() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ess/functional_authority");
		return mv;
	}*/

	/**
	 * 对人员设置资源访问权限
	 * @param empId
	 * @param resIds
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/setEmpResource")
	public  ResponseMsg<String> setEmpResource(String empId, String resIds) throws AppException {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		String[] menuIds = null;
		if (ObjectHelper.isNotEmpty(resIds)) {
			menuIds = resIds.split(",");
		}
		try {
			employeeService.setEmpResource(empId, menuIds);
			resp.success("设置权限成功!");
		} catch (AppException ae) {
			resp.fail("设置权限失败!");
			logger.error("设置权限失败!", ae); 
		} catch (Exception e) {
			resp.fail("设置权限失败!");
			logger.error("设置权限失败!", e); 
		}
		return resp;
	}

	/**
	 * 对角色设置资源访问权限
	 * @param roleId
	 * @param resIds
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/setRoleResource")
	public ResponseMsg<String> setRoleResource(String roleId, String resIds) throws AppException {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		String[] menuIds = null;
		if (ObjectHelper.isNotEmpty(resIds)) {
			menuIds = resIds.split(",");
		}
		try {
			employeeService.setRoleResource(roleId, menuIds);
			resp.success("设置权限成功!");
		} catch (AppException ae) {
			resp.fail("设置权限失败!");
			logger.error("设置权限失败!", ae); 
		} catch (Exception e) {
			resp.fail("设置权限失败!");
			logger.error("设置权限失败!", e); 
		}
		return resp;
	}

	/**
	 * 获取人员已有权限菜单
	 * @param empId
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/findEmpResources")
	@ResponseBody
	public ResponseMsg<List<EmpMenu>> findEmpResources(String empId) throws AppException {
		ResponseMsg<List<EmpMenu>> resp = new ResponseMsg<List<EmpMenu>>();
		try {
			List<EmpMenu> menus = employeeService.findEmpResources(empId);
			resp.success("获取人员权限成功!");
			resp.setData(menus);
		} catch (AppException ae) {
			resp.fail("获取人员权限失败!");
			logger.error("获取人员权限失败!", ae); 
		} catch (Exception e) {
			resp.fail("获取人员权限失败!");
			logger.error("获取人员权限失败!", e); 
		}
		return resp;
	}

	/**
	 * 获取角色已有权限菜单
	 * @param roleId
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/findRoleResources")
	@ResponseBody
	public ResponseMsg<List<RoleMenu>> findRoleResources(String roleId) throws AppException {
		ResponseMsg<List<RoleMenu>> resp = new ResponseMsg<List<RoleMenu>>();
		try {
			List<RoleMenu> menus = employeeService.findRoleResources(roleId);
			resp.success("获取角色权限成功!");
			resp.setData(menus);
		} catch (AppException ae) {
			ae.printStackTrace();
			resp.fail("获取角色权限失败!");
			logger.error("获取角色权限失败!", ae); 
		} catch (Exception e) {
			resp.fail("获取角色权限失败!");
			logger.error("获取角色权限失败!", e); 
		}
		return resp;
	}

	/**
	 * 获取菜单树
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/findAllMenus")
	public ResponseMsg<List<TreeMenuBean>> findAllMenus() throws AppException {
		ResponseMsg<List<TreeMenuBean>> resp = new ResponseMsg<List<TreeMenuBean>>();
		List<TreeMenuBean> beans = new ArrayList<TreeMenuBean>();
		Map<MenuBean, List<MenuBean>> menus = this.menuService.findAllMenus();
		Set<MenuBean> keys = menus.keySet();
		int total = 0;
		for (MenuBean key : keys) {
			TreeMenuBean root = new TreeMenuBean();
			root.setId(key.getId());
			root.setLable(key.getLabel());
			root.setDesc(key.getDescription());
			root.setParentId(null);
			root.setType("菜单资源");
			List<MenuBean> childBeans = menus.get(key);
			if (ObjectHelper.isNotEmpty(childBeans)) {
				root.setState("closed");
			} else {
				root.setState("opened");
			}
			for (MenuBean bean : childBeans) {
				TreeMenuBean treeChild = new TreeMenuBean();
				treeChild.setId(bean.getId());
				treeChild.setLable(bean.getLabel());
				treeChild.setDesc(bean.getDescription());
				treeChild.setParentId(root.getId());
				treeChild.setType("菜单资源");
				root.getChildren().add(treeChild);
				total++;
			}
			total++;
			beans.add(root);
		}
		resp.success("获取菜单树成功。");
		resp.setData(beans);
		resp.setTotal(total);
		return resp;
	}
}
