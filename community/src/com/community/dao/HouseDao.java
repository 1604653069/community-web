package com.community.dao;

import java.util.List;

import com.community.domain.House;

public interface HouseDao {
	
	//获取所有的房屋信息
	public List<House> getAllHouseInfo();

	public House getHouseByHid(String hid);
	
	//添加房屋消息
	public void addHouse(House house);
	
	public void updateHouse(House house);
	
	public void removeHouse(House house);
	
	public List<House> getHouseBySort(String hql);
}
