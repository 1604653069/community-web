package com.community.domain;

import com.alibaba.fastjson.annotation.JSONField;

//用户余额
public class Wallet {

	public String wid;
	private int money;
	@JSONField(serialize = false)
	private User user;
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
