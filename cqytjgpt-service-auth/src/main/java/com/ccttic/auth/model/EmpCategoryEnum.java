package com.ccttic.auth.model;

/**
   功能说明：     人员结构分类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.EmpCategoryEnum.java
 @date  2016年12月3日
 */

public enum EmpCategoryEnum {
	//董事长
	CHAIRMAN,
	//总经理
	GENERALMANAGER,
	//分管领导
	LEADERSHIP,
	//普通员工
	GENERALEMPLOYEE,
	//管理员
	ADMIN;
	public static String getLabel(String empCategory) {
		String label = "董事长";
		if (CHAIRMAN.name().equalsIgnoreCase(empCategory)) {
			label = "董事长";
		} else if (GENERALMANAGER.name().equalsIgnoreCase(empCategory)) {
			label = "总经理";
		} else if (LEADERSHIP.name().equalsIgnoreCase(empCategory)) {
			label = "分管领导";
		} else if (GENERALEMPLOYEE.name().equalsIgnoreCase(empCategory)) {
			label = "普通员工";
		} else if (ADMIN.name().equalsIgnoreCase(empCategory)) {
			label = "管理员";
		}
		return label;
	}
}
