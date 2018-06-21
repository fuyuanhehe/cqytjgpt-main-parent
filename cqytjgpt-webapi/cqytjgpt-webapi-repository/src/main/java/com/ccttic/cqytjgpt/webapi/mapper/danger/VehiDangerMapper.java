package com.ccttic.cqytjgpt.webapi.mapper.danger;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.role.VehiIllicit;

public interface VehiDangerMapper {
	
	int insertSelective(VehiDanger record);
	
	int updateByPrimaryKeySelective(VehiDanger record);
	
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
	
	/**批量添加车辆预警
	 * @param list
	 */
	public void insertBatch(List<VehiDanger> list);
	/**批量修改车辆预警
	 * @param list
	 */
	public void updateBatch(List<VehiDanger> list);
}