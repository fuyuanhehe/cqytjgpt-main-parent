  
    /**    
    * @Title: ResMenuServiceImpl.java  
    * @Package com.ccttic.service.menu.impl  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author Administrator  
    * @date 2018年6月6日  
    * @version V1.0    
    */  
    
package com.ccttic.cqytjgpt.webapi.service.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.ccttic.cqytjgpt.webapi.interfaces.menu.IResMenuService;
import com.ccttic.cqytjgpt.webapi.mapper.employee.ResMenuMapper;
import com.ccttic.entity.employee.ResMenu;
import com.ccttic.entity.employee.ResMenuExample;
import com.ccttic.util.exception.ResourceDoNotFonundException;

/**  
    * @ClassName: ResMenuServiceImpl  
    * @Description: 资源菜 单服务  
    * @author Administrator  
    * @date 2018年6月6日  
    *    
    */
@Service

public class ResMenuServiceImpl implements IResMenuService {
	
	  @Autowired
	  private ResMenuMapper resMenuMapper;
	  

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param record
	    * @return  
	    * @see com.ccttic.service.menu.IResMenuService#insertSelective(com.ccttic.entity.employee.ResMenu)  
	    */  
	    
	@Override
	@Transactional
	public int insertSelective(ResMenu record) {
		int row = resMenuMapper.insertSelective(record);
		return row;
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param record
	    * @param resources
	    * @return  
	    * @see com.ccttic.service.menu.IResMenuService#updateByExampleSelective(com.ccttic.entity.employee.ResMenu, java.lang.String)  
	    */  
	    
	@Override
	@Transactional
	public int updateByExampleSelective(ResMenu record, String resources) {
		ResMenuExample example = new ResMenuExample();
		example.createCriteria().andResourceEqualTo(resources);
		int row = resMenuMapper.updateByExampleSelective(record, example);
		return row;
	}


	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param resources
	    * @return
	    * @throws ResourceDoNotFonundException  
	    * @see com.ccttic.service.menu.IResMenuService#selectByExample(java.lang.String)  
	    */  
	    
	@Override
	public ResMenu selectByExample(String resources) throws ResourceDoNotFonundException {
		ResMenuExample example = new ResMenuExample();
		example.createCriteria().andResourceEqualTo(resources);
		List<ResMenu> menus = resMenuMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(menus)) {
			throw new ResourceDoNotFonundException("["+resources+"],的资源数据在resmenu表中没有查找到.");
		}
		return menus.get(0);
	}

}
