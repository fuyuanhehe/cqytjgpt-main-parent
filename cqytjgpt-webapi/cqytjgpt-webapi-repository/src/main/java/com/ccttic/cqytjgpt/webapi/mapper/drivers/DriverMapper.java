package com.ccttic.cqytjgpt.webapi.mapper.drivers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;

public interface DriverMapper {

	/**
	 * 驾驶人信息分页
	 * @param driverVo 筛选的参数
	 * @return
	 */		
	public List<DriverVo> seDriverPage(Map<String, Object> params);
	//分页数量
	public long sePageCount(Map<String, Object> params);

	///查询驾驶人违法记录
	public	DriverillicitVo seDrillicitByDriverId(@Param("driverid")String driverid);


	//驾驶人违法分页
	public List<DriverillicitVo> seDr_illicitPages(Map<String, Object> params);
	//分页总数
	public long getDriverPageCount(Map<String, Object> params);



	public List<Driver> selectAllDriver();

}