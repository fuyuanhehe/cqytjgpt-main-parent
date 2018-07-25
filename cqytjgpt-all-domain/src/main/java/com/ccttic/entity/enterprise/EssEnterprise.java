package com.ccttic.entity.enterprise;

import java.io.Serializable;
import java.util.Date;

import com.ccttic.entity.BaseBean;

public class EssEnterprise extends BaseBean implements Serializable{
	private static final long serialVersionUID = -8349678655503842856L;
    /**
     * 主键ID
     */
    private String id;

    /**
     * 所属机构Id
     */
    private String orgId;

    /**
     * 企业组织机构编码
     */
    private String etpcd;

    /**
     * 企业 名称
     */
    private String etpnm;

    /**
     * 企业简称
     */
    private String etpshortnm;

    /**
     * 企业法人
     */
    private String etplawer;

    /**
     * 法人电话
     */
    private String lawertel;

    /**
     * 安全责任人
     */
    private String etpsafer;

    /**
     * 责任人电话
     */
    private String safertel;

    /**
     * 外键参照表ess_employee的id
     */
    private String adminEmpid;

    /**
     * 所属交巡警大队
     */
    private String ownertraffic;

    /**
     * 所属运管所
     */
    private String ownertransport;

    /**
     * 企业地址
     */
    private String etpadress;

    /**
     * 企业注册地址
     */
    private String etpregadress;

    /**
     * 企业电话
     */
    private String etptel;

    /**
     * 企业关联附件id，企业营业执照
     */
    private String attachmentId;

    /**
     * 审核状态 -1 审核未通过 0待审核 1审核通过
     */
    private Integer state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 显示顺序
     */
    private Integer disporder;
    
    // 提交开始时间
    private String referStartTime;
    // 提交结束时间
    private String referEndTime;
    // 审核开始时间
    private String checkStartTime;
    // 审核结束时间
    private String checkEndTime;

    private String etpType;
    private String issueCardDate;
    private String roadTransport;
    /**
     * 创建时间
     */
    private Date createtime;

    public EssEnterprise() {
		super();
	}

	public EssEnterprise(String id, String orgId, String etpcd, String etpnm, String etpshortnm, String etplawer,
			String lawertel, String etpsafer, String safertel, String adminEmpid, String ownertraffic,
			String ownertransport, String etpadress, String etpregadress, String etptel, String attachmentId,
			Integer state, String remark, Integer disporder, String referStartTime, String referEndTime,
			String checkStartTime, String checkEndTime, String etpType, String issueCardDate, String roadTransport,Date createtime) {
		super();
		this.id = id;
		this.orgId = orgId;
		this.etpcd = etpcd;
		this.etpnm = etpnm;
		this.etpshortnm = etpshortnm;
		this.etplawer = etplawer;
		this.lawertel = lawertel;
		this.etpsafer = etpsafer;
		this.safertel = safertel;
		this.adminEmpid = adminEmpid;
		this.ownertraffic = ownertraffic;
		this.ownertransport = ownertransport;
		this.etpadress = etpadress;
		this.etpregadress = etpregadress;
		this.etptel = etptel;
		this.attachmentId = attachmentId;
		this.state = state;
		this.remark = remark;
		this.disporder = disporder;
		this.referStartTime = referStartTime;
		this.referEndTime = referEndTime;
		this.checkStartTime = checkStartTime;
		this.checkEndTime = checkEndTime;
		this.etpType = etpType;
		this.issueCardDate = issueCardDate;
		this.roadTransport = roadTransport;
		this.createtime = createtime;
	}

	/**
     * 主键ID
     * @return id 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 所属机构Id
     * @return org_id 所属机构Id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 所属机构Id
     * @param orgId 所属机构Id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 企业组织机构编码
     * @return etpCd 企业组织机构编码
     */
    public String getEtpcd() {
        return etpcd;
    }

    /**
     * 企业组织机构编码
     * @param etpcd 企业组织机构编码
     */
    public void setEtpcd(String etpcd) {
        this.etpcd = etpcd;
    }

    /**
     * 企业 名称
     * @return etpNm 企业 名称
     */
    public String getEtpnm() {
        return etpnm;
    }

    /**
     * 企业 名称
     * @param etpnm 企业 名称
     */
    public void setEtpnm(String etpnm) {
        this.etpnm = etpnm;
    }

    /**
     * 企业简称
     * @return etpshortNm 企业简称
     */
    public String getEtpshortnm() {
        return etpshortnm;
    }

    /**
     * 企业简称
     * @param etpshortnm 企业简称
     */
    public void setEtpshortnm(String etpshortnm) {
        this.etpshortnm = etpshortnm;
    }

    /**
     * 企业法人
     * @return etpLawer 企业法人
     */
    public String getEtplawer() {
        return etplawer;
    }

    /**
     * 企业法人
     * @param etplawer 企业法人
     */
    public void setEtplawer(String etplawer) {
        this.etplawer = etplawer;
    }

    /**
     * 法人电话
     * @return lawerTel 法人电话
     */
    public String getLawertel() {
        return lawertel;
    }

    /**
     * 法人电话
     * @param lawertel 法人电话
     */
    public void setLawertel(String lawertel) {
        this.lawertel = lawertel;
    }

    /**
     * 安全责任人
     * @return etpSafer 安全责任人
     */
    public String getEtpsafer() {
        return etpsafer;
    }

    /**
     * 安全责任人
     * @param etpsafer 安全责任人
     */
    public void setEtpsafer(String etpsafer) {
        this.etpsafer = etpsafer;
    }

    /**
     * 责任人电话
     * @return saferTel 责任人电话
     */
    public String getSafertel() {
        return safertel;
    }

    /**
     * 责任人电话
     * @param safertel 责任人电话
     */
    public void setSafertel(String safertel) {
        this.safertel = safertel;
    }

    /**
     * 外键参照表ess_employee的id
     * @return admin_empid 外键参照表ess_employee的id
     */
    public String getAdminEmpid() {
        return adminEmpid;
    }

    /**
     * 外键参照表ess_employee的id
     * @param adminEmpid 外键参照表ess_employee的id
     */
    public void setAdminEmpid(String adminEmpid) {
        this.adminEmpid = adminEmpid;
    }

    /**
     * 所属交巡警大队
     * @return ownerTraffic 所属交巡警大队
     */
    public String getOwnertraffic() {
        return ownertraffic;
    }

    /**
     * 所属交巡警大队
     * @param ownertraffic 所属交巡警大队
     */
    public void setOwnertraffic(String ownertraffic) {
        this.ownertraffic = ownertraffic;
    }

    /**
     * 所属运管所
     * @return ownerTransport 所属运管所
     */
    public String getOwnertransport() {
        return ownertransport;
    }

    /**
     * 所属运管所
     * @param ownertransport 所属运管所
     */
    public void setOwnertransport(String ownertransport) {
        this.ownertransport = ownertransport;
    }

    /**
     * 企业地址
     * @return etpAdress 企业地址
     */
    public String getEtpadress() {
        return etpadress;
    }

    /**
     * 企业地址
     * @param etpadress 企业地址
     */
    public void setEtpadress(String etpadress) {
        this.etpadress = etpadress;
    }

    /**
     * 企业注册地址
     * @return etpRegAdress 企业注册地址
     */
    public String getEtpregadress() {
        return etpregadress;
    }

    /**
     * 企业注册地址
     * @param etpregadress 企业注册地址
     */
    public void setEtpregadress(String etpregadress) {
        this.etpregadress = etpregadress;
    }

    /**
     * 企业电话
     * @return etpTel 企业电话
     */
    public String getEtptel() {
        return etptel;
    }

    /**
     * 企业电话
     * @param etptel 企业电话
     */
    public void setEtptel(String etptel) {
        this.etptel = etptel;
    }

    /**
     * 企业关联附件id，企业营业执照
     * @return attachment_id 企业关联附件id，企业营业执照
     */
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     * 企业关联附件id，企业营业执照
     * @param attachmentId 企业关联附件id，企业营业执照
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * 审核状态 -1 审核未通过 0待审核 1审核通过
     * @return state 审核状态 -1 审核未通过 0待审核 1审核通过
     */
    public Integer getState() {
        return state;
    }

    /**
     * 审核状态 -1 审核未通过 0待审核 1审核通过
     * @param state 审核状态 -1 审核未通过 0待审核 1审核通过
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 显示顺序
     * @return dispOrder 显示顺序
     */
    public Integer getDisporder() {
        return disporder;
    }

    /**
     * 显示顺序
     * @param disporder 显示顺序
     */
    public void setDisporder(Integer disporder) {
        this.disporder = disporder;
    }

	public String getReferStartTime() {
		return referStartTime;
	}

	public void setReferStartTime(String referStartTime) {
		this.referStartTime = referStartTime;
	}

	public String getReferEndTime() {
		return referEndTime;
	}

	public void setReferEndTime(String referEndTime) {
		this.referEndTime = referEndTime;
	}

	public String getCheckStartTime() {
		return checkStartTime;
	}

	public void setCheckStartTime(String checkStartTime) {
		this.checkStartTime = checkStartTime;
	}

	public String getCheckEndTime() {
		return checkEndTime;
	}

	public void setCheckEndTime(String checkEndTime) {
		this.checkEndTime = checkEndTime;
	}

	public String getEtpType() {
		return etpType;
	}

	public void setEtpType(String etpType) {
		this.etpType = etpType;
	}

	public String getIssueCardDate() {
		return issueCardDate;
	}

	public void setIssueCardDate(String issueCardDate) {
		this.issueCardDate = issueCardDate;
	}

	public String getRoadTransport() {
		return roadTransport;
	}

	public void setRoadTransport(String roadTransport) {
		this.roadTransport = roadTransport;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

 
}