package com.ccttic.cqytjgpt.enterpriseapi.mapper.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployeeDept;
import com.ccttic.entity.employee.EssEmployeeDeptExample;

public interface EssEmployeeDeptMapper {
    long countByExample(EssEmployeeDeptExample example);

    int deleteByExample(EssEmployeeDeptExample example);

    int deleteByPrimaryKey(String id);

    int insert(EssEmployeeDept record);

    int insertSelective(EssEmployeeDept record);

    List<EssEmployeeDept> selectByExample(EssEmployeeDeptExample example);

    EssEmployeeDept selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EssEmployeeDept record, @Param("example") EssEmployeeDeptExample example);

    int updateByExample(@Param("record") EssEmployeeDept record, @Param("example") EssEmployeeDeptExample example);

    int updateByPrimaryKeySelective(EssEmployeeDept record);

    int updateByPrimaryKey(EssEmployeeDept record);
}