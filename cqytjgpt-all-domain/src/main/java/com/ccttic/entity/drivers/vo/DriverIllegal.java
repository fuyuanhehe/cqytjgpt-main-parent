package com.ccttic.entity.drivers.vo;

import java.util.List;

import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.illegal.DrIllicit;

public class DriverIllegal extends Driver {

      private List<DrIllicit> drIllicits;

	public List<DrIllicit> getDrIllicits() {
		return drIllicits;
	}

	public void setDrIllicits(List<DrIllicit> drIllicits) {
		this.drIllicits = drIllicits;
	}

	public DriverIllegal(String id, String name, String idcard, String telphone, String mobilephone, String adress,
			String permicar, String firstrecivetime, String mgrdepart, String mgrdepartareaid, String mgrenterpriseid,
			String nextexaminetime, String effectstarttime, String effectendtime, String examineeffectendtime,
			String scoretotal, String state, List<DrIllicit> drIllicits) {
		super();
		this.drIllicits = drIllicits;
	}

	public DriverIllegal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverIllegal(String id, String name, String idcard, String telphone, String mobilephone, String adress,
			String permicar, String firstrecivetime, String mgrdepart, String mgrdepartareaid, String mgrenterpriseid,
			String nextexaminetime, String effectstarttime, String effectendtime, String examineeffectendtime,
			String scoretotal, String state) {
		super();
		// TODO Auto-generated constructor stub
	}
      
      
}
