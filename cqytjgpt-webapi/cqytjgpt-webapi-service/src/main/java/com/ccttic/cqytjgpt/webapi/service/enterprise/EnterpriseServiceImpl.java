package com.ccttic.cqytjgpt.webapi.service.enterprise;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

@Service
public class EnterpriseServiceImpl implements IEnterpriseService {
	@Autowired
	private EssEnterpriseMapper enterpriseMapper;
	@Autowired
	private EssEmployeeMapper employeeMapper;

	@Override
	public Map<String, Object> selectEnterpriseById(Map<String, String> map) {
		EssEnterprise essEnterprise = enterpriseMapper.selectByPrimaryKey(map.get("id"));
		EssEmployee essEmployee = employeeMapper.selectByPrimaryKey(essEnterprise.getAdminEmpid());
		Map<String, Object> result = new HashMap<>();
		result.put("EssEnterprise", essEnterprise);
		result.put("EssEmployee", essEmployee);
		return result;
	}

	@Override
	@Transactional
	public void modifyEnterpriseById(EssEnterprise essEnterprise) throws Exception {
		enterpriseMapper.updateByPrimaryKeySelective(essEnterprise);

	}

	@Override
	@Transactional
	public int delEnterpriseById(EssEnterprise essEnterprise) throws Exception {
		int i = enterpriseMapper.hasemp(essEnterprise.getId());
		if (i == 0) {
			essEnterprise.setIsdeleted(true);
			enterpriseMapper.updateByPrimaryKeySelective(essEnterprise);
			return i;
		}

		return i;

	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param vo
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.ccttic.service.enterprise.IEnterpriseService#registerEnterpries(com.
	 * ccttic.entity.enterprise.vo.EnterpriseVo)
	 */

	@Override
	@Transactional
	public int registerEnterpries(EnterpriseVo vo) throws Exception {
		// 第一步，向employee表 添加账号
		int i = 1;
		EssEmployee employee = new EssEmployee();
		employee.setId(RandomHelper.uuid());
		employee.setEmpstatus(EssEmployeeStatus.START.getValue());
		employee.setEmail(vo.getEmail());
		employee.setAccount(vo.getAccount());
		employee.setPassword(vo.getPassword());
		employee.setEmpnm(vo.getEtplawer());
		employee.setCreatetime(new Date());
		i = employeeMapper.insertSelective(employee);

		// 第二步，添加企业信息
		EssEnterprise en = new EssEnterprise();
		en.setId(RandomHelper.uuid());
		en.setAdminEmpid(employee.getId());
		en.setAttachmentId(vo.getAttachmentId());
		en.setEtpnm(vo.getEtpnm()); // 企业名称
		en.setOwnertransport(vo.getOwnertransport()); // 所属区域
		en.setEtpadress(vo.getEtpadress()); // 企业地址
		en.setEtptel(vo.getEtptel()); // 企业电话
		en.setEtpsafer(vo.getEtpsafer());// 安全责任人
		en.setSafertel(vo.getSafertel()); // 责任人电话
		en.setEtplawer(vo.getEtplawer()); // 法人
		en.setLawertel(vo.getLawertel()); // 法人电话
		en.setOrgId(vo.getOrgId()); // 企业组织机构代码
		en.setEtpregadress(vo.getEtpregadress());// 企业注册地址
		en.setCreatetime(new Date());
		i = enterpriseMapper.insertSelective(en);
		return i;
	}

	@Override
	public Page<EssEnterprise> qryEssEnterpriseList(Pageable page, EssEnterprise vo) throws AppException {
		Page<EssEnterprise> pager = new PageImpl<EssEnterprise>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("etpnm", vo.getEtpnm()); // 企业名称
		params.put("state", vo.getState()); // 审核状态
	    params.put("referStartTime", vo.getReferStartTime()); // 提交开始时间
	    params.put("referEndTime", vo.getReferEndTime()); // 提交结束时间
	    params.put("checkStartTime", vo.getCheckStartTime()); // 审核开始时间
	    params.put("checkEndTime", vo.getCheckEndTime()); // 审核结束时间
		
		long totolRols = enterpriseMapper.qryEnterpriseCount(params);
		List<EssEnterprise> records = enterpriseMapper.qryEnterpriseList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);

		return pager;
	}
	
	
}