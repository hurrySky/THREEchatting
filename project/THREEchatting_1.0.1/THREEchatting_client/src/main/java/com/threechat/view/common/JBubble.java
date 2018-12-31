package com.threechat.view.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

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
	private Font font;
	private List<String> messageList;
	private String message;
	private JTextPane messageTextArea;
	private Color BUBBLE_COLOR = new Color(152, 225, 100);
	public JBubble() {
	}
	/**
	 * 构造方法
	 * @param bubble_width 气泡宽度
	 * @param bubble_height 气泡高度
	 * @param Str 文本
	 * @param img 头像
	 */
	public JBubble(int x, int y, int bubble_width, int bubble_height, Font font, List<String> messageList) {
		
		this.x = x;
		this.y = y;
		this.bubble_width = bubble_width;
		this.bubble_height = bubble_height;
		this.font = font;
		this.messageList = messageList;
		this.setBounds(60, 10, bubble_width + 20 + TRIANGLE_WIDTH, bubble_height);
	}

	/**
	 * 构造方法
	 * @param bubble_width 气泡宽度
	 * @param bubble_height 气泡高度
	 * @param Str 文本
	 * @param img 头像
	 */
	public JBubble(int x, int y, int bubble_width, int bubble_height, Font font, String message) {
		
		this.x = x;
		this.y = y;
		this.bubble_width = bubble_width;
		this.bubble_height = bubble_height;
		this.font = font;
		this.message = message;
		this.setBounds(60, 10, bubble_width + TRIANGLE_WIDTH + 10, bubble_height - 10); // 下偏移 10
		messageTextArea = new JTextPane();
		messageTextArea.setBounds(TRIANGLE_WIDTH + 5, 0, bubble_width, bubble_height - 10); // +5 messageTextArea 向右偏移5，使父控件圆角可以显示
		messageTextArea.setFont(font);
		messageTextArea.setBackground(BUBBLE_COLOR);
		messageTextArea.setText(message);
		messageTextArea.setSize(bubble_width, bubble_height - 10);
		messageTextArea.setEditable(false);
		this.add(messageTextArea);
		//this.setForeground(new Color(152, 225, 100));
	}
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(BUBBLE_COLOR);
		Polygon filledPolygon=new Polygon();
		filledPolygon.addPoint(x, 20);
		filledPolygon.addPoint(x + TRIANGLE_WIDTH, 20 - (TRIANGLE_HEIGHT / 2));
		filledPolygon.addPoint(x + TRIANGLE_WIDTH, 20 + (TRIANGLE_HEIGHT / 2));
		//g.drawPolygon(filledPolygon);
		g.fillPolygon(filledPolygon);
		g.fillRoundRect(x + TRIANGLE_WIDTH, y, bubble_width + 10, bubble_height - 10, 10, 10);
    	
    	// 文字采用 JTextPane 控件呈现，所以不采用绘制文本信息。以下代码将不会执行
		g.setColor(Color.black);
    	g.setFont(font);
    	if (messageList != null && messageList.size() > 0) {
    		for (int i = 0; i < messageList.size(); i++) {
        		g.drawString(messageList.get(i), 10 + TRIANGLE_WIDTH, (i + 1) *25); // 文字横坐标要加上三角形宽度
    		}
		}
    }
}
