package com.threechat.base.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.threechat.base.common.config.BaseConfig;
import com.threechat.base.common.returnentity.ResultEntity;
import com.threechat.base.common.tools.SocketUtil;
import com.threechat.base.common.tools.StringUtil;
import com.threechat.base.entity.User;
import com.threechat.base.mapper.UserMapper;
import com.threechat.base.services.login.LoginService;
//("reponseControlService")
@Component
public class ReponseControlService implements Runnable{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private LoginService loginService;
	/**
	 * 绑定到特定端口的服务器套接字
	 */
	private static ServerSocket serverSocket = null;
	/**
	 * 配置文件
	 */
	private static BaseConfig baseConfig;
	/**
	 * 端口
	 */
	private static Integer port;

	public ReponseControlService() {
		
	}
	public ReponseControlService(LoginService loginService){
		this.loginService = loginService;
	}
	public static void main(String[] args) {
		//serverStart(); // 启动服务
	}
	/**
	 * 初始化 端口
	 */
	static{
		// 静态代码块在类初始化的时候执行
		// 类运行有以下步骤
		// 1.装载
		// 2.连接
		// 3.初始化
		if (port == null) {
			baseConfig = BaseConfig.getSingletonInstance();
			port = baseConfig.getConfigValueByKey("control_port", Integer.class);
			System.out.println("请求控制服务端口名称:" +port);
		}
	}
	/**
	 * 服务器启动类
	 */
	public void serverStart() {
		ReponseControlService reponseControlService = new ReponseControlService(loginService);
		Thread server = new Thread(reponseControlService);
		server.setName("ThreeChat Control Server");
		System.out.println("请求控制服务名称:" +server.getName());
		server.start();
	}
	
	@Override
	public void run() {
		
		System.out.println("操作控制服务线程启动中...");
		// 监听指定的端口
		try {
			serverSocket = new ServerSocket(port); // 监听指定的端口
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    System.out.println("操作控制服务就绪，等待客户端连接...");
	    // 循环监听端口
	    while(true){
	    	try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	    	try {
				Socket socket =  serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				
				HashMap<String, Object> map = (HashMap<String, Object>)objectInputStream.readObject();
				ResultEntity resultEntity = doRequestMap(map); // 处理请求
				SocketUtil.SendResponse(resultEntity, socket);
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }
	}
	
	/**
	 * 处理请求，返回响应
	 */
	public ResultEntity doRequestMap(HashMap<String, Object> map) {
		ResultEntity resultEntity = new ResultEntity();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		User user = null;
		if (StringUtil.isNotNull(map)) {
			String operation_enum = map.get("operation").toString();
			HashMap<String, Object> param =  (HashMap<String, Object>)map.get("param");
			// 登录操作
			if ("login".equals(operation_enum) && operation_enum != null) {
				String userName = (String) param.get("userName");
				String password = (String) param.get("password");
				resultEntity = loginService.checkUser(userName, password);
				
			}else if (true) {
				
			}
		}
		return resultEntity;
	}
	/**
	 * 测试用
	 * 打印小明对应的用户对象
	 */
//	public void printUser(){
//		User user = userMapper.findUser("xiaoming");
//		System.out.println(user);
//	}
}
