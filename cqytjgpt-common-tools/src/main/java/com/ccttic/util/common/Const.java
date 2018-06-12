  
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
			 * 违法信息（违法信息） 三级菜单
			 */
			public static final String CAR_ILLICIT_INFO="car-illicit-info";
			
				/**
				 * 添加车辆 四级菜单
				 */
				public static final String ADD_CAR="add-car";
				/**
				 * 修改车辆 四级菜单（调取信息）
				 */
				public static final String MODIFICATION_CAR="modification-car";
				/**
				 * 车辆详情 四级菜单
				 */
				public static final String PARTICULARS_INFO="particulars-info";
				/**
				 * 违法信息 四级菜单
				 */
				public static final String ILLICIT_INFO="illicit-info";
				/**
				 * 违法详情 四级菜单
				 */
				public static final String ILLICIT_PARTICULARS="illicit-particulars";
				
//***************************日常监管菜单 end************************************************************
				
//***************************系统管理菜单 start**********************************************************
		/**
		 * 系统管理 一级菜单
		 */
		public static final String SYSTEM_SUPERVISE="system-supervise";
			/**
			 * 组织管理 二级菜单
			 */
			public static final String ORGANIZATION_SUPERVISE="organization-supervise";
			
				/**
				 * 获取树头 三级菜单
				 */
				public static final String GET_HEAD="get_Head";
				/**
				 * 获取树头 三级菜单
				 */
				public static final String GET_NEXT_NODE="get_next_node";
				/**
				 * 获取组织信息 三级菜单
				 */
				public static final String GET_ORGANIZATION="get_organization";
				/**
				 * 创建组织 三级菜单
				 */
				public static final String ADD_ORGANIZATION="add_organization";
				/**
				 * 修改组织 三级菜单
				 */
				public static final String MODIFICATION_ORGANIZATION="modification_organization";
				/**
				 * 删除组织 三级菜单
				 */
				public static final String DELETE_ORGANIZATION="delete_organization";
				/**
				 * 获取部门信息 三级菜单
				 */
				public static final String GET_DEPARTMENT="get_department";
				/**
				 * 创建部门 三级菜单
				 */
				public static final String ADD_DEPARTMENT="add_department";
				/**
				 * 修改部门 三级菜单
				 */
				public static final String MODIFICATION_DEPARTMENT="modification_department";
				/**
				 * 修改部门 三级菜单
				 */
				public static final String DELETE_DEPARTMENT="delete_department";
				/**
				 * 创建企业 三级菜单
				 */
				public static final String ADD_ENTERPRISE="add_enterprise";
			
			
		
//***************************系统管理菜单 end************************************************************
}
