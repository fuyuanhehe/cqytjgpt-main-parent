package com.ccttic.entity.post;

import java.util.List;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.role.Department;

public class EssPostVo extends EssPost {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//组织名
	private String orgNm;
	private String orgid;
	//部门名
	private String depNm;
	//员工名
	private List<EssEmployee> emp;
	//员工类型
	private String empType;
	//部门
	private List<Department> deps;
	private int page = 1;
	private int rows = 10;

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

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
	public List<EssEmployee> getEmp() {
		return emp;
	}
	public void setEmp(List<EssEmployee> emp) {
		this.emp = emp;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public List<Department> getDeps() {
		return deps;
	}
	public void setDeps(List<Department> deps) {
		this.deps = deps;
	}
	public EssPostVo(String orgNm, String depNm, List<EssEmployee> emp, String empType, List<Department> deps, int page,
			int rows) {
		super();
		this.orgNm = orgNm;
		this.depNm = depNm;
		this.emp = emp;
		this.empType = empType;
		this.deps = deps;
		this.page = page;
		this.rows = rows;
	}
	public EssPostVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
