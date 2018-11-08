package com.threechat.base;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

public class MyCellRenderer extends JButton implements ListCellRenderer<Object> {

//	private boolean m_selected = false;
	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		
		if(value instanceof ContactsItemData){
			ContactsItemData data = (ContactsItemData)value;  
			setIconTextGap(30);
			setHorizontalAlignment(SwingConstants.LEFT);
            setIcon(data.getImage());
            setText("<html>" + data.getName() +"<br>&nbsp;&nbsp;<html/>");
            setBorder(null);
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

}
