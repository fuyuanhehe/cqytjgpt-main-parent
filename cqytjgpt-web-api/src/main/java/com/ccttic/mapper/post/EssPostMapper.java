package com.ccttic.mapper.post;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostExample;

public interface EssPostMapper {
    long countByExample(EssPostExample example);

    int deleteByExample(EssPostExample example);

    int deleteByPrimaryKey(String id);

    int insert(EssPost record);

    int insertSelective(EssPost record);

    List<EssPost> selectByExample(EssPostExample example);

    EssPost selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EssPost record, @Param("example") EssPostExample example);

    int updateByExample(@Param("record") EssPost record, @Param("example") EssPostExample example);

    int updateByPrimaryKeySelective(EssPost record);

    int updateByPrimaryKey(EssPost record);
}