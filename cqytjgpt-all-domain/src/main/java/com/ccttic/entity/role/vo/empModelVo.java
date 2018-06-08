package com.ccttic.entity.role.vo;

import java.util.List;

//员工实体Vo
public class empModelVo {
      //员工ID
	private List<String> empId;
	// 员工名称
	private List<String> empNm;
	public empModelVo(List<String> empId, List<String> empNm) {
		super();
		this.empId = empId;
		this.empNm = empNm;
	}
	@Override
	public String toString() {
		return "empModelVo [empId=" + empId + ", empNm=" + empNm + "]";
	}
	public List<String> getEmpId() {
		return empId;
	}
	public void setEmpId(List<String> empId) {
		this.empId = empId;
	}
	public List<String> getEmpNm() {
		return empNm;
	}
	public void setEmpNm(List<String> empNm) {
		this.empNm = empNm;
	}
	
	public empModelVo() {
		// TODO Auto-generated constructor stub
	}
	
}
