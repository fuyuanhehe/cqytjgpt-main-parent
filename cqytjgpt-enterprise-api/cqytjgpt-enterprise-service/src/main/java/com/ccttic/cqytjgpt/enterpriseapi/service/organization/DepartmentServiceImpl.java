package com.ccttic.cqytjgpt.enterpriseapi.service.organization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.organization.IDepartmentService;
import com.ccttic.cqytjgpt.enterpriseapi.mapper.organization.DepartmentMapper;
import com.ccttic.cqytjgpt.enterpriseapi.mapper.organization.OrganizationMapper;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

	@Resource
	private DepartmentMapper mapper;
	@Resource
	private OrganizationMapper orgMapper;
	
	@Override
	public Page<Department> findOrgDepartmentList(Pageable page, Department tment)
			throws AppException {
		Page<Department> pager = new PageImpl<Department>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		if(null != tment && null != tment.getEptId()){
			params.put("etpId", tment.getEptId());
		}
		if(null != tment && null != tment.getOrgId()){
			params.put("orgId", tment.getOrgId());
		}
		long totolRols = mapper.qryDepartmentListCount(params);
		List<Department> records =mapper.qryDepartmentList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	public int createMent(Department ment){
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("depNm", ment.getDepNm());
		int a = 0;
		Department depNm = mapper.getDepNm(ment.getDepNm());
		if (null != depNm) {
			return a = 2;
		}
		a = orgMapper.addMent(ment);
		return a;
	}

	@Override
	public Department modifyMent(Department ment) throws AppException {
		mapper.modifyMent(ment);
		return ment;
	}

	@Override
	public int removeMent(String id) throws AppException {
		if (ObjectHelper.isNotEmpty(mapper.finByDepEmpId(id))) {
			return 2; //该部门下有人员关联，无法删除；请清除关联人员后重试
		}
		return mapper.removeMent(id);
	}

	@Override
	public Enterprise createRise(Enterprise rise, String id) throws AppException {
		rise.setId(id);
		rise.setOrgId(rise.getOrgCd());
		mapper.createRise(rise);
		return rise;
	}
}
