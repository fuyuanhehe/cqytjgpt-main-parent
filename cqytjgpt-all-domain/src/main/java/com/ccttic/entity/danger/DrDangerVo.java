package com.ccttic.entity.danger;

import java.util.List;

public class DrDangerVo extends DrDanger {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6673671843859000059L;

	private List<DrDanger> drDangers;
	private int page = 1;
	private int rows = 10;
	// 行政区域代码
	private String areaCd;
	// 行政区域名称
	private String areaNm;
	//企业id
    private String etpNm;
    //运管所名
	private String orgNm;

	private String etpId;

    public String getEtpId() {
        return etpId;
    }

    public void setEtpId(String etpId) {
        this.etpId = etpId;
    }

    public String getEtpNm() {
        return etpNm;
    }

    public void setEtpNm(String etpNm) {
        this.etpNm = etpNm;
    }

    private List<String> list;
	//用户类型
	private String empType;
	
	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
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

	

	public String getAreaCd() {
		return areaCd;
	}

	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
	}

	public String getAreaNm() {
		return areaNm;
	}

	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
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

	public List<DrDanger> getDrDangers() {
		return drDangers;
	}

	public void setDrDangers(List<DrDanger> drDangers) {
		this.drDangers = drDangers;
	}

}
