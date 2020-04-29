package com.community.domain;

import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

//用户的收藏实体
public class Favorite {
	//主键
	private String fid;
	@JSONField(serialize =false)
	private User user;
	private Set<FavoriteItem> favorites;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<FavoriteItem> getFavorites() {
		return favorites;
	}
	public void setFavorites(Set<FavoriteItem> favorites) {
		this.favorites = favorites;
	}
	@Override
	public String toString() {
		return "Favorite [fid=" + fid + ", user=" + user + ", favorites=" + favorites + "]";
	}
}
