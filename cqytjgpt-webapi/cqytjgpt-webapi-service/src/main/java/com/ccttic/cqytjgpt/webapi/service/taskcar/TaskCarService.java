package com.ccttic.cqytjgpt.webapi.service.taskcar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.web.CCtticWebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.query.IIllegalProcessService;
import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryCarService;
import com.ccttic.cqytjgpt.webapi.interfaces.taskcar.ITaskCarService;
import com.ccttic.cqytjgpt.webapi.mapper.danger.VehiDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.cqytjgpt.webapi.mapper.organization.OrganizationMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehiIllicitMapper;
import com.ccttic.cqytjgpt.webapi.service.vehicle.VehicleServiceImpl;
import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.danger.DangerEnums;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.illegal.VehiIllicit;
import com.ccttic.entity.illegal.VehiIllicitExample;
import com.ccttic.entity.illegalprocess.XMLIllegalProcess;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.VehicleIllegal;
import com.ccttic.util.common.Const;

import javax.annotation.Resource;

@Service
public class TaskCarService implements ITaskCarService {

	@Resource
	private IIllegalProcessService illegalProcessService;
	@Resource
	private VehiIllicitMapper vehiIllicitMapper;
	@Resource
	private EssEnterpriseMapper essEnterpriseMapper;
	@Resource
	private VehiDangerMapper vehiDangerMapper;
	@Resource
	private OrganizationMapper organizationMapper;
	@Resource
	private IQueryCarService queryCarService;
	

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
					String str=null;
					int x = 0;
					for (int j = 0; j < list.size(); j++) {
						str =vehicle.getVehiIllicits().get(i).getId().substring(Const.ZERO, Const.XHlength);
						if (str.equals(list.get(j).getXh())) {
							x++;
						}
					}
					if (x == 0) {
						vehiIllicitMapper.deleteByPrimaryKey(vehicle.getVehiIllicits().get(i).getId());
					}
				}
			}
			List<VehiIllicit> update = new ArrayList<>();
			List<VehiIllicit> insert = new ArrayList<>();
			
			for (XMLIllegalProcess xml : list) {

				vehiIllicit = new VehiIllicit();
				vehiIllicit.setId(xml.getXh()+vehicle.getVehiNo()+vehicle.getVehiNoType());
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
				if (vehiIllicitMapper.selectByPrimaryKey(xml.getXh()+vehicle.getVehiNo()+vehicle.getVehiNoType()) != null) {
					update.add(vehiIllicit);

				} else {
					insert.add(vehiIllicit);

				}
			}
			result.put("update", update.size() > 0 ? update : null);
			result.put("insert", insert.size() > 0 ? insert : null);

		}
		return result;

	}

	@Override
	public Map<String, Object> getCarDanger(Vehicle vehicle) throws Exception {
		Map<String, Object> map = new HashMap<>();
		VehiDanger vr = new VehiDanger();
		int scrappedDays,overdueexamineDays,illegalDays ;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
		if(null !=vehicle.getEffectEndTime()) {
			Date effectendtime = simpleDateFormat.parse(vehicle.getEffectEndTime());
			map = CCtticWebUtils.getDateSpace(new Date(),effectendtime,"car");
			vr.setScrappedstate((Integer)map.get("type"));
			scrappedDays =(Integer)map.get("days");
		}else {
			vr.setScrappedstate(null);
		}
		if(null !=vehicle.getExamineEffectEndTime()){
			Date examineeffectendtime = simpleDateFormat.parse(vehicle.getExamineEffectEndTime());
			map = CCtticWebUtils.getDateSpace(new Date(),examineeffectendtime,"car");
			vr.setOverdueexaminestate((Integer)map.get("type"));
			overdueexamineDays = (Integer)map.get("days");
		}else{
			vr.setOverdueexaminestate(null);
		}


//		if (listwait.size() == 0 && listdoing.size() == 0) {
//			vr.setCorrectstate(DangerEnums.NORMAL.getValue());
//		} else if (listdoing.size() > 0 && listdoing.size() != 0) {
//			vr.setCorrectstate(DangerEnums.EXECUTING.getValue());
//		} else if (listwait.size() > 0 && listdoing.size() == 0) {
//			vr.setCorrectstate(DangerEnums.UNEXECUTED.getValue());
//		}

		vr.setId(RandomHelper.uuid());
		vr.setVehino(vehicle.getVehiNo());
		vr.setVehitype(vehicle.getVehiNoType());
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		vr.setDangertime(sdf.format(new Date()));
		vr.setVehicleId(vehicle.getId());
		String enterpriseid = vehicle.getMgrEnterpriseId();

		Organization org = organizationMapper.findOrgByEptId(enterpriseid);
		vr.setOwnergener(org.getOrgNm());
		vr.setOwnerorgid(org.getOrgCd());
		vr.setOwnerenterprise(enterpriseid == null ? null : enterpriseid);
		String[] strs = vehicle.getState().split(",");

		if (vehiDangerMapper.selectByPrimaryKey(vehicle.getId()) != null) {
			map.put("update", vr);
			map.put("insert", null);
		} else {
			map.put("insert", vr);
			map.put("update", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> updateCar(VehicleIllegal vehicle) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		XMLCar car = queryCarService.selectCarByHpzlHphm(vehicle.getVehiNoType(), vehicle.getVehiNo());
		if(car!=null) {
			if (vehicle.getOwner() == null || vehicle.getOwner() == "" || ("未上报").equals(vehicle.getOwner())) {
				// 根据车牌号修改车辆基础信息
				vehicle.setOwner(car.getSyr());// 所有人
			}
			vehicle.setEffectStartTime(car.getCcdjrq());// 初次登记日期
			vehicle.setEffectEndTime(car.getYxqz());// 有效结束时间
			vehicle.setState(VehicleServiceImpl.stateConvert(car.getZt())); // 状态
			map.put("update", vehicle);
		}else {
			map.put("delete", vehicle);
		}
		return map;
	}

}
