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
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.post.IPostService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping("/post")
public class PostController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private IPostService postService;

	@RequestMapping(value = "selectPost", method = RequestMethod.POST)
	public ResponseMsg<Page<EssPostVo>> selectPost(ServletRequest request, ServletResponse response, PageRequest page,
			@RequestBody EssPostVo post) {
		ResponseMsg<Page<EssPostVo>> rm = new ResponseMsg<>();
		try {
			Page<EssPostVo> pager = postService.selectPost(page, post);

			rm.setData(pager);
			rm.setMessage("获取post数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			rm.setMessage("获取post数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}
		return rm;
	}

	@RequestMapping(value = "selectAllOrganization", method = RequestMethod.POST)
	public ResponseMsg<List<Organization>> selectAllOrganization(ServletRequest request, ServletResponse response) {
		ResponseMsg<List<Organization>> rm = new ResponseMsg<>();
		try {
			List<Organization> list = postService.getAllOrg();
			rm.setData(list);
			rm.setMessage("获取Organization数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			rm.setMessage("获取Organization数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}

		return rm;
	}

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
			// TODO Auto-generated catch block

			rm.setMessage("获取department数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}

		return rm;
	}

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
			// TODO Auto-generated catch block

			rm.setMessage("获取Employee数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}

		return rm;
	}

	@RequestMapping(value = "addpost", method = RequestMethod.POST)
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
	public ResponseMsg<String> updatepost(@RequestBody EssPostVo post) {
		ResponseMsg<String> rm = new ResponseMsg<>();

		 try {
			postService.updatepost(post);
			rm.setMessage("修改post数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.setMessage("修改post数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}
		return rm;
	}
	@RequestMapping(value = "delpost", method = RequestMethod.POST)
	public ResponseMsg<String> delpost(@RequestBody String postId) {
		ResponseMsg<String> rm = new ResponseMsg<>();
		Map<String, String> map = JsonUtil.jsonToMap(postId);
		 try {
			postService.delpost(map);
			rm.setMessage("删除post数据成功");
			rm.setStatus(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.setMessage("删除post数据失败");
			rm.setStatus(-1);
			logger.info(e);
		}
		return rm;
	}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.fail("获得post数据失败");
			logger.info(e);
		}
		return rm;
	}

}
