package com.ccttic.cqytjgpt.webapi.service.vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<NetTrffSurveil> qryNetTrffSurveilList(String vehiNo,String type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("vehiNo", vehiNo);
		params.put("type", type);
		return mapper.qryNetTrffSurveilList(params);
	}
	@Override
	public void addIllicit(VehiDrIllicit cit) {
		mapper.addIllicit(cit);
	}
	@Override
	public List<NetTrffViolation> qryNetTrffViolationList(String vehiNo,String type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("vehiNo", vehiNo);
		params.put("type", type);
		return mapper.qryNetTrffViolationList(params);
	}
	@Override
	public VehiDrIllicit qryVehiDrIllicit(VehiDrIllicit cit) {
		return mapper.qryVehiDrIllicit(cit);
	}
	@Override
	public void updtVehiDrIllicit(VehiDrIllicit cit) {
		mapper.updtVehiDrIllicit(cit);
	}
	@Override
	public void updaVehi(Map<String, Object> params) {
		mapper.updaVehi(params);
	}


}
