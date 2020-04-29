package com.community.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class PayItem {

	private String iid;
	private Date date;
	@JSONField(serialize=false)
	private User user;
	private int money;
	@JSONField(serialize=false)
	private Pay pay;
	//缴费的状态，0未交费 1缴费
	private int state;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "PayItem [iid=" + iid + ", date=" + date + ", user=" + user + ", money=" + money + ", pay=" + pay
				+ ", state=" + state + "]";
	}
}
