package com.ccttic.entity.role.vo;

import com.ccttic.entity.enterprise.Pages;

public class EmpRoleMenuVo extends Pages {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4373210887690185192L;

	  private String id;
	
	  private String orgNm;
	  
	  private String depNm;
	  
	  private String postNm;
	  
	  private String empNm;
	    
	  private String account;
	  
	  private String orgId;
	  
	  private String depId;
	  
	  
	  
	  public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public EmpRoleMenuVo() {
		// TODO Auto-generated constructor stub
	}

	public EmpRoleMenuVo(String id, String orgNm, String depNm, String postNm, String empNm,
			String account) {
		super();
		this.id = id;
		this.orgNm = orgNm;
		this.depNm = depNm;
		this.postNm = postNm;
		this.empNm = empNm;
		this.account = account;
	}

	@Override
	public String toString() {
		return "EmpRoleMenuVo [id=" + id + ", orgNm=" + orgNm + ", depNm=" + depNm + ", postNm="
				+ postNm + ", empNm=" + empNm + ", account=" + account + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public String getDepNm() {
		return depNm;
	}

	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}

	public String getPostNm() {
		return postNm;
	}

	public void setPostNm(String postNm) {
		this.postNm = postNm;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	  
	  
}
