package com.ccttic.cqytjgpt.webapi.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.stereotype.Component;
/**
 * 
    * @ClassName: Config  
    * @Description: spring session分布式session配置
    * @author syao  
    * @date 2018年6月4日  
    *
 */

@Component
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer { 

	public SessionInitializer() {
		super(SessionConfig.class); 
	}
}