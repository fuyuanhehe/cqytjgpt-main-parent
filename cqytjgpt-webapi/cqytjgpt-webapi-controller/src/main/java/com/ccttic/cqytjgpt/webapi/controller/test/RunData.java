package com.ccttic.cqytjgpt.webapi.controller.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.mapper.employee.EssEmployeeMapper;
import com.ccttic.entity.employee.EmpCategoryEnum;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.employee.EssEmployeeExample;
import com.ccttic.util.common.RandomHelper;
@RestController
public class RunData {
	@Autowired
	private EssEmployeeMapper mapper;
	
	@RequestMapping(value = "/refreshtoken", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void Run() {
		EssEmployee emp = new EssEmployee();
		EssEmployeeExample example = new EssEmployeeExample();
		List<EssEmployee> emps = mapper.selectByExample(example);
		
		
		for (EssEmployee essEmployee : emps) {
			essEmployee.setAccount(essEmployee.getEmpnm());
			mapper.updateByPrimaryKeySelective(essEmployee);
		}
	}

}
