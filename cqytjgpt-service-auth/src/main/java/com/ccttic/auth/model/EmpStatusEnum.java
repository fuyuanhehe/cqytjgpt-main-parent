package com.ccttic.auth.model;

/**
   功能说明：     人员状态(在职，离职)
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.ess.EmpStatusEnum.java
 @date  2016年12月3日
 */

public enum EmpStatusEnum {
	//在职
	ONJOB,
	//离职
	QUITJOB,
	//停薪留职
	SUSSALARY;
	public static String getLabel(String empStatus) {
		String label = "在职";
		if (ONJOB.name().equalsIgnoreCase(empStatus)) {
			label = "在职";
		} else if (QUITJOB.name().equalsIgnoreCase(empStatus)) {
			label = "离职";
		} else if (SUSSALARY.name().equalsIgnoreCase(empStatus)) {
			label = "停薪留职";
		}
		return label;
	}
}
