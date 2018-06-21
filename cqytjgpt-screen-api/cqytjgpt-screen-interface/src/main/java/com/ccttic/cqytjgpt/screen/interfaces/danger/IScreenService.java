package com.ccttic.cqytjgpt.screen.interfaces.danger;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.VehiDanger;

public interface IScreenService {
	    /**
	     * 查询分所名称id接口
	     * @return
	     */
	    public List<Map<String,Object>> findPlace();
		/**
		 *  驾驶人隐患发现情况
		 */
		public Map<String, Object> findDangerForDriver();
		
		/**
		 *  机动车隐患发现情况
		 */
		public Map<String, Object> findDangerForCar() ;

		/**
		 *  驾驶员隐患问题分布情况
		 * @param dateMap 根据条件查询数据 month season year
		 */
		public List<Map<String, Object>> distributionDangerForDriver(Map<String, Object> dateMap) ;

		/**
		 *  机动车隐患问题分布情况
		 * @param dateMap 根据条件查询数据 month season year
		 */
		public List<Map<String, Object>> distributionDangerForCar(Map<String, Object> dateMap) ;

		/**
		 *  驾驶员隐患治理结果分析
		 */
		public Map<String, Object> handleDangerForDriver() ;

		/**
		 *  机动车隐患治理结果分析
		 */
		public Map<String, Object> handleDangerForCar() ;

		/**
		 *  驾驶员整治效果趋势分析
		 */
		public Map<String, Object> resultDangerForDriver() ;

		/**
		 *  机动车整治效果趋势分析
		 */
		public Map<String, Object> resultDangerForCar() ;

		/**
		 *  分区隐患信息
		 */
		public List<Map<String,Object>> areaDangerInfo();

		/**
		 *  隐患驾驶员通报
		 * @param map 条数 top 
		 */
		public  Map<String,Object> noticeDangerForDriver(Map map);

		/**
		 *  隐患机动车通报
		 * @param map 条数 top 
		 */
		public  Map<String,Object> noticeDangerForCar(Map map) ;

		/**
		 *  各区隐患排名
		 */
		public List<Map<String, Object>> areaDangersTop() ;

		/**
		 *  各区驾驶员隐患占比
		 */
		public List<Map<String, Object>> ratioDangerForDriver() ;

		/**
		 *  各区机动车隐患占比
		 */
		public List<Map<String, Object>> ratioDangerForCar() ;

		/**
		 *  各分所驾驶员治理情况同比
		 * @param map orgId 分所id
		 */
		public Map<String, Object> deptDangerForDriver(Map<String,Object> map) ;

		/**
		 *  各分所机动车治理情况同比
		 * @param map orgId 分所id
		 */
		public Map<String, Object> deptDangerForCar(Map<String,Object> map) ;
}
