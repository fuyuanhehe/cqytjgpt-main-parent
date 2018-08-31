  
    /**    
    * @Title: IResMenuService.java  
    * @Package com.ccttic.service.menu  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author Administrator  
    * @date 2018年6月6日  
    * @version V1.0    
    */  
    
package com.ccttic.cqytjgpt.enterpriseapi.interfaces.menu;

import com.ccttic.entity.employee.ResMenu;
import com.ccttic.util.exception.ResourceDoNotFonundException;

/**  
    * @ClassName: IResMenuService  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author Administrator  
    * @date 2018年6月6日  
    *    
    */

public interface IResMenuService {
	  /**
	   * 
	      * @Title: selectByExample  
	      * @Description: 根据资源key获取唯一的菜单 
	      * @param @param resources
	      * @param @return    参数  
	      * @return ResMenu    返回类型  
	      * @throws
	   */
	  ResMenu selectByExample(String resources)throws ResourceDoNotFonundException;
	  
	  /**
	   * 
	      * @Title: insertSelective  
	      * @Description: 插入 
	      * @param @param record
	      * @param @return    参数  
	      * @return int    返回类型  
	      * @throws
	   */
	  int insertSelective(ResMenu record);

	  /**
	   * 
	      * @Title: updateByExampleSelective  
	      * @Description: 更新 
	      * @param @param record
	      * @param @param resources
	      * @param @return    参数  
	      * @return int    返回类型  
	      * @throws
	   */
	  int updateByExampleSelective(ResMenu record, String resources);
	  
	  
}
