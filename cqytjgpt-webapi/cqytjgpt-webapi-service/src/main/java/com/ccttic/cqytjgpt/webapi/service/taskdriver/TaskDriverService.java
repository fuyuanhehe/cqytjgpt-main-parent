package com.ccttic.cqytjgpt.webapi.service.taskdriver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryPersonService;
import com.ccttic.cqytjgpt.webapi.interfaces.taskdriver.ITaskDriverService;
import com.ccttic.cqytjgpt.webapi.mapper.danger.DrDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.drillicit.DrIllicitMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.cqytjgpt.webapi.mapper.organization.OrganizationMapper;
import com.ccttic.entity.danger.DangerEnums;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.XMLDriver;
import com.ccttic.entity.drivers.vo.DriverIllegal;
import com.ccttic.entity.illegal.DrIllicit;
import com.ccttic.entity.illegal.DrIllicitExample;
import com.ccttic.entity.illegalprocess.XMLPendingPayment;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.common.Const;

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
	@Autowired
	private OrganizationMapper organizationMapper;
	@Autowired
	private IQueryPersonService queryPersonService;

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
				String str=null;
				for (int i = 0; i < driver.getDrIllicits().size(); i++) {
					int x = 0;
					for (int j = 0; j < list.size(); j++) {
						str =driver.getDrIllicits().get(i).getId().substring(Const.ZERO, Const.XHlength);
						if (str.equals(list.get(j).getJdsbh())) {
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
			List<DrIllicit> update = new ArrayList<>();
			List<DrIllicit> insert = new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
			for (XMLPendingPayment xmlPendingPayment : list) {

				dr = new DrIllicit();
				dr.setId(xmlPendingPayment.getJdsbh()+sdf.format(new Date()));
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
					update.add(dr);

				} else {
					insert.add(dr);

				}
			}
			result.put("update", update.size() > 0 ? update : null);
			result.put("insert", insert.size() > 0 ? insert : null);
		}
		return result;
	}

	@Override
	public Map<String, Object> getDriverDanger(Driver driver) throws Exception {
		Map<String, Object> result = new HashMap<>();
		DrDanger dr = new DrDanger();

		XMLPendingPayment pendingPayment = new XMLPendingPayment();
		pendingPayment.setJszh(driver.getIdcard());
		Map<String, Object> map = service.queryPendingPayment(pendingPayment, "04", "04Q03");
		@SuppressWarnings("unchecked")
		List<XMLPendingPayment> listdoing = (List<XMLPendingPayment>) map.get("pendingpayment");

		DrIllicitExample example = new DrIllicitExample();
		example.createCriteria().andIdcardEqualTo(driver.getIdcard());

		List<DrIllicit> listwait = drIllicitMapper.selectByExample(example);

		if (listwait.size() == 0 && listdoing.size() == 0) {
			dr.setCorrectstate(DangerEnums.NORMAL.getValue());
		} else if (listdoing.size() > 0 && listdoing.size() != 0) {
			dr.setCorrectstate(DangerEnums.EXECUTING.getValue());
		} else if (listwait.size() > 0 && listdoing.size() == 0) {
			dr.setCorrectstate(DangerEnums.UNEXECUTED.getValue());
		}

		dr.setDriverId(driver.getId());
		dr.setId(driver.getIdcard());
		dr.setDrivername(driver.getName());
		dr.setDriveridcard(driver.getIdcard());
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		dr.setDangertime(sdf.format(new Date()));
		String enterpriseid = driver.getMgrenterpriseid();
		Organization org = organizationMapper.findOrgByEptId(enterpriseid);
		String orgNm = essEnterpriseMapper.selectOrgIdbyId(enterpriseid);
		dr.setOwnerorgid(orgNm);
		if (org != null) {
			dr.setOwnergener(org.getOrgNm());
		}
		String[] strs = driver.getState().split(",");
		for (String string : strs) {
			if (dr.getIllicitstate() == null || dr.getIllicitstate() != 1) {
				dr.setIllicitstate("H".equals(string) ? 1 : 0);
			}
			if (dr.getFailurestate() == null || dr.getFailurestate() != 1) {
				dr.setFailurestate("I".equals(string) ? 1 : 0);
			}
			if (dr.getOverdueproofstate() == null || dr.getOverdueproofstate() != 1) {
				dr.setOverdueproofstate("M".equals(string) ? 1 : 0);
			}
			if (dr.getOverdueexaminestate() == null || dr.getOverdueexaminestate() != 1) {
				dr.setOverdueexaminestate("S".equals(string) ? 1 : 0);
			}
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

	public Driver updateDriver(Driver driver) throws Exception {

		XMLDriver xmldr = queryPersonService.QueryPersonByIDCard(driver.getIdcard());
		driver.setEffectendtime(xmldr != null ? xmldr.getYxqz() : null);
		driver.setPermicar(xmldr != null ? xmldr.getZjcx() : null);
		String str = "";
		if (xmldr != null) {
			char[] state = xmldr.getZt().toCharArray();
			for (int i = 0; i < state.length; i++) {
				if (i != 0) {
					str = str + ",";
				}
				str = str + state[i];

			}
		}
		driver.setState(str != "" ? str : null);

		return driver;

	}

}
