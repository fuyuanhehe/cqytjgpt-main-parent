package com.ccttic.auth.common.exception;

/**
   功能说明：     无效参数异常
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.exception.InvalidArgumentException.java
 @date  2016年12月11日
 */

public class InvalidArgumentException extends AppException {

	private static final long serialVersionUID = 4868456131016604456L;
	/**
	 * 参数名称
	 */
	private String argNm;
	/**
	 * 参数值
	 */
	private String value;

	public InvalidArgumentException(String argNm) {
		super("参数" + argNm + "值不能为空!");
		this.argNm = argNm;
		this.value = null;
	}

	public InvalidArgumentException(String argNm, String value) {
		super("参数" + argNm + "值不能为" + value + "!");
		this.argNm = argNm;
		this.value = value;
	}

	@Override
	public String getErrCode() {
		return "error.argument.invalid";
	}

	@Override
	public Object[] getArguments() {
		return new Object[] { argNm, value };
	}

}
