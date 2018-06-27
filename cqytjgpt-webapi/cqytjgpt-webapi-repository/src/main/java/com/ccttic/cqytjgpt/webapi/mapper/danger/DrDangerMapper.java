package com.ccttic.cqytjgpt.webapi.mapper.danger;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.DrDangerVo;

public interface DrDangerMapper {
	
	int updateByPrimaryKeySelective(DrDanger record);
	
	int insertSelective(DrDanger record);
	
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
	
	/**批量添加驾驶人预警
	 * @param list
	 */
	
	public void insertBatch(List<DrDanger> list);
	/**批量修改驾驶人预警
	 * @param list
	 */
	public void updateBatch(List<DrDanger> list);

	/**根据条件查询预警
	 * @param params
	 * @return
	 */
	List<DrDangerVo> qryDriverList(Map<String, Object> params);

	/**根据条件获取总条数
	 * @param params
	 * @return
	 */
	long qryDriverListCount(Map<String, Object> params);

}