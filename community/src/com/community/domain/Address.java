package com.community.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 地址类
 * @author Hong
 *
 */
public class Address {
	private String aid;
	//收货人名称
	private String name;
	//用户的收货地址
	private String address;
	//是否是默认的收货地址 1.是 0.不是
	private int  statues;
	//收货人的联系电话
	private String phone;
	//地址绑定的用户
	@JSONField(serialize = false)
	private User user;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatues() {
		return statues;
	}
	public void setStatues(int statues) {
		this.statues = statues;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", name=" + name + ", address=" + address + ", statues=" + statues + ", phone="
				+ phone + ", user=" + user + "]";
	}
}
