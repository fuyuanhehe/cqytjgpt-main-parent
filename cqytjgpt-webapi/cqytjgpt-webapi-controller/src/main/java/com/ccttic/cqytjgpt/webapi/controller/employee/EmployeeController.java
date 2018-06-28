package com.ccttic.cqytjgpt.webapi.controller.employee;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.ccttic.cqytjgpt.webapi.client.auth.AuthServiceFeign;
import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeeVo;
import com.ccttic.entity.employee.vo.TokenVo;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.common.MD5;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName: EmployeeController
 * @Description: 用户信息控制器（包括：登录，退出，获取token,刷新token等操作）
 * @author syao
 * @date 2018年5月31日
 *
 */
@RestController
@RequestMapping("/employee")
//@SessionAttributes(Const.USER)
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IEnterpriseService enterpriseService;

	@Autowired
	private AuthServiceFeign authFeign;

	/**
	 * 
	 * @Title: login @Description: 用户登录获取access_token @param @param
	 *         request @param @param useranme @param @param password @param @return
	 *         参数 @return ResponseMsg<String> 返回类型 @throws
	 */
	// @Logger(content = "${}", remark = "用户登录", operType = 1)
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<JSON> login(HttpServletRequest request, @RequestBody EmployeeVo empVo) {
		ResponseMsg<JSON> response = new ResponseMsg<JSON>();

		try {

			Object picCodeCache = request.getSession(true).getAttribute(Const.PIC_CODE);
			if (ObjectHelper.isEmpty(picCodeCache)) {
				response.fail("获取session中的验证码失败");
				logger.error("获取session中的验证码失败");
				return response;
			}
			if (ObjectHelper.isEmpty(empVo.getPicCode()) || !picCodeCache.toString().equalsIgnoreCase(empVo.getPicCode())) {
				logger.error("验证码输入错误");
				response.fail("验证码输入错误");
				return response; 
			}
			Employee employee = employeeService.login(empVo.getAccount(), empVo.getPassword());
			if (employee == null) {
				response.fail("用户名或密码错误!");
				return response;
			} 

			String md5pasword = MD5.sign(empVo.getAccount(), empVo.getPassword(), "utf-8");
			String tokenValue = authFeign.getAccessToken(empVo.getAccount(), empVo.getPassword(), "password", "ccttic1");
			if (ObjectHelper.isEmpty(tokenValue)) {
				response.fail("获取访问token失败");
				return response;
			}
			request.getSession(true).setAttribute(Const.USER, employee);
			response.setStatus(ResponseMsg.STATUS_SUCCES);
			JSON json = JSON.parseObject(tokenValue);
			response.setData(json);
		} catch (Exception e) {
			response.fail("登录失败");
			logger.error("登录失败:", e);
		}
		return response;
	}

	/**
	 * 
	 * @Title: employeeInfo @Description: 获取用户信息 @param @param request @param @param
	 *         useranme @param @return 参数 @return ResponseMsg<Employee> 返回类型 @throws
	 */
	@RequestMapping(value = "/employeeInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<EmployeeVo> employeeInfo(HttpSession session,@RequestBody TokenVo vo) {
		ResponseMsg<EmployeeVo> response = new ResponseMsg<EmployeeVo>();
		Employee emp=	(Employee) session.getAttribute(Const.USER);
		String username=null;
		if (emp == null) {
			username=JWTUtil.getUsername(vo.getAccess_token());
		}else{
			if(!StringUtils.isEmpty(emp.getAccount())){
				username = emp.getAccount();
			}
		}
	

		EmployeeVo employee = employeeService.findEmployeeByAccount(username);
		
		if (employee == null) {
			response.fail("获取用户信息失败!");
			return response;
		}
		logger.info("-----------------放入开始！-----------------------");
		session.setAttribute(Const.ENT, employee); 
		logger.info("-----------------放入结束！-----------------------");
		response.setStatus(ResponseMsg.STATUS_SUCCES);
		response.setData((EmployeeVo) employee);

		return response;
	}
    //分页显示所有员工
	@RequestMapping(value = "/showEmployee", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.SELECT_EMPLOYEE, name = "查询员工信息", hierarchy = 3, isMenue = true, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/employee/showEmployee", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<Page<EssEmployeeVo>> showEmployee(HttpServletRequest request,
			@RequestBody EssEmployeeVo emp) {
		ResponseMsg<Page<EssEmployeeVo>> rm = new ResponseMsg<Page<EssEmployeeVo>>();
		try {
			
			PageRequest page = new PageRequest();
			page.setPage(emp.getPage());
			page.setRows(emp.getRows());
			Page<EssEmployeeVo> pager = employeeService.selectEmployee(page, emp);

			rm.setData(pager);
			rm.setMessage("获取employee数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			rm.setMessage("获取employee数据失败");
			rm.setStatus(-1);
			logger.error("获取employee数据失败", e);
		}

		return rm;
	}
	
	@RequestMapping(value = "/refreshtoken", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseMsg<Map<String , Object>> refreshToken(@RequestBody TokenVo vo){
		ResponseMsg<Map<String , Object>> result = new ResponseMsg<Map<String , Object>>();
		if(StringUtils.isBlank(vo.getRefreshToken())) {
			result.fail("请输入refresh_token.");
		}else {
			try {
				String grant_type="refresh_token";
				String value=authFeign.getRefreshToken(vo.getRefreshToken(),grant_type);
				Map<String , Object> map = new HashMap<String,Object>();
				if(StringUtils.isNotBlank(value)) {
					JSONObject resultJSON = JSONObject.fromObject(value);
					String access_token = resultJSON.get("access_token").toString();
					String refresh_token = resultJSON.get("refresh_token").toString();
					int expires_in = Integer.parseInt(resultJSON.get("expires_in").toString());
					map.put("access_token",access_token);
					map.put("refresh_token",refresh_token);
					map.put("expires_in",expires_in);
				}
				
				result.success("刷新token成功");
				result.setData(map);
			} catch (Exception e) {
				logger.info("刷新token失败");
				e.printStackTrace();
				result.setStatus(ResponseMsg.STATUS_FAIL);
				String massage = e.getMessage();
				if(StringUtils.isNotBlank(massage)) {
					int a = massage.indexOf("{");
					String str = massage.substring(a,massage.length());
					JSONObject resultJSON = JSONObject.fromObject(str);
					String errorMsg = resultJSON.get("error_description").toString();
					result.setMessage("刷新token失败："+errorMsg);
				}else {
					result.setMessage("刷新token失败：系统异常");
				}
			}
		}
		return result;
	}
	
	@RequestMapping("/destoryaccesstoken")
	@ResponseBody
	public ResponseMsg<String> destoryAccessToken(@RequestParam String accessToken){
		ResponseMsg<String> result = new ResponseMsg<String>();
		if(StringUtils.isBlank(accessToken)) {
			result.fail("请输入token.");
		}else {
			String value=authFeign.destoryAccess_token(accessToken);
			if("注销成功".equals(value)) {
				result.success(value);
			}else {
				result.fail(value);
			}
		}	
		return result;
	}

	/**
	 * 添加员工
	 * 
	 * @param request
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/addEmployee", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.ADD_EMPLOYEE, name = "添加员工", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/employee/addEmployee", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> addEmployee(HttpServletRequest request, @RequestBody EssEmployeeVo emp) {
		ResponseMsg<String> rm = new ResponseMsg<String>();

		try {
			employeeService.addEmployee(emp);
			rm.success("添加employee数据成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("添加employee数据失败");
			logger.error("添加employee数据失败", e);
		}
		return rm;
	}

	/**
	 * 修改员工信息
	 * 
	 * @param request
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/editEmployee", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.MODIFY_EMPLOYEE, name = "修改员工", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/employee/editEmployee", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> editEmployee(HttpServletRequest request, @RequestBody EssEmployeeVo emp) {
		ResponseMsg<String> rm = new ResponseMsg<String>();

		try {
			employeeService.editEmployee(emp);
			rm.success("修改employee数据成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("修改employee数据失败");
			logger.error("修改employee数据失败", e);
		}

		return rm;
	}

	/**
	 * 修改员工密码
	 * 
	 * @param request
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/modifyPassword", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<String> modifyPassword(HttpServletRequest request, @RequestBody EssEmployee emp) {
		ResponseMsg<String> rm = new ResponseMsg<String>();
		try {
			employeeService.modifyPassword(emp);
			rm.success("修改密码成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("修改密码失败");
			logger.error("修改密码失败", e);
		}
		return rm;

	}

	@RequestMapping(value = "/delEmployee", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.MODIFY_EMPLOYEE, name = "删除员工", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/employee/delEmployee", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> delEmployee(HttpServletRequest request, @RequestBody String str) {
		List<LinkedHashMap<String, String>> list =JsonUtil.jsonToList(str);	
		ResponseMsg<String> rm = new ResponseMsg<String>();
		
		try {
			for (LinkedHashMap<String, String> map : list) {
				EssEmployeeVo emp = new EssEmployeeVo();
				emp.setId(map.get("id"));
				emp.setDepid(map.get("depId"));
				emp.setIsdeleted(true);
				employeeService.delEmployee(emp);
			}
			
			rm.success("删除Employee成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("删除Employee失败");
			logger.error("删除Employee失败", e);
		}
		return rm;

	}
}
