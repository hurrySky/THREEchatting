package com.threechat.base.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import com.threechat.base.common.operationenum.OperationEnum;
import com.threechat.base.common.tools.SocketUtil;

public class RequestControlService {
	/**
	 * 全局输入流
	 */
	private static InputStream inputStream;
	/**
	 * 全局对象输出流
	 */
	private static ObjectInputStream objectInputStream;
	
	private RequestControlService() {
	}
	
	/**
	 * 向服务器发送请求
	 * @param enum_ 操作类型
	 * @param param 参数数组
	 * @return 返回Map,Map既请求的结果
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws ClassNotFoundException 
	 */
	public static HashMap<String, Object> SendRequest(OperationEnum enum_, HashMap<String, Object> param) throws UnknownHostException, IOException, ClassNotFoundException {
		 // 要连接的服务端IP地址和端口
	    String host = "127.0.0.1";
	    int port = 30705;
	    // 与服务端建立连接
	    Socket socket = new Socket(host, port);
	    // 发送数据到服务端
	    SocketUtil.SendRequestMap(enum_, param, socket);
	    
	    inputStream = socket.getInputStream();
	    objectInputStream = new ObjectInputStream(inputStream);
	    HashMap<String, Object> map = (HashMap<String, Object>)objectInputStream.readObject();
	    socket.close();
		return map;
	}
}
