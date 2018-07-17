package com.ccttic.entity.role.vo;

import java.io.Serializable;
import java.util.List;

public class OrgAndDep implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2774941380195401218L;

	private List<OrgDepVo> OrgNm;
	
	private List<OrgDepVo> Dep;
	
	public OrgAndDep() {
		// TODO Auto-generated constructor stub
	}
	public OrgAndDep(List<OrgDepVo> orgNm, List<OrgDepVo> dep) {
		super();
		OrgNm = orgNm;
		Dep = dep;
	}

	public List<OrgDepVo> getOrgNm() {
		return OrgNm;
	}

	public void setOrgNm(List<OrgDepVo> orgNm) {
		OrgNm = orgNm;
	}

	public List<OrgDepVo> getDep() {
		return Dep;
	}

	public void setDep(List<OrgDepVo> dep) {
		Dep = dep;
	}

	@Override
	public String toString() {
		return "OrgAndDep [OrgNm=" + OrgNm + ", Dep=" + Dep + "]";
	}

	
	
}
