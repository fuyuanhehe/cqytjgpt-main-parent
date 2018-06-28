package com.ccttic.entity.role.vo;
//自定义员工实体
public class EmpVo {

	private String id;
	
	private String empNm;
	
	
	public EmpVo() {
	}


	public EmpVo(String id, String empNm) {
		super();
		this.id = id;
		this.empNm = empNm;
	}


	@Override
	public String toString() {
		return "EmpVp [id=" + id + ", empNm=" + empNm + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmpNm() {
		return empNm;
	}


	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	
	
	
}
