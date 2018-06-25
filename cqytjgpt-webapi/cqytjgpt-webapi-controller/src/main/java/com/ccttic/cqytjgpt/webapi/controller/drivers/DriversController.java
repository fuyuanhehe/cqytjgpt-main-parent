package com.ccttic.cqytjgpt.webapi.controller.drivers;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ccttic.cqytjgpt.webapi.interfaces.drivers.DriversService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.dr_illicit;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverVoPage;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.entity.drivers.vo.DriverillicitVoPage;
import com.ccttic.entity.drivers.vo.EnterprisethenVo;
import com.ccttic.entity.drivers.vo.EnterprisethenVoPage;
import com.ccttic.entity.drivers.vo.vehiclesVo;
import com.ccttic.entity.drivers.vo.vehiclesVoPage;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;
/*
 *功能说明 : 驾驶员，违法记录
 */

@RestController
@RequestMapping(value="/drvers")
public class DriversController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private DriversService service;

	/**
	 * 功能说明：  修改角色和关联的员工
	 * @param etpNm 所属企业
	 * @param areaNm 所属区域
	 * @param name 驾驶人名称
	 * @param idcard 身份证号码
	 * @param permiCar 准驾车型
	 * @param id 驾驶人主键ID
	 * @param mobilephone 手机号码*
	 * @param fiString,laString 初次领证时间,最后领证时间
	 * @param fistShString,laShString 初次审核时期,最后审核时期
	 * @return
	 * @date  2018年6月15日
	 */
	@OperLogging(operType = 3,content="驾驶员信息分页")
	@RequestMapping(value="/getDriversPages",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<DriverVo>> seDriverPages(@RequestBody(required = false) DriverVoPage tment){
		ResponseMsg<List<DriverVo>> resp = new ResponseMsg<List<DriverVo>>();
		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			Page<DriverVo> data = service.seDriverPage(page, tment);
			resp.setMessage("查询驾驶员信息分页成功！");
			resp.setStatus(0);
			resp.setData(data.getRecords());
			resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("查询驾驶员信息分页失败！");
			resp.setStatus(0);
			logger.error("查询驾驶员信息分页失败！",e);
		}

		return resp;
	}
	/**
	 * @param driverId 驾驶人主键ID
	 * @date  2018年6月15日
	 */
	@OperLogging(operType = 3,content="驾驶员违法信息")
	@RequestMapping(value="/getDrillicitByDriverId",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<DriverillicitVo> seDrillicitByDriverId(@RequestBody(required = false) dr_illicit driverid){
		ResponseMsg<DriverillicitVo> resp = new ResponseMsg<DriverillicitVo>();
		try {
			DriverillicitVo data = service.seDrillicitByDriverId(driverid.getDriverId());
			resp.setMessage("查询驾驶员违法信息成功！");
			resp.setStatus(0);
			resp.setData(data);

		} catch (Exception e) {
			resp.setMessage("查询驾驶员违法信息成功！");
			resp.setStatus(0);
			logger.error("查询驾驶员违法信息失败",e);
		}

		return resp;
	}
	/**
	 * 功能说明：  驾驶人违法记录分页
	 * @param driverid 驾驶员ID
	 * @param name 驾驶员名字
	 * @param etpNm 所属区域
	 * @param areaNm 所属企业
	 * @param illicitadress 违法地址
	 * @param illicit 违法行为
	 * @param fiString,laString 初次违法时间,最后违法时间
	 * @return
	 * @date  2018年6月15日
	 */
	@OperLogging(operType = 3,content="驾驶员违法信息分页")
	@RequestMapping(value="/getIllicitPages",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<DriverillicitVo>> getDriveresPages(@RequestBody(required = false) DriverillicitVoPage tment){
		ResponseMsg<List<DriverillicitVo>> resp = new ResponseMsg<List<DriverillicitVo>>();

		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			Page<DriverillicitVo> data = service.getDriverPages(page, tment);
			resp.setMessage("查询驾驶员违法信息成功！");
			resp.setStatus(0);
			resp.setData(data.getRecords());  
			resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("查询驾驶员违法信息失败！");
			resp.setStatus(-1);
			logger.error("查询驾驶员违法信息失败！",e);
		}

		return resp;
	}
	/**
	 * 功能说明：  修改角色和关联的员工
	 * @param idcard 驾驶员身份证
	 * @return
	 * @date  2018年6月15日
	 */
	@OperLogging(operType = 0,content="增加驾驶人")
	@RequestMapping(value="/insertDriver",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<String> insertDriver(@RequestBody List<Driver> driver){
		ResponseMsg<String> resp = new ResponseMsg<>();

		try {
			service.insertSelective(driver);
			resp.setMessage("新增驾驶员成功");
			resp.setStatus(0);
		} catch (Exception e) {
			resp.setMessage("新增驾驶员失败");
			resp.setStatus(-1);
			logger.error("新增驾驶员失败"+driver,e);

		}
		return resp;
	}
	/**
	 * 功能说明：  企业基本信息分页，详情
	 * @param id 企业id
	 * @param etpNm 企业名字
	 * @param ownerTraffic 交警大队
	 * @param ownerTransport 运管所
	 * @return 
	 * @date  2018年6月20日
	 */
	@OperLogging(operType = 0,content="企业基本信息分页")
	@RequestMapping(value="/queryEnterprisePage",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<EnterprisethenVo>> queryEnterprisePage(@RequestBody(required = false) EnterprisethenVoPage tment){
		ResponseMsg<List<EnterprisethenVo>> resp = new ResponseMsg<>();

		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			Page<EnterprisethenVo> data = service.queryEnterprisePage(page, tment);
			resp.setMessage("查询驾驶员违法信息成功！");
			resp.setStatus(0);
			resp.setData(data.getRecords());  
			resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("查询驾驶员违法信息失败！");
			resp.setStatus(0);
			logger.error("查询驾驶员违法信息失败！",e);
		}

		return resp;
	}

	//测试查询
	@OperLogging(operType = 0)
	@RequestMapping(value="/queryEmpPage",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<EssEmployee>> queryEmpPage(PageRequest page){
		ResponseMsg<List<EssEmployee>> resp = new ResponseMsg<List<EssEmployee>>();

		try {
			Page<EssEmployee> data = service.queryEmpPage(page);
			resp.setData(data.getRecords());
			resp.setTotal(data.getTotalRows().intValue());
			resp.setStatus(0);
			resp.setMessage("员工查询成功");
		} catch (Exception e) {
			resp.setStatus(-1);
			resp.setMessage("员工查询失败");
			logger.error("员工查询失败",e);
		}

		return resp;
	}
	/**
	 * 功能说明：  企业基本信息分页
	 * @param orgNm 区域
	 * @param etpNm 企业名字
	 * @param vehiNoType 车辆种类
	 * @return 
	 * @date  2018年6月25日
	 */
	@OperLogging(operType = 0)
	@RequestMapping(value="/queryVehiclespage",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseMsg<List<vehiclesVo>>queryVehiclespage(@RequestBody vehiclesVoPage tment){
		ResponseMsg<List<vehiclesVo>> resp = new ResponseMsg<List<vehiclesVo>>();

		try {
			PageRequest page = new PageRequest();
			page.setPage(tment.getPage());
			page.setRows(tment.getRows());
			Page<vehiclesVo> data = service.queryVehiclespage(page, tment);
			resp.setData(data.getRecords());
			resp.setMessage("查询企业机动车违法信息成功");
			resp.setStatus(0);
            resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("查询企业机动车违法信息失败");
			resp.setStatus(-1);
			logger.error("查询企业机动车违法信息失败",e);
		}

		return resp;
	}

}
