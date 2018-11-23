package com.threechat.base.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;

import com.threechat.base.common.operationenum.OperationEnum;
import com.threechat.base.services.RequestControlService;

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
	public static void login(String userName, String pasword) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", userName);
		paramMap.put("pasword", userName);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap = requestControlService.SendRequest(OperationEnum.login.toString(), paramMap);
		} catch (UnknownHostException e) {
			System.out.println("未知的主机");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
