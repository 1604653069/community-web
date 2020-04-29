package com.community.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/*发表说说的实体*/
public class SS {
	/* 说说表的主键 */
	private String sid;
	/* 说说的内容 */
	private String ssContent;
	/* 说说发表的图片 */
	private Set<SSImg> ssImgs = new HashSet<SSImg>();
	/* 发表说说的时间 */
	@JSONField (format="yyyy-MM-dd HH:mm:SS")  
	private Date time;
	/* 发表说说的用户 */
	private User user;
	public SS() {
		super();
	}
	public SS(String sid, String ssContent, Set<SSImg> ssImgs, Date time, User user) {
		super();
		this.sid = sid;
		this.ssContent = ssContent;
		this.ssImgs = ssImgs;
		this.time = time;
		this.user = user;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSsContent() {
		return ssContent;
	}
	public void setSsContent(String ssContent) {
		this.ssContent = ssContent;
	}
	public Set<SSImg> getSsImgs() {
		return ssImgs;
	}
	public void setSsImgs(Set<SSImg> ssImgs) {
		this.ssImgs = ssImgs;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "SS [sid=" + sid + ", ssContent=" + ssContent + ", ssImgs=" + ssImgs + ", time=" + time + ", user="
				+ user + "]";
	}
}
