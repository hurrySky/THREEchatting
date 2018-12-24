package com.threechat.view.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * 头像组件
 * @author lixin
 *
 */
public class JHeadImage extends JComponent{
	
	private static final long serialVersionUID = 1L;
	private static Image headImage;
	private int head_image_w;
	private int head_image_h;
	
	private JHeadImage() {
	}
	
//	static {
//		//headImage = Toolkit.getDefaultToolkit().getImage("resources/images/default_head.jpg");
//		JHeadImage.initHeadImage("resources/images/default_head.jpg", headImage);
//	}
	
//	static void initHeadImage(String imgSrc, Image headImage) {
//		if (!"".equals(imgSrc) && imgSrc != null) {
//			headImage = Toolkit.getDefaultToolkit().getImage(imgSrc);
//		}else if(headImage != null){
//			JHeadImage.headImage = headImage;
//		}
//		
//	}
	
	
	public JHeadImage(Image headImage,int x, int y, int head_image_w, int head_image_h) {
		if (headImage==null) {
			this.headImage = Toolkit.getDefaultToolkit().getImage("resources/images/default_head.jpg");
			//this.headImage = new ImageIcon("resources/images/default_head.jpg").getImage();
		}else {
			this.headImage = headImage;
		}
		this.head_image_w = head_image_w;
		this.head_image_h = head_image_h;
		this.setBounds(x, y, this.head_image_w, this.head_image_h);
		this.setVisible(true);
	}
	
	public JHeadImage(String imageSrc) {
		if (!"".equals(imageSrc) && imageSrc != null) {
			headImage = Toolkit.getDefaultToolkit().getImage(imageSrc);
		} else {
			this.headImage = null;
		}
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(headImage, 0, 0, this);
    }
}
