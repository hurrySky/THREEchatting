package com.threechat.view.common;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 按钮工具类
 * @author lixin
 */
public class ButtonUtil extends JButton{

	private static final long serialVersionUID = 1L;
	/**
	 * 私有Jbutton 属性
	 */
	private static JButton button;
	
	/**
	 *  获得图片背景的 按钮
	 * @param imageUrl 图片地址
	 * @param button_width 按钮宽度
	 * @param button_height 按钮高度
	 * @return button
	 */
	public static JButton getImageButton(String imageUrl, int button_width, int button_height) {
		Icon icon;
		if (imageUrl == null || "".equals(imageUrl)) {
			icon = new ImageIcon("resource/images/default_head.jpg");
		}else {
			icon = new ImageIcon(imageUrl);
		}
		button = new JButton();
		button.setIcon(icon);
		button.setSize(button_width, button_height);
		button.setBorder(null);
		button.setFocusPainted(false);
		return button;
	}
	/**
	 * 获得退出按钮
	 * @param backgroundColor 背景颜色
	 * @param fontColor 字体颜色
	 * @return JButton
	 */
	public static JButton getExitButton(Color backgroundColor, Color fontColor){
		button = new JButton("X"); // 设置按钮文本为 X
		button.setForeground(fontColor); // 设置文字颜色
		if (fontColor != null) {
			button.setForeground(fontColor); // 设置文字颜色
		}else {
			button.setForeground(Color.BLACK); // 设置文字颜色
		}
		button.setFocusPainted(false); // 不绘制文字周围的边框
		button.setSize(20, 20);
		button.setBorder(null);
		if (backgroundColor != null) {
			button.setBackground(backgroundColor);
		}else {
			button.setBackground(new Color(245,245,245));
		}
		return button;
	}
	
	/**
	 * 获得最小化按钮
	 * @param backgroundColor 背景颜色
	 * @param fontColor 字体颜色
	 * @return JButton
	 */
	public static JButton getMinButton(Color backgroundColor, Color fontColor){
		button = new JButton("一"); // 设置按钮文本为 X
		if (fontColor != null) {
			button.setForeground(fontColor); // 设置文字颜色
		}else {
			button.setForeground(Color.BLACK); // 设置文字颜色
		}
		button.setFocusPainted(false); // 不绘制文字周围的边框
		button.setSize(20, 20);
		button.setBorder(null);
		if (backgroundColor != null) {
			button.setBackground(backgroundColor);
		}else {
			button.setBackground(new Color(245,245,245));
		}
		return button;
	}
	/**
	 * 获得自定义大小，指定背景颜色的按钮
	 * @param buttonText 按钮文字
	 * @param button_width 按钮宽度
	 * @param button_height 按钮高度
	 * @param backgroundColor 背景颜色
	 * @param fontColor 字体颜色
	 * @return JButton
	 */
	public static JButton getCustomButton(String buttonText, int button_width, int button_height, Color backgroundColor,Color fontColor) {
		button = new JButton();
		if (buttonText != null) {
			button.setText(buttonText);
		}
		if (backgroundColor != null ) {
			button.setBackground(backgroundColor);
		}
		button.setSize(button_width, button_height);
		button.setFocusPainted(false); // 不绘制文字周围的边框
		return button;
	}
}
