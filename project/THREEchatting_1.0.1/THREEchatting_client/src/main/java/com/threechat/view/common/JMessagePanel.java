package com.threechat.view.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

public class JMessagePanel extends JPanel implements MouseListener{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	private JHeadImage jHeadImage;
	private JBubble jBubble;
	private boolean isMe;
	private String message;
	
	public JMessagePanel(Image headImage, boolean isMe, String message, Font font) {
		
		int height = MessageUtil.getWordHeight(font, message);
		int rowNum = MessageUtil.getRowNum(font, message);
		height = rowNum < 2 ? 50 : (rowNum - 1) * height + 50;
		int width = MessageUtil.getMessageWidth(font, message); // 气泡及文本宽度，根据消息参数判断
		this.setLayout(null);
		this.setPreferredSize(new Dimension(480, height + 5)); // + 5 增加下边距
		
		jHeadImage = new JHeadImage(headImage, 5, 5, 50, 50);
		//jBubble = new JBubble(0, 0, width, rowNum * 30, font, MessageUtil.getMessageLineList(font, message));
		jBubble = new JBubble(0, 0, width + 20, height, font, message);
		
		this.add(jHeadImage);
		this.add(jBubble);
		this.isMe = isMe;
		this.message = message;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
