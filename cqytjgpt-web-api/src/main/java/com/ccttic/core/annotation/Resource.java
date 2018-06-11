package com.ccttic.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
    * @ClassName: Resource  
    * @Description: 资源注入 
    * @author syao  
    * @date 2018年6月5日  
    *
 */
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Resource {

	/**
	 * @return 全局唯一资源编号
	 */
	String cd();
	
    /**
     * @return 资源名称
     */
    String name();
	
	/**
     * 
     * @return 资源标识 可以为空
     */
    String id() default "";
    
    /**
     * @return 父亲节点编号
     */
    String pcd();
    
    /**
     * @return 资源地址
     */
    String url() default "";
    
    /**
     * @return 层级
     */
    int hierarchy();
    
    boolean isMenue() default false;
    
    boolean available() default true;
    
    String icon() default "";
    
    int sortOrder() default 1;
    
    String description() default "";
    
}
