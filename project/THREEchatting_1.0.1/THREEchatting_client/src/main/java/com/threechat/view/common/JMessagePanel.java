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
		
		int rowNum = MessageUtil.getRowNum(font, message);
		int height = MessageUtil.getWordHeight(font, message);
		height = rowNum < 2 ? 50 : (rowNum - 1) * height + 50;
		int width = MessageUtil.getMessageWidth(font, message); // 气泡及文本宽度，根据消息参数判断
		if (isMe) {
			jHeadImage = new JHeadImage(headImage, 5, 5, 50, 50);
			//jBubble = new JBubble(0, 0, width, rowNum * 30, font, MessageUtil.getMessageLineList(font, message));
			jBubble = new JBubble(60, 0, width + 20, height, font, message, true);
		} else {
			jHeadImage = new JHeadImage(headImage, 550 - 55 - 15, 5, 50, 50); // 550：聊天信息面板宽度， 55： 头像及 头像右边距，15：聊天信息面板滚动条宽度
			jBubble = new JBubble(550 - 15 - (width + 20) - 60, 0, width + 20, height, font, message, false);
		}
		
		this.isMe = isMe;
		this.message = message;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(480, height + 5)); // + 5 增加下边距
		this.add(jHeadImage);
		this.add(jBubble);
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
