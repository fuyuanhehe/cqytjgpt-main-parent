package com.ccttic.cqytjgpt.webapi.interfaces.enterprise;

import java.util.Map;

import com.ccttic.entity.enterprise.EssEnterprise;

public interface IEnterpriseService {

	/**
	 * 通过企业id查询企业详情
	 * @param map
	 * @return
	 */
	public Map<String,Object> selectEnterpriseById(Map<String, String> map);
	/**
	 * 修改企业信息
	 * @param map
	 * @return
	 */
	public void modifyEnterpriseById(EssEnterprise essEnterprise) throws Exception;
	/**
	 * 删除企业
	 * @param map
	 * @return
	 */
	public int delEnterpriseById(EssEnterprise essEnterprise) throws Exception;
	

}
