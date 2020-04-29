package com.community.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class Score {

	private String sid;
	private int score;
	@JSONField(serialize = false)
	private User user;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Score [sid=" + sid + ", score=" + score + ", user=" + user + "]";
	}
}
