package com.threechat.base.services.login;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threechat.base.common.returnentity.ResultEntity;
import com.threechat.base.common.tools.StringUtil;
import com.threechat.base.entity.User;
import com.threechat.base.mapper.UserMapper;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ResultEntity checkUser(String userName, String password) {
		ResultEntity resultEntity = new ResultEntity();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		User user = null;
		if (!"".equals(userName) && userName != null && password != null && !"".equals(password)) {
			user = userMapper.findUser(userName);
			if (StringUtil.isNotNull(user) && user.getPassword().equals(password)) {
				resultEntity.setState(200);
				resultEntity.setMessage("登录成功!");
				retMap.put("user", user);
				resultEntity.setRetResMap(retMap);
			}else {
				resultEntity.setState(400);
				resultEntity.setMessage("登录失败!");
				retMap.put("user", null);
				resultEntity.setRetResMap(null);
			}
		}
		return resultEntity;
	}
}
