package com.ccttic.mapper;

import java.util.List;

import com.ccttic.entity.danger.VehiDanger;

public interface VehiDangerMapper {
    int deleteByPrimaryKey(String id);

    int insert(VehiDanger record);

    VehiDanger selectByPrimaryKey(String id);

    List<VehiDanger> selectAll();

    int updateByPrimaryKey(VehiDanger record);
}