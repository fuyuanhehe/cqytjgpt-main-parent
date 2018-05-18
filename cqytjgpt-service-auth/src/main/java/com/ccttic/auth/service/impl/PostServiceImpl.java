package com.ccttic.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.exception.SystemException;
import com.ccttic.auth.common.page.Page;
import com.ccttic.auth.common.page.PageImpl;
import com.ccttic.auth.common.page.Pageable;
import com.ccttic.auth.mapper.PostEmpMapper;
import com.ccttic.auth.mapper.PostMapper;
import com.ccttic.auth.model.Post;
import com.ccttic.auth.model.PostCategoryEnum;
import com.ccttic.auth.model.PostEmp;
import com.ccttic.auth.service.IPostService;
import com.ccttic.auth.util.ObjectHelper;
import com.ccttic.auth.util.RandomHelper;

/**
   功能说明：    岗位业务实现类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.impl.ContractServiceImpl.java
 @date  2016年12月10日
 */
@Service
public class PostServiceImpl implements IPostService {
	@Resource
	private PostMapper mapper;
	@Resource
	private PostEmpMapper peMapper;

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IPostService#findAllPost()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Post> findAllPost() {
		return mapper.findAllPost();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Post> loadPostsPages(Pageable page, Post post) throws AppException {
		Page<Post> pager = new PageImpl<Post>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("postCd", post.getPostCd());
		params.put("postNm", post.getPostNm());
		params.put("isDefault", post.getIsDefault());
		long totolRols = mapper.countPost(params);
		List<Post> records = mapper.pagerPost(params);
		for (Post record : records) {
			//获取岗位人员
			List<PostEmp> emps = peMapper.findEmpsByPostId(record.getId());
			String empIds = "";
			String empCds = "";
			String empNms = "";
			for (PostEmp emp : emps) {
				empIds += emp.getEmpId() + ",";
				empCds += emp.getEmpCd() + ",";
				empNms += emp.getEmpNm() + ",";
			}
			if (ObjectHelper.isNotEmpty(empIds)) {
				empIds = empIds.substring(0, empIds.length() - 1);
				empCds = empCds.substring(0, empCds.length() - 1);
				empNms = empNms.substring(0, empNms.length() - 1);
			}
			record.setEmpIds(empIds);
			record.setEmpCds(empCds);
			record.setEmpNms(empNms);
		}
		pager.setTotalRows(totolRols);
		pager.setRecords(records);

		return pager;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IPostService#editPost(com.studio.framework.beans.ess.Post)
	 */
	@Override
	@Transactional
	public boolean editPost(Post post) throws AppException {

		if (ObjectHelper.isEmpty(post.getId())) {
			String postId = RandomHelper.uuid();
			post.setId(postId);
			post.setPostCd(postId);
			post.setIsDefault(false);
			post.setPostType(PostCategoryEnum.BPost.name());
			post.setVersion(1);
			mapper.addPost(post);
			if (ObjectHelper.isNotEmpty(post.getEmpIds())) {
				for (String empId : post.getEmpIds().split(",")) {
					PostEmp postEmp = new PostEmp(RandomHelper.uuid(), empId, postId, 1);
					peMapper.addPostEmp(postEmp);
				}
			}

		} else {
			Post p = mapper.findPostById(post.getId());
			if (ObjectHelper.isNotEmpty(p)) {
				p.setPostCd(post.getPostCd());
				p.setPostNm(post.getPostNm());
				p.setDescription(post.getDescription());
				p.setVersion(p.getVersion() + 1);
				mapper.modifyPost(p);
				peMapper.deleteEmpPostByPostId(p.getId());
				if (ObjectHelper.isNotEmpty(post.getEmpIds())) {
					for (String empId : post.getEmpIds().split(",")) {
						PostEmp postEmp = new PostEmp(RandomHelper.uuid(), empId, p.getId(), 1);
						peMapper.addPostEmp(postEmp);
					}
				}
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IPostService#deletePost(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean deletePost(String id) throws AppException {
		peMapper.deleteEmpPostByPostId(id);
		mapper.deletePost(id);
		return true;

	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IPostService#findPostById(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Post findPostById(String id) throws AppException {
		return mapper.findPostById(id);
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IPostService#findPostByPostCd(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Post findPostByPostCd(String postCd) throws SystemException {
		Post post = mapper.findPostByCd(postCd);
		//获取岗位人员
		List<PostEmp> emps = peMapper.findEmpsByPostId(post.getId());
		String empIds = "";
		String empCds = "";
		String empNms = "";
		for (PostEmp emp : emps) {
			empIds += emp.getEmpId() + ",";
			empCds += emp.getEmpCd() + ",";
			empNms += emp.getEmpNm() + ",";
		}
		if (ObjectHelper.isNotEmpty(empIds)) {
			empIds = empIds.substring(0, empIds.length() - 1);
			empCds = empCds.substring(0, empCds.length() - 1);
			empNms = empNms.substring(0, empNms.length() - 1);
		}
		post.setEmpIds(empIds);
		post.setEmpCds(empCds);
		post.setEmpNms(empNms);
		return post;
	}

}
