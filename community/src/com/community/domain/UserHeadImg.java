package com.community.domain;

import com.alibaba.fastjson.annotation.JSONField;

//用户头像
public class UserHeadImg {

	public String hid;
	//用户存储头像的路径
	private String path;
	//绑定头像的用户
	@JSONField(serialize = false)
	public User user;
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
