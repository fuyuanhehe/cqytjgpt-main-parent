package com.ccttic.cqytjgpt.webapi.service.taskdriver;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.ccttic.entity.illegal.DrIllicit;
import com.ccttic.entity.illegal.DrIllicitExample;
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
	public void addDriveIllega(Driver driver) throws Exception {
		DrIllicit dr = null;
		XMLPendingPayment pendingPayment = null;
		if (driver.getIdcard() != null || driver.getIdcard() != "") {
			pendingPayment = new XMLPendingPayment();
			pendingPayment.setJszh(driver.getIdcard());

			Map<String, Object> map = service.queryPendingPayment(pendingPayment, "04", "04Q03");
			@SuppressWarnings("unchecked")
			List<XMLPendingPayment> list = (List<XMLPendingPayment>) map.get("pendingpayment");
			logger.info(list.toString());
			DrIllicitExample example = new DrIllicitExample();
			example.createCriteria().andIdcardEqualTo(driver.getIdcard());
			List<DrIllicit> DrIllicit = drIllicitMapper.selectByExample(example);
			for (int i = 0; i < DrIllicit.size(); i++) {
				int x = 0;
				for (int j = 0; j < list.size(); j++) {
					if (DrIllicit.get(i).getId().equals(list.get(j).getJdsbh())) {
						x++;
					}
				}
				if (x == 0) {
					drIllicitMapper.deleteByPrimaryKey(DrIllicit.get(i).getId());
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
					drIllicitMapper.updateByPrimaryKeySelective(dr);
				} else {
					drIllicitMapper.insertSelective(dr);
				}
			}
		}
	}

	@Override
	public void addDriverDanger(Driver driver) throws Exception {
		DrDanger dr = new DrDanger();
		dr.setId(driver.getIdcard());
		dr.setDrivername(driver.getName());
		dr.setDriveridcard(driver.getIdcard());
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		dr.setDangertime(sdf.format(new Date()));
		String enterpriseid = driver.getMgrenterpriseid();
		String orgNm = essEnterpriseMapper.selectOrgNmbyId(enterpriseid);
		dr.setOwnerorgid(orgNm);
		dr.setIllicitstate("H".equals(driver.getState()) ? 1 : 0);
		dr.setFailurestate("I".equals(driver.getState()) ? 1 : 0);
		dr.setOverdueproofstate("M".equals(driver.getState()) ? 1 : 0);
		dr.setOverdueexaminestate("S".equals(driver.getState())  ? 1 : 0);
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
			drDangerMapper.updateByPrimaryKey(dr);
		} else {
			drDangerMapper.insertSelective(dr);
		}
	}
}
