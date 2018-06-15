package com.ccttic.cqytjgpt.webapi.service.taskcar;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.ccttic.entity.illegal.VehiIllicitExample;
import com.ccttic.entity.illegalprocess.XMLIllegalProcess;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;

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
	public void addCarIllega(Vehicle vehicle) throws Exception {
		VehiIllicit vehiIllicit = null;
			if (vehicle.getVehiNo() != null || vehicle.getVehiNo() != "" || vehicle.getVehiNoType() != null
					|| vehicle.getVehiNoType() != "") {

				Map<Object, Object> map = illegalProcessService.getIIllegalProcess("04", "04Q21",
						"<hphm>渝" + vehicle.getVehiNo() + "</hphm><hpzl>" + vehicle.getVehiNoType() + "</hpzl>");
				@SuppressWarnings("unchecked")
				List<XMLIllegalProcess> list = (List<XMLIllegalProcess>) map.get("illegalprocess");
				VehiIllicitExample example = new VehiIllicitExample();
				example.createCriteria().andVehinoEqualTo(vehicle.getVehiNo())
						.andVehinotypeEqualTo(vehicle.getVehiNoType());
				List<VehiIllicit> VehiIllicit = vehiIllicitMapper.selectByExample(example);
				for (int i = 0; i < VehiIllicit.size(); i++) {
					int x = 0;
					for (int j = 0; j < list.size(); j++) {
						if (VehiIllicit.get(i).getId().equals(list.get(j).getXh())) {
							x++;
						}
					}
					if (x == 0) {
						vehiIllicitMapper.deleteByPrimaryKey(VehiIllicit.get(i).getId());
					}
				}
				for (XMLIllegalProcess xml : list) {

					vehiIllicit = new VehiIllicit();
					vehiIllicit.setId(xml.getXh());
					vehiIllicit.setVehiNo(vehicle.getVehiNo());
					vehiIllicit.setVehiNoType(vehicle.getVehiNoType());
					vehiIllicit.setNature(vehicle.getNature());
					vehiIllicit.setOwnership(vehicle.getOwnership());
					vehiIllicit.setOwner(vehicle.getOwner());
					vehiIllicit.setMgrDepartAreaId(vehicle.getMgrDepartAreaId());
					vehiIllicit.setMgrDepart(vehicle.getMgrDepart());
					vehiIllicit.setVehicleId(vehicle.getId());
					vehiIllicit.setState(vehicle.getState());
					vehiIllicit.setIllicitTime(xml.getWfsj());
					vehiIllicit.setIllicitScore(xml.getWfjfs());
					vehiIllicit.setIllicitAmount(xml.getFkje());
					vehiIllicit.setIllicitAdress(xml.getWfdz());
					vehiIllicit.setIllicit(xml.getWfxw());
					vehiIllicit.setPickDepartmentDesc(xml.getCjjgmc());
					if (vehiIllicitMapper.selectByPrimaryKey(vehiIllicit.getId()) != null) {
						vehiIllicitMapper.updateByPrimaryKeySelective(vehiIllicit);
					} else {
						vehiIllicitMapper.insertSelective(vehiIllicit);
					}
				}
			
		}

	}

	@Override
	public void addCarDanger(Vehicle vehicle) throws Exception {
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
			vr.setOwnerenterprise(etp.getEtpnm());
			vr.setScrappedstate("M".equals(vehicle.getState()) ? 1 : 0);
			vr.setIllicitstate("G".equals(vehicle.getState()) ? 1 : 0);
			vr.setOverdueexaminestate("Q".equals(vehicle.getState()) ? 1 : 0);
			vr.setFailureState("I".equals(vehicle.getState()) ? 1 : 0);
			if (vr.getIllicitstate() + vr.getScrappedstate() + vr.getOverdueexaminestate()
					+ vr.getFailureState() == 0) {
				vr.setDangertype("0");
			} else if (vr.getIllicitstate() == 1
					&& vr.getScrappedstate() + vr.getOverdueexaminestate() + vr.getFailureState() == 0) {
				vr.setDangertype("3");
			} else if (vr.getIllicitstate() + vr.getScrappedstate() + vr.getOverdueexaminestate() == 0
					&& vr.getFailureState() == 1) {
				vr.setDangertype("2");
			} else if (vr.getScrappedstate() == 1 || vr.getOverdueexaminestate() == 1) {
				vr.setDangertype("1");
			}

			if (vehiDangerMapper.selectByPrimaryKey(hphm) != null) {
				vehiDangerMapper.updateByPrimaryKey(vr);
			} else {
				vehiDangerMapper.insertSelective(vr);
			}
		}

}
