package com.ccttic.cqytjgpt.enterpriseapi.interfaces.query;

import com.ccttic.entity.car.XMLCar;



/**
 * @author liuj
 *
 */
public interface IQueryCarService {
	 
		/**
		 * 根据号牌种类，号牌号码获取车辆简要信息
		 * @param 
		 * @return
		 * @throws Exception
		 */
		public XMLCar selectCarByHpzlHphm(String hpzl,String hphm)throws Exception;
}
