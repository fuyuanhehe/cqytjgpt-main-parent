package com.ccttic.cqytjgpt.webapi.controller.post;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.post.IPostService;
import com.ccttic.cqytjgpt.webapi.interfaces.redis.RedisService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping("/post")
public class PostController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private IPostService postService;
	
	@Autowired
	private RedisService<EmployeeVo> redisService;
	
	@Autowired
	private IEmployeeService employeeService;

	/**分页查询岗位
	 * @param request
	 * @param response
	 * @param page
	 * @param post
	 * @return
	 */
	@RequestMapping(value = "selectPost", method = RequestMethod.POST)
	@ResourceScan(rsc = @Resource(cd = Const.SELECT_POST, name = "岗位主页",  hierarchy = 3, isMenue = true, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.POST_MANAGEMENT, url="/post/selectPost", name = "岗位管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<Page<EssPostVo>> selectPost(@RequestParam String access_token, ServletResponse response,
			@RequestBody EssPostVo post) {
		ResponseMsg<Page<EssPostVo>> rm = new ResponseMsg<>();

		EmployeeVo vo = employeeService.getUserInfo(access_token) ;

		try {
			PageRequest page = new PageRequest();
			page.setPage(post.getPage());
			page.setRows(post.getRows());
			System.out.println(vo.getCanSeePosts().size());
			Page<EssPostVo> pager = postService.selectPost(page, post,vo.getCanSeePosts());

			rm.setData(pager);
			rm.setMessage("获取post数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			rm.setMessage("获取post数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}
		return rm;
	}
	
	/**获取所有组织
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "selectAllOrganization", method = RequestMethod.POST)
	public ResponseMsg<List<Organization>> selectAllOrganization(ServletRequest request, ServletResponse response,@RequestParam String access_token) {
		ResponseMsg<List<Organization>> rm = new ResponseMsg<>();
		

		String username = JWTUtil.getUsername(access_token);
		// redis get data
		EmployeeVo vo = (EmployeeVo) redisService.get(username+Const.TOKEN);
		// 2. 判断REDIS是否为空
		if (null != vo) {

		} else {
			EmployeeVo employee;
			try {
				employee = employeeService.findEmployeeByAccount(username);
				// 3. 更新redis里用户缓存
				redisService.set(username+Const.TOKEN, employee, Const.USER_REDIS_LIVE);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
			if(vo.getCanSeeOrgs()!=null && vo.getCanSeeOrgs().size()>0) {
			rm.setData(vo.getCanSeeOrgs());
			rm.setMessage("获取Organization数据成功");
			rm.setStatus(0);
			}else {

			rm.setMessage("获取Organization数据为空");
			rm.setStatus(-1);
			}
		
		return rm;
	}

	/**查询部门
	 * @param orgid
	 * @return
	 */
	@RequestMapping(value = "selectDepartment", method = RequestMethod.POST)
	public ResponseMsg<List<Department>> selectDepartment(@RequestBody String orgid) {
		ResponseMsg<List<Department>> rm = new ResponseMsg<>();
		Map<String, String> map = JsonUtil.jsonToMap(orgid);
		try {
			List<Department> list = postService.getDepartmentByOrg(map);
			rm.setData(list);
			rm.setMessage("获取department数据成功");
			rm.setStatus(0);
		} catch (Exception e) {


			rm.setMessage("获取department数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}

		return rm;
	}

	/**查询员工
	 * @param depid
	 * @return
	 */
	@RequestMapping(value = "selectEmployeeByDep", method = RequestMethod.POST)
	public ResponseMsg<List<EssEmployee>> selectEmployee(@RequestBody String depid) {
		ResponseMsg<List<EssEmployee>> rm = new ResponseMsg<>();
		Map<String, String> map = JsonUtil.jsonToMap(depid);
		try {
			List<EssEmployee> list = postService.getEmployeeByDep(map);
			rm.setData(list);
			rm.setMessage("获取Employee数据成功");
			rm.setStatus(0);
		} catch (Exception e) {

			rm.setMessage("获取Employee数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}

		return rm;
	}

	/**添加岗位
	 * @param post
	 * @return
	 */
	@RequestMapping(value = "addpost", method = RequestMethod.POST)
	@ResourceScan(rsc = @Resource(cd = Const.MODIFY_POST, name = "添加",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.POST_MANAGEMENT, url="/post/addpost", name = "岗位管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> addpost(@RequestBody EssPostVo post) {

		ResponseMsg<String> rm = new ResponseMsg<>();
		 try {
			postService.addpost(post);
			rm.setMessage("添加post数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			rm.setMessage("添加post数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}
		return rm;
	}

	@RequestMapping(value = "updatepost", method = RequestMethod.POST)
	@ResourceScan(rsc = @Resource(cd = Const.ADD_POST, name = "修改岗位",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.POST_MANAGEMENT, url="/post/updatepost", name = "岗位管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> updatepost(@RequestBody EssPostVo post) {
		ResponseMsg<String> rm = new ResponseMsg<>();

		 try {
			postService.updatepost(post);
			rm.setMessage("修改post数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			rm.setMessage("修改post数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}
		return rm;
	}
	/**删除岗位
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = "delpost", method = RequestMethod.POST)
	@ResourceScan(rsc = @Resource(cd = Const.DELETE_POST, name = "删除岗位",  hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
    , prsc = {@Resource( cd = Const.POST_MANAGEMENT, url="/post/delpost", name = "岗位管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
			@Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT) })
	public ResponseMsg<String> delpost(@RequestBody String postId) {
		ResponseMsg<String> rm = new ResponseMsg<>();
		Map<String, String> map = JsonUtil.jsonToMap(postId);
		 try {
			postService.delpost(map);
			rm.setMessage("删除post数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			rm.setMessage("删除post数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}
		return rm;
	}
	/**查询部门下的岗位
	 * @param request
	 * @param post
	 * @return
	 */
	@RequestMapping(value = "/selectPostUnderDep", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseMsg<List<EssPost>> selectPostUnderDep(HttpServletRequest request,
			@RequestBody String post ) {
		ResponseMsg<List<EssPost>> rm = new ResponseMsg<List<EssPost>>();
		Map<String, String> map = JsonUtil.jsonToMap(post);
		
		try {
			List<EssPost> list = postService.selectPostUnderDep(map);
				rm.setData(list);
					rm.success("获得post数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail("获得post数据失败");
			logger.info(e);
		}
		return rm;
	}

}
