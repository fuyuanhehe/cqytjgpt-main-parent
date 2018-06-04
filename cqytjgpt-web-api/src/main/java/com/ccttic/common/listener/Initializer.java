package com.ccttic.common.listener;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
/**
 * 
    * @ClassName: Config  
    * @Description: spring session分布式session配置
    * @author syao  
    * @date 2018年6月4日  
    *
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer { 

	public Initializer() {
		super(Config.class); 
	}
}