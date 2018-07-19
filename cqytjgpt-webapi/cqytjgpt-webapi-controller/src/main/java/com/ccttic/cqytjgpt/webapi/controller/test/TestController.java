package com.ccttic.cqytjgpt.webapi.controller.test;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.ITestIllicitService;
import com.ccttic.entity.illegal.NetTrffSurveil;
import com.ccttic.entity.illegal.NetTrffViolation;
import com.ccttic.entity.illegal.VehiDrIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.util.common.RandomHelper;

@Controller
@RequestMapping("/test")
public class TestController implements Serializable {
	private static final long serialVersionUID = 3413554869422250064L;

	@Autowired
	private ITestIllicitService testIllicitService;

	@RequestMapping(value = "/testSurveil", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void testSurveil() {
		List<Vehicle> vehicle = testIllicitService.qryVehicleList();
		for (Vehicle ve : vehicle) {
			List<NetTrffSurveil> surveilList = testIllicitService.qryNetTrffSurveilList("渝"+ve.getVehiNo());
			if (surveilList.size()>0) {
				for (NetTrffSurveil net : surveilList) {
					String uuid = RandomHelper.uuid();
					VehiDrIllicit veDr = new VehiDrIllicit();
					veDr.setId(uuid);
					// 违法记分IllicitScore
					if (null != net.getJDSBH()) {
						veDr.setDecisionNumber(net.getJDSBH());
					}
					if (null != net.getWFSJ()) {
						veDr.setIllicitTime(net.getWFSJ());
					}
					if (null != net.getFKJE()) {
						veDr.setIllicitAmount(net.getFKJE());
					}
					if (null != net.getWFDZ()) {
						veDr.setIllicitAdress(net.getWFDZ());
					}
					if (null != net.getWFXW()) {
						veDr.setIllicit(net.getWFXW());
					}
//					veDr.setIllicitDesc("");// TODO 违法行为描述
					if (null != net.getCJJG()) {
						veDr.setPickDepartment(net.getCJJG());
					}
					if (null != net.getCJJGMC()) {
						veDr.setPickDepartmentDesc(net.getCJJGMC());
					}
					veDr.setIllicitTime(net.getWFSJ());
					
					// 是否是机动车违法
					if (net.getCLBJ().equals("0")) { 
						veDr.setVehiIllicitState("1");
						veDr.setDrIllicitState("0");
						veDr.setVehiState("001");
					} else if (net.getCLBJ().equals("1") && net.getJKBJ().equals("0")){
						veDr.setVehiIllicitState("1");
						veDr.setDrIllicitState("1");
						veDr.setVehiState("002");
					} else if (net.getCLBJ().equals("1") && (net.getJKBJ().equals("1")||net.getJKBJ().equals("9"))) {
						veDr.setVehiIllicitState("0");
						veDr.setDrIllicitState("1");
						veDr.setVehiState("003");
					}
					// 是否是驾驶人违法
//					if (net.getCLBJ().equals("1")&&(net.getJKBJ().equals("1")||net.getJKBJ().equals("9"))) {
//						veDr.setDrIllicitState("1");
//					} else {
//						veDr.setDrIllicitState("0");
//					}
					veDr.setVehiNo(ve.getVehiNo());
					if (null != ve.getVehiType()) {
						veDr.setVehiNoType(ve.getVehiType());
					}
					if (null != ve.getNature()) {
						veDr.setNature(ve.getNature());
					}
					if (null != ve.getOwnership()) {
						veDr.setOwnership(ve.getOwnership());
					}
					if (null != ve.getOwner()) {
						veDr.setOwner(ve.getOwner());
					}
					if (null != ve.getAdress()) {
						veDr.setAdress(ve.getAdress());
					}
					if (null != ve.getMgrDepartAreaId()) {
						veDr.setMgrDepartAreaId(ve.getMgrDepartAreaId());
					}
					veDr.setVehicleId(ve.getId());
					// 根据年份入库
					String WFSJdate = net.getWFSJ().substring(0, 4);
					String table = "vehi_dr_illicit";
					if (WFSJdate.equals("2009")) {
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2010")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2011")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2012")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2013")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2014")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2015")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2016")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2017")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					} else if (WFSJdate.equals("2018")){
						veDr.setTableName(table+WFSJdate);
						testIllicitService.addIllicit(veDr);
					}
				}
			}
		}
		for (Vehicle ve2 : vehicle) {
			List<NetTrffViolation> tion = testIllicitService.qryNetTrffViolationList("渝"+ve2.getVehiNo());
			if (tion.size()>0) {
				for (NetTrffViolation net : tion) {
					VehiDrIllicit veDr = new VehiDrIllicit();
					String uuid = RandomHelper.uuid();
					veDr.setVehiNo(ve2.getVehiNo());
					if (null != ve2.getVehiType()) {
						veDr.setVehiNoType(ve2.getVehiType());
					}
					if (null != ve2.getNature()) {
						veDr.setNature(ve2.getNature());
					}
					if (null != ve2.getOwnership()) {
						veDr.setOwnership(ve2.getOwnership());
					}
					if (null != ve2.getOwner()) {
						veDr.setOwner(ve2.getOwner());
					}
					if (null != ve2.getAdress()) {
						veDr.setAdress(ve2.getAdress());
					}
					if (null != ve2.getMgrDepartAreaId()) {
						veDr.setMgrDepartAreaId(ve2.getMgrDepartAreaId());
					}
					veDr.setVehicleId(ve2.getId());
					
					if (null != net.getJDSBH()) {
						veDr.setDecisionNumber(net.getJDSBH());
					}
					if (null != net.getWFSJ()) {
						veDr.setIllicitTime(net.getWFSJ());
					}
					if (null != net.getFKJE()) {
						veDr.setIllicitAmount(net.getFKJE());
					}
					if (null != net.getWFDZ()) {
						veDr.setIllicitAdress(net.getWFDZ());
					}
					if (null != net.getWFXW()) {
						veDr.setIllicit(net.getWFXW());
					}
					if (null != net.getFXJG()) {
						veDr.setPickDepartment(net.getFXJG());
					}
					if (null != net.getFXJGMC()) {
						veDr.setPickDepartmentDesc(net.getFXJGMC());
					}
					veDr.setIllicitTime(net.getWFSJ());
					if (null != net.getWFJFS()) {
						veDr.setIllicitScore(net.getWFJFS());
					}
					if (net.getJKBJ().equals("0")){
						veDr.setVehiIllicitState("1");
						veDr.setDrIllicitState("1");
						veDr.setVehiState("002");
					} else {
						veDr.setVehiIllicitState("0");
						veDr.setDrIllicitState("1");
						veDr.setVehiState("003");
					}
					if (null != net.getDSR()) {
						veDr.setName(net.getDSR());
					}
					if (null != net.getJSZH()) {
						veDr.setIdcard(net.getJSZH());
					}
					String WFSJdate = net.getWFSJ().substring(0, 4);
					String table = "vehi_dr_illicit";
					if (WFSJdate.equals("2009")) {
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit.getDecisionNumber()) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
						
					} else if (WFSJdate.equals("2010")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					} else if (WFSJdate.equals("2011")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					} else if (WFSJdate.equals("2012")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					} else if (WFSJdate.equals("2013")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					} else if (WFSJdate.equals("2014")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					} else if (WFSJdate.equals("2015")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					} else if (WFSJdate.equals("2016")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					} else if (WFSJdate.equals("2017")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					} else if (WFSJdate.equals("2018")){
						veDr.setTableName(table+WFSJdate);
						veDr.setDecisionNumber(net.getJDSBH());
						VehiDrIllicit cit = testIllicitService.qryVehiDrIllicit(veDr);
						if (null != cit) {
							// 修改
							testIllicitService.updtVehiDrIllicit(veDr);
						} else {
							// 添加
							veDr.setId(uuid);
							testIllicitService.addIllicit(veDr);
						}
					}
					
					
				}
			}
			
			
			
		}
		
	}

	
	
}
