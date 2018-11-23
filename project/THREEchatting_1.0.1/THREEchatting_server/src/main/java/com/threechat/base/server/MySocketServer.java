package com.threechat.base.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.threechat.base.common.tools.SocketUtil;
import com.threechat.base.config.BaseConfig;

public class MySocketServer implements Runnable{
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

	    System.out.println("服务线程启动中...");
		// 监听指定的端口
		try {
			serverSocket = new ServerSocket(port); // 监听指定的端口
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
	    System.out.println("server就绪，持续等待客户端连接...");
	    // 循环监听端口
	    while(true){
	    	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	//System.out.println(".............");
	    	Runnable runnable = new Runnable() {
				@Override
				public void run() {
					
					try {
						
						Socket socket =  serverSocket.accept();
						InputStream inputStream = socket.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						HashMap<String, Object> map = (HashMap<String, Object>)objectInputStream.readObject();
						System.out.println("lentgh" + map.get("length"));
						System.out.println("message" + map.get("message"));
						//StringBuilder stringBuilder = getStrInfoByInputStream(inputStream);
				        //System.out.println(stringBuilder);
						System.out.println("vvvvv" + SocketUtil.isServerClose(socket));
				        OutputStream outputStream = socket.getOutputStream();
					    String message="我是服务端：我收到了。";
					    outputStream.write(message.getBytes());
					    //outputStream.flush();
					    //sendMessage(message, socket);
					    //outputStream.close();
				        inputStream.close();
				        outputStream.close();
				        socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						System.out.println();
					}
				}
		    };
		    threadPool.submit(runnable);
	    }
	    // serverSocket.close();
	}

	private StringBuilder getStrInfoByInputStream(InputStream inputStream) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			byte[] bytes = new byte[1024];
	        int len = 0;
	       
	        while ((len = inputStream.read(bytes)) != -1) {
	        	// 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
	        	stringBuilder.append(new String(bytes, 0, len, "UTF-8"));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringBuilder;
	}
	
	/**
	 * 关闭资源
	 * @param inputStream 
	 * @param socket
	 */
	private void closeAll(InputStream inputStream, Socket socket) {
		try {
			inputStream.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送消息
	 * @param message
	 * @param socket
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void sendMessage(String message, Socket socket) throws UnsupportedEncodingException, IOException {
		OutputStream out = socket.getOutputStream();
		out.write(message.getBytes("UTF-8"));
		out.flush();//清空缓存区的内容
	}
}
