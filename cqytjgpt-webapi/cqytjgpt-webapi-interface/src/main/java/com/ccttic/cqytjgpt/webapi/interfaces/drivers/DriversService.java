package com.ccttic.cqytjgpt.webapi.interfaces.drivers;



import java.util.List;

import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverIllegal;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.entity.drivers.vo.EnterprisethenVo;
import com.ccttic.entity.drivers.vo.vehiclesVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface DriversService {

	/**
	 * 分页驾驶人信息
	 * @param driverVo 筛选条件
	 * @return
	 */

	Page<DriverVo> seDriverPage(Pageable page,DriverVo driverVo);

	///查询驾驶人违法记录
	Page<DriverillicitVo> seDrillicitByDriverId(Pageable page,Driver driver);

	
	///查询驾驶人违法记录分页
	Page<DriverillicitVo> getDriverPages(Pageable page,DriverillicitVo driverillicitVo);


	// 增加驾驶员
	public void insertSelective(List<Driver> driver);
	
	public List<DriverIllegal> getAllDriver();
	
	// 企业信息分页
	Page<EnterprisethenVo> queryEnterprisePage(Pageable page,EnterprisethenVo enterprisethenVo);
	
	Page<EssEmployee> queryEmpPage(Pageable page);
	//<!--企业信息记录分页 -->
	Page<vehiclesVo> queryVehiclespage(Pageable page,vehiclesVo vehiclesVo);
}
