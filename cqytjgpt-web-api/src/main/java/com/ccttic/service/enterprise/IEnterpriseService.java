package com.ccttic.service.enterprise;

import java.util.Map;

import com.ccttic.entity.enterprise.EssEnterprise;

public interface IEnterpriseService {

	/**
	 * 通过企业id查询企业详情
	 * @param map
	 * @return
	 */
	public EssEnterprise selectEnterpriseById(Map<String, String> map);
	/**
	 * 修改企业信息
	 * @param map
	 * @return
	 */
	public int modifyEnterpriseById(EssEnterprise essEnterprise);
	/**
	 * 删除企业
	 * @param map
	 * @return
	 */
	public int delEnterpriseById(EssEnterprise essEnterprise);
	

}
