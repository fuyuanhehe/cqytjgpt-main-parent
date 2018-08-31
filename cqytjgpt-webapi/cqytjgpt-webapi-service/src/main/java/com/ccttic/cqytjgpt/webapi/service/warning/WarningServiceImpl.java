package com.ccttic.cqytjgpt.webapi.service.warning;

import com.ccttic.cqytjgpt.webapi.interfaces.organization.IOrganizationService;
import com.ccttic.cqytjgpt.webapi.interfaces.warning.IWarningService;
import com.ccttic.cqytjgpt.webapi.mapper.danger.DrDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.danger.VehiDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.organization.OrganizationMapper;
import com.ccttic.entity.danger.DangerEnums;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.DrDangerVo;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.role.Organization;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarningServiceImpl implements IWarningService {

	@javax.annotation.Resource
	private VehiDangerMapper mapper;
	@javax.annotation.Resource
	private DrDangerMapper drMapper;
	@Autowired
	private OrganizationMapper organizationMapper;
	@Autowired
	private IOrganizationService organizationService;

	@Override
	public Page<VehiDangerVo> qryVehicleList(Pageable page, VehiDangerVo ve, EmployeePermission employeePermission) throws AppException {
		Page<VehiDangerVo> pager = new PageImpl<VehiDangerVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		List<Organization> organizations = null;
		if(null!=employeePermission.getOrgId()) {
			organizations = organizationService.getOrgByTypeAndId(employeePermission.getOrgId(), employeePermission.getOrgType());
		}
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("enterpriseId",employeePermission.getEnterpriseId());
		params.put("list", organizations); // 组织集合
		params.put("areaId", ve.getAreaId());// 区域
		params.put("empType", employeePermission.getEmployeeType()); // 账号类型
		params.put("etpNm", ve.getOwnerenterprise());// 公司
		params.put("vehiNo", ve.getVehino()); // 车牌号
		params.put("dangertype", ve.getDangertype());// 预警等级
		params.put("correctstate", ve.getCorrectstate());// 整改进度
		params.put("scrappedState", ve.getScrappedstate() == 1 ? true : false);
		params.put("illicitState", ve.getIllicitstate() == 1 ? true : false);
		params.put("overdueExamineState", ve.getOverdueexaminestate() == 1 ? true : false);

		long totolRols = mapper.qryVehicleListCount(params);
		List<VehiDangerVo> records = mapper.qryVehicleList(params);
		if (1 == ve.getScrappedstate()) {
			for (VehiDangerVo record : records) {
				record.setOverdueexaminestate(null);
				record.setIllicitstate(null);
				record.setDangerdesc("逾期未报废");
				record.setDangertype(record.getScrappedstate().toString());
			}
		}
		if (1 == ve.getOverdueexaminestate()) {
			for (VehiDangerVo record : records) {
				record.setScrappedstate(null);
				record.setIllicitstate(null);
				record.setDangerdesc("逾期未检验");
				record.setDangertype(record.getOverdueexaminestate().toString());
			}
		}
		if (1 == ve.getIllicitstate()) {
			for (VehiDangerVo record : records) {
				record.setOverdueexaminestate(null);
				record.setScrappedstate(null);
				record.setDangerdesc("违法未处理");
				record.setDangertype(record.getIllicitstate().toString());
			}
		}
		for (VehiDangerVo vo : records) {
			if (DangerEnums.EXECUTING.getValue().equals(vo.getCorrectstate())) {
				vo.setCorrectstate(DangerEnums.EXECUTING.getText());
			} else if (DangerEnums.NORMAL.getValue().equals(vo.getCorrectstate())) {
				vo.setCorrectstate(DangerEnums.NORMAL.getText());
			} else if (DangerEnums.UNEXECUTED.getValue().equals(vo.getCorrectstate())) {
				vo.setCorrectstate(DangerEnums.UNEXECUTED.getText());
			}

		}
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	public VehiDangerVo qryOneVehicle(VehiDanger ve) throws AppException {
		return mapper.qryOneVehicle(ve);
	}

	@Override
	public Page<DrDangerVo> qryDriverList(Pageable page, DrDangerVo vo, EmployeePermission employeePermission) throws AppException {

		Page<DrDangerVo> pager = new PageImpl<DrDangerVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		List<Organization> organizations = null;
		if(null!=employeePermission.getOrgId()) {
			organizations = organizationService.getOrgByTypeAndId(employeePermission.getOrgId(), employeePermission.getOrgType());
		}
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("empType", employeePermission.getEmployeeType()); // 账号类型
		params.put("list", organizations); // 组织id
		params.put("driverName", null != vo.getDrivername() ? vo.getDrivername() : null);
		params.put("areaId", vo.getAreaCd());// 区域
		params.put("etpId", employeePermission.getEnterpriseId());// 公司
		params.put("etpNm", vo.getEtpNm());// 公司
		params.put("fullStudyState", vo.getFullstudystate() == 1 ? true : false);
		params.put("overdueExamineState", vo.getOverdueexaminestate() == 1 ? true : false);
		params.put("overdueProofState", vo.getOverdueproofstate() == 1 ? true : false);
		params.put("dangertype", vo.getDangertype());// 预警等级
		params.put("correctstate", vo.getCorrectstate());// 整改进度
		long totolRols = drMapper.qryDriverListCount(params);
		List<DrDangerVo> records = drMapper.qryDriverList(params);
		if (1 == vo.getFullstudystate()) {
			for (DrDangerVo record : records) {
				record.setOverdueexaminestate(null);
				record.setOverdueproofstate(null);
				record.setDangerdesc("满分学习");
				record.setDangertype(record.getFullstudystate().toString());
			}
		}
		if (1 == vo.getOverdueexaminestate()) {
			for (DrDangerVo record : records) {
				record.setOverdueproofstate(null);
				record.setFullstudystate(null);
				record.setDangerdesc("逾期未审验");
				record.setDangertype(record.getOverdueexaminestate().toString());
			}
		}
		if (1 == vo.getOverdueproofstate()) {
			for (DrDangerVo record : records) {
				record.setOverdueexaminestate(null);
				record.setFullstudystate(null);
				record.setDangerdesc("逾期未换证");
				record.setDangertype(record.getOverdueproofstate().toString());
			}
		}
		for (DrDangerVo drDangerVo : records) {
			if (DangerEnums.EXECUTING.getValue().equals(drDangerVo.getCorrectstate())) {
				drDangerVo.setCorrectstate(DangerEnums.EXECUTING.getText());
			} else if (DangerEnums.NORMAL.getValue().equals(drDangerVo.getCorrectstate())) {
				drDangerVo.setCorrectstate(DangerEnums.NORMAL.getText());
			} else if (DangerEnums.UNEXECUTED.getValue().equals(drDangerVo.getCorrectstate())) {
				drDangerVo.setCorrectstate(DangerEnums.UNEXECUTED.getText());
			}

		}
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	public DrDanger qryOneDriver(DrDanger dr) throws AppException {
		return drMapper.selectByPrimaryKey(dr.getId());
	}
}
