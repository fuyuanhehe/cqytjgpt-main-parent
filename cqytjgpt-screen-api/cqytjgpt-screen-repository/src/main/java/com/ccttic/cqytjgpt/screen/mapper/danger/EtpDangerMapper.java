package com.ccttic.cqytjgpt.screen.mapper.danger;

import com.ccttic.entity.danger.DrDanger;

import java.util.List;
import java.util.Map;

public interface EtpDangerMapper {


	int countIntoNum();

	int countEnterpriseDangerNum();

	List countWarnNum();

	List<Map<String, Object>> distributionDangerForEnterprise(Map<String, Object> dateMap);

	int countNoHandleEnterprise();

	Map<String, Object> resultDangerForEnterprise();

    Map<String,Object> noticeDangerEnterprise(Map map);

	List<Map<String, Object>> findMonthAreaDangerByOrgId(Map<String, Object> map);
	List<Map<String, Object>> findPreMonthAreaDangerByOrgId(Map<String, Object> map);

	Map<String, Object> allEnterprise();

	List<Map<String,Object>> ratioDangerForEnterprise();
}