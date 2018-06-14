package com.ccttic.cqytjgpt.webapi.mapper.enterprise;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.EssEnterpriseExample;

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
    
    int hasemp(String id);
}