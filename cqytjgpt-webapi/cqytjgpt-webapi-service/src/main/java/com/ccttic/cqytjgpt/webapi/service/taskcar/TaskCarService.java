package com.ccttic.cqytjgpt.webapi.service.taskcar;

import com.ccttic.cqytjgpt.webapi.interfaces.query.IIllegalProcessService;
import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryCarService;
import com.ccttic.cqytjgpt.webapi.interfaces.taskcar.ITaskCarService;
import com.ccttic.cqytjgpt.webapi.mapper.danger.VehiDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.cqytjgpt.webapi.mapper.organization.OrganizationMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehiIllicitMapper;
import com.ccttic.cqytjgpt.webapi.service.vehicle.VehicleServiceImpl;
import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.illegal.VehiIllicit;
import com.ccttic.entity.illegalprocess.XMLIllegalProcess;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.VehicleIllegal;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.web.CCtticWebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
	@Autowired
	private OrganizationMapper organizationMapper;
	@Autowired
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
					String str = null;
					int x = 0;
					for (int j = 0; j < list.size(); j++) {
						str = vehicle.getVehiIllicits().get(i).getId().substring(Const.ZERO, Const.XHlength);
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
				vehiIllicit.setId(xml.getXh() + vehicle.getVehiNo() + vehicle.getVehiNoType());
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
				if (vehiIllicitMapper.selectByPrimaryKey(xml.getXh() + vehicle.getVehiNo() + vehicle.getVehiNoType()) != null) {
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
		List<Integer> sortList = new ArrayList<>();
		int scrappedDays = 0, overdueExamineDays = 0, illegalDays = 0;
		int scrappedRank = 0, overdueExamineRank = 0, illegalRank = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (null != vehicle.getEffectEndTime()) {
			Date effectEndTime = simpleDateFormat.parse(vehicle.getEffectEndTime());
			map = CCtticWebUtils.getDateSpace(new Date(), effectEndTime, "scrapped");
			scrappedRank = (Integer) map.get("rank");
			sortList.add(scrappedRank);
			vr.setScrappedstate(scrappedRank);
			scrappedDays = (Integer) map.get("days");
		} else {
			vr.setScrappedstate(null);
		}
		if (null != vehicle.getExamineEffectEndTime()) {
			Date examineEffectEndTime = simpleDateFormat.parse(vehicle.getExamineEffectEndTime());
			map = CCtticWebUtils.getDateSpace(new Date(), examineEffectEndTime, "inspection");
			overdueExamineRank = (Integer) map.get("rank");
			sortList.add(overdueExamineRank);
			vr.setOverdueexaminestate(overdueExamineRank);
			overdueExamineDays = (Integer) map.get("days");
		} else {
			vr.setOverdueexaminestate(null);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		String vehiDrIllicit = null;
		List<Integer> totalDays = new ArrayList<>();
		int countMore15 =0;
		int countMore30 =0;
		int totalIllegalNum = 0;
		//for (int x = 0; x < 4; x++) {
			vehiDrIllicit= "illicit" + (year);
			List<Integer> days = vehiIllicitMapper.getIllegalDays(vehiDrIllicit.toString(), vehicle.getVehiNo(), vehicle.getVehiNoType());
			totalDays.addAll(days);
			int illegalNum = vehiIllicitMapper.getIllegalNum(vehiDrIllicit.toString(), vehicle.getVehiNo(), vehicle.getVehiNoType());
			totalIllegalNum += illegalNum;
		//}
		if (totalIllegalNum>=3){
			vr.setIllicitstate(Const.THREE);
			illegalRank = Const.THREE;
			Iterator<Integer> iterator = totalDays.iterator();
			while (iterator.hasNext()){
				if (iterator.next()>15){
					countMore15++;
				}
				if (iterator.next()>30) {
					countMore30++;
				}
			}
			if(countMore15>=Const.THREE && !(countMore30>=Const.THREE) && !(totalDays.size()>=10)){
				illegalRank = Const.TWO;
				vr.setIllicitstate(illegalRank);
			}
			if(countMore30>=Const.THREE || totalDays.size()>=10){
				illegalRank = Const.ONE;
				vr.setIllicitstate(illegalRank);
			}
			sortList.add(illegalRank);
		}else{
			vr.setIllicitstate(Const.ZERO);
			illegalRank = Const.ZERO;
			sortList.add(illegalRank);
		}

		if (null == vr.getScrappedstate() || null == vr.getOverdueexaminestate() || null == vr.getIllicitstate()) {
			vr.setDangertype(null);
		}
		Collections.sort(sortList);
		for (int i = 0; i < sortList.size(); i++) {
			if (sortList.get(i) != 0 && i != (sortList.size() - 1)) {
				vr.setDangertype(sortList.get(i).toString());
				break;
			}
			if (i == (sortList.size() - 1)) {
				vr.setDangertype(sortList.get(i).toString());
			}
		}
		sortList.clear();
		sortList.add(overdueExamineDays);
		sortList.add(scrappedDays);
		Collections.sort(sortList);
		vr.setCorrecttime(sortList.get(0).toString());
		vr.setId(vehicle.getVehiNo()+vehicle.getVehiNoType());
		vr.setVehino(vehicle.getVehiNo());
		vr.setVehitype(vehicle.getVehiNoType());
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		vr.setDangertime(sdf.format(new Date()));
		vr.setVehicleId(vehicle.getId());
		String enterpriseId = vehicle.getMgrEnterpriseId();

		Organization org = organizationMapper.findOrgByEptId(enterpriseId);
		if (org != null) {
			vr.setOwnergener(org.getOrgNm());
			vr.setOwnerorgid(org.getOrgCd());
		}

		vr.setOwnerenterprise(enterpriseId == null ? null : enterpriseId);


		if (vehiDangerMapper.selectByPrimaryKey(vr.getId()) !=null) {
			vehiDangerMapper.updateByPrimaryKeySelective(vr);
		} else {
			vehiDangerMapper.insertSelective(vr);
		}
		return map;
	}

	@Override
	public Map<String, Object> updateCar(VehicleIllegal vehicle) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		XMLCar car = queryCarService.selectCarByHpzlHphm(vehicle.getVehiNoType(), vehicle.getVehiNo());
		if (car != null) {
			if (vehicle.getOwner() == null || vehicle.getOwner() == "" || ("未上报").equals(vehicle.getOwner())) {
				// 根据车牌号修改车辆基础信息
				vehicle.setOwner(car.getSyr());// 所有人
			}
			vehicle.setEffectStartTime(car.getCcdjrq());// 初次登记日期
			vehicle.setEffectEndTime(car.getYxqz());// 有效结束时间
			vehicle.setState(VehicleServiceImpl.stateConvert(car.getZt())); // 状态
			map.put("update", vehicle);
		} else {
			map.put("delete", vehicle);
		}
		return map;
	}

}
