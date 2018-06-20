package com.ccttic.cqytjgpt.webapi.service.vehicle;

import java.util.ArrayList;
import java.util.Arrays;
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
	public Page<Vehicle> qryVehicleList(Pageable page, Vehicle vehicle) throws AppException {
		Page<Vehicle> pager = new PageImpl<Vehicle>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("entId", vehicle.getMgrEnterpriseId()); // 企业id
		params.put("mgrDepartAreaId", vehicle.getMgrDepartAreaId()); // 区域编码
		params.put("vehiNo", vehicle.getVehiNo()); // 车牌号
		params.put("vehiNoType", vehicle.getVehiNoType()); // 车牌种类
		params.put("vehiType", vehicle.getVehiType()); // 车俩类型
		params.put("state", vehicle.getState()); // 状态
		params.put("effectStartTime", vehicle.getEffectStartTime()); // 有效开始时间
		params.put("effectEndTime", vehicle.getEffectEndTime()); // 有效结束时间
		params.put("startTime", vehicle.getEffectEndTime()); // 初次检验开始日期
		params.put("endTime", vehicle.getEffectEndTime()); // 初次检验结束日期

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
	public Map<String, Object> saveVehicle(String vehiNo, String vehiNoType) throws AppException {
		Map<String, Object> map = new HashMap<String, Object>();
		int cet = 0;
		String gather = "";
		// 拆分车牌号
		String[] vehiNoGather = vehiNo.split(",");
		String[] vehiNoTypeGather = vehiNoType.split(",");
		// 数组转集合
		List<String> list = Arrays.asList(vehiNoGather);
		List<String> arrList = new ArrayList<String>(list);
		// 循环把车牌号和车辆类型装入集合
		for (int i = 0; i < arrList.size(); i++) {
			Map<String, Object> params = new HashMap<String, Object>();
			String uuid = RandomHelper.uuid();
			params.put("id", uuid);
			params.put("vehiNo", arrList.get(i));
			params.put("vehiNoType", vehiNoTypeGather[0]);
			// 判断车牌号是否重复
			if (mapper.qryOneVehiNo(arrList.get(i)) != null) {
				logger.info("VehicleBasicServiceImpl-->saveVehicle::车牌号[" + vehiNoGather[i] + "]已存在！");
				gather = gather+ "车牌号[" + vehiNoGather[i] + "]已存在！";
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
		vehicle.setVehiNo(xmlCar.getHphm());
		vehicle.setOwner(xmlCar.getSyr());// 所有人
		vehicle.setEffectStartTime(xmlCar.getCcdjrq());// 初次登记日期
		vehicle.setEffectEndTime(xmlCar.getYxqz());// 有效结束时间
		String state = stateConvert(xmlCar);
		vehicle.setState(state); // 状态
		mapper.modifVehicle(vehicle);
	}

	public static String stateConvert(XMLCar car) {
		String state = "";
		if (car.getZt().equals("违法未处理")) {
			state = "G";
			return state;
		} else if (car.getZt().equals("正常")) {
			state = "A";
			return state;
		} else if (car.getZt().equals("锁定")) {
			state = "O";
			return state;
		} else if (car.getZt().equals("事故逃逸")) {
			state = "N";
			return state;
		} else if (car.getZt().equals("达到报废标准")) {
			state = "M";
			return state;
		} else if (car.getZt().equals("扣留")) {
			state = "L";
			return state;
		} else if (car.getZt().equals("查封")) {
			state = "K";
			return state;
		} else if (car.getZt().equals("嫌疑车")) {
			state = "J";
			return state;
		} else if (car.getZt().equals("停驶")) {
			state = "D";
			return state;
		} else if (car.getZt().equals("注销")) {
			state = "E";
			return state;
		} else if (car.getZt().equals("海关监管")) {
			state = "H";
			return state;
		} else if (car.getZt().equals("被盗抢")) {
			state = "C";
			return state;
		} else if (car.getZt().equals("转出")) {
			state = "B";
			return state;
		} else if (car.getZt().equals("达到报废标准公告牌证作废")) {
			state = "P";
			return state;
		} else if (car.getZt().equals("逾期未检验")) {
			state = "Q";
			return state;
		}
		return state;
	}
	
	@Override
	public List<Vehicle> getAllVehicle() {
		
		return mapper.getAllCar();
	}
	
	
}
