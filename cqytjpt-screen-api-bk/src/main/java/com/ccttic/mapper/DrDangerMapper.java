package com.ccttic.mapper;

import com.ccttic.entity.DrDanger;
import java.util.List;

public interface DrDangerMapper {
    int deleteByPrimaryKey(String id);

    int insert(DrDanger record);

    DrDanger selectByPrimaryKey(String id);

    List<DrDanger> selectAll();

    int updateByPrimaryKey(DrDanger record);
}