package com.threechat.view.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		
		//int height = MessageUtil.getWordHeight(font, message);
		// height = height < 50 ? 60 : height;
		int width = MessageUtil.getWordWidth(font, message);
		int rowNum = MessageUtil.getWordHeight(font, message);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(480, 40 * rowNum + 15));
		//this.setPreferredSize(new Dimension(480, 95));
		
		jHeadImage = new JHeadImage(headImage, 5, 5, 50, 50);
		jBubble = new JBubble( 0, 0, width, 40, message);
		
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
