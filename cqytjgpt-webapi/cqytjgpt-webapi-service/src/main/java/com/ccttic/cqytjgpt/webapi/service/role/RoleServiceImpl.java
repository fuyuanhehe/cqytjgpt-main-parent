package com.ccttic.cqytjgpt.webapi.service.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.role.IRoleService;
import com.ccttic.cqytjgpt.webapi.mapper.role.RoleEmpMapper;
import com.ccttic.cqytjgpt.webapi.mapper.role.RoleMapper;
import com.ccttic.cqytjgpt.webapi.mapper.role.RoleMenuMapper;
import com.ccttic.entity.role.Role;
import com.ccttic.entity.role.RoleEmp;
import com.ccttic.entity.role.Role_Emp;
import com.ccttic.entity.role.Roles;
import com.ccttic.entity.role.vo.EmpRoleMenuVo;
import com.ccttic.entity.role.vo.ModelByRole;
import com.ccttic.entity.role.vo.Model_MenuVo;
import com.ccttic.entity.role.vo.RoleMenuVo;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

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
	public Page<Role> loadRolePages(Pageable page, Role role)  {
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
	public boolean editRole(Role role)  {
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
	public Role findRoleById(String id) {
		return mapper.findRoleById(id);
	}

	/* (non-Javadoc)
	 * @see com.studio.framework.service.ess.IRoleService#deleteRole(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean deleteRole(String id)  {
		reMapper.deleteEmpRoleByRoleId(id);
		rmMapper.deleteRoleMenuByRoleId(id);
		mapper.deleteRole(id);
		return true;

	}

	@Override
	public List<RoleMenuVo> findAllRoleMeun() {
		return rmMapper.findRoleAllResources();
	}

	@Override
	@Transactional
	public void addRole_Emp(List<Role_Emp> role) {

		mapper.addRoleEmp(role);

	}

	@Override
	@Transactional
	public void addRoless(Roles rolty) {

		mapper.addRoless(rolty);

	}

	@Override

	public Page<Roles> seAllRole(Pageable page,Roles roles) {
		Page<Roles> pager = new PageImpl<Roles>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());		
		params.put("roleNm", roles.getRoleNm());
		params.put("roleId", roles.getRoleId());
		long totolRols = mapper.seRoleCount(params);
		List<Roles> records = mapper.seRoleAll(params);

		for (Roles role : records) {
			List<String> list = new ArrayList<>();
			String rid = role.getEmp_id();
			if(rid!= null){
				String [] array = rid.split(","); 
				for (int i = 0; i < array.length; i++) {
					list.add(array[i]);
				}
			}

			role.setEmporIds(list);  
			role.setEmp_id("");

		}

		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;


	}

	@Override
	@Transactional
	public void updateEssRole(Roles roles) {
		//员工ID
		String str = roles.getEmp_id();

		if(str==null){    
			//修改角色信息
			mapper.updateRoleById(roles); 
			return ;
		}
		//角色ID
		String role_id = roles.getRoleId();

		String [] strs = str.split(",");
		//修改角色信息
		mapper.updateRoleById(roles);

		//删除关联
		mapper.deleteEssRoleById(role_id);

		List<Role_Emp> roless = new ArrayList<Role_Emp>(); 

		//修改角色员工关联
		for(int i =0 ; i<strs.length; i++) {	
			Role_Emp emp = new Role_Emp();
			emp.setRole_id(role_id);
			emp.setVersion(1);
			emp.setId(RandomHelper.uuid());
			emp.setEmp_id(strs[i]);
			roless.add(emp);
		}

		mapper.addRoleEmp(roless);


	}

	@Override
	public ModelByRole seRoleByEmpId(String emp_id) {
		// TODO Auto-generated method stub		
		List<Role_Emp> roleids = mapper.seRoleByEmpId(emp_id);

		String ar[] = new String[roleids.size()];
		for (int i = 0; i < roleids.size(); i++) {
			Role_Emp mEmp = roleids.get(i);
			ar[i] = mEmp.getRole_id();
		}

		List<Model_MenuVo> data = rmMapper.seMenuByRoleId(ar);

		ModelByRole byRole = new ModelByRole();

		List<Model_MenuVo> models = new ArrayList<>();

		for (Model_MenuVo model : data) {			
			byRole.setRoleNm(model.getRoleNm());
			models.add(model);
			model.setRoleNm("");
		}
		byRole.setMenus(models);

		return byRole;
	}

	@Override
	public Page<EmpRoleMenuVo> getEmpParameter(Pageable page, EmpRoleMenuVo emp) {
		Page<EmpRoleMenuVo> pager = new PageImpl<EmpRoleMenuVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgNm", emp.getOrgNm());
		params.put("depNm", emp.getDepNm());
		params.put("empNm", emp.getEmpNm());
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		
		pager.setRecords(mapper.getEmpParameter(params));
		pager.setTotalRows(mapper.getEmpParameterCont(params));
		
		return pager;
	}	
	
	
}
