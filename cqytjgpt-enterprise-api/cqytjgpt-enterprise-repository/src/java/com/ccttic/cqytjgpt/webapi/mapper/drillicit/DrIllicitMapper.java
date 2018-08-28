package com.ccttic.cqytjgpt.webapi.mapper.drillicit;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.illegal.DrIllicit;
import com.ccttic.entity.illegal.DrIllicitExample;

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

	/**
	 * 批量添加驾驶人违法
	 * 
	 * @param list
	 */
	public void insertBatch(List<DrIllicit> list);

	/**
	 * 批量修改驾驶人违法
	 * 
	 * @param list
	 */
	public void updateBatch(List<DrIllicit> list);
}