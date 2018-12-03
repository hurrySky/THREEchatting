package com.threechat.base.common;

import java.util.HashMap;

/**
 * 请求返回结果封装实体类
 * @author lixin
 *
 */
public class ResultEntity {
	/**
	 * 状态码
	 */
	private Integer state;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 返回对象map结果集
	 */
	private HashMap<String, Object> retResMap;
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HashMap<String, Object> getRetResMap() {
		return retResMap;
	}
	public void setRetResMap(HashMap<String, Object> retResMap) {
		this.retResMap = retResMap;
	}
}
