package com.ccttic.entity.role.vo;

import com.ccttic.entity.role.VehiIllicit;

public class PageVehiIllicitVo extends VehiIllicit {
	private static final long serialVersionUID = -5437595901819895593L;
	private int page = 1;
	private int rows = 10;
	private String mgrEnterpriseId;


	public PageVehiIllicitVo() {
	}

	public PageVehiIllicitVo(String areaNm,String vehiNo, String vehiNoType, String vehiNoTypeText, String nature, String ownership, String owner, String adress, String mgrDepart, String mgrDepartAreaId, String vehicleId, String illicitTime, String illicitScore, String illicitAmount, String illicitAdress, String illicit, String illicitDesc, String pickDepartment, String pickDepartmentDesc, String state, String remark, String etpNm, String startTime, String endTime) {
		super(areaNm,vehiNo, vehiNoType, vehiNoTypeText, nature, ownership, owner, adress, mgrDepart, mgrDepartAreaId, vehicleId, illicitTime, illicitScore, illicitAmount, illicitAdress, illicit, illicitDesc, pickDepartment, pickDepartmentDesc, state, remark, etpNm, startTime, endTime);
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

	public String getMgrEnterpriseId() {
		return mgrEnterpriseId;
	}

	public void setMgrEnterpriseId(String mgrEnterpriseId) {
		this.mgrEnterpriseId = mgrEnterpriseId;
	}

}
