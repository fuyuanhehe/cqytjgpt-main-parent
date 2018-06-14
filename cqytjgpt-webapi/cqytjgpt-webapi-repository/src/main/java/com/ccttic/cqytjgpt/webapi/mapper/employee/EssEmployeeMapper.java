package com.ccttic.cqytjgpt.webapi.mapper.employee;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeeDept;
import com.ccttic.entity.employee.EssEmployeeExample;
import com.ccttic.entity.employee.EssEmployeeVo;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;

public interface EssEmployeeMapper {
    long countByExample(EssEmployeeExample example);

    int deleteByExample(EssEmployeeExample example);

    int deleteByPrimaryKey(String id);

    int insert(EssEmployee record);

    int insertSelective(EssEmployee record);

    List<EssEmployee> selectByExample(EssEmployeeExample example);

    EssEmployee selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EssEmployee record, @Param("example") EssEmployeeExample example);

    int updateByExample(@Param("record") EssEmployee record, @Param("example") EssEmployeeExample example);

    int updateByPrimaryKeySelective(EssEmployee record);

    int updateByPrimaryKey(EssEmployee record);

	long qryPostListCount(Map<String, String> params);

	List<EssEmployeeVo> qryPostList(Map<String, String> params);

	List<EssPost> selectPostUnderEmp(String id);

	void delPostUnderEmp(String empId);

	void modifyPassword(Map<String, String> map);

	List<Department> selectDepUnderEmp(String id);

	Organization selectOrgByDepId(String id);

	EmployeeVo findEmployeeByAccount(String account);
	
	void relatedDepAndEmp(EssEmployeeDept essEmployeeDept);

	void delEmpUnderDep(EssEmployeeDept dept);
	
	
}