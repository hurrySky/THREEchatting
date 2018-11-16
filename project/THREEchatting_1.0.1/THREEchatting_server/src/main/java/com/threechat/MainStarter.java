package com.threechat;

import java.util.Calendar;

import com.threechat.base.server.MySocketServer;

/**
 * 服务启动类
 * @author lixin
 */
public class MainStarter {
	
	public static void main(String[] args) {
		MySocketServer.serverStart(); // 启动服务
	}
}
