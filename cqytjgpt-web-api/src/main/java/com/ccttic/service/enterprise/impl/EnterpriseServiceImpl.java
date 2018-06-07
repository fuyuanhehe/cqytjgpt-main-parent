package com.ccttic.service.enterprise.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.service.enterprise.IEnterpriseService;

@Service
public class EnterpriseServiceImpl implements IEnterpriseService {

	private EssEnterpriseMapper enterpriseMapper;

	@Override
	public EssEnterprise selectEnterpriseById(Map<String, String> map) {
		return enterpriseMapper.selectByPrimaryKey(map.get("id"));

	}

	@Override
	@Transactional
	public int modifyEnterpriseById(EssEnterprise essEnterprise) {
			int i=enterpriseMapper.updateByPrimaryKeySelective(essEnterprise);
			return i;

	}
	
	@Override
	@Transactional
	public int delEnterpriseById(EssEnterprise essEnterprise) {
			int i =enterpriseMapper.updateByPrimaryKeySelective(essEnterprise);
			return i;
}
}