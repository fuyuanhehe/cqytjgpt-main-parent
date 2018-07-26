package com.ccttic.util.common;

import java.util.HashMap;
import java.util.Map;


public class State {
	//驾驶人状态
	public static final Map<String, Object> MAPS = new HashMap<>();	

	//车辆状态
	public static final Map<String, Object> VEHICLEMAP = new HashMap<>();

	//身份证名称
	public static final Map<String, Object> IDCARDHAMAP = new HashMap<>();

	//企业类型
	public static final Map<String, Object> ENTERMAP = new HashMap<>();
	
	//驾驶人状态
	static {
		MAPS.put("A", "正常");
		MAPS.put("B", "超分");
		MAPS.put("C", "转出");
		MAPS.put("D", "暂扣");
		MAPS.put("E", "撤销");
		MAPS.put("F", "吊销");
		MAPS.put("G", "注销");
		MAPS.put("H", "违法未处理");
		MAPS.put("I", "事故未处理");
		MAPS.put("J", "停止使用");
		MAPS.put("K", "扣押");
		MAPS.put("L", "锁定");
		MAPS.put("M", "预期未换证");
		MAPS.put("N", "延期换证");
		MAPS.put("P", "延期体检");
		MAPS.put("R", "注销可恢复");
		MAPS.put("T", "延期审验");
		MAPS.put("U", "扣留");
		MAPS.put("S", "逾期未审验");

	}
	//车辆状态
	static{
		VEHICLEMAP.put("G", "违法未处理");
		VEHICLEMAP.put("A", "正常");
		VEHICLEMAP.put("O", "锁定");
		VEHICLEMAP.put("N", "事故逃逸");
		VEHICLEMAP.put("M", "达到报废标准");
		VEHICLEMAP.put("L", "扣留");
		VEHICLEMAP.put("K", "查封");
		VEHICLEMAP.put("J", "嫌疑车");
		VEHICLEMAP.put("D", "停驶");
		VEHICLEMAP.put("E", "注销");
		VEHICLEMAP.put("H", "海关监管");
		VEHICLEMAP.put("C", "被盗抢");
		VEHICLEMAP.put("B", "转出");
		VEHICLEMAP.put("P", "达到报废标准公告牌证作废");
		VEHICLEMAP.put("Q", "逾期未检验");

	}
//身份证
	static{
		IDCARDHAMAP.put("A", "居民身份证");
		IDCARDHAMAP.put("B", "组织机构代码证书");
		IDCARDHAMAP.put("C", "军官证");
		IDCARDHAMAP.put("D", "士兵证");
		IDCARDHAMAP.put("E", "军官离退休证");
		IDCARDHAMAP.put("F", "境外人员身份证明");
		IDCARDHAMAP.put("G", "外交人员身份证明");
		IDCARDHAMAP.put("H", "居民户口簿");
		IDCARDHAMAP.put("J", "单位注销证明");
		IDCARDHAMAP.put("K", "居住暂住证明");
		IDCARDHAMAP.put("L", "驻华机构证明");
		IDCARDHAMAP.put("M", "临时居民身份证");
		IDCARDHAMAP.put("N", "统一社会信用代码");
		IDCARDHAMAP.put("P", "个体工商户营业执照注册号");
	}

	//企业
	static{
		ENTERMAP.put("I", "消防企业");
		ENTERMAP.put("D", "出租客运企业 ");
		ENTERMAP.put("Q", "其他校车企业 ");
		ENTERMAP.put("N", "教练企业 ");
		ENTERMAP.put("K", "工程抢险车 ");
		ENTERMAP.put("P", "小学生校车 ");
		ENTERMAP.put("G", "租赁企业");
		ENTERMAP.put("A", "非营运企业 ");
		ENTERMAP.put("C", "公交客运企业 ");
		ENTERMAP.put("H", "警用企业 ");
		ENTERMAP.put("E", "旅游客运企业 ");
		ENTERMAP.put("J", "救护企业 ");
		ENTERMAP.put("M", "出租转非企业 ");
		ENTERMAP.put("L", "营转非企业 ");
		ENTERMAP.put("F", "货运企业 ");
		ENTERMAP.put("R", "危化品运输企业 ");
		ENTERMAP.put("O", "幼儿校车企业 ");
		ENTERMAP.put("B", "公路客运企业 ");
		
		
	}
	
	
}
