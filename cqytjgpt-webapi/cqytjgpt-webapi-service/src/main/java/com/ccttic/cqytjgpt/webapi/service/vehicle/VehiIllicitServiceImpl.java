package com.ccttic.cqytjgpt.webapi.service.vehicle;

import com.ccttic.cqytjgpt.webapi.interfaces.vehicle.IVehiIllicitService;
import com.ccttic.cqytjgpt.webapi.mapper.employee.EssEmployeeMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehiIllicitMapper;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.role.VehiIllicit;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.DateHelper;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class VehiIllicitServiceImpl implements IVehiIllicitService {

	@Resource
	private VehiIllicitMapper mapper;
	@Resource
	private EssEmployeeMapper empMapper;

	@Override
	public Page<VehiIllicit> qryVehiIllicitList(Pageable page, VehiIllicit vehiIllicit,EmployeePermission employeePermission) throws AppException {
		Page<VehiIllicit> pager = new PageImpl<VehiIllicit>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = 0;
		if (null != vehiIllicit.getEndTime() && null != vehiIllicit.getStartTime()) {
			year = Integer.parseInt(vehiIllicit.getStartTime().substring(0, 4));
		} else { // 当违法时间为空的时候直接取当前年份
			year = calendar.get(Calendar.YEAR);
		}
		String endDate = null;
		String startDate = null;
		if (null != vehiIllicit.getEndTime()) {
			endDate = vehiIllicit.getEndTime();
		} else {
			endDate = DateHelper.getLastDayOfMonth1(year, 12);
		}
		if (null != vehiIllicit.getStartTime()) {
			startDate = vehiIllicit.getStartTime();
		} else {
			startDate = DateHelper.getFirstDayOfMonth1(year, 1);
		}
		if(Const.ETPUSER.equals(employeePermission.getEmployeeType()) || Const.ADMIN.equals(employeePermission.getEmployeeType())){
			params.put("id", employeePermission.getEnterpriseId());
		}
		if(Const.SUPER.equals(employeePermission.getEmployeeType()) || Const.ORGUSER.equals(employeePermission.getEmployeeType())){
			params.put("id", employeePermission.getOrgId());
		}
		params.put("userType", employeePermission.getEmployeeType());
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("mgrDepartAreaId", vehiIllicit.getMgrDepartAreaId()); // 区域编码
		params.put("vehiNo", vehiIllicit.getVehiNo()); // 车牌号
		params.put("etpNm", vehiIllicit.getEtpNm()); // 车所属企业
		params.put("illicit", vehiIllicit.getIllicit()); // 违法行为
		params.put("state", vehiIllicit.getState()); // 处罚状态
		params.put("vehiNoType", vehiIllicit.getVehiNoType()); // 号牌种类
		params.put("pickDepartmentDesc", vehiIllicit.getPickDepartmentDesc()); // 采集机关名称
		params.put("startTime", vehiIllicit.getStartTime()); // 违法开始时间
		params.put("endTime", vehiIllicit.getEndTime()); // 违法结束时间
		params.put("tableName", "illicit_"+year);
		
		long totolRol = mapper.qryVehiIllicitListCount(params);;
		List<VehiIllicit> records = mapper.qryVehiIllicitList(params);
		for (VehiIllicit vehi : records) {
			if (null != vehi.getIllicitScore()) {
				vehi.setDisposeSign("已处理");
			}
		}
		pager.setTotalRows(totolRol);
		pager.setRecords(records);

		return pager;
	}

	@Override
	public VehiIllicit qryOneVehiIllicit(Map<String, Object> params) throws AppException {
		return mapper.qryOneVehiIllicit(params);
	}

}
