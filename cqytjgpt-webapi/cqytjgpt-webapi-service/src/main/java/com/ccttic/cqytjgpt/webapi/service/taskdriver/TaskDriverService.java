package com.ccttic.cqytjgpt.webapi.service.taskdriver;

import com.ccttic.cqytjgpt.webapi.interfaces.query.IPendingPaymentService;
import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryPersonService;
import com.ccttic.cqytjgpt.webapi.interfaces.taskdriver.ITaskDriverService;
import com.ccttic.cqytjgpt.webapi.mapper.danger.DrDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.drillicit.DrIllicitMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.cqytjgpt.webapi.mapper.organization.OrganizationMapper;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.XMLDriver;
import com.ccttic.entity.drivers.vo.DriverIllegal;
import com.ccttic.entity.illegal.DrIllicit;
import com.ccttic.entity.illegalprocess.XMLPendingPayment;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.web.CCtticWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class TaskDriverService implements ITaskDriverService {
	private Logger logger = LoggerFactory.getLogger(TaskDriverService.class);
	@Resource
	private IPendingPaymentService service;
	@Resource
	private DrIllicitMapper drIllicitMapper;
	@Resource
	private EssEnterpriseMapper essEnterpriseMapper;
	@Resource
	private DrDangerMapper drDangerMapper;
	@Resource
	private OrganizationMapper organizationMapper;
	@Resource
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
				String str = null;
				for (int i = 0; i < driver.getDrIllicits().size(); i++) {
					int x = 0;
					for (int j = 0; j < list.size(); j++) {
						str = driver.getDrIllicits().get(i).getId().substring(Const.ZERO, Const.XHlength);
						if (str.equals(list.get(j).getJdsbh())) {
							x++;
						}
					}
					if (x == 0) {
						drIllicitMapper.deleteByPrimaryKey(driver.getDrIllicits().get(i).getId());
					}
				}
			}
			List<DrIllicit> update = new ArrayList<>();
			List<DrIllicit> insert = new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
			for (XMLPendingPayment xmlPendingPayment : list) {

				dr = new DrIllicit();
				dr.setId(xmlPendingPayment.getJdsbh() + sdf.format(new Date()));
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
		List<Integer> sortList = new ArrayList<>();
		int overdueproofDays = 0, overdueexaineDays = 0, fullStudyDays = 0;
		int overdueproofRank = 0, overdueexaineRank = 0, fullStudyRank = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (null != driver.getEffectendtime()) {
			Date effectendtime = simpleDateFormat.parse(driver.getEffectendtime());
			result = CCtticWebUtils.getDateSpace(new Date(), effectendtime, "driver");
			overdueproofRank = (int) result.get("rank");
			sortList.add(overdueproofRank);
			dr.setOverdueproofstate(overdueproofRank);
			overdueproofDays = (int) result.get("days");
			dr.setOverDueproofDays(overdueproofDays);
		} else {
			dr.setOverdueproofstate(null);
		}
		if (null != driver.getExamineeffectendtime()) {
			Date examineeffectendtime = simpleDateFormat.parse(driver.getExamineeffectendtime());
			result = CCtticWebUtils.getDateSpace(new Date(), examineeffectendtime, "driver");
			overdueexaineRank = (int) result.get("rank");
			sortList.add(overdueexaineRank);
			dr.setOverdueexaminestate(overdueexaineRank);
			overdueexaineDays = (int) result.get("days");
			dr.setOverDueexamineDays(overdueexaineDays);
		} else {
			dr.setOverdueexaminestate(null);
		}
		dr.setDriverId(driver.getId());
		dr.setId(driver.getIdcard());
		dr.setDrivername(driver.getName());
		dr.setDriveridcard(driver.getIdcard());
		if(null != driver.getMgrdepartareaid()) {
			Organization org = organizationMapper.getOrgIdByAreaId(driver.getMgrdepartareaid());
			if (null != org) {
				dr.setOwnerorgid(org.getId());
				dr.setOwnergener(org.getOrgNm());
			}
		}
		simpleDateFormat = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		dr.setDangertime(simpleDateFormat.format(new Date()));
//		String enterpriseId = driver.getMgrenterpriseid();
//		Organization org = organizationMapper.findOrgByEptId(enterpriseId);
//		if (org != null) {
//			dr.setOwnergener(org.getId());
//		}
		dr.setFullstudystate(0);
		dr.setFullStudyDays(fullStudyDays);
		if (null == dr.getOverdueproofstate() || null == dr.getOverdueexaminestate() || null == dr.getFullstudystate()) {
			dr.setDangertype(null);
		}

		Collections.sort(sortList);
		for (int i = 0; i < sortList.size(); i++) {
			if (sortList.get(i) != 0 && i != (sortList.size() - 1)) {
				dr.setDangertype(sortList.get(i).toString());
				break;
			}
			if (i == (sortList.size() - 1)) {
				dr.setDangertype(sortList.get(i).toString());
			}
		}
		sortList.clear();
		sortList.add(overdueexaineDays);
		sortList.add(overdueproofDays);
		Collections.sort(sortList);
		dr.setCorrecttime(sortList.get(0).toString());
		if (drDangerMapper.selectByPrimaryKey(driver.getIdcard()) !=null) {
			drDangerMapper.updateByPrimaryKeySelective(dr);
		} else {
			drDangerMapper.insertSelective(dr);
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
