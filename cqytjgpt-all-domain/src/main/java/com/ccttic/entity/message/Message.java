package com.ccttic.entity.message;

import com.ccttic.entity.BaseBean;

/**
 * 消息发送实体
 * @author zhuliang
 *
 */
public class Message extends BaseBean{
	private String id;      //id
	
	private String sendfrom;  //发送邮件
	
	private String sendTo;  //接收邮件
	
	private String title;   //标题
	
	private String content; //邮件内容
	
	private String state;  // -1 发送失败 0未发送 1已发送
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSendfrom() {
		return sendfrom;
	}

	public void setSendfrom(String sendfrom) {
		this.sendfrom = sendfrom;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sendfrom=" + sendfrom + ", sendTo=" + sendTo + ", title=" + title + ", content="
				+ content + ", state=" + state + "]";
	}
}
