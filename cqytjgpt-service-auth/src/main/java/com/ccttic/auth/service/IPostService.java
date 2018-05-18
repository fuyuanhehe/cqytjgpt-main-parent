package com.ccttic.auth.service;

import java.awt.print.Pageable;
import java.util.List;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.exception.SystemException;
import com.ccttic.auth.model.Post;
import com.github.pagehelper.Page;

/**
   功能说明：     岗位业务接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.impl.IContractService.java
 @date  2016年12月10日
 */

public interface IPostService {
	/**
	 * 获取所有岗位
	 * @param page
	 * @param post
	 * @return
	 * @throws AppException
	 */
	public Page<Post> loadPostsPages(Pageable page, Post post) throws AppException;

	/**
	 * 编辑岗位信息
	 * @param post
	 * @return
	 * @throws AppException
	 */
	public boolean editPost(Post post) throws AppException;

	/**
	 * 根据ID删除岗位信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public boolean deletePost(String id) throws AppException;

	/**
	 * 根据ID获取岗位信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Post findPostById(String id) throws AppException;

	/**
	 * 根据编号获取岗位信息
	 * @param postCd
	 * @return
	 * @throws AppException
	 */
	public Post findPostByPostCd(String postCd) throws SystemException;

	/**
	 * 取得所有岗位（用于下拉显示)
	 * @return
	 */
	public List<Post> findAllPost();

}
