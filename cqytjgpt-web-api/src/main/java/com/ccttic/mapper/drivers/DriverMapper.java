package com.ccttic.mapper.drivers;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.dr_illicit;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;

import feign.Param;

public interface DriverMapper {
	public int deleteByPrimaryKey(String id);

	public int insert(Driver record);

	public int insertSelective(Driver record);

	public Driver selectByPrimaryKey(String id);

	public int updateByPrimaryKeySelective(Driver record);

	public int updateByPrimaryKey(Driver record);

	/**
	 * 驾驶人信息分页
	 * @param driverVo 筛选的参数
	 * @return
	 */		
	public List<DriverVo> seDriverPage(DriverVo driverVo);
	//分页数量
	public long sePageCount(DriverVo driverVo);

	///查询驾驶人违法记录
	public	DriverillicitVo seDrillicitByDriverId(@Param("driverid")String driverid);

	public List<DriverillicitVo> seDr_illicitPages(Map<String, Object> params);

	public List<Driver> selectAllDriver();

}