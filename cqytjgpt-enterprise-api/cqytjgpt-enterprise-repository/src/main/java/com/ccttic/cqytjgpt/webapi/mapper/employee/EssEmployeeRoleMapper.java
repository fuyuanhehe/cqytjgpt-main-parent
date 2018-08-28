package com.ccttic.cqytjgpt.webapi.mapper.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EssEmployeeRole;
import com.ccttic.entity.employee.EssEmployeeRoleExample;

public interface EssEmployeeRoleMapper {
	long countByExample(EssEmployeeRoleExample example);

	int deleteByExample(EssEmployeeRoleExample example);

	int deleteByPrimaryKey(String id);

	int insert(EssEmployeeRole record);

	int insertSelective(EssEmployeeRole record);

	List<EssEmployeeRole> selectByExample(EssEmployeeRoleExample example);

	EssEmployeeRole selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") EssEmployeeRole record,
								 @Param("example") EssEmployeeRoleExample example);

	int updateByExample(@Param("record") EssEmployeeRole record, @Param("example") EssEmployeeRoleExample example);

	int updateByPrimaryKeySelective(EssEmployeeRole record);

	int updateByPrimaryKey(EssEmployeeRole record);
}