package com.threechat.base.services.login;

import com.threechat.base.common.returnentity.ResultEntity;

public interface LoginService {
	
	/**
	 * 用户校验
	 * 
	 */
	public ResultEntity checkUser(String userName, String password);
}
