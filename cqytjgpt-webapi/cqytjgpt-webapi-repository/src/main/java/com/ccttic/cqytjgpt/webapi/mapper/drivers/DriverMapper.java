package com.ccttic.cqytjgpt.webapi.mapper.drivers;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverIllegal;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.entity.drivers.vo.EnterprisethenVo;
import com.ccttic.entity.drivers.vo.PermiCarsVo;
import com.ccttic.entity.drivers.vo.vehiclesVo;
import com.ccttic.entity.employee.EssEmployee;

public interface DriverMapper {

	public List<DriverVo> seDriverPage(Map<String, Object> params);
	//分页数量
	public long sePageCount(Map<String, Object> params);

	///查询驾驶人违法记录
	public	List<DriverillicitVo> seDrillicitByDriverId(Map<String, Object> params);

   public long seDrillicitByDriverIdCount(Map<String, Object> params);
	
	//准假车型
	public List<PermiCarsVo> getAllpermiCar ();
   
	//驾驶人违法分页
	public List<DriverillicitVo> seDr_illicitPages(Map<String, Object> params);
	
	//分页总数
	public long getDriverPageCount(Map<String, Object> params);

	// 增加
	public int insertSelective(List<Driver> driver);
	
	public List<DriverIllegal> selectAllDriver();
	
	// 企业基本信息
	public List<EnterprisethenVo> queryEnterprisePage(Map<String, Object> params);
	//分页总数
	public long queryEnterprisePageCount(Map<String, Object> params);
	
	
	//<!--企业信息记录分页 -->
	public List<vehiclesVo> queryVehiclespage(Map<String, Object> params);
	
	public long queryVehiclespageCount(Map<String, Object> params);
	
	
	public List<EssEmployee> seEmp(Map<String, Object> params);
	public long seEmpCount(Map<String, Object> params);
	
	
	// 企业信息-信息记录
	public List<vehiclesVo>getvehiclesCount(vehiclesVo vehiclesVo);
	
	/**批量更新驾驶人信息
	 * @param update
	 */
	public void updateBatch(List<Driver> update);
	
	/**
	 * 批量删除驾驶人信息
	 * @param delete
	 */
	public void deleteBatch(List<String> delete);
	
	
}