package com.threechat.base.common;

import java.util.HashMap;

public class ResultEntity {
	/**
	 * 状态码
	 */
	private Integer state;
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
	public HashMap<String, Object> getRetResMap() {
		return retResMap;
	}
	public void setRetResMap(HashMap<String, Object> retResMap) {
		this.retResMap = retResMap;
	}
}
