package com.ccttic.cqytjgpt.enterpriseapi.service.employee;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.redis.RedisService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.role.IRoleMenuService;
import com.ccttic.cqytjgpt.enterpriseapi.mapper.employee.EmployeeMapper;
import com.ccttic.cqytjgpt.enterpriseapi.mapper.employee.EssEmployeeMapper;
import com.ccttic.cqytjgpt.enterpriseapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.entity.employee.*;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能说明： 人员业务实现类
 *
 * @author xgYin
 * @version 1.0.0
 * @date 2016年12月4日
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private EmployeeMapper mapper;
    @Resource
    private EssEmployeeMapper empMapper;
    @Resource
    private EssEnterpriseMapper entMapper;
    @Autowired
    private IRoleMenuService service;
    @Autowired
    private RedisService<EmployeeVo> redisService;


    @Override
    public EmployeeVo findEmployeeByAccount(String account) throws AppException {

        EmployeeVo emp = empMapper.findEmployeeByAccount(account);
        emp.setEnt(entMapper.getEntByAdmin(emp.getId()));

        // 员工能使用的菜单,员工角色
        EmployeeVo datas = service.seRoleMenuById(emp.getId());
        if (datas != null) {
            emp.setMenus(datas.getMenus());
            emp.setModels(datas.getModels());
        }

        return emp;


    }


    @Override
    public Employee login(String account, String password) {
        return mapper.login(account, password);
    }


    @Override
    public List<RoleEmp> findRolesByEmpId(String empId) {
        return null;
    }

    @Override
    public Page<EssEmployeeVo> selectEmployee(Pageable page, EssEmployeeVo emp)
            throws AppException {
        Page<EssEmployeeVo> pager = new PageImpl<EssEmployeeVo>(page);
        Map<String, Object> params = new HashMap<String, Object>();
        if (null != emp.getOrgCd()) {
            params.put("orgId", emp.getOrgCd());//组织id
        }
        if (null != emp.getEtpId()) {
            params.put("eptId", emp.getEtpId());// 企业id
        }
        params.put("pageSize", page.getRows() + "");
        params.put("startRecord", (page.getPage() - 1) * page.getRows() + "");
        params.put("empNm", emp.getEmpnm());// 员工姓名
        params.put("account", emp.getAccount());// 员工账号
        params.put("depid", emp.getDepid());// 部门id
        long totalRows = empMapper.qryEmployeeListCount(params);
        List<EssEmployeeVo> records = empMapper.qryEmployeeList(params);
        for (EssEmployeeVo essEmployeeVo : records) {
            List<EssPost> post = empMapper.selectPostUnderEmp(essEmployeeVo.getId());
            String nm = "";
            essEmployeeVo.setPost(post);
            if (post.size() > 0) {
                for (EssPost essPost : post) {
                    nm += "," + essPost.getPostnm();
                }
                essEmployeeVo.setPostNm(nm.substring(1));
            }
        }

        pager.setTotalRows(totalRows);
        pager.setRecords(records);

        return pager;
    }

    @Override
    @Transactional
    public void modifyPassword(List<EssEmployee> emp) throws AppException {
        empMapper.modifyPassword(emp);
    }

    @Override
    @Transactional
    public void delEmployee(EssEmployeeVo emp) throws AppException {

        empMapper.delPostUnderEmp(emp.getId());
        EssEmployeeDept dept = new EssEmployeeDept();
        dept.setDepId(emp.getDepid());
        dept.setEmpId(emp.getId());
        empMapper.delEmpUnderDep(dept);
        empMapper.updateByPrimaryKeySelective(emp);

    }

    @Override
    public EmployeeVo getUserInfo(String access_token) {
        String username = JWTUtil.getUsername(access_token);
        EmployeeVo employee = (EmployeeVo) redisService.get(username + Const.TOKEN);
        // 2. 判断REDIS是否为空
        if (null == employee) {
            try {
                employee = findEmployeeByAccount(username);
                //3. 更新redis里用户缓存
                redisService.set(username + Const.TOKEN, employee, Const.USER_REDIS_LIVE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public int selectEmpByAccount(String account) {
        EssEmployeeExample example = new EssEmployeeExample();
        example.createCriteria().andAccountEqualTo(account);

        if (empMapper.selectByExample(example).size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<EssEmployeeVo> selectEmployeeByDepartment(String depid, String empnm, String orgCd) throws AppException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("depId", depid);
        params.put("empNm", empnm);
        params.put("orgId", orgCd);
        return empMapper.selectEmployeeByDepartment(params);
    }

    @Override
    public EmployeePermission getEmployeePermission(EmployeeVo employee) {
        EmployeePermission employeePermission = new EmployeePermission();
        EssEnterprise enterprise = null;
        employeePermission.setEmployeeType(employee.getEmptype());
        try {
            enterprise = entMapper.getEntByAdmin(employee.getId());

        } catch (AppException e) {
            e.printStackTrace();
        }
        employeePermission.setEnterpriseId(enterprise.getId());
        return employeePermission;
    }

}
