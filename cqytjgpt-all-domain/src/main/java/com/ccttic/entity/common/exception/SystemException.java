package com.ccttic.entity.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
   功能说明：     系统运行异常
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.exception.SystemException.java
 @date  2016年11月30日
 */

public class SystemException extends RuntimeException {
	private static final long serialVersionUID = -5702771675976948545L;
	private Throwable throwable;

	public SystemException() {

	}

	public SystemException(Throwable e) {
		this.throwable = e;
	}

	public SystemException(String string) {
		super(string);
	}

	public String getErrCode() {
		return "error.system.exception";
	}

	public Object[] getArguments() {
		return null;
	}

	@Override
	public String getMessage() {
		return "系统异常！详细信息：" + this.throwable.getMessage();
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
		this.throwable.printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
		this.throwable.printStackTrace(s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);
		this.throwable.printStackTrace(s);
	}
}
