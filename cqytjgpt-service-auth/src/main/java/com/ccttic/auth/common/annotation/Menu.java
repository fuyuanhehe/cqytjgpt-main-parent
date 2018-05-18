package com.ccttic.auth.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
   功能说明：     菜单注解
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.annotation.Menu.java
 @date  2016年12月3日
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Menu {
	/**
	 * 资源唯一标识，必须且唯一。该资源标识进入权限控制系统的资源体系中，作为授权和权限验证的目标对象之一。
	 * 
	 * @return
	 */
	String resource();

	/**
	 * 资源显示名称
	 * 
	 * @return 资源显示名称
	 */
	String label();

	/**
	 * 菜单项的分组名称，即所属的父级菜单资源标识。
	 * 
	 * @return
	 */
	String group() default "";

	/**
	 * 菜单顺序
	 * 
	 * @return
	 */
	int order() default 0;

	/**
	 * 菜单项图标名称
	 * 
	 * @return 图标名称
	 */
	String icon() default "";

	/**
	 * 菜单描述
	 * 
	 * @return
	 */
	String description() default "";
}
