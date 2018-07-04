package com.ccttic.cqytjgpt.webapi.service.batch;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.interfaces.batch.ICarBatch;
import com.ccttic.cqytjgpt.webapi.mapper.danger.VehiDangerMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehiIllicitMapper;
import com.ccttic.cqytjgpt.webapi.mapper.vehicle.VehicleMapper;
import com.ccttic.entity.danger.VehiDanger;
import com.ccttic.entity.illegal.VehiIllicit;
import com.ccttic.entity.role.Vehicle;

@Service
public class CarBatchImpl implements ICarBatch {
	@Autowired
	private VehiIllicitMapper vehiIllicitMapper;
	@Autowired
	private VehiDangerMapper vehiDangerMapper;
	@Autowired
	private VehicleMapper vehicleMapper;

	@Override
	public void addCarIllegal(List<VehiIllicit> list) {

		List<VehiIllicit> saveTargets = new ArrayList<VehiIllicit>();

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

		for (VehiIllicit quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

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

		for (VehiDanger quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

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

		for (VehiIllicit quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

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
		for (VehiDanger quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

				vehiDangerMapper.updateBatch(saveTargets); // 保存当前批次后清楚历史
				saveTargets.clear();
			}
		}
		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			vehiDangerMapper.updateBatch(saveTargets);
		}

	}

	@Override
	public void deleteCar(List<Vehicle> list) {

		List<String> saveTargets = new ArrayList<String>();

		for (Vehicle quotaResult : list) {

			saveTargets.add(quotaResult.getId());

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

				vehicleMapper.deleteBatch(saveTargets); // 保存当前批次后清楚历史

				saveTargets.clear();

			}

		}

		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			vehicleMapper.deleteBatch(saveTargets);

		}

	}

	@Override
	public void updateCar(List<Vehicle> list) {

		List<Vehicle> saveTargets = new ArrayList<Vehicle>();

		for (Vehicle quotaResult : list) {

			saveTargets.add(quotaResult);

			if (saveTargets.size() > 0 && (saveTargets.size() % 100) == 0) { // 每100条提交

				vehicleMapper.updateBatch(saveTargets); // 保存当前批次后清楚历史

				saveTargets.clear();
			}
		}

		if (!CollectionUtils.isEmpty(saveTargets)) {
			// saveTargets 只有1～99条时
			vehicleMapper.updateBatch(saveTargets);
		}

	}

}
