package com.ccttic.cqytjgpt.enterpriseapi.auth;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AntPathMatcher;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.role.IRoleService;
import com.ccttic.entity.role.vo.RoleMenuVo;

@Component 
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource { 

	@Autowired
	private IRoleService roleService;
	
	private static Map<String, Collection<ConfigAttribute>> moduleMap = null;

//    private static Map<String, Collection<ConfigAttribute>> methodMap = null;
	
	AntPathMatcher antPathMatcher = new AntPathMatcher();
	
/*	@Override 
	public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
		//获取请求地址 
		String requestUrl = ((FilterInvocation) o).getRequestUrl();
		List<RoleResult> list = roleService.findUserRole();
		Map<String, Vector<String>> map = new HashMap<String, Vector<String>>();
		for (RoleResult role : list) {
			Vector<String> roles = map.get(role.getJkurl());
			if (roles == null) {
				roles = new Vector<String>();
				roles.add(role.getUsertype());
				map.put(role.getJkurl(), roles);
			} else {
				roles.add(role.getUsertype());
			}
		}
		return null;
		}*/
	
	 @Override
	    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
	        Collection<ConfigAttribute> collection;
//	        collection = getAttributesHandler(methodMap, object);
//	        if (collection != null)
//	            return collection;
	        collection = getAttributesHandler(moduleMap, object);
	        return collection;
	    }
	 
	 /**
	     * 处理方法
	     *
	     * @param map
	     * @return
	     */
	    private Collection<ConfigAttribute> getAttributesHandler(Map<String, Collection<ConfigAttribute>> map, Object object) {
	        HttpServletRequest request = ((FilterInvocation) object).getRequest();
	        
	/*        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
					.entrySet()) {
				if (entry.getKey().matches(request)) {
					return entry.getValue();
				}
			}
			return null;*/
			
	        Iterator var3 = map.entrySet().iterator();
	        Map.Entry entry;
	        do {
	            if (!var3.hasNext()) {
	                return null;
	            }
	            entry = (Map.Entry) var3.next();

	        } while (!(new AntPathRequestMatcher(entry.getKey().toString())).matches(request));
	        Collection<ConfigAttribute> collection =  (Collection<ConfigAttribute>) entry.getValue();
	        return collection;
	    }
	
	    
	    @Override
	    public Collection<ConfigAttribute> getAllConfigAttributes() {
	        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
	        Map<String, Collection<ConfigAttribute>> all = new HashMap<>(this.moduleMap);
//	        all.putAll(this.methodMap);
	        Iterator<?> var2 = all.entrySet().iterator();
	        while (var2.hasNext()) {
	            Map.Entry<String, Collection<ConfigAttribute>> entry = (Map.Entry) var2.next();
	            allAttributes.addAll(entry.getValue());
	        }

	        return allAttributes;
	    }
	    

	@Override
	public boolean supports(Class<?> aClass) {
		return FilterInvocation.class.isAssignableFrom(aClass);
		}
	
	@Transactional(readOnly = true)
    private void loadResourceDefine() {
        loadModuleResources();
//        loadMethodResources();
    }


    /**
     * 提供一个外部使用方法.获取module权限MAP;
     *
     * @return
     */
    public Map<String, Collection<ConfigAttribute>> getModuleMap() {
        Map<String, Collection<ConfigAttribute>> map = new HashMap<>(moduleMap);
        return map;
    }
    
    /**
     * 提供外部方法让Spring环境启动完成后调用
     */
    public void doLoadResourceDefine() {
        loadResourceDefine();
    }
    
    /**
     * 读取模块资源
     */
    public void loadModuleResources() {
    	
    	   //模块资源为KEY,角色为Value 的list
        moduleMap = new HashMap<>();
        
        /**
         * 查询模块资源权限,配置模块权限验证
         */
        
    	List<RoleMenuVo> aclResources = roleService.findAllRoleMeun();
    	
    	
    	Map<String, Vector<String>> map = new HashMap<String, Vector<String>>();
		for (RoleMenuVo role : aclResources) {
			Vector<String> roles = map.get(role.getPath());
			if (roles == null) {
				roles = new Vector<String>();
				roles.add(role.getRoleCd());
				map.put(role.getPath(), roles);
			} else {
				roles.add(role.getRoleCd());
			}
		}
		
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Vector<String> roles = map.get(key);
			
			int size = roles.size(); 
			String[] values = new String[size]; 
			for (int i = 0; i < size; i++) { 
				values[i] ="ROLE_"+ roles.get(i); 
				}

			moduleMap.put(key, SecurityConfig.createList(values));
		}

     
        
               
    }


    /**
     * 读取精确方法权限资源
     */
/*    private void loadMethodResources() {
        *//**
         * 因为只有权限控制的资源才需要被拦截验证,所以只加载有权限控制的资源
         *//*
        //方法资源为key,权限编码为
        methodMap = new HashMap<>();
        List<Map<String, String>> pathAuths = aclAuthService.findPathCode();
        for (Map pathAuth : pathAuths) {
            String path = pathAuth.get("path").toString();
            ConfigAttribute ca = new SecurityConfig(pathAuth.get("code").toString().toUpperCase());
            stuff(ca, methodMap, path);
        }
    }*/

  /*  private void stuff(ConfigAttribute ca, Map<String, Collection<ConfigAttribute>> map, String path) {

        String[] pathArr = path.substring(1, path.length() - 1).split(Delimiter.COMMA.getDelimiter());
        for (String item : pathArr) {
            Collection<ConfigAttribute> collection = map.get(item + "/**");
            if (collection != null) {
                collection.add(ca);
            } else {
                collection = new ArrayList<>();
                collection.add(ca);
                String pattern = StringUtils.trimToEmpty(item) + "/**";
                map.put(pattern, collection);
            }
        }
    }*/
	
}
