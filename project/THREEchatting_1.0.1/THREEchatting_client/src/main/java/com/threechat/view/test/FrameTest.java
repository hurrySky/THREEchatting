package com.threechat.view.test;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.threechat.view.common.JBubbleMessage;
import com.threechat.view.common.JHeadImage;

public class FrameTest extends JFrame implements MouseListener{

	JPanel jPanel;
	JHeadImage jHeadImage;
	JBubbleMessage jbubbleComponent;
	public static void main(String[] args) {
		FrameTest frameTest = new FrameTest();
	}
	public FrameTest(){
		jPanel = new JPanel();
		jPanel.setLayout(null);
		jPanel.setBounds(0, 0, 400, 400);
		//jPanel.setBackground(Color.red);
		Image headImage = Toolkit.getDefaultToolkit().getImage("resources/images/default_head2.jpg");
		jHeadImage = new JHeadImage(headImage, 0, 0, 50, 50);
		jHeadImage.addMouseListener(this);
		
		jbubbleComponent = new JBubbleMessage();
		jbubbleComponent.setBounds(0, 200, 400, 200);
		jbubbleComponent.setBackground(Color.green);
		
		jPanel.add(jHeadImage);
		jPanel.add(jbubbleComponent);
		
		this.setLayout(null);
		this.add(jPanel);
		this.setLocation(50, 50);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == jHeadImage) {
			System.out.println("我已经被触发监听了");
		}
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
