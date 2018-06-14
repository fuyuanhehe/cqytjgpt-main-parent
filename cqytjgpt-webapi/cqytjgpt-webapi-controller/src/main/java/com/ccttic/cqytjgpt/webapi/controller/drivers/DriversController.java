package com.ccttic.cqytjgpt.webapi.controller.drivers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.drivers.DriversService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping(value="drvers")
public class DriversController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private DriversService service;

	@OperLogging(operType = 3,content="驾驶员信息分页")
	@GetMapping
	public ResponseMsg<List<DriverVo>> seDriverPages(PageRequest page,DriverVo driverVo){
		ResponseMsg<List<DriverVo>> resp = new ResponseMsg<List<DriverVo>>();
		try {
			Page<DriverVo> data = service.seDriverPage(page, driverVo);
			resp.setMessage("查询驾驶员信息分页成功！");
			resp.setStatus(0);
			resp.setData(data.getRecords());
			resp.setTotal(data.getTotalRows().intValue());
		} catch (Exception e) {
			resp.setMessage("查询驾驶员信息分页失败！");
			resp.setStatus(0);
			logger.error("查询驾驶员信息分页失败！"+driverVo,e);
		}

		return resp;
	}

	@OperLogging(operType = 3,content="驾驶员违法信息")
	@GetMapping(value="seDrillicitByDriverId")
	public ResponseMsg<DriverillicitVo> seDrillicitByDriverId(String driverid){
		ResponseMsg<DriverillicitVo> resp = new ResponseMsg<DriverillicitVo>();
		try {
			DriverillicitVo data = service.seDrillicitByDriverId(driverid);
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







}
