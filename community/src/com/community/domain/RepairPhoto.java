package com.community.domain;

import com.alibaba.fastjson.annotation.JSONField;

/*报事维修图片信息类*/
public class RepairPhoto {
	//主键
	private String pid;
	//图片上传保存的路径
	private String path;
	//图片所属的报事订单号
	@JSONField(serialize = false)
	private Repair repair;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Repair getRepair() {
		return repair;
	}
	public void setRepair(Repair repair) {
		this.repair = repair;
	}
}
