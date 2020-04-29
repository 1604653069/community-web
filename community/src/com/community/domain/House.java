package com.community.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class House {
	//主键
	private String hid;
	//房屋详细地址
	private String address;
	//房屋详细信息
	private String detailed;
	//房屋发布日期
	@JSONField(format="yyyy-MM-dd")
	private Date date;
	//房屋面积
	private String area;
	//房屋租金
	private int rent;
	//房屋推送的标题
	private String title;
	//房屋类型 0 单间  1 套间
	private int type;
	private Set<HouseImg> houseImgs =new HashSet<HouseImg>();
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailed() {
		return detailed;
	}
	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Set<HouseImg> getHouseImgs() {
		return houseImgs;
	}
	public void setHouseImgs(Set<HouseImg> houseImgs) {
		this.houseImgs = houseImgs;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "House [hid=" + hid + ", address=" + address + ", detailed=" + detailed + ", date=" + date + ", area="
				+ area + ", rent=" + rent + ", title=" + title + ", type=" + type + ", houseImgs=" + houseImgs + "]";
	}
}
