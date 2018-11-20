package com.threechat.base.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

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
}
