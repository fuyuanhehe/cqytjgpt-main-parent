  
    /**    
    * @Title: Const.java  
    * @Package com.ccttic.util.common  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author Administrator  
    * @date 2018年6月4日  
    * @version V1.0    
    */  
    
package com.ccttic.util.common;

  
    /**  
    * @ClassName: Const  
    * @Description: 常量类，系统中所有的常量都定义在里面
    * @author syao  
    * @date 2018年6月4日  
    *    
    */

public class Const {
	
	/**
	 * 从sesssion中获取用户的的key
	 */
	final public static String USER = "USER";
	
	/**
	 * 从session中获取登录验证面的key
	 */
	final public static String PIC_CODE = "PIC_CODE";
	
	/**
	 * resmenu表中系统根菜单
	 */
	public static final String ROOT = "Root";
	
	
//***************************日常监管菜单 start************************************************************
	/**
	 * 日常监管 一级菜单
	 */
	public static final String DAY_SUPERVISE="day-supervise";
		/**
		 * 车辆监管 二级菜单
		 */
		public static final String CAR_SUPERVISE="car-supervise";
		
			/**
			 * 车辆信息（基本信息） 三级菜单
			 */
			public static final String CAR_BASE_INFO="car-base-info";
				/**
				 * 添加车辆 四级菜单
				 */
				public static final String ADD_CAR="add-car";
//***************************日常监管菜单 end**************************************************************			
}
