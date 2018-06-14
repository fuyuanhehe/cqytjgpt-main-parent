package com.ccttic.util.exception;

/**
   功能说明：     用户名或密码无效异常
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.exception.LoginInvalidException.java
 @date  2016年11月30日
 */

public class LoginInvalidException extends AppException {
	private static final long serialVersionUID = -1032004664848956584L;

	/**
	 * 参数名称
	 */
	private String argNm;

	public LoginInvalidException() {
		super("用户名或密码无效!");
	}

	public LoginInvalidException(String argNm) {
		super(argNm);
		this.argNm = argNm;
	}

	@Override
	public String getErrCode() {
		return "error.login.invalid";
	}

	@Override
	public Object[] getArguments() {
		return new Object[] { argNm };
	}

}
