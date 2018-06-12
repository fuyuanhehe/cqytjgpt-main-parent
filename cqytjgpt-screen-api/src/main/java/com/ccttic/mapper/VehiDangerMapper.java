package com.ccttic.mapper;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.VehiDanger;

public interface VehiDangerMapper {
    int deleteByPrimaryKey(String id);

    int insert(VehiDanger record);

    VehiDanger selectByPrimaryKey(String id);

    List<VehiDanger> selectAll();

    int updateByPrimaryKey(VehiDanger record);
    
    int countIntoNum();

	int countCarDangerNum();

	List countWarnNum();

	List<Map<String, Object>> distributionDangerForCar(Map<String, Object> dateMap);

	int countNoHandleCar();

	Map<String, Object> resultDangerForCar();

	VehiDanger noticeDangerCar(Map map);


	List<Map<String, Object>> findMonthAreaDangerByOrgId(Map<String, Object> map);

	List<Map<String, Object>> findPreMonthAreaDangerByOrgId(Map<String, Object> map);
}