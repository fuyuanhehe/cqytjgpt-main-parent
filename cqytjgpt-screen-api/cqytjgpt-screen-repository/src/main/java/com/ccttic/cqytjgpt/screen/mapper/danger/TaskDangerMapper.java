package com.ccttic.cqytjgpt.screen.mapper.danger;

import java.util.List;
import java.util.Map;

public interface TaskDangerMapper {
	List<Map<String,Object>> allEtp();

	int findDangerCarByEtpId(String etpId);

	int findFirstDangerCarByEtpId(String etpId);

	Map findOrgByOrgId(String orgId);

	Map findAreaByAreaId(String areaId);

	Map<String,Object> findDangerGroupByMonthByEtpId(String etpId);

	void deleteAll(Map param);

	void insertEtpTotal(Map param);
}