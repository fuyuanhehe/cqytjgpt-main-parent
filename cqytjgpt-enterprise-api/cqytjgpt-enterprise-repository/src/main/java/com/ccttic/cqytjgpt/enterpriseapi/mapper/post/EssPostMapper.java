package com.ccttic.cqytjgpt.enterpriseapi.mapper.post;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.category.CategoryAttr;
import com.ccttic.util.exception.AppException;
import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeePost;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;

public interface EssPostMapper {


	/**分页查询post的总数
	 * @param params
	 * @return
	 * @throws Exception
	 */
	long qryPostListCount(Map<String, Object> params)throws AppException;

	/**分页查询post
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<EssPostVo> qryPostList(Map<String, Object> params)throws AppException;
	
	/**获取所有的组织
	 * @return
	 * @throws Exception
	 */
	List<Organization> getAllOrg()throws AppException;

	/**根据组织获取部门
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Department> getDepartmentByOrg(Map<String, String> map)throws AppException;

	/**根据部门获取员工
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<EssEmployee> getEmployeeByDep(Map<String, String> map)throws AppException;

	/**创建岗位
	 * @param post
	 * @return
	 * @throws Exception
	 */
	int createpost(EssPostVo post)throws AppException;

	/**关联员工和岗位
	 * @param eep
	 * @throws Exception
	 */
	void relatedPostAndEmp(EssEmployeePost eep)throws AppException;

	/**更新岗位
	 * @param post
	 * @throws Exception
	 */
	void updatepost(EssPost post)throws AppException;

	/**查询部门下的员工
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<EssEmployee> selectEmpUnderPost(@Param("id") String id)throws AppException;

	/**删除岗位下的员工
	 * @param id
	 * @throws Exception
	 */
	void delEmpUnderPost(String id)throws AppException;

	/**删除岗位
	 * @param map
	 * @throws Exception
	 */
	void delpost(Map<String, String> map)throws AppException;

	/**查询部门下的岗位
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<EssPost> selectPostUnderDep(Map<String, String> map)throws AppException;
	
	List<EssPost> getAllPost()throws AppException;

	int selectPostByPostCd(@Param("postCd") String postCd);
}