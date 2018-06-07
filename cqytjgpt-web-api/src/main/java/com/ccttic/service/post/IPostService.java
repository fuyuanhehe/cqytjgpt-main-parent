package com.ccttic.service.post;

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

	Page<EssPostVo> selectPost(Pageable page, EssPostVo post) throws Exception;

	List<Organization> getAllOrg() throws Exception;

	List<Department> getDepartmentByOrg(Map<String, String> map) throws Exception;

	List<EssEmployee> getEmployeeByDep(Map<String, String> map) throws Exception;

	void addpost(EssPostVo post) throws Exception;

	void updatepost(EssPostVo post) throws Exception;

	void delpost(Map<String, String> map) throws Exception;

	List<EssPost> selectPostUnderDep(Map<String, String> map) throws Exception;

}
