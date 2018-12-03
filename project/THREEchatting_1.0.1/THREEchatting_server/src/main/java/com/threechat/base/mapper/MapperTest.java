package com.threechat.base.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mapperTest")
public class MapperTest {

	@Autowired
	private UserMapper userMapper;
	public MapperTest() {
		System.out.println("33333333333333333");
	}
	
	public static void main(String[] args) {
	//	userMapper.findUser("admin");
	}

	public void findUser() {
		userMapper.findUser("admin");
	}
}
