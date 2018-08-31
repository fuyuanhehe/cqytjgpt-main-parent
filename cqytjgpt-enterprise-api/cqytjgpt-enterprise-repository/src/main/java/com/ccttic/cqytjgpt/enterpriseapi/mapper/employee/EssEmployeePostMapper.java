package com.ccttic.cqytjgpt.enterpriseapi.mapper.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployeePost;
import com.ccttic.entity.employee.EssEmployeePostExample;

public interface EssEmployeePostMapper {
    long countByExample(EssEmployeePostExample example);

    int deleteByExample(EssEmployeePostExample example);

    int deleteByPrimaryKey(String id);

    int insert(EssEmployeePost record);

    int insertSelective(EssEmployeePost record);

    List<EssEmployeePost> selectByExample(EssEmployeePostExample example);

    EssEmployeePost selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EssEmployeePost record, @Param("example") EssEmployeePostExample example);

    int updateByExample(@Param("record") EssEmployeePost record, @Param("example") EssEmployeePostExample example);

    int updateByPrimaryKeySelective(EssEmployeePost record);

    int updateByPrimaryKey(EssEmployeePost record);
}