package com.community.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class History {

	private String hid;
	//充值后还剩的余额
	private int balance;
	//充值的时间
	@JSONField(format="yyyy-MM-dd")
	private Date time;	
	//充值的金额
	private int money;
	//绑定哪个用户的
	@JSONField(serialize = false)
	private User user;
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
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
	@Override
	public String toString() {
		return "History [hid=" + hid + ", balance=" + balance + ", time=" + time + ", money=" + money + "]";
	}
}
