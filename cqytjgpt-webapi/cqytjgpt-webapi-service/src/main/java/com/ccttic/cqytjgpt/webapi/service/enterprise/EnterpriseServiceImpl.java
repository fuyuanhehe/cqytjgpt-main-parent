package com.ccttic.cqytjgpt.webapi.service.enterprise;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.cqytjgpt.webapi.mapper.employee.EssEmployeeMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.enums.EssEmployeeStatus;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;
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
		// 第一步，向employee表 添加账叼
		EssEmployee employee = new EssEmployee();
		employee.setId(RandomHelper.uuid());
		employee.setEmpstatus(EssEmployeeStatus.START.getValue());
		
		return 0;
	}
}