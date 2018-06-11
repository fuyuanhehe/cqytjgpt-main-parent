package com.ccttic.service.drivers;

import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface DriversService {

	/**
	 * 分页驾驶人信息
	 * @return
	 */

	Page<DriverVo> seDriverPage(Pageable page,DriverVo driverVo);
	
	
}