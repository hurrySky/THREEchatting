package com.threechat.base.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 提供对话服务
 * @author lixin
 * 
 * IP地址+TCP或UDP端口号”就为socket
 * 创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
 */
public class ChattingServerImpl implements ChattingServer{

	/**
	 * 定义绑定到特定端口的服务器套接字
	 */
	private static ServerSocket serverSocket;
	/**
	 *  指定端口
	 */
	private static int port = 30704;
	
	public static void main(String[] args) throws IOException {
		init();
	}
	/**
	 * 初始化
	 * @throws IOException
	 */
	private static void init() throws IOException {
		
		// 监听指定的端口
	    serverSocket = new ServerSocket(port);
	    // server将一直等待连接的到来
	    System.out.println("server就绪，持续等待客户端连接");
	    
	  //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
	    ExecutorService threadPool = Executors.newFixedThreadPool(100);
	    
	    while(true) {
	    	Socket socket = serverSocket.accept();
	    	Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						InputStream inputStream = socket.getInputStream();
						byte[] bytes = new byte[1024];
				        int len = 0;
				        StringBuilder stringBuilder = new StringBuilder();
				        while ((len = inputStream.read(bytes)) != -1) {
				          // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
				          stringBuilder.append(new String(bytes, 0, len, "UTF-8"));
				        }
				          System.out.println("get message from client: " + stringBuilder);
				          Thread.sleep(1000);
				          inputStream.close();
				         // socket.close();
				          
					} catch (Exception e) {
						e.printStackTrace();
					}					
				}
			};
	    	threadPool.submit(runnable);
	    }
	  //  socket.close();
	}
}
