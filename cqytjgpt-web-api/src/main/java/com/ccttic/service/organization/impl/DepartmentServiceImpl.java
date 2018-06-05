package com.ccttic.service.organization.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccttic.entity.common.exception.AppException;
import com.ccttic.entity.common.exception.DeleteRefusedException;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.mapper.organization.DepartmentMapper;
import com.ccttic.service.organization.IDepartmentService;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

	@Resource
	private DepartmentMapper mapper;
	
	@Override
	public Page<Map<String, Object>> findOrgDepartmentList(Pageable page, Department tment, String orgCd)
			throws AppException {
		Page<Map<String, Object>> pager = new PageImpl<Map<String, Object>>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("orgCd", orgCd);
		long totolRols = mapper.qryDepartmentListCount(params);
		List<Map<String, Object>> records =mapper.qryDepartmentList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	public Department createMent(Department ment, String id) throws AppException {
		ment.setId(id);
		ment.setOrgId(ment.getOrgCd());
		mapper.createMent(ment);
		return ment;
	}

	@Override
	public Department modifyMent(Department ment) throws AppException {
		mapper.modifyMent(ment);
		return ment;
	}

	@Override
	public void removeMent(String id) throws AppException {
		if (ObjectHelper.isNotEmpty(mapper.finByDepEmpId(id))) {
			throw new DeleteRefusedException("该部门有供职人员，请移除员工后删除!");
		}
		mapper.removeMent(id);
	}

	@Override
	public Enterprise createRise(Enterprise rise, String id) throws AppException {
		rise.setId(id);
		rise.setOrgId(rise.getOrgCd());
		mapper.createRise(rise);
		return rise;
	}
}
