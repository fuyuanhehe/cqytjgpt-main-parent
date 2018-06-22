package com.ccttic.cqytjgpt.webapi.service.taskcar;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.query.IIllegalProcessService;
import com.ccttic.cqytjgpt.webapi.interfaces.taskcar.ITaskCarService;
import com.ccttic.cqytjgpt.webapi.mapper.danger.VehiDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehiIllicitMapper;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.illegal.VehiIllicit;
import com.ccttic.entity.illegalprocess.XMLIllegalProcess;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.VehicleIllegal;

@Service
public class TaskCarService implements ITaskCarService {

	@Autowired
	private IIllegalProcessService illegalProcessService;
	@Autowired
	private VehiIllicitMapper vehiIllicitMapper;
	@Autowired
	private EssEnterpriseMapper essEnterpriseMapper;
	@Autowired
	private VehiDangerMapper vehiDangerMapper;

	@Override
	public Map<String, Object> getCarIllega(VehicleIllegal vehicle) throws Exception {
		Map<String, Object> result = new HashMap<>();
		VehiIllicit vehiIllicit = null;
		if (vehicle.getVehiNo() != null || vehicle.getVehiNo() != "" || vehicle.getVehiNoType() != null
				|| vehicle.getVehiNoType() != "") {

			Map<Object, Object> map = illegalProcessService.getIIllegalProcess("04", "04Q21",
					"<hphm>渝" + vehicle.getVehiNo() + "</hphm><hpzl>" + vehicle.getVehiNoType() + "</hpzl>");
			@SuppressWarnings("unchecked")
			List<XMLIllegalProcess> list = (List<XMLIllegalProcess>) map.get("illegalprocess");
			if (vehicle.getVehiIllicits() != null && vehicle.getVehiIllicits().size() > 0) {
				for (int i = 0; i < vehicle.getVehiIllicits().size(); i++) {
					int x = 0;
					for (int j = 0; j < list.size(); j++) {
						if (vehicle.getVehiIllicits().get(i).getId().equals(list.get(j).getXh())) {
							x++;
						}
					}
					if (x == 0) {
						vehiIllicit = new VehiIllicit();
						vehiIllicit.setIsdeleted(true);
						vehiIllicit.setId(vehicle.getVehiIllicits().get(i).getId());
						vehiIllicitMapper.updateByPrimaryKeySelective(vehiIllicit);
					}
				}
			}
			for (XMLIllegalProcess xml : list) {

				vehiIllicit = new VehiIllicit();
				vehiIllicit.setId(xml.getXh());
				vehiIllicit.setVehino(vehicle.getVehiNo());
				vehiIllicit.setVehinotype(vehicle.getVehiNoType());
				vehiIllicit.setNature(vehicle.getNature());
				vehiIllicit.setOwnership(vehicle.getOwnership());
				vehiIllicit.setOwner(vehicle.getOwner());
				vehiIllicit.setMgrdepartareaid(vehicle.getMgrDepartAreaId());
				vehiIllicit.setMgrdepart(vehicle.getMgrDepart());
				vehiIllicit.setVehicleId(vehicle.getId());
				vehiIllicit.setState(vehicle.getState());
				vehiIllicit.setIllicittime(xml.getWfsj());
				vehiIllicit.setIllicitscore(xml.getWfjfs());
				vehiIllicit.setIllicitamount(xml.getFkje());
				vehiIllicit.setIllicitadress(xml.getWfdz());
				vehiIllicit.setIllicit(xml.getWfxw());
				vehiIllicit.setPickdepartmentdesc(xml.getCjjgmc());
				if (vehiIllicitMapper.selectByPrimaryKey(vehiIllicit.getId()) != null) {
					result.put("update", vehiIllicit);
					result.put("insert", null);
				} else {
					result.put("insert", vehiIllicit);
					result.put("update", null);
				}
			}

		}
		return result;

	}

	@Override
	public Map<String, Object> getCarDanger(Vehicle vehicle) throws Exception {
		Map<String, Object> map = new HashMap<>();
		VehiDanger vr = new VehiDanger();
		String hphm = URLDecoder.decode(vehicle.getVehiNo() + vehicle.getVehiNoType(), "UTF-8");
		vr.setId(hphm);
		vr.setVehino(vehicle.getVehiNo());
		vr.setVehitype(vehicle.getVehiNoType());
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		vr.setDangertime(sdf.format(new Date()));
		String enterpriseid = vehicle.getMgrEnterpriseId();
		String orgNm = essEnterpriseMapper.selectOrgNmbyId(enterpriseid);
		EssEnterprise etp = essEnterpriseMapper.selectByPrimaryKey(enterpriseid);
		vr.setOwnerorgid(orgNm);
		vr.setOwnerenterprise(etp == null ? null : etp.getEtpnm());
		String[] strs = vehicle.getState().split(",");
		for (String string : strs) {
			vr.setScrappedstate("M".equals(string) ? 1 : 0);
			vr.setIllicitstate("G".equals(string) ? 1 : 0);
			vr.setOverdueexaminestate("Q".equals(string) ? 1 : 0);
			vr.setFailurestate("I".equals(string) ? 1 : 0);
		}

		if (vr.getIllicitstate() + vr.getScrappedstate() + vr.getOverdueexaminestate() + vr.getFailurestate() == 0) {
			vr.setDangertype("0");
		} else if (vr.getIllicitstate() == 1
				&& vr.getScrappedstate() + vr.getOverdueexaminestate() + vr.getFailurestate() == 0) {
			vr.setDangertype("3");
		} else if (vr.getIllicitstate() + vr.getScrappedstate() + vr.getOverdueexaminestate() == 0
				&& vr.getFailurestate() == 1) {
			vr.setDangertype("2");
		} else if (vr.getScrappedstate() == 1 || vr.getOverdueexaminestate() == 1) {
			vr.setDangertype("1");
		}

		if (vehiDangerMapper.selectByPrimaryKey(hphm) != null) {
			map.put("update", vr);
			map.put("insert", null);
		} else {
			map.put("insert", vr);
			map.put("update", null);
		}
		return map;
	}

}
