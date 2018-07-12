package com.ccttic.cqytjgpt.webapi.service.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Resource
	private EssPostMapper postMapper;
	@Override
	public Page<EssPostVo> selectPost(Pageable page, EssPostVo post,List<EssPost> list) throws Exception {
		Page<EssPostVo> pager = new PageImpl<EssPostVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("posts", list);
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
	public List<Organization> getAllOrg() throws Exception {
		return postMapper.getAllOrg();
	}

	@Override
	public List<Department> getDepartmentByOrg(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return postMapper.getDepartmentByOrg(map);
	}

	@Override
	public List<EssEmployee> getEmployeeByDep(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return postMapper.getEmployeeByDep(map);
	}

	@Override
	@Transactional
	public void addpost(EssPostVo post) throws Exception {

		String id = RandomHelper.uuid();
		post.setId(id);
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
	public void updatepost(EssPostVo post) throws Exception {

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
	public void delpost(Map<String, String> map) throws Exception {
		postMapper.delpost(map);
		postMapper.delEmpUnderPost(map.get("postId"));

	}

	@Override
	public List<EssPost> selectPostUnderDep(Map<String, String> map) throws Exception {

		List<EssPost> list = postMapper.selectPostUnderDep(map);

		return list;
	}

}
