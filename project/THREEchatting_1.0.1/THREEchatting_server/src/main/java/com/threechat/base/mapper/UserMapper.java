package com.threechat.base.mapper;

import com.threechat.base.entity.User;

public interface UserMapper {
	/**
	 * 查找用戶
	 * @return 
	 */
	public User findUser(String userName);
}
