package com.ccttic.util.common;

import java.util.*;

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
		List<Map<String,String>> tmpList = new ArrayList<Map<String,String>>();
		List<Map<String,String>> createList = new ArrayList<Map<String,String>>();
		List<Map<String,String>> updateList = new ArrayList<Map<String,String>>();
		for(MenuVo a:menuCommon){
			Map<String,String> childMap = new HashMap<String, String>();
			Map<String,Object> childArray = new LinkedHashMap<String, Object>();
			if(a.getpId() == id || a.getpId().equals(id) ){
				String start = a.getTitle().substring(0,2);
				//String end =a.getTitle().substring(2,a.getTitle().length());
				if("创建".equals(start)){
					childMap.put("menuId", a.getMenuId());
					childMap.put("title", a.getTitle());
					createList.add(childMap);
					continue;
				}
				if("修改".equals(start)){
					childMap.put("menuId", a.getMenuId());
					childMap.put("title", a.getTitle());
					updateList.add(childMap);
					continue;
				}
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

		for (int i =0 ;i<createList.size();i++){
			Map<String,Object> childArray = new LinkedHashMap<String, Object>();
			for (int j =0 ;j<updateList.size()-i;j++){
				if (createList.get(i).get("title").substring(2,4).equals(updateList.get(j).get("title").substring(2,4))){
					childArray.put("menuId", createList.get(i).get("menuId")+","+ updateList.get(j).get("menuId"));
					childArray.put("title", "创建"+"/"+"修改"+ createList.get(i).get("title").substring(2,4));
					lists.add(childArray);
				}
			}
		}

		return lists; 
	} 

}
