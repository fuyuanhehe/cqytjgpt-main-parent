package com.ccttic.mapper;

import java.util.List;

import com.ccttic.entity.danger.DrDanger;

public interface DrDangerMapper {
    int deleteByPrimaryKey(String id);

    int insert(DrDanger record);

    DrDanger selectByPrimaryKey(String id);

    List<DrDanger> selectAll();

    int updateByPrimaryKey(DrDanger record);
}