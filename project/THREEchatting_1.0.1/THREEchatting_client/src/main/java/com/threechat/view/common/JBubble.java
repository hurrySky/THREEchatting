package com.threechat.view.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

/**
 * 自定义 气泡组件
 * @author lixin
 *
 */
public class JBubble extends JComponent {
	
	private int x;
	private int y;
	private int bubble_width;
	private int bubble_height;
	
	private String str;
	
	public JBubble() {
		
	}
	/**
	 * 构造方法
	 * @param bubble_width 气泡宽度
	 * @param bubble_height 气泡高度
	 * @param Str 文本
	 * @param img 头像
	 */
	public JBubble(int x, int y, int bubble_width, int bubble_height, String str) {
		this.x = x;
		this.y = y;
		this.bubble_width = bubble_width;
		this.bubble_height = bubble_height;
		
		this.str = str;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void paintComponent(Graphics g) {
		
//    	g.fillPolygon(xPoints, yPoints, nPoints);
//    	g.fillRoundRect(x, y, width, height, arcHeight, arcHeight);
//    	g.drawString(str, x, y);
    	g.setColor(new Color(152, 225, 100));
    	g.fillRoundRect(0, 0, 400, 200, 20, 20);
    	g.setColor(Color.blue);
    	g.drawString("hhh", 100, 100);
    }
}
