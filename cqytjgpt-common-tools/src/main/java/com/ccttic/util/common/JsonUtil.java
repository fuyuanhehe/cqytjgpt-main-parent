package com.ccttic.util.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description JSON和对象相互转换
 * @author andes
 * @version 1.0
 */
public class JsonUtil {
	private JsonUtil() {
	}

	/**
	 * @Description 将对象转换成json，如果涉及懒加载机制将会转换失败
	 */
	public static String objectToJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(obj);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * @Description 将json转换成对象
	 * @param json
	 * @param clazz,需要转换的对象Class
	 */
	public static <T> T jsonToObject(String json, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		T obj = null;
		try {
			obj = mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * @Description 将集合json转换成List对象
	 * @param json
	 */
	public static <T> List<T> jsonToList(String json) {
		ObjectMapper mapper = new ObjectMapper();
		List<T> relist = null;
		try {
			relist = mapper.readValue(json, new TypeReference<List<T>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relist;
	}

	/**
	 * @Description 将集合json转换成Set对象
	 * @param json
	 */
	public static <T> Set<T> jsonToSet(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Set<T> relist = null;
		try {
			relist = mapper.readValue(json, new TypeReference<Set<T>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relist;
	}

	/**
	 * @Description 将集合json转换成Map对象
	 * @param json
	 */
	public static <k, v> Map<k, v> jsonToMap(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Map<k, v> reMap = null;
		try {
			reMap = mapper.readValue(json, new TypeReference<Map<k, v>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reMap;
	}
}
