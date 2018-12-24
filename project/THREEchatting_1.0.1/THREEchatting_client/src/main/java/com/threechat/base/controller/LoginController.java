package com.threechat.base.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;

import com.threechat.base.common.operationenum.OperationEnum;
import com.threechat.base.common.returnentity.ResultEntity;
import com.threechat.base.entity.User;
import com.threechat.base.services.RequestControlService;
import com.threechat.view.chattingpage.ChattingPageImpl;

public class LoginController {
	/**
	 * 请求控制service
	 */
	private static RequestControlService requestControlService = new RequestControlService();

	public static void main(String[] args) {

	}

	/**
	 * 登录
	 */
	public static ResultEntity login(String userName, String password) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		ResultEntity resultEntity = new ResultEntity();
		paramMap.put("userName", userName);
		paramMap.put("password", password);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultEntity = requestControlService.SendRequest(OperationEnum.login.toString(), paramMap);
		} catch (UnknownHostException e) {
			System.out.println("未知的主机");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resultEntity);
		return resultEntity;
	}
	
	/**
	 * 跳转到chating 界面
	 */
	public static void toChattingPage(HashMap<String, Object> retResMap) {
		User user = null;
		if (retResMap != null) {
			user = (User) retResMap.get("user");
		}
		ChattingPageImpl chattingPage = new ChattingPageImpl(user);
	}
}
