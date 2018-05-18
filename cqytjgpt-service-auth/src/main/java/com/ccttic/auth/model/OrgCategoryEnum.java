package com.ccttic.auth.model;

/**
   功能说明：     组织机构分类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.OrgCategoryEnum.java
 @date  2016年12月6日
 */

public enum OrgCategoryEnum {
	//总公司
	HEAD,
	//分公司
	BRANCH,
	//子公司
	SUB,
	//部门
	DEPARTMENT;
	public static String getLabel(String orgType) {
		String label = "部门";
		if (orgType.equalsIgnoreCase(HEAD.name())) {
			label = "总公司";
		} else if (orgType.equalsIgnoreCase(BRANCH.name())) {
			label = "分公司";
		} else if (orgType.equalsIgnoreCase(SUB.name())) {
			label = "子公司";
		} else if (orgType.equalsIgnoreCase(DEPARTMENT.name())) {
			label = "部门";
		}
		return label;
	}
}
