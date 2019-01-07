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
	private String messageId;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 登录名/账号
	 */
	private String loginName;
	/**
	 * 用户编号
	 */
	private String code;
	
	/**
	 * 发送时间
	 */
	private String sendTime;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message
				+ ", loginName=" + loginName + ", code=" + code + ", sendTime="
				+ sendTime + "]";
	}
}
