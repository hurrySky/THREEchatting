package com.threechat.base.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.threechat.base.config.BaseConfig;

public class ReponseControlService implements Runnable{
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

	public static void main(String[] args) {
		serverStart(); // 启动服务
	}

	/**
	 * 服务器启动类
	 */
	public static void serverStart() {
		ReponseControlService reponseControlService = new ReponseControlService();
		Thread server = new Thread(reponseControlService);
		server.setName("ThreeChat Control Server");
		System.out.println("操作控制服务名称:" +server.getName());
		server.start();
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
			System.out.println("操作控制服务端口名称:" +port);
		}
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
	    System.out.println("操作控制服务就绪，持续等待客户端连接...");
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
				doRequestMap(map); // 处理请求
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }
	}
	
	/**
	 * 处理请求，返回响应
	 */
	public void doRequestMap(HashMap<String, Object> map) {
		System.out.println(map.get("operation"));
		String enum_ = map.get("operation").toString();
		@SuppressWarnings("unchecked")
		HashMap<String, Object> param =  (HashMap<String, Object>) map.get("param");
		if ("login".equals(enum_) && enum_ != null) {
			String userName = (String) param.get("userName");
			String password = (String) param.get("password");
			
		}else if (true) {
			
		}
	}
}
