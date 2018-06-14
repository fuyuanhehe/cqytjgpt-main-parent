package com.ccttic.service.query;

import java.util.Map;

import com.ccttic.entity.illegalprocess.XMLPendingPayment;


public interface IPendingPaymentService {

	/**
	 * 根据驾驶证号获违法信息
	 * @param pendingPayment
	 * @param stype 系统类别
	 * @param jkid 接口ID
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> queryPendingPayment(XMLPendingPayment pendingPayment,String stype, String jkid) throws Exception; 
}
