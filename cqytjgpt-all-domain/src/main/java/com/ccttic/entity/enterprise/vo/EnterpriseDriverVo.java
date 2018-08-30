package com.ccttic.entity.enterprise.vo;

import java.io.Serializable;
import java.util.List;

import com.ccttic.entity.drivers.Driver;

public class EnterpriseDriverVo extends Driver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1777695904284295639L;

	private int page = 1;

	private int rows = 10;
	//账号类型
	private String empType;
	//企业id
	private  List<String> list;
	//区域
	private String areaNm;
	//企业名称
	private String etpNm;




	public String getAreaNm() {
		return areaNm;
	}

	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}

	public String getEtpNm() {
		return etpNm;
	}

	public void setEtpNm(String etpNm) {
		this.etpNm = etpNm;
	}

	public EnterpriseDriverVo() {
		// TODO Auto-generated constructor stub
	}

	public EnterpriseDriverVo(String id, String name, String idcard, String telphone,
			String mobilephone, String adress, String permicar, String firstrecivetime,
			String mgrdepart, String mgrdepartareaid, String mgrenterpriseid, String nextexaminetime,
			String effectstarttime, String effectendtime, String examineeffectendtime,
			String scoretotal, String state, int page, int rows, String empType, List<String> list) {
		super();
		this.page = page;
		this.rows = rows;
		this.empType = empType;
		this.list = list;
	}

	@Override
	public String toString() {
		return "EnterpriseDriverVo [page=" + page + ", rows=" + rows + ", empType=" + empType
				+ ", list=" + list + "]";
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

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}



}
