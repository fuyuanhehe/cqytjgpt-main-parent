package com.ccttic.service.enterprise.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.enums.EssEmployeeStatus;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;
import com.ccttic.mapper.employee.EssEmployeeMapper;
import com.ccttic.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.service.enterprise.IEnterpriseService;
import com.ccttic.util.common.RandomHelper;

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

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param vo
	    * @return
	    * @throws Exception  
	    * @see com.ccttic.service.enterprise.IEnterpriseService#registerEnterpries(com.ccttic.entity.enterprise.vo.EnterpriseVo)  
	    */  
	    
	@Override
	@Transactional
	public int registerEnterpries(EnterpriseVo vo) throws Exception {
		// 第一步，向employee表 添加账号
		EssEmployee employee = new EssEmployee();
		employee.setId(RandomHelper.uuid());
		employee.setEmpstatus(EssEmployeeStatus.START.getValue());
		employee.setEmail(vo.getEmail());
		employee.setAccount(vo.getAccount());
		employee.setPassword(vo.getPassword());
		employeeMapper.insertSelective(employee);
		
		// 第二步，添加企业信息
		EssEnterprise en = new EssEnterprise();
		en.setAdminEmpid(employee.getId());
		en.setAttachmentId(vo.getAttachmentId());
		en.setEtpnm(vo.getEtpnm()); // 企业名称
		en.setOwnertransport(vo.getOwnertransport()); // 所属区域
		en.setEtpadress(vo.getEtpadress()); // 企业地址
		en.setEtptel(vo.getEtptel()); // 企业电话
		en.setEtpsafer(vo.getEtpsafer());// 安全责任人
		en.setSafertel(vo.getSafertel()); //责任人电话
		en.setEtplawer(vo.getEtplawer()); //法人
		en.setLawertel(vo.getLawertel()); //法人电话
		en.setOrgId(vo.getOrgId()); // 企业组织机构代码
		en.setEtpregadress(vo.getEtpregadress());// 企业注册地址
		enterpriseMapper.insertSelective(en);
		return 0;
	}
}