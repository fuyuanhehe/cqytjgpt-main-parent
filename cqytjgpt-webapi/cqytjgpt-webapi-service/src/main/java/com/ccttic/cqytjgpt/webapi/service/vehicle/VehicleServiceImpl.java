package com.ccttic.cqytjgpt.webapi.service.vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehicleService;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehicleMapper;
import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.PageVehicleVo;
import com.ccttic.entity.role.vo.VehicleIllegal;
import com.ccttic.entity.role.vo.VehicleList;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

@Service
public class VehicleServiceImpl implements IVehicleService {
	private Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);
	@Resource
	private VehicleMapper mapper;// 司机基础信息

	@Override
	public Page<Vehicle> qryVehicleList(Pageable page, PageVehicleVo vehicle) throws AppException {
		Page<Vehicle> pager = new PageImpl<Vehicle>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("entId", vehicle.getMgrEnterpriseId()); // 企业id
		params.put("list", vehicle.getList()); // 企业id
		params.put("mgrDepartAreaId", vehicle.getMgrDepartAreaId()); // 区域编码
		params.put("vehiNo", vehicle.getVehiNo()); // 车牌号
		params.put("vehiNoType", vehicle.getVehiNoType()); // 车牌种类
		params.put("vehiType", vehicle.getVehiType()); // 车俩类型
		params.put("state", vehicle.getState()); // 状态
		params.put("effectStartTime", vehicle.getEffectStartTime()); // 有效开始时间
		params.put("effectEndTime", vehicle.getEffectEndTime()); // 有效结束时间
		params.put("startTime", vehicle.getStartTime()); // 初次检验开始日期
		params.put("endTime", vehicle.getEndTime()); // 初次检验结束日期
		params.put("empType", vehicle.getEmpType()); // 账号类型

		long totolRols = mapper.qryVehicleListCount(params);
		List<Vehicle> records = mapper.qryVehicleList(params);

		pager.setTotalRows(totolRols);
		pager.setRecords(records);

		return pager;
	}

	@Override
	public Vehicle qryOneVehicle(Map<String, Object> params) throws AppException {
		return mapper.qryOneVehicle(params);
	}

	@Override
	public Page<VehiIllicit> qryVehiIllicitList(Pageable page, VehiIllicit vehiIllicit) throws AppException {
		Page<VehiIllicit> pager = new PageImpl<VehiIllicit>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("id", vehiIllicit.getId());
		long totolRols = mapper.qryVehiIllicitListCount(params);
		List<VehiIllicit> records = mapper.qryVehiIllicitList(params);

		pager.setTotalRows(totolRols);
		pager.setRecords(records);

		return pager;
	}

	@Override
	public Map<String, Object> saveVehicle(VehicleList listMap,String entId) throws AppException {
		Map<String, Object> map = new HashMap<String, Object>();
		int cet = 0;
		String gather="";
		List<Map<String, String>> maps = listMap.getListMap();
		for (int i = 0; i < maps.size(); i++) {
			Map<String, String> mapVe = maps.get(i);
			Map<String, Object> params = new HashMap<String, Object>();
			String uuid = RandomHelper.uuid();
			params.put("id", uuid);
			params.put("vehiNo", mapVe.get("vehiNo"));
			params.put("vehiNoType", mapVe.get("vehiNoType"));
			params.put("carTypeName", mapVe.get("carTypeName"));
			params.put("entId", entId);
			if (mapper.qryOneVehiNo(maps.get(i).get("vehiNo")) != null) {
				logger.info("VehicleBasicServiceImpl-->saveVehicle::车牌号[" + maps.get(i).get("vehiNo") + "]已存在！");
				gather = gather+ "车牌号[" + maps.get(i).get("vehiNo") + "]已存在！";
				cet = 1;
				continue;
			}
		
			// 入库
			mapper.saveVehicle(params);
		}
		map.put("cet", cet);
		map.put("gather", gather);
		return map;
	}

	@Override
	public void modifVehicle(XMLCar xmlCar) throws AppException {
		Vehicle vehicle = new Vehicle();
		// 根据编号查询机动车 如果机动车里面有所有人则不修改 否则修改
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("vehiNo", xmlCar.getHphm());
		Vehicle v = mapper.qryOneVehicle(params);
		if(v.getOwner()==null || v.getOwner()=="") {
			// 根据车牌号修改车辆基础信息
			vehicle.setOwner(xmlCar.getSyr());// 所有人
		}
		vehicle.setVehiNo(xmlCar.getHphm());
		vehicle.setEffectStartTime(xmlCar.getCcdjrq());// 初次登记日期
		vehicle.setEffectEndTime(xmlCar.getYxqz());// 有效结束时间
		String state = null;
		if (null != xmlCar.getZt()) {
			state = stateConvert(xmlCar.getZt());
		}
		
		vehicle.setState(state); // 状态
		mapper.modifVehicle(vehicle);
	}

	public static String stateConvert(String zt) {
		String state = "";
		String [] stait = zt.split(",");
		for (int i = 0; i < stait.length; i++) {
			if (stait[i].equals("违法未处理")) {
				state += ",G";
			} else if (stait[i].equals("正常")) {
				state += ",A";
			} else if (stait[i].equals("锁定")) {
				state += ",O";
			} else if (stait[i].equals("事故逃逸")) {
				state += ",N";
			} else if (stait[i].equals("达到报废标准")) {
				state += ",M";
			} else if (stait[i].equals("扣留")) {
				state += ",L";
			} else if (stait[i].equals("查封")) {
				state += ",K";
			} else if (stait[i].equals("嫌疑车")) {
				state += ",J";
			} else if (stait[i].equals("停驶")) {
				state += ",D";
			} else if (stait[i].equals("注销")) {
				state += ",E";
			} else if (stait[i].equals("海关监管")) {
				state += ",H";
			} else if (stait[i].equals("被盗抢")) {
				state += ",C";
			} else if (stait[i].equals("转出")) {
				state += ",B";
			} else if (stait[i].equals("达到报废标准公告牌证作废")) {
				state += ",P";
			} else if (stait[i].equals("逾期未检验")) {
				state += ",Q";
			}
		}
		state = state.substring(1);
		return state;
	}
	
	@Override
	public List<VehicleIllegal> getAllVehicle() {
		
		return mapper.getAllCar();
	}

	@Override
	public String getfenceIdByEssid(String id) {
		
		return mapper.getfenceIdByEssid(id);
	}

	
}
