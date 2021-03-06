package com.ccttic.cqytjgpt.enterpriseapi.service.drivers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.drivers.DriversService;
import com.ccttic.cqytjgpt.enterpriseapi.mapper.drivers.DriverMapper;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverInsert;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.entity.drivers.vo.EnterprisethenVo;
import com.ccttic.entity.drivers.vo.PermiCarsVo;
import com.ccttic.entity.drivers.vo.VehicleCountVo;
import com.ccttic.entity.drivers.vo.vehiclesVo;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.common.State;
import com.ccttic.util.common.StringHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

@Service
public class DriversServiceImpl implements DriversService {

	@Autowired
	private DriverMapper mapper;

	@Override
	public Page<DriverVo> driverPage(Pageable page, DriverVo driverVo) {
		Page<DriverVo> pager = new PageImpl<DriverVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("areaNm", driverVo.getAreaNm());
		params.put("mobilephone", driverVo.getMobilephone());
		params.put("enterprise",driverVo.getMgrenterpriseid());
		params.put("inaugurationStatus",driverVo.getInaugurationStatus());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("name", driverVo.getName());
		params.put("idcard", driverVo.getIdcard());
		List<DriverVo> List = mapper.driverPage(params);
		pager.setRecords(List);
		pager.setTotalRows( mapper.pageCount(params));


		return pager;
	}

	@Override
	public DriverVo driverDetails(Map<String, Object> params) {
		return mapper.driverDetails(params);
	}

	@Override
	public Page<DriverillicitVo> seDrillicitByDriverId(Pageable page,DriverVo driver) {
		Page<DriverillicitVo> pager = new PageImpl<DriverillicitVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("idCard", driver.getIdcard());
		params.put("list", driver.getQid());

		pager.setRecords( mapper.seDrillicitByDriverId(params));
		pager.setTotalRows(mapper.seDrillicitByDriverIdCount(params));

		return pager;
	}

	@Override
	public Page<DriverillicitVo> getDriverPages(Pageable page, DriverillicitVo driver, EmployeePermission employeePermission) {
		Page<DriverillicitVo> pager = new PageImpl<DriverillicitVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		if(Const.ADMIN.equals(employeePermission.getEmployeeType())){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		if(Const.ETPUSER.equals(employeePermission.getEmployeeType())){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		if(null!=driver.getIdcard()){
			params.put("idCard",driver.getIdcard());
		}
		if(null!=driver.getFiString()){
			params.put("startTime",driver.getFiString());
		}
		if(null!=driver.getLaString()){
			params.put("endTime",driver.getLaString());
		}
		if (null!=driver.getId()){
			params.put("id",driver.getId());
		}
		if(null!=driver.getName()){
			params.put("name", driver.getName());
		}
		if(null!=driver.getEtpNm()){
			params.put("etpNm", driver.getEtpNm());
		}

		params.put("list", employeePermission.getAreaList()!=null?employeePermission.getAreaList():null);


		pager.setRecords(mapper.seDr_illicitPages(params));
		pager.setTotalRows(mapper.getDriverPageCount(params));

		return pager;
	}

	@Override
	@Transactional
	public boolean insertSelective(DriverInsert driver) {

		List<Driver> list = new ArrayList<>();

		for (Driver driver2 : driver.getDrivers()) {
			if(isIDCard(driver2.getIdcard())){
				driver2.setId(RandomHelper.uuid());
				list.add(driver2);
			}else {
				return false;
			}
		}
		mapper.insertSelective(list);
		return true;
	}

	@Override
	public List<Driver> getAllDriverMsg() {

		return mapper.getAllDriverMsg();
	}

	@Override
	public Page<EnterprisethenVo> queryEnterprisePage(Pageable page,
			EnterprisethenVo enterprisethenVo,EmployeePermission employeePermission) {
		Page<EnterprisethenVo> pager = new PageImpl<EnterprisethenVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("id", enterprisethenVo.getId());
		params.put("etpNm", enterprisethenVo.getEtpnm());
		params.put("areaNm", enterprisethenVo.getAreaNm());
		params.put("ownerTraffic", enterprisethenVo.getOwnertraffic());
		params.put("ownerTransport", enterprisethenVo.getOwnertransport());
		params.put("empType", enterprisethenVo.getEmpType());
		params.put("etpCd", enterprisethenVo.getEtpcd());
		if(Const.ADMIN.equals(employeePermission.getEmployeeType())){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		if(Const.ETPUSER.equals(employeePermission.getEmployeeType())){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		params.put("list", employeePermission.getAreaList()!=null?employeePermission.getAreaList():null);
		
		List<EnterprisethenVo> list = mapper.queryEnterprisePage(params);

		for (EnterprisethenVo enter : list) {
			if(enter.getEtpType()==null){
				enter.setEtpType("其他");
			}else {
				enter.setEtpType(StringHelper.getChar(enter.getEtpType(),State.ENTERMAP));
			}

		}
		pager.setRecords(list);
		pager.setTotalRows(mapper.queryEnterprisePageCount(params));

		return pager;
	}

	@Override
	public Page<EssEmployee> queryEmpPage(Pageable page) {
		Page<EssEmployee> pager = new PageImpl<EssEmployee>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		pager.setRecords(mapper.seEmp(params));
		pager.setTotalRows(mapper.seEmpCount(params));
		return pager;
	}

	@Override
	public Page<vehiclesVo> queryVehiclespage(Pageable page, vehiclesVo vehiclesVo) {
		Page<vehiclesVo> pager = new PageImpl<vehiclesVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("orgNm", vehiclesVo.getOrgNm());
		params.put("etpNm", vehiclesVo.getEtpNm());
		params.put("vehiType", vehiclesVo.getVehiType());
		params.put("list", vehiclesVo.getQid());
		params.put("empType", vehiclesVo.getEmpType());
		params.put("id", vehiclesVo.getId());
		pager.setRecords(mapper.queryVehiclespage(params));
		pager.setTotalRows(mapper.queryVehiclespageCount(params));

		return pager;
	}

	@Override
	public List<PermiCarsVo> getAllpermiCar() {

		return mapper.getAllpermiCar();
	}

	@Override
	public List<VehicleCountVo> getVehiclesCount(VehicleCountVo countVo) {
		countVo.setVehiType("01");
		List<VehicleCountVo> count = mapper.getvehiCount(countVo);
		List<VehicleCountVo> bcount = mapper.getvehibCount(countVo);                                
		List<VehicleCountVo> wcount = mapper.getvehiwCount(countVo);  
		List<VehicleCountVo> ycount = mapper.getvehiyCount(countVo);  
		List<VehicleCountVo> list = new ArrayList<>();
		List<VehicleCountVo> vehilist = new ArrayList<>();
		List<VehicleCountVo> vehicCount = new ArrayList<>();

		lableB: 
			for (VehicleCountVo vehicleCountVo : count) {
				VehicleCountVo vehic = new VehicleCountVo();

				for (VehicleCountVo vehicount : bcount) {
					if (vehicleCountVo.getEtpNm().equals(vehicount.getEtpNm() )) {
						vehic.setId(vehicleCountVo.getId() );
						vehic.setEtpNm(vehicleCountVo.getEtpNm());
						vehic.setvCount(vehicleCountVo.getvCount());
						vehic.setOverCount( vehicount.getvCount());
						list.add(vehic); 
						continue lableB;
					}
				}
				vehic.setId(vehicleCountVo.getId() );
				vehic.setvCount(vehicleCountVo.getvCount());
				vehic.setEtpNm(vehicleCountVo.getEtpNm());
				vehic.setOverCount(0);
				list.add(vehic); 

			}
		out:
			for (VehicleCountVo vehicleCountVo : list) {
				VehicleCountVo vehic = new VehicleCountVo();

				for (VehicleCountVo vehicleCountVoyc : wcount) {
					if (vehicleCountVo.getEtpNm().equals(vehicleCountVoyc.getEtpNm() )) {
						vehic.setId(vehicleCountVo.getId() );
						vehic.setEtpNm(vehicleCountVo.getEtpNm());
						vehic.setIllicitCount( vehicleCountVoyc.getvCount() );
						vehic.setvCount( vehicleCountVo.getvCount());
						vehic.setOverCount(vehicleCountVo.getOverCount() );
						vehilist.add(vehic);
						continue out ;
					} 
				}
				vehic.setId(vehicleCountVo.getId() );
				vehic.setEtpNm(vehicleCountVo.getEtpNm());
				vehic.setIllicitCount(0);
				vehic.setvCount( vehicleCountVo.getvCount());
				vehic.setOverCount(vehicleCountVo.getOverCount() );
				vehilist.add(vehic);	

			}
			dnag:
				for (VehicleCountVo velc : vehilist) {
					VehicleCountVo vehics = new VehicleCountVo();

					for (VehicleCountVo ycountts : ycount) {
						if (velc.getEtpNm().equals(ycountts.getEtpNm() )) {
							vehics.setId(velc.getId() );
							vehics.setVehiType("大型车");
							vehics.setEtpNm( velc.getEtpNm());
							vehics.setvCount(velc.getvCount() );
							vehics.setOverCount(velc.getOverCount() );
							vehics.setIllicitCount(velc.getIllicitCount());
							vehics.setScraCount(ycountts.getvCount() );
							vehics.setzCount( velc.getvCount() - velc.getOverCount() );
							vehicCount.add(vehics);
							continue dnag;
						} 	 
					}
					vehics.setId(velc.getId() );
					vehics.setVehiType("大型车");
					vehics.setEtpNm(velc.getEtpNm());
					vehics.setvCount(velc.getvCount() );
					vehics.setOverCount(velc.getOverCount() );
					vehics.setIllicitCount(velc.getIllicitCount());
					vehics.setScraCount(0);
					vehics.setzCount( velc.getvCount() - velc.getOverCount() );
					vehicCount.add(vehics); 
				}

			return vehicCount;

	}
	public static boolean isIDCard(String idCard) {
		String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
				"(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
		return Pattern.matches(regularExpression, idCard);
	}

	@Override
	public List<VehicleCountVo> getVehiclesVehi(VehicleCountVo countVo) {
		countVo.setVehiType("02");
		List<VehicleCountVo> count = mapper.getvehiCount(countVo);
		List<VehicleCountVo> bcount = mapper.getvehibCount(countVo);                                
		List<VehicleCountVo> wcount = mapper.getvehiwCount(countVo);  
		List<VehicleCountVo> ycount = mapper.getvehiyCount(countVo);  
		List<VehicleCountVo> list = new ArrayList<>();
		List<VehicleCountVo> vehilist = new ArrayList<>();
		List<VehicleCountVo> vehicCount = new ArrayList<>();

		lableB: 
			for (VehicleCountVo vehicleCountVo : count) {
				VehicleCountVo vehic = new VehicleCountVo();

				for (VehicleCountVo vehicount : bcount) {
					if (vehicleCountVo.getEtpNm().equals(vehicount.getEtpNm() )) {
						vehic.setId(vehicleCountVo.getId());
						vehic.setEtpNm(vehicleCountVo.getEtpNm());
						vehic.setvCount(vehicleCountVo.getvCount());
						vehic.setOverCount( vehicount.getvCount());
						list.add(vehic); 
						continue lableB;
					}
				}
				vehic.setId(vehicleCountVo.getId());
				vehic.setvCount(vehicleCountVo.getvCount());
				vehic.setEtpNm(vehicleCountVo.getEtpNm());
				vehic.setOverCount(0);
				list.add(vehic); 

			}
		out:
			for (VehicleCountVo vehicleCountVo : list) {
				VehicleCountVo vehic = new VehicleCountVo();

				for (VehicleCountVo vehicleCountVoyc : wcount) {
					if (vehicleCountVo.getEtpNm().equals(vehicleCountVoyc.getEtpNm() )) {
						vehic.setId(vehicleCountVo.getId());
						vehic.setEtpNm(vehicleCountVo.getEtpNm());
						vehic.setIllicitCount( vehicleCountVoyc.getvCount() );
						vehic.setvCount( vehicleCountVo.getvCount());
						vehic.setOverCount(vehicleCountVo.getOverCount() );
						vehilist.add(vehic);
						continue out ;
					} 
				}
				vehic.setId(vehicleCountVo.getId());
				vehic.setEtpNm(vehicleCountVo.getEtpNm());
				vehic.setIllicitCount(0);
				vehic.setvCount( vehicleCountVo.getvCount());
				vehic.setOverCount(vehicleCountVo.getOverCount() );
				vehilist.add(vehic);	

			}
			dnag:
				for (VehicleCountVo velc : vehilist) {
					VehicleCountVo vehics = new VehicleCountVo();

					for (VehicleCountVo ycountts : ycount) {
						if (velc.getEtpNm().equals(ycountts.getEtpNm() )) {
							vehics.setId(velc.getId());
							vehics.setVehiType("小型车");
							vehics.setEtpNm( velc.getEtpNm());
							vehics.setvCount(velc.getvCount() );
							vehics.setOverCount(velc.getOverCount() );
							vehics.setIllicitCount(velc.getIllicitCount());
							vehics.setScraCount(ycountts.getvCount() );
							vehics.setzCount( velc.getvCount() - velc.getOverCount() );
							vehicCount.add(vehics);
							continue dnag;
						} 	 
					}
					vehics.setId(velc.getId());
					vehics.setVehiType("小型车");
					vehics.setEtpNm(velc.getEtpNm());
					vehics.setvCount(velc.getvCount() );
					vehics.setOverCount(velc.getOverCount() );
					vehics.setIllicitCount(velc.getIllicitCount());
					vehics.setScraCount(0);
					vehics.setzCount( velc.getvCount() - velc.getOverCount() );
					vehicCount.add(vehics); 
				}

			return vehicCount;

	}


}
