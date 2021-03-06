package com.threechat.base.entity;

import java.io.Serializable;

/**
 * 用户表
 * @author lixin
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 用户ID */
    private Integer userId;
    /** 用户号 */
    private String code;
    /** 登录名/账号 */
    private String loginName;
    /** 用户名 */
    private String userName;
    /** 昵称 */
    private String nickName;
    /** 用户邮箱 */
    private String email;
    /** 手机号码 */
    private String phonenumber;
    /** 性别 */
    private Integer sex;
    /** 头像url */
    private String headImgUrl;
    /** 密码 */
    private String password;
    /** 盐加密 */
    private String salt;
    /** 帐号状态:0正常,1禁用 */
    private Integer status;
    /** 登录IP地址 */
    private String loginIp;
    /** 登录时间 */
    private String loginDate;
    /** 签名 */
    private String motto;
    /** 所在地 */
    private String address;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private String createTime;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    private String updateTime;
    /** 备注 */
    private String remark;
	public Integer getUserId() {
		return userId;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", code=" + code + ", loginName="
				+ loginName + ", userName=" + userName + ", nickName="
				+ nickName + ", email=" + email + ", phonenumber="
				+ phonenumber + ", sex=" + sex + ", headImgUrl=" + headImgUrl
				+ ", password=" + password + ", salt=" + salt + ", status="
				+ status + ", loginIp=" + loginIp + ", loginDate=" + loginDate
				+ ", motto=" + motto + ", address=" + address + ", createBy="
				+ createBy + ", createTime=" + createTime + ", updateBy="
				+ updateBy + ", updateTime=" + updateTime + ", remark="
				+ remark + "]";
	}
}
