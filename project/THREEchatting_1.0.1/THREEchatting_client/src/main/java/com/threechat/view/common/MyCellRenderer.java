package com.threechat.view.common;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.ComponentUI;

import com.threechat.base.ContactsItemData;

public class MyCellRenderer extends JButton implements ListCellRenderer<Object> {

//	private boolean m_selected = false;
	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		
		setLayout(null);
		if(value instanceof ContactsItemData){
			ContactsItemData data = (ContactsItemData)value;
		//	setUI(new MyButtonUi());
			setIconTextGap(30);
			setHorizontalAlignment(SwingConstants.LEFT);
            setIcon(data.getImage());
            setBorder(new RoundBorder());
            setText("<html>" + data.getName() +"<br>&nbsp;&nbsp;<html/>");
           
		}else{  
            setIcon(null);  
            setText("");  
        }  

        if(isSelected){  
        	setBackground(list.getSelectionBackground());
        	setForeground(list.getSelectionForeground());  
        }else{
        	 setBackground(list.getBackground()); 
        	 setForeground(list.getForeground()); 
        }
        return this;  
	}

	class RoundBorder implements Border {
		 
		 public Insets getBorderInsets(Component c) {
		  return new Insets(0,0,0,0);
		 }
		 public boolean isBorderOpaque() {
		  return false;
		 }
		 @Override
		 public void paintBorder(Component c, Graphics g, int x, int y,
		   int width, int height) {
		  //使用黑色在组件的外边缘绘制一个圆角矩形
		  g.setColor(new Color(219, 217, 216));
		  g.drawRoundRect(0, 0, c.getWidth()-0, c.getHeight()-0, 5, 5);
		 }
		}
	
//	class MyButtonUi extends ComponentUI {
//		
//		 
//		public void paint(Graphics g, JComponent c) {
//			super.paint(g, c);
//			
//			System.out.println("33");
//		}
//	}
}
