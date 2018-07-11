package com.ccttic.cqytjgpt.webapi.mapper.enterprise;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.EssEnterpriseExample;
import com.ccttic.entity.enterprise.vo.EnterpriseVehiVo;
import com.ccttic.util.exception.AppException;

public interface EssEnterpriseMapper {
    long countByExample(EssEnterpriseExample example);

    int deleteByExample(EssEnterpriseExample example);

    int deleteByPrimaryKey(String id);

    int insert(EssEnterprise record);

    int insertSelective(EssEnterprise record);

    List<EssEnterprise> selectByExample(EssEnterpriseExample example);

    EssEnterprise selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EssEnterprise record, @Param("example") EssEnterpriseExample example);

    int updateByExample(@Param("record") EssEnterprise record, @Param("example") EssEnterpriseExample example);

    int updateByPrimaryKeySelective(EssEnterprise record);

    int updateByPrimaryKey(EssEnterprise record);
    //查看企业下是否还有员工
    int hasemp(String id);
    //通过企业id查询组织名
    String selectOrgIdbyId(String id);
    
    /**
	 * 根据条件获取企业信息
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public List<EssEnterprise> qryEnterpriseList(Map<String, Object> params) throws AppException;
	
	/**
	 * 
	 * 根据条件获取企业信息总记录数
	 * 
	 * @param params
	 * @return
	 * @throws AppException
	 */
	public int qryEnterpriseCount(Map<String, Object> params) throws AppException;
	/**
	 *@Author:zhy
	 *@Description:企业管理员获取企业信息
	 *@Date:10:25 2018/7/11
	 */
	public List<EssEnterprise> getEssEnterprise(@Param("id")String id);
	/**
	 *@Author:zhy
	 *@Description:通过组织id获取企业信息
	 *@Date:10:25 2018/7/11
	 */
	public List<EssEnterprise> getEssEnterpriseByOrgId(@Param("id")String id);

	/**
	 *@Author:zhy
	 *@Description:通过用户的id获取企业信息
	 *@Date:10:28 2018/7/11
	 */
	public EssEnterprise getEntByEmpId(@Param("id") String id);
	
	
	/*
	 * 企业下属车辆
	 */
	public List<EnterpriseVehiVo> getEnterpriseVe(Map<String, Object> map);
	 
	public long getEnterpriseVeCount(Map<String, Object> map);
	
	
}