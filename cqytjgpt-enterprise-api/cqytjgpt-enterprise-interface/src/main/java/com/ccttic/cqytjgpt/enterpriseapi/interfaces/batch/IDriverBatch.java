package com.ccttic.cqytjgpt.enterpriseapi.interfaces.batch;

import java.util.List;

import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.illegal.DrIllicit;

public interface IDriverBatch {
	/**
	 * 批量添加驾驶人违法
	 * @param list
	 */
	public void addDriverIllegal(List<DrIllicit> list);
	
	/**
	 * 批量添加驾驶人预警
	 * @param list
	 */
	public void addDriverDanger(List<DrDanger> list);
	
	/**
	 * 批量修改驾驶人违法
	 * @param list
	 */
	public void updateDriverIllegal(List<DrIllicit> list);
	
	/**
	 * 批量修改驾驶人预警
	 * @param list
	 */
	public void updateDriverDanger(List<DrDanger> list);

	/**批量更新驾驶人信息
	 * @param update
	 */
	public void updateDriver(List<Driver> update);

	/**删除没有数据的驾驶员
	 * @param delete
	 */
	public void deleteDriver(List<Driver> delete);
}
