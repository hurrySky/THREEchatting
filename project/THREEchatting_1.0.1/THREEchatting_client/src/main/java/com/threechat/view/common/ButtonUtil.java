package com.threechat.view.common;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonUtil extends JButton{
	
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
	 * @return
	 */
	public static JButton getExitButton(Color backgroundColor, Color fontColor){
		button = new JButton("X"); // 设置按钮文本为 X
		button.setForeground(fontColor); // 设置文字颜色为白色
		button.setFocusPainted(false); // 不绘制文字周围的边框
		button.setSize(20, 20);
		button.setBorder(null);
		button.setBackground(backgroundColor);
		return button;
	}
	
	/**
	 * 获得最小化按钮
	 * @return
	 */
	public static JButton getMinButton(Color backgroundColor, Color fontColor){
		button = new JButton("一"); // 设置按钮文本为 X
		button.setForeground(fontColor); // 设置文字颜色为白色
		button.setFocusPainted(false); // 不绘制文字周围的边框
		button.setSize(20, 20);
		button.setBorder(null);
		button.setBackground(backgroundColor);
		return button;
	}
}
