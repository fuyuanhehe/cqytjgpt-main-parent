package com.ccttic.service.query.impl;


import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccttic.service.query.IIllegalProcessService;
import com.ccttic.util.common.DESHelper;
import com.ccttic.util.common.SaxUtil;
import com.ccttic.util.constant.CommonConstant;
import com.ccttic.util.interfaces.WebServiceFeign;



@Service
public class IllegalprocessServiceImpl implements IIllegalProcessService {


	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private WebServiceFeign ws;


	@Override
	public Map<Object, Object> getIIllegalProcess(String stype, String jkid, String body) {
		Map<Object, Object> map =new HashMap<>();
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding =\"GBK\"?>\n");
		sb.append("<root>\n");
		sb.append("<QueryCondition>\n");
		sb.append(body);
		sb.append("</QueryCondition>\n");
		sb.append("</root>\n");
		logger.info(sb.toString());
		try {
			String str =DESHelper.str2HexStr(CommonConstant.ENKEY, URLEncoder.encode(sb.toString(), "utf-8"));
			String[] objects = new String[] { stype, jkid, CommonConstant.JKSQM, CommonConstant.ZDYHDH, CommonConstant.ZDYHXM, CommonConstant.ZDBS, CommonConstant.ZDDZZB,
					CommonConstant.ENKEY, str };
			String xml=ws.queryData(objects);
			
		logger.info(xml);
		
			 map =SaxUtil.saxIIllegalProcess(xml);
			
		} catch (Exception e) {

			e.printStackTrace();
			logger.info(e);
			map.put("code", "0");
			map.put("message", "服务器异常,请稍后再试");
		}
		return map;
	}

	

}
