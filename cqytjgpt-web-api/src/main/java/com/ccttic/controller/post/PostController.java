package com.ccttic.controller.post;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.beans.ResponseMsg;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.service.post.IPostService;
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
	public ResponseMsg<List<Department>> selectDepartment(@RequestBody String depid) {
		ResponseMsg<List<Department>> rm = new ResponseMsg<>();
		Map<String, String> map = JsonUtil.jsonToMap(depid);
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
		System.out.println(post.getEmp().get(1).getId());
		int i = postService.addpost(post);
		if (i == 1) {
			rm.setMessage("添加post数据成功");
			rm.setStatus(0);
		} else {
			rm.setMessage("添加post数据失败");
			rm.setStatus(-1);
		}

		return rm;
	}

	@RequestMapping(value = "updatepost", method = RequestMethod.POST)
	public ResponseMsg<String> updatepost(@RequestBody EssPostVo post) {
		ResponseMsg<String> rm = new ResponseMsg<>();

		int i = postService.updatepost(post);
		if (i == 1) {
			rm.setMessage("添加post数据成功");
			rm.setStatus(0);
		} else {
			rm.setMessage("添加post数据失败");
			rm.setStatus(-1);
		}

		return rm;
	}

}
