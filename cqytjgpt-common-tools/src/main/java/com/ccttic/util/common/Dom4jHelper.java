package com.ccttic.util.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXValidator;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.XMLErrorHandler;

public class Dom4jHelper {
	private static final Log logger = LogFactory.getLog(Dom4jHelper.class);

	/**
	 * 从字符串加载Document对象
	 * 
	 * @param s
	 *            xml字符串
	 * @return Document
	 */
	public static Document loadXml(String s) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(s);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}

	/**
	 * 根据文件名和编码加载Document对象
	 * 
	 * @param filename
	 *            文件名称
	 * @param encode
	 *            编码
	 * @return Document
	 */
	public static Document load(String filename, String encode) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			saxReader.setEncoding(encode);
			document = saxReader.read(new File(filename));
		} catch (Exception ex) {
		}
		return document;
	}

	/**
	 * 根据xml内容和编码加载document对象
	 * 
	 * @param xml
	 *            xml内容
	 * @param encode
	 *            编码
	 * @return
	 */
	public static Document loadXml(String xml, String encode) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				xml.getBytes());
		return loadXml(inputStream, encode);
	}

	/**
	 * 从inputstream加载Document
	 * 
	 * @param is
	 *            inputstream
	 * @return Document
	 */
	public static Document loadXml(InputStream is) {
		return loadXml(is, "utf-8");
	}

	/**
	 * 指定编码，从inputstream加载Document
	 * 
	 * @param is
	 *            inputStream
	 * @param charset
	 *            编码
	 * @return Document
	 */
	public static Document loadXml(InputStream is, String charset) {
		Document document = null;
		try {
			SAXReader reader = new SAXReader();
			reader.setEncoding(charset);
			document = reader.read(is);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}



	/**
	 * 从远程URL加载Document
	 * 
	 * @param url
	 *            url
	 * @return Document
	 * @throws DocumentException
	 */
	public Document load(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		return document;
	}

	/**
	 * 根据文件名称加载Document
	 * 
	 * @param filename
	 *            文件名称
	 * @return Document
	 */
	public static Document load(String filename) {
		Document document = null;
		try {
			SAXReader reader = new SAXReader();
			document = reader.read(new File(filename));
			document.normalize();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}

	public static String transFormXsl(String xml, String xsl,
			Map<String, String> map) throws Exception {
		StringReader xmlReader = new StringReader(xml);
		StringReader xslReader = new StringReader(xsl);

		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(
				xslReader));
		if (map != null) {
			Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> obj = (Map.Entry<String, String>) it
						.next();
				transformer.setParameter((String) obj.getKey(), obj.getValue());
			}
		}
		StreamSource xmlSource = new StreamSource(xmlReader);

		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		transformer.transform(xmlSource, result);

		return writer.toString();
	}

	public static String transXmlByXslt(String xml, String xslPath,
			Map<String, String> map) throws Exception {
		Document document = loadXml(xml);

		Document result = styleDocument(document, xslPath, map);

		return docToString(result);
	}

	public static String docToString(Document document) {
		String s = "";
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			OutputFormat format = new OutputFormat("  ", true, "UTF-8");
			XMLWriter writer = new XMLWriter(out, format);
			writer.write(document);
			s = out.toString("UTF-8");
		} catch (Exception ex) {
			logger.error("docToString error:" + ex.getMessage());
		}
		return s;
	}

	public static Document styleDocument(Document document, String stylesheet,
			Map<String, String> map) throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(
				stylesheet));

		if (map != null) {
			Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> obj = it.next();
				transformer.setParameter((String) obj.getKey(), obj.getValue());
			}
		}

		DocumentSource source = new DocumentSource(document);
		DocumentResult result = new DocumentResult();
		transformer.transform(source, result);

		Document transformedDoc = result.getDocument();
		return transformedDoc;
	}

	/**
	 * 根据schema验证xml文件内容格式
	 * 
	 * @param xml
	 *            xml文件内容
	 * @param schema
	 *            schema文件内容
	 * @return 结果xml
	 */
	public static String validXmlBySchema(String xml, String schema) {
		String result = "";
		try {
			XMLErrorHandler errorHandler = new XMLErrorHandler();

			SAXParserFactory factory = SAXParserFactory.newInstance();

			factory.setValidating(true);

			factory.setNamespaceAware(true);

			SAXParser parser = factory.newSAXParser();

			SAXReader xmlReader = new SAXReader();

			Document xmlDocument = xmlReader.read(new File(xml));

			parser.setProperty(
					"http://java.sun.com/xml/jaxp/properties/schemaLanguage",
					"http://www.w3.org/2001/XMLSchema");
			parser.setProperty(
					"http://java.sun.com/xml/jaxp/properties/schemaSource",
					"file:" + schema);

			SAXValidator validator = new SAXValidator(parser.getXMLReader());

			validator.setErrorHandler(errorHandler);

			validator.validate(xmlDocument);
			// XMLWriter writer = new
			// XMLWriter(OutputFormat.createPrettyPrint());

			if (errorHandler.getErrors().hasContent()) {
				result = "<result success='0'>XML文件通过XSD文件校验失败,请检查xml是否符合指定格式!</result>";
			} else {
				result = "<result success='1'>XML文件通过XSD文件校验成功!</result>";
			}
		} catch (Exception ex) {
			result = "<result success='0'>XML文件通过XSD文件校验失败:" + ex.getMessage()
					+ "</result>";
		}
		return result;
	}
}