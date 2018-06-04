package com.ccttic.mapper.post;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeePost;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;

public interface EssPostMapper {


	long qryPostListCount(Map<String, String> params)throws Exception;

	List<EssPostVo> qryPostList(Map<String, String> params)throws Exception;

	List<Organization> getAllOrg()throws Exception;

	List<Department> getDepartmentByOrg(Map<String, String> map)throws Exception;

	List<EssEmployee> getEmployeeByDep(Map<String, String> map)throws Exception;

	int createpost(EssPost post);

	void relatedPostAndEmp(EssEmployeePost eep);

	void updatepost(EssPost post);

	List<String> selectEmpUnderPost(@Param("id") String id);

	void delEmpUnderPost(String id);
	
	
}