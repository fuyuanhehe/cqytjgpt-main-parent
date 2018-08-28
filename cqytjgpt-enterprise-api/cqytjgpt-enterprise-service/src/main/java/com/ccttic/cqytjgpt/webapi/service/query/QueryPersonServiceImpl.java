package com.ccttic.cqytjgpt.webapi.service.query;

import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.webapi.client.cqjxj.WebServiceFeign;
import com.ccttic.cqytjgpt.webapi.interfaces.query.IQueryPersonService;
import com.ccttic.entity.drivers.XMLDriver;
import com.ccttic.util.common.DESHelper;
import com.ccttic.util.common.SaxUtil;
import com.ccttic.util.constant.CommonConstant;



/**
 * 功能说明： 查询驾驶员业务接口
 * 
 * @version 1.0.0
 * @author zenghy
 * @see com.studio.framework.service.query.impl.QueryPersonServiceImpl.java
 * @date 2018年1月24日
 */
@Service
public class QueryPersonServiceImpl implements IQueryPersonService {
	
	private Logger logger = LoggerFactory.getLogger(QueryPersonServiceImpl.class);

	@Autowired
	private WebServiceFeign ws;


	@Override
	public XMLDriver QueryPersonByIDCard(String IDCard) throws Exception {
		XMLDriver driver = null;

		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding =\"GBK\"?>\n");
		sb.append("<root>\n");
		sb.append("<QueryCondition>\n");
		sb.append("<sfzmhm>");
		String value = URLEncoder.encode(IDCard, "utf-8");
		sb.append(value);
		sb.append("</sfzmhm>\n");
		sb.append("</QueryCondition>\n");
		sb.append("</root>\n");

		String str = DESHelper.str2HexStr(CommonConstant.ENKEY, URLEncoder.encode(sb.toString(), "utf-8"));
		String[] objects = new String[] { "02", "02Q01", CommonConstant.JKSQM, CommonConstant.ZDYHDH, CommonConstant.ZDYHXM, CommonConstant.ZDBS, CommonConstant.ZDDZZB,
				CommonConstant.ENKEY, str };
		String xml = ws.queryData(objects);
		logger.info(xml);
		driver = SaxUtil.SaxDriver(xml);
		return driver;
	}


}