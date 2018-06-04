package com.ccttic.entity.common.beans;

import java.io.Serializable;

public class ResponseMsg<T> implements Serializable{

	private static final long serialVersionUID = 7302468380401978723L;
	
	public static final Integer STATUS_SUCCES = 0;
	
	public static final Integer STATUS_FAIL = -1;
	
	private Integer status;
	
	private String  messsage;
	
	private T data;
	
	private Integer total = 0;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void success(String msg){
		this.messsage = msg;
		this.status = STATUS_SUCCES;
	}
	
	public void fail(String msg){
		this.messsage = msg;
		this.status = STATUS_FAIL;
	}
	

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ResponseMsg [status=" + status + ", messsage=" + messsage + ", data=" + data + ", total=" + total + "]";
	}
	
}
