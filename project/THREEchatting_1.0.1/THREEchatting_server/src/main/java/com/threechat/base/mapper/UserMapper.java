package com.threechat.base.mapper;

import org.springframework.stereotype.Repository;

import com.threechat.base.entity.User;

@Repository
public interface UserMapper {
	/**
	 * 查找用戶
	 * @return 
	 */
	public User findUser(String userName);
}
