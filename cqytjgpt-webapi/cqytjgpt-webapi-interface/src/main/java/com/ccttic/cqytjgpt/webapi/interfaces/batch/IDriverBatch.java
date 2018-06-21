package com.ccttic.cqytjgpt.webapi.interfaces.batch;

import java.util.List;

import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.illegal.DrIllicit;

public interface IDriverBatch {
	/**
	 * 批量添加车辆违法
	 * @param list
	 */
	public void addDriverIllegal(List<DrIllicit> list);
	
	/**
	 * 批量添加车辆预警
	 * @param list
	 */
	public void addDriverDanger(List<DrDanger> list);
	
	/**
	 * 批量修改车辆违法
	 * @param list
	 */
	public void updateDriverIllegal(List<DrIllicit> list);
	
	/**
	 * 批量修改车辆预警
	 * @param list
	 */
	public void updateDriverDanger(List<DrDanger> list);
}
