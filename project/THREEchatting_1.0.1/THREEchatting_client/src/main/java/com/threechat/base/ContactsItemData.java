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
    /**
     *  个性签名/座右铭
     */
    private String motto;
    
    /**
     * 无参构造方法
     */
    @SuppressWarnings("unused")
	private ContactsItemData(){
    	
    }
    
    /**
     * 构造方法
     * @param name 用户名
     * @param image 头像
     * @param motto 个性签名/座右铭
     */
    public ContactsItemData(String name, Icon image, String motto){
    	this.name = name;
    	this.image = image;
    	if (motto.length() > 20) {
			this.motto = motto.substring(0, 20) + "...";
		}else {
			this.motto = motto;
		}
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

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}
}
