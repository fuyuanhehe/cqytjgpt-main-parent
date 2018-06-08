package com.ccttic.mapper.drivers;

import java.util.List;

import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverVo;

public interface DriverMapper {
	int deleteByPrimaryKey(String id);

	int insert(Driver record);

	int insertSelective(Driver record);

	Driver selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Driver record);

	int updateByPrimaryKey(Driver record);

	/**
	 * 驾驶人信息分页
	 * @param driverVo 筛选的参数
	 * @return
	 */		
	List<DriverVo> seDriverPage(DriverVo driverVo);
	//分页数量
	long sePageCount(DriverVo driverVo);
	
	
}