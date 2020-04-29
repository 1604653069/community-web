package com.community.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class HouseImg {
	private String iid;
	private String path;
	@JSONField(serialize=false)
	private House house;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "HouseImg [iid=" + iid + ", path=" + path + ", house=" + house + "]";
	}

}
