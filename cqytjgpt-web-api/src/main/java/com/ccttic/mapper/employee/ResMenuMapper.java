package com.ccttic.mapper.employee;

import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.employee.ResMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResMenuMapper {
    long countByExample(ResMenuExample example);

    int deleteByExample(ResMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResMenu record);

    int insertSelective(ResMenu record);

    List<ResMenu> selectByExample(ResMenuExample example);

    ResMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResMenu record, @Param("example") ResMenuExample example);

    int updateByExample(@Param("record") ResMenu record, @Param("example") ResMenuExample example);

    int updateByPrimaryKeySelective(ResMenu record);

    int updateByPrimaryKey(ResMenu record);
}