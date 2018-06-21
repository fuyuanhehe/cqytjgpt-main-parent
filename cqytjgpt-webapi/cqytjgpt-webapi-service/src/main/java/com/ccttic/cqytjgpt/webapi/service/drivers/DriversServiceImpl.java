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
import com.ccttic.entity.drivers.vo.DriverVo;
import com.ccttic.entity.drivers.vo.DriverillicitVo;
import com.ccttic.entity.drivers.vo.EnterprisethenVo;
import com.ccttic.util.common.ObjectHelper;
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
		String ids = driverVo.getId();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("etpNm", driverVo.getEtpNm());
		params.put("areaNm", driverVo.getAreaNm());
		params.put("name", driverVo.getName());
		params.put("idcard", driverVo.getIdcard());
		params.put("permicar", driverVo.getPermicar());
		params.put("id", ids);
		params.put("fiString", driverVo.getFiString());
		params.put("laString", driverVo.getLaString());
		params.put("fistShString", driverVo.getFistShString());
		params.put("laShString", driverVo.getLaShString());
		List<DriverVo> data = mapper.seDriverPage(params);
		if(ObjectHelper.isEmpty(ids)){
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
		}    

		pager.setTotalRows( mapper.sePageCount(params));
		pager.setRecords(data);

		return pager;
	}

	@Override
	public DriverillicitVo seDrillicitByDriverId(String driverid) {
		// TODO Auto-generated method stub
		return mapper.seDrillicitByDriverId(driverid);
	}

	@Override
	public Page<DriverillicitVo> getDriverPages(Pageable page, DriverillicitVo driver) {
		Page<DriverillicitVo> pager = new PageImpl<DriverillicitVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("driverid", driver.getId());
		params.put("name", driver.getName());
		params.put("etpNm", driver.getEtpNm());
		params.put("areaNm", driver.getAreaNm());
		params.put("illicitadress", driver.getIllicitadress());
		params.put("illicit", driver.getIllicit());
		params.put("fiString", driver.getFiString());
		params.put("laString", driver.getLaString());
		List<DriverillicitVo> data = mapper.seDr_illicitPages(params);
		long count = mapper.getDriverPageCount(params);

		pager.setRecords(data);
		pager.setTotalRows(count);

		return pager;
	}


	@Override
	@Transactional
	public void insertSelective(List<Driver> driver) {
		for (Driver driver2 : driver) {
			driver2.setId(RandomHelper.uuid());
		}
		mapper.insertSelective(driver);

	}

	@Override
	public List<Driver> getAllDriver() {

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
        pager.setRecords(mapper.queryEnterprisePage(params));
		pager.setTotalRows(mapper.queryEnterprisePageCount(params));
		
		return pager;
	}
}
