package com.ccttic.util.common;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ccttic.entity.car.XMLCar;
import com.ccttic.entity.drivers.XMLDriver;
import com.ccttic.entity.illegalprocess.XMLIllegalProcess;
import com.ccttic.entity.illegalprocess.XMLPendingPayment;


public class SaxUtil {

	// 获得节点
	public static Element getHead(String xml) {
		Document doc = Dom4jHelper.loadXml(xml);
		Element rootElt = doc.getRootElement();
		return rootElt.element("head");
	}

	public static Element getBody(String xml) {
		Document doc = Dom4jHelper.loadXml(xml);
		Element rootElt = doc.getRootElement();
		return rootElt.element("head").element("body");
	}

	public static Element getVeh(String xml) {
		Document doc = Dom4jHelper.loadXml(xml);
		Element rootElt = doc.getRootElement();
		return rootElt.element("head").element("body").element("veh");
	}

	public static Element getVio(String xml) {
		Document doc = Dom4jHelper.loadXml(xml);
		Element rootElt = doc.getRootElement();
		return rootElt.element("head").element("body").element("vio");
	}

	public static Element getDrv(String xml) {
		Document doc = Dom4jHelper.loadXml(xml);
		Element rootElt = doc.getRootElement();
		return rootElt.element("head").element("body").element("drv");
	}

	// 解析车辆简要信息xml，返回一个Car对象
	public static XMLCar SaxCar(String xml) throws Exception {
		XMLCar car = new XMLCar();
		if ("0".equals(getHead(xml).elementText("code"))) {
			return car;
		}
		Element body = getBody(xml);
		Element veh = getVeh(xml);
		Iterator<Element> items = body.elementIterator();
		if (items.hasNext()) {

			car.setXh(veh.elementText("xh"));

			car.setHpzl(URLDecoder.decode(veh.elementText("hpzl"), "UTF-8"));

			car.setHphm(veh.elementText("hphm"));

			car.setClpp(URLDecoder.decode(veh.elementText("clpp"), "UTF-8"));

			car.setCcdjrq(veh.elementText("ccdjrq"));

			car.setSyr(URLDecoder.decode(veh.elementText("syr"), "UTF-8"));

			car.setYxqz(veh.elementText("yxqz"));

			car.setZt(URLDecoder.decode(veh.elementText("zt"), "UTF-8"));

			car.setCllx(URLDecoder.decode(veh.elementText("cllx"), "UTF-8"));

			car.setClsbdh(veh.elementText("clsbdh"));

		}

		return car;
	}

	

	// 解析查询驾驶员简要信息xml，返回一个Driver对象
	public static XMLDriver SaxDriver(String xml) throws Exception {
		XMLDriver driver = null;
		if ("0".equals(getHead(xml).elementText("code"))) {
			return driver;
		}
		Element body = getBody(xml);
		Element drv = getDrv(xml);
		Iterator<Element> items = body.elementIterator();
		if (items.hasNext()) {
			driver = new XMLDriver();
			// 往实体类中添加
			driver.setDabh(URLDecoder.decode(drv.elementText("dabh"), "UTF-8"));
			driver.setSfzmmc(URLDecoder.decode(drv.elementText("sfzmmc"), "UTF-8"));
			driver.setSfzmhm(URLDecoder.decode(drv.elementText("sfzmhm"), "UTF-8"));
			driver.setXm(URLDecoder.decode(drv.elementText("xm"), "UTF-8"));
			driver.setZjcx(URLDecoder.decode(drv.elementText("zjcx"), "UTF-8"));
			driver.setYxqz(URLDecoder.decode(drv.elementText("yxqz"), "UTF-8"));
			driver.setCcdjrq(URLDecoder.decode(drv.elementText("qfrq"), "UTF-8"));
			driver.setZt(URLDecoder.decode(drv.elementText("zt"), "UTF-8"));
			driver.setLjjf(URLDecoder.decode(drv.elementText("ljjf"), "UTF-8"));
			driver.setSjhm(URLDecoder.decode(drv.elementText("sjhm"), "UTF-8"));

		}
		return driver;
	}

	

	public static Map<Object, Object> saxIIllegalProcess(String xml) throws Exception{
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<XMLIllegalProcess> list = new ArrayList<XMLIllegalProcess>();
		Document doc = null;

		try {
			// 将字符串转为XML
			doc = DocumentHelper.parseText(xml);
			// 获取根节点
			Element rootElt = doc.getRootElement();
			// 获取根节点下的子节点head
			Iterator<Element> headElt = rootElt.elementIterator("head");
			while (headElt.hasNext()) {
				Element headEle = (Element) headElt.next();
				String code = headEle.elementTextTrim("code");
				String message = URLDecoder.decode(headEle.elementTextTrim("message"), "UTF-8");
				map.put("code", code);
				map.put("message", message);
				if (!"1".equals(code)) {
					break;
				}
				// 获取head节点下的子节点body

				Iterator<Element> iterss = headEle.elementIterator("body");
				// 遍历body节点
				while (iterss.hasNext()) {
					Element recordEless = (Element) iterss.next();
					// 获取子节点body下的子节点vio

					Iterator<Element> itersElIterator = recordEless.elementIterator("vio");

					while (itersElIterator.hasNext()) {
						Element itemEle = (Element) itersElIterator.next();
						// 拿到body下的子节点drv下的字节点
						String xh = itemEle.elementTextTrim("xh");
						String cjjgmc = URLDecoder.decode(itemEle.elementTextTrim("cjjgmc"), "UTF-8");
						String hpzl = itemEle.elementTextTrim("hpzl");
						String hphm = URLDecoder.decode(itemEle.elementTextTrim("hphm"), "UTF-8");
						String wfsj = URLDecoder.decode(itemEle.elementTextTrim("wfsj"), "UTF-8");
						String wfdz = URLDecoder.decode(itemEle.elementTextTrim("wfdz"), "UTF-8");
						String wfxw = itemEle.elementTextTrim("wfxw");
						String clbj = URLDecoder.decode(itemEle.elementTextTrim("clbj"), "UTF-8");
						String wfxwms = URLDecoder.decode(itemEle.elementTextTrim("wfxwms"), "UTF-8");
						String fkje = itemEle.elementTextTrim("fkje");
						String wfjfs = itemEle.elementTextTrim("wfjfs");
						String cfzl = URLDecoder.decode(itemEle.elementTextTrim("cfzl"), "UTF-8");
						String clzt = itemEle.elementTextTrim("clzt");
						XMLIllegalProcess illegalprocess = new XMLIllegalProcess(xh, cjjgmc, hpzl, hphm, wfsj, wfdz, wfxw,
								clbj, wfxwms, fkje, wfjfs, cfzl, clzt);
						list.add(illegalprocess);

					}
					map.put("illegalprocess", list);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public static Map<String, Object> readStringXmlOut(String xml) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<XMLPendingPayment> list = new ArrayList<XMLPendingPayment>();
		XMLPendingPayment pendingPayment = null;
		Document doc = null;
		try {
			// 将字符串转为XML
			doc = DocumentHelper.parseText(xml);
			// 获取根节点
			Element rootElt = doc.getRootElement();
			// 获取根节点下的子节点head
			Iterator <Element> headElt = rootElt.elementIterator("head");
			while (headElt.hasNext()) {
				Element headEle = (Element) headElt.next();
				String code = headEle.elementTextTrim("code");
				map.put("code", code);
				String message = headEle.elementTextTrim("message");
				map.put("message", message);
				// 获取head节点下的子节点body
				Iterator <Element> iterss = headEle.elementIterator("body");
				// 遍历body节点
				while (iterss.hasNext()) {
					Element recordEless = (Element) iterss.next();
					// 获取子节点body下的子节点drv
					Iterator <Element> itersElIterator = recordEless.elementIterator("vio");
					// 遍历Header节点下的Response节点
					while (itersElIterator.hasNext()) {
						Element itemEle = (Element) itersElIterator.next();
						// 拿到body下的子节点drv下的字节点sfzmhm的值
						pendingPayment = new XMLPendingPayment();
						//获取，补全信息
						pendingPayment.setCljgmc(URLDecoder.decode(itemEle.elementTextTrim("cljgmc"),"UTF-8"));
						pendingPayment.setWfdz(URLDecoder.decode(itemEle.elementTextTrim("wfdz"),"UTF-8"));
						pendingPayment.setWfsj(URLDecoder.decode(itemEle.elementTextTrim("wfsj"),"UTF-8"));
						pendingPayment.setWfxw(URLDecoder.decode(itemEle.elementTextTrim("wfxw"),"UTF-8"));
						pendingPayment.setJdslb(URLDecoder.decode(itemEle.elementTextTrim("jdslb"),"UTF-8"));
						pendingPayment.setJdsbh(URLDecoder.decode(itemEle.elementTextTrim("jdsbh"),"UTF-8"));
						pendingPayment.setDsr(URLDecoder.decode(itemEle.elementTextTrim("dsr"),"UTF-8"));
						pendingPayment.setJszh(URLDecoder.decode(itemEle.elementTextTrim("jszh"),"UTF-8"));
						pendingPayment.setHpzl(URLDecoder.decode(itemEle.elementTextTrim("hpzl"),"UTF-8"));
						pendingPayment.setHphm(URLDecoder.decode(itemEle.elementTextTrim("hphm"),"UTF-8"));
						pendingPayment.setClsj(URLDecoder.decode(itemEle.elementTextTrim("clsj"),"UTF-8"));
						pendingPayment.setFkje(URLDecoder.decode(itemEle.elementTextTrim("fkje"),"UTF-8"));
						pendingPayment.setWfjfs(URLDecoder.decode(itemEle.elementTextTrim("wfjfs"),"UTF-8"));
						pendingPayment.setZnj(URLDecoder.decode(itemEle.elementTextTrim("znj"),"UTF-8"));
						pendingPayment.setClbj(URLDecoder.decode(itemEle.elementTextTrim("clbj"),"UTF-8"));
						pendingPayment.setJkbj(URLDecoder.decode(itemEle.elementTextTrim("jkbj"),"UTF-8"));
						//添加到list
						list.add(pendingPayment);
					}
					map.put("pendingpayment", list);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
