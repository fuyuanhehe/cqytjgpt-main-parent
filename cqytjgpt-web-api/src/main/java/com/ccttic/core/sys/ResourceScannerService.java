
package com.ccttic.core.sys;

import java.util.Set;

import com.ccttic.exception.ResourceMappingException;

/**
 * 
    * @ClassName: ResourceScannerService  
    * @Description: 菜单资源入库
    * @author syao  
    * @date 2018年6月5日  
    *
 */
public interface ResourceScannerService {

	/**
	 * 安装系统资源
	 * @param sysResources
	 */
	void installResources(Set<ResourceInfo> sysResources)throws ResourceMappingException;
	
}
