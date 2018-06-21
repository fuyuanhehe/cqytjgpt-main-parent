package com.ccttic.cqytjgpt.webapi.service.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.batch.IDriverBatch;
import com.ccttic.cqytjgpt.webapi.mapper.danger.DrDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.drillicit.DrIllicitMapper;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.illegal.DrIllicit;
@Service
public class DriverBatchImpl implements IDriverBatch {
	@Autowired
	private DrIllicitMapper drIllicitMapper;
	
	@Autowired
	private DrDangerMapper drDangerMapper;

	@Override
	public void addDriverIllegal(List<DrIllicit> list) {
		drIllicitMapper.insertBatch(list);

	}

	@Override
	public void addDriverDanger(List<DrDanger> list) {
		drDangerMapper.insertBatch(list);

	}

	@Override
	public void updateDriverIllegal(List<DrIllicit> list) {
		drIllicitMapper.updateBatch(list);

	}

	@Override
	public void updateDriverDanger(List<DrDanger> list) {
		drDangerMapper.updateBatch(list);
	}

}
