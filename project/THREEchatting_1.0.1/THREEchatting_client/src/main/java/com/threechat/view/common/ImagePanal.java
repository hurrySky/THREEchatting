package com.threechat.view.common;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanal extends JPanel{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 背景图片
	 */
	private Image img;
	
	/**
	 * 无参构造方法
	 */
	private ImagePanal(){
		
	}
	
	/**
	 * 无参构造方法
	 */
	public ImagePanal(Image img, int width, int height){
		this.img = img;
		this.setSize(width, height);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0,0, this.getWidth(), this.getHeight(),this);
		this.repaint();
	}
}
