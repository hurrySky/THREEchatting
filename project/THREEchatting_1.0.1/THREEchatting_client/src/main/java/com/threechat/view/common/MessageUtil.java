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
	private static final int WIDTH = 340; // 最大像素宽(此值最好是由参数传入，暂以常量表示)
	
	public static void main(String[] args) {
		Font font = new Font("宋体",Font.BOLD,10);
		String messages = "a";
		String messages2 = "1";
		String messages3 = "一";
//		System.out.println(messages.getBytes().toString());
//		System.out.println(messages2.getBytes().toString());
//		System.out.println(messages3.getBytes().toString());
//		System.out.println(messages.getBytes().length);
//		System.out.println(messages2.getBytes().length);
//		System.out.println(messages3.getBytes().length);
//		System.out.println(System.getProperty("file.encoding"));
		
		System.out.println(getMessageWidth(font, messages));
//		System.out.println(getMessageWidth(font, messages2));
		System.out.println(getMessageWidth(font, messages3));
//		System.out.println(getMessageWidth(font, messages4));
		
//		getWordHeight(font,messages);
//		getStrLenByWidth(font, WIDTH);
		
		getMessageLineList(font, "是的发生的发士大夫撒是\r\n打发士大夫阿萨德发撒地方撒的发生阿斯顿发送aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	/**
	 *  获得给定字体,字符串的高度
	 * @param font 字体
	 * @param messages 要计算的字符串
	 * @return 高度
	 */
	protected static int getWordHeight(Font font, String messages){
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
		int height = fm.getHeight();	// 高度 
	    // 单个字符宽度
//	    System.out.println(fm.charWidth('A'));
	    // 整个字符串的宽度 
//	    System.out.println(fm.stringWidth("A"));
	    return fm.getHeight();
	}
	/**
	 * 获得给定字体,字符串的宽度
	 * @param font 字体
	 * @param str 要计算的字符串
	 * @return 宽度
	 */
	private static int getWordWidth(Font font, String str) {
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
		return fm.stringWidth(str);
	}
	
	/**
	 * 获得给定字体,字符的宽度
	 * @param font 字体
	 * @param c 要计算的字符
	 * @return
	 */
	private static int getWordWidth(Font font, char c) {
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
		return fm.charWidth(c);
	}

	/**
	 * 获得某字体，某消息所占页面宽度
	 * @param font 字体
	 * @param messages 字符串消息
	 * @return 某消息所占页面宽度
	 */
	public static int getMessageWidth(Font font, String messages){
		@SuppressWarnings("restriction")
		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
	    String[] messagesArr = messages.split("\\r\\n");
	    int length = messagesArr.length;
	    String maxLen = "";
	    List<String> list = Arrays.asList(messagesArr); // 转 messagesArr 数组为集合
	    // 构建字符串长度比较类
	    List<CompareMaxString> listCompare = sortStrListByLength(list);
	    // System.out.println(listCompare);
	    // 获得最长字符串
	    maxLen = listCompare.get(listCompare.size()-1) == null ? "" : listCompare.get(listCompare.size()-1).getSingleLineMessage();
	    // 如果最长的行宽度大于350，则气泡宽度为350，若小于350则为实际宽度
	    if (fm.stringWidth(maxLen) > WIDTH) {
	    	return WIDTH;
		}else {
			return fm.stringWidth(maxLen);
		}
	}
	
	/**
	 * 获得消息行数
	 * @param font 字体
	 * @param messages 字符串消息
	 * @return 总行数
	 */
//	@Deprecated
//	public static int getRowNum(Font font, String messages) {
//		int rowLength = 0;
//		// 最大字符串长度
//		int len = getStrLenByWidth(font, WIDTH);
//		String[] messagesArr = messages.split("\\r\\n");
//		// 转数组为list 集合
//		List<String> list = Arrays.asList(messagesArr);
//		int length = list.size();
//		int count = 0;
//		for (String list_ : list) {
//			int size = list_.length();
//			if (size > len) {
//				int line_temp = size % len == 0 ? (size / len) : (size / len) + 1;
//				count = count + line_temp;
//			} else {
//				count = count + 1;
//			}
//		}
//	    System.out.println("总行数 " + count);
//	    return count;
//	}
	
	/**
	 *  获得消息集合
	 * @param font 字体
	 * @param messages 字符串消息
	 * @return
	 */
//	@Deprecated
//	private static List<String> getMessageLineListByCharMessage(Font font, String messages) {
//		String[] messagesArr = messages.split("\\r\\n");
//		int len = getStrLenByWidth(font, WIDTH);
//	    String maxLen = "";
//	    List<String> list = Arrays.asList(messagesArr);
//		int length = list.size();
//		ArrayList<String> resList = new ArrayList<String>();
//		int count = 0;
//		for (String str : list) {
//			int size = str.length();
//			if (size > len) {
//				int line_temp = size % len == 0 ? (size / len) : (size / len) + 1;
//				count = count + line_temp;
//				for (int i = 0; i < count; i++) {
//					if (i == count - 1) {
//						resList.add(str.substring(i * len, str.length()));
//					}else {
//						resList.add(str.substring(i * len, (i + 1) * len));
//					}
//				}
//			} else {
//				resList.add(str);
//			}
//		}
//		return resList;
//	}
	
	/**
	 *  得到指定像素宽度下，多长字符串能够占满
	 *  (采用编码为 utf-8，字符占一个字节，汉字占三个字节,单元汉字所占像素大于单元字符所占像素，此方法只适用于纯字符)
	 * @param font
	 * @param size
	 * @return
	 */
//	@Deprecated
//	private static int getStrLenByWidth(Font font, int size) {
//		@SuppressWarnings("restriction")
//		FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
//		String str = "AAAAAAAAAAA";
//		int s = fm.stringWidth(str);
//		while (s < size) {
//			str = str + "A";
//			s = fm.stringWidth(str);
//		}
//		return str.length();
//	}
	
	/**
	 * 获得消息行集合
	 * @param font 字体
	 * @param messages 要组装字符串
	 * @return 消息行集合
	 */
	public static List<String> getMessageLineList(Font font, String messages) {
		List<String> result = new ArrayList<String>();
		String[] messagesArr = messages.split("\\r\\n");
		for (int i = 0; i < messagesArr.length; i++) {
			if (getWordWidth(font, messagesArr[i]) >= WIDTH) {
				String tempStr = messagesArr[i];
				char[] charArr = tempStr.toCharArray();
				//String s = String.valueOf(charArr[0]);
				String s = "";
				//int len = getWordWidth(font, s);
				for (int j = 0; j < charArr.length; j++) {
					int len = getWordWidth(font, s);
					if (len < WIDTH) {
						s = s + String.valueOf(charArr[j]);
						if (j == charArr.length - 1) {
							result.add(s);
						}
					} else {
						result.add(s);
						s = String.valueOf(charArr[j]);
					}
				}
			}else {
				result.add(messagesArr[i]);
			}
		}
		//String[] resultArr = (String[]) result.toArray(new String[0]);
		return result;
	}
	
	/**
	 * 获得消息行数
	 * @param font 字体
	 * @param messages 字符串消息
	 * @return 总行数
	 */
	public static int getRowNum(Font font, String messages) {
		List<String> list = getMessageLineList(font, messages);
		int count = list.size();
		return count;
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
//	    		if (c1.getSingleLineLength() != c2.getSingleLineLength()) {
//	    			return c1.getSingleLineLength() - c2.getSingleLineLength();
//				}
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