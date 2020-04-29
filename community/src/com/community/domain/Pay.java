package com.community.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Pay {

	private String pid;
	private int type;
	@JSONField(format="yyyy-MM-dd")
	private Date commitDate;
	private int money;
	@JSONField(format="yyyy-MM-dd")
	private Date startDate;
	@JSONField(format="yyyy-MM-dd")
	private Date endDate;
	private String detail;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCommitDate() {
		return commitDate;
	}
	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Pay [pid=" + pid + ", type=" + type + ", commitDate=" + commitDate + ", money=" + money + ", startDate="
				+ startDate + ", endDate=" + endDate + ", detail=" + detail + "]";
	}
}
