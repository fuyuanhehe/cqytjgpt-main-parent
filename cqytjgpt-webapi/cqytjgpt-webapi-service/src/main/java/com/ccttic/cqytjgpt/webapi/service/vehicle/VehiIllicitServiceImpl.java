package com.ccttic.cqytjgpt.webapi.service.vehicle;

import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehiIllicitService;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehiIllicitMapper;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehiIllicitServiceImpl implements IVehiIllicitService {

	@Resource
	private VehiIllicitMapper mapper;

	@Override
	public Page<VehiIllicit> qryVehiIllicitList(Pageable page, VehiIllicit vehiIllicit, List<String> list) throws AppException {
		Page<VehiIllicit> pager = new PageImpl<VehiIllicit>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(new Date());
		String endDate = formatter.format(calendar.getTime());// 当前时间
		int year = calendar.get(Calendar.YEAR);
		// 要查询数据为当前时间往后推36个月的数据，所以固定查询当前年份后面的4张表
		String tableNmae1 = "vehi_dr_illicit"+year;
		String tableNmae2 = "vehi_dr_illicit"+(year-1);
		String tableNmae3 = "vehi_dr_illicit"+(year-2);
		String tableNmae4 = "vehi_dr_illicit"+(year-3);
		calendar.add(calendar.MONTH, -36); 
		String startDate = formatter.format(calendar.getTime());// 后推36个月后的时间
		List<String> tableList = new ArrayList<String>();
		tableList.add(tableNmae1);
		tableList.add(tableNmae2);
		tableList.add(tableNmae3);
		tableList.add(tableNmae4);
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("list", list);
		params.put("mgrDepartAreaId", vehiIllicit.getMgrDepartAreaId()); // 区域编码
		params.put("vehiNo", vehiIllicit.getVehiNo()); // 车牌号
		params.put("etpNm", vehiIllicit.getEtpNm()); // 车所属企业
		params.put("illicit", vehiIllicit.getIllicit()); // 违法行为
		params.put("state", vehiIllicit.getState()); // 处罚状态
		params.put("vehiNoType", vehiIllicit.getVehiNoType()); // 号牌种类
		params.put("pickDepartmentDesc", vehiIllicit.getPickDepartmentDesc()); // 采集机关名称
		params.put("startTime", vehiIllicit.getStartTime()); // 违法开始时间
		params.put("endTime", vehiIllicit.getEndTime()); // 违法结束时间

		long totolRols = 0;
		List<VehiIllicit> listAll = new ArrayList<VehiIllicit>();
		for (int i = 0; i < tableList.size(); i++) {
			params.put("tableNmae", i);
			List<VehiIllicit> records = mapper.qryVehiIllicitList(params);
			totolRols = mapper.qryVehiIllicitListCount(params);
			totolRols+=totolRols;
			listAll.addAll(records);
		}
			
		pager.setTotalRows(totolRols);
		pager.setRecords(listAll);

		return pager;
	}

	@Override
	public VehiIllicit qryOneVehiIllicit(Map<String, Object> params) throws AppException {
		return mapper.qryOneVehiIllicit(params);
	}

}
