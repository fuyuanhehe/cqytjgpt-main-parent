package com.ccttic.common.exception;

public class DeleteRefusedException extends AppException {

	private static final long serialVersionUID = -2675792821254102550L;
	/**
	 * 删除的数据
	 */
	private String data;

	public DeleteRefusedException(String data) {
		super(data);
		this.data = data;
	}

	@Override
	public String getErrCode() {
		return "warning.delete.refuse";
	}

	@Override
	public Object[] getArguments() {
		return new Object[] { data };
	}

}
