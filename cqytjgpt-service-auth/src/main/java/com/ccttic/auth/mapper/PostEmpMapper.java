package com.ccttic.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.auth.model.PostEmp;

/**
   功能说明：      MyBatis岗位人员映射
 @version  1.0.0
 @author  xgYin
 @date  2016年12月10日
 */

public interface PostEmpMapper {
	/**
	 * 根据岗位ID获取员工信息
	 * @param postId
	 * @return
	 */
	public List<PostEmp> findEmpsByPostId(@Param("postId") String postId);

	/**
	 * 根据员工ID获取岗位信息
	 * @param empId
	 * @return
	 */
	public List<PostEmp> findPostsByEmpId(@Param("empId") String empId);

	/**
	 * 通过岗位ID删除岗位人员关联关系
	 * @param postId
	 * @return
	 */
	public int deleteEmpPostByPostId(@Param("postId") String postId);

	/**
	 * 通过人员ID删除岗位人员关联关系
	 * @param empId
	 * @return
	 */
	public int deleteEmpPostByEmpId(@Param("empId") String empId);

	/**
	 * 插入岗位人员信息
	 * @param postEmp
	 */
	public void addPostEmp(@Param("postEmp") PostEmp postEmp);

	/**
	 * 移除指定人员指定岗位
	 * @param empId
	 * @param postId
	 */
	public void removeEmpPost(@Param("empId") String empId, @Param("postId") String postId);

	/**
	 * 通过人员ID，岗位ID获取岗位人员信息
	 * @param empId
	 * @param postId
	 * @return
	 */
	public long findPostEmpByCondition(@Param("empId") String empId, @Param("postId") String postId);
}
