package com.threechat.base.services.login;

public interface LoginService {

	/**
	 * 用户校验
	 * 
	 */
	public void checkUser(String userName, String password);
}
