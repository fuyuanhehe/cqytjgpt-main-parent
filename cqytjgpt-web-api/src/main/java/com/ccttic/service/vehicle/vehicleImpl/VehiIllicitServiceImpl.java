package com.ccttic.service.vehicle.vehicleImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccttic.entity.common.exception.AppException;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.mapper.vehicle.VehiIllicitMapper;
import com.ccttic.service.vehicle.IVehiIllicitService;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
@Service
public class VehiIllicitServiceImpl implements IVehiIllicitService{

	@Resource
	private VehiIllicitMapper mapper;
	@Override
	public Page<VehiIllicit> qryVehiIllicitList(Pageable page, VehiIllicit vehiIllicit, String entId) throws AppException {
		Page<VehiIllicit> pager = new PageImpl<VehiIllicit>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("entId", entId);
		params.put("mgrDepartAreaId", vehiIllicit.getMgrDepartAreaId()); // 区域编码
		params.put("vehiNo", vehiIllicit.getVehiNo()); // 车牌号
		params.put("ownership", vehiIllicit.getOwnership()); // 车所属企业
		params.put("illicit", vehiIllicit.getIllicit()); // 违法行为
		params.put("state", vehiIllicit.getState()); // 处罚状态
		params.put("vehiNoType", vehiIllicit.getVehiNoType()); // 号牌种类
		params.put("pickDepartmentDesc", vehiIllicit.getPickDepartmentDesc()); // 采集机关名称
		params.put("startTime", vehiIllicit.getStartTime()); // 违法开始时间
		params.put("endTime", vehiIllicit.getPickDepartmentDesc()); // 违法结束时间
		
		long totolRols = mapper.qryVehiIllicitListCount(params);
		List<VehiIllicit> records = mapper.qryVehiIllicitList(params);

		pager.setTotalRows(totolRols);
		pager.setRecords(records);

		return pager;
	}

	@Override
	public VehiIllicit qryOneVehiIllicit(Map<String, Object> params) throws AppException {
		return mapper.qryOneVehiIllicit(params);
	}

}