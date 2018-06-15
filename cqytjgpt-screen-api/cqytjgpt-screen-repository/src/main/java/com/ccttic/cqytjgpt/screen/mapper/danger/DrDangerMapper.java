package com.ccttic.cqytjgpt.screen.mapper.danger;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.danger.DrDanger;

public interface DrDangerMapper {
    int deleteByPrimaryKey(String id);

    int insert(DrDanger record);

    DrDanger selectByPrimaryKey(String id);

    List<DrDanger> selectAll();

    int updateByPrimaryKey(DrDanger record);

	int countIntoNum();

	int countDriverDangerNum();

	List countWarnNum();

	List<Map<String, Object>> distributionDangerForDriver(Map<String, Object> dateMap);

	int countNoHandleDriver();

	Map<String, Object> resultDangerForDriver();

	List<Map<String, Object>> areaDangerInfo();

	DrDanger noticeDangerDriver(Map map);

	List<Map<String, Object>> areaDangersTop();

	List<Map<String, Object>> findMonthAreaDangerByOrgId(Map<String, Object> map);
	List<Map<String, Object>> findPreMonthAreaDangerByOrgId(Map<String, Object> map);
}