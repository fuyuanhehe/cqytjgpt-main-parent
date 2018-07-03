package com.ccttic.cqytjgpt.webapi.service.drivers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ccttic.cqytjgpt.webapi.interfaces.drivers.DriversService;
import com.ccttic.cqytjgpt.webapi.mapper.drivers.DriverMapper;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverIllegal;
import com.ccttic.entity.drivers.vo.DriverInsert;
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.entity.drivers.vo.EnterprisethenVo;
import com.ccttic.entity.drivers.vo.PermiCarsVo;
import com.ccttic.entity.drivers.vo.VehicleCountVo;
import com.ccttic.entity.drivers.vo.vehiclesVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

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
		params.put("list", driverVo.getQid());
		params.put("empType", driverVo.getEmpType()); // 账号类型
		List<DriverVo> data = mapper.seDriverPage(params);
		/*		if(ObjectHelper.isEmpty(ids)){
			List<DriverVo> list = new ArrayList<>();   	   
			for (DriverVo driver : data) {
				driver.setAdress("");
				driver.setMgrdepart("");
				driver.setTelphone("");
				driver.setScoretotal("");
				driver.setExamineeffectendtime("");
				driver.setEffectendtime("");
				driver.setEffectstarttime("");
				list.add(driver);
			}
			pager.setTotalRows( mapper.sePageCount(params));
			pager.setRecords(list);
		}  */  

		pager.setTotalRows( mapper.sePageCount(params));
		pager.setRecords(data);

		return pager;
	}

	@Override
	public Page<DriverillicitVo> seDrillicitByDriverId(Pageable page,DriverVo driver) {
		Page<DriverillicitVo> pager = new PageImpl<DriverillicitVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("id", driver.getId());
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
		List<DriverillicitVo> data = mapper.seDr_illicitPages(params);
		long count = mapper.getDriverPageCount(params);

		pager.setRecords(data);
		pager.setTotalRows(count);

		return pager;
	}


	@Override
	@Transactional
	public void insertSelective(DriverInsert driver) {

		List<Driver> list = new ArrayList<>();
		for (Driver driver2 : driver.getDrivers()) {
			driver2.setId(RandomHelper.uuid());
			list.add(driver2);
		}

		mapper.insertSelective(list);

	}

	@Override
	public List<DriverIllegal> getAllDriver() {

		return mapper.selectAllDriver();
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
		params.put("ownerTraffic", enterprisethenVo.getOwnertraffic());
		params.put("ownerTransport", enterprisethenVo.getOwnertransport());
		params.put("list", enterprisethenVo.getQid());
		params.put("empType", enterprisethenVo.getEmpType());
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
		pager.setRecords(mapper.queryVehiclespage(params));
		pager.setTotalRows(mapper.queryVehiclespageCount(params));

		return pager;
	}

	@Override
	public List<List<VehicleCountVo>> getvehiclesCount(vehiclesVo vehiclesVo) {
		List<vehiclesVo> data = mapper.getvehiclesCount(vehiclesVo); 

		List<List<VehicleCountVo>> lists = new ArrayList<>();

		String empNm = "";
		List<vehiclesVo> vehi = new ArrayList<>();
		int count = 0;
		for (vehiclesVo model : data) {
			if(count==0){ 
				empNm = model.getEtpNm();
				vehi.add(model);  
				count++;      
				continue;
			}
			if(empNm.equals(model.getEtpNm()) ){
				vehi.add(model);
				continue;
			}
			empNm = model.getEtpNm();
			try {
				lists.add( getHiStory(vehi)  )	;
			} catch (Exception e) {
				e.printStackTrace();
			}
			vehi.clear();

		}

		return lists;
	}

	public static List<VehicleCountVo> getHiStory(List<vehiclesVo> list)throws Exception{
		List<VehicleCountVo> vehilist = new ArrayList<>();
		List<vehiclesVo> arrs = new ArrayList<>();
		List<vehiclesVo> arrstwo = new ArrayList<>();
		for (vehiclesVo vehi : list) {
			if(vehi.getVehiType().equals("1")  || vehi.getVehiType().equals("01")){
				arrs.add(vehi);
				continue;
			}
			arrstwo.add(vehi);
		}   
		int ints = 0;
		Integer vCount = 0;     //总数量
		Integer scraCount = 0; //报废车辆
		Integer overCount = 0 ; // 逾期
		Integer illicitCount = 0 ; //违法未处理
		VehicleCountVo  vahic = new VehicleCountVo();//车辆数目
		for (vehiclesVo vehiclesVo : arrs) {
			vCount ++; ints++;
			if(vehiclesVo.getOverdueExamineState()==1 //逾期   
					){ overCount ++; }
			if(vehiclesVo.getScrappedState()==1 //报废
					){ scraCount ++; }
			if(vehiclesVo.getIllicitState()==1 //违法
					){ illicitCount ++; } 
			if(ints ==arrs.size()){ 
				vahic.setEtpNm( vehiclesVo.getEtpNm()); 
				vahic.setType( vehiclesVo.getVehiType()); 
			}
		}  
		vahic.setvCount(vCount);
		vahic.setzCount(vCount-scraCount);
		vahic.setScraCount(overCount);
		vahic.setOverCount(scraCount);
		vahic.setIllicitCount(illicitCount);
		// 循环下一个
		int intss = 0;
		Integer vCounts = 0;     //总数量
		Integer scraCounts = 0; //报废车辆
		Integer overCounts = 0 ; // 逾期
		Integer illicitCounts = 0 ; //违法未处理
		VehicleCountVo  vahics = new VehicleCountVo();//车辆数目
		for (vehiclesVo vehiclesVo : arrstwo) {
			vCounts ++; intss++;
			if(vehiclesVo.getOverdueExamineState()==1 //逾期   
					){ overCounts ++; }
			if(vehiclesVo.getScrappedState()==1 //报废
					){ scraCounts ++; }
			if(vehiclesVo.getIllicitState()==1 //违法
					){ illicitCounts ++; } 
			if(intss ==arrs.size()){ 
				vahics.setEtpNm( vehiclesVo.getEtpNm()); 
				vahics.setType( vehiclesVo.getVehiType()); 
			}
		}
		vahics.setvCount(vCounts);
		vahics.setzCount(vCounts-scraCounts);
		vahics.setScraCount(overCounts);
		vahics.setOverCount(scraCounts);
		vahics.setIllicitCount(illicitCounts);

		vehilist.add(vahic);
		vehilist.add(vahics);

		return vehilist;
	}

	@Override
	public List<PermiCarsVo> getAllpermiCar() {
		return mapper.getAllpermiCar();
	}


}
