package com.ccttic.entity.role.vo;

import java.util.List;

import com.ccttic.entity.illegal.VehiIllicit;
import com.ccttic.entity.role.Vehicle;

public class VehicleIllegal extends Vehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<VehiIllicit> vehiIllicits;

	public List<VehiIllicit> getVehiIllicits() {
		return vehiIllicits;
	}

	public void setVehiIllicits(List<VehiIllicit> vehiIllicits) {
		this.vehiIllicits = vehiIllicits;
	}



	public VehicleIllegal() {
		super();
	}

	public VehicleIllegal(List<VehiIllicit> vehiIllicits) {
		this.vehiIllicits = vehiIllicits;
	}

	public VehicleIllegal(String vehiNo, String vehiNoType, String vehiNoTypeText, String vehiType, String vehiTypeText, String nature, String ownership, String owner, String telphone, String mobilephone, String adress, String permitCar, String firstReciveTime, String mgrDepart, String mgrDepartAreaId, String areaNm, String mgrEnterpriseId, String etpNm, String nextExamineTime, String effectStartTime, String effectEndTime, String examineEffectEndTime, String scoreTotal, String state, String remark, String startTime, String endTime, String id, String identityName, String identityCode, String countrySideUse, String mbCar, String examineForceEffectEndTime, List<VehiIllicit> vehiIllicits) {
		super(vehiNo, vehiNoType, vehiNoTypeText, vehiType, vehiTypeText, nature, ownership, owner, telphone, mobilephone, adress, permitCar, firstReciveTime, mgrDepart, mgrDepartAreaId, areaNm, mgrEnterpriseId, etpNm, nextExamineTime, effectStartTime, effectEndTime, examineEffectEndTime, scoreTotal, state, remark, startTime, endTime, id, identityName, identityCode, countrySideUse, mbCar, examineForceEffectEndTime);
		this.vehiIllicits = vehiIllicits;
	}
	
}
