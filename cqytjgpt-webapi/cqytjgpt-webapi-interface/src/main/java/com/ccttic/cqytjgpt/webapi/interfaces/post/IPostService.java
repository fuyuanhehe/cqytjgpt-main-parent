package com.ccttic.cqytjgpt.webapi.interfaces.post;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface IPostService {

	/**
	 * 查询岗位
	 * @param page
	 * @param post
	 * @return
	 * @throws Exception
	 */
	Page<EssPostVo> selectPost(Pageable page, EssPostVo post) throws Exception;

	/**
	 * 获取所有组织
	 * @return
	 * @throws Exception
	 */
	List<Organization> getAllOrg() throws Exception;

	/**
	 * 获取组织下的部门
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Department> getDepartmentByOrg(Map<String, String> map) throws Exception;

	/**获取部门下的员工
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<EssEmployee> getEmployeeByDep(Map<String, String> map) throws Exception;

	/**添加岗位
	 * @param post
	 * @throws Exception
	 */
	void addpost(EssPostVo post) throws Exception;

	/**修改岗位
	 * @param post
	 * @throws Exception
	 */
	void updatepost(EssPostVo post) throws Exception;

	/**删除岗位
	 * @param map
	 * @throws Exception
	 */
	void delpost(Map<String, String> map) throws Exception;

	/**查询部门下的岗位
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<EssPost> selectPostUnderDep(Map<String, String> map) throws Exception;

}
