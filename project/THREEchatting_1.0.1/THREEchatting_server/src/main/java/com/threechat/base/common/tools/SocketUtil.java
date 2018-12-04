package com.threechat.base.common.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.HashMap;

import com.threechat.base.common.returnentity.ResultEntity;

/**
 * socket 收发消息时用到的工具类
 * @author Lixin
 *
 */
public class SocketUtil {
	
	private static Integer sotimeout=1*1*10;//超时时间，以毫秒为单位 
	
	/**
	 * 主方法
	 * @param args
	 */
	public static void main(String args[]){
		
	}
	
	/**
	* 读取数据，返回字符串类型
	* @param csocket
	* @return
	*/ 
	public static String ReadText(Socket socket){ 
	   try{
		   socket.setSoTimeout(sotimeout);
		    InputStream input = socket.getInputStream();
		    BufferedReader in = new BufferedReader(new InputStreamReader(input));
		    char[] sn = new char[1000];
		    in.read(sn);
		    String sc = new String(sn);
		    return sc;
	   }catch(IOException se){ 
	    return null; 
	   } 
	}
	/**
	* 判断是否断开连接;断开返回true,没有返回false
	* @param socket
	* @return
	*/ 
	public static Boolean isServerClose(Socket socket){
	   try{
	    socket.sendUrgentData(0xFF);//发送1个字节的紧急数据，默认情况下，服务器端没有开启紧急数据处理，不影响正常通信 
	    return false;
	   }catch(Exception se){
	    return true;
	   }
	}
	/**
	 * 发送map对象消息
	 * @param message
	 * @param length
	 * @param socket
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void SendResponse(ResultEntity resultEntity, Socket socket) throws UnsupportedEncodingException, IOException {

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		objectOutputStream.writeObject(resultEntity);
		// objectOutputStream.close(); 对象输出流关闭则socket也会关闭
	}
}
