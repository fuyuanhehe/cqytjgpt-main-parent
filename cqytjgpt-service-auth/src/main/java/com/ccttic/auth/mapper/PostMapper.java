package com.ccttic.auth.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.auth.model.Post;

/**
   功能说明：      MyBatis岗位映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月10日
 */

public interface PostMapper {
	/**
	 * 根据条件获取岗位信息
	 * @param params
	 * @return
	 */
	public List<Post> pagerPost(Map<String, Object> params);

	/**
	 * 
	 * 根据条件获取岗位信息总记录数
	 * @param params
	 * @return
	 */
	public long countPost(Map<String, Object> params);

	/**
	 * 添加岗位
	 * @param post
	 */
	public int addPost(@Param("post") Post post);

	/**
	 * 通过ID获取岗位信息
	 * @param id
	 * @return
	 */
	public Post findPostById(@Param("id") String id);

	/**
	 * 修改岗位
	 * @param post
	 */
	public void modifyPost(@Param("post") Post post);

	/**
	 * 通过ID删除岗位信息
	 * @param id
	 */
	public int deletePost(@Param("id") String id);

	/**
	 * 取得所有岗位（用于下拉显示)
	 * @return
	 */
	public List<Post> findAllPost();

	/**
	 * 通过编号获取岗位信息
	 * @param postCd
	 * @return
	 */
	public Post findPostByCd(@Param("postCd") String postCd);

	/**
	 * 通过岗位类型获取岗位
	 * @param postType
	 * @return
	 */
	public Post findPostByPostType(@Param("postType") String postType);

}
