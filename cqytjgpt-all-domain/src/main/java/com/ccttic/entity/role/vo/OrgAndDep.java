package com.ccttic.entity.role.vo;

import java.io.Serializable;
import java.util.List;

public class OrgAndDep implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2774941380195401218L;

	private List<String> OrgNm;
	
	private List<String> Dep;
	
	public OrgAndDep() {
		// TODO Auto-generated constructor stub
	}

	public OrgAndDep(List<String> orgNm, List<String> dep) {
		super();
		OrgNm = orgNm;
		Dep = dep;
	}

	@Override
	public String toString() {
		return "OrgAndDep [OrgNm=" + OrgNm + ", Dep=" + Dep + "]";
	}

	public List<String> getOrgNm() {
		return OrgNm;
	}

	public void setOrgNm(List<String> orgNm) {
		OrgNm = orgNm;
	}

	public List<String> getDep() {
		return Dep;
	}

	public void setDep(List<String> dep) {
		Dep = dep;
	}
	
	
	
	
}
