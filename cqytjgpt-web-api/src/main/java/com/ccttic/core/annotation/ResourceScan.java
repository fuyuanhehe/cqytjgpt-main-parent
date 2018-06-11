
package com.ccttic.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
    * @ClassName: ResourceScan  
    * @Description: 资源彩单扫苗
    * @author syao  
    * @date 2018年6月5日  
    *
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceScan {

	/**
	 * @return 当前资源信息
	 */
	Resource rsc();
	
	/**
	 * @return 所有上级资源信息
	 */
	Resource[] prsc() default{};
	
}
