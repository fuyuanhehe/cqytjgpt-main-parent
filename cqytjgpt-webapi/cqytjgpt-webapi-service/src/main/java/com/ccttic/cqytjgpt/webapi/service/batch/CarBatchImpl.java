package com.ccttic.cqytjgpt.webapi.service.batch;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
		List<VehiIllicit> saveTargets = new ArrayList<VehiIllicit>();
		for (VehiIllicit quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交
				List<Integer> cf = new ArrayList<>();  
				for (int a = 0; a < saveTargets.size(); a ++) {
					for (int j = a+1; j < saveTargets.size()-a; j++) {
						if(saveTargets.get(a).getId().equals(saveTargets.get(j).getId())) {
							cf.add(a);
							break;
						}
					}
				}
				for (Integer integer : cf) {
					saveTargets.remove((int)integer);
				}
				vehiIllicitMapper.insertBatch(list); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			vehiIllicitMapper.insertBatch(list);
		}

	}

	@Override
	public void addCarDanger(List<VehiDanger> list) {
		List<VehiDanger> saveTargets = new ArrayList<VehiDanger>();
		for (VehiDanger quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交
				List<Integer> cf = new ArrayList<>();  
				for (int a = 0; a < saveTargets.size(); a ++) {
					for (int j = a+1; j < saveTargets.size()-a; j++) {
						if(saveTargets.get(a).getId().equals(saveTargets.get(j).getId())) {
							cf.add(a);
							break;
						}
					}
				}
				for (Integer integer : cf) {
					saveTargets.remove((int)integer);
				}
				vehiDangerMapper.insertBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			vehiDangerMapper.insertBatch(saveTargets);
		}

	}

	@Override
	public void updateCarIllegal(List<VehiIllicit> list) {
		List<VehiIllicit> saveTargets = new ArrayList<VehiIllicit>();
		for (VehiIllicit quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交
				List<Integer> cf = new ArrayList<>();  
				for (int a = 0; a < saveTargets.size(); a ++) {
					for (int j = a+1; j < saveTargets.size()-a; j++) {
						if(saveTargets.get(a).getId().equals(saveTargets.get(j).getId())) {
							cf.add(a);
							break;
						}
					}
				}
				for (Integer integer : cf) {
					saveTargets.remove((int)integer);
				}
				vehiIllicitMapper.updateBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			vehiIllicitMapper.updateBatch(saveTargets);
		}

	}

	@Override
	public void updateCarDanger(List<VehiDanger> list) {
		List<VehiDanger> saveTargets = new ArrayList<VehiDanger>();
		for (VehiDanger quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交
				List<Integer> cf = new ArrayList<>();  
				for (int a = 0; a < saveTargets.size(); a ++) {
					for (int j = a+1; j < saveTargets.size()-a; j++) {
						if(saveTargets.get(a).getId().equals(saveTargets.get(j).getId())) {
							cf.add(a);
							break;
						}
					}
				}
				for (Integer integer : cf) {
					saveTargets.remove((int)integer);
				}
				vehiDangerMapper.updateBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			vehiDangerMapper.updateBatch(saveTargets);
		}

	}

}
