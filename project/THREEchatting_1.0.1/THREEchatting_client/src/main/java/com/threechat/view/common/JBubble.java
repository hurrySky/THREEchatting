package com.threechat.view.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JComponent;

/**
 * 自定义 气泡组件
 * @author lixin
 *
 */
public class JBubble extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private int x;
	private int y;
	private final int TRIANGLE_WIDTH = 10;
	private final int TRIANGLE_HEIGHT = 15;
	private int bubble_width;
	private int bubble_height;
	private String message;
	
	
	public JBubble() {
	}
	/**
	 * 构造方法
	 * @param bubble_width 气泡宽度
	 * @param bubble_height 气泡高度
	 * @param Str 文本
	 * @param img 头像
	 */
	public JBubble(int x, int y, int bubble_width, int bubble_height, String message) {
		
		this.x = x;
		this.y = y;
		this.bubble_width = bubble_width;
		this.bubble_height = bubble_height;
		this.message = message;
		this.setBounds(60, 10, bubble_width + 20 + TRIANGLE_WIDTH, 80);
	}

	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(152, 225, 100));
		Polygon filledPolygon=new Polygon();
		filledPolygon.addPoint(x, 20);
		filledPolygon.addPoint(x + TRIANGLE_WIDTH, 20 - (TRIANGLE_HEIGHT / 2));
		filledPolygon.addPoint(x + TRIANGLE_WIDTH, 20 + (TRIANGLE_HEIGHT / 2));
		//g.drawPolygon(filledPolygon);
		g.fillPolygon(filledPolygon);
		g.fillRoundRect(x + 10, y, bubble_width + 20, bubble_height, 10, 10);
    	
    	g.setColor(Color.black);
    	g.drawString(message, 10 + TRIANGLE_WIDTH, 25); // 文字横坐标要加上三角形宽度
    	g.drawString(message, 10 + TRIANGLE_WIDTH, 65); // 文字横坐标要加上三角形宽度
    }
}
