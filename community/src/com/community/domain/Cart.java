package com.community.domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Cart {
	/* 购物车id */
	private String cid;
	/* 加购的用户 */
	@JSONField(serialize = false)
	private User user;
	//购物车中的条目
	private Set<CartItem> items = new HashSet<CartItem>();
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<CartItem> getItems() {
		return items;
	}
	public void setItems(Set<CartItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", user=" + user + "]";
	}
}
