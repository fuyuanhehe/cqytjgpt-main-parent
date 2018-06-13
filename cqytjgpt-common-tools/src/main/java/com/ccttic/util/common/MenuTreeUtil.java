package com.ccttic.util.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ccttic.entity.role.vo.MenuVo;

public class MenuTreeUtil {
	public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>(); 
	public List<MenuVo> menuCommon; 
	public List<Object> list = new ArrayList<Object>(); 

	public List<Object> menuList(List<MenuVo> menu){   
		this.menuCommon = menu; 
		for (MenuVo x : menu) {   
			Map<String,Object> mapArr = new LinkedHashMap<String, Object>(); 
			if(x.getId()=="Root" || x.getId().equals("Root")){
				mapArr.put("menuId", x.getMenuId()); 
				mapArr.put("id", x.getId()); 
				mapArr.put("title", x.getTitle());  
				mapArr.put("pid", x.getpId());  
				mapArr.put("type", x.getType());
				mapArr.put("url", x.getUrl());
				mapArr.put("cen", x.getCen());
				mapArr.put("childList", menuChild(x.getId()));  
				
				list.add(mapArr); 
			} 
		}   	
		return list; 
	} 

	public List<?> menuChild(String id){ 
		List<Object> lists = new ArrayList<Object>(); 
		for(MenuVo a:menuCommon){ 
			Map<String,Object> childArray = new LinkedHashMap<String, Object>(); 
			if(a.getpId() == id || a.getpId().equals(id) ){ 
				childArray.put("menuId", a.getMenuId()); 
				childArray.put("id", a.getId()); 
				childArray.put("title", a.getTitle());  
				childArray.put("pid", a.getpId());  
				childArray.put("type", a.getType());
				childArray.put("url", a.getUrl());
				childArray.put("cen", a.getCen());
				childArray.put("childList", menuChild(a.getId()));
				lists.add(childArray); 
			} 
		} 
		return lists; 
	} 

}
