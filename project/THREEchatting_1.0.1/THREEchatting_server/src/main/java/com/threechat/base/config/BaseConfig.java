package com.threechat.base.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseConfig {
	
	private static BaseConfig baseConfig;;
	
	private Properties properties;
	/**
	 * 私有无参构造方法
	 */
	private BaseConfig() {
		initConfigValue();
	}
	
	/**
	 * 获得单例
	 * @return
	 */
	public static BaseConfig getSingletonInstance() {
		if (baseConfig == null) {
			baseConfig = new BaseConfig();
		}
		return baseConfig;
	}
	
	private void initConfigValue() {
		properties = new Properties();
		// 使用InPutStream流读取properties文件
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("resources/config/serverConfig.properties"));
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
	}
	
	/**
	 * 根据键值获得服务配置的值
	 * @param key 键值
	 * @param class1 
	 * @return T类对象
	 */
	@SuppressWarnings("unchecked")
	public <T> T  getConfigValueByKey (String key, Class<T> c) {
		T t = (T) new Integer(0);
		if (t instanceof Integer) {
			t = (T) Integer.valueOf((String) properties.get(key));
		}else if (t instanceof String) {
			t = (T) properties.get(key);
		}
		return t;
	}
}
