package com.ccttic.cqytjgpt.webapi.mapper.enterprise;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.EssEnterpriseExample;
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
	
	public List<EssEnterprise> getEssEnterprise(String id)throws Exception;
}