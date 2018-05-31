package com.ccttic.mapper.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeeExample;

public interface EssEmployeeMapper {
    long countByExample(EssEmployeeExample example);

    int deleteByExample(EssEmployeeExample example);

    int deleteByPrimaryKey(String id);

    int insert(EssEmployee record);

    int insertSelective(EssEmployee record);

    List<EssEmployee> selectByExample(EssEmployeeExample example);

    EssEmployee selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EssEmployee record, @Param("example") EssEmployeeExample example);

    int updateByExample(@Param("record") EssEmployee record, @Param("example") EssEmployeeExample example);

    int updateByPrimaryKeySelective(EssEmployee record);

    int updateByPrimaryKey(EssEmployee record);
}