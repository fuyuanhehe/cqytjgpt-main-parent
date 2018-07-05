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
    
	/**分页查询员工总数
	 * @param params
	 * @return
	 */
	long qryPostListCount(Map<String, Object> params);

	/**分页查询员工
	 * @param params
	 * @return
	 */
	List<EssEmployeeVo> qryPostList(Map<String, Object> params);

	/**查询员工下的岗位
	 * @param id
	 * @return
	 */
	List<EssPost> selectPostUnderEmp(String id);

	/**删除员工下的岗位
	 * @param empId
	 */
	void delPostUnderEmp(String empId);

	/**查询员工下的部门
	 * @param id
	 * @return
	 */
	List<Department> selectDepUnderEmp(String id);

	/**通过部门id获取组织
	 * @param id
	 * @return
	 */
	Organization selectOrgByDepId(String id);

	/**通过用户账号获取用户详情
	 * @param account
	 * @return
	 */
	EmployeeVo findEmployeeByAccount(String account);
	
	/**关联部门和员工
	 * @param essEmployeeDept
	 */
	void relatedDepAndEmp(EssEmployeeDept essEmployeeDept);

	/**删除部门下的员工
	 * @param dept
	 */
	void delEmpUnderDep(EssEmployeeDept dept);
	
	List<EssEmployee> getAllEmp();
	
}