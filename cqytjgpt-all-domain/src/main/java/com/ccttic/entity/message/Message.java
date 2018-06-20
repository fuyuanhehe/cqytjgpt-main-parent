package com.ccttic.entity.message;

import com.ccttic.entity.BaseBean;

/**
 * 消息发送实体
 * @author zhuliang
 *
 */
public class Message extends BaseBean{
	
	/**
	 * 短信
	 */
	public static final Integer MSG_TYPE_0 = 0;
	
	/**
	 * 邮件
	 */
	public static final Integer MSG_TYPE_1 = 1;
	
	/**
	 * 其他
	 */
	public static final Integer MSG_TYPE_2 = 2;
	
	/**
	 * 未发送
	 */
	public static final Integer STATE_0 = 0;
	
	/**
	 * 已发送
	 */
	public static final Integer STATE_1 = 1;
	
	private String id;         //id
	
	private Integer msgType;   //消息类型
	
	private String sendFrom;   //发送邮件
	
	private String sendTo;     //接收邮件
	
	private String title;      //标题
	
	private String content;    //邮件内容
	
	private Integer state;     // 0未发送 1已发送

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public String getSendFrom() {
		return sendFrom;
	}

	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
