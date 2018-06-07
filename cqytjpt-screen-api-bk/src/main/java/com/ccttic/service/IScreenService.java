package com.ccttic.service;

import java.util.Map;


import com.ccttic.entity.common.beans.ResponseMsg;

public interface IScreenService {
		// 驾驶人隐患发现情况
		public ResponseMsg<Map<String, Object>> findDangerForDriver();
		// 机动车隐患发现情况
		public ResponseMsg<Map<String, Object>> findDangerForCar() ;

		// 驾驶员隐患问题分布情况
		public ResponseMsg<Map<String, Object>> distributionDangerForDriver(Map<String, Object> dateMap) ;

		// 机动车隐患问题分布情况
		public ResponseMsg<Map<String, Object>> distributionDangerForCar() ;

		// 驾驶员隐患治理结果分析
		public ResponseMsg<Map<String, Object>> handleDangerForDriver() ;

		// 机动车隐患治理结果分析
		public ResponseMsg<Map<String, Object>> handleDangerForCar() ;

		// 驾驶员整治效果趋势分析
		public ResponseMsg<Map<String, Object>> resultDangerForDriver() ;

		// 机动车整治效果趋势分析
		public ResponseMsg<Map<String, Object>> resultDangerForCar() ;

		// 分区隐患信息
		public ResponseMsg<Map<String, Object>> areaDangerInfo() ;

		// 隐患驾驶员通报
		public ResponseMsg<Map<String, Object>> noticeDangerForDriver() ;

		// 隐患驾驶员通报
		public ResponseMsg<Map<String, Object>> noticeDangerForCar() ;

		// 各区隐患排名
		public ResponseMsg<Map<String, Object>> areaDangersTop() ;

		// 各区驾驶员隐患占比
		public ResponseMsg<Map<String, Object>> ratioDangerForDriver() ;

		// 各区机动车隐患占比
		public ResponseMsg<Map<String, Object>> ratioDangerForCar() ;

		// 各分所治理情况同比
		public ResponseMsg<Map<String, Object>> deptDangerForDriver(Map<String,Object> map) ;

		// 各分所机动车治理情况同比
		public ResponseMsg<Map<String, Object>> deptDangerForCar(Map<String,Object> map) ;
}
