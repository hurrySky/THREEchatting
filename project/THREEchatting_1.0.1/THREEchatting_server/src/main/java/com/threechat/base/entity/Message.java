package com.threechat.base.entity;

import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 序列UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  消息ID
	 */
	private String MessageId;
	/**
	 * 消息
	 */
	private String Message;
	/**
	 * 登录名/账号
	 * @return
	 */
	private String loginName;
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getMessageId() {
		return MessageId;
	}
	public void setMessageId(String messageId) {
		MessageId = messageId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
