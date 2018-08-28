package com.ccttic.cqytjgpt.webapi.mapper.vehicle;

import com.ccttic.entity.illegal.VehiIllicitExample;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.util.exception.AppException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VehiIllicitMapper {
	long countByExample(VehiIllicitExample example);

	int deleteByExample(VehiIllicitExample example);

	int deleteByPrimaryKey(String id);

	int insert(VehiIllicit record);

	int insertSelective(VehiIllicit record);

	List<com.ccttic.entity.illegal.VehiIllicit> selectByExample(VehiIllicitExample example);

	com.ccttic.entity.illegal.VehiIllicit selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") VehiIllicit record, @Param("example") VehiIllicitExample example);

	int updateByExample(@Param("record") VehiIllicit record, @Param("example") VehiIllicitExample example);

	int updateByPrimaryKeySelective(com.ccttic.entity.illegal.VehiIllicit record);

	int updateByPrimaryKey(VehiIllicit record);

	/**
	 * 根据条件获取车辆违法信息
	 *
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public List<VehiIllicit> qryVehiIllicitList(Map<String, Object> params) throws AppException;

	/**
	 * 根据条件获取车辆违法信息总记录数
	 *
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryVehiIllicitListCount(Map<String, Object> params) throws AppException;

	/**
	 * 获取指定车辆违法信息
	 *
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public VehiIllicit qryOneVehiIllicit(Map<String, Object> params) throws AppException;

	/**
	 * 批量添加车辆违法记录
	 *
	 * @param list
	 */
	public void insertBatch(List<com.ccttic.entity.illegal.VehiIllicit> list);

	/**
	 * 批量修改车辆违法记录
	 *
	 * @param list
	 */
	public void updateBatch(List<com.ccttic.entity.illegal.VehiIllicit> list);

	/**
	 * @Author:zhy
	 * @Description: 获取违法未交款的天数
	 * @Date:14:40 2018/7/26
	 */
	public  List<Integer> getIllegalDays(@Param("vehiDrIllicit") String vehiDrIllicit,@Param("vehiNo") String vehiNo,@Param("vehiNoType") String vehiNoType);

	/**
	 * @Author:zhy
	 * @Description:获得违法条数
	 * @Date:14:41 2018/7/26
	 */
	public  int getIllegalNum(@Param("vehiDrIllicit") String vehiDrIllicit,@Param("vehiNo") String vehiNo,@Param("vehiNoType") String vehiNoType);
}
