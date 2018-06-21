package com.ccttic.cqytjgpt.webapi.service.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.batch.ICarBatch;
import com.ccttic.cqytjgpt.webapi.mapper.danger.VehiDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehiIllicitMapper;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.illegal.VehiIllicit;

@Service
public class CarBatchImpl implements ICarBatch {
	@Autowired
	private VehiIllicitMapper vehiIllicitMapper;
	@Autowired
	private VehiDangerMapper vehiDangerMapper;

	@Override
	public void addCarIllegal(List<VehiIllicit> list) {
		vehiIllicitMapper.insertBatch(list);

	}

	@Override
	public void addCarDanger(List<VehiDanger> list) {
		vehiDangerMapper.insertBatch(list);

	}

	@Override
	public void updateCarIllegal(List<VehiIllicit> list) {
		vehiIllicitMapper.updateBatch(list);

	}

	@Override
	public void updateCarDanger(List<VehiDanger> list) {
		vehiDangerMapper.updateBatch(list);

	}

}
