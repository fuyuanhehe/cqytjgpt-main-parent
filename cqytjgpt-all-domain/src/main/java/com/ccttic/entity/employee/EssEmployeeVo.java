package com.ccttic.entity.employee;

import java.util.List;

import com.ccttic.entity.post.EssPost;

public class EssEmployeeVo extends EssEmployee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//部门名
	private String depNm;
	//部门id
	private String depid;
	//组织名
	private String orgNm;
	//组织id
	private String orgCd;
	//企业id
	private String eptId;
	
	
	//岗位
	private List<EssPost> post;
	private int page = 1;
	private int rows = 10;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getDepNm() {
		return depNm;
	}
	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}
	public String getDepid() {
		return depid;
	}
	public void setDepid(String depid) {
		this.depid = depid;
	}
	public String getOrgNm() {
		return orgNm;
	}
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	public List<EssPost> getPost() {
		return post;
	}
	public void setPost(List<EssPost> post) {
		this.post = post;
	}public String getEptId() {
		return eptId;
	}
	public void setEptId(String eptId) {
		this.eptId = eptId;
	}
	public EssEmployeeVo(String depNm, String depid, String orgNm, String orgCd, String eptId, List<EssPost> post,
			int page, int rows) {
		super();
		this.depNm = depNm;
		this.depid = depid;
		this.orgNm = orgNm;
		this.orgCd = orgCd;
		this.eptId = eptId;
		this.post = post;
		this.page = page;
		this.rows = rows;
	}
	public EssEmployeeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
