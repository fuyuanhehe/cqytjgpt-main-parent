package com.ccttic.cqytjgpt.webapi.mapper.danger;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.util.exception.AppException;

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
	
	/**
	 * 根据条件查询车辆预警信息
	 * @param page
	 * @param ve
	 * @return
	 * @throws AppException
	 */
	public List<VehiDangerVo> qryVehicleList(Map<String, Object> params) throws AppException;
	/**
	 * 根据id查询车辆预警详情信息
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public VehiDangerVo qryOneVehicle(VehiDanger ve) throws AppException;
	
	/**
	 * 
	 * 根据条件获取车辆预警总记录数
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryVehicleListCount(Map<String, Object> params) throws AppException;

	
}