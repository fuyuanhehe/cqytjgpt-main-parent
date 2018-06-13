package com.ccttic.service.enterprise;

import java.util.Map;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;

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
	
	/**
	 * 
	    * @Title: registerEnterpries  
	    * @Description: 企业注册 
	    * @param @param vo
	    * @param @return
	    * @param @throws Exception    参数  
	    * @return int    返回类型  
	    * @throws
	 */
	public int registerEnterpries(EnterpriseVo vo)throws Exception;
	

}
