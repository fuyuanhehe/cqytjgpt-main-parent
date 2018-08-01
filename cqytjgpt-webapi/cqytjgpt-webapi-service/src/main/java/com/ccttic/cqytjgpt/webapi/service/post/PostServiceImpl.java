package com.ccttic.cqytjgpt.webapi.service.post;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.post.IPostService;
import com.ccttic.cqytjgpt.webapi.mapper.post.EssPostMapper;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeePost;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

import javax.annotation.Resource;

@Service
public class PostServiceImpl implements IPostService {
	@Autowired
	private EssPostMapper postMapper;
	@Override
	public Page<EssPostVo> selectPost(Pageable page, EssPostVo post, EmployeePermission employeePermission) throws AppException {
		Page<EssPostVo> pager = new PageImpl<EssPostVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		
		if (null!= employeePermission && null!= employeePermission.getOrgId() && !(Const.SUPERMAN.equals(employeePermission.getEmployeeType()))){
			params.put("orgId",employeePermission.getOrgId());
		}
		if (null!= employeePermission && null!= employeePermission.getEnterpriseId() && !(Const.SUPERMAN.equals(employeePermission.getEmployeeType()))){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		if (null!= employeePermission && Const.SUPERMAN.equals(employeePermission.getEmployeeType()) && "true".equals(post.getOrgNm ())){
			params.put("employeeType",Const.SUPERMAN);
			params.put("org","true");
		}
		if (null!= employeePermission && Const.SUPERMAN.equals(employeePermission.getEmployeeType()) && "false".equals(post.getOrgNm ())){
			params.put("employeeType",Const.SUPERMAN);
			params.put("etp","true");
		}
		params.put("pageSize", page.getRows() + "");
		params.put("startRecord", (page.getPage() - 1) * page.getRows() + "");
		params.put("postNm", post.getPostnm());// 岗位名称

		long totalRows = postMapper.qryPostListCount(params);
		List<EssPostVo> records = postMapper.qryPostList(params);
		for (EssPostVo essPostVo : records) {
			List<EssEmployee> emp = postMapper.selectEmpUnderPost(essPostVo.getId());
			essPostVo.setEmp(emp);
		}

		pager.setTotalRows(totalRows);
		pager.setRecords(records);

		return pager;
	}

	@Override
	public List<Organization> getAllOrg() throws AppException {
		return postMapper.getAllOrg();
	}

	@Override
	public List<Department> getDepartmentByOrg(Map<String, String> map) throws AppException {
		// TODO Auto-generated method stub
		return postMapper.getDepartmentByOrg(map);
	}

	@Override
	public List<EssEmployee> getEmployeeByDep(Map<String, String> map) throws AppException {
		// TODO Auto-generated method stub
		return postMapper.getEmployeeByDep(map);
	}

	@Override
	@Transactional
	public void addPost(EssPostVo post) throws AppException {

		String id = RandomHelper.uuid();
		post.setId(id);
		post.setCreatetime(new Date());
		postMapper.createpost(post);
		if(post.getEmp()!=null) {
		for (int i = 0; i < post.getEmp().size(); i++) {
			String uid = RandomHelper.uuid();
			EssEmployeePost eep = new EssEmployeePost();
			eep.setEmpId(post.getEmp().get(i).getId());
			eep.setId(uid);
			eep.setVersion(1);
			eep.setPostId(id);
			postMapper.relatedPostAndEmp(eep);
		}
	}
	}

	@Override
	@Transactional
	public void updatePost(EssPostVo post) throws AppException {

		postMapper.updatepost(post);
		postMapper.delEmpUnderPost(post.getId());
		for (int i = 0; i < post.getEmp().size(); i++) {
			String uid = RandomHelper.uuid();
			EssEmployeePost eep = new EssEmployeePost();
			eep.setEmpId(post.getEmp().get(i).getId());
			eep.setId(uid);
			eep.setVersion(1);
			eep.setPostId(post.getId());
			postMapper.relatedPostAndEmp(eep);
		}
	}

	@Override
	@Transactional
	public void delPost(Map<String, String> map) throws AppException {
		postMapper.delpost(map);
		postMapper.delEmpUnderPost(map.get("id"));

	}

	@Override
	public List<EssPost> selectPostUnderDep(Map<String, String> map) throws AppException {

		List<EssPost> list = postMapper.selectPostUnderDep(map);

		return list;
	}
}
