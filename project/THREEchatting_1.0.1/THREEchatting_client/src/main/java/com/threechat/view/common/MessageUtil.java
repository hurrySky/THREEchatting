package com.threechat.view.common;

import java.awt.Font;
import java.awt.FontMetrics;

/**
 * 发送消息工具类
 * 获得某字体文本的实际像素宽和像素高
 * @author lixin
 *
 */
public class MessageUtil {

	public static void main(String[] args) {
		Font font = new Font("宋体",Font.BOLD,10);
		String messages = "你好吗";
		getWordHeight(font,messages);
	}
	
	public static int  getWordHeight(Font font, String messages){
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
		// 高度 
	    System.out.println("height： " + fm.getHeight());
	    // 单个字符宽度
//	    System.out.println(fm.charWidth('A'));
	    // 整个字符串的宽度 
//	    System.out.println(fm.stringWidth("A"));
	    return fm.getHeight();
	}
	
	public static int getWordWidth(Font font, String messages){
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
		// 高度 
//	    System.out.println(fm.getHeight());
	    // 单个字符宽度 
//	    System.out.println(fm.charWidth('A'));
	    // 整个字符串的宽度 
	    System.out.println("width：" + fm.stringWidth(messages));
	    return fm.stringWidth(messages);
	}
}
