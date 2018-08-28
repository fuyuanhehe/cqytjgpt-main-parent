package com.ccttic.cqytjgpt.webapi.interfaces.post;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IPostService {

	/**
	 * 查询岗位
	 * @param page
	 * @param post
	 * @param list
	 * @return
	 * @throws Exception
	 */
	Page<EssPostVo> selectPost(Pageable page, EssPostVo post, EmployeePermission list) throws AppException;

	/**
	 * 获取所有组织
	 * @return
	 * @throws Exception
	 */
	List<Organization> getAllOrg() throws AppException;

	/**
	 * 获取组织下的部门
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Department> getDepartmentByOrg(Map<String, String> map) throws AppException;

	/**获取部门下的员工
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<EssEmployee> getEmployeeByDep(Map<String, String> map) throws AppException;

	/**添加岗位
	 * @param post
	 * @throws Exception
	 */
	String addPost(EssPostVo post) throws AppException;

	/**修改岗位
	 * @param post
	 * @throws Exception
	 */
	void updatePost(EssPostVo post) throws AppException;

	/**删除岗位
	 * @param map
	 * @throws Exception
	 */
	void delPost(Map<String, String> map) throws AppException;

	/**查询部门下的岗位
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<EssPost> selectPostUnderDep(Map<String, String> map) throws AppException;
}
