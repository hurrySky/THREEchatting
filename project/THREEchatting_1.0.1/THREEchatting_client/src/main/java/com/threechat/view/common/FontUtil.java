package com.threechat.view.common;

import java.awt.Font;

/**
 * swing 组件字体工具类
 * @author lixin
 *
 */
public class FontUtil {
	/**
	 * 字体
	 */
	private static Font font;
	public static void main(String[] args) {

	}
	
	/**
	 * 获得普通20号黑体
	 */
	public static Font getBlackBig() {
		font = new Font("黑体", Font.TRUETYPE_FONT, 20);
		return font;
	}
	/**
	 * 获得普通16号黑体
	 */
	public static Font getBlackMiddle() {
		font = new Font("黑体", Font.ROMAN_BASELINE, 16);
		return font;
	}
	/**
	 * 获得普通12号黑体
	 */
	public static Font getBlackSmalll() {
		font = new Font("黑体", Font.TRUETYPE_FONT, 12);
		return font;
	}
	
	/**
	 * 获得普通20号楷体
	 */
	public static Font getKaiTiBig() {
		font = new Font("楷体", Font.TRUETYPE_FONT, 20);
		return font;
	}
	/**
	 * 获得普通16号楷体
	 */
	public static Font getKaiTiMiddle() {
		font = new Font("楷体", Font.TRUETYPE_FONT, 16);
		return font;
	}
	/**
	 * 获得普通12号楷体
	 */
	public static Font getKaiTiSmalll() {
		font = new Font("楷体", Font.TRUETYPE_FONT, 12);
		return font;
	}
	
	/**
	 * 获得普通20号宋体
	 */
	public static Font getSongTiBig() {
		font = new Font("宋体", Font.TRUETYPE_FONT, 20);
		return font;
	}
	/**
	 * 获得普通16号宋体
	 */
	public static Font getSongTiMiddle() {
		font = new Font("宋体", Font.TRUETYPE_FONT, 16);
		return font;
	}
	/**
	 * 获得普通12号宋体
	 */
	public static Font getSongTiSmalll() {
		font = new Font("宋体", Font.TRUETYPE_FONT, 12);
		return font;
	}
}
