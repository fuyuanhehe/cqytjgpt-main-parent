package com.ccttic.cqytjgpt.webapi.interfaces.drivers;



import java.util.List;

import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverInsert;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.entity.drivers.vo.EnterprisethenVo;
import com.ccttic.entity.drivers.vo.PermiCarsVo;
import com.ccttic.entity.drivers.vo.VehicleCountVo;
import com.ccttic.entity.drivers.vo.vehiclesVo;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

public interface DriversService {

	/**
	 * 分页驾驶人信息
	 * @param driverVo 筛选条件
	 * @param employeePermission 
	 * @param employeePermission 
	 * @return
	 */

	Page<DriverVo> seDriverPage(Pageable page,DriverVo driverVo, EmployeePermission employeePermission );

	///查询驾驶人违法记录
	Page<DriverillicitVo> seDrillicitByDriverId(Pageable page,DriverVo driver);
       //准假车型
	List<PermiCarsVo> getAllpermiCar();
	
	///查询驾驶人违法记录分页
	Page<DriverillicitVo> getDriverPages(Pageable page, DriverillicitVo driverillicitVo, EmployeePermission employeePermission);


	// 增加驾驶员
	public boolean insertSelective(DriverInsert driver);
	
	public List<Driver> getAllDriverMsg();
	
	// 企业信息分页
	Page<EnterprisethenVo> queryEnterprisePage(Pageable page,EnterprisethenVo enterprisethenVo, EmployeePermission employeePermission);
	
	Page<EssEmployee> queryEmpPage(Pageable page);
	//<!--企业信息记录分页 -->
	Page<vehiclesVo> queryVehiclespage(Pageable page,vehiclesVo vehiclesVo);
	
	
	//企业信息-信息记录 01
	public List<VehicleCountVo> getVehiclesCount(VehicleCountVo countVo );
	//企业信息-信息记录 02
	public List<VehicleCountVo> getVehiclesVehi(VehicleCountVo countVo );
}



