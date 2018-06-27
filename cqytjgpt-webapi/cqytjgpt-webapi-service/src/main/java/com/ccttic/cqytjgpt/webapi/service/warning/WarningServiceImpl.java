package com.ccttic.cqytjgpt.webapi.service.warning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.warning.IWarningservice;
import com.ccttic.cqytjgpt.webapi.mapper.danger.VehiDangerMapper;
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
	@Override
	public Page<VehiDanger> qryVehicleList(Pageable page, VehiDangerVo ve) throws AppException {
		Page<VehiDanger> pager = new PageImpl<VehiDanger>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("list", ve.getList()); // 企业id
		params.put("areaId", ve.getAreaId());// 区域
		params.put("ownerenterprise", ve.getOwnerenterprise());// 公司
		params.put("vehiNo", ve.getVehino()); // 车牌号
		params.put("dangertype", ve.getDangertype());// 预警等级
		params.put("correctstate", ve.getCorrectstate());// 整改进度
		long totolRols = mapper.qryVehicleListCount(params);
		List<VehiDanger> records = mapper.qryVehicleList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	public VehiDanger qryOneVehicle(VehiDanger ve) throws AppException {
		return mapper.qryOneVehicle(ve);
	}

}
