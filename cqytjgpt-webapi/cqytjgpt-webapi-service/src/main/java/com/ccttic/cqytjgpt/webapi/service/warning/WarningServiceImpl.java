package com.ccttic.cqytjgpt.webapi.service.warning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.warning.IWarningservice;
import com.ccttic.cqytjgpt.webapi.mapper.danger.DrDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.danger.VehiDangerMapper;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.DrDangerVo;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
@Service
public class WarningServiceImpl implements IWarningservice{
	@Autowired
	private VehiDangerMapper mapper;
	@Autowired
	private DrDangerMapper drMapper;
	@Override
	public Page<VehiDangerVo> qryVehicleList(Pageable page, VehiDangerVo ve) throws AppException {
		Page<VehiDangerVo> pager = new PageImpl<VehiDangerVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("list", ve.getList()); // 企业id
		params.put("areaId", ve.getAreaId());// 区域
		params.put("empType", ve.getEmpType()); // 账号类型
		params.put("ownerenterprise", ve.getOwnerenterprise());// 公司
		params.put("vehiNo", ve.getVehino()); // 车牌号
		params.put("dangertype", ve.getDangertype());// 预警等级
		params.put("correctstate", ve.getCorrectstate());// 整改进度
		params.put("scrappedState", ve.getScrappedstate()==1?true:false);
		params.put("illicitState", ve.getIllicitstate()==1?true:false);
		params.put("failureState", ve.getFailurestate()==1?true:false);
		params.put("overdueExamineState", ve.getOverdueexaminestate()==1?true:false);
		long totolRols = mapper.qryVehicleListCount(params);
		List<VehiDangerVo> records = mapper.qryVehicleList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	public VehiDanger qryOneVehicle(VehiDanger ve) throws AppException {
		return mapper.qryOneVehicle(ve);
	}

	@Override
	public Page<DrDangerVo> qryDriverList(Pageable page, DrDangerVo vo) throws AppException {

		Page<DrDangerVo> pager = new PageImpl<DrDangerVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("empType", vo.getEmpType()); // 账号类型
		params.put("list", vo.getList()); // 企业id
		params.put("areaId", vo.getAreaId());// 区域
		params.put("ownerenterprise", vo.getOwnerenterprise());// 公司
		params.put("fullStudyState", vo.getFullstudystate()==1?true:false);
		params.put("illicitState", vo.getIllicitstate()==1?true:false);
		params.put("failureState", vo.getFailurestate()==1?true:false);
		params.put("overdueProofState", vo.getOverdueproofstate()==1?true:false);
		params.put("dangertype", vo.getDangertype());// 预警等级
		params.put("correctstate", vo.getCorrectstate());// 整改进度
		long totolRols = drMapper.qryDriverListCount(params);
		List<DrDangerVo> records = drMapper.qryDriverList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	public DrDanger qryOneDriver(DrDanger dr) throws AppException {		
		return drMapper.selectByPrimaryKey(dr.getId());
	}

}
