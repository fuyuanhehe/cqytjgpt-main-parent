package com.ccttic.cqytjgpt.webapi.service.enterprise;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ccttic.cqytjgpt.webapi.mapper.category.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ccttic.cqytjgpt.webapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.cqytjgpt.webapi.mapper.employee.EssEmployeeMapper;
import com.ccttic.cqytjgpt.webapi.mapper.enterprise.EssEnterpriseMapper;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.enums.EssEmployeeStatus;
import com.ccttic.entity.enterprise.EnterVehicle;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.enterprise.vo.EnterpriseDriverVo;
import com.ccttic.entity.enterprise.vo.EnterpriseVehiVo;
import com.ccttic.entity.enterprise.vo.EnterpriseVo;
import com.ccttic.entity.role.Vehicle;
import com.ccttic.entity.role.vo.EmpVo;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.DateHelper;
import com.ccttic.util.common.MD5;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.common.State;
import com.ccttic.util.common.StringHelper;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;

import javax.annotation.Resource;

@Service
public class EnterpriseServiceImpl implements IEnterpriseService {
	@Autowired
	private EssEnterpriseMapper enterpriseMapper;
	@Autowired
	private EssEmployeeMapper employeeMapper;

	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public Map<String, Object> selectEnterpriseById(Map<String, String> map) {
		EssEnterprise essEnterprise = enterpriseMapper.selectByPrimaryKey(map.get("id"));
		EssEmployee essEmployee = employeeMapper.selectByPrimaryKey(essEnterprise.getAdminEmpid());
		essEnterprise.setAccount(essEmployee.getAccount());
		essEnterprise.setPassword(essEmployee.getPassword());
		Map<String, Object> result = new HashMap<>();
		result.put("EssEnterprise", essEnterprise);
		return result;
	}

	@Override
	@Transactional
	public void modifyEnterpriseById(EssEnterprise essEnterprise) throws AppException {
		enterpriseMapper.updateByPrimaryKeySelective(essEnterprise);

	}

	@Override
	@Transactional
	public int delEnterpriseById(EssEnterprise essEnterprise) throws AppException {
		int i = enterpriseMapper.hasemp(essEnterprise.getId());
		if (i == 0) {
			essEnterprise.setIsdeleted(true);
			enterpriseMapper.updateByPrimaryKeySelective(essEnterprise);
			return i;
		}

		return i;

	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param vo
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.ccttic.service.enterprise.IEnterpriseService#registerEnterpries(com.
	 * ccttic.entity.enterprise.vo.EnterpriseVo)
	 */

	@Override
	@Transactional
	public int registerEnterpries(EnterpriseVo vo) throws AppException {
		// 第一步，向employee表 添加账号
		int i = 1;
		EssEmployee employee = new EssEmployee();
		String id = RandomHelper.uuid();
		employee.setId(id);
		employee.setEmpstatus(EssEmployeeStatus.START.getValue());
		employee.setEmail(vo.getEmail());
		employee.setAccount(vo.getAccount());
		String md5pasword = MD5.sign(vo.getAccount(), vo.getPassword(), "utf-8");
		employee.setPassword(md5pasword);
		employee.setEmpnm(vo.getEtplawer());
		employee.setCreatetime(new Date());
		employee.setEmpcd(vo.getEtpcd());
		employee.setEmpnm(vo.getEtplawer());
		i = employeeMapper.insertSelective(employee);

		// 第二步，添加企业信息
		EssEnterprise en = new EssEnterprise();
		en.setId(RandomHelper.uuid());
		en.setAdminEmpid(id);
		en.setAttachmentId(vo.getAttachmentId());
		en.setEtpnm(vo.getEtpnm()); // 企业名称
		en.setOwnertransport(vo.getOwnertransport()); // 所属区域
		en.setEtpadress(vo.getEtpadress()); // 企业地址
		en.setEtptel(vo.getEtptel()); // 企业电话
		en.setEtpsafer(vo.getEtpsafer());// 安全责任人
		en.setSafertel(vo.getSafertel()); // 责任人电话
		en.setEtplawer(vo.getEtplawer()); // 法人
		en.setLawertel(vo.getLawertel()); // 法人电话
		en.setOrgId(vo.getOrgId()); // 企业组织机构代码
		en.setEtpregadress(vo.getEtpregadress());// 企业注册地址
		en.setCreatetime(new Date());
		i = enterpriseMapper.insertSelective(en);
		return i;
	}

	@Override
	public Page<EssEnterprise> qryEssEnterpriseList(Pageable page, EssEnterprise vo) throws AppException {
		Page<EssEnterprise> pager = new PageImpl<EssEnterprise>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("etpnm", vo.getEtpnm()); // 企业名称
		params.put("state", vo.getState()); // 审核状态
		params.put("referStartTime", vo.getReferStartTime()); // 提交开始时间
		params.put("referEndTime", vo.getReferEndTime()); // 提交结束时间
		params.put("checkStartTime", vo.getCheckStartTime()); // 审核开始时间
		params.put("checkEndTime", vo.getCheckEndTime()); // 审核结束时间

		long totolRols = enterpriseMapper.qryEnterpriseCount(params);
		List<EssEnterprise> records = enterpriseMapper.qryEnterpriseList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);

		return pager;
	}

	@Override
	public List<EssEnterprise> getEssEnterprise(String id) throws AppException {
		return enterpriseMapper.getEssEnterprise(id);
	}

	@Override
	public Page<EnterpriseVehiVo> getEnterpriseVe(Pageable page, EnterpriseVehiVo envo,EmployeePermission employeePermission)
			throws AppException {
		Page<EnterpriseVehiVo> pager = new PageImpl<EnterpriseVehiVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("etpNm", envo.getEtpNm());
		params.put("areaNm", envo.getAreaNm());
		params.put("id", envo.getId());
		params.put("empType", envo.getEmpType());
		params.put("vehiNo", envo.getVehiNo());
		params.put("vehiNoType", envo.getVehiNoType());
		if(Const.ADMIN.equals(employeePermission.getEmployeeType())){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		if(Const.ETPUSER.equals(employeePermission.getEmployeeType())){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		params.put("list", employeePermission.getAreaList()!=null?employeePermission.getAreaList():null);
		List<EnterpriseVehiVo> data = enterpriseMapper.getEnterpriseVe(params);

		for (EnterpriseVehiVo enterpriseVehiVo : data) {
			if(enterpriseVehiVo.getState()==null){
				enterpriseVehiVo.setState("不明确");
			}else {
				enterpriseVehiVo.setState(StringHelper.getChar(enterpriseVehiVo.getState(), State.VEHICLEMAP)  );
			}

			if( enterpriseVehiVo.getIdentityName()==null){
				enterpriseVehiVo.setIdentityName("不明确");
			}else {
				enterpriseVehiVo.setIdentityName(StringHelper.getChar(enterpriseVehiVo.getIdentityName() , State.IDCARDHAMAP) );
			}

			if(enterpriseVehiVo.getVehicleState()==null){
				enterpriseVehiVo.setVehicleState("不明确");
			}else {
				enterpriseVehiVo.setVehicleState( StringHelper.getChar(enterpriseVehiVo.getVehicleState() , State.VEHICLEMAP)   );	
			}


		}

		pager.setRecords(data);
		pager.setTotalRows(enterpriseMapper.getEnterpriseVeCount(params));

		return pager;
	}

	@Override
	public Page<EnterpriseDriverVo> getEnterpriceDriver(Pageable page, EnterpriseDriverVo envo,EmployeePermission employeePermission)
			throws AppException {
		Page<EnterpriseDriverVo> pager = new PageImpl<EnterpriseDriverVo>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("etpNm", envo.getEtpNm());
		params.put("areaNm", envo.getAreaNm());
		params.put("id", envo.getId());
		params.put("empType", envo.getEmpType());
		params.put("empType", envo.getEmpType());
		params.put("idcard", envo.getIdcard());
		if(Const.ADMIN.equals(employeePermission.getEmployeeType())){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		if(Const.ETPUSER.equals(employeePermission.getEmployeeType())){
			params.put("etpId",employeePermission.getEnterpriseId());
		}
		params.put("list", employeePermission.getAreaList()!=null?employeePermission.getAreaList():null);
		List<EnterpriseDriverVo> list = enterpriseMapper.getEnterpriceDriver(params);

		for (EnterpriseDriverVo driverVo2 : list) {

			if(driverVo2.getState()==null){
				driverVo2.setState("不明确");	
			}else{
				driverVo2.setState( StringHelper.getChar(driverVo2.getState() , State.MAPS) );	
			}   
			if(driverVo2.getState1()==null){
				driverVo2.setState1("不明确");	
			}else{
				driverVo2.setState1( StringHelper.getChar(driverVo2.getState1() , State.MAPS) );	
			}  

			driverVo2.setFirstrecivetime(DateHelper.getDataString(driverVo2.getFirstrecivetime()));
			driverVo2.setNextexaminetime(DateHelper.getDataString(driverVo2.getNextexaminetime()));	
			driverVo2.setEffectstarttime(DateHelper.getDataString(driverVo2.getEffectstarttime()));
			driverVo2.setEffectendtime(DateHelper.getDataString(driverVo2.getEffectendtime()));
			driverVo2.setExamineeffectendtime(DateHelper.getDataString(driverVo2.getExamineeffectendtime()));
		}

		pager.setRecords(list);

		pager.setTotalRows(enterpriseMapper.getEnterpriceDriverCount(params));

		return pager;
	}

	@Override
	@Transactional
	public void updateVehicleByid(EmpVo empVo) {

		Vehicle ve = new Vehicle();
		ve.setId(empVo.getId());

		Vehicle data = enterpriseMapper.getEnterVehicle(ve);

		EnterVehicle en = new EnterVehicle();
		en.setId(RandomHelper.uuid());
		en.setVehiId(data.getId() );
		if(data.getMgrEnterpriseId()==null){
			en.setEnterId("没有选择过企业");
		}else {
			en.setEnterId(data.getMgrEnterpriseId());
		}

		SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		en.setSetTime(s.format( new Date()).toString());

		enterpriseMapper.setEnterpriseVehicle(en);

		enterpriseMapper.updateVehicleByid(empVo);


	}

	@Override
	@Transactional
	public void updateDriverById(EmpVo empVo) {
		Vehicle ve = new Vehicle();
		ve.setId(empVo.getId());
		Vehicle data = enterpriseMapper.getEnterDriversBy(ve);

		EnterVehicle en = new EnterVehicle();
		en.setId(RandomHelper.uuid());
		en.setDriverId(data.getId() );
		if(data.getMgrEnterpriseId()==null){
			en.setEnterId("没有选择过企业");
		}else {
			en.setEnterId(data.getMgrEnterpriseId());
		}

		SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		en.setSetTime(s.format( new Date()).toString());

		enterpriseMapper.setEnterpriseDriver(en);

		enterpriseMapper.updateDriverByid(empVo);

	}

	@Override
	@Transactional
	public void relieveVehicleEnter(EmpVo empVo) {
		enterpriseMapper.relieveVehicleEnter(empVo);
	}

	@Override
	@Transactional
	public void relieveDricerEnter(EmpVo empVo) {
		enterpriseMapper.relieveDricerEnter(empVo);
	}
	@Override
	public Page<EssEnterprise> selectEnterpriseList(Pageable page,EssEnterprise ess) {
		Page<EssEnterprise> pager = new PageImpl<EssEnterprise>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		params.put("orgId", ess.getOrgId());
		long totolRols = enterpriseMapper.selectEnterpriseListCount(params);
		List<EssEnterprise> records = enterpriseMapper.selectEnterpriseList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	public List<String> getDepar() {
		// TODO Auto-generated method stub
		return enterpriseMapper.getDepar();
	}





}