package com.ccttic.controller.employee;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.beans.ResponseMsg;
import com.ccttic.entity.employee.Employee;
import com.ccttic.service.employee.IEmployeeService;
import com.ccttic.util.auth.AuthServiceFeign;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.ObjectHelper;

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
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private AuthServiceFeign authFeign;

	/**
	 * 
	 * @Title: login @Description: 用户登录获取access_token @param @param
	 * request @param @param useranme @param @param password @param @return
	 * 参数 @return ResponseMsg<String> 返回类型 @throws
	 */
	// @Logger(content = "${}", remark = "用户登录", operType = 1)
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<String> login(HttpServletRequest request, @RequestParam String username,
			@RequestParam String password, @RequestParam String picCode) {
		ResponseMsg<String> response = new ResponseMsg<String>();

		try {

			Object picCodeCache = request.getSession(true).getAttribute(Const.PIC_CODE);
			if (ObjectHelper.isEmpty(picCodeCache)) {
				response.fail("获取session中的验证码失败");
				logger.error("获取session中的验证码失败");
				return response;
			}
			if (ObjectHelper.isEmpty(picCode) || !picCodeCache.toString().equalsIgnoreCase(picCode)) {
				logger.error("验证码输入错误");
				response.fail("验证码输入错误");
				return response;
			}
			Employee employee = employeeService.login(username, password);

			if (employee == null) {
				response.fail("用户名或密码错误!");
				return response;
			}

			String tokenValue = authFeign.getAccessToken(username, password, "password", "ccttic1");
			if (ObjectHelper.isEmpty(tokenValue)) {
				response.fail("获取访问token失败");
				return response;
			}
			request.getSession(true).setAttribute(Const.USER, employee);
			response.setStatus(ResponseMsg.STATUS_SUCCES);
			response.setData(tokenValue);
		} catch (Exception e) {
			response.fail("登录失败");
			logger.error("登录失败:", e);
		}
		return response;
	}

	/**
	 * 
	 * @Title: employeeInfo @Description: 获取用户信息 @param @param request @param @param
	 * useranme @param @return 参数 @return ResponseMsg<Employee> 返回类型 @throws
	 */
	@RequestMapping(value = "/employeeInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<Employee> employeeInfo(HttpServletRequest request,
			String useranme/* ,@ModelAttribute("EMP")Employee emp */) {
		ResponseMsg<Employee> response = new ResponseMsg<Employee>();
		Object employee = request.getSession(true).getAttribute(Const.USER);
		if (employee == null) {
			employee = employeeService.findEmployeeByAccount(useranme);
		}

		if (employee == null) {
			response.fail("获取用户信息失败!");
			return response;
		}
		response.setStatus(ResponseMsg.STATUS_SUCCES);
		response.setData((Employee) employee);

		return response;
	}

}
