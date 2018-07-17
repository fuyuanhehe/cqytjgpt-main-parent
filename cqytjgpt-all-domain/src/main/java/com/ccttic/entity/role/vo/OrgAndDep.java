package com.ccttic.entity.role.vo;

import java.io.Serializable;
import java.util.List;

public class OrgAndDep implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2774941380195401218L;

	private List<OrgDepVo> Org;
	
	private List<OrgDepVo> Dep;
	
	public OrgAndDep() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrgAndDep [Org=" + Org + ", Dep=" + Dep + "]";
	}

	public List<OrgDepVo> getOrg() {
		return Org;
	}

	public void setOrg(List<OrgDepVo> org) {
		Org = org;
	}

	public List<OrgDepVo> getDep() {
		return Dep;
	}

	public void setDep(List<OrgDepVo> dep) {
		Dep = dep;
	}

	public OrgAndDep(List<OrgDepVo> org, List<OrgDepVo> dep) {
		super();
		Org = org;
		Dep = dep;
	}
	
	
}
