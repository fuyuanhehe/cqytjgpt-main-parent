package com.ccttic.cqytjgpt.webapi.service.warning;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.warning.IWarningservice;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;
@Service
public class WarningServiceImpl implements IWarningservice{

	@Override
	public Page<VehiDanger> qryVehicleList(Pageable page, VehiDanger ve) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehiDanger qryOneVehicle(Map<String, Object> params) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

}
