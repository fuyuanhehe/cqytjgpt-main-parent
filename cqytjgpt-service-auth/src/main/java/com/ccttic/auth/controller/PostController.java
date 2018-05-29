package com.ccttic.auth.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.auth.common.beans.ResponseMsg;
import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.exception.InvalidArgumentException;
import com.ccttic.auth.common.page.Page;
import com.ccttic.auth.common.page.PageRequest;
import com.ccttic.auth.model.Post;
import com.ccttic.auth.model.SelectPostVo;
import com.ccttic.auth.service.IPostService;
import com.ccttic.auth.util.ObjectHelper;

/**
   功能说明：     岗位信息
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.controller.ess.FileUploadController.java
 @date  2016年12月9日
 */
@RestController
@RequestMapping("/ess")
public class PostController implements Serializable {
	private static final long serialVersionUID = 213026144265132682L;
	private final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private IPostService postService;

	/**
	 * 岗位管理
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping(value = "/postInit")
	@Menu(resource = "essential.postinit", group = "essential-manager", label = "岗位管理", order = 2, description = "岗位管理")
	public ModelAndView postInit() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ess/post");
		return mv;
	}*/

	/**
	 * 根据查询条件获取岗位列表
	 * 
	 * @param pageRequest
	 *            分页请求接口
	 * @param post
	 *            查询条件
	 * @return JSON
	 * @throws AppException
	 */
	@RequestMapping("/loadPostPages")
	@ResponseBody
	public ResponseMsg<List<Post>> loadPostsPages(PageRequest page, Post post) throws AppException {
		ResponseMsg<List<Post>> resp = new ResponseMsg<List<Post>>();
		logger.debug("post--->" + post);
		Page<Post> pager = this.postService.loadPostsPages(page, post);
		resp.success("根据条件查询岗位列表成功！");
		resp.setData(pager.getRecords());
		resp.setTotal(pager.getTotalRows().intValue());
		return resp;
	}

	/**
	 * 取得所有岗位（用于下拉显示)
	 * @return
	 */
	@RequestMapping(value = "/findAllPost")
	public ResponseMsg<List<SelectPostVo>> findAllPost() {
		ResponseMsg<List<SelectPostVo>> resp = new ResponseMsg<List<SelectPostVo>>();
		List<Post> posts = this.postService.findAllPost();
		List<SelectPostVo> list = new ArrayList<SelectPostVo>();
		SelectPostVo defaultVal = new SelectPostVo();
		defaultVal.setId("");
		defaultVal.setText("选择全部");
		list.add(defaultVal);
		for (Post post : posts) {
			SelectPostVo vo = new SelectPostVo();
			vo.setId(post.getPostCd());
			vo.setText(post.getPostNm());
			list.add(vo);
		}
		resp.success("获取所有岗位成功！");
		resp.setData(list);
		return resp;
	}

	/**
	 * 新增或修改岗位信息
	 * 
	 * @param pageRequest
	 *            分页请求接口
	 * @param post
	 *            查询条件
	 * @return JSON
	 */
	@RequestMapping("/editPost")
	public ResponseMsg<String> editPost(Post post) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			if (ObjectHelper.isEmpty(post.getPostNm())) {
				throw new InvalidArgumentException(post.getPostNm());
			}
			this.postService.editPost(post);
			resp.success("编辑岗位成功!");
		} catch (AppException e) {
			resp.fail("编辑岗位失败!");
			logger.error("编辑岗位失败!",e);
		} catch (Exception e) {
			resp.fail("编辑岗位失败!");
			logger.error("编辑岗位失败!",e);
		}
		return resp;
	}

	/**
	 * 根据id获取岗位信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findPost")
	public ResponseMsg<Post> findPost(String id) {
		ResponseMsg<Post> resp = new ResponseMsg<Post>();
		try {
			Post post = this.postService.findPostById(id);
			resp.success("根据id获取岗位成功!");
			resp.setData(post);
		} catch (AppException e) {
			resp.fail("根据id获取岗位失败!");
			logger.error("编辑岗位失败!",e);
		}catch (Exception e) {
			resp.fail("根据id获取岗位失败!");
			logger.error("编辑岗位失败!",e);
		}
		return resp;
	}

	/**
	 * 根据ID删除岗位信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletePost")
	@ResponseBody
	public ResponseMsg<String> deletePost(String id) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			this.postService.deletePost(id);
			resp.success("根据id删除岗位成功!");
		} catch (AppException e) {
			resp.fail("根据id删除岗位失败!");
			logger.error("编辑岗位失败!",e);
		} catch (Exception e) {
			resp.fail("根据id删除岗位失败!");
			logger.error("编辑岗位失败!",e);
		}
		return resp;
	}

}
