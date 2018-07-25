package com.ccttic.cqytjgpt.webapi.service.drivers;

import com.ccttic.cqytjgpt.webapi.interfaces.drivers.DriversService;
import com.ccttic.cqytjgpt.webapi.mapper.drivers.DriverMapper;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.*;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.util.common.DateHelper;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.activation.DataHandler;

@Service
public class DriversServiceImpl implements DriversService {

	@Autowired
	private DriverMapper mapper;

	@Override
	public Page<DriverVo> seDriverPage(Pageable page, DriverVo driverVo) {
		Page<DriverVo> pager = new PageImpl<DriverVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("etpNm", driverVo.getEtpNm());
		params.put("areaNm", driverVo.getAreaNm());
		params.put("name", driverVo.getName());
		params.put("idcard", driverVo.getIdcard());
		params.put("permicar", driverVo.getPermicar());
		params.put("id", driverVo.getId() );
		params.put("fiString", driverVo.getFiString());
		params.put("laString", driverVo.getLaString());
		params.put("fistShString", driverVo.getFistShString());
		params.put("laShString", driverVo.getLaShString());
		params.put("mobilephone", driverVo.getMobilephone());
		params.put("list", driverVo.getQid());
		params.put("empType", driverVo.getEmpType()); // 账号类型

		List<DriverVo> List = mapper.seDriverPage(params);
		for (DriverVo driverVo2 : List) {

			driverVo2.setFirstrecivetime(DateHelper.getDataString(driverVo2.getFirstrecivetime()));

			driverVo2.setNextexaminetime(DateHelper.getDataString(driverVo2.getNextexaminetime()));	

			driverVo2.setEffectstarttime(DateHelper.getDataString(driverVo2.getEffectstarttime()));

			driverVo2.setEffectendtime(DateHelper.getDataString(driverVo2.getEffectendtime()));

			driverVo2.setExamineeffectendtime(DateHelper.getDataString(driverVo2.getExamineeffectendtime()));
		}


		pager.setRecords(List);
		pager.setTotalRows( mapper.sePageCount(params));


		return pager;
	}

	@Override
	public Page<DriverillicitVo> seDrillicitByDriverId(Pageable page,DriverVo driver) {
		Page<DriverillicitVo> pager = new PageImpl<DriverillicitVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("idcard", driver.getIdcard());
		params.put("list", driver.getQid());
		params.put("empType", driver.getEmpType()); // 账号类型
		pager.setRecords( mapper.seDrillicitByDriverId(params));
		pager.setTotalRows(mapper.seDrillicitByDriverIdCount(params));

		return pager;
	}

	@Override
	public Page<DriverillicitVo> getDriverPages(Pageable page, DriverillicitVo driver) {
		Page<DriverillicitVo> pager = new PageImpl<DriverillicitVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("id", driver.getId());
		params.put("name", driver.getName());
		params.put("etpNm", driver.getEtpNm());
		params.put("areaNm", driver.getAreaNm());
		params.put("illicitadress", driver.getIllicitadress());
		params.put("illicit", driver.getIllicit());
		params.put("fiString", driver.getFiString());
		params.put("laString", driver.getLaString());
		params.put("list", driver.getQid());
		params.put("empType", driver.getEmpType()); // 账号类型

		if(driver.getFiString()!=null){
			if(  !(driver.getFiString().equals(""))){
				String year = driver.getFiString().substring(0, 4) ;
				params.put("dring", "vehi_dr_illicit"+year);
			}else {
				params.put("dring", "vehi_dr_illicit"+driver.getYears());
			}
		}else {
			params.put("dring", "vehi_dr_illicit"+driver.getYears());
		}

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
			EnterprisethenVo enterprisethenVo) {
		Page<EnterprisethenVo> pager = new PageImpl<EnterprisethenVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("id", enterprisethenVo.getId());
		params.put("etpNm", enterprisethenVo.getEtpnm());
		params.put("areaNm", enterprisethenVo.getAreaNm());
		params.put("ownerTraffic", enterprisethenVo.getOwnertraffic());
		params.put("ownerTransport", enterprisethenVo.getOwnertransport());
		params.put("list", enterprisethenVo.getQid());
		params.put("empType", enterprisethenVo.getEmpType());
		params.put("etpCd", enterprisethenVo.getEtpcd());

		pager.setRecords(mapper.queryEnterprisePage(params));
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
