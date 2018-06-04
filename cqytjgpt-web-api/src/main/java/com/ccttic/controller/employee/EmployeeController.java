package com.ccttic.controller.employee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.beans.ResponseMsg;
import com.ccttic.entity.employee.Employee;
import com.ccttic.service.employee.IEmployeeService;
import com.ccttic.util.auth.AuthServiceFeign;

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
//@SessionAttributes("EMP")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	 @Autowired
	 private AuthServiceFeign authFeign;

	 /**
	  * 
	     * @Title: login  
	     * @Description: 用户登录获取access_token 
	     * @param @param request
	     * @param @param useranme
	     * @param @param password
	     * @param @return    参数  
	     * @return ResponseMsg<String>    返回类型  
	     * @throws
	  */
//	 @Logger(content = "${}", remark = "用户登录", operType = 1)
	@RequestMapping(value = "/login", method = RequestMethod.GET)  
    public ResponseMsg<String> login (HttpServletRequest request,String username,String password){  
		ResponseMsg<String> response = new ResponseMsg<String>();  
        
		Employee employee = employeeService.login(username, password);
		
		if(employee == null) {
			response.setMessage("用户名或密码错误!");
			response.setStatus(ResponseMsg.STATUS_FAIL);
			return response;
		}
		
		String tokenValue=authFeign.getAccessToken(username, password, "password", "ccttic1");
        request.getSession(true).setAttribute("EMPS", employee);  
		response.setStatus(ResponseMsg.STATUS_SUCCES);
		response.setData(tokenValue);
        return response;  
    }
	
	/**
	 * 
	    * @Title: employeeInfo  
	    * @Description: 获取用户信息
	    * @param @param request
	    * @param @param useranme
	    * @param @return    参数  
	    * @return ResponseMsg<Employee>    返回类型  
	    * @throws
	 */
	@RequestMapping(value = "/employeeInfo", method = {RequestMethod.GET,RequestMethod.POST})  
	public ResponseMsg<Employee> employeeInfo (HttpServletRequest request,String useranme/*,@ModelAttribute("EMP")Employee emp*/){
		ResponseMsg<Employee> response = new ResponseMsg<Employee>();  
		Object	employee = request.getSession(true).getAttribute("EMPS");
		if(employee ==null) {
			employee = employeeService.findEmployeeByAccount(useranme);
		}
		
		if(employee ==null) {
			response.setMessage("获取用户信息失败!");
			response.setStatus(ResponseMsg.STATUS_FAIL);
			return response;
		}
		response.setStatus(ResponseMsg.STATUS_SUCCES);
		response.setData((Employee)employee);
		
		return response;
	}
	

}
