  
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
	 * 次级管理员
	 */
	final public static String ADMIN = "ADMIN";
	/**
	 * 最高管理员
	 */
	final public static String SUPERMAN = "SUPERMAN";
	
	/**
	 * 0
	 */
	final public static int ZERO = 0;
	
	/**
	 * 1
	 */
	final public static int ONE = 1;
	
	/**
	 * 2
	 */
	final public static int TWO = 2;
	/**
	 * 3
	 */
	final public static int THREE =3;
	/**
	 * 违法序号长度
	 */
	final public static int XHlength = 16;
	
	final public static String TOKEN = "TOKEN";
	/**
	 * redis 里面的用户生存时间
	 */
	final public static long USER_REDIS_LIVE = 7200 ;
	/**
	 * 从sesssion中获取用户的的key
	 */
	final public static String USER = "USER";
	/**
	 * 从sesssion中获取企业的的key
	 */
	final public static String ENT = "ENT-USER";
	
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
			 * 动态监管 三级菜单
			 */
			public static final String CAR_TRACK="car_track";
			
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
				/**
				 * 轨迹查询 四级菜单
				 */
				public static final String CAR_HISTORY_TRACK="car_history_track";
				/**
				 * 车辆信息查询 四级菜单
				 */
				public static final String CAR_HISTORY_INFO="car_history_info";
    
	/*
	 * 驾驶人监管二级
	 */
	public static final String DRIVER_INFORMATION = "Driver_information";		
		 /*
	      * 驾驶人信息-基本信息 三级
	      */
	        public static final String PERSONAL_INFORMATION = "personal_information";
	   
	         /*
	           * 驾驶人信息-信息记录 三级
	          */
	        public static final String DRIVER_PER = "driver_per";
	        /*
		        * 获取准假车型 四级
		        */
		     public static final String GET_PERMICAR = "get_permicar";
			       /*
			        * 新增驾驶人 四级
			        */
			     public static final String ADD_DRIVER = "add_driver";
			     
			     /*
			        * 基本信息-个人  四级
			        */
			     public static final String BASIC_INFOR = "basic_infor";
			      
			     /*
			      * 基本信息-违法记录 四级
			      */
			     public static final String ILLEGAL_RECORD = "illegal_record";
			     /*
			       * 驾驶人信息-信息记录-详情 四级
			       */
			     public static final String DRIVER_DETAILS = "driver_details";
	 
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
				/**
				 * 查询企业 三级菜单
				 */
				public static final String SELECT_ENTERPRISE="select_enterprise";
				/**
				 * 修改企业 三级菜单
				 */
				public static final String MODIFY_ENTERPRISE="modify_enterprise";
				/**
				 * 删除企业 三级菜单
				 */
				public static final String DELETE_ENTERPRISE="delete_enterprise";
				/**
				 * 组织员工管理 三级菜单
				 */
			    public static final String SELECT_EMPLOYEE = "employee-management";
			    
			    /**
			     * 添加员工
			     */
			    public static final String ADD_EMPLOYEE = "add-employee";
			    
			    /**
			     * 修改员工
			     */
			    public static final String MODIFY_EMPLOYEE ="modify-employee";
			    
			    /**
			     * 删除员工
			     */
			    public static final String DELETE_EMPLOYEE = "delete-employee";
			    
		/**
		  * 岗位管理 二级菜单
		  */
		   public static final String POST_MANAGEMENT = "post-management";
		   			
			   /**
		   		 * 查询岗位 三级菜单
		   		 */
	   			public static final String SELECT_POST = "select-post";
		   		/**
		   		 * 添加岗位 三级菜单
		   		 */
		   		public static final String ADD_POST = "add-post";
		   		
		   		
		   		/**
		   		 * 修改岗位 三级菜单
		   		 */
		   		public static final String MODIFY_POST = "modify-post";
		   		
		   		/**
		   		 * 添加岗位 三级菜单
		   		 */
		   		public static final String DELETE_POST = "delete-post";
		   
		/**
		* 角色管理 二级菜单
	    * */
		 public static final String ROLE_MANAGE = "role-manage";	 
		       /**
		        * 查询角色三级菜单
		        */
		       public static final String QUERY_ROLE = "query-role";
		         /**
		          * 增加角色三级菜单
		          */
		       public static final String ADD_ROLE = "add-role";
		       /**
		        * 删除角色 三级
		        */
		       public static final String DELETE_ROLE = "delete-role";
		       
		       /**
		        * 修改角色 三级
		        */
		       public static final String UPDATE_ROLE = "update-role";
		       /**
				* 功能权限管理 二级菜单
			    * */
		 public static final String MENU_MANAGE = "menu-manage";    
		       /**
	          * 修改权限三级菜单
	          */
	           public static final String UPDATE_MENU = "update-menu";
	           /**
	            * 查询菜单 三级
	            */
	           public static final String QUERY_MENU = "query-menu";
	           /**
	            * 查询所有菜单树
	            */
	           public static final String QUERYALL_MENU = "queryall-menu";
	           /*
	            * 获取所有员工
	            */
	           public static final String GETALL_EMP = "getall-menu";
//***************************系统管理菜单 end************************************************************
	           
	        /**
	   		 * 登录注册审核 一级菜单
	   		 */
	   		public static final String LOGIN_REGISTER_ENTERPRISE="login_register_enterprise";
	   		/**
			 * 注册企业 二级菜单
			 */
			public static final String REGISTER_ENTERPRISE="register_enterprise";
	   		/**
	   		 * 取分所审核 二级菜单
	   		 */
	   		public static final String CHECK_ENTERPRISE="CHECK_ENTERPRISE";
	   		
	   		
}
