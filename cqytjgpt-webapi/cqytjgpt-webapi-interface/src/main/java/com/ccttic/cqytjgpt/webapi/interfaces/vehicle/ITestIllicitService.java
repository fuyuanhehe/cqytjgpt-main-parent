package com.ccttic.cqytjgpt.webapi.interfaces.vehicle;

import java.util.List;

import com.ccttic.entity.illegal.NetTrffSurveil;
import com.ccttic.entity.illegal.NetTrffViolation;
import com.ccttic.entity.illegal.VehiDrIllicit;
import com.ccttic.entity.role.Vehicle;

public interface ITestIllicitService {
	
	public List<Vehicle> qryVehicleList();
	
	public List<NetTrffSurveil> qryNetTrffSurveilList(String vehiNo);
	
	public void addIllicit (VehiDrIllicit cit);
	
	public List<NetTrffViolation> qryNetTrffViolationList(String vehiNo);
	
	public VehiDrIllicit qryVehiDrIllicit(VehiDrIllicit cit);
	public void updtVehiDrIllicit(VehiDrIllicit cit);
}
