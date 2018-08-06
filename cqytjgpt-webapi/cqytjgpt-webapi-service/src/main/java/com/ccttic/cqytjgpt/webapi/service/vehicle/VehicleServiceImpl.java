package com.ccttic.cqytjgpt.webapi.service.vehicle;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.util.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehicleService;
import com.ccttic.cqytjgpt.webapi.mapper.category.CategoryMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehicleMapper;
import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.role.Area;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.PageVehicleVo;
import com.ccttic.entity.role.vo.VehicleIllegal;
import com.ccttic.entity.role.vo.VehicleList;
import com.ccttic.entity.role.vo.VehicleVO;
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

	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public Page<Vehicle> qryVehicleList(Pageable page, PageVehicleVo vehicle, EmployeePermission employeePermission) throws AppException {
		Page<Vehicle> pager = new PageImpl<Vehicle>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("entId", vehicle.getMgrEnterpriseId()); // 企业id
		if(Const.ETPUSER.equals(employeePermission.getEmployeeType()) || Const.ADMIN.equals(employeePermission.getEmployeeType())){
			params.put("id", employeePermission.getEnterpriseId());
			employeePermission.setEmployeeType("ADMIN");
		}
		if(Const.SUPER.equals(employeePermission.getEmployeeType()) || Const.ORGUSER.equals(employeePermission.getEmployeeType())){
			params.put("id", employeePermission.getOrgId());
			employeePermission.setEmployeeType("SUPER");
		}

		params.put("mgrDepartAreaId", vehicle.getMgrDepartAreaId()); // 区域编码
		params.put("vehiNo", vehicle.getVehiNo()); // 车牌号
		params.put("vehiNoType", vehicle.getVehiNoType()); // 车牌种类
		params.put("vehiType", vehicle.getVehiType()); // 车俩类型
		params.put("state", vehicle.getState()); // 状态
		params.put("effectStartTime", vehicle.getEffectStartTime()); // 有效开始时间
		params.put("effectEndTime", vehicle.getEffectEndTime()); // 有效结束时间
		params.put("startTime", vehicle.getStartTime()); // 初次检验开始日期
		params.put("endTime", vehicle.getEndTime()); // 初次检验结束日期
		params.put("empType", employeePermission.getEmployeeType()); // 账号类型

		long totolRols = mapper.qryVehicleListCount(params);
		List<Vehicle> records = mapper.qryVehicleList(params);
		for (Vehicle ve : records) {
			if (null != ve.getState()){
				String Stra = upStact(ve.getState());
				ve.setState(Stra);
			}
		}
		pager.setTotalRows(totolRols);
		pager.setRecords(records);

		return pager;
	}
	
	@Override
	public VehicleVO qryOneVehicle(Map<String, Object> params) throws AppException {
		VehicleVO vehicle = mapper.qryOneVehicle(params);
		if (null != vehicle.getState()) {
			String Stra=upStact(vehicle.getState());
			vehicle.setState(Stra);
		}
		return vehicle;
	}

	@Override
	public Page<VehiIllicit> qryVehiIllicitList(Pageable page, VehiIllicit vehiIllicit) throws AppException {
		Page<VehiIllicit> pager = new PageImpl<VehiIllicit>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = 0;
		if (null != vehiIllicit.getIllicitTime()) {
			year = Integer.parseInt(vehiIllicit.getIllicitTime().substring(0, 4));
		} else { // 当违法时间为空的时候直接取当前年份
			year = calendar.get(Calendar.YEAR);
		}
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		
		params.put("vehiNo", vehiIllicit.getVehiNo());
		params.put("vehiNoType", vehiIllicit.getVehiNoType());
		params.put("tableName", "illicit_"+year);
		long totolRol = mapper.qryVehiIllicitListCount(params);
		List<VehiIllicit> records = mapper.qryVehiIllicitList(params);
		for (VehiIllicit vehiIllicit2 : records) {
			if (null != vehiIllicit2.getIllicitScore()) {
				vehiIllicit.setDisposeSign("已处理");
				vehiIllicit.setState("已处理");
			}
		}
        pager.setRecords(records);
		pager.setTotalRows(totolRol);
		return pager;
	}

	@Override
	public Map<String, Object> saveVehicle(VehicleList listMap, String entId) throws AppException {
		Map<String, Object> map = new HashMap<String, Object>();
		int cet = 0;
		String gather = "";
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
				gather = gather + "车牌号[" + maps.get(i).get("vehiNo") + "]已存在！";
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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("vehiNo", xmlCar.getHphm());
		Vehicle v = mapper.qryOneVehicle(params);
		if (v.getOwner() == null || v.getOwner() == "" || ("未上报").equals(v.getOwner())) {
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
		String[] stait = zt.split(",");
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

	public static String upStact (String zt) {
		String state = "";
		for (int i = 0; i < zt.length(); i++) {
			if (String.valueOf(zt.charAt(i)).equals("G")) {
				state += ",违法未处理";
			} else if (String.valueOf(zt.charAt(i)).equals("A")) {
				state += ",正常";
			} else if (String.valueOf(zt.charAt(i)).equals("O")) {
				state += ",锁定";
			} else if (String.valueOf(zt.charAt(i)).equals("N")) {
				state += ",事故逃逸";
			} else if (String.valueOf(zt.charAt(i)).equals("M")) {
				state += ",达到报废标准";
			} else if (String.valueOf(zt.charAt(i)).equals("L")) {
				state += ",扣留";
			} else if (String.valueOf(zt.charAt(i)).equals("K")) {
				state += ",查封";
			} else if (String.valueOf(zt.charAt(i)).equals("J")) {
				state += ",嫌疑车";
			} else if (String.valueOf(zt.charAt(i)).equals("D")) {
				state += ",停驶";
			} else if (String.valueOf(zt.charAt(i)).equals("E")) {
				state += ",注销";
			} else if (String.valueOf(zt.charAt(i)).equals("H")) {
				state += ",海关监管";
			} else if (String.valueOf(zt.charAt(i)).equals("C")) {
				state += ",被盗抢";
			} else if (String.valueOf(zt.charAt(i)).equals("B")) {
				state += ",转出";
			} else if (String.valueOf(zt.charAt(i)).equals("P")) {
				state += ",达到报废标准公告牌证作废";
			} else if (String.valueOf(zt.charAt(i)).equals("Q")) {
				state += ",逾期未检验";
			}
		}
		state = state.substring(1);
		return state;
	}
	
	@Override
	public Area getfenceIdByEssid(String id) {

		return mapper.getfenceIdByEssid(id);
	}

	@Override
	public List<VehicleIllegal> getVehicleByEnterprises(List<EssEnterprise> enterprise) {
		return mapper.getVehicleByEnterprises(enterprise);
	}

	@Override
	public List<Vehicle> getVehicleMsg() {
		return mapper.getVehicleMsg();
	}

}
