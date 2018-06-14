package com.ccttic.cqytjgpt.webapi.service.query;

import java.net.URLEncoder;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.client.cqjxj.WebServiceFeign;
import com.ccttic.cqytjgpt.webapi.interfaces.query.IPendingPaymentService;
import com.ccttic.entity.illegalprocess.XMLPendingPayment;
import com.ccttic.util.common.DESHelper;
import com.ccttic.util.common.SaxUtil;
import com.ccttic.util.constant.CommonConstant;

@Service
public class PendingPaymentServiceImpl implements IPendingPaymentService {
	private Logger logger = LoggerFactory.getLogger(PendingPaymentServiceImpl.class);

	@Autowired
	private WebServiceFeign wsServiceWrap;

	@Transactional
	@Override
	public Map<String, Object> queryPendingPayment(XMLPendingPayment pendingPayment,String stype, String jkid) throws Exception {
		// 拼接传入参数
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding =\"GBK\"?>\n");
		sb.append("<root>\n");
		sb.append("<QueryCondition>\n");
		switch (jkid) {
		// 根据驾驶证号获取待交款信息
		case "04Q03":
			sb.append("<jszh>");
			sb.append(URLEncoder.encode(pendingPayment.getJszh(), "utf-8"));
			sb.append("</jszh>\n");
			break;
		// 根据号牌种类、号牌号码获取待交款信息
		case "04Q04":
			sb.append("<hpzl>");
			sb.append(URLEncoder.encode(pendingPayment.getHpzl(), "utf-8"));
			sb.append("</hpzl>\n");
			sb.append("<hphm>");
			sb.append(URLEncoder.encode(pendingPayment.getHphm(), "utf-8"));
			sb.append("</hphm>\n");
			break;
		default:
			return null;
		}
		sb.append("</QueryCondition>\n");
		sb.append("</root>\n");
		// 调用接口
		String queryObject = null;
		try {
			String str =DESHelper.str2HexStr(CommonConstant.ENKEY, URLEncoder.encode(sb.toString(), "utf-8"));
			String[] objects = new String[] { stype, jkid, CommonConstant.JKSQM, CommonConstant.ZDYHDH, CommonConstant.ZDYHXM, CommonConstant.ZDBS, CommonConstant.ZDDZZB,
					CommonConstant.ENKEY, str };
			queryObject=wsServiceWrap.queryData(objects);
			
		} catch (Exception e) {
			logger.error("调用接口失败"+e);
			return null;
		}
		// 从字符串加载Document对象
		Map<String, Object> readStringXmlOut =SaxUtil.readStringXmlOut(queryObject);
		return readStringXmlOut;
	}

}
