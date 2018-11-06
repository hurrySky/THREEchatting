package com.threechat.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;

/**
 * 登录界面
 * @author lx
 */
public class LoginPage extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 *  初始水平位置
	 */
	private int init_x;
	/**
	 *  初始垂直位置
	 */
	private int int_y;
	/**
	 * 界面宽
	 */
	private int width;
	/**
	 * 界面高
	 */
	private int height;
	
	// 定义界面组件
	
	/**
	 * 初始化读取配置
	 */
	private void init(){
		Properties properties = new Properties();
		// 使用InPutStream流读取properties文件
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("resource/config/LoginPage.properties"));
		} catch (FileNotFoundException e1) {
			System.out.println("配置文件未找到!");
			e1.printStackTrace();
		}
		try {
			properties.load(bufferedReader);
		} catch (IOException e) {
			System.out.println("配置文件加载失败!");
			e.printStackTrace();
		}
		// 获取key对应的value值
		this.init_x = Integer.parseInt(properties.getProperty("init_x"));
		this.int_y = Integer.parseInt(properties.getProperty("int_y"));
		this.width = Integer.parseInt(properties.getProperty("width"));
		this.height = Integer.parseInt(properties.getProperty("height"));
	}
	
	/**
	 * 无参构造方法
	 */
	public LoginPage() {
		init();
		this.setLocation(init_x, int_y);
		this.setSize(width, height);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		LoginPage loginPage = new LoginPage();
	}
}
