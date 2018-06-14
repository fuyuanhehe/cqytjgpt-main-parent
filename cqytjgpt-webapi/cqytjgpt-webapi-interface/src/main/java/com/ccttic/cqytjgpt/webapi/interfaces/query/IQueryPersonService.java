package com.ccttic.cqytjgpt.webapi.interfaces.query;


import com.ccttic.entity.drivers.XMLDriver; 

/**
 * 功能说明： 查询驾驶员业务接口
 * 
 * @version 1.0.0
 * @author zenghy
 * @see com.studio.framework.service.query.IQueryPersonService.java
 * @date 2018年1月24日
 */

public interface IQueryPersonService {
     /**
     * 根据身份证明号码，获取驾驶人简要信息
     *
     */
	public XMLDriver QueryPersonByIDCard(String IDCard) throws Exception;
	
}
