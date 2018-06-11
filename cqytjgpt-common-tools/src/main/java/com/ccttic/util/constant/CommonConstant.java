package com.ccttic.util.constant;

/**
   功能说明：     常量
 @version  1.0.0
 @author  xgYin
 @see  com.ccttic.commons.constant.CommonConstant.java
 @date  2016年11月30日
 */

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class CommonConstant {
	//文件上传路径(未使用)
	public static final String UPLOAD_DIR = "/pic";
	//前端文件上传路径(未使用)
	public static final String ONLINE_UPLOAD_DIR = "/onlineFile";
	//违法文件上传路径
	public static final String SERVICE_UPLOAD_DIR = "/opt/tomcat/temp/uploadfile";
	
	//文件上传后的压缩文件名
	public static final String SERVICE_UPLOAD_FILE_PREFIX = "sendBank";
	//模板路径
	public static final String TEMPLATE_DIR = "C://gurarantee//template";
	//DES密钥默认常量
	public static final String DES_KEY_DEFAULT = "studiosoft";
	//登录用户
	public static final String SESSION_USER = "loginUser";
	//不需要验证的Controller方法
	public static final String[] EXCLUDE_METHODS = new String[] { "login", "main", "logout",
			"register","findpassword","checkzjnum","checkphonenum","loginout",
			//绑定车辆
			"bindcar","bc","idc","yzm","querysjhm","qcar","getbind","gb",
			//绑定驾驶人
			"binddriver","bd","qd","querydriverlicense","querystudykm","sm","ubd","afd","dfd","fd","gfd","sd",
			"writstudylog",
			//接口IP邦定测试
			"test1","qry","wrt","wrtver",
			//考试
			"ts2","tests","getTests","checkAnswer",
			//各类号牌种类代码表
			"code","gc","unauthorized",
			//题库
			"postInit","findAllPost","qryOneCompany","editCompany","delCompany",
			//后台密码修改
			"modPasswd","qryPasswd","updPasswd",
			//上传文件
			"uploadfile","upp",
			//违法举报记录
			"launchIllegalReport","queryillegalreportbysfzmh","queryillegalreportbylsh","sendmsg","msg","checkcode"
			
	};
	//http请求JSON类型
	public static final String ACCEPT_TYPE = "application/json";

	/**
	 * 短信常量
	 */
	//短信地址
	public final static String smsUrl = "";
	//账号
	public final static String smsAccount = "";
	//密码
	public final static String smsPassword = "";
	//编码
	public final static String smsEncode = "GB2312";
	
	/**
	 * 工作流常量
	 */
	//流程发起人编号
	public static final String PROCESSSTARTER = "processStarter";

	// 流程签批Key
	public final static String OPINION_KEY = "opinion_key";

	//主流程调用子流程所用输入输出变量
	// <activiti:in source="varMainProcess" target="varSubProcess"></activiti:in>
	// <activiti:out source="varSubProcess" target="varMainProcess"></activiti:out>
	public final static String VAR_MAIN_PROCESS = "varMainProcess";
	public final static String VAR_SUB_PROCESS = "varSubProcess";

	//多实列任务
	//多实列签批变量
	public final static String ASSIGNEE = "${assignee}";
	
	//多实列参与人员变量
	public final static String MULTI_COLLECTION = "${assigneeList}";
	//多实列会签变量
	public final static String MULTI_ELEMENT = "assignee";
	//多实例会签完成条件变量
	public final static String MULTI_COMPLETION_CONDITION = "${nrOfCompletedInstances/nrOfInstances == 1}";

	//系统任务处理类变量
	public final static String SERVICE_HANDLER = "${systemTaskHandler}";

	//任务节点监听器变量
	//创建（用户任务）之前变量
	public final static String TASK_CREATE_LISTENER = "${taskCreateListener}";
	//完成（用户任务）之后变量
	public final static String TASK_COMPLETE_LISTENER = "${taskCompleteListener}";

	//开始（系统任务/调用子流程）之前变量
	public final static String EXECUTION_START_LISTENER = "${executionStartListener}";
	//结束（系统任务/调用子流程）之后变量
	public final static String EXECUTION_END_LISTENER = "${executionEndListener}";
	
	//订单预处理作废时间10分钟
	public final static Integer ORDER_PRIORDEL_TIMELIMIT = 10;
	
	public final static String AUTHORIZATION = "Authorization";
	
	/**
	 * 考试的题目总数
	 */
	public final static Integer TEST_TOTAL_NUM = 30;
	
	/**
	 * 达到合格，题目的数量
	 */
	public final static Integer TEST_PASS_NUM = 9;
	
	/**
	 * 根据Id获取题目失败
	 */
	public final static Integer GET_TESTS_FAIL = -99;
	
	/**
	 * 根据Id获取题目的数量不对
	 */
	public final static Integer GET_TESTS_NUM_WRONG = -98;
	
	/**
	 * 考试通过(0)
	 */
	public final static Integer TEST_RESULT_PASS = 0;
	
	/**
	 * 考试未通过(1)
	 */
	public final static Integer TEST_RESULT_FAIL = 1;
	
	/**
	 * 调用ws成功,返回的Code(1)
	 */
	public final static String WS_SUCCESS_CODE = "1";
	/**
	 * 违法视频和图片上传地址
	 */
	public final static String FILE_URL="http://113.204.53.10/temp";
	/**
	 * 接口授权码
	 */
	public final static String JKSQM="89485270542937088955095752601831";
	
	/**
	 * 解密KEY
	 */
	public final static String ENKEY="ABCDEF0123456789";
	/**
	 * 终端用户代号
	 */
	public final static String ZDYHDH="11";
	/**
	 * 终端用户姓名
	 */
	public final static String ZDYHXM="1";
	/**
	 * 终端标识
	 */
	public final static String ZDBS="2";
	/**
	 * 终端电子坐标
	 */
	public final static String ZDDZZB="3";
	
	/**
	 * 接受缴费结果接口约定的key
	 * 
	 * **/
	public final static String SHA256KEY="2FStH7sEtSM-xVGUKlflc5kdAYwpwc6y";
	
	
}
