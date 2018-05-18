package com.ccttic.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.common.page.Page;
import com.ccttic.auth.common.page.PageImpl;
import com.ccttic.auth.common.page.Pageable;
import com.ccttic.auth.mapper.RoleEmpMapper;
import com.ccttic.auth.mapper.RoleMapper;
import com.ccttic.auth.mapper.RoleMenuMapper;
import com.ccttic.auth.model.Role;
import com.ccttic.auth.model.RoleEmp;
import com.ccttic.auth.service.IRoleService;
import com.ccttic.auth.util.ObjectHelper;
import com.ccttic.auth.util.RandomHelper;

/**
   功能说明：     角色业务实现类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.service.ess.impl.RoleServiceImpl.java
 @date  2016年12月11日
 */
@Service
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleMapper mapper;
	@Resource
	private RoleEmpMapper reMapper;
	@Resource
	private RoleMenuMapper rmMapper;

	@Override
	@Transactional(readOnly = true)
	public Page<Role> loadRolePages(Pageable page, Role role) throws AppException {
		Page<Role> pager = new PageImpl<Role>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("roleCd", role.getRoleCd());
		params.put("roleNm", role.getRoleNm());
		params.put("isDefault", role.getIsDefault());
		long totolRols = mapper.countRole(params);
		List<Role> records = mapper.pagerRole(params);
		for (Role record : records) {
			//获取角色人员
			List<RoleEmp> emps = reMapper.findEmpsByRoleId(record.getId());
			String empIds = "";
			String empCds = "";
			String empNms = "";
			for (RoleEmp emp : emps) {
				empIds += emp.getEmpId() + ",";
				empCds += emp.getEmpCd() + ",";
				empNms += emp.getEmpNm() + ",";
			}
			if (ObjectHelper.isNotEmpty(empIds)) {
				empIds = empIds.substring(0, empIds.length() - 1);
				empCds = empCds.substring(0, empCds.length() - 1);
				empNms = empNms.substring(0, empNms.length() - 1);
			}
			record.setEmpIds(empIds);
			record.setEmpCds(empCds);
			record.setEmpNms(empNms);
		}
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	@Transactional
	public boolean editRole(Role role) throws AppException {
		if (ObjectHelper.isEmpty(role.getId())) {
			String roleId = RandomHelper.uuid();
			role.setId(roleId);
			role.setRoleCd(roleId);
			role.setIsDefault(false);
			role.setVersion(1);
			mapper.addRole(role);
			if (ObjectHelper.isNotEmpty(role.getEmpIds())) {
				for (String empId : role.getEmpIds().split(",")) {
					RoleEmp roleEmp = new RoleEmp(RandomHelper.uuid(), empId, roleId, 1);
					reMapper.addRoleEmp(roleEmp);
				}
			}
		} else {
			Role p = mapper.findRoleById(role.getId());
			if (ObjectHelper.isNotEmpty(p)) {
				p.setRoleCd(role.getRoleCd());
				p.setRoleNm(role.getRoleNm());
				p.setDescription(role.getDescription());
				p.setVersion(p.getVersion() + 1);
				mapper.modifyRole(p);
				reMapper.deleteEmpRoleByRoleId(p.getId());
				if (ObjectHelper.isNotEmpty(role.getEmpIds())) {
					for (String empId : role.getEmpIds().split(",")) {
						RoleEmp roleEmp = new RoleEmp(RandomHelper.uuid(), empId, p.getId(), 1);
						reMapper.addRoleEmp(roleEmp);
					}
				}
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IRoleService#findRoleById(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Role findRoleById(String id) throws AppException {
		return mapper.findRoleById(id);
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IRoleService#deleteRole(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean deleteRole(String id) throws AppException {
		reMapper.deleteEmpRoleByRoleId(id);
		rmMapper.deleteRoleMenuByRoleId(id);
		mapper.deleteRole(id);
		return true;

	}

}
