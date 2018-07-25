package com.ccttic.entity.post;

import java.util.List;
import java.util.Map;

public class ObjectList {
	//接收listjosn
	public List<Map<String, String>> listMap;
	//接受josn
	public  String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public List<Map<String, String>> getListMap() {
		return listMap;
	}

	public void setListMap(List<Map<String, String>> listMap) {
		this.listMap = listMap;
	}
}
