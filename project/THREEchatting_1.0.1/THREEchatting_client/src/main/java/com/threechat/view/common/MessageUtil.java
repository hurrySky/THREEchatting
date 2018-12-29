package com.threechat.view.common;

import java.awt.Font;
import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 发送消息工具类
 * 获得某字体文本的实际像素宽和像素高
 * @author lixin
 *
 */
public class MessageUtil {

	public static void main(String[] args) {
		Font font = new Font("宋体",Font.BOLD,10);
//		String messages = "你好吗";
//		getWordHeight(font,messages);
		getStrLenByWidth(font, 350);
	}
	
	public static int  getWordHeight(Font font, String messages){
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
		// 高度 
//	    System.out.println("height： " + fm.getHeight());
	    // 单个字符宽度
//	    System.out.println(fm.charWidth('A'));
	    // 整个字符串的宽度 
//	    System.out.println(fm.stringWidth("A"));
	    return fm.getHeight();
	}
	

	/**
	 * 获得某字体，某消息所占页面宽度
	 * @param font 字体
	 * @param messages 字符串消息
	 * @return 某消息所占页面宽度
	 */
	public static int getWordWidth(Font font, String messages){
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
		// 高度 
//	    System.out.println(fm.getHeight());
	    // 单个字符宽度 
//	    System.out.println(fm.charWidth('A'));
	    // 整个字符串的宽度 
		
	    System.out.println("width：" + fm.stringWidth(messages));
	    String[] messagesArr = messages.split("\\r\\n");
	    int length = messagesArr.length;
	    String maxLen = "";
	    // 转 messagesArr 数组为集合
	    List<String> list = Arrays.asList(messagesArr);
	    // 构建字符串长度比较类
	    List<CompareMaxString> listCompare = sortStrListByLength(list);
	    System.out.println(listCompare);
	    // 获得最长字符串
	    maxLen = listCompare.get(listCompare.size()-1) == null ? "" : listCompare.get(listCompare.size()-1).getSingleLineMessage();

	    System.out.println(maxLen);
	    if (fm.stringWidth(maxLen) > 350) {
	    	return 350;
		}else {
			return fm.stringWidth(maxLen);
		}
	}
	
	/**
	 * 
	 * @param font 字体
	 * @param messages 字符串消息
	 * @return 总行数
	 */
	public int getRowNum(Font font, String messages) {
		int rowLength = 0;
		// 最大字符串长度
		int len = getStrLenByWidth(font, 350);
		String[] messagesArr = messages.split("\\r\\n");
		// 转数组为list 集合
		List<String> list = Arrays.asList(messagesArr);
		int length = list.size();
		int count = 0;
		for (String list_ : list) {
			int size = list_.length();
			if (size > len) {
				int line_temp = size % len == 0 ? (size / len) : (size / len) + 1;
				count = count + line_temp;
			} else {
				count = count + 1;
			}
		}
	    System.out.println("总行数 " + count);
	    return count;
	}
	
	/**
	 *  获得消息数组
	 * @param messages
	 * @return
	 */
	public static String[] getMessageLineArr(String messages) {
		String[] messagesArr = messages.split("\\r\\n");
		int length = messagesArr.length;
	    String maxLen = "";
	    for (int i = 0; i < length-1; i++) {
			if (length == 1) {
				maxLen = messagesArr[0];
				break;
			}else if (messagesArr[i].length() >= messagesArr[i+1].length()) {
				maxLen = messagesArr[i];
			}else {
				maxLen = messagesArr[i+1];
			}
		}
		return messagesArr;
	}
	
	private static int getStrLenByWidth(Font font, int size) {
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
		String str = "AAAAAAAAAAA";
		int s = fm.stringWidth(str);
		while (s < size) {
			str = str + "A";
			s = fm.stringWidth(str);
		}
		//System.out.println(s);
		//System.out.println(str);
		return str.length();
	}
	
	/**
	 * 按集合字符串元素长度排序
	 * @param list 要排序的字符串集合
	 * @return 排序后的字符串集合
	 */
	private static List<CompareMaxString> sortStrListByLength(List<String> list) {
		// 构建字符串长度比较类
	    List<CompareMaxString> listCompare = new ArrayList<CompareMaxString>();
	    CompareMaxString compareMaxString = null;
	    for (String str : list) {
	    	compareMaxString = new CompareMaxString(str, str.length());
	    	listCompare.add(compareMaxString);
		}
	    // 排序取最大
	    Collections.sort(listCompare, new Comparator<CompareMaxString>() {
	    	@Override
	    	public int compare(CompareMaxString c1, CompareMaxString c2) {
	    		return c1.getSingleLineLength() - c2.getSingleLineLength();
	    	}
	    });
	    return listCompare;
	}
}

/**
 * 字符串长度比较类
 * @author Lixin
 */
class CompareMaxString{
	private String singleLineMessage;
	private int singleLineLength;
	/**
	 *  字符串长度比较类构造方法
	 * @param singleLineMessage
	 * @param singleLineLength
	 */
	public CompareMaxString(String singleLineMessage, int singleLineLength) {
		this.singleLineMessage = singleLineMessage;
		this.setSingleLineLength(singleLineLength);
	}
	
	public String getSingleLineMessage() {
		return singleLineMessage;
	}
	public void setSingleLineMessage(String singleLineMessage) {
		this.singleLineMessage = singleLineMessage;
	}
	
	public int getSingleLineLength() {
		return singleLineLength;
	}
	public void setSingleLineLength(int singleLineLength) {
		this.singleLineLength = singleLineLength;
	}
	
	@Override
	public String toString() {
		return "CompareMaxString [singleLineMessage=" + singleLineMessage
				+ ", singleLineLength=" + singleLineLength + "]";
	}
	
}