package com.ccttic.auth.common.exception;

/**
   功能说明：     业务抽象异常
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.exception.AppException.java
 @date  2016年11月30日
 */

public abstract class AppException extends Exception {
	private static final long serialVersionUID = 6266618979568625272L;

	public AppException() {

	}

	public AppException(String msg) {
		super(msg);
	}

	/**
	 * 返回异常代码
	 * 
	 * @return
	 */
	public abstract String getErrCode();

	/**
	 * 返回异常参数
	 * 
	 * @return
	 */
	public abstract Object[] getArguments();
}
