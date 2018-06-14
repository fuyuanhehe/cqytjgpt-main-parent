package com.ccttic.controller.employee;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ccttic.entity.common.beans.ResponseMsg;
import com.ccttic.entity.employee.Employee;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeeVo;
import com.ccttic.service.employee.IEmployeeService;
import com.ccttic.util.auth.AuthServiceFeign;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.common.MD5;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

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
@SessionAttributes(Const.USER)
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;

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
	public ResponseMsg<String> login(HttpServletRequest request, @RequestBody EmployeeVo empVo) {
		ResponseMsg<String> response = new ResponseMsg<String>();

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
	 *         useranme @param @return 参数 @return ResponseMsg<Employee> 返回类型 @throws
	 */
	@RequestMapping(value = "/employeeInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<EmployeeVo> employeeInfo(HttpServletRequest request, String useranme,
			@ModelAttribute(Const.USER) Employee emp) {
		ResponseMsg<EmployeeVo> response = new ResponseMsg<EmployeeVo>();
//		Object employee = request.getSession(true).getAttribute(Const.USER);
//		if (employee == null) {
//			employee = employeeService.findEmployeeByAccount(useranme);
//		}

		EmployeeVo employee = employeeService.findEmployeeByAccount(useranme);
		
		if (employee == null) {
			response.fail("获取用户信息失败!");
			return response;
		}
		response.setStatus(ResponseMsg.STATUS_SUCCES);
		response.setData((EmployeeVo) employee);

		return response;
	}

	@RequestMapping(value = "/showEmployee", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<Page<EssEmployeeVo>> showEmployee(HttpServletRequest request, PageRequest page,
			@RequestBody EssEmployeeVo emp) {
		ResponseMsg<Page<EssEmployeeVo>> rm = new ResponseMsg<Page<EssEmployeeVo>>();
		try {
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

	/**
	 * 添加员工
	 * 
	 * @param request
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/addEmployee", method = { RequestMethod.GET, RequestMethod.POST })
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
