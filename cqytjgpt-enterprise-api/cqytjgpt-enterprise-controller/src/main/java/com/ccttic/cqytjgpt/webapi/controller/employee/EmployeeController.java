package com.ccttic.cqytjgpt.webapi.controller.employee;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ccttic.entity.employee.*;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.post.ObjectList;
import com.ccttic.entity.role.Organization;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ccttic.cqytjgpt.webapi.client.auth.AuthServiceFeign;
import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.vo.TokenVo;
import com.ccttic.entity.role.Department;
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
@Api(tags="用户Controller")
@RestController
@RequestMapping("/employee")
// @SessionAttributes(Const.USER)
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private AuthServiceFeign authFeign;
	@Autowired
	private RedisService<EmployeeVo> redisService;

	/**
	 *
	 * @Title: login @Description: 用户登录获取access_token @param @param
	 *         request @param @param useranme @param @param password @param @return
	 *         参数 @return ResponseMsg<String> 返回类型 @throws
	 */
	// @Logger(content = "${}", remark = "用户登录", operType = 1)
	@ApiOperation(value="用户登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name="picCode",value="验证码",required=true,paramType="form"),
			@ApiImplicitParam(name="account",value="员工账号",required=true,paramType="form"),
			@ApiImplicitParam(name="password",value="员工密码",required=true,paramType="form")
	})
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
			if (ObjectHelper.isEmpty(empVo.getPicCode())
					|| !picCodeCache.toString().equalsIgnoreCase(empVo.getPicCode())) {
				logger.error("验证码输入错误");
				response.fail("验证码输入错误");
				return response;
			}
			String md5pasword = MD5.sign(empVo.getAccount(), empVo.getPassword(), "utf-8");
			Employee employee = employeeService.login(empVo.getAccount(), md5pasword);
			if (employee == null) {
				response.fail("用户名或密码错误!");
				return response;
			}


			String tokenValue = authFeign.getAccessToken(empVo.getAccount(), md5pasword, "password",
					"ccttic1");
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
	@ApiOperation(value="用户信息查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name="access_token",value="用户token",required=true,paramType="form")
	})
	@RequestMapping(value = "/employeeInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<EmployeeVo> employeeInfo(@RequestParam String access_token) {
		ResponseMsg<EmployeeVo> response = new ResponseMsg<EmployeeVo>();
		if (StringUtils.isEmpty(access_token)) {
			response.fail("access_token 不能为空");
			return response;
		}
		String username = JWTUtil.getUsername(access_token);

		EmployeeVo employee;
		try {
			employee = employeeService.findEmployeeByAccount(username);
			employee.setPassword(null);
			redisService.set(username+Const.TOKEN,employee,Const.USER_REDIS_LIVE);
			if (employee == null) {
				response.fail("获取用户信息失败!");
				return response;
			}
			response.setStatus(ResponseMsg.STATUS_SUCCES);
			response.setData((EmployeeVo) employee);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@ApiOperation(value="分页显示所有员工")
	@ApiImplicitParams({
			@ApiImplicitParam(name="access_token",value="用户token",required=true,paramType="form"),
	})
	@RequestMapping(value = "/showEmployee", method = {RequestMethod.GET, RequestMethod.POST})
	@ResourceScan(rsc = @Resource(cd = Const.SELECT_EMPLOYEE, name = "查询员工信息", hierarchy = 3, isMenue = true, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/employee/showEmployee", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
	public ResponseMsg<Page<EssEmployeeVo>> showEmployee(@RequestParam String access_token,
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

			rm.setMessage("获取employee数据失败");
			rm.setStatus(-1);
			logger.error("获取employee数据失败", e);
		}

		return rm;
	}
	@ApiOperation(value="根据部门显示员工")
	@ApiImplicitParams({
			@ApiImplicitParam(name="depid",value="部门id",required=true,paramType="form"),
			@ApiImplicitParam(name="empnm",value="用户名",required=true,paramType="form"),
			@ApiImplicitParam(name="orgCd",value="组织id",required=true,paramType="form")
	})
	@RequestMapping(value = "/showEmployeeByDepartment", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseMsg<List<EssEmployeeVo>> showEmployeeByDepartment(@RequestBody EssEmployeeVo emp) {
		ResponseMsg<List<EssEmployeeVo>> responseMsg = new ResponseMsg<List<EssEmployeeVo>>();
		try {
			if (emp != null && emp.getOrgCd() != null) {
				List<EssEmployeeVo> employees = employeeService.selectEmployeeByDepartment(emp.getDepid(), emp.getEmpnm(), emp.getOrgCd());

				responseMsg.setData(employees);
				responseMsg.setMessage("获取employee数据成功");
				responseMsg.setStatus(0);
			} else {
				responseMsg.setMessage("获取employee数据失败,获取组织id失败");
				responseMsg.setStatus(-1);
			}
		} catch (Exception e) {
			responseMsg.setMessage("获取employee数据失败");
			responseMsg.setStatus(-1);
			logger.error("获取employee数据失败", e);
		}
		return responseMsg;
	}

	@ApiOperation(value="刷新token")
	@ApiImplicitParams({
			@ApiImplicitParam(name="refreshToken",value="刷新token",required=true,paramType="form"),
	})
	@RequestMapping(value = "/refreshtoken", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseMsg<Map<String, Object>> refreshToken(@RequestBody TokenVo vo) {
		ResponseMsg<Map<String, Object>> result = new ResponseMsg<Map<String, Object>>();
		if (StringUtils.isBlank(vo.getRefreshToken())) {
			result.fail("请输入refresh_token.");
		} else {
			try {
				String grant_type = "refresh_token";
				String value = authFeign.getRefreshToken(vo.getRefreshToken(), grant_type);
				Map<String, Object> map = new HashMap<String, Object>();
				if (StringUtils.isNotBlank(value)) {
					JSONObject resultJSON = JSONObject.fromObject(value);
					String access_token = resultJSON.get("access_token").toString();
					String refresh_token = resultJSON.get("refresh_token").toString();
					int expires_in = Integer.parseInt(resultJSON.get("expires_in").toString());
					map.put("access_token", access_token);
					map.put("refresh_token", refresh_token);
					map.put("expires_in", expires_in);
				}

				result.success("刷新token成功");
				result.setData(map);
			} catch (Exception e) {
				logger.info("刷新token失败");
				e.printStackTrace();
				result.setStatus(ResponseMsg.STATUS_FAIL);
				String massage = e.getMessage();
				if (StringUtils.isNotBlank(massage)) {
					int a = massage.indexOf("{");
					String str = massage.substring(a, massage.length());
					JSONObject resultJSON = JSONObject.fromObject(str);
					String errorMsg = resultJSON.get("error_description").toString();
					result.setMessage("刷新token失败：" + errorMsg);
				} else {
					result.setMessage("刷新token失败：系统异常");
				}
			}
		}
		return result;
	}

	@RequestMapping("/destoryaccesstoken")
	@ResponseBody
	public ResponseMsg<String> destoryAccessToken(@RequestParam String accessToken) {
		ResponseMsg<String> result = new ResponseMsg<String>();
		if (StringUtils.isBlank(accessToken)) {
			result.fail("请输入token.");
		} else {
			String value = authFeign.destoryAccess_token(accessToken);
			if ("注销成功".equals(value)) {
				result.success(value);
			} else {
				result.fail(value);
			}
		}
		return result;
	}

	@ApiOperation(value="创建员工")
	@ApiImplicitParams({
			@ApiImplicitParam(name="account",value="员工账号",required=true,paramType="form"),
			@ApiImplicitParam(name="password",value="员工密码",required=true,paramType="form"),
			@ApiImplicitParam(name="empno",value="员工工号",required=true,paramType="form"),
			@ApiImplicitParam(name="empnm",value="员工名",required=true,paramType="form"),
			@ApiImplicitParam(name="emptype",value="员工类型",required=true,paramType="form"),
			@ApiImplicitParam(name="id",value="岗位id",required=false,paramType="form"),
			@ApiImplicitParam(name="description",value="岗位描述",required=false,paramType="form"),
			@ApiImplicitParam(name="postcd",value="岗位编号",required=false,paramType="form"),
			@ApiImplicitParam(name="postnm",value="岗位名称",required=false,paramType="form"),
	})
	@RequestMapping(value = "/addEmployee", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.ADD_EMPLOYEE, name = "创建员工", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/employee/addEmployee", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> addEmployee(HttpServletRequest request, @RequestBody EssEmployeeVo emp) {
		ResponseMsg<String> rm = new ResponseMsg<String>();

		try {
			int cat = employeeService.selectEmpByAccount(emp.getAccount());
			if (cat == 1) {
				rm.fail("添加employee数据失败，用户名重复");
				return rm;
			}
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

	@ApiOperation(value="修改员工")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="员工id",required=true,paramType="form"),
			@ApiImplicitParam(name="account",value="员工账号",required=true,paramType="form"),
			@ApiImplicitParam(name="password",value="员工密码",required=true,paramType="form"),
			@ApiImplicitParam(name="empno",value="员工工号",required=true,paramType="form"),
			@ApiImplicitParam(name="empnm",value="员工名",required=true,paramType="form"),
			@ApiImplicitParam(name="emptype",value="员工类型",required=true,paramType="form"),
			@ApiImplicitParam(name="id",value="岗位id",required=false,paramType="form"),
			@ApiImplicitParam(name="description",value="岗位描述",required=false,paramType="form"),
			@ApiImplicitParam(name="postcd",value="岗位编号",required=false,paramType="form"),
			@ApiImplicitParam(name="postnm",value="岗位名称",required=false,paramType="form"),
	})
	@RequestMapping(value = "/editEmployee", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.MODIFY_EMPLOYEE, name = "修改员工", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/employee/editEmployee", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> editEmployee(HttpServletRequest request, @RequestBody EssEmployeeVo emp) {
		ResponseMsg<String> rm = new ResponseMsg<String>();
		if (null != emp.getPassword()) {
			String md5pasword = MD5.sign(emp.getAccount(), emp.getPassword(), "utf-8");
			emp.setPassword(md5pasword);
		}
		
		try {
			employeeService.editEmployee(emp);
			rm.success("修改employee数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail("修改employee数据失败");
			logger.error("修改employee数据失败", e);
		}

		return rm;
	}

	@ApiOperation(value="修改密码")
	@ApiImplicitParams({
			@ApiImplicitParam(name="str",value="新密码",required=true,paramType="form"),

	})
	@RequestMapping(value = "/modifyPassword", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<String> modifyPassword(HttpServletRequest request, @RequestBody ObjectList list) {
		ResponseMsg<String> rm = new ResponseMsg<String>();
		List<Map<String, String>> maps =list.listMap;
		String password = list.str;
		List<EssEmployee> emp = new ArrayList<>();
		EssEmployee employee =null;
		if(maps!=null && password!=null){
			for(Map<String, String> map:maps) {
				employee = new EssEmployee();
				String id = map.get("id");
				String account = map.get("account");
				String md5pasword = MD5.sign(account, password, "utf-8");
				employee.setPassword(md5pasword);
				employee.setId(id);
				emp.add(employee);
			}
		}else {
			rm.fail("修改密码失败");
			return rm;
		}
		try {
			employeeService.modifyPassword(emp);
			rm.success("修改密码成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail("修改密码失败");
			logger.error("修改密码失败", e);
		}
		return rm;

	}
	@ApiOperation(value="修改密码")
	@ApiImplicitParams({
			@ApiImplicitParam(name="str",value="新密码",required=true,paramType="form"),

	})
	@RequestMapping(value = "/delEmployee", method = { RequestMethod.GET, RequestMethod.POST })
	@ResourceScan(rsc = @Resource(cd = Const.MODIFY_EMPLOYEE, name = "删除员工", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE), prsc = {
			@Resource(cd = Const.ORGANIZATION_SUPERVISE, url = "/employee/delEmployee", name = "组织管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> delEmployee(HttpServletRequest request,@RequestBody ObjectList list) {
		ResponseMsg<String> rm = new ResponseMsg<>();
		List<Map<String, String>> maps =list.listMap;
		EssEmployeeVo emp = null;
		try {
			if (maps != null ) {
				for (int i = 0; i < maps.size(); i++){
					emp = new EssEmployeeVo();
					emp.setId(maps.get(i).get("id"));
					emp.setDepid(maps.get(i).get("depid"));
					emp.setIsdeleted(true);
					employeeService.delEmployee(emp);
				}
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

	/**
	 * @Author:zhy
	 * @Description:获取用户信息
	 * @Date:10:05 2018/7/9
	 */
	public EmployeeVo getUserInfo(String access_token) {

		String username = JWTUtil.getUsername(access_token);
		// redis get data
		EmployeeVo employee = (EmployeeVo) redisService.get(username + Const.TOKEN);
		// 2. 判断REDIS是否为空
		if (null == employee) {
			try{
				employee = employeeService.findEmployeeByAccount(username);
				// 3. 更新redis里用户缓存
				redisService.set(username + Const.TOKEN, employee, Const.USER_REDIS_LIVE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return employee;
	}
}
