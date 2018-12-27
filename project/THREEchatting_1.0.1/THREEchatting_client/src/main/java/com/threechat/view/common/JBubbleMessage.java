package com.threechat.view.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

/**
 * 自定义 气泡组件
 * @author lixin
 *
 */
public class JBubbleMessage extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private Image headImage;
	private int x;
	private int y;
	private int bubble_width;
	private int bubble_height;
	private String message;
	
	public JBubbleMessage() {
	}
	/**
	 * 构造方法
	 * @param bubble_width 气泡宽度
	 * @param bubble_height 气泡高度
	 * @param Str 文本
	 * @param img 头像
	 */
	public JBubbleMessage(Image headImage, int x, int y, int bubble_width, int bubble_height, String message) {
		if (headImage==null) {
			this.headImage = Toolkit.getDefaultToolkit().getImage("resources/images/default_head2.jpg");
			//this.headImage = new ImageIcon("resources/images/default_head.jpg").getImage();
		}else {
			this.headImage = headImage;
		}
		
		this.x = x;
		this.y = y;
		this.bubble_width = bubble_width;
		this.bubble_height = bubble_height;
		this.message = message;
		//this.setBounds(x, y, 50, 50);
	}

	@Override
    protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
		//g.drawImage(headImage, 0, 0, this);
		//g.drawImage(this.headImage, 0, 0, 50, 50, Color.black, this);
		g.setColor(new Color(152, 225, 100));

    	g.fillRoundRect(55, y, bubble_width, bubble_height, 5, 5);
    	g.setColor(Color.black);
    	g.drawString(message, 55, 25);
    	g.drawString(message, 55, 50);

    }
}
