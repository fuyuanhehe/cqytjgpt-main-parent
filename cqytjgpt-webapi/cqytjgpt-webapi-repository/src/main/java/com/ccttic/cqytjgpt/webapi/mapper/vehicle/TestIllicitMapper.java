package com.ccttic.cqytjgpt.webapi.mapper.vehicle;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.illegal.NetTrffSurveil;
import com.ccttic.entity.illegal.NetTrffViolation;
import com.ccttic.entity.illegal.VehiDrIllicit;
import com.ccttic.entity.role.Vehicle;

public interface TestIllicitMapper {
	
	public List<Vehicle> qryVehicleList();
	
	public List<NetTrffSurveil> qryNetTrffSurveilList(Map<String, Object> params);
	
	public void addIllicit (VehiDrIllicit cit);
	
	public List<NetTrffViolation> qryNetTrffViolationList(Map<String, Object> params);
	
	public VehiDrIllicit qryVehiDrIllicit(VehiDrIllicit cit);
	
	public void updtVehiDrIllicit(VehiDrIllicit cit);
	
	public void updaVehi(Map<String, Object> params);
	//--------------------------------------
	public List<EssEnterprise> getEnt();
	public void updaEnt(EssEnterprise essent);
}
