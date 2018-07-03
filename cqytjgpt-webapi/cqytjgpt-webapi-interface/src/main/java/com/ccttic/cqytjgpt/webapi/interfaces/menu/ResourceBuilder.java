
package com.ccttic.cqytjgpt.webapi.interfaces.menu;

import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.exception.ResourceMappingException;

/**
 * 
    * @ClassName: ResourceBuilder  
    * @Description: 系统菜单资源  
    * @author Administrator  
    * @date 2018年6月5日  
    *  
    * @param <O>
 */
public interface ResourceBuilder<O> {

	/**
	 * 创建系统资源
	 * @param resourceScan 资源注解信息
	 * @param controllerRequestUri 使用@RequestMappin注解在类上定义的请求路径
	 * @param methodRequestUri 使用@RequestMappin注解在方法上定义的请求路径
	 * @return 构建好的系统资源对象
	 */
	O createSysResource(ResourceScan resourceScan,String[] controllerRequestUri, String[] methodRequestUri) throws ResourceMappingException;
	
	/**
	 * 启用扫描器
	 * @return
	 */
	boolean scannerEnable();
}
