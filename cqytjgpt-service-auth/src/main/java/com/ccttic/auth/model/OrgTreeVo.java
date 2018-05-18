package com.ccttic.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
   功能说明：     机构树VO
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.OrgTreeVo.java
 @date  2016年12月13日
 */

public class OrgTreeVo implements Serializable {
	private static final long serialVersionUID = 6899062775634227044L;
	private String id;
	/**
	 * 机构类型
	 */
	private String orgType;
	private String orgTypeNm;
	/**
	 * 上级机构
	 */
	private String superOrgCd;
	private String superOrdNm;
	/**
	 * 上级机构类型
	 */
	private String superOrgCdOrgType;

	/**
	 * 机构code
	 */
	private String orgCd;
	/**
	 * 机构名称
	 */
	private String orgNm;
	/**
	 * 部门职能（只在部门上设置）
	 */
	private String orgDuty;
	/**
	 * 公司简称
	 */
	private String shortNm;
	/**
	 * 所在区域（只在公司上设置）
	 */
	private String region;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 董事长
	 */
	private String chairman;
	private String chairmanNm;
	/**
	 * 总经理
	 */
	private String generalManger;
	private String generalMangerNm;
	/**
	 * 部门经理
	 */
	private String deptManager;
	private String deptManagerNm;
	/**
	 * 部门副经理
	 */
	private List<String> deputyManagerIds = new ArrayList<String>();
	private List<String> deputyManagerNms = new ArrayList<String>();

	/**
	 * 分管领导
	 */
	private String tempLeadership;
	private String tempLeadershipNm;

	/**
	 * 树型显示节点名称
	 */
	private String text;
	/**
	 * 树型节点属性
	 */
	private Map<String, String> attributes = new HashMap<String, String>();
	/**
	 * 树弄节点状态打开还是关闭
	 */
	private String state;

	/**
	 * 显示顺序
	 */
	private Integer dispOrder;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Integer getDispOrder() {
		return dispOrder;
	}

	public void setDispOrder(Integer dispOrder) {
		this.dispOrder = dispOrder;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgTypeNm() {
		return orgTypeNm;
	}

	public void setOrgTypeNm(String orgTypeNm) {
		this.orgTypeNm = orgTypeNm;
	}

	public String getSuperOrgCd() {
		return superOrgCd;
	}

	public void setSuperOrgCd(String superOrgCd) {
		this.superOrgCd = superOrgCd;
	}

	public String getSuperOrdNm() {
		return superOrdNm;
	}

	public void setSuperOrdNm(String superOrdNm) {
		this.superOrdNm = superOrdNm;
	}

	public String getSuperOrgCdOrgType() {
		return superOrgCdOrgType;
	}

	public void setSuperOrgCdOrgType(String superOrgCdOrgType) {
		this.superOrgCdOrgType = superOrgCdOrgType;
	}

	public String getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public String getOrgDuty() {
		return orgDuty;
	}

	public void setOrgDuty(String orgDuty) {
		this.orgDuty = orgDuty;
	}

	public String getShortNm() {
		return shortNm;
	}

	public void setShortNm(String shortNm) {
		this.shortNm = shortNm;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	public String getChairmanNm() {
		return chairmanNm;
	}

	public void setChairmanNm(String chairmanNm) {
		this.chairmanNm = chairmanNm;
	}

	public String getGeneralManger() {
		return generalManger;
	}

	public void setGeneralManger(String generalManger) {
		this.generalManger = generalManger;
	}

	public String getGeneralMangerNm() {
		return generalMangerNm;
	}

	public void setGeneralMangerNm(String generalMangerNm) {
		this.generalMangerNm = generalMangerNm;
	}

	public String getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(String deptManager) {
		this.deptManager = deptManager;
	}

	public String getDeptManagerNm() {
		return deptManagerNm;
	}

	public void setDeptManagerNm(String deptManagerNm) {
		this.deptManagerNm = deptManagerNm;
	}

	public List<String> getDeputyManagerIds() {
		return deputyManagerIds;
	}

	public void setDeputyManagerIds(List<String> deputyManagerIds) {
		this.deputyManagerIds = deputyManagerIds;
	}

	public List<String> getDeputyManagerNms() {
		return deputyManagerNms;
	}

	public void setDeputyManagerNms(List<String> deputyManagerNms) {
		this.deputyManagerNms = deputyManagerNms;
	}

	/**
	 * @return the tempLeadership
	 */
	public String getTempLeadership() {
		return tempLeadership;
	}

	/**
	 * @param tempLeadership the tempLeadership to set
	 */
	public void setTempLeadership(String tempLeadership) {
		this.tempLeadership = tempLeadership;
	}

	/**
	 * @return the tempLeadershipNm
	 */
	public String getTempLeadershipNm() {
		return tempLeadershipNm;
	}

	/**
	 * @param tempLeadershipNm the tempLeadershipNm to set
	 */
	public void setTempLeadershipNm(String tempLeadershipNm) {
		this.tempLeadershipNm = tempLeadershipNm;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
