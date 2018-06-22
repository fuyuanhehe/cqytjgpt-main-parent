package com.ccttic.cqytjgpt.webapi.interfaces.enterprise;

import java.util.Map;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

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
	
	/**
	 * 根据条件获取企业信息
	 * @param page
	 * @param vo
	 * @return
	 * @throws AppException
	 */
	public Page<EssEnterprise> qryEssEnterpriseList(Pageable page, EssEnterprise vo) throws AppException;
	
	public EssEnterprise getEssEnterprise(String id)throws Exception;
}
