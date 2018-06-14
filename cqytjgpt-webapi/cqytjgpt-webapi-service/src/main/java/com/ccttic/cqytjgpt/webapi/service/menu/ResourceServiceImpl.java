
package com.ccttic.cqytjgpt.webapi.service.menu;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.menu.IResMenuService;
import com.ccttic.cqytjgpt.webapi.interfaces.menu.ResourceScannerService;
import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.employee.ResourceInfo;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.ResourceDoNotFonundException;
import com.ccttic.util.exception.ResourceMappingException;




/**
 * 
    * @ClassName: ResourceServiceImpl  
    * @Description: 资源菜单安装器
    * @author Administrator  
    * @date 2018年6月6日  
    *
 */
@Service
public class ResourceServiceImpl  implements  ResourceScannerService {

    private static Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    IResMenuService menuService;

    /**
     * 系统启动时自动将扫描到的菜单资源保存到表中<br/>
     * 树 root / \ 1 2 /\ /\ 3 4 5 6 1.保存一棵上面的树需要将所有节点包括root节点保存到 sys_resource表
     * 2.将节点间关系保存到sys_resource_path表，以上关系解析的数据结构为：
     * root-root,root-1,root-2,root-3,root-4,root-5,root-6 1-1,1-3,1-4
     * 2-2,2-5,2-6 3-3,4-4,5-5,6-6
     * 
     **/
    @Override
    @Transactional
    public void installResources(Set<ResourceInfo> resourceInfos) {

        if (CollectionUtils.isEmpty(resourceInfos)) {
            logger.info("未扫描到系统资源信息");
            return;
        }

        
     // 查找资源根节点
        ResMenu rootResource =null;
        
        try {
			rootResource = menuService.selectByExample(Const.ROOT);
		} catch (ResourceDoNotFonundException e) {
			logger.warn("查度resmenu表中的root根菜单为空，系统自动创建");
			rootResource=createRootMenu();
		}
        
        // 遍历保存所有扫描到的资源
        Iterator<ResourceInfo> infoIt = resourceInfos.iterator();
        while (infoIt.hasNext()) {
            // 当前资源
            ResourceInfo currtenResourceInfo = infoIt.next();
            
            ResMenu menu =null;
            //先保存父资源
            for(ResourceInfo parentRes: currtenResourceInfo.getPartenResourceInfos()) {
            	
            	//先查找数据库里有没有这个资源
            	
				try {
					menu = menuService.selectByExample(parentRes.getResourceCd());
	               //更新资源
	               updateMenu(parentRes,menu);
				} catch (ResourceDoNotFonundException e) {
					//创建资源
					createMenu(parentRes);
					logger.warn("查度resmenu表中没有查找到["+parentRes.getResourceCd()+"]菜单,，系统自动创建");
				}
            
            }
            
            //保存当前资
            try {
            	menu = menuService.selectByExample(currtenResourceInfo.getResourceCd());
            	//更新资源
	               updateMenu(currtenResourceInfo,menu);
			} catch (ResourceDoNotFonundException e) {
				//创建资源
				createMenu(currtenResourceInfo);
				logger.warn("查度resmenu表中没有查找到["+currtenResourceInfo.getResourceCd()+"]菜单,，系统自动创建");
			}
        }
     

     
    }

   
      
	      
	    /**  
	    * @Title: updateMenu  
	    * @Description: 更新资源
	    * @param @param parentRes
	    * @param @param menu    参数  
	    * @return void    返回类型  
	    * @throws  
	    */  
	    
	private void updateMenu(ResourceInfo parentRes, ResMenu menu) {
		menu.setDescription(parentRes.getDescription());
		menu.setGroupresource(parentRes.getParentCd());
		menu.setHierarchy(parentRes.getHierarchy());
		menu.setIcon(parentRes.getIcon());
		menu.setIsmenu(parentRes.isMenue()?"1":"0");
		menu.setLabel(parentRes.getName());
		menu.setPath(parentRes.getUrl());
		menu.setSortorder(parentRes.getSortOrder());
		menuService.updateByExampleSelective(menu, menu.getResource());
	}



		/**  
	    * @Title: createMenu  
	    * @Description: 创建资源菜单  
	    * @param @param parentRes
	    * @param @return    参数  
	    * @return ResMenu    返回类型  
	    * @throws  
	    */  
	    
	private void createMenu(ResourceInfo parentRes) {
		ResMenu menu = new ResMenu();
		menu.setDescription(parentRes.getDescription());
		menu.setGroupresource(parentRes.getParentCd());
		menu.setHierarchy(parentRes.getHierarchy());
		menu.setIcon(parentRes.getIcon());
		menu.setId(uuid());
		menu.setIsmenu(parentRes.isMenue()?"1":"0");
		menu.setLabel(parentRes.getName());
		menu.setPath(parentRes.getUrl());
		menu.setResource(parentRes.getResourceCd());
		menu.setSortorder(parentRes.getSortOrder());
		menuService.insertSelective(menu);
	}


	private ResMenu createRootMenu() {
    	ResMenu menu = new ResMenu();
    	menu.setId(uuid());
    	menu.setResource(Const.ROOT);
    	menu.setLabel("菜单资源");
    	menu.setGroupresource("");
    	menu.setSortorder(0);
    	menu.setIcon("");
    	menu.setDescription("菜单资源");
    	menu.setPath("");
    	menu.setIsmenu("0");
    	menu.setHierarchy(0);
    	int row = menuService.insertSelective(menu);
    	if (1 > row) {
            // 根节点创建失败
            logger.error("往系统资源表插入根节点失败");
            throw new ResourceMappingException();
        }
    	return menu;
    }
    
    private String uuid() {
    	return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
