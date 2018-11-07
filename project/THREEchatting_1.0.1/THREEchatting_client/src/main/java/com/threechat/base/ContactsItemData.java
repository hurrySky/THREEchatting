package com.threechat.base;

import javax.swing.Icon;

/**
 * 联系人or历史对话人 数据模型
 * @author lixin
 */
public class ContactsItemData {
	
	
	/**
	 * 联系人名称
	 */
	private String name;
	/**
	 * 联系人头像
	 */
    private Icon image;
    
    private ContactsItemData(){
    	
    }
    
    public ContactsItemData(String name, Icon image){
    	this.name = name;
    	this.image = image;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Icon getImage() {
		return image;
	}
	public void setImage(Icon image) {
		this.image = image;
	}
}
