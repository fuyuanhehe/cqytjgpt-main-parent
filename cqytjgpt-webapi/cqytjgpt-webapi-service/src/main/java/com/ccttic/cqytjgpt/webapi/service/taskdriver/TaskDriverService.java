package com.ccttic.cqytjgpt.webapi.service.taskdriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.query.IPendingPaymentService;
import com.ccttic.cqytjgpt.webapi.interfaces.taskdriver.ITaskDriverService;
import com.ccttic.cqytjgpt.webapi.mapper.danger.DrDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.drillicit.DrIllicitMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverIllegal;
import com.ccttic.entity.illegal.DrIllicit;
import com.ccttic.entity.illegalprocess.XMLPendingPayment;

@Service
@Transactional
public class TaskDriverService implements ITaskDriverService {
	private Logger logger = LoggerFactory.getLogger(TaskDriverService.class);
	@Autowired
	private IPendingPaymentService service;
	@Autowired
	private DrIllicitMapper drIllicitMapper;
	@Autowired
	private EssEnterpriseMapper essEnterpriseMapper;
	@Autowired
	private DrDangerMapper drDangerMapper;

	@Override
	public Map<String, Object> getDriveIllega(DriverIllegal driver) throws Exception {
		Map<String, Object> result = new HashMap<>();
		DrIllicit dr = null;
		XMLPendingPayment pendingPayment = null;
		if (driver.getIdcard() != null || driver.getIdcard() != "") {
			pendingPayment = new XMLPendingPayment();
			pendingPayment.setJszh(driver.getIdcard());

			Map<String, Object> map = service.queryPendingPayment(pendingPayment, "04", "04Q03");
			@SuppressWarnings("unchecked")
			List<XMLPendingPayment> list = (List<XMLPendingPayment>) map.get("pendingpayment");
			logger.info(list.toString());

			if (driver.getDrIllicits() != null && driver.getDrIllicits().size() > 0) {
				for (int i = 0; i < driver.getDrIllicits().size(); i++) {
					int x = 0;
					for (int j = 0; j < list.size(); j++) {
						if (driver.getDrIllicits().get(i).getId().equals(list.get(j).getJdsbh())) {
							x++;
						}
					}
					if (x == 0) {
						dr = new DrIllicit();
						dr.setIsdeleted(true);
						dr.setId(driver.getDrIllicits().get(i).getId());
						drIllicitMapper.updateByPrimaryKeySelective(dr);
					}
				}
			}
			for (XMLPendingPayment xmlPendingPayment : list) {

				dr = new DrIllicit();
				dr.setId(xmlPendingPayment.getJdsbh());
				dr.setName(xmlPendingPayment.getDsr());
				dr.setIdcard(xmlPendingPayment.getJszh());
				dr.setVehino(xmlPendingPayment.getHphm());
				dr.setVehinotype(xmlPendingPayment.getHpzl());
				dr.setPermitcar(driver.getPermicar());
				dr.setMgrdepartareaid(driver.getMgrdepartareaid());
				dr.setMgrdepart(driver.getMgrdepart());
				dr.setDriverId(driver.getId());
				dr.setScoretotal(driver.getScoretotal());
				dr.setState(driver.getState());
				dr.setIllicittime(xmlPendingPayment.getWfsj());
				dr.setIllicitscore(xmlPendingPayment.getWfjfs());
				dr.setIllicitamount(xmlPendingPayment.getFkje());
				dr.setIllicitadress(xmlPendingPayment.getWfdz());
				dr.setIllicit(xmlPendingPayment.getWfxw());
				dr.setPickdepartmentdesc(xmlPendingPayment.getCljgmc());
				if (drIllicitMapper.selectByPrimaryKey(dr.getId()) != null) {
					result.put("update", dr);
					result.put("insert", null);
				} else {
					result.put("insert", dr);
					result.put("update", null);
				}
			}
		}
		return result;
	}

	@Override
	public Map<String, Object> getDriverDanger(Driver driver) throws Exception {
		Map<String, Object> result = new HashMap<>();
		DrDanger dr = new DrDanger();
		dr.setDriverId(driver.getId());
		dr.setId(driver.getIdcard());
		dr.setDrivername(driver.getName());
		dr.setDriveridcard(driver.getIdcard());
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		dr.setDangertime(sdf.format(new Date()));
		String enterpriseid = driver.getMgrenterpriseid();
		String orgNm = essEnterpriseMapper.selectOrgIdbyId(enterpriseid);
		dr.setOwnerorgid(orgNm);
		String[] strs = driver.getState().split(",");
		for (String string : strs) {
		dr.setIllicitstate("H".equals(string) ? 1 : 0);
		dr.setFailurestate("I".equals(string) ? 1 : 0);
		dr.setOverdueproofstate("M".equals(string) ? 1 : 0);
		dr.setOverdueexaminestate("S".equals(string) ? 1 : 0);
		}
		dr.setFullstudystate(0);
		if (dr.getIllicitstate() + dr.getFailurestate() + dr.getOverdueexaminestate() + dr.getOverdueproofstate()
				+ dr.getFullstudystate() == 0) {
			dr.setDangertype("0");
		} else if (dr.getIllicitstate() + dr.getFailurestate() + dr.getOverdueexaminestate() + dr.getOverdueproofstate()
				+ dr.getFullstudystate() == 1) {
			dr.setDangertype("3");
		} else if (dr.getIllicitstate() + dr.getFailurestate() + dr.getOverdueexaminestate() + dr.getOverdueproofstate()
				+ dr.getFullstudystate() == 2) {
			dr.setDangertype("2");
		} else {
			dr.setDangertype("1");
		}

		if (drDangerMapper.selectByPrimaryKey(driver.getIdcard()) != null) {
			result.put("update", dr);
			result.put("insert", null);
		} else {
			result.put("insert", dr);
			result.put("update", null);
		}
		return result;
	}
}
