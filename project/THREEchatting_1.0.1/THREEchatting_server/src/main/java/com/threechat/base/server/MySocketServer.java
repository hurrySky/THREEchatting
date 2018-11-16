package com.threechat.base.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.threechat.base.config.BaseConfig;

public class MySocketServer implements Runnable{
	/**
	 * 定义绑定到特定端口的服务器套接字
	 */
	private static ServerSocket serverSocket;

	/**
	 * 配置文件
	 */
	private static BaseConfig baseConfig;
	/**
	 * 端口
	 */
	private static Integer port;
    
    //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
	
	public static void main(String[] args) {
		serverStart(); // 启动服务
	}
	
	/**
	 * 服务器启动类
	 */
	public static void serverStart() {
		MySocketServer mySocketServer = new MySocketServer();
		Thread server = new Thread(mySocketServer);
		server.setName("ThreeChat Server");
		System.out.println("服务名称:" +server.getName());
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
			port = baseConfig.getConfigValueByKey("port", Integer.class);
			System.out.println("端口名称:" +port);
		}
	}

	@Override
	public void run() {
//		// 监听指定的端口
//		serverSocket = new ServerSocket(port);
//		// server将一直等待连接的到来
//	    System.out.println("server就绪，持续等待客户端连接");
//	    // 循环监听端口
//	    while (true) {
//	    	Socket socket = serverSocket.accept();
//	    }
	    System.out.println("服务线程启动中...");
	    try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    System.out.println("server就绪，持续等待客户端连接...");
	    while(true){
	    	try {
				Socket socket = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
		    Runnable runnable = new Runnable() {
		    	
				@Override
				public void run() {
				}
		    };
		    threadPool.submit(runnable);
	    }
	    
//		try {
//			
//			InputStream inputStream = socket.getInputStream();
//			byte[] bytes = new byte[1024];
//	          int len = 0;
//	          StringBuilder stringBuilder = new StringBuilder();
//	          while ((len = inputStream.read(bytes)) != -1) {
//	            // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
//	        	  stringBuilder.append(new String(bytes, 0, len, "UTF-8"));
//	          }
//	          System.out.println("get message from client: " + stringBuilder);
//	          Thread.sleep(1000);
//	          inputStream.close();
//	         // socket.close();
//	          
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
