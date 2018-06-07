package com.ccttic.entity.employee;

import java.util.List;

import com.ccttic.entity.post.EssPost;

public class EssEmployeeVo extends EssEmployee {
	//部门名
	private String depNm;
	//部门id
	private String depid;
	//组织名
	private String orgNm;
	//组织id
	private String orgCd;
	//岗位
	private List<EssPost> post;
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
	}
	public EssEmployeeVo(String depNm, String depid, String orgNm, String orgCd, List<EssPost> post) {
		super();
		this.depNm = depNm;
		this.depid = depid;
		this.orgNm = orgNm;
		this.orgCd = orgCd;
		this.post = post;
	}
	public EssEmployeeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
