package com.threechat.base.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import com.threechat.base.common.config.BaseConfig;
import com.threechat.base.common.operationenum.OperationEnum;
import com.threechat.base.common.returnentity.ResultEntity;
import com.threechat.base.common.tools.SocketUtil;

/**
 * 请求控制服务实现类
 * @author lixin
 *
 */
public class RequestControlService {
	
	private static BaseConfig baseConfig; // 声明配置类对象
	private static Integer port; // 声明端口
	private static String host; // 声明主机地址
	
	/**
	 * 全局输入流
	 */
	private static InputStream inputStream;
	/**
	 * 全局对象输出流
	 */
	private static ObjectInputStream objectInputStream;
	
//	public RequestControlService() {
//	}
	
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
		// 要连接的服务端IP地址和端口
		if (port == null) {
			port = baseConfig.getConfigValueByKey("requestControlPort", Integer.class);
		}
		if (host == null || "".equals(host)) {
			host = baseConfig.getConfigValueByKey("host", String.class);
		}
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
	public static ResultEntity SendRequest(String enum_, HashMap<String, Object> param) throws UnknownHostException, IOException, ClassNotFoundException {
//		 // 要连接的服务端IP地址和端口
//	    String host = "127.0.0.1";
//	    int port = 30705;
//	    // 与服务端建立连接
	    Socket socket = new Socket(host, port);
	    // 发送数据到服务端
	    SocketUtil.SendRequestMap(enum_, param, socket);
	    
	    inputStream = socket.getInputStream();
	    objectInputStream = new ObjectInputStream(inputStream);
	    ResultEntity resultEntity = (ResultEntity) objectInputStream.readObject();
	    socket.close();
		return resultEntity;
	}
}
