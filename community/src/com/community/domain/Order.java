package com.community.domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Order {

	private String oid;
	private User user;
	private int total;
	//0待付款 1.待发货  2待收货 3.已收货
	private int state;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	private Address address;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", user=" + user + ", total=" + total + ", state=" + state + ", orderItems="
				+ orderItems + ", address=" + address + "]";
	}
}
