package com.ccttic.cqytjgpt.webapi.service.query;

import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.client.cqjxj.WebServiceFeign;
import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryCarService;
import com.ccttic.entity.car.XMLCar;
import com.ccttic.util.common.DESHelper;
import com.ccttic.util.common.SaxUtil;
import com.ccttic.util.constant.CommonConstant;

@Service
public class QueryCarServiceImpl implements IQueryCarService {
	private Logger logger = LoggerFactory.getLogger(QueryCarServiceImpl.class);
	
	@Autowired
	private WebServiceFeign ws;

	@Override
	public XMLCar selectCarByHpzlHphm(String hpzl, String hphm) throws Exception {

		// 拼接成xml数据格式
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding =\"GBK\"?>\n");
		sb.append("<root>\n");
		sb.append("<QueryCondition>\n");
		sb.append("<hpzl>");
		String value = URLEncoder.encode(hpzl, "utf-8");
		sb.append(value);
		sb.append("</hpzl>\n");

		sb.append("<hphm>");
		String value1 = URLEncoder.encode(hphm, "utf-8");
		sb.append(value1);
		sb.append("</hphm>\n");
		sb.append("</QueryCondition>\n");
		sb.append("</root>\n");

		String str = DESHelper.str2HexStr(CommonConstant.ENKEY, URLEncoder.encode(sb.toString(), "utf-8"));
		String[] objects = new String[] { "01", "01Q01", CommonConstant.JKSQM, CommonConstant.ZDYHDH, CommonConstant.ZDYHXM, CommonConstant.ZDBS, CommonConstant.ZDDZZB,
				CommonConstant.ENKEY, str };
		String xml = ws.queryData(objects);
		logger.info(xml);
		XMLCar car = SaxUtil.SaxCar(xml);

		return car;
	}

}
