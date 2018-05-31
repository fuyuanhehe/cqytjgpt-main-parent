package com.ccttic.mapper.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployeeMenu;
import com.ccttic.entity.employee.EssEmployeeMenuExample;

public interface EssEmployeeMenuMapper {
    long countByExample(EssEmployeeMenuExample example);

    int deleteByExample(EssEmployeeMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(EssEmployeeMenu record);

    int insertSelective(EssEmployeeMenu record);

    List<EssEmployeeMenu> selectByExample(EssEmployeeMenuExample example);

    EssEmployeeMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EssEmployeeMenu record, @Param("example") EssEmployeeMenuExample example);

    int updateByExample(@Param("record") EssEmployeeMenu record, @Param("example") EssEmployeeMenuExample example);

    int updateByPrimaryKeySelective(EssEmployeeMenu record);

    int updateByPrimaryKey(EssEmployeeMenu record);
}