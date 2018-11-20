package com.threechat.base.entity;

import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 序列UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  消息
	 */
	private String Message;
	/**
	 *  消息ID
	 */
	private String MessageId;
	
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
}
