package com.community.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;


/** 报事维修
 * @author Hong
 *
 */
public class Repair {
	//保修的id
	private String rid;
	//保修的日期
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Date datetime;
	//提交保修的用户
	private User user;
	//保修的问题
	private String question;
	//提交问题的状态 0提交为审核 1提交已审核
	private int state;
	//保修完成的时间
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Date doneDate;
	//上传图片的保存的路径
	private Set<RepairPhoto> repairPhotos = new HashSet<RepairPhoto>();
	private String title;
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getDoneDate() {
		return doneDate;
	}
	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}
	public Set<RepairPhoto> getRepairPhotos() {
		return repairPhotos;
	}
	public void setRepairPhotos(Set<RepairPhoto> repairPhotos) {
		this.repairPhotos = repairPhotos;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Repair [rid=" + rid + ", datetime=" + datetime + ", user=" + user + ", question=" + question
				+ ", state=" + state + ", doneDate=" + doneDate + ", repairPhotos=" + repairPhotos + ", title=" + title
				+ "]";
	}
}
