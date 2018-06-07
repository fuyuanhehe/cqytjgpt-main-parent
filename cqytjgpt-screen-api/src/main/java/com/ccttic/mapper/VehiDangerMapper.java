package com.ccttic.mapper;

import com.ccttic.entity.VehiDanger;
import java.util.List;

public interface VehiDangerMapper {
    int deleteByPrimaryKey(String id);

    int insert(VehiDanger record);

    VehiDanger selectByPrimaryKey(String id);

    List<VehiDanger> selectAll();

    int updateByPrimaryKey(VehiDanger record);
}