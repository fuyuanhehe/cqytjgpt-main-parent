package com.ccttic.mapper.drillicit;

import com.ccttic.entity.illegal.DrIllicit;
import com.ccttic.entity.illegal.DrIllicitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrIllicitMapper {
    long countByExample(DrIllicitExample example);

    int deleteByExample(DrIllicitExample example);

    int deleteByPrimaryKey(String id);

    int insert(DrIllicit record);

    int insertSelective(DrIllicit record);

    List<DrIllicit> selectByExample(DrIllicitExample example);

    DrIllicit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DrIllicit record, @Param("example") DrIllicitExample example);

    int updateByExample(@Param("record") DrIllicit record, @Param("example") DrIllicitExample example);

    int updateByPrimaryKeySelective(DrIllicit record);

    int updateByPrimaryKey(DrIllicit record);
}