package com.threechat.base.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.threechat.base.common.config.BaseConfig;
import com.threechat.base.common.tools.SocketUtil;
import com.threechat.base.common.tools.TimeUtil;
import com.threechat.base.entity.Message;
import com.threechat.base.entity.User;

public class ChattingClientImpl implements ChattingClient{
	
	private static BaseConfig baseConfig; // 声明配置类对象
	private static Integer port; // 声明端口
	private static String host; // 声明主机地址
	
	public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException{
		 // 要连接的服务端IP地址和端口
	    String host = "127.0.0.1";
	    int port = 30704;
	    // 与服务端建立连接
	    Socket socket = new Socket(host, port);
	    // 建立连接后获得输出流
	    OutputStream outputStream = socket.getOutputStream();
	    String message="你好好从上面的代码可以得知PPPP";
	    int length = message.length();
	    sendMessageMap(message, length, socket);
	    System.out.println("vvvvv" + SocketUtil.isServerClose(socket));
	    //sendMessage(String.valueOf(len), socket);
	    //socket.shutdownOutput();
	    //sendMessage(message, socket);
	    
	    InputStream inputStream = socket.getInputStream();
	    getObjectInfoByInputStream(inputStream);
//		StringBuilder stringBuilder = getStrInfoByInputStream(inputStream);
//	    System.out.println(stringBuilder);
	    outputStream.close();
	    socket.close();
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
		baseConfig = BaseConfig.getSingletonInstance();
		if (port == null) {
			port = baseConfig.getConfigValueByKey("port", Integer.class);
			System.out.println("对话服务端口名称:" + port);
		}
		
		if (host == null || "".equals(host)) {
			host = baseConfig.getConfigValueByKey("host", String.class);
			System.out.println("对话服务主机地址:" + host);
		}
	}
	
	/**
	 * 处理 聊天任务
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws ClassNotFoundException 
	 */
	public static void doChat(String sendText, User user) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket = new Socket(host, port);
		sendMessageMap(sendText, socket, user);
		// socket.shutdownOutput(); // 通过Socket关闭输出流,缺点是不能再次向服务端发送消息
		InputStream inputStream = socket.getInputStream();
		Message message = getObjectInfoByInputStream(inputStream);
//		StringBuilder stringBuilder = getStrInfoByInputStream(inputStream);
//	    System.out.println("服务端消息" + stringBuilder);
	}
	/**
	 * 发送消息
	 * @param message
	 * @param socket
	 */
	public static Boolean sendMessage(String message, Socket socket) {
		Boolean flag = false;
		try {
			socket.getOutputStream().write(message.getBytes("UTF-8"));
			flag = true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return flag;
		} catch (IOException e) {
			
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	
	/**
	 * 发送map对象消息
	 * @param message
	 * @param length
	 * @param socket
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void sendMessageMap(String message,int length, Socket socket) throws UnsupportedEncodingException, IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("length", length);
		map.put("message", message);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		objectOutputStream.writeObject(map);
	}
	
	/**
	 * 发送map对象消息
	 * @param message 文本消息
	 * @param socket
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void sendMessageMap(String _message, Socket socket, User user) throws UnsupportedEncodingException, IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Message message = new Message();
		message.setMessage(_message);
		message.setSendTime(TimeUtil.getYYYYMMDDTime(new Date()));
		message.setCode(user.getCode());
		map.put("message", message);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		objectOutputStream.writeObject(map);
	}
	
	private static StringBuilder getStrInfoByInputStream(InputStream inputStream) {
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
	
	private static Message getObjectInfoByInputStream(InputStream inputStream) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Message message = (Message) objectInputStream.readObject();
		System.out.println(message);
		return message;
	}
}
