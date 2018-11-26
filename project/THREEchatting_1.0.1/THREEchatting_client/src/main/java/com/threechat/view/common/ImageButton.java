package com.threechat.view.common;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton{

	/**
	 *  按钮的背景图片
	 */
	private ImageIcon icon;
	public static void main(String[] args) {

	}
	public ImageButton() {
		
	}
	
	public ImageButton(String imageUrl, int button_width, int button_height) {
		if (imageUrl == null || "".equals(imageUrl)) {
			icon = new ImageIcon("resources/images/default_head.jpg");
		}else {
			icon = new ImageIcon(imageUrl);
		}
		icon.setImage(icon.getImage().getScaledInstance(button_width, button_height,Image.SCALE_DEFAULT));
	
		this.setIcon(icon);
		this.setSize(button_width, button_height);
		this.setBorder(null);
		this.setFocusPainted(false);
	}
}
