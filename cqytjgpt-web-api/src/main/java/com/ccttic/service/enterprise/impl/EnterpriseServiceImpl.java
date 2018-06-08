package com.ccttic.service.enterprise.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.mapper.employee.EssEmployeeMapper;
import com.ccttic.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.service.enterprise.IEnterpriseService;

@Service
public class EnterpriseServiceImpl implements IEnterpriseService {
    @Autowired
	private EssEnterpriseMapper enterpriseMapper;
	@Autowired
	private EssEmployeeMapper employeeMapper;

	@Override
	public Map<String,Object> selectEnterpriseById(Map<String, String> map) {
		EssEnterprise essEnterprise= enterpriseMapper.selectByPrimaryKey(map.get("id"));
		EssEmployee essEmployee = employeeMapper.selectByPrimaryKey(essEnterprise.getAdminEmpid());
		Map<String,Object> result = new HashMap<>();
		result.put("EssEnterprise", essEnterprise);
		result.put("EssEmployee", essEmployee);
		return result;
	}

	@Override
	@Transactional
	public void modifyEnterpriseById(EssEnterprise essEnterprise) throws Exception{
			enterpriseMapper.updateByPrimaryKeySelective(essEnterprise);

	}
	
	@Override
	@Transactional
	public int delEnterpriseById(EssEnterprise essEnterprise) throws Exception{
			int i = enterpriseMapper.hasemp(essEnterprise.getId());
			if(i==0) {
				essEnterprise.setIsdeleted(true);
			enterpriseMapper.updateByPrimaryKeySelective(essEnterprise);
			return i;
			}
			
			return i;
	
}
}