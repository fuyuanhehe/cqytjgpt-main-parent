package com.ccttic.cqytjgpt.webapi.service.batch;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.batch.IDriverBatch;
import com.ccttic.cqytjgpt.webapi.mapper.danger.DrDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.drillicit.DrIllicitMapper;
import com.ccttic.cqytjgpt.webapi.mapper.drivers.DriverMapper;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.illegal.DrIllicit;

@Service
public class DriverBatchImpl implements IDriverBatch {
	@Autowired
	private DrIllicitMapper drIllicitMapper;

	@Autowired
	private DrDangerMapper drDangerMapper;
	
	@Autowired 
	private DriverMapper driverMapper;

	@Override
	public void addDriverIllegal(List<DrIllicit> list) {
		List<DrIllicit> saveTargets = new ArrayList<DrIllicit>();
		List<Integer> cf = new ArrayList<>();
		for (int a = 0; a < list.size(); a++) {
			for (int j = a + 1; j < list.size() - a; j++) {
				if (list.get(a).getId().equals(list.get(j).getId())) {
					cf.add(a);
					break;
				}
			}
		}
		for (Integer integer : cf) {
			list.remove((int) integer);
		}

		for (DrIllicit quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

				drIllicitMapper.insertBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			drIllicitMapper.insertBatch(saveTargets);
		}

	}

	@Override
	public void addDriverDanger(List<DrDanger> list) {
		List<DrDanger> saveTargets = new ArrayList<DrDanger>();
		List<Integer> cf = new ArrayList<>();
		for (int a = 0; a < list.size(); a++) {
			for (int j = a + 1; j < list.size() - a; j++) {
				if (list.get(a).getId().equals(list.get(j).getId())) {
					cf.add(a);
					break;
				}
			}
		}
		for (Integer integer : cf) {
			list.remove((int) integer);
		}

		for (DrDanger quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

				drDangerMapper.insertBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			drDangerMapper.insertBatch(saveTargets);
		}

	}

	@Override
	public void updateDriverIllegal(List<DrIllicit> list) {
		List<DrIllicit> saveTargets = new ArrayList<DrIllicit>();
		List<Integer> cf = new ArrayList<>();
		for (int a = 0; a < list.size(); a++) {
			for (int j = a + 1; j < list.size() - a; j++) {
				if (list.get(a).getId().equals(list.get(j).getId())) {
					cf.add(a);
					break;
				}
			}
		}
		for (Integer integer : cf) {
			list.remove((int) integer);
		}

		for (DrIllicit quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交
				drIllicitMapper.updateBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			drIllicitMapper.updateBatch(saveTargets);
		}

	}

	@Override
	public void updateDriverDanger(List<DrDanger> list) {
		List<DrDanger> saveTargets = new ArrayList<DrDanger>();

		List<Integer> cf = new ArrayList<>();
		for (int a = 0; a < list.size(); a++) {
			for (int j = a + 1; j < list.size() - a; j++) {
				if (list.get(a).getId().equals(list.get(j).getId())) {
					cf.add(a);
					break;
				}
			}
		}
		for (Integer integer : cf) {
			list.remove((int) integer);
		}
		for (DrDanger quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

				drDangerMapper.updateBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			drDangerMapper.updateBatch(saveTargets);
		}

	}

	@Override
	public void updateDriver(List<Driver> list) {
		List<Driver> saveTargets = new ArrayList<Driver>();
		for (Driver quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

				driverMapper.updateBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			driverMapper.updateBatch(saveTargets);
		}
		
		
	}

	@Override
	public void deleteDriver(List<Driver> list) {
		
		
		List<String> saveTargets = new ArrayList<String>();
		for (Driver quotaResult : list) {

			saveTargets.add(quotaResult.getIdcard());

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

				driverMapper.deleteBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			driverMapper.deleteBatch(saveTargets);
		}
	}

}
