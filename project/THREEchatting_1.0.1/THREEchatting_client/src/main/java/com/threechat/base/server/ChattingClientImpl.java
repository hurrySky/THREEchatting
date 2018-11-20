package com.threechat.base.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class ChattingClientImpl implements ChattingClient{
	public static void main(String args[]) throws UnknownHostException, IOException{
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
	    //sendMessage(String.valueOf(len), socket);
	    //socket.shutdownOutput();
	    //sendMessage(message, socket);
	    InputStream inputStream = socket.getInputStream();
		StringBuilder stringBuilder = getStrInfoByInputStream(inputStream);
	    System.out.println(stringBuilder);
	    outputStream.close();
	    socket.close();
	}
	
	/**
	 * 发送消息
	 * @param message
	 * @param socket
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void sendMessage(String message, Socket socket) throws UnsupportedEncodingException, IOException {
		socket.getOutputStream().write(message.getBytes("UTF-8"));
	}
	
	public static void sendMessageMap(String message,int length, Socket socket) throws UnsupportedEncodingException, IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("length", length);
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
}
