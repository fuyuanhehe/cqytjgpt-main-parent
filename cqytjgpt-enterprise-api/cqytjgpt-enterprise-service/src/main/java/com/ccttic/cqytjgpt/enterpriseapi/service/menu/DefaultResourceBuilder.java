
package com.ccttic.cqytjgpt.enterpriseapi.service.menu;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.menu.ResourceBuilder;
import com.ccttic.entity.employee.ResourceInfo;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.exception.ResourceMappingException;

/**
 * 
    * @ClassName: DefaultResourceBuilder  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author syao  
    * @date 2018年6月5日  
    *
 */
@Service
public class DefaultResourceBuilder implements ResourceBuilder<ResourceInfo> {

	private Logger logger = LoggerFactory.getLogger(DefaultResourceBuilder.class);
	
	/* (non-Javadoc)
	 * @see com.rls.ef.common.sys.ResourceBuilder#createSysResource(com.rls.ef.common.anno.ResourceScan, java.lang.String[], java.lang.String[])
	 */
	@Override
	public ResourceInfo createSysResource(ResourceScan resourceScan,
			String[] controllerRequestUri, String[] methodRequestUri) throws ResourceMappingException{

		// 当前资源注解信息
		Resource resourceAnno = resourceScan.rsc();
		
		if (((ArrayUtils.isNotEmpty(controllerRequestUri) && controllerRequestUri.length > 1) || 
				ArrayUtils.isNotEmpty(methodRequestUri) && methodRequestUri.length > 1 ) && StringUtils.isEmpty(resourceAnno.url())) {
			// 存在多个类的请求路径或者存在多个方法的请求路径 同时 当前资源注解信息中没有 请求url信息时
			throw new ResourceMappingException("存在多个类的请求路径或者存在多个方法的请求路径 同时 当前资源注解信息中没有 请求url信息时");
		}
		
		String rootUrl = "";
		
		if (StringUtils.isNotEmpty(resourceAnno.url())) {
			rootUrl = resourceAnno.url();
		} else {
			if (ArrayUtils.isNotEmpty(controllerRequestUri)) {
				rootUrl = controllerRequestUri[0];
			}
			rootUrl = rootUrl + methodRequestUri[0];
		}
		
		ResourceInfo rootResourceInfo = create(resourceAnno,rootUrl);

		
		
		// 当前资源的所有父资源注解信息
		Resource[] partenResources = resourceScan.prsc();
		if (ArrayUtils.isNotEmpty(partenResources)) {
			String partenUrl = null;
			ResourceInfo partenResourceInfo = null;
			for(Resource prsAnno : partenResources) {
				partenUrl = prsAnno.url();
				partenResourceInfo = create(prsAnno, partenUrl);
				rootResourceInfo.addPartenResourceInfo(partenResourceInfo);
			}
		}
		
		return rootResourceInfo;
	}
	
	protected ResourceInfo create(Resource resourceAnno,String url) {
		ResourceInfo resourceInfo = new ResourceInfo();
		resourceInfo.setAvailable(resourceAnno.available());
		resourceInfo.setHierarchy(resourceAnno.hierarchy());
		if (StringUtils.isNotEmpty(resourceAnno.id())) {
		    resourceInfo.setIdentity(resourceAnno.id());
		}
		resourceInfo.setIcon(resourceAnno.icon());
		resourceInfo.setMenue(resourceAnno.isMenue());
		resourceInfo.setSortOrder(resourceAnno.sortOrder());
		resourceInfo.setName(resourceAnno.name());
		resourceInfo.setParentCd(resourceAnno.pcd());
		resourceInfo.setResourceCd(resourceAnno.cd());
		resourceInfo.setUrl(url);
		resourceInfo.setDescription(resourceAnno.description());
		return resourceInfo;
	}

	/* (non-Javadoc)
	 * @see com.rls.ef.common.sys.ResourceBuilder#scannerEnable()
	 */
	@Override
	public boolean scannerEnable() {
		// TODO 这里可以通过配置来做个开关
		return true;
	}

}
