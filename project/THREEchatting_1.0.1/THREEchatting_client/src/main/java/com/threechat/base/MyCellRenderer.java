package com.threechat.base;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyCellRenderer extends JLabel implements ListCellRenderer {

//	private boolean m_selected = false;
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		if(value instanceof ContactsItemData){  
			ContactsItemData data = (ContactsItemData)value;  
            setIcon(data.getImage());  
            setText(data.getName());
        }else{  
            setIcon(null);  
            setText("");  
        }  
        setBackground(Color.WHITE);  
    //    m_selected = isSelected;  
        if(isSelected){  
        	setBackground(list.getSelectionBackground());
        	setForeground(list.getSelectionForeground());  
        }else{
        	 setBackground(list.getBackground()); 
        	 setForeground(list.getForeground()); 
        }
      //  this.setBounds(0, 0, 250, 60);
        return this;  
	}

}
