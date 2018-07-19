package com.ccttic.cqytjgpt.webapi.service.vehicle;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.ITestIllicitService;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.TestIllicitMapper;
import com.ccttic.entity.illegal.NetTrffSurveil;
import com.ccttic.entity.illegal.NetTrffViolation;
import com.ccttic.entity.illegal.VehiDrIllicit;
import com.ccttic.entity.role.Vehicle;
@Service
public class TestIllicitServiceImpl implements ITestIllicitService{

	@Resource
	private TestIllicitMapper mapper;
	@Override
	public List<Vehicle> qryVehicleList() {
		return mapper.qryVehicleList();
	}
	@Override
	public List<NetTrffSurveil> qryNetTrffSurveilList(String vehiNo) {
		return mapper.qryNetTrffSurveilList(vehiNo);
	}
	@Override
	public void addIllicit(VehiDrIllicit cit) {
		mapper.addIllicit(cit);
	}
	@Override
	public List<NetTrffViolation> qryNetTrffViolationList(String vehiNo) {
		return mapper.qryNetTrffViolationList(vehiNo);
	}
	@Override
	public VehiDrIllicit qryVehiDrIllicit(VehiDrIllicit cit) {
		return mapper.qryVehiDrIllicit(cit);
	}
	@Override
	public void updtVehiDrIllicit(VehiDrIllicit cit) {
		mapper.updtVehiDrIllicit(cit);
		
	}


}
